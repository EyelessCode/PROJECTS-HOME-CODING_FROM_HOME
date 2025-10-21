package modules.books.domain.ports.outport;

import java.util.List;
import java.util.Optional;

import modules.books.domain.models.Book;

public interface IBookRepositoryOutport {
    Book create(String isbn, String title, String author, String releaseDate, Short pages, String gender);
    void delete(Byte id);
    List<Book>getAll();
    Optional<Book>getById(Byte id);
}
