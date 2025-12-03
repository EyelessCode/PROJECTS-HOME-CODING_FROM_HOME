package modules.loans.domain.ports.inport;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import modules.loans.domain.models.BookLoan;


public interface IBookLoanServiceInport {
    // Traditional
    void saveLoan(Byte userId,Byte bookId,String deliveryDateString,String returnDateString);
    void modifyLoan(Byte userId,Byte bookId,String deliveryDateString,String returnDateString);
    List<BookLoan>getAllLoans();
    Optional<BookLoan>getLoan(Byte id);
    void removeLoan(Byte id);

    // Customs
    List<BookLoan>getAllLoans(String value); //? User IC, name or Book ISBN, author, title
    List<BookLoan>getAllLoans(LocalDate value); //? Loan dates (only if 'returnDate' is less to the 'value')
    void removeLoan(String value); //? User IC or Book ISBN
    Optional<BookLoan>getLoan(String value); //? User IC or Book ISBN
}
