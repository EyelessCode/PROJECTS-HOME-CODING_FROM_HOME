package modules.books.domain.exceptions.models;

import modules.books.domain.exceptions.BookInvalidException;

public class BookGenderInvalidException extends BookInvalidException {
    public BookGenderInvalidException(String message,BookInvalidException ex){
        super(message,ex);
    }

    public BookGenderInvalidException(String message){
        super(message);
    }

    public BookGenderInvalidException(){
        super();
    }
}
