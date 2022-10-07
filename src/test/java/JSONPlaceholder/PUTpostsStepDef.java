package JSONPlaceholder;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;
public class PUTpostsStepDef {

    @Steps
    JsonplaceholderAPIpanji jsonplaceholderAPIpanji ;

    //Scenario Update valid data
    @Given("PUT with valid request body and valid path id {int}")
    public void putWithValidRequestBodyAndValidPathIdId(int id) {
        File json = new File(JsonplaceholderAPIpanji.JSON_FILE+"/JsonRequestBody/PUTUpdateUser.json");
        jsonplaceholderAPIpanji.putUpdatePosts(id,json);
    }

    @When("Send request update user")
    public void sendRequestUpdateUser() {
        SerenityRest.when().put(JsonplaceholderAPIpanji.PUT_UPDATE);
    }

    @Then("Should return {int} OK")
    public void shouldReturnOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body should contain name {string} and {string}")
    public void responseBodyShouldContainNameAnd(String title, String body) {
        SerenityRest.then()
                .body(JsonplaceholderResponsePanji.TITLE,equalTo(title))
                .body(JsonplaceholderResponsePanji.BODY,equalTo(body));
    }
    @And("PUT update posts schema validator")
    public void putUpdatePostsSchemaValidator() {
        File json = new File(JsonplaceholderAPIpanji.JSON_FILE+"/JsonSchemaValidation/PUTUpdatePostsSchemaValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //Scenario Update with Invalid data
    @Given("PUT with invalid id {int} and userId")
    public void putWithInvalidIdAndUserId(int id) {
        File json = new File(JsonplaceholderAPIpanji.JSON_FILE+"/JsonRequestBody/PUTUpdateInvalidId.json");
        jsonplaceholderAPIpanji.putUpdatePosts(id,json);
    }

    @When("Send request update user invalid")
    public void sendRequestUpdateUserInvalid() {
        SerenityRest.when().put(JsonplaceholderAPIpanji.PUT_UPDATE);
    }

    @Then("Should response {int} Bad Request")
    public void shouldResponseBadRequest(int badrequest) {
        SerenityRest.then().statusCode(badrequest);
    }

    //Scenario Empty Title
    @Given("PUT with empty title id {int}")
    public void putWithEmptyTitleId(int id) {
        File json = new File(JsonplaceholderAPIpanji.JSON_FILE+"/JsonRequestBody/PUTWithEmptyTitle.json");
        jsonplaceholderAPIpanji.putUpdatePosts(id,json);
    }
    @When("Send request update user with empty title")
    public void sendRequestUpdateUserWithEmptyTitle() {
        SerenityRest.when().put(JsonplaceholderAPIpanji.PUT_UPDATE);
    }

    //Scenario PUT with empty body
    @Given("PUT with empty body id {int}")
    public void putWithEmptyBodyId(int id) {
        File json = new File(JsonplaceholderAPIpanji.JSON_FILE+"/JsonRequestBody/PUTWithEmptyBody.json");
        jsonplaceholderAPIpanji.putUpdatePosts(id,json);
    }

    @When("Send request update user with empty body")
    public void sendRequestUpdateUserWithEmptyBody() {
        SerenityRest.when().put(JsonplaceholderAPIpanji.PUT_UPDATE);
    }

    //Scenario PUT without title
    @Given("PUT without title {int}")
    public void putWithoutTitle(int id) {
        File json = new File(JsonplaceholderAPIpanji.JSON_FILE+"/JsonRequestBody/PUTWithoutTitle.json");
        jsonplaceholderAPIpanji.putUpdatePosts(id,json);
    }

    //Scenario PUT without body
    @Given("PUT without body {int}")
    public void putWithoutBody(int id) {
        File json = new File(JsonplaceholderAPIpanji.JSON_FILE+"/JsonRequestBody/PUTWithoutBody.json");
        jsonplaceholderAPIpanji.putUpdatePosts(id,json);
    }

    //Scenario wihout id
    @Given("PUT without id {int}")
    public void putWithoutId(int id) {
        File json = new File(JsonplaceholderAPIpanji.JSON_FILE+"/JsonRequestBody/PUTWithoutId.json");
        jsonplaceholderAPIpanji.putUpdatePosts(id,json);
    }
    @When("Send request update user without id")
    public void sendRequestUpdateUserWithoutId() {
        SerenityRest.when().put(JsonplaceholderAPIpanji.PUT_UPDATE);
    }

    @Then("Should response {int} Not Found")
    public void shouldResponseNotFound(int notfound) {
        SerenityRest.then().statusCode(notfound);
    }

    //Scenario without id and userId
    @Given("PUT without id and userId {int}")
    public void putWithoutIdAndUserId(int id) {
        File json = new File(JsonplaceholderAPIpanji.JSON_FILE+"/JsonRequestBody/PUTWithoutIdAndUserid.json");
        jsonplaceholderAPIpanji.putUpdatePosts(id,json);
    }
    @When("Send request update user without id and userId")
    public void sendRequestUpdateUserWithoutIdAndUserId() {
        SerenityRest.when().put(JsonplaceholderAPIpanji.PUT_UPDATE);
    }

}
