package shared.exceptions;

public class GenericStringBoundaryException extends IllegalArgumentException{
    public GenericStringBoundaryException(String message,IllegalArgumentException ex){
        super(message,ex);
    }
    
    public GenericStringBoundaryException(String message){
        super(message);
    }

    public GenericStringBoundaryException(){
        super();
    }
}
