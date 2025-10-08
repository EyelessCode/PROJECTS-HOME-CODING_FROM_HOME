package modules.users.domain.models.valueObjects;

import shared.exceptions.GenericStringBoundaryException;
import shared.exceptions.validators.GenericStringValidator;

public class UserIc extends GenericStringValidator{
    private final String value;

    public UserIc(String value) {
        this.value=icBound(value);
    }

    public String getValue() {
        return value;
    }

    private String icBound(String param){
        if (param==null||param.isBlank()) {
            throw new GenericStringBoundaryException("User's IC cannot be empty or null.");
        }
        param=param.trim();
        if (!param.matches("[0-9 ]*")) {
            throw new GenericStringBoundaryException("User's IC must be numeric.");
        }
        if (param.length()==10) {
            return param;
        }
        throw new GenericStringBoundaryException("User's IC must be 10 characters long.");
    }
}
