package modules.loans.domain.exceptions.models.valueObjects;

import java.time.DateTimeException;


public class BookLoanDateInvalidException extends DateTimeException{
    public BookLoanDateInvalidException(String message,DateTimeException ex){
        super(message, ex);
    }

    public BookLoanDateInvalidException(String message){
        super(message);
    }

}
