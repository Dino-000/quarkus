package com.axonactive.enity;


import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import java.time.Instant;


@Schema(description = "A book")
public class BookEntity {
    @JsonbProperty("isbn_13")
    @Schema(required = true)
    private String isbn13;
    @Schema(required = true)

    private String title;
    private String author;
    @JsonbProperty("year_of_publication")
    private int yearOfPublication;
    private String genre;

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    @JsonbDateFormat("yyyy-MM-dd")
    @JsonbProperty("creation_date")
    @Schema(implementation = String.class, format = "date")

    private Instant creationDate;

    public BookEntity(String isbn13, String title, String author, int yearOfPublication, String genre, Instant creationDate) {
        this.isbn13 = isbn13;
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.genre = genre;
        this.creationDate = creationDate;
    }
}
