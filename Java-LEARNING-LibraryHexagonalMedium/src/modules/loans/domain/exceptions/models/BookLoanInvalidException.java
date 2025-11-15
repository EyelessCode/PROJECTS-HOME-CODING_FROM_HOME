package modules.loans.domain.exceptions.models;

public class BookLoanInvalidException extends RuntimeException{
    public BookLoanInvalidException(String message, RuntimeException ex){
        super(message, ex);
    }

    public BookLoanInvalidException(String message){
        super(message);
    }

    public BookLoanInvalidException(){}
}
