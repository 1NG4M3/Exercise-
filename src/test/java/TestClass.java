import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestClass {

    @Test
    public void checkId() {
        given()
                .baseUri("https://jsonplaceholder.typicode.com/posts/1")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200);
    }
}
