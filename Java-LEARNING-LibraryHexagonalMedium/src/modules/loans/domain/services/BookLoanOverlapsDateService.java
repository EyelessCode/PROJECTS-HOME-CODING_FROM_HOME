package modules.loans.domain.services;

import modules.loans.domain.models.BookLoan;

public class BookLoanOverlapsDateService {
    public boolean overlaps(BookLoan a,BookLoan b){
        return(!a.getDeliveryDate().getValue().isAfter(b.getReturnDate().getValue())&&
        !a.getReturnDate().getValue().isBefore(b.getDeliveryDate().getValue()));
    }
}
