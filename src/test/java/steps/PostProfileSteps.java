package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.hamcrest.core.IsNot;
import utilities.RestAssuredExtension;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PostProfileSteps {
    private static ResponseOptions<Response> response;
    @Given("^I perform POST operation from \"([^\"]*)\"$")
    public void iPerformPOSTOperationFrom(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        BDDStyleMethod.performPOSTWithBodyParameter();
    }

    @Given("^I perform POST operation with path params from \"([^\"]*)\" with body$")
    public void   iPerformPOSTOperationWithPathParamsFromWithBody(String url, DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //Cucumber table data retrieval
        var data = table.raw();
        HashMap<String,String> pathParams = new HashMap<String,String>();
        pathParams.put("profileNo",data.get(1).get(1));

        HashMap<String,String> body = new HashMap<String,String>();
        body.put("name",data.get(1).get(0));

        //Perform POST operation
        response = RestAssuredExtension.PostOpsWithBodyPathParams(url, pathParams, body);
    }

    @Then("^I should see the body has name as \"([^\"]*)\"$")
    public void iShouldSeeTheBodyHasNameAs(String name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertThat(response.getBody().jsonPath().get("name"),equalTo(name));
    }

    @Given("^I ensure to Perform POST operation for \"([^\"]*)\" with body as$")
    public void iEnsureToPerformPOSTOperationForWithBodyAs(String url,DataTable table) throws Throwable {
        var data = table.raw();
        Map<String,String> body = new HashMap<String,String>();
        body.put("id",data.get(1).get(0));
        body.put("title",data.get(1).get(1));
        body.put("author",data.get(1).get(2));
        response = RestAssuredExtension.PostOpsWithBody(url,body);
    }
    @And("^I perform DELETE operation for \"([^\"]*)\"$")
    public void iPerformDELETEOperationFor(String url, DataTable table) throws Throwable {
        var data = table.raw();
        Map<String,String> pathParams = new HashMap<String,String>();
        pathParams.put("postid",data.get(1).get(0));
        response = RestAssuredExtension.DeleteOpsWithPathParams(url,pathParams);
    }

    @Then("^I should not see the body with title as \"([^\"]*)\"$")
    public void iShouldNotSeeTheBodyWithTitleAs(String title) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertThat(response.getBody().jsonPath().get("title"), IsNot.not(title));
    }

    @And("^I perform PUT operation for \"([^\"]*)\" with body as$")
    public void iPerformPUTOperationForWithBodyAndPathParams(String url,DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        var data = table.raw();
        Map<String,String> pathParams = new HashMap<String,String>();
        pathParams.put("postid",data.get(1).get(0));

        Map<String,String> body = new HashMap<String,String>();
        body.put("id",data.get(1).get(0));
        body.put("title",data.get(1).get(1));
        body.put("author",data.get(1).get(2));
        //Post Operation
        response = RestAssuredExtension.PUTOpsWithBodyAndPathParams(url,body,pathParams);
    }

    @Then("^I should see the body with title as \"([^\"]*)\"$")
    public void iShouldSeeTheBodyWithTitleAs(String title) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertThat(response.getBody().jsonPath().get("title"),equalTo(title));
    }
}
