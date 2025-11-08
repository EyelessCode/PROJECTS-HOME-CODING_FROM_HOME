package modules.books.domain.ports.inport;

import java.util.List;
import java.util.Optional;

import modules.books.domain.models.Book;

public interface IBookServiceInport {
    // TRADITIONAL CRUD
    void saveBook(String isbn,String title,String author,String releaseDate,Short pages,String gender);
    void modifyBook(String isbn,String title,String author,String releaseDate,Short pages,String gender);
    void removeBook(Byte id);
    List<Book>getBooks();
    Optional<Book>getBook(Byte id);

    // CUSTOM METHODS
    void removeBook(String isbn);
    List<Book>getBooks(String value);
    List<String>getbookGenders();
    Optional<Book>getBook(String isbn);
}
