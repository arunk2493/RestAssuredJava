import io.restassured.RestAssured;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TestNGRestAssuredPOST {
    @Test
    public void test3() {

        JSONObject request = new JSONObject();
        request.put("name", "chaya");
        request.put("job", "QA");

        System.out.println(request);
        System.out.println(request.toString());

        RestAssured.given().
                body(request.toJSONString()).
                when().
                post("https://reqres.in/api/users").
                then().statusCode(201).log().all();

    }
    @Test
    public void testPUT() {

        JSONObject request = new JSONObject();
        request.put("name", "chaya");
        request.put("job", "BAA");

        System.out.println(request);
        System.out.println(request.toString());

        RestAssured.given().
                body(request.toJSONString()).
                when().
                put("https://reqres.in/api/users/2").
                then().statusCode(200).log().body();

    }
    @Test
    public void testDelete() {

        JSONObject request = new JSONObject();
        RestAssured.given().
                body(request.toJSONString()).
                when().
                delete("https://reqres.in/api/users/2").
                then().statusCode(204).
                log().body();

    }
}
