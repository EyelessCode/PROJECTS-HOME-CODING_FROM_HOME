package modules.books.domain.exceptions.models;

import modules.books.domain.exceptions.BookInvalidException;

public class BookLocalDateInvalidException extends BookInvalidException{
    public BookLocalDateInvalidException(String message,BookInvalidException ex){
        super(message,ex);
    }

    public BookLocalDateInvalidException(String message){
        super(message);
    }

    public BookLocalDateInvalidException(){
        super();
    }
}
