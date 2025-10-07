package services;

import java.util.List;
import java.util.Optional;

import models.LoanBook;
import models.interfaces.ILoanBookRepository;
import models.interfaces.ILoanBookService;

public class LoanBookService implements ILoanBookService{
    private final ILoanBookRepository repository;

    public LoanBookService(ILoanBookRepository repository){
        this.repository=repository;
    }

    @Override
    public void registerLoanBook(LoanBook loanBook) {
        if (loanBook!=null) {
            repository.save(loanBook);
        }else{
            throw new NullPointerException("User book loan couldn't be created.");
        }
    }

    @Override
    public void deleteLoanBook(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<LoanBook> findLoanBook(Integer id) {
        if (!repository.findById(id).isEmpty()) {
            return repository.findById(id);
        }
        throw new NullPointerException("User book loan wasn't found.");
    }

    @Override
    public List<LoanBook> findAllLoanBooks() {
        if (!repository.findAll().isEmpty()) {
            return repository.findAll();
        }
        throw new NullPointerException("No user book loans were found.");
    }

    @Override
    public List<LoanBook> findLoanBook(String value) {
        String search=value.trim().toLowerCase();
        List<LoanBook>found=repository.findAll().stream().filter(lb->lb.getUser().getName().toLowerCase().contains(search)||lb.getUser().getLastname().toLowerCase().contains(search)||lb.getBook().getTitle().toLowerCase().contains(search)||lb.getBook().getAuthor().toLowerCase().contains(search)).toList();
        if (!found.isEmpty()) {
            return found;
        }
        throw new NullPointerException("User book loan wasn't found.");
    }
    
}
