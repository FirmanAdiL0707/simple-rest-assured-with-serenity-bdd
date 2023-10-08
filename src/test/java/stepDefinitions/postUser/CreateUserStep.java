package stepDefinitions.postUser;

import org.json.JSONObject;

import base.BasePath;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import stepDefinitions.common.CommonRequest;

import static stepDefinitions.common.CommonHeaders.*;

public class CreateUserStep {
    @Steps
    CommonRequest commonRequest;

    @When("user send request for post user api")
    public void sendRequestForPostUser(){
        JSONObject payload = new JSONObject();
        payload.put("name", "Firman");
        payload.put("job", "QA Engineer");
        commonRequest.post(payload.toString(), addBasicHeader(), BasePath.USERS);
    }
}
