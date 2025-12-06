package modules.loans.infrastructure.adapters.inbound.controllers;

import modules.books.infrastructure.adapters.outbound.repositories.BookRepositoryInMemory;
import modules.loans.app.services.BookLoanService;
import modules.loans.domain.ui.console.BookLoanConsole;
import modules.loans.infrastructure.adapters.outbound.repositories.BookLoanRepositoryInMemory;
import modules.users.infrastructure.adapters.outbound.repositories.UserRepositoryInMemory;

import java.time.LocalDate;

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
                case "1"->subShowOptions();
                case "2"->{System.out.println("Removing the admin privileges...");return;}
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
                case "1"->subShowOptions();
//                case "3"->searchLoans();
                case "3"->{System.out.println("Removing the admin privileges...");return;}
//                case "4"->createLoan();
                case "4"->{System.out.println("Removing the admin privileges...");return;}
//                case "5"->modifyLoan();
                case "5"->{System.out.println("Removing the admin privileges...");return;}
//                case "6"->deleteLoan();
                case "6"->{System.out.println("Removing the admin privileges...");return;}
                case "7"->{System.out.println("Removing the admin privileges...");return;}
                // case "test"->showAllBookGenders();
                default->System.out.println("Invalid option. Please enter a valid option (1-7).");
            }
        }
    }

    @Override
    protected void subShowOptions() {
        String option;
        while (true){
            submenu();
            option=fromInputOption();
            switch (option){
                case "1"->showAllLoansByDate();
                case "2"->showAllLoans();
                case "3"->{System.out.println("Exiting the Submenu...");return;}
                default->System.out.println("Invalid option. Please enter a valid option (1-3).");
            }
        }
    }

    private void showAllLoans(){
        loanService.getAllLoans().forEach(loans->System.out.printf(
                "%n"+"=".repeat(4)+" Loan by %s %s "+"=".repeat(4)+
                "%n"+"ISBN: %s"+"\tTitle: %s"+"\tAuthor: %s"+
                "%n"+"User IC: %s"+"\tfullname: %s %s"+
                "%n"+"Delivery Date: %s"+"\tReturn Date: %s"+
                "%n"+"=".repeat(40)+"%n",
                loans.userLastName(),loans.userName(),
                loans.bookIsbn(),loans.bookTitle(),loans.bookAuthor(),
                loans.userIc(),loans.userName(),loans.userLastName(),
                loans.deliveryDate(),loans.returnDate()
        ));
    }

    private void showAllLoansByDate(){
        try {
            String dateYearString=String.valueOf(LocalDate.now().getYear());
            String dateMonthString=inCaseExit("Enter a month (1-12): ");
            String dateDayString=inCaseExit("Enter a day (1-31): ");
            String dateString=dateYearString+"/"+dateMonthString+"/"+dateDayString;

            loanService.getAllLoansByDate(dateString).forEach(loans->System.out.printf(
                    "%n"+"=".repeat(4)+" Loan by %s %s "+"=".repeat(4)+
                            "%n"+"ISBN: %s"+"\tTitle: %s"+"\tAuthor: %s"+
                            "%n"+"User IC: %s"+"\tfullname: %s %s"+
                            "%n"+"Delivery Date: %s"+"\tReturn Date: %s"+
                            "%n"+"=".repeat(40)+"%n",
                    loans.userLastName(),loans.userName(),
                    loans.bookIsbn(),loans.bookTitle(),loans.bookAuthor(),
                    loans.userIc(),loans.userName(),loans.userLastName(),
                    loans.deliveryDate(),loans.returnDate()
            ));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
