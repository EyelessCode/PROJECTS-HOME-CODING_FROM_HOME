package modules.books.domain.exceptions.models;

public class BookStateInvalidException extends IllegalStateException{
    public BookStateInvalidException(String message,IllegalStateException ex){
        super(message, ex);
    }

    public BookStateInvalidException(String message){
        super(message);
    }

    public BookStateInvalidException(){
        super();
    }
}