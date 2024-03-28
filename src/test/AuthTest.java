import main.Auth;
import main.AuthClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AuthTest {
    @ParameterizedTest
    @CsvSource({"eve.holt@reqres.in, pistol"})
    void testRegisterNewUserShouldReturnToken(String email, String password) {
        Auth response = AuthClient.register(Auth.builder().email(email).password(password).build()).as(Auth.class);

        Assertions.assertNotNull(response.getToken());
    }
}
