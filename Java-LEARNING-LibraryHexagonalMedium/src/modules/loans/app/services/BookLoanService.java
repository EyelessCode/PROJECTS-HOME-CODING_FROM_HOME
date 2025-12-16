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
    public void saveLoan(String userIc, String bookIsbn, String deliveryDateString, String returnDateString) {
        isNotNull(userIc, bookIsbn, deliveryDateString, returnDateString);
        LocalDate deliveryDate=dateValidator(deliveryDateString);
        LocalDate returnDate=deliveryDate.plusDays(Integer.parseInt(returnDateString));
        Optional<Book>book=bookRepository.getAll().stream().
                filter(b->bookIsbn.equals(b.getIsbn().getValue())).findFirst();
        if (book.isEmpty()){
            throw new BookLoanNotFoundException("Book with '"+bookIsbn+"' ISBN couldn't be found.");
        }
        Optional<User> user=userRepository.getAll().stream().
                filter(u->userIc.equals(u.getIc().getValue())).findFirst();
        if (user.isEmpty()){
            throw new BookLoanNotFoundException("User with '"+userIc+"' IC couldn't be found.");
        }
        book.get().lead();
        BookLoan bookLoan=new BookLoan(
            book.get().getId(),
            user.get().getId(),
            new BookLoanDates(deliveryDate),
            new BookLoanDates(returnDate)
        );

        loanRepository.create(bookLoan);
    }

    @Override
    public void modifyLoan(String userIc, String bookIsbn, String deliveryDateString, String returnDateString) {
        boolean loanList=loanRepository.getAll().isEmpty();
        if (loanList) {
            throw new BookLoanNotFoundException("Loan list is empty.");
        }
        LocalDate deliveryDate=dateValidator(deliveryDateString);
        LocalDate returnDate=deliveryDate.plusDays(Integer.parseInt(returnDateString));
        Optional<Book> book=bookRepository.getAll().stream().
                filter(b->bookIsbn.equals(b.getIsbn().getValue())).findFirst();
        if (book.isEmpty()){
            throw new BookLoanNotFoundException("Book with '"+bookIsbn+"' ISBN couldn't be found.");
        }
        Optional<User> user=userRepository.getAll().stream().
                filter(u->userIc.equals(u.getIc().getValue())).findFirst();
        if (user.isEmpty()){
            throw new BookLoanNotFoundException("User with '"+userIc+"' IC couldn't be found.");
        }
//        book.get().lead();
        Optional<BookLoan>oldBookLoan=loanRepository.getAll().stream().
            filter(lb->lb.getBookId().getValue().equals(book.get().getId().getValue())&&
                    lb.getUserId().getValue().equals(user.get().getId().getValue())).findFirst();
        if (oldBookLoan.isEmpty()) {
            throw new BookLoanNotFoundException("Loan with '"+userIc+" IC and "+bookIsbn+" ISBN' couldn't be found.");
        }
        BookLoan modifiedBookLoan=new BookLoan(
            book.get().getId(),
            user.get().getId(),
            new BookLoanDates(deliveryDateString.isBlank()?deliveryDate:oldBookLoan.get().getDeliveryDate().getValue()),
            new BookLoanDates(returnDateString.isBlank()?returnDate:oldBookLoan.get().getReturnDate().getValue())
        );
        loanRepository.update(modifiedBookLoan);
    }

    @Override
    public List<BookLoanDTO> getAllLoans() {
        List<BookLoanDTO>bookLoans=loanRepository.getAll().stream().
                map(loan->{
                    Optional<User> user=userRepository.getById(loan.getUserId());
                    if (user.isEmpty()){
                        throw new BookLoanNotFoundException("User with '"+loan.getUserId()+"' IC couldn't be found.");
                    }
                    Optional<Book> book=bookRepository.getById(loan.getBookId());
                    if (book.isEmpty()){
                        throw new BookLoanNotFoundException("Book with '"+loan.getBookId()+"' ISBN couldn't be found.");
                    }
                    return new BookLoanDTO(
                            loan.getId().getValue(),
                            user.get().getId().getValue(),
                            book.get().getId().getValue(),
                            user.get().getIc().getValue(),
                            user.get().getName().getValue(),
                            user.get().getLastname().getValue(),
                            user.get().getGender().getDescription(),
                            user.get().getAge().getValue(),
                            book.get().getIsbn().getValue(),
                            book.get().getTitle().getValue(),
                            book.get().getAuthor().getValue(),
                            book.get().getReleaseDate().getValue(),
                            book.get().getPages().getValue(),
                            book.get().getGender().getDescription(),
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
                    Optional<User> user=userRepository.getById(loan.getUserId());
                    if (user.isEmpty()){
                        throw new BookLoanNotFoundException("User with '"+loan.getUserId()+"' IC couldn't be found.");
                    }
                    Optional<Book> book=bookRepository.getById(loan.getBookId());
                    if (book.isEmpty()){
                        throw new BookLoanNotFoundException("Book with '"+loan.getBookId()+"' ISBN couldn't be found.");
                    }
                    return new BookLoanDTO(
                            loan.getId().getValue(),
                            user.get().getId().getValue(),
                            book.get().getId().getValue(),
                            user.get().getIc().getValue(),
                            user.get().getName().getValue(),
                            user.get().getLastname().getValue(),
                            user.get().getGender().getDescription(),
                            user.get().getAge().getValue(),
                            book.get().getIsbn().getValue(),
                            book.get().getTitle().getValue(),
                            book.get().getAuthor().getValue(),
                            book.get().getReleaseDate().getValue(),
                            book.get().getPages().getValue(),
                            book.get().getGender().getDescription(),
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
            throw new BookLoanNotFoundException("Loan with '"+id+"' ID couldn't be found.");
        }
        loanRepository.delete(bookLoan.get().getId());
    }

    @Override
    public List<BookLoanDTO> getAllLoans(String value) {
        String search=value.toLowerCase();
        List<BookLoanDTO>loans=loanRepository.getAll().stream().
                map(loan ->{
                    Optional<User> user=userRepository.getById(loan.getUserId());
                    if (user.isEmpty()){
                        throw new BookLoanNotFoundException("User with '"+value+"' IC couldn't be found.");
                    }
                    Optional<Book> book=bookRepository.getById(loan.getBookId());
                    if (book.isEmpty()){
                        throw new BookLoanNotFoundException("Book with '"+value+"' ISBN couldn't be found.");
                    }
                    return new BookLoanDTO(
                            loan.getId().getValue(),
                            user.get().getId().getValue(),
                            book.get().getId().getValue(),
                            user.get().getIc().getValue(),
                            user.get().getName().getValue(),
                            user.get().getLastname().getValue(),
                            user.get().getGender().getDescription(),
                            user.get().getAge().getValue(),
                            book.get().getIsbn().getValue(),
                            book.get().getTitle().getValue(),
                            book.get().getAuthor().getValue(),
                            book.get().getReleaseDate().getValue(),
                            book.get().getPages().getValue(),
                            book.get().getGender().getDescription(),
                            loan.getDeliveryDate().getValue(),
                            loan.getReturnDate().getValue(),
                            loan.getRemainingDays().getValue()
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
                    Optional<User> user=userRepository.getById(loan.getUserId());
                    if (user.isEmpty()){
                        throw new BookLoanNotFoundException("User with '"+loan.getUserId()+"' IC couldn't be found.");
                    }
                    Optional<Book> book=bookRepository.getById(loan.getBookId());
                    if (book.isEmpty()){
                        throw new BookLoanNotFoundException("Book with '"+loan.getBookId()+"' ISBN couldn't be found.");
                    }
                    return new BookLoanDTO(
                            loan.getId().getValue(),
                            user.get().getId().getValue(),
                            book.get().getId().getValue(),
                            user.get().getIc().getValue(),
                            user.get().getName().getValue(),
                            user.get().getLastname().getValue(),
                            user.get().getGender().getDescription(),
                            user.get().getAge().getValue(),
                            book.get().getIsbn().getValue(),
                            book.get().getTitle().getValue(),
                            book.get().getAuthor().getValue(),
                            book.get().getReleaseDate().getValue(),
                            book.get().getPages().getValue(),
                            book.get().getGender().getDescription(),
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
                    Optional<User> user=userRepository.getById(lb.getUserId());
                    if (user.isEmpty()){
                        throw new BookLoanNotFoundException("User with '"+value+"' IC couldn't be found.");
                    }
                    Optional<Book> book=bookRepository.getById(lb.getBookId());
                    if (book.isEmpty()){
                        throw new BookLoanNotFoundException("Book with '"+value+"' ISBN couldn't be found.");
                    }
                    return new BookLoanDTO(
                            lb.getId().getValue(),
                            user.get().getId().getValue(),
                            book.get().getId().getValue(),
                            user.get().getIc().getValue(),
                            user.get().getName().getValue(),
                            user.get().getLastname().getValue(),
                            user.get().getGender().getDescription(),
                            user.get().getAge().getValue(),
                            book.get().getIsbn().getValue(),
                            book.get().getTitle().getValue(),
                            book.get().getAuthor().getValue(),
                            book.get().getReleaseDate().getValue(),
                            book.get().getPages().getValue(),
                            book.get().getGender().getDescription(),
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
                    Optional<User> user=userRepository.getById(lb.getUserId());
                    if (user.isEmpty()){
                        throw new BookLoanNotFoundException("User with '"+value+"' IC couldn't be found.");
                    }
                    Optional<Book> book=bookRepository.getById(lb.getBookId());
                    if (book.isEmpty()){
                        throw new BookLoanNotFoundException("Book with '"+value+"' ISBN couldn't be found.");
                    }
                    return new BookLoanDTO(
                            lb.getId().getValue(),
                            user.get().getId().getValue(),
                            book.get().getId().getValue(),
                            user.get().getIc().getValue(),
                            user.get().getName().getValue(),
                            user.get().getLastname().getValue(),
                            user.get().getGender().getDescription(),
                            user.get().getAge().getValue(),
                            book.get().getIsbn().getValue(),
                            book.get().getTitle().getValue(),
                            book.get().getAuthor().getValue(),
                            book.get().getReleaseDate().getValue(),
                            book.get().getPages().getValue(),
                            book.get().getGender().getDescription(),
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
