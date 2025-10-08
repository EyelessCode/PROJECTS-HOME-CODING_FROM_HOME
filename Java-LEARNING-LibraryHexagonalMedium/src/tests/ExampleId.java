package tests;

import shared.exceptions.GenericNumberInvalidException;
import shared.exceptions.validators.GenericNumericValidator;

public class ExampleId extends GenericNumericValidator{
    private static byte currentId=1;
    private final Byte value;

    public ExampleId(Byte value){
        this.value=autoincrementId(value);
    }

    public Byte getValue() {
        return value;
    }

    private Byte autoincrementId(Byte value){
        // currentId=byteBound(currentId);
        if (value==null) {
            return currentId++;
        }
        if (value.equals(currentId)) {
            throw new GenericNumberInvalidException("User's ID must not be duplicated.");
        }
        return currentId++;
    }
}
