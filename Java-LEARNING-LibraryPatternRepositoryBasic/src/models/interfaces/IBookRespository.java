package models.interfaces;

import java.util.List;
import java.util.Optional;

import models.Book;

public interface IBookRespository {
    Book save(Book book);
    void deleteById(Integer id);
    List<Book>findAll();
    Optional<Book>findById(Integer id);
}
