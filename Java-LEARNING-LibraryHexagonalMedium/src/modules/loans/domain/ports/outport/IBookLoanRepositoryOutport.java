package modules.loans.domain.ports.outport;

import java.util.List;
import java.util.Optional;

import modules.loans.domain.models.BookLoan;
import modules.loans.domain.models.valueObjects.BookLoanId;

public interface IBookLoanRepositoryOutport {
    BookLoan create(BookLoan bookLoan);
    BookLoan update(BookLoan bookLoan);
    void delete(BookLoanId id);
    List<BookLoan>getAll();
    Optional<BookLoan>getById(BookLoanId id);
}
