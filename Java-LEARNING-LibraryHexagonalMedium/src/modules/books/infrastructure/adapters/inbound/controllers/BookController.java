package modules.books.infrastructure.adapters.inbound.controllers;

import java.util.List;
import java.util.Optional;

import modules.books.app.services.BookService;
import modules.books.domain.exceptions.models.BookCouldNotBeCreatedException;
import modules.books.domain.exceptions.models.BookInvalidException;
import modules.books.domain.exceptions.models.BooksNotFoundException;
import modules.books.domain.exceptions.models.valueObjects.BookLocalDateInvalidException;
import modules.books.domain.models.Book;
import modules.books.domain.ui.console.BookConsole;
import shared.exceptions.GenericNumberInvalidException;
import shared.exceptions.GenericStringBoundaryException;

public class BookController extends BookConsole{
    private final BookService service;

    public BookController(BookService service){
        this.service=service;
    }

    public void bookRun(){
        options();
    }
    public void bookRootRun(){
        rootOptions();
    }

    @Override
    protected void options() {
        String option;
        while (true) {
            menu();
            option=fromInputOption();
            switch (option) {
                case "1"->showAllBooks();
                case "2"->showAllBookGenders();
                case "3"->searchBooks();
                case "4"->{System.out.println("Going back to main Menu...");return;}
//                case "root"->rootOptions();
                default->System.out.println("Invalid option. Please enter a valid option (1-4).");
            }
        }
    }

