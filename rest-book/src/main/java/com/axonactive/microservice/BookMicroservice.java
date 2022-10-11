package com.axonactive.microservice;

import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        info   = @Info(
                title = "Book API",
                description = "Creates Books",
                version = "1.0",
                contact = @Contact(name ="@axonactive", url="https://www.axonactive.com")
        ),
        externalDocs = @ExternalDocumentation(url = "www.google.com", description = "All the Microservice code"),
        tags = {
                @Tag(name="api", description ="Public API"),
                @Tag(name = "books", description = "Interested in books")
        }
)
public class BookMicroservice extends Application {
}
