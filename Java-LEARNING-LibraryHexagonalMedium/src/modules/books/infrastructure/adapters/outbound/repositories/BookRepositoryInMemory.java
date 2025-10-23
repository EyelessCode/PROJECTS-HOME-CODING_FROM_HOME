package modules.books.infrastructure.adapters.outbound.repositories;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import modules.books.domain.models.Book;
import modules.books.domain.models.valueObjects.BookAuthor;
import modules.books.domain.models.valueObjects.BookId;
import modules.books.domain.models.valueObjects.BookIsbn;
import modules.books.domain.models.valueObjects.BookPages;
import modules.books.domain.models.valueObjects.BookReleaseDate;
import modules.books.domain.models.valueObjects.BookTitle;
import modules.books.domain.models.valueObjects.enums.BookGender;
import modules.books.domain.ports.outport.IBookRepositoryOutport;

public class BookRepositoryInMemory implements IBookRepositoryOutport{
    private byte currentId=1;
    private Map<BookId,Book>bookMemory=new HashMap<>();

    public BookRepositoryInMemory(){
        bookMemory.put(new BookId(currentId++), new Book(
            new BookIsbn("9788490627568"),
            new BookTitle("The Little Prince"),
            new BookAuthor("Antoine de Saint-Exupéry"),
            new BookReleaseDate(LocalDate.of(1943, 4, 6)),
            new BookPages((short)96),
            BookGender.NARRATIVE
        ));

        bookMemory.put(new BookId(currentId++), new Book(
            new BookIsbn("9780060883287"),
            new BookTitle("One Hundred Years of Solitude"),
            new BookAuthor("Gabriel García Márquez"),
            new BookReleaseDate(LocalDate.of(1967, 5, 30)),
            new BookPages((short)417),
            BookGender.NARRATIVE
        ));

        bookMemory.put(new BookId(currentId++), new Book(
            new BookIsbn("9780143126393"),
            new BookTitle("The Shadow of the Wind"),
            new BookAuthor("Carlos Ruiz Zafón"),
            new BookReleaseDate(LocalDate.of(2001, 4, 12)),
            new BookPages((short)487),
            BookGender.MYSTERY
        ));

        bookMemory.put(new BookId(currentId++), new Book(
            new BookIsbn("9780060934347"),
            new BookTitle("Don Quixote"),
            new BookAuthor("Miguel de Cervantes"),
            new BookReleaseDate(LocalDate.of(1605, 1, 16)),
            new BookPages((short)992),
            BookGender.CLASSIC
        ));

        bookMemory.put(new BookId(currentId++), new Book(
            new BookIsbn("9780439023528"),
            new BookTitle("The Hunger Games"),
            new BookAuthor("Suzanne Collins"),
            new BookReleaseDate(LocalDate.of(2008, 9, 14)),
            new BookPages((short)374),
            BookGender.SCIENCE_FICTION
        ));
    }

    @Override
    public Book create(String isbn, String title, String author, String releaseDate, Short pages, String gender) {
        DateTimeFormatter formatterDate=DateTimeFormatter.ofPattern("yyyy/MM/dd");
        Book book=new Book(
            new BookIsbn(isbn),
            new BookTitle(title),
            new BookAuthor(author),
            new BookReleaseDate(LocalDate.parse(releaseDate, formatterDate)),
            new BookPages(pages),
            BookGender.genderValidatorFromInput(gender)
        );
        return book;
    }

    @Override
    public void delete(Byte id) {
        bookMemory.remove(new BookId(id));
    }

    @Override
    public List<Book> getAll() {
        return bookMemory.values().stream().toList();
    }

    @Override
    public Optional<Book> getById(Byte id) {
        return Optional.ofNullable(bookMemory.get(new BookId(id)));
    }
}
