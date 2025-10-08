package modules.users.domain.models.valueObjects;

import shared.exceptions.GenericNumberInvalidException;
import shared.exceptions.validators.GenericNumericValidator;

public class UserId extends GenericNumericValidator{
    private static byte currentId=1;
    private final Byte value;

    public UserId(Byte value) {
        this.value = (value != null) ? value : generateId();
    }

    public Byte getValue() {
        return value;
    }

    private synchronized Byte generateId() {
        if (value==null) {
            return currentId++;
            
        }
        if (currentId == Byte.MAX_VALUE) {
            throw new IllegalStateException("Se alcanzó el límite de IDs.");
        }
        return currentId++;
    }

    /* private synchronized autoincrementId(){
        currentId=onlyPositiveNumber(currentId);
        if (param==null) {
            return currentId++;
        }
        if (param.equals(currentId)) {
            throw new GenericNumberInvalidException("User's ID must not be duplicated.");
        }
        return currentId++;
    } */
}
