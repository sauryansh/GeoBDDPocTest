package steps;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetPostSteps {
    private static ResponseOptions<Response> response;
    @Given("^I perform GET operation from \"([^\"]*)\"$")
    public void iPerformGETOperationFrom(String url) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        response = RestAssuredExtension.GetOps(url);
    }

/* For Step 1:
    @And("^I perform GET operation for the post number \"([^\"]*)\"$")
    public void iPerformGETOperationForThePostNumber(String postNumber) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        BDDStyleMethod.simpleGETPost(postNumber);
    }*/

    @Then("^I should see the author name \"([^\"]*)\"$")
    public void iShouldSeeTheAuthorName(String authorName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
          System.out.println("Author Name "+ authorName);
          assertThat(response.getBody().jsonPath().get("author"),hasItems(authorName));
    }

    @Then("^I should see the author names$")
    public void iShouldSeeTheAuthorNames() {
        // Write code here that turns the phrase above into concrete actions
        BDDStyleMethod.performContainsCollection();
    }

    @Then("^I should verify GET Params$")
    public void iShouldVerifyGETParams() {
        // Write code here that turns the phrase above into concrete actions
        BDDStyleMethod.performGetWithPathParameters("1");
    }

    @And("^query params \"([^\"]*)\" and \"([^\"]*)\"$")
    public void queryParamsAnd(String postId, String value) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        BDDStyleMethod.performQueryParameter(postId, value);
    }

    @Then("^I should verify Query Params$")
    public void iShouldVerifyQueryParams() {
    }

    @And("^I perform GET operation with path parameter from \"([^\"]*)\"$")
    public void iPerformGETOperationWithPathParameterFrom(String url,DataTable table) throws Throwable {
        var data = table.raw();
        Map<String, String> pathParams = new HashMap<String, String>();
        pathParams.put("postid", data.get(1).get(0));
        response = RestAssuredExtension.GetWithPathParams(url, pathParams);
    }

    @And("^I perform GET operation for \"([^\"]*)\"$")
    public void iPerformGETOperationFor(String url,DataTable table) throws Throwable {
        var data = table.raw();
        Map<String, String> pathParams = new HashMap<String, String>();
        pathParams.put("postid", data.get(1).get(0));
        response = RestAssuredExtension.GetWithPathParams(url, pathParams);
    }
}
