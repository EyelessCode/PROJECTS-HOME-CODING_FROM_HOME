package modules.books.domain.models.valueObjects;

import shared.exceptions.validators.GenericStringValidator;

public class BookTitle extends GenericStringValidator{
    private final String value;

    public BookTitle(String value){
        value=stringLargestBound(value).toUpperCase();
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
