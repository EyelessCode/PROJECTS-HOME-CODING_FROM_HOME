package modules.loans.app.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import modules.books.domain.models.Book;
import modules.books.domain.models.valueObjects.BookId;
import modules.books.domain.ports.outport.IBookRepositoryOutport;
import modules.loans.app.services.dtos.BookLoanDTO;
import modules.loans.domain.exceptions.models.BookLoanNotFoundException;
import modules.loans.domain.models.BookLoan;
import modules.loans.domain.models.valueObjects.BookLoanDates;
import modules.loans.domain.models.valueObjects.BookLoanId;
import modules.loans.domain.ports.inport.IBookLoanServiceInport;
import modules.loans.domain.ports.outport.IBookLoanRepositoryOutport;
import modules.loans.domain.services.BookLoanServiceValidator;
import modules.users.domain.models.User;
import modules.users.domain.models.valueObjects.UserId;
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
        if (oldBookLoan.isEmpty()) {
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
    public List<BookLoanDTO> getAllLoans() {
        List<BookLoanDTO>bookLoans=loanRepository.getAll().stream().
                map(loan->{
                    User user=userRepository.getById(loan.getUserId()).get();
                    Book book=bookRepository.getById(loan.getBookId()).get();
                    return new BookLoanDTO(
                            loan.getId().getValue(),
                            user.getId().getValue(),
                            book.getId().getValue(),
                            user.getIc().getValue(),
                            user.getName().getValue(),
                            user.getLastname().getValue(),
                            user.getGender().getDescription(),
                            user.getAge().getValue(),
                            book.getIsbn().getValue(),
                            book.getTitle().getValue(),
                            book.getAuthor().getValue(),
                            book.getReleaseDate().getValue(),
                            book.getPages().getValue(),
                            book.getGender().getDescription(),
                            loan.getDeliveryDate().getValue(),
                            loan.getReturnDate().getValue(),
                            loan.getRemainingDays().getValue()
                    );
                }).toList();
        if (bookLoans.isEmpty()) {
            throw new BookLoanNotFoundException("Loan list is empty.");
        }
        return bookLoans;
    }

    @Override
    public Optional<BookLoanDTO> getLoan(Byte id) {
        Optional<BookLoanDTO>bookLoan=loanRepository.getById(new BookLoanId(id)).stream().
                map(loan->{;
                User user=userRepository.getById(loan.getUserId()).get();
                Book book=bookRepository.getById(loan.getBookId()).get();
                return new BookLoanDTO(
                        loan.getId().getValue(),
                        user.getId().getValue(),
                        book.getId().getValue(),
                        user.getIc().getValue(),
                        user.getName().getValue(),
                        user.getLastname().getValue(),
                        user.getGender().getDescription(),
                        user.getAge().getValue(),
                        book.getIsbn().getValue(),
                        book.getTitle().getValue(),
                        book.getAuthor().getValue(),
                        book.getReleaseDate().getValue(),
                        book.getPages().getValue(),
                        book.getGender().getDescription(),
                        loan.getDeliveryDate().getValue(),
                        loan.getReturnDate().getValue(),
                        loan.getRemainingDays().getValue()
                );
            }).findFirst();
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
        if (bookLoan.isEmpty()){
            throw new BookLoanNotFoundException("Loan couldn't be found.");
        }
        loanRepository.delete(bookLoan.get().getId());
    }

    @Override
    public List<BookLoanDTO> getAllLoans(String value) {
        String search=value.toLowerCase();
        List<BookLoanDTO>loans=loanRepository.getAll().stream().
                map(bookLoan ->{
                    User user=userRepository.getById(bookLoan.getUserId()).get();
                    Book book=bookRepository.getById(bookLoan.getBookId()).get();
                    return new BookLoanDTO(
                            bookLoan.getId().getValue(),
                            user.getId().getValue(),
                            book.getId().getValue(),
                            user.getIc().getValue(),
                            user.getName().getValue(),
                            user.getLastname().getValue(),
                            user.getGender().getDescription(),
                            user.getAge().getValue(),
                            book.getIsbn().getValue(),
                            book.getTitle().getValue(),
                            book.getAuthor().getValue(),
                            book.getReleaseDate().getValue(),
                            book.getPages().getValue(),
                            book.getGender().getDescription(),
                            bookLoan.getDeliveryDate().getValue(),
                            bookLoan.getReturnDate().getValue(),
                            bookLoan.getRemainingDays().getValue()
                    );
                }).filter(loan->(loan.userName().toLowerCase().contains(search)
                    ||loan.userLastName().toLowerCase().contains(search))
                    ||(loan.bookTitle().toLowerCase().contains(search)
                    ||loan.bookAuthor().toLowerCase().contains(search))
                    ||(loan.userIc().equals(search)||loan.bookIsbn().equals(search))
                    ||(loan.bookGender().toLowerCase().contains(search))).toList();
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
    public List<BookLoanDTO> getAllLoansByDate(String value) {
        LocalDate date=dateValidator(value);
        List<BookLoanDTO>loans=loanRepository.getAll().stream().
                map(loan->{
                    User user=userRepository.getById(loan.getUserId()).get();
                    Book book=bookRepository.getById(loan.getBookId()).get();
                    return new BookLoanDTO(
                            loan.getId().getValue(),
                            user.getId().getValue(),
                            book.getId().getValue(),
                            user.getIc().getValue(),
                            user.getName().getValue(),
                            user.getLastname().getValue(),
                            user.getGender().getDescription(),
                            user.getAge().getValue(),
                            book.getIsbn().getValue(),
                            book.getTitle().getValue(),
                            book.getAuthor().getValue(),
                            book.getReleaseDate().getValue(),
                            book.getPages().getValue(),
                            book.getGender().getDescription(),
                            loan.getDeliveryDate().getValue(),
                            loan.getReturnDate().getValue(),
                            loan.getRemainingDays().getValue()
                    );
                }).filter(loan->(loan.returnDate().isBefore(date)
                        ||loan.returnDate().isEqual(date))).toList();
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
        Optional<BookLoanDTO>loan=loanRepository.getAll().stream().
                map(lb->{
                    User user=userRepository.getById(lb.getUserId()).get();
                    Book book=bookRepository.getById(lb.getBookId()).get();
                    return new BookLoanDTO(
                            lb.getId().getValue(),
                            user.getId().getValue(),
                            book.getId().getValue(),
                            user.getIc().getValue(),
                            user.getName().getValue(),
                            user.getLastname().getValue(),
                            user.getGender().getDescription(),
                            user.getAge().getValue(),
                            book.getIsbn().getValue(),
                            book.getTitle().getValue(),
                            book.getAuthor().getValue(),
                            book.getReleaseDate().getValue(),
                            book.getPages().getValue(),
                            book.getGender().getDescription(),
                            lb.getDeliveryDate().getValue(),
                            lb.getReturnDate().getValue(),
                            lb.getRemainingDays().getValue()
                    );
                }).filter(lb->lb.userIc().equals(value)||lb.bookIsbn().equals(value)).findFirst();
        if (loan.isEmpty()){
            throw new BookLoanNotFoundException("Loan couldn't be found.");
        }
        loanRepository.delete(new BookLoanId(loan.get().id()));
    }

    @Override
    public Optional<BookLoanDTO> getLoan(String value) {
        boolean isEmpty=loanRepository.getAll().isEmpty();
        if (isEmpty) {
            throw new BookLoanNotFoundException("Loan list is empty.");
        }
        Optional<BookLoanDTO>loan=loanRepository.getAll().stream().
                map(lb->{
                    User user=userRepository.getById(lb.getUserId()).get();
                    Book book=bookRepository.getById(lb.getBookId()).get();
                    return new BookLoanDTO(
                            lb.getId().getValue(),
                            user.getId().getValue(),
                            book.getId().getValue(),
                            user.getIc().getValue(),
                            user.getName().getValue(),
                            user.getLastname().getValue(),
                            user.getGender().getDescription(),
                            user.getAge().getValue(),
                            book.getIsbn().getValue(),
                            book.getTitle().getValue(),
                            book.getAuthor().getValue(),
                            book.getReleaseDate().getValue(),
                            book.getPages().getValue(),
                            book.getGender().getDescription(),
                            lb.getDeliveryDate().getValue(),
                            lb.getReturnDate().getValue(),
                            lb.getRemainingDays().getValue()
                    );
                }).filter(lb->lb.userIc().equals(value)||lb.bookIsbn().equals(value)).findFirst();
        if (loan.isEmpty()){
            throw new BookLoanNotFoundException("Loan couldn't be found.");
        }
        return loan;
    }
}
