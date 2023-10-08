package stepDefinitions.common;

import io.cucumber.java.en.Then;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CommonStep {
    
    @Then("the response status code is {int}")
    public void verifyResponseStatusCode(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }
}
