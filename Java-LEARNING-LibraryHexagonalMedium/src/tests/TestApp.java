package tests;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import modules.books.domain.models.Book;
import modules.books.domain.models.valueObjects.BookAuthor;
import modules.books.domain.models.valueObjects.BookIsbn;
import modules.books.domain.models.valueObjects.BookPages;
import modules.books.domain.models.valueObjects.BookReleaseDate;
import modules.books.domain.models.valueObjects.BookTitle;
import modules.books.domain.models.valueObjects.enums.BookGender;
import modules.books.infrastructure.adapters.inbound.controllers.BookController;
import modules.books.infrastructure.adapters.outbound.repositories.BookRepositoryInMemory;
import modules.loans.app.services.BookLoanService;
import modules.loans.infrastructure.adapters.inbound.controllers.BookLoanController;
import modules.loans.infrastructure.adapters.outbound.repositories.BookLoanRepositoryInMemory;
import modules.users.infrastructure.adapters.inbound.controllers.UserController;
import modules.users.infrastructure.adapters.outbound.repositories.UserRepositoryInMemory;

public class TestApp {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

//         UserController u=new UserController();
//         u.userRun();
//        BookController b=new BookController();
//        b.bookRun();
//        BookLoanController blc=new BookLoanController();
//        blc.loanRun();
        System.out.println(LocalDate.now().format(formatter));
    }
}
