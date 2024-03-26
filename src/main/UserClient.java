package main;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public final class UserClient extends BaseClient {
    private UserClient() {}

    public static Response listSingleUser(int id) {
        return given().when().get(constructPath(id));
    }

    public static Response createSingleUser(User requestBody){
        return given().body(requestBody).when().post("users");
    }

    private static String constructPath(int id) {
        return "users/" + id;
    }

}
