package modules.books.domain.ports.outport;

import java.util.List;
import java.util.Optional;

import modules.books.domain.models.Book;
import modules.books.domain.models.valueObjects.BookId;

public interface IBookRepositoryOutport {
    Book create(Book book);
    Book update(Book book);
    void delete(BookId id);
    List<Book>getAll();
    Optional<Book>getById(BookId id);
}
