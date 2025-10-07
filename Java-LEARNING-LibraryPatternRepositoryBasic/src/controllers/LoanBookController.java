package controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import models.Book;
import models.LoanBook;
import models.User;
import repositories.BookRepository;
import repositories.LoanBookRepository;
import repositories.UserRepository;
import services.BookService;
import services.LoanBookService;
import services.UserService;
import ui.LibraryTemplate;

public class LoanBookController extends LibraryTemplate{
    private UserService userService;
    private BookService bookService;
    private LoanBookService loanBookService;
    private Scanner scanner=new Scanner(System.in);

    public LoanBookController(){
        UserRepository userRepo = new UserRepository();
        BookRepository bookRepo = new BookRepository();
        LoanBookRepository loanRepo = new LoanBookRepository(bookRepo, userRepo);


        this.userService = new UserService(userRepo);
        this.bookService = new BookService(bookRepo);
        this.loanBookService = new LoanBookService(loanRepo);
    }

    public void run(){
        mainOptions();
    }

    //todo: OPTIONS
    @Override
    protected void mainOptions(){
        while (!false) {
            mainMenu();
            byte option=validatorOption();
            switch (option) {
                case 1->bookOptions();
                case 2->userOptions();
                case 3->loanBookOptions();
                case 4->{
                    scanner.close();
                    System.exit(0);
                }
                default->System.out.println("You must enter a number between 1-4.");
            };
        }
    }

    @Override
    protected void bookOptions(){
        while (!false) {
            bookMenu();
            byte option=validatorOption();
            switch (option) {
                case 1->{
                    try {
                        bookService.findAllBooks().forEach(System.out::println);
                    } catch (RuntimeException e) {
                        System.err.println("Error: "+e.getMessage());
                    }
                }
                case 2->{
                    try {
                        bookService.findAllBooksAvailable().forEach(System.out::println);
                    } catch (RuntimeException e) {
                        System.err.println("Error: "+e.getMessage());
                    }
                }
                case 3->searchBook();
                case 4->{
                    return; //* MUST BE 'RETURN'.
                }
                default->System.out.println("You must enter a number between 1-4.");
            }
        }
    }

    @Override
    protected void userOptions(){
        while (!false) {
            userMenu();
            byte option=validatorOption();
            switch (option) {
                case 1->userService.findAllUsers().forEach(System.out::println);
                case 2->searchUser();
                case 3->{
                    return; // Testing if works or not.
                }
                default->System.out.println("You must enter a number between 1-3.");
            }
        }
    }

    @Override
    protected void loanBookOptions(){
        while (!false) {
            loanBookMenu();
            byte option=validatorOption();
            switch (option) {
                case 1->registerLoanBook();
                case 2->{
                    try {
                        loanBookService.findAllLoanBooks().forEach(System.out::println);
                    } catch (NullPointerException ex) {
                        System.err.println("Error: "+ex.getMessage());
                    }
                }
                case 3->searchBookLoan();
                case 4->deleteLoanBook();
                case 5->{
                    return; // Testing if works or not.
                }
                default->System.out.println("You must enter a number between 1-5.");
            }
        }
    }

