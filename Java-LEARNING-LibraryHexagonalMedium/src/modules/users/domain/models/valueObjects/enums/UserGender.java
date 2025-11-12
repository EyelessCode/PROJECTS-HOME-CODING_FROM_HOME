package modules.users.domain.models.valueObjects.enums;

import modules.users.domain.exceptions.models.valueObjects.UserGenderInvalidException;

public enum UserGender {
    M("MALE"),
    F("FEMALE");

    private final String description;

    private UserGender(String description){
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public static UserGender genderValidatorFromInput(String value){
        if (value==null||value.isBlank()) {
            throw new UserGenderInvalidException("Gender input cannot be empty or null.");
        }
        value=value.trim().toUpperCase();
        for (UserGender gender : values()) {
            if (gender.name().equalsIgnoreCase(value)) {
                return gender;
            }
        }
        throw new UserGenderInvalidException("Gender invalid. Please enter (M)ale or (F)emale.");
    }
}
