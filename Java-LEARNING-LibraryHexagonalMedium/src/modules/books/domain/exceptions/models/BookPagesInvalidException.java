package modules.books.domain.exceptions.models;

import modules.books.domain.exceptions.BookInvalidException;

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
