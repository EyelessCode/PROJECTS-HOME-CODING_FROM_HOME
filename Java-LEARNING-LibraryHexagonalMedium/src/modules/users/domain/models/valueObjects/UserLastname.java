package modules.users.domain.models.valueObjects;

import modules.users.domain.exceptions.models.UserNameInvalidException;
import shared.exceptions.validators.GenericStringValidator;

public class UserLastname extends GenericStringValidator{
    private final String value;

    public UserLastname(String value){
        if (!stringNotNull(value)) {
            throw new UserNameInvalidException("User's name cannot be a null value or blank.");
        }
        this.value=stringCleanedBound(value);
    }

    public String getValue() {
        return value;
    }
}
