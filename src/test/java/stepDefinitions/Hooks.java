package stepDefinitions;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before("@DeletePlace")
    public void beforeScenario() throws IOException {

        StepDefinitions m = new StepDefinitions();

        if (StepDefinitions.place_id == null) {

            m.add_place_payload_with("Shetty", "French", "Asia");
            m.user_calls_with_post_http_request("AddPlaceApi", "POST");
            m.verify_place_Id_created_maps_to_using("Shetty", "getPlaceApi");
        }
    }
}