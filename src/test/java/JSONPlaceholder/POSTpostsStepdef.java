package JSONPlaceholder;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class POSTpostsStepdef {
    @Steps
    JsonplaceholderAPI jsonplaceholderAPI;
    @Given("Post create post with valid path and valid all data")
    public void postCreatePostWithValidPathAndValidAllData() {
        File jsonFiles = new File(JsonplaceholderAPI.JSON_FILE+"/JsonRequestBody/POSTValidposts.json");
        jsonplaceholderAPI.postCreatepost(jsonFiles);
    }

    @Given("Post create post with invalid path")
    public void postCreatePostWithInvalidPath() {
        File jsonFiles = new File(JsonplaceholderAPI.JSON_FILE+"/JsonRequestBody/POSTValidposts.json");
        jsonplaceholderAPI.postCreatepost(jsonFiles);
    }
    @When("Send request post create post")
    public void sendRequestPostCreatePost() {
        SerenityRest.when()
                .post(JsonplaceholderAPI.POST_CREATE_POST);
    }
    @And("Response body should contain user Id {int}, title {string}, body {string}, and id {int}")
    public void responseBodyShouldContainUserIdUserIdTitleBodyAndIdId(int userid, String title, String body, int id) {
        SerenityRest.then()
                .body(JsonplaceholderResponse.USERID,equalTo(userid))
                .body(JsonplaceholderResponse.TITLE,equalTo(title))
                .body(JsonplaceholderResponse.BODY,equalTo(body))
                .body(JsonplaceholderResponse.ID,equalTo(id));
    }

    @Given("post create posts with valid path and empty Request body only one field")
    public void postCreatePostsWithValidPathAndEmptyRequestBodyOnlyOneField() {
        File jsonFiles = new File(JsonplaceholderAPI.JSON_FILE+"/JsonRequestBody/POSTEmptypostsOneField.json");
        jsonplaceholderAPI.postCreatepost(jsonFiles);
    }


    @Given("post create posts with valid path and empty Request body only two field")
    public void postCreatePostsWithValidPathAndEmptyRequestBodyOnlyTwoField() {
        File jsonFiles = new File(JsonplaceholderAPI.JSON_FILE+"/JsonRequestBody/POSTEmptypostsTwoField.json");
        jsonplaceholderAPI.postCreatepost(jsonFiles);
    }

    @Given("Post create post with valid path and Invalid all data")
    public void postCreatePostWithValidPathAndInvalidAllData() {
        File jsonFiles = new File(JsonplaceholderAPI.JSON_FILE+"/JsonRequestBody/POSTInvalidpostsAllData.json");
        jsonplaceholderAPI.postCreatepost(jsonFiles);
    }

    @When("Send request post invalid create post")
    public void sendRequestPostInvalidCreatePost() {
        SerenityRest.when()
                .post(JsonplaceholderAPI.POST_INVALID_CREATE_POST);
    }

    @And("Post create user assert json validation")
    public void postCreateUserAssertJsonValidation() {
        File jsonFile = new File(JsonplaceholderAPI.JSON_FILE+"/JsonSchemaValidation/PostpostJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }
}
