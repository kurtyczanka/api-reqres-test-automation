import io.restassured.response.Response;
import main.ResourceClient;
import main.ResourceData;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertAll;

public class ResourceTest {

    @ParameterizedTest
    @CsvSource({
            "2, fuchsia rose, 2001, #C74375, 17-2031",
            "5, tigerlily, 2004, #E2583E, 17-1456"
    })
    void testSingleResourceDataShouldBeCorrect(
            int id, String name, int year, String color, String pantoneValue) {
        ResourceData response = ResourceClient.listSingleResource(id).as(ResourceData.class);

        assertAll(
                () -> Assertions.assertEquals(id, response.getData().getId()),
                () -> Assertions.assertEquals(name, response.getData().getName()),
                () -> Assertions.assertEquals(year, response.getData().getYear()),
                () -> Assertions.assertEquals(color, response.getData().getColor()),
                () -> Assertions.assertEquals(pantoneValue, response.getData().getPantoneValue()));
    }

    @ParameterizedTest
    @CsvSource({"0", "23"})
    void testGettingNonExistentSingleResourceShouldReturn404(int id) {
        Response response = ResourceClient.listSingleResource(id);

        Assertions.assertEquals(HttpStatus.SC_NOT_FOUND, response.getStatusCode());
    }
}
