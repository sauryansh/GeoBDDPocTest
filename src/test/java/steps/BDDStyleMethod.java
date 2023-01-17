package steps;

import io.restassured.http.ContentType;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

public class BDDStyleMethod {

        public static void simpleGETPost(String postNumber) {
            given()
                    .contentType(ContentType.JSON)
            .when()
                    .get("http://localhost:3000/posts/" + postNumber)
            .then().statusCode(200)
                    .body("author", is("KK")).statusCode(200);
        }

        public static void performContainsCollection() {
            given().contentType(ContentType.JSON).
            when()
                    .get("http://localhost:3000/posts")
            .then().statusCode(200)
                    .body("author", hasItems("KK", "James Gosling")).statusCode(200);
        }

        public static void performGetWithPathParameters(String postNumber) {
            given()
                    .contentType(ContentType.JSON)
            .with()
                    .pathParams("post", postNumber)
                    .when()
             .get("http://localhost:3000/posts/{post}")
                    .then().statusCode(200)
                    .body("author", is("KK")).statusCode(200);
        }

    public static void performQueryParameter(String postId, String value) {
            given()
                .contentType(ContentType.JSON)
                .queryParam(postId, value)
                .when()
                .get("http://localhost:3000/posts/")
                .then().statusCode(200)
                .body("author", hasItems("KK")).statusCode(200);
    }

    public static void performPOSTWithBodyParameter(){
        HashMap<String, String> body = new HashMap<String, String>();

        body.put("id", "5");
        body.put("title", "Rest Assured");
        body.put("author", "KK");

        given()
                .contentType(ContentType.JSON)
        .with()
                .body(body)
         .when()
                .post("http://localhost:3000/posts")
         .then().statusCode(201);
    }
}
