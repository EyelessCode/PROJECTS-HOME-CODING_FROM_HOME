package modules.loans.domain.models.valueObjects;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import modules.loans.domain.exceptions.models.valueObjects.BookLoanRemainingDaysException;
import shared.exceptions.validators.GenericNumericValidator;

public class BookLoanRemainingDays extends GenericNumericValidator{
    private final Long value;

    public BookLoanRemainingDays(Long value,LocalDate deliveryDate,LocalDate returnDate){
        if (!numberNotNull(value)) {
            throw new BookLoanRemainingDaysException("Loan Remaining days cannot be a null value.");
        }
        onlyPositiveNumber(value);
        this.value=ChronoUnit.DAYS.between(deliveryDate,returnDate);
    }

    public Long getValue() {
        return value;
    }
}
