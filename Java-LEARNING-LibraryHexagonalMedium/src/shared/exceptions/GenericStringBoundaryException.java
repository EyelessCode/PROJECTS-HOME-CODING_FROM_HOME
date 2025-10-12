package shared.exceptions;

public class GenericStringBoundaryException extends IllegalArgumentException{
    public GenericStringBoundaryException(String message){
        super(message);
    }

    public GenericStringBoundaryException(){
        super();
    }
}
