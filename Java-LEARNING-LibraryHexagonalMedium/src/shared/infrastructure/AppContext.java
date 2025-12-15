package shared.infrastructure;

import modules.books.app.services.BookService;
import modules.books.infrastructure.adapters.inbound.controllers.BookController;
import modules.books.infrastructure.adapters.outbound.repositories.BookRepositoryInMemory;
import modules.loans.app.services.BookLoanService;
import modules.loans.infrastructure.adapters.inbound.controllers.BookLoanController;
import modules.loans.infrastructure.adapters.outbound.repositories.BookLoanRepositoryInMemory;
import modules.users.app.services.UserService;
import modules.users.infrastructure.adapters.inbound.controllers.UserController;
import modules.users.infrastructure.adapters.outbound.repositories.UserRepositoryInMemory;
import shared.infrastructure.adapters.inbound.controllers.SharedController;
import shared.infrastructure.datas.seeders.Seeder;

public class AppContext {
    public static SharedController build(){
        UserRepositoryInMemory userRepository = new UserRepositoryInMemory();
        BookRepositoryInMemory bookRepository = new BookRepositoryInMemory();
        BookLoanRepositoryInMemory loanRepository = new BookLoanRepositoryInMemory();
        UserService userService = new UserService(userRepository);
        BookService bookService = new BookService(bookRepository);
        BookLoanService loanService = new BookLoanService(
                loanRepository,
                bookRepository,
                userRepository
        );

        new Seeder(
                loanService,
                bookService,
                userService
        ).load();
        return new SharedController(
                new BookController(bookService),
                new UserController(userService),
                new BookLoanController(loanService)
        );
    }
}
