package JSONPlaceholder;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class GETpostsStepDef {

    @Steps
    JsonplaceholderAPI jsonplaceholderAPI;

    // Scenario Get posts valid path
    @Given("GET posts article with valid path")
    public void getPostsArticleWithValidPath() {
        jsonplaceholderAPI.getPostsArticle();
    }

    @When("Send request get posts")
    public void sendRequestGetPosts() {
        SerenityRest.when()
                .get(JsonplaceholderAPI.GET_POSTS);
    }


    // Scenario Get posts invalid parameter (int)
    @Given("Get posts article with invalid parameter")
    public void getPostsArticleWithInvalidParameter() {
        jsonplaceholderAPI.getPostsArticle();
    }

    @When("Send request get posts article")
    public void sendRequestGetPostsArticle() {
        SerenityRest.when()
                .get(JsonplaceholderAPI.GET_POSTS_INVALID1);
    }


    // Scenario Get posts invalid parameter (String)
    @When("Send request get posts invalid parameter")
    public void sendRequestGetPostsInvalidParameter() {
        SerenityRest.when()
                .get(JsonplaceholderAPI.GET_POSTS_INVALID2);
    }

    // Scenario Get posts invalid path
    @Given("GET posts article with invalid id {string}")
    public void getPostsArticleWithInvalidId(String id) {
        jsonplaceholderAPI.getPostsInvalid(id);
    }

    @When("Send request posts invalid path")
    public void sendRequestPostsInvalidPath() {
        SerenityRest.when()
                .get(JsonplaceholderAPI.GET_INVALID);
    }

    // Scenario Get with id exceed the limit
    @Given("GET posts article with id exceed the limit {int}")
    public void getPostsArticleWithIdExceedTheLimit(int id) {
        jsonplaceholderAPI.getPostsWithIdExceedTheLimit(id);
    }

    @When("Send request posts with id exceed the limit")
    public void sendRequestPostsWithIdExceedTheLimit() {
        SerenityRest.when()
                .get(JsonplaceholderAPI.GET_LIMIT);
    }
}
