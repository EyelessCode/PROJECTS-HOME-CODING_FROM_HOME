package modules.books.domain.exceptions.models.valueObjects;

import modules.books.domain.exceptions.models.BookInvalidException;

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
