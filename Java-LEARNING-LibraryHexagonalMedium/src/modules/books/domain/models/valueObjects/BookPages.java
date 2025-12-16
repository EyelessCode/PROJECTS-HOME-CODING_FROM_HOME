package modules.books.domain.models.valueObjects;

import modules.books.domain.exceptions.models.valueObjects.BookPagesInvalidException;
import shared.exceptions.validators.GenericNumericValidator;

public class BookPages extends GenericNumericValidator{
    private final Short value;

    public BookPages(Short value){
        if (!isNotNumberNull(value)) {
            throw new BookPagesInvalidException("Book's pages cannot be a null value or blank.");
        }
        if (value>10_000) {
            throw new BookPagesInvalidException("Book's pages exceed the established limit.");
        }
        onlyPositiveNumber(value);
        this.value=value;
    }

    public Short getValue() {
        return value;
    }
}
