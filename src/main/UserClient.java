package main;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public final class UserClient extends BaseClient {
    private UserClient() {}

    public static Response listSingleUser(int id) {
        return given().spec(requestSpec()).when().get(constructPath(id));
    }

    public static Response createSingleUser(User requestBody) {
        return given().spec(requestSpec()).body(requestBody).when().post("users");
    }

    public static Response updateSingleUserPut(int id, User requestBody) {
        return given().spec(requestSpec()).body(requestBody).when().put(constructPath(id));
    }

    private static String constructPath(int id) {
        return "users/" + id;
    }

}
