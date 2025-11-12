package modules.books.domain.models.valueObjects;

import modules.books.domain.exceptions.models.valueObjects.BookStateInvalidException;

public class BookAvailability {
    private final Boolean value;

    public BookAvailability(Boolean value){
        if (value==null) {
            throw new BookStateInvalidException("Book state cannot be a null value.");
        }
        this.value=value;
    }

    public boolean isValue() {
        return value;
    }

    public BookAvailability lend(){
        if (!value) {
            throw new BookStateInvalidException("Book is already on loan.");
        }
        return new BookAvailability(false);
    }

    public BookAvailability returnBook(){
        if (value) {
            throw new BookStateInvalidException("Book is now available.");
        }
        return new BookAvailability(true);
    }

    @Override
    public String toString() {
        return value?"Available":"On loan";
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
        BookAvailability other = (BookAvailability) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
