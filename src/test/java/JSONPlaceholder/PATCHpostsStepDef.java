package JSONPlaceholder;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

public class PATCHpostsStepDef {
    @Steps
    JsonplaceholderAPI jsonplaceholderAPI;

    // Scenario patch with valid id
    @Given("Patch posts with valid id {int}")
    public void patchPostsWithValidIdId(int id) {
        File json = new File(JsonplaceholderAPI.JSON_FILE + "/JsonRequestBody/PATCHpostsalldata.json");
        jsonplaceholderAPI.patchPostsID(id, json);
    }

    @When("Send request patch posts id")
    public void sendRequestPatchPostsId() {
        SerenityRest.when()
                .patch(JsonplaceholderAPI.PATCH_POSTS_ID);
    }


    @And("Response body page should contain user id {int}, id {int}, title {string} and body {string}")
    public void responseBodyPageShouldContainUserIdUserIdIdIdTitleAndBody(int userId, int id, String title, String body) {
        SerenityRest.then()
                .body(JsonplaceholderResponse.USERID, equalTo(userId))
                .body(JsonplaceholderResponse.ID, equalTo(id))
                .body(JsonplaceholderResponse.TITLE, equalTo(title))
                .body(JsonplaceholderResponse.BODY, equalTo(body));
    }

    @And("Patch posts article json schema validator")
    public void patchPostsArticleJsonSchemaValidator() {
        File json = new File(JsonplaceholderAPI.JSON_FILE + "/JsonSchemaValidation/PATCHpostsAllDataJsonSchemaValidation.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    // Scenario patch with invalid id
    @Given("Patch posts with invalid id {string}")
    public void patchPostsWithInvalidId(String id) {
        File json = new File(JsonplaceholderAPI.JSON_FILE + "/JsonRequestBody/PATCHpostsalldata.json");
        jsonplaceholderAPI.patchPostsString(id, json);
    }

    @When("Send request patch posts invalid id")
    public void sendRequestPatchPostsInvalidId() {
        SerenityRest.when()
                .patch(JsonplaceholderAPI.PATCH_POSTS_STRING);
    }

    @Given("Patch posts with id exceed the limit {int}")
    public void patchPostsWithIdExceedTheLimitId(int id) {
        File json = new File(JsonplaceholderAPI.JSON_FILE + "/JsonRequestBody/PATCHpostsalldata.json");
        jsonplaceholderAPI.patchPostsID(id, json);

    }


    @Given("Patch posts with valid id half {int}")
    public void patchPostsWithValidIdHalfId(int id) {
        File json = new File(JsonplaceholderAPI.JSON_FILE + "/JsonRequestBody/PATCHpostshalfdata.json");
        jsonplaceholderAPI.patchPostsID(id, json);
    }

}