    private void showAllBooks(){
        try {
            List<Book>books=service.getBooks();
            books.forEach(System.out::println);
            System.out.println(">".repeat(4)+" "+books.size()+" books registered.");
        } catch (BooksNotFoundException ex) {
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(30)
            );
        }
    }

    private void searchBooks(){
        String string;
        try {
            string=inCaseExit("Enter a ISBN, title, author or gender: ");
            List<Book>books=service.getBooks(string);
            books.forEach(System.out::println);
            System.out.println(">".repeat(4)+" "+books.size()+" books found.");
        } catch (GenericStringBoundaryException ex) {
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(30)
            );
        } catch (BooksNotFoundException ex) {
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+ex.getMessage()+
                    "\nCause: "+ex.getCause()+
                    "\nException: "+ex.getClass().getSimpleName()+
                    "\n"+".".repeat(30)
            );
        }
    }

    private void createBook(){
        System.out.println("\n-- CREATING BOOK --");
        try {
            String isbn=numberString("Enter ISBN: ");
            String title=inCaseExit("Enter title: ");
            String author=inCaseExit("Enter author: ");
            String releaseDateYear= numberString("Enter year: ");
            String releaseDateMonth= numberString("Enter digit of month: ");
            String releaseDateDay= numberString("Enter day: ");
            String releaseDate=((releaseDateYear.isBlank()||releaseDateMonth.isBlank())||releaseDateDay.isBlank())?
                    null:(releaseDateYear+"-"+releaseDateMonth+"-"+releaseDateDay);
            String pagesString=numberString("Enter pages: ");
            String gender=inCaseExit("Enter gender: ");
            Short pages= pagesString.isBlank()?0:Short.parseShort(pagesString);
            System.out.printf(
                "%n"+"=".repeat(5)+" BOOK "+"=".repeat(5)+
                "%nISBN: %s"+"\tTITLE: %s"+"\tGENDER: %s"+
                "%nAUTHOR: %s"+"\tRELEASE DATE: %s"+
                "%nPAGES: %d"+
                "%n"+"=".repeat(12),
                isbn,title,gender,author,releaseDate,pages
            );
            System.out.println("\nConfirm creating this book (YES/NO)?");
            String confirm=inCaseExit("Enter: ");
            if (!confirm.equalsIgnoreCase("YES")) {
                System.out.println("-- Book NOT created --");
                return;
            }
                service.saveBook(isbn, title, author, releaseDate, pages, gender);
                System.out.println("-- Book created --");
//            throw new BookCouldNotBeCreatedException("Book couldn't be created.");
        }catch(GenericStringBoundaryException ex){
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(15)
            );
        }catch(GenericNumberInvalidException ex){
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(30)
            );
        }catch(BookLocalDateInvalidException ex){
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(30)
            );
        }catch(BookInvalidException ex){
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(30)
            );
        }
    }

    private void modifyBook(){
        System.out.println("\n-- MODIFYING BOOK --");
        String isbn;
        try {
            isbn=numberString("Enter an ISBN: ");
            Optional<Book> oldBook=service.getBook(isbn);
                System.out.println("\tOld save: press 'ENTER' -> "+oldBook.get().getTitle().getValue()+"'");
            String title=inCaseExit("Enter new title: ");

                System.out.println("\tOld save: press 'ENTER' -> '"+oldBook.get().getAuthor().getValue()+"'");
            String author=inCaseExit("Enter new author: ");

                System.out.println("\tOld save: press 'ENTER' -> '"+oldBook.get().getReleaseDate().getValue().getYear()+"'");
            String releaseDateYear= numberString("Enter new year: ");

                System.out.println("\tOld save: press 'ENTER' -> '"+oldBook.get().getReleaseDate().getValue().getMonthValue()+"'");
            String releaseDateMonth= numberString("Enter new digit of month: ");

                System.out.println("\tOld save: press 'ENTER' -> '"+oldBook.get().getReleaseDate().getValue().getDayOfMonth()+"'");
            String releaseDateDay= numberString("Enter new day: ");

                System.out.println("\tOld save: press 'ENTER' -> '"+oldBook.get().getPages().getValue()+"'");
            String pagesString=numberString("Enter new pages: ");

                System.out.println("\tOld save: press 'ENTER' -> '"+oldBook.get().getGender().name()+"'");
            String gender=inCaseExit("Enter new gender: ");

            String releaseDate=(releaseDateYear.isBlank()?oldBook.get().getReleaseDate().getValue().getYear():releaseDateYear)+
            "-"+(releaseDateMonth.isBlank()?oldBook.get().getReleaseDate().getValue().getMonthValue():releaseDateMonth)+
            "-"+(releaseDateDay.isBlank()?oldBook.get().getReleaseDate().getValue().getDayOfMonth():releaseDateDay);
//            System.out.println(releaseDate);
            short pages=((pagesString.isBlank())?0:Short.parseShort(pagesString));
            System.out.printf(
                "%n"+"=".repeat(5)+" BOOK "+"=".repeat(5)+
                "%nISBN: %s"+"\tTITLE: %s"+"\tGENDER: %s"+
                "%nAUTHOR: %s"+"\tRELEASE DATE: %s"+
                "%nPAGES: %d"+
                "%n"+"=".repeat(12),
                isbn,
                title.isBlank() ?oldBook.get().getTitle().getValue():title,
                gender.isBlank() ?oldBook.get().getGender().name():gender,
                author.isBlank() ?oldBook.get().getAuthor().getValue():author,
                releaseDate.isBlank() ?oldBook.get().getReleaseDate().getValue().toString():releaseDate,
                pages<=0 ?oldBook.get().getPages().getValue():pages
            );
            System.out.println("\nConfirm modifying this book (YES/NO)?");
            String confirm=inCaseExit("Enter your answer: ");
            if (!confirm.equalsIgnoreCase("YES")) {
                System.out.println("-- Book NOT modified --");
                return;
            }
                service.modifyBook(isbn, title, author, releaseDate, pages, gender);
                System.out.println("-- Book modified --");
//            throw new GenericStringBoundaryException("Book couldn't be created.");
        }catch(GenericStringBoundaryException ex){
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(30)
            );
        }catch(GenericNumberInvalidException ex){
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(30)
            );
        }catch(BookLocalDateInvalidException ex){
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(30)
            );
        }catch(BooksNotFoundException ex){
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(30)
            );
        }
    }

    private void showAllBookGenders(){
        service.getbookGenders().forEach(b->System.out.printf(
            "%n"+"=".repeat(5)+" BOOK "+"=".repeat(5)+
            "%nGENDERS: %s"+
            "%n"+"=".repeat(12),
            b
        ));
    }

    private void removeBook(){
        System.out.println("\n-- DELETING BOOK --");
        String string;
        try{
            string=numberString("Enter an ISBN: ");
            Book book=service.getBook(string).get();
            System.out.println(book);
            System.out.println("\nConfirm removing this book (YES/NO)?");
            String option=inCaseExit("Enter: ");
            if (!option.equalsIgnoreCase("YES")){
                System.out.println("-- Book NOT removed --");
                return;
            }
            System.out.println("-- Book removed --");
            service.removeBook(string);
//            throw new GenericStringBoundaryException("Input unexcepted. Try again.");
        }catch (GenericStringBoundaryException ex){
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+ex.getMessage()+
                    "\nCause: "+ex.getCause()+
                    "\nException: "+ex.getClass().getSimpleName()+
                    "\n"+".".repeat(30)
            );
        }catch (BooksNotFoundException ex){
            System.out.println(
                    "\n"+".".repeat(30)+
                    "\nError: "+ex.getMessage()+
                    "\nCause: "+ex.getCause()+
                    "\nException: "+ex.getClass().getSimpleName()+
                    "\n"+".".repeat(30)
            );
        }
    }

    private void rootOptions(){
        String option;
        while (true) {
            adminBookMenu();
            option=fromInputOption();
            switch (option) {
                case "1"->showAllBooks();
                case "2"->showAllBookGenders();
                case "3"->searchBooks();
                case "4"->createBook();
                case "5"->modifyBook();
                case "6"->removeBook();
                case "7"->{System.out.println("Going back to main Menu...");return;}
                default->System.out.println("Invalid option. Please enter a valid option (1-7).");
            }
        }
    }
}
