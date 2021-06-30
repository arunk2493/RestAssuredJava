import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

public class SampleTest {
    String petstatus = "available";
    @Test
    public void getPetByStatus(){
        RestAssured.given()
                .get(" https://petstore.swagger.io/v2/pet/findByStatus?status="+petstatus)
                // THEN
                .then().log().body()
                .assertThat().statusCode(200);
    }
}
