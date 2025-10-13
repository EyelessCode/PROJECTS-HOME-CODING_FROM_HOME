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
        if(obj==null)return false;
        if(getClass()!=obj.getClass())return false;
        UserId other=(UserId)obj;
        if (value==null){
            if (other.value!=null) {
                return false;
            }
        }else if(!value.equals(other.value))return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime=31;
        int result=1;
        result=prime*result+((value==null)?0:value.hashCode());
        return result;
    }
}
