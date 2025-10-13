package modules.users.domain.models.valueObjects;

import modules.users.domain.exceptions.models.UserAgeInvalidException;
import shared.exceptions.validators.GenericNumericValidator;

public class UserAge extends GenericNumericValidator{
    private final Byte value;

    public UserAge(Byte value){
        if (byteNotNull(value)) {
            throw new UserAgeInvalidException("User's age cannot be a null value or blank.");
        }
        value=ageValidator(value);
        this.value=value;
    }

    public Byte getValue() {
        return value;
    }

    private byte ageValidator(Byte param){
        onlyPositiveByte(param);
        if (param>120) {
            throw new UserAgeInvalidException("User's age isn't real. Please enter a real age.");
        }
        return param;
    }
}
