package modules.loans.domain.exceptions.models;

public class BookLoanInvalidException extends RuntimeException{
    public BookLoanInvalidException(String message, RuntimeException exception){
        super(message, exception);
    }

    public BookLoanInvalidException(String message){
        super(message);
    }

    public BookLoanInvalidException(){}
}
