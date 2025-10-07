package models.interfaces;

import java.util.List;
import java.util.Optional;

import models.LoanBook;

public interface ILoanBookService {
    void registerLoanBook(LoanBook loanBook); //? Trying with "VOID"
    void deleteLoanBook(Integer id);
    Optional<LoanBook>findLoanBook(Integer id);
    List<LoanBook>findAllLoanBooks();
    List<LoanBook>findLoanBook(String value);
}
