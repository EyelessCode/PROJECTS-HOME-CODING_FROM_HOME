package modules.loans.infrastructure.adapters.outbound.repositories;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import modules.loans.domain.models.BookLoan;
import modules.loans.domain.models.valueObjects.BookLoanId;
import modules.loans.domain.ports.outport.IBookLoanRepositoryOutport;

public class BookLoanRepositoryInMemory implements IBookLoanRepositoryOutport{
    private byte currentId=1;
    private Map<BookLoanId,BookLoan>loanInMemory=new HashMap<>();
    private DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public BookLoanRepositoryInMemory(){

    }
    
    @Override
    public BookLoan create(Byte userId, Byte bookId, LocalDate deliveryDate, LocalDate returnDate) {
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
    @Override
    public BookLoan update(Byte userId, Byte bookId, LocalDate deliveryDate, LocalDate returnDate) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    @Override
    public void delete(Byte id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    @Override
    public List<BookLoan> getAll() {
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
    @Override
    public Optional<BookLoan> getById(Byte id) {
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }


}
