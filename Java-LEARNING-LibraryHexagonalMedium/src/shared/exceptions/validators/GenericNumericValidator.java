package shared.exceptions.validators;

import shared.exceptions.GenericNumberInvalidException;
import shared.exceptions.GenericStringBoundaryException;

public abstract class GenericNumericValidator {
    private byte byteBound(Byte value){
        if (value==Byte.MAX_VALUE) {
            throw new GenericNumberInvalidException("Number limit has been reached.");
        }
        return value;
    }

    private short shortBound(Short value){
        if (value==Short.MAX_VALUE) {
            throw new GenericNumberInvalidException("Number limit has been reached.");
        }
        return value;
    }

    private long longBound(Long value){
        if (value==Long.MAX_VALUE) {
            throw new GenericNumberInvalidException("Number limit has been reached.");
        }
        return value;
    }

    protected boolean isNotNumberNull(Byte value)throws GenericStringBoundaryException {
        return value != null;
    }

    protected boolean isNotNumberNull(Short value)throws GenericStringBoundaryException{
        return value != null;
    }

    protected boolean isNotNumberNull(Long value)throws GenericStringBoundaryException{
        return value != null;
    }

    protected void onlyPositiveNumber(Byte value){
        value=byteBound(value);
        if (value<=0) {
            throw new GenericNumberInvalidException("It cannot be a negative number.");
        }
    }

    protected void onlyPositiveNumber(Short value){
        value=shortBound(value);
        if (value<=0) {
            throw new GenericNumberInvalidException("It cannot be a negative number.");
        }
    }

    protected void onlyPositiveNumber(Long value){
        value=longBound(value);
        if (value<=0) {
            throw new GenericNumberInvalidException("It cannot be a negative number.");
        }
    }
}
