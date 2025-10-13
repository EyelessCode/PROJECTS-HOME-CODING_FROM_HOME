package modules.books.domain.exceptions.models;

import modules.books.domain.exceptions.BookCouldNotBeCreatedException;

public class BookPagesInvalidException extends BookCouldNotBeCreatedException{
    public BookPagesInvalidException(String message){
        super(message);
    }

    public BookPagesInvalidException(){
        super();
    }
}
