package modules.books.domain.exceptions.models;

import modules.books.domain.exceptions.BookInvalidException;

public class BookIbnInvalidException extends BookInvalidException{
    public BookIbnInvalidException(String message,BookInvalidException ex){
        super(message, ex);
    }

    public BookIbnInvalidException(String message){
        super(message);
    }

    public BookIbnInvalidException(){
        super();
    }
}
