package models.interfaces;

import java.util.List;
import java.util.Optional;

import models.Book;

public interface IBookService {
    void registerBook(Book book);
    List<Book>findAllBooks();
    // List<Book>findAllBooks(String gender);
    List<Book>findAllBooksAvailable();
    Optional<Book>findBook(Integer id);
    List<Book>findBook(String value);
}
