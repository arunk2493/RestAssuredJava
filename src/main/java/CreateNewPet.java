import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.File;

public class CreateNewPet {
    String petstatus = "available";

    @Test
    public void createPet(){
        File loadPetData = new File("src//main//resources//newPetData.json");
        RestAssured.given().baseUri("https://petstore.swagger.io/v2/pet").contentType(ContentType.JSON).body(loadPetData)
                .when()
                .post()
                // THEN
                .then().log().body()
                .assertThat().statusCode(200);
    }
    @Test
    public void getPetByStatus(){
        RestAssured.given()
                .queryParam("status="+petstatus)
                .get(" https://petstore.swagger.io/v2/pet/findByStatus")
                // THEN
                .then().log().body()
                .assertThat().statusCode(200);
    }
    @Test
    public void validateGetResponseBody(){
        RestAssured.given()
                .get(" https://petstore.swagger.io/v2/pet/1")
                // THEN
                .then().log().body()
                .assertThat().statusCode(200)
                .body("id",Matchers.equalTo(1))
                .body("category.id",Matchers.equalTo(0)).body("name",Matchers.equalTo("aa"));
    }

}
