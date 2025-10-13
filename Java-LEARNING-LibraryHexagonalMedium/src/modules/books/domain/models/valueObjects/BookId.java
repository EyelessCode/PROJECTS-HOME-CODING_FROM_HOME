package modules.books.domain.models.valueObjects;

import shared.exceptions.GenericNumberInvalidException;
import shared.exceptions.validators.GenericNumericValidator;

public class BookId extends GenericNumericValidator{
    private static byte currentId=1;
    private final Byte value;

    public BookId(Byte value){
        if (value==null) {
            this.value=generatedId();
        }else{
            onlyPositiveNumber(value);
            this.value=value;
        }
    }

    private synchronized Byte generatedId(){
        if (currentId==Byte.MAX_VALUE) {
            throw new GenericNumberInvalidException("Book's ID has been reached.");
        }
        return currentId++;
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
        BookId other = (BookId) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
