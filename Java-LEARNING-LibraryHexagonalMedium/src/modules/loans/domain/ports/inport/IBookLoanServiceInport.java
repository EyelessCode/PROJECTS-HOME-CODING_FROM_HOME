package modules.loans.domain.ports.inport;

import java.util.List;
import java.util.Optional;

import modules.loans.app.services.dtos.BookLoanDTO;

public interface IBookLoanServiceInport {
    // Traditional
    void saveLoan(String userIc, String bookIsbn, String deliveryDateString,String returnDateString);
    void modifyLoan(String userIc, String bookIsbn, String deliveryDateString,String returnDateString);
    List<BookLoanDTO>getAllLoans();
    Optional<BookLoanDTO>getLoan(Byte id);
    void removeLoan(Byte id);

    // Customs
    List<BookLoanDTO>getAllLoans(String value); //? User IC, name or Book ISBN, author, title
    List<BookLoanDTO>getAllLoansByDate(String value); //? Loan dates (only if 'returnDate' is less to the 'value')
    void removeLoan(String value); //? User IC or Book ISBN
    Optional<BookLoanDTO>getLoan(String value); //? User IC or Book ISBN
}
