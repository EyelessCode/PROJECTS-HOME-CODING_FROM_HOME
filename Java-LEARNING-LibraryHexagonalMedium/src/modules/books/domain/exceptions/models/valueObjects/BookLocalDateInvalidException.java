package modules.books.domain.exceptions.models.valueObjects;

import java.time.DateTimeException;


// import modules.books.domain.exceptions.models.BookInvalidException;

public class BookLocalDateInvalidException extends DateTimeException{
    public BookLocalDateInvalidException(String message,DateTimeException ex){
        super(message,ex);
    }

    public BookLocalDateInvalidException(String message){
        super(message);
    }
}
