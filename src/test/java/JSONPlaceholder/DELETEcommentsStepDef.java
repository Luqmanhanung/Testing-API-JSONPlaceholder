package JSONPlaceholder;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;


public class DELETEcommentsStepDef {
    @Steps
    JsonplaceholderAPIIlham jsonplaceholderAPIIlham;

    // Scenario delete with valid id
    @Given("Delete comments with valid id {int}")
    public void deleteCommentsWithValidIdId(int id) {
        jsonplaceholderAPIIlham.deleteCommentsID(id);
    }

    @When("Send request delete comments id")
    public void sendRequestDeleteCommentsID() {
        SerenityRest.when().delete(JsonplaceholderAPIIlham.DELETE_COMMENTS_ID);
    }

    @Then("Should return {int} No Content")
    public void shouldReturnNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }



    // Scenario delete with invalid id
    @Given("Delete comments with invalid id {string}")
    public void deleteCommentsWithInvalidIdId(String id) {
        jsonplaceholderAPIIlham.deleteCommentsString(id);
    }

    @When("Send request delete comments string")
    public void sendRequestDeleteCommentsString() {
        SerenityRest.when().delete(JsonplaceholderAPIIlham.DELETE_COMMENTS_STRING);
    }

    @Then("Should return {int} Bad Request")
    public void shouldReturnBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }



    // Scenario delete with id exceed the limit
    @Given("Delete comments with id exceed the limit {int}")
    public void deleteCommentsWithIdExceedTheLimitId(int id) {
        jsonplaceholderAPIIlham.deletePostsID(id);
    }

    @Then("Should return {int} Not Found")
    public void shouldReturnNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }
}
