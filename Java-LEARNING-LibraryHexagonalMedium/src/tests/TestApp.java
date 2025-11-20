package tests;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import modules.books.domain.models.Book;
import modules.books.domain.models.valueObjects.BookAuthor;
import modules.books.domain.models.valueObjects.BookIsbn;
import modules.books.domain.models.valueObjects.BookPages;
import modules.books.domain.models.valueObjects.BookReleaseDate;
import modules.books.domain.models.valueObjects.BookTitle;
import modules.books.domain.models.valueObjects.enums.BookGender;
import modules.books.infrastructure.adapters.inbound.controllers.BookController;
import modules.users.infrastructure.adapters.inbound.controllers.UserController;

public class TestApp {
    public static void main(String[] args) {
        /* Book book1=new Book(new BookIsbn("1111111111111"), new BookTitle("TITLE 1"), new BookAuthor("AUTHOR"), new BookReleaseDate(LocalDate.of(2014, Month.APRIL, 15)), new BookPages((short)1_547), BookGender.LYRICAL);
        Book book2=new Book(new BookIsbn("1111111111111"), new BookTitle("TITLE 2"), new BookAuthor("AUTHOR"), new BookReleaseDate(LocalDate.of(2019, Month.JANUARY, 2)), new BookPages((short)6_789), BookGender.LYRICAL);
        Book book3=new Book(new BookIsbn("1111111111111"), new BookTitle("TITLE 3"), new BookAuthor("AUTHOR"), new BookReleaseDate(LocalDate.of(2011, Month.OCTOBER, 20)), new BookPages((short)4_151), BookGender.ROMANCE);

        System.out.println(book1.toString());
        System.out.println(book2.toString());
        System.out.println(book3.toString());

        book3.lead();

        System.out.println(book3.toString()); */

        // UserController u=new UserController();
        // u.userRun();
        // BookController b=new BookController();
        // b.bookRun();
        String datee="2030/10/23";
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate=LocalDate.parse(datee, formatter);
        dateValidator(localDate);
    }
    private static void dateValidator(LocalDate param){
        /* if (LocalDate.now().getYear()!=param.getYear()) {
            throw new BookLoanDateInvalidException("Loan date must be current year.");
        } */
        System.out.println(LocalDate.now()+" added 1.800 days "+LocalDate.now().plusDays(1_800));
        if (!param.isAfter(LocalDate.now())) {
            throw new RuntimeException("Loan date cannot be earlier of current date.");
        }
        System.out.println("Is after.");
        if (!param.isBefore(LocalDate.now().plusDays(1_800))) {
            throw new RuntimeException("Is after 1800 days.");
        }
        System.out.println("Is before to 1800 days.");
    }
}
