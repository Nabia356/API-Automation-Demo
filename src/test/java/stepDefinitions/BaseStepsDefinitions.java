package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.BaseTest;

public class BaseStepsDefinitions extends BaseTest {
    @Given("^Valid Request is prepared$")
    public void valid_Request_is_prepared() {
        createRequestSpec();
    }

    @When("Get request is send to server for end point {string}")
    public void get_request_is_send_to_server_for_end_point(String endpoint) {
        response = reqSpec.when().get(endpoint);
    }

    @When("Post request is send to server for end point {string}")
    public void post_request_is_send_to_server_for_end_point(String endpoint) {
        response = reqSpec.when().post(endpoint);
    }

    @When("Put request is send to server for end point {string}")
    public void put_request_is_send_to_server_for_end_point(String endpoint) {
        if (endpoint.contains("/api/") && endpoint.endsWith("Activities/")) {
            endpoint = endpoint + newActivitiesId;
        }
        response = reqSpec.when().put(endpoint);
    }

    @When("Delete request is send to server for end point {string}")
    public void delete_request_is_send_to_server_for_end_point(String endpoint) {
        if (endpoint.contains("/api/") && endpoint.endsWith("Activities/")) {
            endpoint = endpoint + newActivitiesId;
        }
        response = reqSpec.when().delete(endpoint);
    }

    @Then("^response is matches with response specification$")
    public void response_is_matches_with_response_specification() {
        createResponseSpec();
    }

    @Then("^Value at json path \"([^\"]*)\" is equals to \"([^\"]*)\"$")
    public void value_at_json_path_is_equals_to(String jsonPath, String expectedValue) {
        Assert.assertEquals(expectedValue, response.body().jsonPath().get(jsonPath).toString(), "Value for JSON is not matched");
    }

    @Then("Extract Activities id from json path")
    public void extract_activities_id_from_json_path() {
        newActivitiesId = response.body().jsonPath().get("id");
        System.out.println("New Activities ID: " + newActivitiesId);
    }

    @Then("response is matches with delete response specification")
    public void responseIsMatchesWithDeleteResponseSpecification() {
        createDeleteResponseSpec();
    }

    @Then("response is matches with invalid response specification")
    public void responseIsMatchesWithInvalidResponseSpecification() {
        createResponseSpecForInvalidData();
    }

    @Then("response is matches with not found response specification")
    public void responseIsMatchesWithNotFoundResponseSpecification() {
        createResponseSpecNotFound();
    }
}
