package modules.loans.domain.exceptions.models.valueObjects;

import modules.loans.domain.exceptions.models.BookLoanInvalidException;

public class BookLoanIdInvalidException extends BookLoanInvalidException{
    public BookLoanIdInvalidException(String message,BookLoanInvalidException ex){
        super(message, ex);
    }

    public BookLoanIdInvalidException(String message){
        super(message);
    }

    public BookLoanIdInvalidException(){
    }
}
