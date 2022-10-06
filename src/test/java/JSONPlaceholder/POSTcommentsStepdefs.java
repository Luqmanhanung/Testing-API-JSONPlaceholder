package JSONPlaceholder;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class POSTcommentsStepdefs {
    @Steps
    JsonplaceholderAPI jsonplaceholderAPI;

    @Given("Post create comment with valid path and valid all data")
    public void postCreateCommentWithValidPathAndValidAllData() {
        File jsonFiles = new File(JsonplaceholderAPI.JSON_FILE+"/JsonRequestBody/POSTValidcomments.json");
        jsonplaceholderAPI.postCreatepost(jsonFiles);
    }

    @When("Send request post create comment")
    public void sendRequestPostCreateComment() {
        SerenityRest.when()
                .post(JsonplaceholderAPI.POST_CREATE_COMMENTS);
    }

    @And("Response body should contain user Id {int}, name {string}, email {string}, body {string} and id {int}")
    public void responseBodyShouldContainUserIdUserIdNameEmailBodyAndIdId(int userid, String name, String email, String body, int id) {
        SerenityRest.then()
                .body(JsonplaceholderResponse.USERID,equalTo(userid))
                .body(JsonplaceholderResponse.NAME,equalTo(name))
                .body(JsonplaceholderResponse.EMAIL,equalTo(email))
                .body(JsonplaceholderResponse.BODY,equalTo(body))
                .body(JsonplaceholderResponse.ID,equalTo(id));

    }

    @Given("post create comments with valid path and empty Request body only one field")
    public void postCreateCommentsWithValidPathAndEmptyRequestBodyOnlyOneField() {
        File jsonFiles = new File(JsonplaceholderAPI.JSON_FILE+"/JsonRequestBody/POSTEmptycommentsOneField.json");
        jsonplaceholderAPI.postCreatepost(jsonFiles);
    }

    @Given("post create comments with valid path and empty Request body only two field")
    public void postCreateCommentsWithValidPathAndEmptyRequestBodyOnlyTwoField() {
        File jsonFiles = new File(JsonplaceholderAPI.JSON_FILE+"/JsonRequestBody/POSTEmptycommentsTwoField.json");
        jsonplaceholderAPI.postCreatepost(jsonFiles);
    }

    @Given("post create comments with valid path and empty Request body only three field")
    public void postCreateCommentsWithValidPathAndEmptyRequestBodyOnlyThreeField() {
        File jsonFiles = new File(JsonplaceholderAPI.JSON_FILE+"/JsonRequestBody/POSTEmptycommentsThreeField.json");
        jsonplaceholderAPI.postCreatepost(jsonFiles);
    }

    @Given("Post create comments with valid path and Invalid all data")
    public void postCreateCommentsWithValidPathAndInvalidAllData() {
        File jsonFiles = new File(JsonplaceholderAPI.JSON_FILE+"/JsonRequestBody/POSTInvalidcommentsAllData.json");
        jsonplaceholderAPI.postCreatepost(jsonFiles);
    }
}
