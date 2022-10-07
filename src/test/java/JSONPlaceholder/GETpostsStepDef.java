package JSONPlaceholder;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class GETpostsStepDef {

    @Steps
    JsonplaceholderAPIpanji jsonplaceholderAPIpanji;

    // Scenario Get posts valid path
    @Given("GET posts article with valid path")
    public void getPostsArticleWithValidPath() {
        jsonplaceholderAPIpanji.getPostsArticle();
    }

    @When("Send request get posts")
    public void sendRequestGetPosts() {
        SerenityRest.when()
                .get(JsonplaceholderAPIpanji.GET_POSTS);
    }

    @Then("Should response {int} OK")
    public void shouldResponseOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    // Scenario Get posts invalid parameter (int)
    @Given("Get posts article with invalid parameter")
    public void getPostsArticleWithInvalidParameter() {
        jsonplaceholderAPIpanji.getPostsArticle();
    }

    @When("Send request get posts article")
    public void sendRequestGetPostsArticle() {
        SerenityRest.when()
                .get(JsonplaceholderAPIpanji.GET_POSTS_INVALID1);
    }

    @Then("Should response {int} bad request")
    public void shouldResponseBadRequest(int badrequest) {
        SerenityRest.then().statusCode(badrequest);
    }

    // Scenario Get posts invalid parameter (String)
    @When("Send request get posts invalid parameter")
    public void sendRequestGetPostsInvalidParameter() {
        SerenityRest.when()
                .get(JsonplaceholderAPIpanji.GET_POSTS_INVALID2);
    }

    // Scenario Get posts invalid path
    @Given("GET posts article with invalid id {string}")
    public void getPostsArticleWithInvalidId(String id) {
        jsonplaceholderAPIpanji.getPostsInvalid(id);
    }

    @When("Send request posts invalid path")
    public void sendRequestPostsInvalidPath() {
        SerenityRest.when()
                .get(JsonplaceholderAPIpanji.GET_INVALID);
    }

    // Scenario Get with id exceed the limit
    @Given("GET posts article with id exceed the limit {int}")
    public void getPostsArticleWithIdExceedTheLimit(int id) {
        jsonplaceholderAPIpanji.getPostsWithIdExceedTheLimit(id);
    }

    @When("Send request posts with id exceed the limit")
    public void sendRequestPostsWithIdExceedTheLimit() {
        SerenityRest.when()
                .get(JsonplaceholderAPIpanji.GET_LIMIT);
    }
}
