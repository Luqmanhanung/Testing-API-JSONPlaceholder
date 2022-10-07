package JSONPlaceholder;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GETalbumsStepDef {
    @Steps
    JsonplaceholderAPI jsonplaceholderAPI;
    @When("Send request get list albums")
    public void sendRequestGetListAlbums() {
        SerenityRest.when()
                .get(JsonplaceholderAPI.GET_LIST_ALBUMS);
    }

    @And("Response body list album should contain user id {int}, id {int}, and title {string}")
    public void responseBodyShouldContainUserIdUserIdIdIdAndTitle(int userId, int id, String title) {
        SerenityRest.then()
                .body(JsonplaceholderResponse.USERIDLISTALBUMS,equalTo(userId))
                .body(JsonplaceholderResponse.IDLISTALBUMS,equalTo(id))
                .body(JsonplaceholderResponse.TITLELISTALBUMS,equalTo(title));
    }

    @Given("Get list all albums")
    public void getListAllAlbums() {
        jsonplaceholderAPI.getListAlbums();
    }

    @And("Get list albums assert json validation")
    public void getListAlbumsAssertJsonValidation() {
        File jsonFile = new File(JsonplaceholderAPI.JSON_FILE+"/JsonSchemaValidation/GETValidListalbumsJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Get list all albums with valid id {int}")
    public void getListAllAlbumsWithValidIdId(int id) {
        jsonplaceholderAPI.getSingleAlbumWithValidId(id);
    }

    @When("Send request get single albums")
    public void sendRequestGetSingleAlbums() {
        SerenityRest.when()
                .get(JsonplaceholderAPI.GET_SINGLE_ALBUMS);

    }

    @And("Response body single album should contain user id {int}, id {int}, and title {string}")
    public void responseBodySingleAlbumShouldContainUserIdIdAndTitle(int userId, int id, String title) {
        SerenityRest.then()
                .body(JsonplaceholderResponse.USERIDSINGLEALBUMS,equalTo(userId))
                .body(JsonplaceholderResponse.IDSINGLEALBUMS,equalTo(id))
                .body(JsonplaceholderResponse.TITLESINGLEALBUMS,equalTo(title));
    }

    @And("Get single albums assert json validation")
    public void getSingleAlbumsAssertJsonValidation() {
        File jsonFile = new File(JsonplaceholderAPI.JSON_FILE+"/JsonSchemaValidation/GETValidSinglealbumsJsonSchemaValidation.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Get list all albums with invalid id {string}")
    public void getListAllAlbumsWithInvalidId(String id) {
        jsonplaceholderAPI.getSingleAlbumWithInvalidId(id);
    }

    @Given("Get single all albums with valid id {int}")
    public void getSingleAllAlbumsWithValidIdId(int id) {
        jsonplaceholderAPI.getSingleAlbumWithValidId(id);
    }

    @Given("Get single all albums with invalid id {string}")
    public void getSingleAllAlbumsWithInvalidId(String id) {
        jsonplaceholderAPI.getSingleAlbumWithInvalidId(id);
    }

    @Given("Get single all albums with id exceed the limit {int}")
    public void getSingleAllAlbumsWithIdExceedTheLimitId(int id) {
        jsonplaceholderAPI.getSingleAlbumWithValidId(id);
    }

    @Given("Get list albums with valid parameter {string}")
    public void getListAlbumsWithValidParameter(String title) {
        jsonplaceholderAPI.getListAlbumsWithValidParameter(title);
    }

    @When("Send request get list albums with parameter")
    public void sendRequestGetListAlbumsWithParameter() {
        SerenityRest.when()
                .get(JsonplaceholderAPI.GET_LIST_ALBUM_BY_TITLE);
    }
}
