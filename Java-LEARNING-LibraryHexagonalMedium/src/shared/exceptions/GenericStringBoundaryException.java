package shared.exceptions;

public class GenericStringBoundaryException extends RuntimeException{
    public GenericStringBoundaryException(String message){
        super(message);
    }

    public GenericStringBoundaryException(){
        super();
    }
}
