package modules.books.domain.exceptions;

public class BookCouldNotBeCreatedException extends RuntimeException{
    public BookCouldNotBeCreatedException(String message){
        super(message);
    }
    
    public BookCouldNotBeCreatedException(){
        super();
    }
}
