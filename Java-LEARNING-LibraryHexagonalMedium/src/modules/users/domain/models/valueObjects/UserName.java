package modules.users.domain.models.valueObjects;

import shared.exceptions.validators.GenericStringValidator;

public class UserName extends GenericStringValidator{
    private final String value;

    public UserName(String value){
        this.value=stringBound(value);
    }

    public String getValue() {
        return value;
    }
}
