package modules.books.domain.ports.outport;

import java.util.List;
import java.util.Optional;

import modules.books.domain.models.Book;

public interface IBookRepositoryOutport {
    Book create(Book book);
    void delete(Byte id);
    List<Book>GetAll();
    Optional<Book>GetById(Byte id);
}
