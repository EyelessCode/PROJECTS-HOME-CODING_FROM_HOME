package modules.books.app.services;

import java.time.LocalDate;
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

    public BookService(IBookRepositoryOutport repository){
        this.repository=repository;
    }

    @Override
    public void saveBook(String isbn, String title, String author, String releaseDateString, Short pages, String gender) {
        isNotNull(isbn, title, author, releaseDateString, pages, gender);
        LocalDate releaseDate=dateValidator(releaseDateString);
        Book book=new Book(
            new BookIsbn(isbn),
            new BookTitle(title),
            new BookAuthor(author),
            new BookReleaseDate(releaseDate),
            new BookPages(pages),
            BookGender.genderValidatorFromInput(gender)
        );
        repository.create(book);
    }

    @Override
    public void modifyBook(String isbn, String title, String author, String releaseDateString, Short pages, String gender) {
        boolean isEmpty=repository.getAll().isEmpty();
        LocalDate releaseDate=dateValidator(releaseDateString);
        Optional<Book> oldBook=repository.getAll().stream().filter(b->b.getIsbn().getValue().equals(isbn)).findFirst();

        if (isEmpty) {
            throw new BooksNotFoundException("Book list is empty.");
        }
        if (oldBook.isEmpty()) {
            throw new BooksNotFoundException("Book '"+isbn+"' ISBN couldn't be found.");
        }
        Book book=new Book(
            oldBook.get().getId(),
            oldBook.get().getIsbn(),
            new BookTitle(title.isBlank() ?oldBook.get().getTitle().getValue():title),
            new BookAuthor(author.isBlank() ?oldBook.get().getAuthor().getValue():author),
            new BookReleaseDate(releaseDateString.isBlank() ?oldBook.get().getReleaseDate().getValue():releaseDate),
            new BookPages(pages<=0 ?oldBook.get().getPages().getValue():pages),
            BookGender.genderValidatorFromInput(gender.isBlank() ?oldBook.get().getGender().name():gender)
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
        if (book.isPresent()) {
            repository.delete(book.get().getId());
            return;
        }
        throw new BooksNotFoundException("Book '"+id+"' ID couldn't be found.");
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
        if (book.isPresent()) {
            return book;
        }
        throw new BooksNotFoundException("Book '"+id+"' ID couldn't be found.");
    }

    @Override
    public void removeBook(String isbn) {
        boolean isEmpty=repository.getAll().isEmpty();
        Optional<Book> book=repository.getAll().stream().
            filter(b->b.getIsbn().getValue().equals(isbn)).findFirst();
        if (isEmpty) {
            throw new BooksNotFoundException("Book list is empty.");
        }
        if (book.isPresent()) {
            repository.delete(book.get().getId());
            return;
        }
        throw new BooksNotFoundException("Book '"+isbn+"' couldn't be found.");
    }

    @Override
    public List<Book> getBooks(String value) {
        String search=value.toLowerCase();
        boolean isEmpty=repository.getAll().isEmpty();
        List<Book>books=repository.getAll().stream().
            filter(bs->(bs.getIsbn().getValue().equals(search)||
                    bs.getTitle().getValue().toLowerCase().contains(search))||
                    (bs.getAuthor().getValue().toLowerCase().contains(search)||
                    bs.getGender().getDescription().toLowerCase().contains(search))).toList();
        if (isEmpty) {
            throw new BooksNotFoundException("Book list is empty.");
        }
        if (!books.isEmpty()) {
            return books;
        }
        throw new BooksNotFoundException("Book '"+value+"' couldn't be found.");
    }

    @Override
    public Optional<Book> getBook(String isbn) {
        boolean isEmpty=repository.getAll().isEmpty();
        Optional<Book>book=repository.getAll().stream().
            filter(b->b.getIsbn().getValue().equals(isbn)).findFirst();
        if (isEmpty) {
            throw new BooksNotFoundException("Book list is empty.");
        }
        if (book.isPresent()) {
            return book;
        }
        throw new BooksNotFoundException("Book '"+isbn+"' couldn't be found.");
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
