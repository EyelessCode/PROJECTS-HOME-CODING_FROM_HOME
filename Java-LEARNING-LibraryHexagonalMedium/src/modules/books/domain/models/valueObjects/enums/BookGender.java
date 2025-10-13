package modules.books.domain.models.valueObjects.enums;

import modules.books.domain.exceptions.models.BookGenderInvalidException;

public enum BookGender {
    NARRATIVE("NARRATIVE"),
    LYRICAL("LYRICAL"),
    DRAMATIC("DRAMATIC"),
    DIDACTIC("DIDACTIC"),
    FANTASY("FANTASY"),
    SCIENCE_FICTION("SCIENCE FICTION"),
    ROMANCE("ROMANCE"),
    MYSTERY("MYSTERY");

    private final String description;

    private BookGender(String description){
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public static BookGender genderValidatorFromInput(String gender){
        if (gender==null||gender.isBlank()) {
            throw new BookGenderInvalidException("Gender input cannot be a null value or blank.");
        }
        gender=gender.trim().toUpperCase();
        for (BookGender bookGender : values()) {
            if (bookGender.name().equalsIgnoreCase(gender)) {
                return bookGender;
            }
        }
        throw new BookGenderInvalidException("Book's gender invalid. Please try it again.");
    }
}
