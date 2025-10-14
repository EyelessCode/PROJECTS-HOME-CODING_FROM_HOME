package modules.books.domain.exceptions;

public class BookCouldNotBeCreatedException extends BookInvalidException{
    public BookCouldNotBeCreatedException(String message,BookInvalidException ex){
        super(message,ex);
    }

    public BookCouldNotBeCreatedException(String message){
        super(message);
    }
    
    public BookCouldNotBeCreatedException(){
        super();
    }
}
