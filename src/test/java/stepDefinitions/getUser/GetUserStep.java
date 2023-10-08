package stepDefinitions.getUser;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import stepDefinitions.common.CommonRequest;
import static stepDefinitions.common.CommonHeaders.*;

import base.BasePath;
import io.cucumber.java.en.When;

public class GetUserStep {
    
    @Steps
    CommonRequest commonRequest;

    @When("user send request for get user api")
    public void getUserAPI(){
        commonRequest.get(addBasicHeader(), BasePath.USERS);
    }
}
