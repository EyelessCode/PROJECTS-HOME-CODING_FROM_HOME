package modules.books.domain.models.valueObjects;

import java.time.LocalDate;

import modules.books.domain.exceptions.models.valueObjects.BookLocalDateInvalidException;

public class BookReleaseDate {
    private final LocalDate value;

    public BookReleaseDate(LocalDate value){
        if (value==null) {
            throw new BookLocalDateInvalidException("Book's release date cannot be a null value.");
        }else if(!value.isBefore(LocalDate.now())){
            throw new BookLocalDateInvalidException("Book's release '"+value+"' date cannot be later than today.");
        }
        this.value=value;
    }

    public LocalDate getValue() {
        return value;
    }
}
