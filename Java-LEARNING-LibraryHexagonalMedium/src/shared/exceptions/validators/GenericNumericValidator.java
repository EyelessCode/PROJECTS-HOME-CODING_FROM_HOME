package shared.exceptions.validators;

import shared.exceptions.GenericNumberInvalidException;

public abstract class GenericNumericValidator {
    private byte byteBound(Byte value){
        if (value==null) {
            throw new GenericNumberInvalidException("Number positive is expected, not a null value.");
        }
        if (value==Byte.MAX_VALUE) {
            throw new GenericNumberInvalidException("Number limit has been reached.");
        }
        return value;
    }

    protected byte onlyPositiveNumber(Byte value){
        value=byteBound(value);
        if (value<=0) {
            throw new GenericNumberInvalidException("It cannot be a negative number.");
        }
        return value;
    }
}
