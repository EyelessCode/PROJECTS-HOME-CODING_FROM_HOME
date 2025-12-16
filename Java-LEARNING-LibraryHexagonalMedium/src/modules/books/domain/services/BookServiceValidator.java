package modules.books.domain.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import modules.books.domain.exceptions.models.BookCouldNotBeCreatedException;
import modules.books.domain.exceptions.models.valueObjects.BookIsbnInvalidException;
import modules.books.domain.exceptions.models.valueObjects.BookLocalDateInvalidException;
import modules.books.domain.models.valueObjects.BookIsbn;

public abstract class BookServiceValidator {
    protected final Set<BookIsbn>isbnRegistry=new HashSet<>();
//    private final DateTimeFormatter formatterDate=DateTimeFormatter.ofPattern("yyyy/MM/dd");

    protected void isDuplicated(String isbn){
        BookIsbn bookIsbn=new BookIsbn(isbn);
        if (isbnRegistry.contains(bookIsbn)) {
            throw new BookIsbnInvalidException("This book already has been registered.");
        }
        isbnRegistry.add(bookIsbn);
    }

    protected void isNotNull(String isbn,String title,String author,String releaseDate,Short pages,String gender){
        if (
                ((isbn == null || title == null) && (author == null || releaseDate == null) && (pages == null || gender == null))
        ) {
            throw new BookCouldNotBeCreatedException("Book couldn't be created.");
        }
    }

    protected LocalDate dateValidator(String releaseDate) throws BookLocalDateInvalidException{
        if (!releaseDate.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            throw new BookLocalDateInvalidException("Date invalid '"+releaseDate+"'. Please try again with YYYY-MM-DD.");
        }
        return LocalDate.parse(releaseDate);
    }
}
