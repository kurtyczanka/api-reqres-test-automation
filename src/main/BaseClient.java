package main;

import io.restassured.RestAssured;

public class BaseClient {

    static {
        RestAssured.baseURI = "https://reqres.in/api/";
    }
}
