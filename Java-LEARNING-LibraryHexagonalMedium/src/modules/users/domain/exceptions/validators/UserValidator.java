package modules.users.domain.exceptions.validators;

import modules.users.domain.exceptions.UserGenderInvalidException;

public abstract class UserValidator {
    protected char genderValidator(char value){
        char gender=Character.toUpperCase(value);
        if (gender=='M'||gender=='F') {
            return gender;
        }
        throw new UserGenderInvalidException("Gender invalid. Please enter (M)ale or (F)emale.");
    }
}
