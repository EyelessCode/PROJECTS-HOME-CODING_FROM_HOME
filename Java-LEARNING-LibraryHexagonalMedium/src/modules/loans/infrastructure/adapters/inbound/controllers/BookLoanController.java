package modules.loans.infrastructure.adapters.inbound.controllers;

import modules.books.infrastructure.adapters.outbound.repositories.BookRepositoryInMemory;
import modules.loans.app.services.BookLoanService;
import modules.loans.app.services.dtos.BookLoanDTO;
import modules.loans.domain.exceptions.models.BookLoanInvalidException;
import modules.loans.domain.exceptions.models.BookLoanNotFoundException;
import modules.loans.domain.ui.console.BookLoanConsole;
import modules.loans.infrastructure.adapters.outbound.repositories.BookLoanRepositoryInMemory;
import modules.users.infrastructure.adapters.outbound.repositories.UserRepositoryInMemory;
import shared.exceptions.GenericStringBoundaryException;

import java.time.LocalDate;
import java.util.List;

public class BookLoanController extends BookLoanConsole {
    private final BookLoanService service;

    public BookLoanController(){
        BookLoanRepositoryInMemory loanRepositoryInMemory=new BookLoanRepositoryInMemory();
        BookRepositoryInMemory bookRepositoryInMemory=new BookRepositoryInMemory();
        UserRepositoryInMemory userRepositoryInMemory=new UserRepositoryInMemory();
        this.service =new BookLoanService(loanRepositoryInMemory,bookRepositoryInMemory,userRepositoryInMemory);
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
                case "1"->subShowOptions();
                case "2"->searchLoans();
//                case "3"->createLoan();
                case "3"->{System.out.println("Removing the admin privileges...");return;}
//                case "4"->modifyLoan();
                case "4"->{System.out.println("Removing the admin privileges...");return;}
//                case "4"->deleteLoan();
                case "5"->{System.out.println("Removing the admin privileges...");return;}
                case "6"->{System.out.println("Removing the admin privileges...");return;}
                // case "test"->showAllBookGenders();
                default->System.out.println("Invalid option. Please enter a valid option (1-6).");
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
        try{
            service.getAllLoans().forEach(System.out::println);
//            service.getAllLoans().forEach(loans -> System.out.printf(
//                    "%n" + "=".repeat(4) + " Loan by %s %s " + "=".repeat(4) +
//                            "%n" + "ISBN: %s" + "\tTitle: %s" + "\tAuthor: %s" +
//                            "%n" + "User IC: %s" + "\tfullname: %s %s" +
//                            "%n" + "Delivery Date: %s" + "\tReturn Date: %s" +
//                            "%n" + "=".repeat(40) + "%n",
//                    loans.userLastName(), loans.userName(),
//                    loans.bookIsbn(), loans.bookTitle(), loans.bookAuthor(),
//                    loans.userIc(), loans.userName(), loans.userLastName(),
//                    loans.deliveryDate(), loans.returnDate()
//            ));
        } catch (BookLoanNotFoundException e) {
            System.out.println(
                    "\n"+".".repeat(30)+
                            "\nError: "+e.getMessage()+
                            "\nCause: "+e.getCause()+
                            "\nException: "+e.getClass().getSimpleName()+
                            "\n"+".".repeat(15)
            );
        }
    }

    private void showAllLoansByDate(){
        try {
            String dateYearString=String.valueOf(LocalDate.now().getYear());
            String dateMonthString=inCaseExit("Enter a month (1-12): ");
            String dateDayString=inCaseExit("Enter a day (1-31): ");
            String dateString=dateYearString+"/"+dateMonthString+"/"+dateDayString;
            service.getAllLoansByDate(dateString).forEach(System.out::println);
//            service.getAllLoansByDate(dateString).forEach(loans->System.out.printf(
//                    "%n"+"=".repeat(4)+" Loan by %s %s "+"=".repeat(4)+
//                            "%n"+"ISBN: %s"+"\tTitle: %s"+"\tAuthor: %s"+
//                            "%n"+"User IC: %s"+"\tfullname: %s %s"+
//                            "%n"+"Delivery Date: %s"+"\tReturn Date: %s"+
//                            "%n"+"=".repeat(40)+"%n",
//                    loans.userLastName(),loans.userName(),
//                    loans.bookIsbn(),loans.bookTitle(),loans.bookAuthor(),
//                    loans.userIc(),loans.userName(),loans.userLastName(),
//                    loans.deliveryDate(),loans.returnDate()
//            ));
        } catch (GenericStringBoundaryException e) {
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+e.getMessage()+
                    "\nCause: "+e.getCause()+
                    "\nException: "+e.getClass().getSimpleName()+
                    "\n"+".".repeat(15)
            );
        }catch (BookLoanNotFoundException e) {
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+e.getMessage()+
                    "\nCause: "+e.getCause()+
                    "\nException: "+e.getClass().getSimpleName()+
                    "\n"+".".repeat(15)
            );
        }catch (BookLoanInvalidException e) {
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+e.getMessage()+
                    "\nCause: "+e.getCause()+
                    "\nException: "+e.getClass().getSimpleName()+
                    "\n"+".".repeat(15)
            );
        }
    }

    private void searchLoans(){
        String string;
        try {
            System.out.println("\tYou can enter: IC, names, ISBN, title, author.");
            string=inCaseExit("Enter: ");
            List<BookLoanDTO> loans=service.getAllLoans(string);
            loans.forEach(System.out::println);
//            loans.forEach(loan->System.out.printf(
//                    "%n"+"=".repeat(4)+" Loan by %s %s "+"=".repeat(4)+
//                            "%n"+"ISBN: %s"+"\tTitle: %s"+"\tAuthor: %s"+
//                            "%n"+"User IC: %s"+"\tfullname: %s %s"+
//                            "%n"+"Delivery Date: %s"+"\tReturn Date: %s"+
//                            "%n"+"=".repeat(40)+"%n",
//                    loan.userLastName(),loan.userName(),
//                    loan.bookIsbn(),loan.bookTitle(),loan.bookAuthor(),
//                    loan.userIc(),loan.userName(),loan.userLastName(),
//                    loan.deliveryDate(),loan.returnDate()
//            ));;
            System.out.println(">".repeat(4)+" Found "+loans.size()+" Result.");
        }catch (GenericStringBoundaryException e) {
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+e.getMessage()+
                    "\nCause: "+e.getCause()+
                    "\nException: "+e.getClass().getSimpleName()+
                    "\n"+".".repeat(15)
            );
        }catch (BookLoanInvalidException e){
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+e.getMessage()+
                    "\nCause: "+e.getCause()+
                    "\nException: "+e.getClass().getSimpleName()+
                    "\n"+".".repeat(15)
            );
        }
    }
}
