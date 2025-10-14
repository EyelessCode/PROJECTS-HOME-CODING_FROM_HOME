package modules.books.app.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import modules.books.domain.models.Book;
import modules.books.domain.models.valueObjects.BookAuthor;
import modules.books.domain.models.valueObjects.BookIsbn;
import modules.books.domain.models.valueObjects.BookPages;
import modules.books.domain.models.valueObjects.BookReleaseDate;
import modules.books.domain.models.valueObjects.BookTitle;
import modules.books.domain.models.valueObjects.enums.BookGender;
import modules.books.domain.ports.inport.IBookServiceInport;
import modules.books.domain.ports.outport.IBookRepositoryOutport;

public class BookService implements IBookServiceInport{
    private final IBookRepositoryOutport repository;

    public BookService(IBookRepositoryOutport repository){
        this.repository=repository;
    }

    @Override
    public void saveBook(String isbn, String title, String author, String releaseDate, Short pages, String gender) {
        DateTimeFormatter formatterDate=DateTimeFormatter.ofPattern("yyyy/MM/dd");
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
    public void deleteBook(Byte id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBook'");
    }

    @Override
    public List<Book> getBooks() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBooks'");
    }

    @Override
    public Optional<Book> getBook(Byte id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBook'");
    }

    @Override
    public void deleteBook(String isbn) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBook'");
    }

    @Override
    public List<Book> getBooks(String value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBooks'");
    }

    @Override
    public Optional<Book> getBook(String isbn) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBook'");
    }
    
}
