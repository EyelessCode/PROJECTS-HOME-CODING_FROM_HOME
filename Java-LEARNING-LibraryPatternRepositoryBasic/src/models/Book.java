package models;

import java.time.LocalDate;

import models.enums.GenderBook;

public class Book {
    private Integer id;
    private String title,author,ibn;
    private GenderBook gender;
    private LocalDate releaseDate;
    private boolean available=true;

    public Book(String title, String author, String ibn, GenderBook gender, LocalDate releaseDate) {
        this.title = title;
        this.author = author;
        this.ibn = ibn;
        this.gender = gender;
        this.releaseDate = releaseDate;
    }

    public Book(Integer id,String title, String author, String ibn, GenderBook gender, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ibn = ibn;
        this.gender = gender;
        this.releaseDate = releaseDate;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIbn() {
        return ibn;
    }

    public GenderBook getGender() {
        return gender;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", ibn=" + ibn + ", gender=" + gender
                + ", releaseDate=" + releaseDate + ", available=" + available + "]";
    }
}
