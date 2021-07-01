import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ResponseTest {
    @Test
    public void createOrderOnlyIfInventoryIsAvailable(){
        /*Run the tests only if available inventory is greater than 0 and print the order ID*/

        String inventory = given()
                .baseUri("https://petstore.swagger.io")
                .when()
                .get("/v2/store/inventory")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response()
                .asString();

        JsonPath jsonPath = new JsonPath(inventory);
        int available = jsonPath.getInt("available");

        if (available> 0){
            File loadOrderData = new File("src//main//resources//storeOrderData.json");
            String response = given().baseUri("https://petstore.swagger.io").contentType(ContentType.JSON).body(loadOrderData)
                    .when()
                    .post("/v2/store/order")
                    // THEN
                    .then().log().body()
                    .assertThat().statusCode(200)
                    .extract()
                    .response()
                    .asString();

            jsonPath = new JsonPath(response);
            System.out.println("Order ID --------------> "+jsonPath.getLong("id"));
        }
    }
}
