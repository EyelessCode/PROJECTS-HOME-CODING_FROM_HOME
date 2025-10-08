package shared.exceptions.validators;

import shared.exceptions.GenericStringBoundaryException;

public abstract class GenericStringValidator {
    private String stringNotNull(String value){
        if (value==null||value.isBlank()) {
            throw new GenericStringBoundaryException("String cannot be empty or null.");
        }
        value=value.trim();
        return value;
    }

    protected String stringBound(String value){
        value=stringCleaner(stringNotNull(value));
        if (value.length()>30) {
            throw new GenericStringBoundaryException("String limit has been reached. Please enter a string of fewer than 30 characters.");
        }
        return value;
    }

    protected String stringCleaner(String value){
        value=stringNotNull(value);
        if (!value.matches("[a-zA-Z ]*")) {
            throw new GenericStringBoundaryException("String cannot have special characters.");
        }
        return value;
    }
}
