package modules.loans.app.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import modules.books.domain.models.Book;
import modules.books.domain.models.valueObjects.BookId;
import modules.books.domain.ports.outport.IBookRepositoryOutport;
import modules.loans.domain.exceptions.models.BookLoanNotFoundException;
import modules.loans.domain.models.BookLoan;
import modules.loans.domain.models.valueObjects.BookLoanDates;
import modules.loans.domain.models.valueObjects.BookLoanId;
import modules.loans.domain.models.valueObjects.UserId;
import modules.loans.domain.ports.inport.IBookLoanServiceInport;
import modules.loans.domain.ports.outport.IBookLoanRepositoryOutport;
import modules.loans.domain.services.BookLoanServiceValidator;
import modules.users.domain.models.User;
import modules.users.domain.ports.outport.IUserRepositoryOutpor;

public class BookLoanService extends BookLoanServiceValidator implements IBookLoanServiceInport{
    private final IBookLoanRepositoryOutport loanRepository;
    private final IBookRepositoryOutport bookRepository;
    private final IUserRepositoryOutpor userRepository;

    public BookLoanService(IBookLoanRepositoryOutport loanRepository,IBookRepositoryOutport bookRepository
    ,IUserRepositoryOutpor userRepository){
        this.loanRepository=loanRepository;
        this.bookRepository=bookRepository;
        this.userRepository=userRepository;
    }

    @Override
    public void saveLoan(Byte userId, Byte bookId, String deliveryDateString, String returnDateString) {
        isNotNull(userId, bookId, deliveryDateString, returnDateString);
        LocalDate deliveryDate=dateValidator(deliveryDateString);
        LocalDate returnDate=dateValidator(returnDateString);
        BookLoan bookLoan=new BookLoan(
            new BookId(bookId),
            new UserId(userId),
            new BookLoanDates(deliveryDate),
            new BookLoanDates(returnDate)
        );
        loanRepository.create(bookLoan);
    }

    @Override
    public void modifyLoan(Byte userId, Byte bookId, String deliveryDateString, String returnDateString) {
        boolean loanList=loanRepository.getAll().isEmpty();
        Optional<BookLoan>oldBookLoan=loanRepository.getAll().stream().
            filter(lb->lb.getBookId().getValue().equals(bookId)&&lb.getUserId().getValue().equals(userId)).findFirst();
        UserId oldUserId=oldBookLoan.get().getUserId();
        BookId oldBookId=oldBookLoan.get().getBookId();
        LocalDate deliveryDate=dateValidator(deliveryDateString);
        LocalDate returnDate=dateValidator(returnDateString);
        if (!oldBookLoan.isPresent()) {
            throw new BookLoanNotFoundException("Loan couldn't be found.");
        }
        if (loanList) {
            throw new BookLoanNotFoundException("Loan list is empty.");
        }
        BookLoan modifiedBookLoan=new BookLoan(
            oldBookId,
            oldUserId,
            new BookLoanDates((deliveryDateString.isBlank())?deliveryDate:oldBookLoan.get().getDeliveryDate().getValue()),
            new BookLoanDates((returnDateString.isBlank())?returnDate:oldBookLoan.get().getReturnDate().getValue())
        );
        loanRepository.update(modifiedBookLoan);
    }

    @Override
    public List<BookLoan> getAllLoans() {
        List<BookLoan>bookLoans=loanRepository.getAll();
        if (bookLoans.isEmpty()) {
            throw new BookLoanNotFoundException("Loan list is empty.");
        }
        return bookLoans;
    }

    @Override
    public Optional<BookLoan> getLoan(Byte id) {
        Optional<BookLoan>bookLoan=loanRepository.getById(new BookLoanId(id));
        boolean isEmpty=loanRepository.getAll().isEmpty();
        if (isEmpty) {
            throw new BookLoanNotFoundException("Loan list is empty.");
        }
        return bookLoan;
    }

    @Override
    public void removeLoan(Byte id) {
        Optional<BookLoan>bookLoan=loanRepository.getById(new BookLoanId(id));
        boolean isEmpty=loanRepository.getAll().isEmpty();
        if (isEmpty) {
            throw new BookLoanNotFoundException("Loan list is empty.");
        }
        loanRepository.delete(bookLoan.get().getId());
    }

    @Override
    public List<BookLoan> getAllLoans(String value) {
        List<User>users=userRepository.getAll().stream()
                .filter(user->user.getIc().getValue().equals(value)
                        ||(user.getName().getValue().equalsIgnoreCase(value)
                        ||user.getLastname().getValue().equalsIgnoreCase(value))).toList();
        if (users.isEmpty()){
            System.out.println("\nNo users found with the given "+value+" value.");
        }
        List<Book>books=bookRepository.getAll().stream()
                .filter(book->book.getIsbn().getValue().equals(value)
                        ||book.getTitle().getValue().equalsIgnoreCase(value)
                        ||book.getAuthor().getValue().equalsIgnoreCase(value)).toList();
        if (books.isEmpty()) {
            System.out.println("\nNo books found with the given "+value+" value.");
        }
        List<BookLoan>loans=loanRepository.getAll().stream()
                .filter(loan->users.stream()
                        .anyMatch(user->user.getId().getValue().equals(loan.getUserId().getValue()))
                        ||
                        books.stream()
                        .anyMatch(book->book.getId().getValue().equals(loan.getBookId().getValue()))
                ).toList();
        boolean isEmpty=loanRepository.getAll().isEmpty();
        if (isEmpty) {
            throw new BookLoanNotFoundException("Loan list is empty.");
        }
        if (loans.isEmpty()){
            throw new BookLoanNotFoundException("Loan couldn't be found.");
        }
        return  loans;
    }

    @Override
    public List<BookLoan> getAllLoans(LocalDate value) {
        List<BookLoan>loans=loanRepository.getAll().stream()
                .filter(loan->value.isAfter(loan.getDeliveryDate().getValue())&&
                        value.isBefore(loan.getReturnDate().getValue())).toList();
        boolean isEmpty=loanRepository.getAll().isEmpty();
        if (isEmpty) {
            throw new BookLoanNotFoundException("Loan list is empty.");
        }
        if (loans.isEmpty()){
            throw new BookLoanNotFoundException("Loan couldn't be found.");
        }
        return  loans;
    }

    @Override
    public void removeLoan(String value) {
        boolean isEmpty=loanRepository.getAll().isEmpty();
        if (isEmpty) {
            throw new BookLoanNotFoundException("Loan list is empty.");
        }
        Optional<User>user=userRepository.getAll().stream()
                .filter(u->u.getIc().getValue().equals(value)).findFirst();
        if (user.isEmpty()){
            System.out.println("\nNo user found with the given IC: "+value);
        }
        Optional<Book>book=bookRepository.getAll().stream()
                .filter(b->b.getIsbn().getValue().equals(value)).findFirst();
        if (book.isEmpty()) {
            System.out.println("\nNo book found with the given ISBN: " + value);
        }
        if (user.isEmpty()&&book.isEmpty()){
            throw new BookLoanNotFoundException("No user or book found with the given value: "+value);
        }
        Optional<BookLoan>loan=loanRepository.getAll().stream()
                .filter(l->l.getBookId().getValue().equals(book.get().getId().getValue())
                    ||l.getUserId().getValue().equals(user.get().getId().getValue())).findFirst();
        if (loan.isEmpty()){
            throw new BookLoanNotFoundException("Loan couldn't be found.");
        }
        loanRepository.delete(loan.get().getId());
    }

    @Override
    public Optional<BookLoan> getLoan(String value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLoan'");
    }
}
