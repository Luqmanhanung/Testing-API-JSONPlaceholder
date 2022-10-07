package JSONPlaceholder;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;


public class DELETEpostsStepDef {
    @Steps
    JsonplaceholderAPI jsonplaceholderAPI;


    // Scenario delete with valid id
    @Given("Delete posts with valid id {int}")
    public void deletePostsWithValidIdId(int id) {
        jsonplaceholderAPI.deletePostsID(id);
    }

    @When("Send request delete posts id")
    public void sendRequestDeletePostsId() {
        SerenityRest.when().delete(JsonplaceholderAPI.DELETE_POSTS_ID);
    }


    // Scenario delete with invalid id
    @Given("Delete posts with invalid id {string}")
    public void deletePostsWithInvalidId(String id) {
        jsonplaceholderAPI.deleteCommentsString(id);
    }

    @When("Send request delete posts string")
    public void sendRequestDeletePostsString() {
        SerenityRest.when().delete(JsonplaceholderAPI.DELETE_POSTS_STRING);
    }


    // Scenario delete with id exceed the limit
    @Given("Delete posts with id exceed the limit {int}")
    public void deletePostsWithIdExceedTheLimitId(int id) {
        jsonplaceholderAPI.deletePostsID(id);
    }
}
