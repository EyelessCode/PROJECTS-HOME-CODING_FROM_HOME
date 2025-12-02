package modules.books.infrastructure.adapters.outbound.repositories;

import java.time.LocalDate;
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
    // private byte currentId=1;
    private Map<BookId,Book>bookMemory=new HashMap<>();

    public BookRepositoryInMemory(){
        bookMemory.putIfAbsent(new BookId((byte)1), new Book(
            new BookIsbn("9788490627568"),
            new BookTitle("The Little Prince"),
            new BookAuthor("Antoine de Saint Exupéry"),
            new BookReleaseDate(LocalDate.of(1943, 4, 6)),
            new BookPages((short)96),
            BookGender.NARRATIVE
        ));

        bookMemory.putIfAbsent(new BookId((byte)2), new Book(
            new BookIsbn("9780060883287"),
            new BookTitle("One Hundred Years of Solitude"),
            new BookAuthor("Gabriel García Márquez"),
            new BookReleaseDate(LocalDate.of(1967, 5, 30)),
            new BookPages((short)417),
            BookGender.NARRATIVE
        ));

        bookMemory.putIfAbsent(new BookId((byte)3), new Book(
            new BookIsbn("9780143126393"),
            new BookTitle("The Shadow of the Wind"),
            new BookAuthor("Carlos Ruiz Zafón"),
            new BookReleaseDate(LocalDate.of(2001, 4, 12)),
            new BookPages((short)487),
            BookGender.MYSTERY
        ));

        bookMemory.putIfAbsent(new BookId((byte)4), new Book(
            new BookIsbn("9780060934347"),
            new BookTitle("Don Quixote"),
            new BookAuthor("Miguel de Cervantes"),
            new BookReleaseDate(LocalDate.of(1605, 1, 16)),
            new BookPages((short)992),
            BookGender.CLASSIC
        ));

        bookMemory.putIfAbsent(new BookId((byte)5), new Book(
            new BookIsbn("9780439023528"),
            new BookTitle("The Hunger Games"),
            new BookAuthor("Suzanne Collins"),
            new BookReleaseDate(LocalDate.of(2008, 9, 14)),
            new BookPages((short)374),
            BookGender.SCIENCE_FICTION
        ));
    }

    @Override
    public Book create(Book book) {
        Book newBook=bookMemory.putIfAbsent(new BookId(null), book);
        return newBook;
    }

    @Override
    public Book update(Book book) {
        Optional<Map.Entry<BookId,Book>>exist=bookMemory.entrySet().stream()
            .filter(b->b.getValue().getIsbn().getValue().equals(book.getIsbn().getValue())).findFirst();
        BookId id=exist.get().getKey();
        Book updatedBook=bookMemory.put(id, book);
        return updatedBook;
    }

    @Override
    public void delete(BookId id) {
        bookMemory.remove(id);
    }

    @Override
    public List<Book> getAll() {
        return bookMemory.values().stream().toList();
    }

    @Override
    public Optional<Book> getById(BookId id) {
        return Optional.ofNullable(bookMemory.get(id));
    }
}
