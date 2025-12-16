package modules.loans.app.services.dtos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record BookLoanDTO (
        // IDs
        Byte id,
        Byte userId,
        Byte bookId,
        // User model
        String userIc,
        String userName,
        String userLastName,
        String userGender,
        Byte userAge,
        // User model
        String bookIsbn,
        String bookTitle,
        String bookAuthor,
        LocalDate bookReleaseDate,
        Short bookPages,
        String bookGender,
        // Loan model
        LocalDate deliveryDate,
        LocalDate returnDate,
        Long remainingDays
){
    @Override
    public String toString() {
        return (
                "\n"+"=".repeat(3)+"ID: "+id+"=".repeat(3)+" Loan by "+userLastName+" "+userName+" "+"=".repeat(6)+
                        "\ttoday date: "+LocalDate.now()+
                "\n"+"+".repeat(3)+" Book "+"+".repeat(3)+
                "\n"+"ISBN: "+bookIsbn+"\tTitle: "+bookTitle+"\tAuthor: "+bookAuthor+"\tGender: "+bookGender+
                "\n"+"+".repeat(3)+" User "+"+".repeat(3)+
                "\n"+"IC: "+userIc+"\tfullname: "+userName+" "+userLastName+"\tGender: "+userGender+"\tAge: "+userAge+
                "\n"+"+".repeat(3)+" Estimated dates "+"+".repeat(3)+
                "\n"+"Delivery Date: "+deliveryDate+"\tReturn Date: "+returnDate+
                        "\t\tRemaining days: >> "+(remainingDays<=0?remainingDays+" [MUST RETURN BOOK]":remainingDays)+" <<"+
                "\n"+"=".repeat(40)
        );
    }
}
