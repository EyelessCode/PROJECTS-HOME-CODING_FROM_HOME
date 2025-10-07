package repositories;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import models.Book;
import models.LoanBook;
import models.User;
import models.enums.GenderBook;
import models.interfaces.ILoanBookRepository;

public class LoanBookRepository implements ILoanBookRepository{
    private Map<Integer,LoanBook>memoryLoanBook=new ConcurrentHashMap<>();
    private UserRepository user;
    private BookRepository book;

    private Integer currentId=1;

    public LoanBookRepository(BookRepository book,UserRepository user){
        this.book = book;
        this.user = user;
        

        int currentByMap=1;
        memoryLoanBook.put(currentByMap++, new LoanBook(currentId++, LocalDate.of(2025, Month.APRIL, 7), LocalDate.of(2025, Month.NOVEMBER, 28), book.memoryBook.get(4), user.memoryUser.get(3)));
        memoryLoanBook.put(currentByMap++, new LoanBook(currentId++, LocalDate.of(2025, Month.SEPTEMBER, 19), LocalDate.of(2025, Month.OCTOBER, 19), book.memoryBook.get(5), user.memoryUser.get(4)));
    }

    @Override
    public LoanBook save(LoanBook loanBook) {
        if (loanBook.getId()==null) {
            loanBook.setId(currentId++);
        }
        return memoryLoanBook.put(loanBook.getId(), loanBook);
    }

    @Override
    public void deleteById(Integer id) {
        if (memoryLoanBook.containsKey(id)) {
            memoryLoanBook.remove(id);
        }
    }

    @Override
    public List<LoanBook> findAll() {
        return memoryLoanBook.values().stream().toList();
    }

    @Override
    public Optional<LoanBook> findById(Integer id) {
        return Optional.ofNullable(memoryLoanBook.get(id));
    }
}
