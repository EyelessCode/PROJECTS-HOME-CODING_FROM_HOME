package modules.books.domain.exceptions.models;

import modules.books.domain.exceptions.BookCouldNotBeCreatedException;

public class BookLocalDateInvalidException extends BookCouldNotBeCreatedException{
    public BookLocalDateInvalidException(String message){
        super(message);
    }

    public BookLocalDateInvalidException(){
        super();
    }
}
