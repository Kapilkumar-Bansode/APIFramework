package stepDefinitions;

import static org.junit.Assert.*;
import Resources.APIResources;
import Resources.TestDataBuild;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.io.IOException;
import static io.restassured.RestAssured.given;


public class StepDefinitions extends Utils {
    RequestSpecification res;
    ResponseSpecification resspec;
    static String place_id;



    Response response;
    TestDataBuild data = new TestDataBuild();

    @Given("Add Place Payload with {string} {string} {string}")
    public void add_place_payload_with(String name, String language, String address) throws IOException {

        res = given().spec(requestSpecification()).body(data.addPlacePayLoad(name, language, address));
    }

    @When("user calls {string} with {string} http request")
    public void user_calls_with_post_http_request(String resource, String method) {

        APIResources resourceAPI = APIResources.valueOf(resource);
        System.out.println(resourceAPI.getResource());

        resspec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

        if (method.equalsIgnoreCase("post"))
            response = res.when()
                    .post(resourceAPI.getResource());

        else if (method.equalsIgnoreCase("GET"))
            response = res.when()
                    .get(resourceAPI.getResource());
    }

    @Then("the API call got success with status code {int}")
    public void the_API_call_got_success_with_status_code(Integer int1) {
        assertEquals(response.getStatusCode(),200);
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String ExpectedValue) {

        assertEquals(getJsonPath(response, keyValue), ExpectedValue);
    }

    @Then("verify place_Id created maps to {string} using {string}")
    public void verify_place_Id_created_maps_to_using(String expectedName, String resource) throws IOException {

        place_id = getJsonPath(response, "place_id");
        res = given().spec(requestSpecification()).queryParam("place_id", place_id);

        user_calls_with_post_http_request(resource, "GET");

        String actualName = getJsonPath(response, "name");
        assertEquals(actualName, expectedName);
    }

    @Given("DeletePlace Payload")
    public void deleteplace_Payload() throws IOException {

        res =given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
    }


}
