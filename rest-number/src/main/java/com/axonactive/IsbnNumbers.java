package com.axonactive;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import java.time.Instant;

@Schema(description = "Several ISBN numbers for books")

public class IsbnNumbers {
    @JsonbProperty("isbn_10")
    public String isbn10;
    @JsonbProperty("isbn_13")

    public String isbn13;
    @JsonbTransient
    public Instant generationDate;

    public IsbnNumbers(String isbn10, String isbn13, Instant generationDate) {
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
        this.generationDate = generationDate;
    }

    public IsbnNumbers() {
    }

    @Override
    public String toString() {
        return "IsbnNumbers{" +
                "isbn10='" + isbn10 + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                ", generationDate=" + generationDate +
                '}';
    }
}
