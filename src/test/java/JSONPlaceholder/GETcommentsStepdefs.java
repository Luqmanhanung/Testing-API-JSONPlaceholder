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
    JsonplaceholderAPIIlham jsonplaceholderAPIIlham;
    
    @Given("Get all comments article")
    public void getAllCommentsArticle() {
        jsonplaceholderAPIIlham.getAllComments();
    }

    @When("Send request get all comments")
    public void sendRequestGetAllComments() {
        SerenityRest.when()
                .get(JsonplaceholderAPIIlham.GET_ALL_COMMENTS);
    }

    @And("Response body page should contain post id {int}, id {int}, name {string}, email {string} and body {string}")
    public void responseBodyPageShouldContainPostIdPostIdIdIdNameEmailAndBody(int postId, int id, String name, String email, String body) {
        SerenityRest.then()
                .body(JsonplaceholderResponseIlham.POSTIDD, equalTo(postId))
                .body(JsonplaceholderResponseIlham.IDD, equalTo(id))
                .body(JsonplaceholderResponseIlham.NAMED, equalTo(name))
                .body(JsonplaceholderResponseIlham.EMAILED, equalTo(email))
                .body(JsonplaceholderResponseIlham.BODYD, equalTo(body));
    }

    @And("Get all comments json schema validator")
    public void getAllCommentsJsonSchemaValidator() {
        File json = new File(JsonplaceholderAPIIlham.JSON_FILE + "/JsonSchemaValidation/GETallcommentsJsonSchemaValidation.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    // Scenario get comments with valid id
    @Given("Get comments valid id {int}")
    public void getCommentsValidIdId(int id) {
        jsonplaceholderAPIIlham.getCommentsID(id);
    }

    @When("Send request get comments valid id")
    public void sendRequestGetCommentsValidId() {
        SerenityRest.when().get(JsonplaceholderAPIIlham.GET_COMMENTS_ID);
    }

    @And("Response body page should contains post id {int}, id {int}, name {string}, email {string} and body {string}")
    public void responseBodyPageShouldContainsPostIdPostIdIdIdNameEmailAndBody(int postId, int id, String name, String email, String body) {
        SerenityRest.then()
                .body(JsonplaceholderResponseIlham.POSTID, equalTo(postId))
                .body(JsonplaceholderResponseIlham.ID, equalTo(id))
                .body(JsonplaceholderResponseIlham.NAME, equalTo(name))
                .body(JsonplaceholderResponseIlham.EMAIL, equalTo(email))
                .body(JsonplaceholderResponseIlham.BODY, equalTo(body));
    }

    @And("Get comments with valid id json schema validator")
    public void getCommentsWithValidIdJsonSchemaValidator() {
        File json = new File(JsonplaceholderAPIIlham.JSON_FILE + "/JsonSchemaValidation/GETsinglecommentsJsonSchemaValidation.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    // Scenario get comments with invalid id
    @Given("Get comments invalid id {string}")
    public void getCommentsInvalidId(String id) {
        jsonplaceholderAPIIlham.getCommentsString(id);
    }

    @When("Send request get comments invalid id")
    public void sendRequestGetCommentsInvalidId() {
        SerenityRest.when().get(JsonplaceholderAPIIlham.GET_COMMENTS_STRING);
    }

    @When("Send request get comments parameter")
    public void sendRequestGetCommentsParameter() {
        SerenityRest.when().get(JsonplaceholderAPIIlham.GET_COMMENTS_PARAMETER_ID);
    }

//    @And("Response body page should contain id {int}")
//    public void responseBodyPageShouldContainIdId(int id) {
//        SerenityRest.then()
//                .body(JsonplaceholderResponseIlham.POSTIDD, equalTo(postId))
//                .body(JsonplaceholderResponseIlham.IDD, equalTo(id))
//                .body(JsonplaceholderResponseIlham.NAMED, equalTo(name))
//                .body(JsonplaceholderResponseIlham.EMAILED, equalTo(email))
//                .body(JsonplaceholderResponseIlham.BODYD, equalTo(body));
//    }

    @And("Get comments with parameter json schema validator")
    public void getCommentsWithParameterJsonSchemaValidator() {
        File json = new File(JsonplaceholderAPIIlham.JSON_FILE + "/JsonSchemaValidation/GETcommentsparameterJsonSchemaValidation.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
