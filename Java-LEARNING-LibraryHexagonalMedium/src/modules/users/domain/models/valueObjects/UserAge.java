package modules.users.domain.models.valueObjects;

import modules.users.domain.exceptions.models.valueObjects.UserAgeInvalidException;
import shared.exceptions.validators.GenericNumericValidator;

public class UserAge extends GenericNumericValidator{
    private final Byte value;

    public UserAge(Byte value){
        if (!isNotNumberNull(value)) {
            throw new UserAgeInvalidException("User's age cannot be a null value or blank.");
        }
        ageValidator(value);
        this.value=value;
    }

    public Byte getValue() {
        return value;
    }

    private void ageValidator(Byte param){
        onlyPositiveNumber(param);
        if (!(param>120)) {
            return;
        }
        throw new UserAgeInvalidException("User '"+param+"' age isn't real. Please enter a real age.");
    }
}
