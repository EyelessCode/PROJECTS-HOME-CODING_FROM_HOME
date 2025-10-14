package modules.books.domain.exceptions;

public class BooksNotFoundException extends BookInvalidException{
    public BooksNotFoundException(String message,BookInvalidException ex){
        super(message,ex);
    }

    public BooksNotFoundException(String message){
        super(message);
    }

    public BooksNotFoundException(){
        super();
    }
}
