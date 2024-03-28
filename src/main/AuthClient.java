package main;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthClient extends BaseClient {
    private AuthClient() {
    }

    public static Response register(Auth requestBody) {
        return given().spec(requestSpec()).contentType(ContentType.JSON).body(requestBody).when().post(constructPath());
    }

    private static String constructPath() {
        return "register";
    }
}


