package modules.loans.domain.exceptions.models.valueObjects;

import modules.loans.domain.exceptions.models.BookLoanInvalidException;

public class BookLoanDateInvalidException extends BookLoanInvalidException{
    public BookLoanDateInvalidException(String message,BookLoanInvalidException ex){
        super(message, ex);
    }

    public BookLoanDateInvalidException(String message){
        super(message);
    }

    public BookLoanDateInvalidException(){}
}
