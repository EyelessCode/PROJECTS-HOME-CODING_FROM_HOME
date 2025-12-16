package shared.exceptions.validators;

import shared.exceptions.GenericStringBoundaryException;

public abstract class GenericStringValidator {
    private String stringCleaner(String value){
        // value=isStringNull(value);
        if (!value.matches("[\\p{L} ]*")) {
            throw new GenericStringBoundaryException("String cannot have special characters or numbers. '"+
                    value+"' value is invalid.");
        }
        return value;
    }
    
    protected boolean isStringNull(String value) throws GenericStringBoundaryException{
        // throw new GenericStringBoundaryException("String cannot be empty or null.");
        return value == null || value.isEmpty();
    }

    protected String stringCleanedBound(String value){
        value=stringCleaner(value);
        if (value.length()>30) {
            throw new GenericStringBoundaryException("String limit has been reached. "+
                    "Please enter a string of fewer than 30 characters.");
        }
        return value;
    }

    protected String stringBound(String value){
        // value=isStringNull(value);
        if (value.length()>30) {
            throw new GenericStringBoundaryException("String limit has been reached. "+
                    "Please enter a string of fewer than 30 characters.");
        }
        return value;
    }

    protected String stringLargestBound(String value){
        // value=isStringNull(value);
        if (value.length()>60) {
            throw new GenericStringBoundaryException("String limit has been reached."+
                    "Please enter a string of fewer than 60 characters.");
        }
        return value;
    }

    protected String stringCleanedLargestBound(String value){
        value=stringCleaner(value);
        if (value.length()>60) {
            throw new GenericStringBoundaryException("String limit has been reached."+
                    "Please enter a string of fewer than 60 characters.");
        }
        return value;
    }
}
