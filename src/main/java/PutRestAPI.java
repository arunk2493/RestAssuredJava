import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PutRestAPI {
    @Test
    public void RegistrationSuccessful()
    {
        RestAssured.baseURI ="https://reqres.in/api";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Virender"); // Cast
        requestParams.put("job", "QA");
        request.body(requestParams.toJSONString());
        Response response = request.post("/users");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
        System.out.println(response.jsonPath());
       // String successCode = response.jsonPath().get("SuccessCode");
       // Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
    }
    @Test
    public static void getResponseHeaders(){
        System.out.println("The headers in the response "+
                RestAssured.get("http://demo.guru99.com/V4/sinkministatement.php").then().extract().path("result.statements"));
    }
}
