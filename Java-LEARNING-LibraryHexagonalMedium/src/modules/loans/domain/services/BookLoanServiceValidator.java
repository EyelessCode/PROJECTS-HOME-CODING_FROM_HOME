package modules.loans.domain.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import modules.loans.domain.exceptions.models.BookLoanInvalidException;
import modules.loans.domain.exceptions.models.valueObjects.BookLoanDateInvalidException;
import modules.loans.domain.models.BookLoan;

public abstract class BookLoanServiceValidator {
    private final DateTimeFormatter formatterDate=DateTimeFormatter.ofPattern("yyyy-M-d");

    protected boolean overlaps(BookLoan a,BookLoan b){
        return(!a.getDeliveryDate().getValue().isAfter(b.getReturnDate().getValue())&&
        !a.getReturnDate().getValue().isBefore(b.getDeliveryDate().getValue()));
    }

    protected void isNotNull(String userIc, String bookIsbn, String deliveryDateString, String returnDateString){
        if ((userIc==null||bookIsbn==null)&&(deliveryDateString==null||returnDateString==null)) {
            throw new BookLoanInvalidException("Invalid Loan. Please try again.");
        }
    }

    protected LocalDate dateValidator(String date) throws BookLoanDateInvalidException{
        if (!date.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")) {
           throw new BookLoanDateInvalidException("Date invalid '"+date+"'. Please try again with YYYY/MM/DD.");
        }
        return LocalDate.parse(date,formatterDate);
    }
}
