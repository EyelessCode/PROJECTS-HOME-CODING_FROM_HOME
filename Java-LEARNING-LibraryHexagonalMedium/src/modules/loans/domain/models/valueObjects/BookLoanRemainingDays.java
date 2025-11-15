package modules.loans.domain.models.valueObjects;

import java.time.temporal.ChronoUnit;

import modules.loans.domain.exceptions.models.valueObjects.BookLoanRemainingDaysException;
import shared.exceptions.validators.GenericNumericValidator;

public class BookLoanRemainingDays extends GenericNumericValidator{
    private final Long value;

    public BookLoanRemainingDays(BookLoanDates deliveryDate,BookLoanDates returnDate){
        long days=ChronoUnit.DAYS.between(deliveryDate.getValue(),returnDate.getValue());
        if (!numberNotNull(days)) {
            throw new BookLoanRemainingDaysException("Loan Remaining days cannot be a null value.");
        }
        onlyPositiveNumber(days);
        this.value=days;
    }

    public Long getValue() {
        return value;
    }
}
