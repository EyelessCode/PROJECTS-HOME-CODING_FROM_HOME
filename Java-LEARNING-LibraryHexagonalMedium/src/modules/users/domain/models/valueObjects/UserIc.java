package modules.users.domain.models.valueObjects;

import shared.exceptions.GenericStringBoundaryException;
import shared.exceptions.validators.GenericStringValidator;

public class UserIc extends GenericStringValidator{
    private final String value;

    public UserIc(String value) {
        if (value==null||value.isBlank()) {
            throw new GenericStringBoundaryException("User's IC cannot be empty or null.");
        }
        this.value=icBound(value);
    }

    public String getValue() {
        return value;
    }

    private String icBound(String param){
        param=param.trim();
        if (!param.matches("[0-9 ]*")) {
            throw new GenericStringBoundaryException("User's IC must be numeric.");
        }
        if (param.length()==10) {
            return param;
        }
        throw new GenericStringBoundaryException("User's IC must be 10 characters long.");
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)return true;
        if(!(obj instanceof UserIc))return false;
        UserIc other=(UserIc)obj;
        return this.value.equalsIgnoreCase(other.value);
    }

    @Override
    public int hashCode() {
        return value.toLowerCase().hashCode();
    }
}
