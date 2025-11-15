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
        if (LocalDate.now().getYear()!=param.getYear()) {
            throw new BookLoanDateInvalidException("Loan date must be current year.");
        }
        if (!LocalDate.now().isAfter(param)) {
            throw new BookLoanDateInvalidException("Loan date cannot be earlier of current date.");
        }
        if (!(LocalDate.now().getMonthValue()<param.getMonth().plus(60).getValue())) {
            throw new BookLoanDateInvalidException("Loan date cannot be earlier of current date.");
        }
    }
}
