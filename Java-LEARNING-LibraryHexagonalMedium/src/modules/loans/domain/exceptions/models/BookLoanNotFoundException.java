package modules.loans.domain.exceptions.models;

public class BookLoanNotFoundException extends BookLoanInvalidException {
    public BookLoanNotFoundException(String message, BookLoanInvalidException exception){
        super(message, exception);
    }

    public BookLoanNotFoundException(String message){
        super(message);
    }

    public BookLoanNotFoundException(){}
}
