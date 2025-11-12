package modules.loans.domain.exceptions.models;

public class BookLoanCouldntBeCreatedException extends BookLoanInvalidException{
    public BookLoanCouldntBeCreatedException(String message, BookLoanInvalidException exception){
        super(message, exception);
    }

    public BookLoanCouldntBeCreatedException(String message){
        super(message);
    }

    public BookLoanCouldntBeCreatedException(){}
}
