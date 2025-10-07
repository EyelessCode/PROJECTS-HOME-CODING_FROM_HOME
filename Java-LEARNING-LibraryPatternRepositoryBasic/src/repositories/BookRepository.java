package repositories;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import models.Book;
import models.enums.GenderBook;
import models.interfaces.IBookRespository;

public class BookRepository implements IBookRespository{
    public Map<Integer,Book>memoryBook=new HashMap<>();
    private Integer currentId=1;

    public BookRepository(){ //* Data already initializated
        int currentByMap=1;
        memoryBook.put(
            currentByMap++,new Book(currentId++,"TITLE 1", "AUTHOR 1", "IBN 1", GenderBook.ADVENTURE, LocalDate.of(2014, Month.JUNE, 14))
        );
        memoryBook.put(
            currentByMap++,new Book(currentId++,"TITLE 2", "AUTHOR 2", "IBN 2", GenderBook.COMEDY, LocalDate.of(2018, Month.MARCH, 7))
        );
        memoryBook.put(
            currentByMap++,new Book(currentId++,"TITLE 3", "AUTHOR 3", "IBN 3", GenderBook.DRAMATIC, LocalDate.of(2020, Month.DECEMBER, 27))
        );
        memoryBook.put(
            currentByMap++,new Book(currentId++,"TITLE 4", "AUTHOR 4", "IBN 4", GenderBook.HORROR, LocalDate.of(2011, Month.OCTOBER, 25))
        );
        memoryBook.put(
            currentByMap++,new Book(currentId++,"TITLE 5", "AUTHOR 5", "IBN 5", GenderBook.SUSPENSE, LocalDate.of(1997, Month.FEBRUARY, 2))
        );
    }

    @Override
    public Book save(Book book) {
        if (book.getId()==null) {
            book.setId(currentId++);
        }
        return memoryBook.put(book.getId(), book);
    }

    @Override
    public void deleteById(Integer id) {
        memoryBook.remove(id);
    }

    @Override
    public List<Book> findAll() {
        return memoryBook.values().stream().toList();
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return Optional.ofNullable(memoryBook.get(id));
    }
}
