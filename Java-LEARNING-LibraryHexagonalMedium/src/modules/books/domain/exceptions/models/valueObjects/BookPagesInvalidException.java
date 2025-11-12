package modules.books.domain.exceptions.models.valueObjects;

import modules.books.domain.exceptions.models.BookInvalidException;

public class BookPagesInvalidException extends BookInvalidException{
    public BookPagesInvalidException(String message,BookInvalidException ex){
        super(message,ex);
    }

    public BookPagesInvalidException(String message){
        super(message);
    }

    public BookPagesInvalidException(){
        super();
    }
}
