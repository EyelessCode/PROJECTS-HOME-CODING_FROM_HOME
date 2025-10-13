package modules.books.domain.models.valueObjects;

import shared.exceptions.validators.GenericStringValidator;

public class BookAuthor extends GenericStringValidator{
    private final String value;

    public BookAuthor(String value){
        value=stringCleanedLargestBound(value);
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
