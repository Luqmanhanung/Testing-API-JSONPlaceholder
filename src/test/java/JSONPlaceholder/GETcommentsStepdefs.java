package JSONPlaceholder;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.module.jsv.JsonSchemaValidator;

import java.io.File;

public class GETcommentsStepdefs {
    @Steps
    JsonplaceholderAPI jsonplaceholderAPI;
    
    @Given("Get all comments article")
    public void getAllCommentsArticle() {
        jsonplaceholderAPI.getAllComments();
    }

    @When("Send request get all comments")
    public void sendRequestGetAllComments() {
        SerenityRest.when()
                .get(JsonplaceholderAPI.GET_ALL_COMMENTS);
    }

    @And("Response body page should contain post id {int}, id {int}, name {string}, email {string} and body {string}")
    public void responseBodyPageShouldContainPostIdPostIdIdIdNameEmailAndBody(int postId, int id, String name, String email, String body) {
        SerenityRest.then()
                .body(JsonplaceholderResponse.POSTIDD, equalTo(postId))
                .body(JsonplaceholderResponse.IDD, equalTo(id))
                .body(JsonplaceholderResponse.NAMED, equalTo(name))
                .body(JsonplaceholderResponse.EMAILED, equalTo(email))
                .body(JsonplaceholderResponse.BODYD, equalTo(body));
    }

    @And("Get all comments json schema validator")
    public void getAllCommentsJsonSchemaValidator() {
        File json = new File(JsonplaceholderAPI.JSON_FILE + "/JsonSchemaValidation/GETallcommentsJsonSchemaValidation.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    // Scenario get comments with valid id
    @Given("Get comments valid id {int}")
    public void getCommentsValidIdId(int id) {
        jsonplaceholderAPI.getCommentsID(id);
    }

    @When("Send request get comments valid id")
    public void sendRequestGetCommentsValidId() {
        SerenityRest.when().get(JsonplaceholderAPI.GET_COMMENTS_ID);
    }

    @And("Response body page should contains post id {int}, id {int}, name {string}, email {string} and body {string}")
    public void responseBodyPageShouldContainsPostIdPostIdIdIdNameEmailAndBody(int postId, int id, String name, String email, String body) {
        SerenityRest.then()
                .body(JsonplaceholderResponse.POSTID, equalTo(postId))
                .body(JsonplaceholderResponse.ID, equalTo(id))
                .body(JsonplaceholderResponse.NAME, equalTo(name))
                .body(JsonplaceholderResponse.EMAIL, equalTo(email))
                .body(JsonplaceholderResponse.BODY, equalTo(body));
    }

    @And("Get comments with valid id json schema validator")
    public void getCommentsWithValidIdJsonSchemaValidator() {
        File json = new File(JsonplaceholderAPI.JSON_FILE + "/JsonSchemaValidation/GETsinglecommentsJsonSchemaValidation.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    // Scenario get comments with invalid id
    @Given("Get comments invalid id {string}")
    public void getCommentsInvalidId(String id) {
        jsonplaceholderAPI.getCommentsString(id);
    }

    @When("Send request get comments invalid id")
    public void sendRequestGetCommentsInvalidId() {
        SerenityRest.when().get(JsonplaceholderAPI.GET_COMMENTS_STRING);
    }

    @When("Send request get comments parameter")
    public void sendRequestGetCommentsParameter() {
        SerenityRest.when().get(JsonplaceholderAPI.GET_COMMENTS_PARAMETER_ID);
    }

    @And("Get comments with parameter json schema validator")
    public void getCommentsWithParameterJsonSchemaValidator() {
        File json = new File(JsonplaceholderAPI.JSON_FILE + "/JsonSchemaValidation/GETcommentsparameterJsonSchemaValidation.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
