package modules.books.domain.exceptions.models.valueObjects;

import modules.books.domain.exceptions.models.BookInvalidException;

public class BookIdInvalidException extends BookInvalidException{
    public BookIdInvalidException(String message,BookInvalidException ex){
        super(message, ex);
    }

    public BookIdInvalidException(String message){
        super(message);
    }

    public BookIdInvalidException(){
    }
}
