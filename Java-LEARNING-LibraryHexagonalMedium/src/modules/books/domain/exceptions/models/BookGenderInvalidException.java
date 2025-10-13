package modules.books.domain.exceptions.models;

import modules.books.domain.exceptions.BookCouldNotBeCreatedException;

public class BookGenderInvalidException extends BookCouldNotBeCreatedException {
    public BookGenderInvalidException(String message){
        super(message);
    }

    public BookGenderInvalidException(){
        super();
    }
}
