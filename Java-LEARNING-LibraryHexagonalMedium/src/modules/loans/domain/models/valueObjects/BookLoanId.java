package modules.loans.domain.models.valueObjects;

import modules.loans.domain.exceptions.models.valueObjects.BookLoanIdInvalidException;
import shared.exceptions.validators.GenericNumericValidator;

public class BookLoanId extends GenericNumericValidator{
    private static Byte currentId=1;
    private final Byte value;

    public BookLoanId(Byte value){
        if (!numberNotNull(value)) {
            this.value=generatedId();
        }else{
            onlyPositiveNumber(value);
            this.value=value;
        }
    }

    public Byte getValue() {
        return value;
    }

    private synchronized Byte generatedId(){
        if (currentId==Byte.MAX_VALUE) {
            throw new BookLoanIdInvalidException("Loan IDs has been reached.");
        }
        return currentId++;
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
        BookLoanId other = (BookLoanId) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
