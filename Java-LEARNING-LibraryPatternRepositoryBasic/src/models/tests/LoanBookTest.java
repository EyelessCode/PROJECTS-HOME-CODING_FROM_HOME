package models.tests;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import models.Book;
import models.User;
import models.enums.GenderBook;

public class LoanBookTest {
    private Integer id;
    private final LocalDate checkIn,checkOut;
    private final Book book;
    private final User user;
    private final long daysRemaining;

    public LoanBookTest(LocalDate checkIn, LocalDate checkOut, Book book, User user) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.book = book;
        this.user = user;
        this.daysRemaining = ChronoUnit.DAYS.between(checkIn, checkOut);

        book.setAvailable(false);
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public long getDaysRemaining() {
        return daysRemaining;
    }

    @Override
    public String toString() {
        return "LoanBook [id=" + id + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", book=" + book.getTitle() + ", user="
                + user.getName()+" "+user.getLastname() + ", daysRemaining=" + daysRemaining + "]";
    }

    public static void main(String[] args) {
        // Préstamo original: del 10 al 15 de enero
        LocalDate checkIn = LocalDate.of(2025, 1, 10);
        LocalDate checkOut = LocalDate.of(2025, 1, 15);

        // Nuevo intento de préstamo
        LocalDate nuevoIn1 = LocalDate.of(2025, 1, 12);
        LocalDate nuevoOut1 = LocalDate.of(2025, 1, 14);

        LocalDate nuevoIn2 = LocalDate.of(2025, 1, 14);
        LocalDate nuevoOut2 = LocalDate.of(2025, 1, 18);

        LocalDate nuevoIn3 = LocalDate.of(2025, 1, 15);
        LocalDate nuevoOut3 = LocalDate.of(2025, 1, 20);

        /* System.out.println("Prueba 1 (12 al 14): " + overlaps(checkIn, checkOut, nuevoIn1, nuevoOut1));
        System.out.println("Prueba 2 (14 al 18): " + overlaps(checkIn, checkOut, nuevoIn2, nuevoOut2));
        System.out.println("Prueba 3 (15 al 20): " + overlaps(checkIn, checkOut, nuevoIn3, nuevoOut3)); */

        User u1=new User("NAME 1", "LASTANAME 1", "IC 1", (byte)28, 'M');
        User u2=new User("NAME 2", "LASTANAME 2", "IC 2", (byte)18, 'F');
        User u3=new User("NAME 3", "LASTANAME 3", "IC 3", (byte)25, 'M');
        User u4=new User("NAME 4", "LASTANAME 4", "IC 4", (byte)20, 'F');

        Book b1=new Book("TITLE 1", "AUTHOR 1", "IBN 1", GenderBook.ADVENTURE, LocalDate.of(2024, 8, 28));
        Book b2=new Book("TITLE 2", "AUTHOR 2", "IBN 2", GenderBook.ADVENTURE, LocalDate.of(2024, 8, 28));
        Book b3=new Book("TITLE 3", "AUTHOR 3", "IBN 3", GenderBook.ADVENTURE, LocalDate.of(2024, 8, 28));
        Book b4=new Book("TITLE 4", "AUTHOR 4", "IBN 4", GenderBook.COMEDY, LocalDate.of(2024, 8, 28));

        LoanBookTest lbt1=new LoanBookTest(LocalDate.now(), LocalDate.now().plusDays(7), b1, u1);
        LoanBookTest lbt2=new LoanBookTest(LocalDate.now(), LocalDate.now().plusDays(9), b2, u1);
        LoanBookTest lbt3=new LoanBookTest(LocalDate.now(), LocalDate.now().plusDays(4), b3, u1);
        LoanBookTest lbt4=new LoanBookTest(LocalDate.of(2025, 11, 24), LocalDate.of(2025, 11, 28), b3, u4);

        Map<Integer,LoanBookTest> memory=new HashMap<>();
        memory.put(1, lbt1);
        memory.put(2, lbt2);
        memory.put(3, lbt3);
        memory.put(4, lbt4);
        System.out.println("=".repeat(5));
        memory.entrySet().forEach(System.out::println);
        System.out.println("=".repeat(5));
        // memory.values().stream().filter(m->m.getBook().isAvailable()==false).forEach(System.out::println);

        memory.values().stream().forEach(System.out::println); // listar todos los prestamos
        memory.values().stream().filter(l->l.getUser().getName()=="NAME 4").forEach(System.out::println); // listar todos los prestamos
        // memory.values().stream().filter(u->u.getUser().getAge()>21).forEach(System.out::println); //? Test
        
        //todo: SABER DE LA INFO DE LOS LIBROS!
        Map<Integer,Book> memoryBook=new HashMap<>();
        memoryBook.put(1, b1);
        memoryBook.put(2, b2);
        memoryBook.put(3, b3);
        memoryBook.put(4, b4);
        // memoryBook.values().stream().filter(m->m.isAvailable()==false).forEach(System.out::println); // disponible o no
        // memoryBook.values().stream().forEach(System.out::println); // mostrar todos
    }

    // Método helper para ver si se cruzan los rangos de fechas
    public static boolean overlaps(LocalDate checkIn, LocalDate checkOut,
                                LocalDate otherIn, LocalDate otherOut) {
        return (!otherOut.isBefore(checkIn)) &&
            (!otherIn.isAfter(checkOut)) &&
            !(otherOut.equals(checkIn) || otherIn.equals(checkOut));
    }
}
