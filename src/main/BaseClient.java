package main;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class BaseClient {
    protected static RequestSpecification requestSpec() {
        final RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
        return requestBuilder
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .setBaseUri("https://reqres.in/api/").build();
    }
}
