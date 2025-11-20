package modules.loans.domain.models;

import modules.books.domain.models.valueObjects.BookId;
import modules.loans.domain.models.valueObjects.BookLoanDates;
import modules.loans.domain.models.valueObjects.BookLoanId;
import modules.loans.domain.models.valueObjects.BookLoanRemainingDays;
import modules.loans.domain.models.valueObjects.UserId;

public class BookLoan {
    private BookLoanId id;
    private final BookId bookId;
    private final UserId userId;
    private final BookLoanDates deliveryDate,returnDate;
    private final BookLoanRemainingDays remainingDays;
    
    public BookLoan(BookId bookId, UserId userId, BookLoanDates deliveryDate,
            BookLoanDates returnDate) {
        this.id = new BookLoanId(null);
        this.bookId = bookId;
        this.userId = userId;
        this.deliveryDate = deliveryDate;
        this.returnDate = returnDate;
        this.remainingDays=new BookLoanRemainingDays(deliveryDate,returnDate);
    }

    public BookLoan(BookLoanId id, BookId bookId, UserId userId, BookLoanDates deliveryDate,
            BookLoanDates returnDate) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.deliveryDate = deliveryDate;
        this.returnDate = returnDate;
        this.remainingDays=new BookLoanRemainingDays(deliveryDate,returnDate);
    }

    public BookLoanId getId() {
        return id;
    }

    public BookId getBookId() {
        return bookId;
    }

    public UserId getUserId() {
        return userId;
    }

    public BookLoanDates getDeliveryDate() {
        return deliveryDate;
    }

    public BookLoanDates getReturnDate() {
        return returnDate;
    }
    
    public BookLoanRemainingDays getRemainingDays() {
        return remainingDays;
    }
}
