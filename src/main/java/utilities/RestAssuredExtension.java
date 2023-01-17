package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

//Arrange and Assert Options
public class RestAssuredExtension {
    //Arrange
        //Static implementation of Request Specification
        public static RequestSpecification Request;
        public RestAssuredExtension() {
            RequestSpecBuilder builder = new RequestSpecBuilder();
            builder.setBaseUri("http://localhost:3000");
            builder.setContentType("application/json");
            //Request Specification class to make all kind of request that we can make
            var requestSpec = builder.build();
            Request = RestAssured.given().spec(requestSpec);
        }
        // Simple Constructor so that we can start creating other method.

    //Now Act
    public static void GetOpsWithPathParameter(String url, Map<String,String> pathParams) throws URISyntaxException {
            //Act
        Request.pathParams(pathParams);
        Request.get(new URI(url));
    }

    public static ResponseOptions<Response> GetOps(String url) throws URISyntaxException {
            //Act
        return Request.get(url);
    }

    public static ResponseOptions<Response> PostOpsWithBodyPathParams(String url,
                                                                        Map<String,String> path,
                                                                         Map<String,String> body)  {
        //Act
        Request.pathParams(path);
        Request.body(body);
        return Request.post(url);
    }

    public static ResponseOptions<Response> PostOpsWithBody(String url, Map<String,String> body)  {
        //Act
        Request.body(body);
        return Request.post(url);
    }

    public static ResponseOptions<Response> DeleteOpsWithPathParams(String url,
            Map<String,String> pathParams){
            Request.pathParams(pathParams);
            return Request.delete(url);
    }

    public static ResponseOptions<Response> GetWithPathParams(String url, Map<String,String> pathParams){
            Request.pathParams(pathParams);
            return Request.get(url);
    }

    public static ResponseOptions<Response> PUTOpsWithBodyAndPathParams(String url, Map<String, String> body, Map<String, String> pathParams){
            Request.pathParams(pathParams);
            Request.body(body);
            return Request.put(url);
    }
}
