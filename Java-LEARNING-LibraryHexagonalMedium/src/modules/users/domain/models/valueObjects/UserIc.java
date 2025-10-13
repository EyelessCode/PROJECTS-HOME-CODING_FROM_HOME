package modules.users.domain.models.valueObjects;

import shared.exceptions.GenericStringBoundaryException;
import shared.exceptions.validators.GenericStringValidator;

public class UserIc extends GenericStringValidator{
    private final String value;

    public UserIc(String value) {
        if (stringNotNull(value)) {
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserIc other = (UserIc) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equalsIgnoreCase(other.value))
            return false;
        return true;
    }
}
