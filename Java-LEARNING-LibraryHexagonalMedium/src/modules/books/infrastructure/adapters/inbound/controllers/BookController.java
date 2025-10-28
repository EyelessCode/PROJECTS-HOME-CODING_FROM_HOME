package modules.books.infrastructure.adapters.inbound.controllers;

import modules.books.app.services.BookService;
import modules.books.domain.exceptions.BooksNotFoundException;
import modules.books.domain.ui.console.BookConsole;
import modules.books.infrastructure.adapters.outbound.repositories.BookRepositoryInMemory;

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
                case "2"->searchBooks();
                case "3"->{System.out.println("Exiting the Book menu...");return;}
                case "root"->rootOptions();
                default->System.out.println("Invalid option. Please enter a valid option (1-3).");
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

    private void rootOptions(){
        String option;
        while (true) {
            adminBookMenu();
            option=fromInputOption();
            switch (option) {
                case "1"->showAllBooks();
                case "2"->throw new IllegalArgumentException();
                case "3"->throw new IllegalArgumentException();
                case "4"->throw new IllegalArgumentException();
                case "5"->{System.out.println("Removing the admin privileges...");return;}
                default->System.out.println("Invalid option. Please enter a valid option (1-5).");
            }
        }
    }
}
