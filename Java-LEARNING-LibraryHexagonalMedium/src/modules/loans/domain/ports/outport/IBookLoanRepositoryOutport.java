package modules.loans.domain.ports.outport;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import modules.loans.domain.models.BookLoan;

public interface IBookLoanRepositoryOutport {
    BookLoan create(Byte userId,Byte bookId,LocalDate deliveryDate,LocalDate returnDate);
    BookLoan update(Byte userId,Byte bookId,LocalDate deliveryDate,LocalDate returnDate);
    void delete(Byte id);
    List<BookLoan>getAll();
    Optional<BookLoan>getById(Byte id);
}
