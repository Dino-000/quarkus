package com.axonactive.rest.api;

import com.axonactive.enity.BookEntity;
import com.axonactive.microservice.NumberProxy;
import com.axonactive.repository.BookRepository;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.List;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    @Inject
    BookRepository bookRepository;
    @Inject
    Logger log;

    @Inject
    @RestClient
    NumberProxy proxy;


    @GET
    public List<BookEntity> getAllBook() {
        log.info("Return all of books");

        return bookRepository.getAllBook();
    }
//
//    @GET
//    @Path("count")
//    @Produces(MediaType.APPLICATION_JSON)
//    public int countAllBooks() {
//        log.info("Return number of books");
//
//        return bookRepository.countAllBooks();
//    }

//    @GET
//    @Path("{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Optional<BookEntity> getBook(@PathParam("id") int id) {
//        log.info("Return a books with id " + id);
//
//        return bookRepository.getBook(id);
//    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Operation(
            summary = "Creates a Book",
            description = "Creates a Book with ISBN number")
//    @Retry(maxRetries = 3,delay = 3000)
//    @Fallback(
//            fallbackMethod = "fallingbackOnCreatingABook"
//    )
    public Response createABook(@FormParam("title") String title, @FormParam("author") String author, @FormParam("year") int yearOfPublication, @FormParam("genre") String genre) {
        BookEntity bookEntity = new BookEntity(proxy.generateIsbnNumbers().isbn13, title, author, yearOfPublication, genre, Instant.now());
        log.info("Book created " + bookEntity);
        return Response.status(201).entity(bookEntity).build();
    }

    public Response fallingbackOnCreatingABook(String title, String author, int yearOfPublication, String genre) {
        BookEntity bookEntity = new BookEntity("Will be set later", title, author, yearOfPublication, genre, Instant.now());
        log.warn("Book save on disk: " + bookEntity);
        saveBookOnDisk(bookEntity);
        return Response.status(201).entity(bookEntity).build();
    }

    private void saveBookOnDisk(BookEntity book) {
        String bookJson = JsonbBuilder.create().toJson(book);
        try (PrintWriter out = new PrintWriter("book-" + Instant.now().toEpochMilli() + ".json")) {
            out.println(bookJson);
        } catch (FileNotFoundException e) {
            log.error("can not find file " + e);
        }
    }

}
