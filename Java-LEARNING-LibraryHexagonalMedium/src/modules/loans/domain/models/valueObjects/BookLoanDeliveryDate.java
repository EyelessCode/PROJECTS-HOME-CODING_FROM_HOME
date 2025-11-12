package modules.loans.domain.models.valueObjects;

import java.time.LocalDate;

import modules.loans.domain.exceptions.models.valueObjects.BookLoanDateInvalidException;

public class BookLoanDeliveryDate {
    private final LocalDate value;

    public BookLoanDeliveryDate(LocalDate value){
        if (value==null) {
            throw new BookLoanDateInvalidException("Loan date cannot be a null value.");
        }
        if (!value.isBefore(LocalDate.now())) {
            this.value=value;
        }
        throw new BookLoanDateInvalidException("Loan date cannot be before or today.");
    }

    public LocalDate getValue() {
        return value;
    }
}
