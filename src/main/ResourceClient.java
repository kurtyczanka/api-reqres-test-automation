package main;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ResourceClient extends BaseClient {

    private ResourceClient() {}

    public static Response listSingleResource(int id) {
        return given().spec(requestSpec()).when().get(constructPath(id));
    }

    private static String constructPath(int id) {
        return "unknown/" + id;
    }
}
