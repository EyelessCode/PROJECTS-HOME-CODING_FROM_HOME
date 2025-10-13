package shared.exceptions.validators;

import shared.exceptions.GenericNumberInvalidException;

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

    protected boolean byteNotNull(Byte value){
        if (value==null) {
            return false;
        }
        return true;
    }

    protected boolean shortNotNull(Short value){
        if (value==null) {
            return false;
        }
        return true;
    }

    protected void onlyPositiveByte(Byte value){
        value=byteBound(value);
        if (value<=0) {
            throw new GenericNumberInvalidException("It cannot be a negative number.");
        }
    }

    protected void onlyPositiveShort(Short value){
        value=shortBound(value);
        if (value<=0) {
            throw new GenericNumberInvalidException("It cannot be a negative number.");
        }
    }
}
