package modules.loans.infrastructure.adapters.outbound.repositories;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import modules.books.domain.exceptions.models.BookInvalidException;
import modules.books.domain.models.valueObjects.BookId;
import modules.loans.domain.models.BookLoan;
import modules.loans.domain.models.valueObjects.BookLoanDates;
import modules.loans.domain.models.valueObjects.BookLoanId;
import modules.loans.domain.ports.outport.IBookLoanRepositoryOutport;
import modules.users.domain.models.valueObjects.UserId;

public class BookLoanRepositoryInMemory implements IBookLoanRepositoryOutport{
    private final Map<BookLoanId,BookLoan>loanInMemory=new HashMap<>();

    public BookLoanRepositoryInMemory(){
//        loanInMemory.putIfAbsent(
//            new BookLoanId((byte)1),
//            new BookLoan(
//                // new BookLoanId((byte)1),
//                new BookId((byte)1),
//                new UserId((byte)1),
//                new BookLoanDates(LocalDate.now()),
//                new BookLoanDates(LocalDate.now().plusMonths(1))
//            )
//        );
//
//        loanInMemory.putIfAbsent(
//            new BookLoanId((byte)2),
//            new BookLoan(
//                new BookId((byte)2),
//                new UserId((byte)2),
//                new BookLoanDates(LocalDate.now()),
//                new BookLoanDates(LocalDate.now().plusDays(4))
//            )
//        );
//
//        loanInMemory.putIfAbsent(
//            new BookLoanId((byte)3),
//            new BookLoan(
//                new BookId((byte)3),
//                new UserId((byte)3),
//                new BookLoanDates(LocalDate.now()),
//                new BookLoanDates(LocalDate.now().plusWeeks(2))
//            )
//        );
//
//        loanInMemory.putIfAbsent(
//            new BookLoanId((byte)4),
//            new BookLoan(
//                new BookId((byte)4),
//                new UserId((byte)4),
//                new BookLoanDates(LocalDate.now()),
//                new BookLoanDates(LocalDate.now())
//            )
//        );
        create(
                new BookLoan(
                        new BookId((byte)1),
                        new UserId((byte)1),
                        new BookLoanDates(LocalDate.now()),
                        new BookLoanDates(LocalDate.now().plusMonths(1))
                )
        );
        create(
                new BookLoan(
                        new BookId((byte)2),
                        new UserId((byte)2),
                        new BookLoanDates(LocalDate.now()),
                        new BookLoanDates(LocalDate.now().plusDays(4))
                )
        );
        create(
                new BookLoan(
                        new BookId((byte)3),
                        new UserId((byte)3),
                        new BookLoanDates(LocalDate.now()),
                        new BookLoanDates(LocalDate.now().plusMonths(2))
                )
        );
    }

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
