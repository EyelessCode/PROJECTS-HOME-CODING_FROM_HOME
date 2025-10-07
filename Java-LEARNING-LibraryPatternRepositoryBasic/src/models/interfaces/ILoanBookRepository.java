package models.interfaces;

import java.util.List;
import java.util.Optional;

import models.LoanBook;


public interface ILoanBookRepository {
    LoanBook save(LoanBook loanBook);
    void deleteById(Integer id);
    List<LoanBook>findAll();
    Optional<LoanBook>findById(Integer id);
}
