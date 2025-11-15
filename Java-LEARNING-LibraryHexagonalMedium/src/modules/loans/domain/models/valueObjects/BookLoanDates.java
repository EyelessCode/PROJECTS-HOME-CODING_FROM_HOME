package modules.loans.domain.models.valueObjects;

import java.time.LocalDate;

import modules.loans.domain.exceptions.models.valueObjects.BookLoanDateInvalidException;

public class BookLoanDates {
    private final LocalDate value;

    public BookLoanDates(LocalDate value){
        if (value==null) {
            throw new BookLoanDateInvalidException("Loan date cannot be a null value.");
        }
        this.value=value;
        /* if (!value.isAfter(LocalDate.now())) {
            this.value=value;
        }
        throw new BookLoanDateInvalidException("Loan date cannot be after or today."); */
    }

    public LocalDate getValue() {
        return value;
    }
}
