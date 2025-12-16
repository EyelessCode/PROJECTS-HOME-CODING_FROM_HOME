package modules.books.domain.models.valueObjects;

import modules.books.domain.exceptions.models.valueObjects.BookIsbnInvalidException;
import shared.exceptions.GenericStringBoundaryException;
import shared.exceptions.validators.GenericStringValidator;

public class BookIsbn extends GenericStringValidator{
    private final String value;

    public BookIsbn(String value){
        if (isStringNull(value)) {
            throw new GenericStringBoundaryException("Book's IBN cannot be a null value or blank.");
        }
        value=isbnBound(value);
        if (!(value.length()==10||value.length()==13)) {
            throw new GenericStringBoundaryException("Book's IBN must be between 10 or 13 digits.");
        }
        this.value=value;
    }

    public String getValue() {
        return value;
    }

    private String isbnBound(String param){
        param=param.trim();
        if (!param.matches("^\\d+$*")) {
            throw new BookIsbnInvalidException("Book ISBN must have digits.");
        }
        return param;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)return true;
        if(obj==null)return false;
        if(getClass()!=obj.getClass())return false;
        BookIsbn other=(BookIsbn)obj;
        if(value==null){
            if (other.value!=null) {
                return false;
            }
        }else if(!value.equals(other.value))return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime=31;
        int result=1;
        result=prime*result+((value==null)?0:value.hashCode());
        return result;
    }
}
