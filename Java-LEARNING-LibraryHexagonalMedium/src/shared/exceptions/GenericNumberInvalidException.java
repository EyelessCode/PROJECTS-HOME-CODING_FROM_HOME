package shared.exceptions;

public class GenericNumberInvalidException extends NumberFormatException{
    public GenericNumberInvalidException(String message) {
        super(message);
    }
    
    public GenericNumberInvalidException() {
        super();
    }
}
