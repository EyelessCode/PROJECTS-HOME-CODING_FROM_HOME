package modules.loans.domain.models.valueObjects;

import java.time.LocalDate;

import modules.loans.domain.exceptions.models.valueObjects.BookLoanDateInvalidException;

public class BookLoanDates {
    private final LocalDate value;

    public BookLoanDates(LocalDate value){
        if (value==null) {
            throw new BookLoanDateInvalidException("Loan date cannot be a null value.");
        }
        dateValidator(value);
        this.value=value;
    }

    public LocalDate getValue() {
        return value;
    }

    private void dateValidator(LocalDate param){
        if (param.isBefore(LocalDate.now())) {
            throw new BookLoanDateInvalidException("Loan date cannot be earlier of current date.");
        }
        if (param.isAfter(LocalDate.now().plusDays(1_800))) {
            throw new BookLoanDateInvalidException("The maximum loan period allowed is 1,800 days.");
        }
    }
}
