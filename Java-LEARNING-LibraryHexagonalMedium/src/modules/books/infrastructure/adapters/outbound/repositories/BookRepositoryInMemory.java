package modules.books.infrastructure.adapters.outbound.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import modules.books.domain.models.Book;
import modules.books.domain.models.valueObjects.BookId;
import modules.books.domain.ports.outport.IBookRepositoryOutport;

public class BookRepositoryInMemory implements IBookRepositoryOutport{
    private final Map<BookId,Book>bookMemory=new HashMap<>();

    @Override
    public Book create(Book book) {
        return bookMemory.putIfAbsent(book.getId(), book);
    }

    @Override
    public Book update(Book book) {
        Optional<Map.Entry<BookId,Book>>exist=bookMemory.entrySet().stream()
            .filter(b->b.getValue().getIsbn().getValue().equals(book.getIsbn().getValue())).findFirst();
        BookId id=exist.get().getKey();
        return bookMemory.put(id, book);
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
