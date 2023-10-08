package stepDefinitions.common;

import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static base.EnvironmentVariable.BASE_URL;

public class CommonRequest {
    @Step("Given call send request with post method")
    public void post(String payload, Map<String, String> headerParams, String basePath) {
        if (payload == null) {
            requestSpec()
                    .contentType(ContentType.JSON)
                    .headers(headerParams)
                    .basePath(basePath).when().post();
        } else {
            requestSpec()
                    .contentType(ContentType.JSON)
                    .headers(headerParams)
                    .basePath(basePath).body(payload).when().post();
        }
    }
    @Step("Given call send request with get method")
    public void get(Map<String, String> headerParams, String basePath) {
        requestSpec()
                .headers(headerParams)
                .contentType(ContentType.JSON)
                .when().get(basePath);
    }

    public static RequestSpecification requestSpec() {
        return SerenityRest.given().baseUri(BASE_URL);
    }
}
