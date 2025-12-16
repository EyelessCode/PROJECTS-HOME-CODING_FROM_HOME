package modules.users.domain.models.valueObjects;

import modules.users.domain.exceptions.models.valueObjects.UserNameInvalidException;
import shared.exceptions.validators.GenericStringValidator;

public class UserLastname extends GenericStringValidator{
    private final String value;

    public UserLastname(String value){
        if (isNotStringNull(value)) {
            throw new UserNameInvalidException("User's lastname cannot be a null value or blank.");
        }
        this.value=stringCleanedBound(value);
    }

    public String getValue() {
        return value;
    }
}
