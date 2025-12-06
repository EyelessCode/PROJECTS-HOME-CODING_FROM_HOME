import modules.books.infrastructure.adapters.outbound.repositories.BookRepositoryInMemory;
import modules.loans.app.services.BookLoanService;
import modules.loans.domain.ui.console.BookLoanConsole;
import modules.loans.infrastructure.adapters.outbound.repositories.BookLoanRepositoryInMemory;
import modules.users.infrastructure.adapters.outbound.repositories.UserRepositoryInMemory;

public class BookLoanController extends BookLoanConsole {
    private final BookLoanService loanService;

    public BookLoanController(){
        BookLoanRepositoryInMemory loanRepositoryInMemory=new BookLoanRepositoryInMemory();
        BookRepositoryInMemory bookRepositoryInMemory=new BookRepositoryInMemory();
        UserRepositoryInMemory userRepositoryInMemory=new UserRepositoryInMemory();
        this.loanService=new BookLoanService(loanRepositoryInMemory,bookRepositoryInMemory,userRepositoryInMemory);
    }

    public void loanRun() {
        options();
    }

    @Override
    protected void options() {
        String option;
        while (true) {
            menu();
            option=fromInputOption();
            switch (option) {
                case "1"->showAllLoans();
                case "2"->searchLoans();
                case "3"->{System.out.println("Exiting the Book menu...");return;}
                case "root"->rootOptions();
                default->System.out.println("Invalid option. Please enter a valid option (1-3).");
            }
        }
    }

    private void rootOptions(){
        String option;
        while (true) {
            adminLoanMenu();
            option=fromInputOption();
            switch (option) {
                case "1"->showAllLoans();
                case "3"->searchLoans();
                case "4"->createLoan();
                case "5"->modifyLoan();
                case "6"->deleteLoan();
                case "7"->{System.out.println("Removing the admin privileges...");return;}
                // case "test"->showAllBookGenders();
                default->System.out.println("Invalid option. Please enter a valid option (1-7).");
            }
        }
    }

    private void showAllLoans(){
        loanService.getAllLoans().forEach(loan-> System.out.printf("%s%n",loan.toString()));
    }
}
