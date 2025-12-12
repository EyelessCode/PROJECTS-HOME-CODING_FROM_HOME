package shared.infrastructure.datas.seeders;

import modules.books.app.services.BookService;
import modules.books.infrastructure.adapters.outbound.repositories.BookRepositoryInMemory;
import modules.loans.app.services.BookLoanService;
import modules.loans.infrastructure.adapters.outbound.repositories.BookLoanRepositoryInMemory;
import modules.users.app.services.UserService;
import modules.users.infrastructure.adapters.outbound.repositories.UserRepositoryInMemory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Seeder {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private final BookLoanService loanService;
    private final BookService bookService;
    private final UserService userService;

    public Seeder(){
        BookLoanRepositoryInMemory loanRepository=new BookLoanRepositoryInMemory();
        BookRepositoryInMemory bookRepository=new BookRepositoryInMemory();
        UserRepositoryInMemory userRepository=new UserRepositoryInMemory();

        this.userService=new UserService(userRepository);
        this.bookService=new BookService(bookRepository);
        this.loanService=new BookLoanService(loanRepository,bookRepository,userRepository);
    }

    public void load(){
        preLoadUsers();
        preLoadBooks();
        preLoadLoan();
    }

    private void preLoadLoan(){
        loanService.saveLoan(
                "0974852960",
                "9788490627568",
                LocalDate.now().format(formatter),
                String.valueOf(ChronoUnit.DAYS.between(
                        LocalDate.now(),
                        LocalDate.now().plusMonths(1))
                )
        );
        loanService.saveLoan(
                "0985987874",
                "9780060883287",
                LocalDate.now().format(formatter),
                String.valueOf(ChronoUnit.DAYS.between(
                        LocalDate.now(),
                        LocalDate.now().plusDays(4))
                )
        );
        loanService.saveLoan(
                "0969963695",
                "9780143126393",
                LocalDate.now().format(formatter),
                String.valueOf(ChronoUnit.DAYS.between(
                        LocalDate.now(),
                        LocalDate.now().plusWeeks(2))
                )
        );
    }

    private void preLoadUsers(){
        userService.createUser(
                "0974852960",
                "Roberto",
                "Mendoza",
                "M",
                (byte)29
        );
        userService.createUser(
                "0985987874",
                "Daniel",
                "Mendoza",
                "M",
                (byte)23
        );
        userService.createUser(
                "0969963695",
                "Lenin",
                "Castillo",
                "M",
                (byte)41
        );
        userService.createUser(
                "0958852100",
                "Esther",
                "Verdezoto",
                "F",
                (byte)14
        );
        userService.createUser(
                "0990010147",
                "Nicole",
                "Demara",
                "F",
                (byte)21
        );
    }

    private void preLoadBooks(){
        bookService.saveBook(
                "9788490627568",
                "The Little Prince",
                "Antoine de Saint Exupéry",
                "1943/04/06",
                (short)96,
                "NARRATIVE"
        );
        bookService.saveBook(
                "9780060883287",
                "One Hundred Years of Solitude",
                "Gabriel García Márquez",
                "1967/05/30",
                (short)417,
                "NARRATIVE"
        );
        bookService.saveBook(
                "9780143126393",
                "The Shadow of the Wind",
                "Carlos Ruiz Zafón",
                "2001/04/12",
                (short)487,
                "MYSTERY"
        );
        bookService.saveBook(
                "9780060934347",
                "Don Quixote",
                "Miguel de Cervantes",
                "1605/01/16",
                (short)992,
                "CLASSIC"
        );
        bookService.saveBook(
                "9780439023528",
                "The Hunger Games",
                "Suzanne Collins",
                "2008/09/14",
                (short)374,
                "SCIENCE_FICTION"
        );
    }
}
