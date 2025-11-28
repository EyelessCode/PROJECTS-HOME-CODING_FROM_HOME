package modules.books.app.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import modules.books.domain.exceptions.models.BooksNotFoundException;
import modules.books.domain.exceptions.models.valueObjects.BookGenderInvalidException;
import modules.books.domain.models.Book;
import modules.books.domain.models.valueObjects.BookAuthor;
import modules.books.domain.models.valueObjects.BookId;
import modules.books.domain.models.valueObjects.BookIsbn;
import modules.books.domain.models.valueObjects.BookPages;
import modules.books.domain.models.valueObjects.BookReleaseDate;
import modules.books.domain.models.valueObjects.BookTitle;
import modules.books.domain.models.valueObjects.enums.BookGender;
import modules.books.domain.ports.inport.IBookServiceInport;
import modules.books.domain.ports.outport.IBookRepositoryOutport;
import modules.books.domain.services.BookServiceValidator;

public class BookService extends BookServiceValidator implements IBookServiceInport{
    private final IBookRepositoryOutport repository;
    private final DateTimeFormatter formatterDate=DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public BookService(IBookRepositoryOutport repository){
        this.repository=repository;
    }

    @Override
    public void saveBook(String isbn, String title, String author, String releaseDate, Short pages, String gender) {
        isNotNull(isbn, title, author, releaseDate, pages, gender);
        Book book=new Book(
            new BookIsbn(isbn),
            new BookTitle(title),
            new BookAuthor(author),
            new BookReleaseDate(LocalDate.parse(releaseDate, formatterDate)),
            new BookPages(pages),
            BookGender.genderValidatorFromInput(gender)
        );
        repository.create(book);
    }

    @Override
    public void modifyBook(String isbn, String title, String author, String releaseDate, Short pages, String gender) {
        boolean isEmpty=repository.getAll().isEmpty();
        Optional<Book> oldBook=repository.getAll().stream().filter(b->b.getIsbn().getValue().equals(isbn)).findFirst();
        if (isEmpty) {
            throw new BooksNotFoundException("Book list is empty.");
        }
        if (oldBook.isEmpty()) {
            throw new BooksNotFoundException("Book couldn't be found.");
        }
        //! make an exception for the fucking date parse.
        Book book=new Book(
            oldBook.get().getIsbn(),
            new BookTitle((title.isBlank()||title.isEmpty())?oldBook.get().getTitle().getValue():title),
            new BookAuthor((author.isBlank()||author.isEmpty())?oldBook.get().getAuthor().getValue():author),
            new BookReleaseDate((releaseDate.isBlank()||releaseDate.isEmpty())?oldBook.get().getReleaseDate().getValue():LocalDate.parse(releaseDate,formatterDate)),
            new BookPages((pages<=0||pages==null)?oldBook.get().getPages().getValue():pages),
            BookGender.genderValidatorFromInput((gender.isBlank()||gender.isEmpty())?oldBook.get().getGender().name():gender)
        );
        repository.update(book);
    }

    @Override
    public void removeBook(Byte id) {
        boolean isEmpty=repository.getAll().isEmpty();
        Optional<Book> book=repository.getById(new BookId(id)).stream().findFirst();
        if (isEmpty) {
            throw new BooksNotFoundException("Book list is empty.");
        }
        if (!book.isEmpty()) {
            repository.delete(book.get().getId());
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
        Optional<Book>book=repository.getById(new BookId(id)).stream().findFirst();
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
            repository.delete(book.get().getId());
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
            return book;
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
