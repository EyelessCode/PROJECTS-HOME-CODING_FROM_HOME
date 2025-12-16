package modules.loans.infrastructure.adapters.inbound.controllers;

import modules.loans.app.services.BookLoanService;
import modules.loans.app.services.dtos.BookLoanDTO;
import modules.loans.domain.exceptions.models.BookLoanCouldntBeCreatedException;
import modules.loans.domain.exceptions.models.BookLoanNotFoundException;
import modules.loans.domain.exceptions.models.valueObjects.BookLoanDateInvalidException;
import modules.loans.domain.ui.console.BookLoanConsole;
import shared.exceptions.GenericNumberInvalidException;
import shared.exceptions.GenericStringBoundaryException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BookLoanController extends BookLoanConsole {
    private final BookLoanService service;

    public BookLoanController(BookLoanService service){
        this.service = service;
    }

    public void loanRun() {
        options();
    }
    public void loanRootRun() {
        rootOptions();
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
                case "3"->{System.out.println("Going back to main Menu...");return;}
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
                case "2"->searchLoans();
                case "3"->createLoan();
                case "4"->modifyLoan();
                case "5"->deleteLoan();
                case "6"->{System.out.println("Going back to main Menu...");return;}
                default->System.out.println("Invalid option. Please enter a valid option (1-6).");
            }
        }
    }

    private void showAllLoans(){
        try{
            List<BookLoanDTO>loans=service.getAllLoans();
            loans.forEach(System.out::println);
            System.out.println(">".repeat(4)+" "+loans.size()+" loans registered.");
        }catch (RuntimeException e){
            printError(e);
        }
    }

    private void showAllLoansByDate(){
        try {
            String dateYearString=String.valueOf(LocalDate.now().getYear());
            String dateMonthString=inCaseExit("Enter a month (1-12): ");
            String dateDayString=inCaseExit("Enter a day (1-31): ");
            String dateString=dateYearString+"/"+dateMonthString+"/"+dateDayString;
            List<BookLoanDTO>loans=service.getAllLoansByDate(dateString);
            loans.forEach(System.out::println);
            System.out.println(">".repeat(4)+" "+loans.size()+" loans found.");
        }catch (RuntimeException e){
            printError(e);
        }
    }

    private void searchLoans(){
        String string;
        try {
            System.out.println("\tYou can enter: IC, names, ISBN, title, author.");
            string=inCaseExit("Enter: ");
            List<BookLoanDTO> loans=service.getAllLoans(string);
            loans.forEach(System.out::println);
            System.out.println(">".repeat(4)+" "+loans.size()+" loans found.");
        }catch (RuntimeException e){
            printError(e);
        }
    }

    private void createLoan(){
        System.out.println("-- CREATING LOAN --");
        try{
            String ic=numberString("Enter IC: ");
            String isbn=numberString("Enter ISBN: ");
            System.out.println("Creating delivery date...");
            System.out.println("\tWants to make a Loan today -> '"+LocalDate.now()+"' (YES/NO)?");
            String dateString=null;
            String dateOption=inCaseExit("Enter: ");
            dateString=LocalDate.now().toString();
            if (!dateOption.equalsIgnoreCase("YES")){
                System.out.println("\tSpecify the date:");
                String yearDateString=numberString("Enter year: ");
                String monthDateString=numberString("Enter month (1-12): ");
                String dayDateString=numberString("Enter day (1-31): ");
                dateString=yearDateString+"-"+monthDateString+"-"+dayDateString;
            }
            System.out.println("Creating return date...");
            System.out.println("\t¡Only days!");
            String plusDaysString=numberString("Enter how many days to return the book: ");
            long plusDays=plusDaysString.isBlank()?0:Long.parseLong(plusDaysString);
            System.out.println(
                    "\n"+"=".repeat(6)+" Loan "+"=".repeat(6)+
                    "\ttoday date: "+LocalDate.now()+
                    "\n"+"ISBN: "+isbn+"\t\t"+"IC: "+ic+
                    "\n"+"+".repeat(3)+" Estimated dates "+"+".repeat(3)+"\n"+"Delivery Date: "
                            +LocalDate.parse(dateString,DateTimeFormatter.ofPattern("yyyy-M-d"))+"\tReturn Date: "
                            +LocalDate.parse(dateString,DateTimeFormatter.ofPattern("yyyy-M-d")).plusDays(plusDays)+
                    "\t\tRemaining days: >> "+(plusDays<=0?plusDays+
                            " [MUST RETURN BOOK]":plusDays)+" <<"+
                    "\n"+"=".repeat(40)
            );
            System.out.println("\nConfirm creating this loan (YES/NO)?");
            String option=inCaseExit("Enter: ");
            if (!option.equalsIgnoreCase("YES")){
                System.out.println("-- Loan NOT created");
                return;
            }
            System.out.println("-- Loan created --");
            service.saveLoan(ic,isbn,dateString,plusDaysString);
        }catch (RuntimeException e){
            printError(e);
        }
    }

    private void modifyLoan(){
        System.out.println("\n-- MODIFYING LOAN --");
        try{
            String ic=numberString("Enter IC: ");
            BookLoanDTO oldLoan=service.getLoan(ic).get();
            System.out.println(oldLoan);
            System.out.println("\nIs this the loan you want to modify (YES/NO)?");
            String option=inCaseExit("Enter: ");
            if (!option.equalsIgnoreCase("YES")) {
                System.out.println("-- Loan NOT modified --.");
                return;
            }
            System.out.println("Modifying return date...");
            System.out.println("\t¡Only days!");
                System.out.println("\tOld save: press 'ENTER' -> "+oldLoan.remainingDays()+"'");
            String plusDaysString = numberString("Enter how many days to return the book: ");
            long plusDays=plusDaysString.isBlank()?0:Long.parseLong(plusDaysString);
            System.out.println("\nConfirm modifying this loan (YES/NO)?");
            System.out.println(
                    "\n"+"=".repeat(6)+" Loan by "+oldLoan.userLastName()+" "+oldLoan.userName()+" "+"=".repeat(6)+
                        "\ttoday date: "+LocalDate.now()+
                    "\n"+"+".repeat(3)+" Book "+"+".repeat(3)+
                    "\n"+"ISBN: "+oldLoan.bookIsbn()+"\tTitle: "+oldLoan.bookTitle()+"\tAuthor: "+oldLoan.bookAuthor()+
                    "\tGender: "+oldLoan.bookGender()+
                    "\n"+"+".repeat(3)+" User "+"+".repeat(3)+
                    "\n"+"IC: "+oldLoan.userIc()+"\tfullname: "+oldLoan.userName()+" "+oldLoan.userLastName()+
                        "\tGender: "+oldLoan.userGender()+"\tAge: "+oldLoan.userAge()+
                    "\n"+"+".repeat(3)+" Estimated dates "+"+".repeat(3)+
                    "\n"+"Delivery Date: "+oldLoan.deliveryDate()+"\tReturn Date: "+oldLoan.deliveryDate().plusDays(plusDays)+
                        "\t\tRemaining days: >> "+(plusDays<=0?plusDays+" [MUST RETURN BOOK]":plusDays)+" <<"+
                    "\n"+"=".repeat(40)
            );
            option=inCaseExit("Enter: ");
            if (!option.equalsIgnoreCase("YES")){
                System.out.println("-- Loan NOT modified --");
                return;
            }
            System.out.println("-- Loan modified --");
            service.modifyLoan(oldLoan.userIc(), oldLoan.bookIsbn(), oldLoan.deliveryDate().toString(), plusDaysString);
//            throw new GenericStringBoundaryException("Loan modification cancelled by user.");
        }catch (RuntimeException e){
            printError(e);
        }
    }

    private void deleteLoan(){
        System.out.println("\n-- DELETING LOAN --");
        String ic;
        try{
            ic=numberString("Enter IC: ");
            BookLoanDTO loan=service.getLoan(ic).get();
            System.out.println(loan);
            System.out.println("\nIs this the loan you want to delete (YES/NO)?");
            String option=inCaseExit("Enter: ");
            if (!option.equalsIgnoreCase("YES")) {
                System.out.println("-- Loan NOT deleted --.");
                return;
            }
            System.out.println("-- Loan deleted --");
            service.removeLoan(ic);
//            throw new GenericStringBoundaryException("Loan deletion cancelled by user.");
        }catch (RuntimeException e){
            printError(e);
        }
    }
}
