package API;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Objects;

import static io.restassured.RestAssured.given;

@DisplayName("API tests for /posts endpoint")
public class ApiTest {
    private final static String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @Test
    @DisplayName("GET /posts returns a list of 5000 photos with valid IDs")
    public void testGetAllPhotos5000Responses() {
        Response response = given()
                .baseUri(BASE_URL)
                .when()
                .get("/photos")
                .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .extract().response();

        List<Integer> ids = response.jsonPath().getList("id");

        Assertions.assertEquals(5000, ids.size(), "Should return 5000 photos");
        Assertions.assertTrue(ids.stream().allMatch(Objects::nonNull), "All ids should be non-null");
    }
}