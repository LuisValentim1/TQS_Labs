import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import org.hamcrest.core.IsEqual;
import static org.junit.jupiter.api.Assertions.*;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class MyFirstRESTAClass {

    @Test
    public static void getResponseBody(){
        given().when().get("https://jsonplaceholder.typicode.com/todos").then().log()
                .all();

    }

    @Test
    public static void getResponseBodyQueryAll(){

        given().when().get("https://jsonplaceholder.typicode.com/todos").then().log()
                .body();
    }

    @Test
    public static void getResponseBodyQuery4(){

        List<Object> title = given().queryParam("id","4")
                .when().get("https://jsonplaceholder.typicode.com/todos").then().extract().path("title");

        assertEquals( "et porro tempora",  title.get(0));
    }

    @Test
    public static void getResponseBodyQueryContainsIds(){

        List<Object> ids = given().when().get("https://jsonplaceholder.typicode.com/todos").then().extract().path("id");
        assertTrue(ids.contains(199) && ids.contains(198));
    }
}
