package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;

import java.util.HashMap;

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
}
