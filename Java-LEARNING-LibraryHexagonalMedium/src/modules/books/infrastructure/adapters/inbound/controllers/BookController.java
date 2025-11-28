package modules.books.infrastructure.adapters.inbound.controllers;

import java.util.Optional;

import modules.books.app.services.BookService;
import modules.books.domain.exceptions.models.BookCouldNotBeCreatedException;
import modules.books.domain.exceptions.models.BookInvalidException;
import modules.books.domain.exceptions.models.BooksNotFoundException;
import modules.books.domain.models.Book;
import modules.books.domain.ui.console.BookConsole;
import modules.books.infrastructure.adapters.outbound.repositories.BookRepositoryInMemory;
import shared.exceptions.GenericNumberInvalidException;
import shared.exceptions.GenericStringBoundaryException;

public class BookController extends BookConsole{
    private BookService service;

    public BookController(){
        BookRepositoryInMemory repository=new BookRepositoryInMemory();
        this.service=new BookService(repository);
    }

    public void bookRun(){
        options();
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
                case "4"->{System.out.println("Exiting the Book menu...");return;}
                case "root"->rootOptions();
                default->System.out.println("Invalid option. Please enter a valid option (1-4).");
            }
        }
    }

    private void showAllBooks(){
        try {
            service.getBooks().forEach(books->System.out.printf(
                "%n[ ISBN: %s "+"-".repeat(3)+" Title: %s "+"-".repeat(3)+"%nAuthor: %s "+"-".repeat(3)+" Pages: %d "+"-".repeat(3)+"%nRelease date: %s "+"-".repeat(3)+" Gender: %s "+"-".repeat(3)+" Availability: %b ]%n",
                books.getIsbn().getValue(),
                books.getTitle().getValue(),
                books.getAuthor().getValue(),
                books.getPages().getValue(),
                books.getReleaseDate().getValue(),
                books.getGender().getDescription(),
                books.getAvailability().isValue()
            ));
        } catch (BooksNotFoundException ex) {
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(15)
            );
        }
    }

    private void searchBooks(){
        String string;
        try {
            string=inCaseExit("Enter a ISBN, title, author or gender: ");
            service.getBooks(string).forEach(books->System.out.printf(
                "%n[ ISBN: %s "+"-".repeat(3)+" Title: %s "+"-".repeat(3)+"%nAuthor: %s "+"-".repeat(3)+" Pages: %d "+"-".repeat(3)+"%nRelease date: %s "+"-".repeat(3)+" Gender: %s "+"-".repeat(3)+" Availability: %b ]%n",
                books.getIsbn().getValue(),
                books.getTitle().getValue(),
                books.getAuthor().getValue(),
                books.getPages().getValue(),
                books.getReleaseDate().getValue(),
                books.getGender().getDescription(),
                books.getAvailability().isValue()
            ));
        } catch (BooksNotFoundException ex) {
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(15)
            );
        }
    }

    private void createBook(){
        System.out.println("\n-- CREATING BOOK --");
        try {
            String isbn=inCaseExit("Enter ISBN: ");
            String title=inCaseExit("Enter title: ");
            String author=inCaseExit("Enter author: ");
            String releaseDate=inCaseExit("Enter a release date: ");
            String pagesString=inCaseExit("Enter pages: ");
            String gender=inCaseExit("Enter gender: ");
            Short pages=((pagesString.isBlank()||pagesString.isEmpty())?0:Short.parseShort(pagesString));
            System.out.printf(
                "\n"+"=".repeat(5)+" BOOK "+"=".repeat(5)+
                "\nISBN: %s"+
                "\nTITLE: %s"+
                "\nAUTHOR: %s"+"\tRELEASE DATE: %s"+
                "\nPAGES: %d"+"\tGENDER: %s"+
                "\n"+"=".repeat(12),
                isbn,title,author,releaseDate,pages,gender
            );
            System.out.println("\nIs anything ok (YES or CANCEL)?");
            String confirm=inCaseExit("Enter your answer: ");
            if (confirm.equalsIgnoreCase("YES")) {
                service.saveBook(isbn, title, author, releaseDate, pages, gender);
                System.out.println("-- Book created --");
                return;
            }else if(confirm.equalsIgnoreCase("CANCEL")){
                System.out.println("-- Book NOT created --");
                return;
            }
            throw new BookCouldNotBeCreatedException("Book couldn't be created.");
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
                "\n"+".".repeat(15)
            );
        }catch(BookInvalidException ex){
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(15)
            );
        }
    }

    private void modifyBook(){
        String isbn;
        try {
            isbn=inCaseExit("Enter an ISBN: ");
            Optional<Book> oldBook=service.getBook(isbn);
            if (oldBook.isEmpty()) {
                throw new BooksNotFoundException("Book couldn't be found.");
            }
                System.out.println("\tOld save: press 'ENTER' -> "+oldBook.get().getTitle().getValue()+"'");
            String title=inCaseExit("Enter new title: ");

                System.out.println("\tOld save: press 'ENTER' -> '"+oldBook.get().getAuthor().getValue()+"'");
            String author=inCaseExit("Enter new author: ");

                System.out.println("\tOld save: press 'ENTER' -> '"+oldBook.get().getReleaseDate().getValue().getYear()+"'");
            String releaseDateYear=numbeString("Enter new year: ");

                System.out.println("\tOld save: press 'ENTER' -> '"+oldBook.get().getReleaseDate().getValue().getMonthValue()+"'");
            String releaseDateMonth=numbeString("Enter new digit of month: ");

                System.out.println("\tOld save: press 'ENTER' -> '"+oldBook.get().getReleaseDate().getValue().getDayOfMonth()+"'");
            String releaseDateDay=numbeString("Enter new day: ");

                System.out.println("\tOld save: press 'ENTER' -> '"+oldBook.get().getPages().getValue()+"'");
            String pagesString=inCaseExit("Enter new pages: ");

                System.out.println("\tOld save: press 'ENTER' -> '"+oldBook.get().getGender().name()+"'");
            String gender=inCaseExit("Enter new gender: ");

            String releaseDate=(releaseDateYear.isBlank()?oldBook.get().getReleaseDate().getValue().getYear():releaseDateYear)+
            "/"+(releaseDateMonth.isBlank()?oldBook.get().getReleaseDate().getValue().getMonthValue():releaseDateMonth)+
            "/"+(releaseDateDay.isBlank()?oldBook.get().getReleaseDate().getValue().getDayOfMonth():releaseDateDay);
            System.out.println(releaseDate);
            Short pages=((pagesString.isBlank())?0:Short.parseShort(pagesString));
            System.out.printf(
                "\n"+"=".repeat(5)+" BOOK "+"=".repeat(5)+
                "\nISBN: %s"+
                "\nTITLE: %s"+
                // "\nAUTHOR: %s"+"\tRELEASE DATE: %d/%d/%d"+
                "\nAUTHOR: %s"+"\tRELEASE DATE: %s"+
                "\nPAGES: %d"+"\tGENDER: %s"+
                "\n"+"=".repeat(12),
                isbn,
                (title.isBlank()||title.isEmpty()?oldBook.get().getTitle().getValue():title),
                (author.isBlank()||author.isEmpty())?oldBook.get().getAuthor().getValue():author,
                (releaseDate.isBlank()||releaseDate.isEmpty()?oldBook.get().getReleaseDate().getValue().toString():releaseDate),
                /* (releaseDateYear.isBlank()||releaseDateYear.isEmpty())?oldBook.get().getReleaseDate().getValue().getYear():Short.parseShort(releaseDateYear),
                (releaseDateMonth.isBlank()||releaseDateMonth.isEmpty())?oldBook.get().getReleaseDate().getValue().getMonthValue():Short.parseShort(releaseDateMonth),
                (releaseDateDay.isBlank()||releaseDateDay.isEmpty())?oldBook.get().getReleaseDate().getValue().getDayOfMonth():Short.parseShort(releaseDateDay), */
                (pages<=0||pages==null)?oldBook.get().getPages().getValue():pages,
                (gender.isBlank()||gender.isEmpty())?oldBook.get().getGender().name():gender
            );
            System.out.println("\nIs anything ok (YES or CANCEL)?");
            String confirm=inCaseExit("Enter your answer: ");
            if (confirm.equalsIgnoreCase("YES")) {
                service.modifyBook(isbn, title, author, releaseDate, pages, gender);
                System.out.println("-- Book modified --");
                return;
            }else if(confirm.equalsIgnoreCase("CANCEL")){
                System.out.println("-- Book NOT modified --");
                return;
            }
            throw new BookCouldNotBeCreatedException("Book couldn't be created.");
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
                "\n"+".".repeat(15)
            );
        }catch(BookInvalidException ex){
            System.out.println(
                "\n"+".".repeat(30)+
                "\nError: "+ex.getMessage()+
                "\nCause: "+ex.getCause()+
                "\nException: "+ex.getClass().getSimpleName()+
                "\n"+".".repeat(15)
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
                case "6"->modifyBook();
                case "7"->{System.out.println("Removing the admin privileges...");return;}
                // case "test"->showAllBookGenders();
                default->System.out.println("Invalid option. Please enter a valid option (1-7).");
            }
        }
    }
}
