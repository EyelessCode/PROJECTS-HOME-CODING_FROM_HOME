package modules.books.domain.exceptions;

public class BooksNotFoundException extends BookCouldNotBeCreatedException{
    public BooksNotFoundException(String message){
        super(message);
    }

    public BooksNotFoundException(){
        super();
    }
}
