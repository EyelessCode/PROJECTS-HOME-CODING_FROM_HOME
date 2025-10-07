package services;

import java.util.List;
import java.util.Optional;

import models.Book;
import models.interfaces.IBookRespository;
import models.interfaces.IBookService;

public class BookService implements IBookService{
    private final IBookRespository repository;

    public BookService(IBookRespository repository){
        this.repository=repository;
    }

    @Override
    public void registerBook(Book book) {
        if (book!=null) {
            repository.save(book);
        }else{
            throw new NullPointerException("Book couldn't be created.");
        }
    }

    @Override
    public List<Book> findAllBooks() {
        List<Book>found=repository.findAll();
        if (!found.isEmpty()) {
            return found;
        }
        throw new NullPointerException("There aren't books available yet.");
    }

    @Override
    public List<Book> findAllBooksAvailable() {
        List<Book>found=repository.findAll().stream().filter(bs->bs.isAvailable()).toList();
        if (!found.isEmpty()) {
            return found;
        }
        throw new NullPointerException("There aren't books available yet.");
    }

    /* @Override
    public List<Book> findAllBooks(String gender) {
        if (!repository.findAll().isEmpty()) {
            return repository.findAll().stream().filter(bsg->bsg.getGender().name()==gender).toList();
        }
        throw new RuntimeException("There aren't books yet.");
    } */

    @Override
    public Optional<Book> findBook(Integer id) {
        if (!repository.findById(id).isEmpty()) {
            return repository.findById(id);
        }
        throw new NullPointerException("Book not found.");
    }

    @Override
    public List<Book> findBook(String value) {
        String search=value.trim().toLowerCase();
        List<Book>found=repository.findAll().stream().filter(b->b.getTitle().toLowerCase().contains(search)||b.getGender().name().toLowerCase().equals(search)||b.getAuthor().toLowerCase().contains(search)).toList();
        if (!found.isEmpty()) {
            return found;
        }
        throw new NullPointerException("Book not found.");
    }
}
