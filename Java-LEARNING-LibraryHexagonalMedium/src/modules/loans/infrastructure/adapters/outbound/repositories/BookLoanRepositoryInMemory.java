package modules.loans.infrastructure.adapters.outbound.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import modules.books.domain.exceptions.models.BookInvalidException;
import modules.loans.domain.models.BookLoan;
import modules.loans.domain.models.valueObjects.BookLoanId;
import modules.loans.domain.ports.outport.IBookLoanRepositoryOutport;

public class BookLoanRepositoryInMemory implements IBookLoanRepositoryOutport{
    private final Map<BookLoanId,BookLoan>loanInMemory=new HashMap<>();

    @Override
    public BookLoan create(BookLoan bookLoan) {
        return loanInMemory.putIfAbsent(bookLoan.getId(), bookLoan);
    }

    @Override
    public BookLoan update(BookLoan bookLoan) {
        Optional<Map.Entry<BookLoanId,BookLoan>>exist=loanInMemory.entrySet().stream().
            filter(lb->lb.getValue().getUserId().getValue().equals(bookLoan.getUserId().getValue())&&
                    lb.getValue().getBookId().getValue().equals(bookLoan.getBookId().getValue())).findFirst();
        if (exist.isEmpty()){
            throw new BookInvalidException("It seems that the Loan Server occurred an error. Try again later.");
        }
        BookLoanId bookLoanId=exist.get().getKey();
        return loanInMemory.put(bookLoanId, bookLoan);
    }

    @Override
    public void delete(BookLoanId id) {
        loanInMemory.remove(id);
    }

    @Override
    public List<BookLoan> getAll() {
        return loanInMemory.values().stream().toList();
    }

    @Override
    public Optional<BookLoan> getById(BookLoanId id) {
        return Optional.ofNullable(loanInMemory.get(id));
    }
}
