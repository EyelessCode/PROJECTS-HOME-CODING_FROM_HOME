package modules.loans.app.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import modules.books.domain.models.valueObjects.BookId;
import modules.loans.domain.exceptions.models.BookLoanNotFoundException;
import modules.loans.domain.models.BookLoan;
import modules.loans.domain.models.valueObjects.BookLoanDates;
import modules.loans.domain.models.valueObjects.BookLoanId;
import modules.loans.domain.models.valueObjects.UserId;
import modules.loans.domain.ports.inport.IBookLoanServiceInport;
import modules.loans.domain.ports.outport.IBookLoanRepositoryOutport;
import modules.loans.domain.services.BookLoanServiceValidator;

public class BookLoanService extends BookLoanServiceValidator implements IBookLoanServiceInport{
    private final IBookLoanRepositoryOutport repository;

    public BookLoanService(IBookLoanRepositoryOutport repository){
        this.repository=repository;
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
        repository.create(bookLoan);
    }

    @Override
    public void modifyLoan(Byte userId, Byte bookId, String deliveryDateString, String returnDateString) {
        boolean loanList=repository.getAll().isEmpty();
        Optional<BookLoan>oldBookLoan=repository.getAll().stream().
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
        repository.update(modifiedBookLoan);
    }

    @Override
    public List<BookLoan> getAllLoans() {
        List<BookLoan>bookLoans=repository.getAll();
        if (bookLoans.isEmpty()) {
            throw new BookLoanNotFoundException("Loan list is empty.");
        }
        return bookLoans;
    }

    @Override
    public Optional<BookLoan> getLoan(Byte id) {
        Optional<BookLoan>bookLoan=repository.getById(new BookLoanId(id));
        boolean isEmpty=repository.getAll().isEmpty();
        if (isEmpty) {
            throw new BookLoanNotFoundException("Loan list is empty.");
        }
        return bookLoan;
    }

    @Override
    public void removeLoan(Byte id) {
        Optional<BookLoan>bookLoan=repository.getById(new BookLoanId(id));
        boolean isEmpty=repository.getAll().isEmpty();
        if (isEmpty) {
            throw new BookLoanNotFoundException("Loan list is empty.");
        }
        repository.delete(bookLoan.get().getId());
    }

    @Override
    public List<BookLoan> getAllLoans(String value) {
        List<BookLoan>loans=repository.getAll().stream()
            .filter(loan->loan.getBookId().getValue().toString().equals(value)
                ||loan.getUserId().getValue().toString().equals(value))
            .toList();
        boolean isEmpty=repository.getAll().isEmpty();
        if (isEmpty) {
            throw new BookLoanNotFoundException("Loan list is empty.");
        }
        if (loans.isEmpty()) {
            throw new BookLoanNotFoundException("Loan couldn't be found.");
        }
        return loans;
    }

    @Override
    public List<BookLoan> getAllLoans(LocalDate value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllLoans'");
    }

    @Override
    public void removeLoan(String value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeLoan'");
    }

    @Override
    public Optional<BookLoan> getLoan(String value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLoan'");
    }
}
