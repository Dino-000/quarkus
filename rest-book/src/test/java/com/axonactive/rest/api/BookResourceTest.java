package com.axonactive.rest.api;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.jboss.resteasy.reactive.RestResponse.StatusCode.OK;

@QuarkusTest
 class BookResourceTest {

//    @Test
//    void  shouldGetAllBook(){
//        given().header(ACCEPT,APPLICATION_JSON).when().get("api/books").then().statusCode(OK).body("size()",is(4));
//    }
//
//    @Test
//    void  shouldCountAllBooks(){
//        given().header(ACCEPT,APPLICATION_JSON).when().get("api/books/count").then().statusCode(OK).body(is("4"));
//    }
//
//    @Test
//    public void  shouldGetABook(){
//        given().header(ACCEPT,APPLICATION_JSON)
//                .pathParams("id",1).when().get("api/books/{id}")
//                .then().statusCode(OK).
//                body("author", is("Victor Hugo")).
//                body("genre", is("short stories")).
//                body("title", is("Les miRable")).
//                body("yearOfPublication", is(2000))
//        ;
//    }

    @Test
    void shouldCreateABook(){
        given()
                .formParam("title","Understanding Quarkus")
                .formParam("author","Antonio Goncalves")
                .formParam("year",2000)
                .formParam("genre","IT").when()
                .post("api/books")
                .then()
                .body("isbn_13",startsWith("13-"))
                .body("title",is("Understanding Quarkus"))
                .body("author",is("Antonio Goncalves"))
                .body("year_of_publication",is(2000))
                .body("genre",is("IT"))
                .body("creation_date",startsWith("20"));
    }

}
