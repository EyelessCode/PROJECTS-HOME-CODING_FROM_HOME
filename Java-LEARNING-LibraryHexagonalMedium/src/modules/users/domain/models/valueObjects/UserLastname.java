package modules.users.domain.models.valueObjects;

import shared.exceptions.validators.GenericStringValidator;

public class UserLastname extends GenericStringValidator{
    private final String value;

    public UserLastname(String value){
        this.value=stringBound(value);
    }

    public String getValue() {
        return value;
    }
}
