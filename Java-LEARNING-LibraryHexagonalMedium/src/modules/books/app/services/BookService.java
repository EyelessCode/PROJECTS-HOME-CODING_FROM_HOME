package modules.books.app.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import modules.books.domain.exceptions.BooksNotFoundException;
import modules.books.domain.exceptions.models.BookGenderInvalidException;
import modules.books.domain.models.Book;
import modules.books.domain.models.valueObjects.enums.BookGender;
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
    public void modify(String isbn, String title, String author, String releaseDate, Short pages, String gender) {
        isNotNull(isbn, title, author, releaseDate, pages, gender);
        boolean isEmpty=repository.getAll().isEmpty();
        Optional<Book>book=repository.getAll().stream().filter(b->b.getIsbn().getValue().equals(isbn)).findFirst();
        if (isEmpty) {
            throw new BooksNotFoundException("Book list is empty.");
        }
        if (!book.isEmpty()) {
            repository.update(isbn, title, author, releaseDate, pages, gender);
            return;
        }
        throw new BooksNotFoundException("Book couldn't be found.");
    }

    @Override
    public void removeBook(Byte id) {
        boolean isEmpty=repository.getAll().isEmpty();
        Optional<Book> book=repository.getById(id).stream().findFirst();
        if (isEmpty) {
            throw new BooksNotFoundException("Book list is empty.");
        }
        if (!book.isEmpty()) {
            repository.delete(book.get().getId().getValue());
            return;
        }
        throw new BooksNotFoundException("Book couldn't be found.");
    }

    @Override
    public List<Book> getBooks() {
        List<Book>books=repository.getAll().stream().toList();
        if (!books.isEmpty()) {
            return books;
        }
        throw new BooksNotFoundException("Book list is empty.");
    }

    @Override
    public Optional<Book> getBook(Byte id) {
        boolean isEmpty=repository.getAll().isEmpty();
        Optional<Book>book=repository.getById(id).stream().findFirst();
        if (isEmpty) {
            throw new BooksNotFoundException("Book list is empty.");
        }
        if (!book.isEmpty()) {
            return book;
        }
        throw new BooksNotFoundException("Book couldn't be found.");
    }

    @Override
    public void removeBook(String isbn) {
        boolean isEmpty=repository.getAll().isEmpty();
        Optional<Book> book=repository.getAll().stream().
            filter(b->b.getIsbn().getValue().equals(isbn)).findFirst();
        if (isEmpty) {
            throw new BooksNotFoundException("Book list is empty.");
        }
        if (!book.isEmpty()) {
            repository.delete(book.get().getId().getValue());
            return;
        }
        throw new BooksNotFoundException("Book couldn't be found.");
    }

    @Override
    public List<Book> getBooks(String value) {
        boolean isEmpty=repository.getAll().isEmpty();
        List<Book>books=repository.getAll().stream().
            filter(bs->bs.getIsbn().getValue().equals(value)||bs.getTitle().getValue().equalsIgnoreCase(value)||bs.getAuthor().getValue().equalsIgnoreCase(value)||bs.getGender().getDescription().equalsIgnoreCase(value)).toList();
        if (isEmpty) {
            throw new BooksNotFoundException("Book list is empty.");
        }
        if (!books.isEmpty()) {
            return books;
        }
        throw new BooksNotFoundException("Book list with '"+value+"' as value couldn't be found.");
    }

    @Override
    public Optional<Book> getBook(String isbn) {
        boolean isEmpty=repository.getAll().isEmpty();
        Optional<Book>book=repository.getAll().stream().
            filter(b->b.getIsbn().getValue().equals(isbn)).findFirst();
        if (isEmpty) {
            throw new BooksNotFoundException("Book list is empty.");
        }
        if (!book.isEmpty()) {
            repository.getById(book.get().getId().getValue());
        }
        throw new BooksNotFoundException("Book couldn't be found.");
    }

    @Override
    public List<String> getbookGenders(){
        List<String> gender=Arrays.stream(BookGender.values()).map(BookGender::getDescription).toList();
        if (!gender.isEmpty()) {
            return gender;
        }
        throw new BookGenderInvalidException("Book genders list is empty.");
    }
}
