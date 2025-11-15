package modules.loans.domain.models.valueObjects;

import modules.loans.domain.exceptions.models.valueObjects.UserIdInvalidException;
import shared.exceptions.validators.GenericNumericValidator;

public class UserId extends GenericNumericValidator{
    private final Byte value;

    public UserId(Byte value){
        if (!numberNotNull(value)) {
            onlyPositiveNumber(value);
            this.value=value;
        }
        throw new UserIdInvalidException("User ID cannot be a null value.");
    }

    public Byte getValue() {
        return value;
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
        UserId other = (UserId) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
