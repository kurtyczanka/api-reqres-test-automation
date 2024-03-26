import io.restassured.response.Response;
import main.UserClient;
import main.UserData;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertAll;

public class UserTest {
    @ParameterizedTest
    @CsvSource({
            "1, george.bluth@reqres.in, George, Bluth, https://reqres.in/img/faces/1-image.jpg",
            "2, janet.weaver@reqres.in, Janet, Weaver, https://reqres.in/img/faces/2-image.jpg",
            "12, rachel.howell@reqres.in, Rachel, Howell, https://reqres.in/img/faces/12-image.jpg"
    })
    void  testSingleUserDataShouldBeCorrect(
            int id, String email, String firstName, String lastName, String avatar) {
        UserData response = UserClient.listSingleUser(id).as(UserData.class);
                assertAll(
                () -> Assertions.assertEquals(id, response.getData().getId()),
                () -> Assertions.assertEquals(email, response.getData().getEmail()),
                () -> Assertions.assertEquals(firstName, response.getData().getFirstName()),
                () -> Assertions.assertEquals(lastName, response.getData().getLastName()),
                () -> Assertions.assertEquals(avatar, response.getData().getAvatar()));

    }

    @ParameterizedTest
    @CsvSource({"0", "13"})
    void testGettingNonExistentSingleUserShouldReturn404(int id) {
        Response response = UserClient.listSingleUser(id);

        Assertions.assertEquals(HttpStatus.SC_NOT_FOUND, response.getStatusCode());
    }
}
