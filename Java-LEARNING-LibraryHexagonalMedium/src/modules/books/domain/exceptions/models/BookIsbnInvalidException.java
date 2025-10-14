package modules.books.domain.exceptions.models;

import modules.books.domain.exceptions.BookInvalidException;

public class BookIsbnInvalidException extends BookInvalidException{
    public BookIsbnInvalidException(String message,BookInvalidException ex){
        super(message, ex);
    }

    public BookIsbnInvalidException(String message){
        super(message);
    }

    public BookIsbnInvalidException(){
        super();
    }
}
