package com.axonactive.microservice;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.json.bind.annotation.JsonbProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IsbnThirteen {
    @JsonbProperty("isbn_13")
    public String isbn13;
//    @JsonbProperty("isbn_10")
}
