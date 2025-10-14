package modules.books.domain.exceptions;

public class BookInvalidException extends RuntimeException{
    public BookInvalidException(String message,RuntimeException ex){
        super(message, ex);
    }

    public BookInvalidException(String message){
        super(message);
    }

    public BookInvalidException(){
        super();
    }
}
