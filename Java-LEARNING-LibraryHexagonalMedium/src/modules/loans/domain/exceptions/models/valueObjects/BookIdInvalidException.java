package modules.loans.domain.exceptions.models.valueObjects;

import modules.loans.domain.exceptions.models.BookLoanInvalidException;

public class BookIdInvalidException extends BookLoanInvalidException{
    public BookIdInvalidException(String message, BookLoanInvalidException exception){
        super(message, exception);
    }

    public BookIdInvalidException(String message){
        super(message);
    }

    public BookIdInvalidException(){}
}
