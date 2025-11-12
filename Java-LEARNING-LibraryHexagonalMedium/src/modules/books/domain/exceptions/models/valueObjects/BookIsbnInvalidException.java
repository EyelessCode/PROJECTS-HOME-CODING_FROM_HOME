package modules.books.domain.exceptions.models.valueObjects;

import modules.books.domain.exceptions.models.BookInvalidException;

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
