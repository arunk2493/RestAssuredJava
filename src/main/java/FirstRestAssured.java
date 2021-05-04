import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class FirstRestAssured {

    public static String url ="http://demo.guru99.com/V4/sinkministatement.php";

    public static void getResponseBody(){
        RestAssured.given().when().get("http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1")
                .then().log().all();
    }
    public static void getResponse(){
        RestAssured.given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1")
                .when().get("http://demo.guru99.com/V4/sinkministatement.php").then().log()
                .body();

    }
    public static void getStatusCode(){
        int statusCode= RestAssured.given().queryParam("CUSTOMER_ID","68195")
                .queryParam("PASSWORD","1234!")
                .queryParam("Account_No","1") .when().get("http://demo.guru99.com/V4/sinkministatement.php").getStatusCode();
        System.out.println("The response status is "+statusCode);

        RestAssured.given().when().get("http://demo.guru99.com/V4/sinkministatement.php").then().assertThat().statusCode(200);
    }
    public static void getResponseHeaders(){
        System.out.println("The headers in the response "+
                RestAssured.get("http://demo.guru99.com/V4/sinkministatement.php").then().extract()
                        .headers());
    }
    public static void getResponseTime(){
        System.out.println("The time taken to fetch the response "+RestAssured.get(url)
                .timeIn(TimeUnit.MILLISECONDS) + " milliseconds");
    }
    public static void getResponseContentType(){
        System.out.println("The content type of response "+
                RestAssured.get(url).then().extract()
                        .contentType());
    }

    public static void main(String[] args){
        /*getResponseBody();
        System.out.println("-------------------------");
        getResponse();
        System.out.println("-------------------------");
        getStatusCode();
        System.out.println("-------------------------");
        getResponseHeaders();
        System.out.println("-------------------------");
        getResponseTime();
        System.out.println("-------------------------");
        getResponseContentType();*/
        //getSpecificPartOfResponseBody();


    }
}
