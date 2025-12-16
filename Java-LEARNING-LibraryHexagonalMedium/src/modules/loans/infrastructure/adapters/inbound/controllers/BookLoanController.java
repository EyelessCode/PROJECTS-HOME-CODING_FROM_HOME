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
                case "1"->subShowOptions();
                case "2"->searchLoans();
                case "3"->{System.out.println("Going back to main Menu...");return;}
//                case "root"->rootOptions();
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
                case "3"->createLoan();
                case "4"->modifyLoan();
                case "5"->deleteLoan();
                case "6"->{System.out.println("Going back to main Menu...");return;}
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
            List<BookLoanDTO>loans=service.getAllLoans();
            loans.forEach(System.out::println);
            System.out.println(">".repeat(4)+" "+loans.size()+" loans registered.");
        } catch (BookLoanNotFoundException e) {
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+e.getMessage()+
                    "\nCause: "+e.getCause()+
                    "\nException: "+e.getClass().getSimpleName()+
                    "\n"+".".repeat(30)
            );
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
        } catch (GenericStringBoundaryException e) {
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+e.getMessage()+
                    "\nCause: "+e.getCause()+
                    "\nException: "+e.getClass().getSimpleName()+
                    "\n"+".".repeat(30)
            );
        }catch (BookLoanDateInvalidException e) {
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+e.getMessage()+
                    "\nCause: "+e.getCause()+
                    "\nException: "+e.getClass().getSimpleName()+
                    "\n"+".".repeat(30)
            );
        }catch (BookLoanNotFoundException e) {
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+e.getMessage()+
                    "\nCause: "+e.getCause()+
                    "\nException: "+e.getClass().getSimpleName()+
                    "\n"+".".repeat(30)
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
            System.out.println(">".repeat(4)+" "+loans.size()+" loans found.");
        }catch (GenericStringBoundaryException e) {
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+e.getMessage()+
                    "\nCause: "+e.getCause()+
                    "\nException: "+e.getClass().getSimpleName()+
                    "\n"+".".repeat(30)
            );
        }catch (BookLoanNotFoundException e){
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+e.getMessage()+
                    "\nCause: "+e.getCause()+
                    "\nException: "+e.getClass().getSimpleName()+
                    "\n"+".".repeat(30)
            );
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
                    "\n"+"=".repeat(6)+" Loan by "+"=".repeat(6)+
                    "\ttoday date: "+LocalDate.now()+
                    "\n"+"ISBN: "+isbn+"\t"+"IC: "+ic+
                    "\n"+"+".repeat(3)+" Estimated dates "+"+".repeat(3)+
                    "\n"+"Delivery Date: "+LocalDate.parse(dateString)+"\tReturn Date: "
                            +LocalDate.parse(dateString).plusDays(plusDays)+
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
        }catch (GenericStringBoundaryException e){
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+e.getMessage()+
                    "\nCause: "+e.getCause()+
                    "\nException: "+e.getClass().getSimpleName()+
                    "\n"+".".repeat(30)
            );
        }catch (BookLoanNotFoundException e){
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+e.getMessage()+
                    "\nCause: "+e.getCause()+
                    "\nException: "+e.getClass().getSimpleName()+
                    "\n"+".".repeat(30)
            );
        }catch (BookLoanCouldntBeCreatedException e){
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+e.getMessage()+
                    "\nCause: "+e.getCause()+
                    "\nException: "+e.getClass().getSimpleName()+
                    "\n"+".".repeat(30)
            );
        }
    }

    private void modifyLoan(){
        System.out.println("\n-- MODIFYING LOAN --");
        try{
            String ic=numberString("Enter IC: ");
            BookLoanDTO loan=service.getLoan(ic).get();
            System.out.println(loan);
            System.out.println("\nIs this the loan you want to modify (YES/NO)?");
            String option=inCaseExit("Enter: ");
            if (!option.equalsIgnoreCase("YES")) {
                System.out.println("-- Loan NOT modified --.");
                return;
            }
            System.out.println("Modifying return date...");
            System.out.println("\t¡Only days!");
            String plusDaysString = numberString("Enter how many days to return the book: ");
            long plusDays=plusDaysString.isBlank()?0:Long.parseLong(plusDaysString);
            System.out.println("\nConfirm modifying this loan (YES/NO)?");
            System.out.println(
                    "\n"+"=".repeat(6)+" Loan by "+loan.userLastName()+" "+loan.userName()+" "+"=".repeat(6)+
                        "\ttoday date: "+LocalDate.now()+
                    "\n"+"+".repeat(3)+" Book "+"+".repeat(3)+
                    "\n"+"ISBN: "+loan.bookIsbn()+"\tTitle: "+loan.bookTitle()+"\tAuthor: "+loan.bookAuthor()+
                    "\tGender: "+loan.bookGender()+
                    "\n"+"+".repeat(3)+" User "+"+".repeat(3)+
                    "\n"+"IC: "+loan.userIc()+"\tfullname: "+loan.userName()+" "+loan.userLastName()+
                        "\tGender: "+loan.userGender()+"\tAge: "+loan.userAge()+
                    "\n"+"+".repeat(3)+" Estimated dates "+"+".repeat(3)+
                    "\n"+"Delivery Date: "+loan.deliveryDate()+"\tReturn Date: "+loan.deliveryDate().plusDays(plusDays)+
                        "\t\tRemaining days: >> "+(plusDays<=0?plusDays+" [MUST RETURN BOOK]":plusDays)+" <<"+
                    "\n"+"=".repeat(40)
            );
            option=inCaseExit("Enter: ");
            if (!option.equalsIgnoreCase("YES")){
                System.out.println("-- Loan NOT modified --");
                return;
            }
            System.out.println("-- Loan modified --");
            service.modifyLoan(loan.userIc(), loan.bookIsbn(), loan.deliveryDate().toString(), plusDaysString);
//            throw new GenericStringBoundaryException("Loan modification cancelled by user.");
        }catch (GenericStringBoundaryException e){
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+e.getMessage()+
                    "\nCause: "+e.getCause()+
                    "\nException: "+e.getClass().getSimpleName()+
                    "\n"+".".repeat(30)
            );
        }catch (GenericNumberInvalidException e){
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+e.getMessage()+
                    "\nCause: "+e.getCause()+
                    "\nException: "+e.getClass().getSimpleName()+
                    "\n"+".".repeat(30)
            );
        }catch (BookLoanNotFoundException e){
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+e.getMessage()+
                    "\nCause: "+e.getCause()+
                    "\nException: "+e.getClass().getSimpleName()+
                    "\n"+".".repeat(30)
            );
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
        }catch (GenericStringBoundaryException e){
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+e.getMessage()+
                    "\nCause: "+e.getCause()+
                    "\nException: "+e.getClass().getSimpleName()+
                    "\n"+".".repeat(30)
            );
        }catch (BookLoanNotFoundException e){
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+e.getMessage()+
                    "\nCause: "+e.getCause()+
                    "\nException: "+e.getClass().getSimpleName()+
                    "\n"+".".repeat(30)
            );
        }
    }
}
