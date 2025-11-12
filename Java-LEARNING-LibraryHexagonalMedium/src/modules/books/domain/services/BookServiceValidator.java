package modules.books.domain.services;

import java.util.HashSet;
import java.util.Set;

import modules.books.domain.exceptions.models.BookCouldNotBeCreatedException;
import modules.books.domain.exceptions.models.valueObjects.BookIsbnInvalidException;
import modules.books.domain.models.valueObjects.BookIsbn;

public abstract class BookServiceValidator {
    protected final Set<BookIsbn>isbnRegistry=new HashSet<>();

    protected void isDuplicated(String isbn){
        BookIsbn bookIsbn=new BookIsbn(isbn);
        if (isbnRegistry.contains(bookIsbn)) {
            throw new BookIsbnInvalidException("This book already has been registered.");
        }
        isbnRegistry.add(bookIsbn);
    }

    protected void isNotNull(String isbn,String title,String author,String releaseDate,Short pages,String gender){
        if (
            (isbn==null&&title==null&&author==null&&releaseDate==null&&pages==null&&gender==null)||
            ((isbn==null||title==null)||(author==null||releaseDate==null)||(pages==null||gender==null))
        ) {
            throw new BookCouldNotBeCreatedException("Book couldn't be created.");
        }
    }
}
