package modules.users.domain.models.valueObjects;

import modules.users.domain.exceptions.UserAgeInvalidException;
import shared.exceptions.validators.GenericNumericValidator;

public class UserAge extends GenericNumericValidator{
    private final byte value;

    public UserAge(byte value){
        this.value=ageValidator(value);
    }

    public byte getValue() {
        return value;
    }

    private byte ageValidator(byte param){
        onlyPositiveNumber(param);
        if (param>120) {
            throw new UserAgeInvalidException("User's age isn't real. Please enter a real age.");
        }
        return param;
    }
}
