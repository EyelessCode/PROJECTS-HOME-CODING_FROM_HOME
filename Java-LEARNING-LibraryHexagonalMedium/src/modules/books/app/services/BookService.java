package modules.books.app.services;

import java.util.List;
import java.util.Optional;

import modules.books.domain.exceptions.BooksNotFoundException;
import modules.books.domain.models.Book;
import modules.books.domain.ports.inport.IBookServiceInport;
import modules.books.domain.ports.outport.IBookRepositoryOutport;
import modules.books.domain.services.BookServiceValidator;

public class BookService extends BookServiceValidator implements IBookServiceInport{
    private final IBookRepositoryOutport repository;

    public BookService(IBookRepositoryOutport repository){
        this.repository=repository;
    }

    @Override
    public void saveBook(String isbn, String title, String author, String releaseDate, Short pages, String gender) {
        // DateTimeFormatter formatterDate=DateTimeFormatter.ofPattern("yyyy/MM/dd");
        isNotNull(isbn, title, author, releaseDate, pages, gender);
        repository.create(isbn, title, author, releaseDate, pages, gender);
    }

    @Override
    public void removeBook(Byte id) {
        boolean isEmpty=repository.getAll().isEmpty();
        boolean isPresent=repository.getById(id).isPresent();
        if (!isEmpty) {
            if (isPresent) {
                repository.delete(id);
            }
            throw new BooksNotFoundException("Book couldn't be found.");
        }
        throw new BooksNotFoundException("Book list is empty.");
    }

    @Override
    public List<Book> getBooks() {
        boolean isEmpty=repository.getAll().isEmpty();
        if (!isEmpty) {
            List<Book>books=repository.getAll().stream().toList();
            return books;
        }
        throw new BooksNotFoundException("Book list is empty.");
    }

    @Override
    public Optional<Book> getBook(Byte id) {
        boolean isEmpty=repository.getAll().isEmpty();
        boolean isPresent=repository.getById(id).isPresent();
        if (!isEmpty) {
            if (isPresent) {
                return repository.getById(id);
            }
            throw new BooksNotFoundException("Book couldn't be found.");
        }
        throw new BooksNotFoundException("Book list is empty.");
    }

    @Override
    public void removeBook(String isbn) {
        boolean isEmpty=repository.getAll().isEmpty();
        boolean isPresent=repository.getAll().stream().
            filter(b->b.getIsbn().getValue().equals(isbn)).findFirst().isPresent();
        if (!isEmpty) {
            if (isPresent) {
                Book book=repository.getAll().stream().filter(b->b.getIsbn().getValue().equals(isbn)).findFirst().get();
                repository.delete(book.getId().getValue());
            }
            throw new BooksNotFoundException("Book couldn't be found.");
        }
        throw new BooksNotFoundException("Book list is empty.");
    }

    @Override
    public List<Book> getBooks(String value) {
        boolean isEmpty=repository.getAll().isEmpty();
        if (!isEmpty) {
            boolean isNotPresent=repository.getAll().stream().
                filter(bs->bs.getIsbn().getValue().equals(value)||bs.getTitle().getValue().contains(value)||bs.getAuthor().getValue().contains(value)||bs.getGender().getDescription().contains(value)).toList().isEmpty();
            if (!isNotPresent) {
                List<Book>books=repository.getAll().stream().
                    filter(bs->bs.getIsbn().getValue().equals(value)||bs.getTitle().getValue().contains(value)||bs.getAuthor().getValue().contains(value)||bs.getGender().getDescription().contains(value)).toList();
                return books;
            }
            throw new BooksNotFoundException("Book list with '"+value+"' as value couldn't be found.");
        }
        throw new BooksNotFoundException("Book list is empty.");
    }

    @Override
    public Optional<Book> getBook(String isbn) {
        boolean isEmpty=repository.getAll().isEmpty();
        boolean isPresent=repository.getAll().stream().
            filter(b->b.getIsbn().getValue().equals(isbn)).findFirst().isPresent();
        if (!isEmpty) {
            if (isPresent) {
                Book book=repository.getAll().stream().filter(b->b.getIsbn().getValue().equals(isbn)).findFirst().get();
                repository.getById(book.getId().getValue());
            }
            throw new BooksNotFoundException("Book couldn't be found.");
        }
        throw new BooksNotFoundException("Book list is empty.");
    }
}
