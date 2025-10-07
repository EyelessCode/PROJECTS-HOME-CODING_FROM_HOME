package models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LoanBook {
    private Integer id;
    private final LocalDate checkIn,checkOut;
    private final Book book;
    private final User user;
    private final long daysRemaining;

    public LoanBook(LocalDate checkIn, LocalDate checkOut, Book book, User user) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.book = book;
        this.user = user;
        this.daysRemaining = ChronoUnit.DAYS.between(checkIn, checkOut);

        book.setAvailable(false);
    }

    public LoanBook(Integer id,LocalDate checkIn, LocalDate checkOut, Book book, User user) {
        this.id = id;
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

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LoanBook [id=" + id + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", book=" + book.getTitle()+", available= "+book.isAvailable() + ", user="
                + user.getName()+" "+user.getLastname()+ ", daysRemaining=" + daysRemaining + "]";
    }

    public boolean overlaps(LocalDate otherIn,LocalDate otherOut){
        return (!otherIn.isAfter(checkOut)&&!otherOut.isBefore(checkIn))&&!(otherIn.equals(checkOut)||otherOut.equals(checkIn));
    }
}
