import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.hamcrest.Matchers.*;

public class TestNGRestAssuredGet {

    @Test
    public void test() {

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.statusLine());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }

    @Test
    public void test1() {

        RestAssured.given().get("https://reqres.in/api/users?page=2").then().assertThat().statusCode(200).body("data.id[0]", Matchers.equalTo(7));

    }
    @Test
    public void test2() {

        RestAssured.given().get("https://reqres.in/api/users?page=2").then().
                statusCode(200).
                body("data.id[1]", Matchers.equalTo(8)).
                body("data.first_name", Matchers.hasItems("Michael","Lindsay")).
                log().all();

    }
    @Test
    public void testGet() {

        RestAssured.given().
                get("https://reqres.in/api/users/584").then().
                statusCode(200).
                log().body();

    }

}
