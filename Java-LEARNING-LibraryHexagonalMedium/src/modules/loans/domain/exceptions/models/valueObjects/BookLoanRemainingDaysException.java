package modules.loans.domain.exceptions.models.valueObjects;

import modules.loans.domain.exceptions.models.BookLoanInvalidException;

public class BookLoanRemainingDaysException extends BookLoanInvalidException{
    public BookLoanRemainingDaysException(String message, RuntimeException ex){
        super(message, ex);
    }

    public BookLoanRemainingDaysException(String message){
        super(message);
    }

    public BookLoanRemainingDaysException(){}
}
