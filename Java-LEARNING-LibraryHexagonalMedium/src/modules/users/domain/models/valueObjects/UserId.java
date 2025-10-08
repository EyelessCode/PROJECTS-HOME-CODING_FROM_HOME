package modules.users.domain.models.valueObjects;

import shared.exceptions.GenericNumberInvalidException;
import shared.exceptions.validators.GenericNumericValidator;

public class UserId extends GenericNumericValidator{
    private static byte currentId=1;
    private final Byte value;

    public UserId(Byte value) {
        if (value==null) {
            this.value=generateId();
        }else{
            onlyPositiveNumber(value);
            this.value=value;
        }
    }

    public Byte getValue() {
        return value;
    }

    private synchronized Byte generateId(){
        if (currentId==Byte.MAX_VALUE) {
            throw new GenericNumberInvalidException("IDs limit has been reached.");
        }
        return currentId++;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)return true;
        if(!(obj instanceof UserId))return false;
        UserId other=(UserId)obj;
        return this.value==other.value;
    }

    @Override
    public int hashCode() {
        return Byte.hashCode(value);
    }
}
