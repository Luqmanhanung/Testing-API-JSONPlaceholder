package JSONPlaceholder;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;


public class DELETEcommentsStepDef {
    @Steps
    JsonplaceholderAPI jsonplaceholderAPI;

    // Scenario delete with valid id
    @Given("Delete comments with valid id {int}")
    public void deleteCommentsWithValidIdId(int id) {
        jsonplaceholderAPI.deleteCommentsID(id);
    }

    @When("Send request delete comments id")
    public void sendRequestDeleteCommentsID() {
        SerenityRest.when().delete(JsonplaceholderAPI.DELETE_COMMENTS_ID);
    }


    // Scenario delete with invalid id
    @Given("Delete comments with invalid id {string}")
    public void deleteCommentsWithInvalidIdId(String id) {
        jsonplaceholderAPI.deleteCommentsString(id);
    }

    @When("Send request delete comments string")
    public void sendRequestDeleteCommentsString() {
        SerenityRest.when().delete(JsonplaceholderAPI.DELETE_COMMENTS_STRING);
    }


    // Scenario delete with id exceed the limit
    @Given("Delete comments with id exceed the limit {int}")
    public void deleteCommentsWithIdExceedTheLimitId(int id) {
        jsonplaceholderAPI.deletePostsID(id);
    }

}
