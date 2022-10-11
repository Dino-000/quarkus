package com.axonactive.rest.api;

import com.axonactive.enity.BookEntity;
import com.axonactive.repository.BookRepository;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    @Inject
    BookRepository bookRepository;
    @Inject
    Logger log;

//    @GET
//    public List<BookEntity> getAllBook() {
//        log.info("Return all of books");
//        return bookRepository.getAllBook();
//    }
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
    @Operation(summary = "Creates a Book", description = "Creates a Book with ISBN number")

    public Response createABook(@FormParam("title") String title,@FormParam("author")String author,@FormParam("year") int yearOfPublication,@FormParam("genre") String genre){
        BookEntity bookEntity = new BookEntity("13-Microservice",title,author,yearOfPublication,genre, Instant.now());
        log.info("Book created "+bookEntity);
        return  Response.status(201).entity(bookEntity).build();
    }

}
