package modules.books.domain.models;

import modules.books.domain.models.valueObjects.BookAuthor;
import modules.books.domain.models.valueObjects.BookAvailability;
import modules.books.domain.models.valueObjects.BookIsbn;
import modules.books.domain.models.valueObjects.BookId;
import modules.books.domain.models.valueObjects.BookPages;
import modules.books.domain.models.valueObjects.BookReleaseDate;
import modules.books.domain.models.valueObjects.BookTitle;
import modules.books.domain.models.valueObjects.enums.BookGender;

public class Book {
    private BookId id;
    private BookAvailability availability;
    private final BookIsbn isbn;
    private final BookTitle title;
    private final BookAuthor author;
    private final BookReleaseDate releaseDate;
    private final BookPages pages;
    private final BookGender gender;

    public Book(BookIsbn isbn, BookTitle title, BookAuthor author, BookReleaseDate releaseDate, BookPages pages,
            BookGender gender) {
        this.id=new BookId(null);
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.pages = pages;
        this.gender = gender;
        this.availability=new BookAvailability(true);
    }
    //? For modify
    public Book(BookId id,BookIsbn isbn, BookTitle title, BookAuthor author, BookReleaseDate releaseDate, BookPages pages,
            BookGender gender) {
        this.id=id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.pages = pages;
        this.gender = gender;
        this.availability=new BookAvailability(true);
    }

    public BookId getId() {
        return id;
    }

    public BookIsbn getIsbn() {
        return isbn;
    }

    public BookTitle getTitle() {
        return title;
    }

    public BookAuthor getAuthor() {
        return author;
    }

    public BookReleaseDate getReleaseDate() {
        return releaseDate;
    }

    public BookPages getPages() {
        return pages;
    }

    public BookGender getGender() {
        return gender;
    }

    public BookAvailability getAvailability() {
        return availability;
    }

    public void lead(){
        this.availability=availability.lend();
    }

    public void returnBook(){
        this.availability=availability.returnBook();
    }

    @Override
    public String toString() {
        return(
            "\n"+"=".repeat(5)+" BOOK "+"=".repeat(5)+
            "\nID: "+id.getValue()+"\tISBN: "+isbn.getValue()+
            "\nTITLE: "+title.getValue()+
            "\nAUTHOR: "+author.getValue()+"\tRELEASE DATE: "+releaseDate.getValue()+
            "\nPAGES: "+pages.getValue()+"\tGENDER: "+gender.getDescription()+
            "\n== AVAILABILITY: "+availability.toString()+" =="+
            "\n"+"=".repeat(12)
        );
    }
}
