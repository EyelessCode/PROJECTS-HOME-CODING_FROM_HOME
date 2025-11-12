package modules.loans.domain.exceptions.models.valueObjects;

import modules.loans.domain.exceptions.models.BookLoanInvalidException;

public class UserIdInvalidException extends BookLoanInvalidException{
    public UserIdInvalidException(String message, BookLoanInvalidException exception){
        super(message, exception);
    }

    public UserIdInvalidException(String message){
        super(message);
    }

    public UserIdInvalidException(){}
}