    //todo: Validators
    @Override
    protected byte validatorOption() {
        while (!false) {
            System.out.print("Enter an option: ");
            String string=scanner.nextLine();
            try {
                byte option=Byte.parseByte(string);
                if (option>0&&option<6) {
                    return option;
                }else{
                    System.out.println("You must enter a number between 1-5.");
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Error: "+e.getMessage());
            }
        }
    }

    private String scannerValidator(String messege){
        System.out.print(messege);
        String string=scanner.nextLine().trim();
        if (string.equalsIgnoreCase("EXIT".toLowerCase())) {
            throw new RuntimeException("Register process was canceled.");
        }
        return string;
    }

    //todo: FUNCTIONS
    //* BOOK
    private void searchBook(){
        /* try {
            Integer id=Integer.parseInt(string);
            bookService.findBook(id).stream().forEach(System.out::println);
        } catch (NumberFormatException e) {
            try {
                bookService.findBook(string).forEach(System.out::println);
                // return;
            } catch (NullPointerException ex) {
                System.err.println("Error: "+ex.getMessage());
            }
        }catch (NullPointerException e) {
            System.err.println("Error: "+e.getMessage());
            
        } */
        try {
            System.out.print("Enter title, gender or author: ");
            String string=scanner.nextLine();
            bookService.findBook(string).forEach(System.out::println);
        } catch (NullPointerException ex) {
            System.err.println("Error: "+ex.getMessage());
        }
    }

    //* USER
    private void searchUser(){
        try {
            System.out.print("Enter name, lastname or IC: ");
            String string=scanner.nextLine();
            userService.findUser(string).forEach(System.out::println);
        } catch (NullPointerException ex) {
            System.err.println("Error: "+ex.getMessage());
        }
    }

    //* BOOK LOAN
    private void registerLoanBook(){
        // DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy/MM/dd");
        try {
            System.out.println("\n"+"=".repeat(5)+" Registering... "+"=".repeat(5));
            System.out.println("\n"+"=".repeat(5)+" USER "+"=".repeat(5));
            String ic=scannerValidator("Enter your IC: ");
            String name=scannerValidator("Enter your name: ");
            String lastname=scannerValidator("Enter your lastname: ");
            String ageString=scannerValidator("Enter your age: ");
            byte age=Byte.parseByte(ageString);
            char gender=scannerValidator("Enter your gender (F|M): ").toUpperCase().charAt(0);
            User user=new User(name, lastname, ic, age, gender);
            System.out.printf
            (
                "\n| USER DRAFT |"+
                "\nIC: %s"+
                "\nNAME: %s"+
                "\nLASTNAME: %s"+
                "\nAGE: %d"+
                "\nGENDER: %s",
                ic,name,lastname,age,gender
            );

            System.out.println("\n"+"=".repeat(5)+" BOOK "+"=".repeat(5));
            String bookIdString=scannerValidator("Enter book's ID: ");
            int bookId=Integer.parseInt(bookIdString);
            if (!bookService.findBook(bookId).isPresent()) {
                throw new NullPointerException("Book doesn't exist.");
            }
            if (bookService.findBook(bookId).get().isAvailable()==false) {
                throw new RuntimeException("Book unavailable.");
            }
            Book book=bookService.findBook(bookId).get();
            System.out.printf
            (
                "\n| BOOK DRAFT |"+
                "\nTITLE: %s"+
                "\nIBN: %s"+
                "\nAUTHOR: %s"+
                "\nGENDER: %s"+
                "\nRelease date: %s%n",
                book.getTitle(),book.getIbn(),book.getAuthor(),book.getGender().name(),book.getReleaseDate()
            );

            System.out.println("\n"+"=".repeat(5)+" BOOK LOAN "+"=".repeat(5));
            LocalDate checkIn=LocalDate.now();
            // System.out.print("Enter checkout date (YYYY/MM/DD): ");
            System.out.println("How many days do you want to borrow your book?");
            String daysAfterString=scannerValidator("Enter the days: ");
            byte daysAfter=Byte.parseByte(daysAfterString);
            LocalDate checkOut=LocalDate.now().plusDays(daysAfter);
            LoanBook loanBook=new LoanBook(checkIn, checkOut, book, user);
            System.out.printf
            (
                "\n| BOOK LOAN DRAFT |"+
                "\nIC: %s"+
                "\nFULL NAME: %s %s"+
                "\nTITLE: %s"+
                "\nAUTHOR: %s"+
                "\nGENDER: %s"+
                "\nCheckout: %s"+
                "\nDays remaining: %d%n",
                ic,name,lastname,book.getTitle(),book.getAuthor(),book.getGender().name(),checkOut,loanBook.getDaysRemaining()
            );
            System.out.println("\nAre you sure to make a Book loan?");
            System.out.print("Enter your asnwer (Y|N): ");
            String option=scanner.nextLine().toLowerCase();
            if (option.equals("NO".toLowerCase())||option.equals("N".toLowerCase())||option.equals("EXIT".toLowerCase())) {
                throw new RuntimeException("Register process was canceled.");
            }
            loanBookService.registerLoanBook(loanBook);
            // return;
        } catch (RuntimeException ex) {
            System.err.println("Error: "+ex.getMessage());
        }
    }

    private void deleteLoanBook(){
        try {
            System.out.print("Enter Book's loan ID: ");
            String string=scanner.nextLine();
            int id=Integer.parseInt(string);
            if(!loanBookService.findLoanBook(id).isPresent()){
                throw new NullPointerException("Book loan couldn't be found.");
            }
            LoanBook loanBook=loanBookService.findLoanBook(id).get();
            System.out.printf
            (
                "\n| BOOK LOAN DRAFT |"+
                "\nIC: %s"+
                "\nFULL NAME: %s %s"+
                "\nTITLE: %s"+
                "\nAUTHOR: %s"+
                "\nGENDER: %s"+
                "\nCheckout: %s"+
                "\nDays remaining: %d%n",
                loanBook.getUser().getIc(),loanBook.getUser().getName(),loanBook.getUser().getLastname(),loanBook.getBook().getTitle(),loanBook.getBook().getAuthor(),loanBook.getBook().getGender().name(),loanBook.getCheckOut(),loanBook.getDaysRemaining()
            );
            System.out.println("\nAre you sure to remove this Book loan?");
            System.out.print("Enter your asnwer (Y|N): ");
            string=scanner.nextLine().toLowerCase();
            String option=string;
            if (option.equals("NO".toLowerCase())) {
                throw new RuntimeException("Deleting process was canceled.");
            }
            loanBook.getBook().setAvailable(true);
            loanBookService.deleteLoanBook(id);
        } catch (RuntimeException ex) {
            System.err.println("Error: "+ex.getMessage());
        }
    }

    private void searchBookLoan(){
        try {
            System.out.print("Enter name, lastname, IC, Book's title or Book's author: ");
            String string=scanner.nextLine();
            loanBookService.findLoanBook(string).forEach(System.out::println);
        } catch (NullPointerException ex) {
            System.err.println("Error: "+ex.getMessage());
        }
    }
}
