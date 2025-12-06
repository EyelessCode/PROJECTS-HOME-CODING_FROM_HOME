package modules.loans.app.services.dtos;

import java.time.LocalDate;

public record BookLoanDTO (
        Byte id,
        Byte userId,
        Byte bookId,
        String userIc,
        String userName,
        String userLastName,
        String bookIsbn,
        String bookTitle,
        String bookAuthor,
        LocalDate deliveryDate,
        LocalDate returnDate
){}
