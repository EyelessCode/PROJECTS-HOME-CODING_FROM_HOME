package modules.loans.domain.ports.inport;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import modules.loans.domain.models.BookLoan;


public interface IBookLoanServiceInport {
    // Traditional
    void saveLoan(Byte userId,Byte bookId,LocalDate deliveryDate,LocalDate returnDate);
    void modifyLoan(Byte userId,Byte bookId,LocalDate deliveryDate,LocalDate returnDate);
    List<BookLoan>getAllLoans();
    Optional<BookLoan>getLoan(Byte id);
    void removeLoan(Byte id);

    // Customs
    List<BookLoan>getAllLoans(String value); // User IC or Book ISBN
    void removeLoan(String value); // User IC or Book ISBN
    Optional<BookLoan>getLoan(String value); // User IC or Book ISBN
}
