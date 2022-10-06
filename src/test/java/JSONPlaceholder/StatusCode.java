package JSONPlaceholder;

import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;

public class StatusCode {
    @Then("Api should return response {int} Created")
    public void apiShouldReturnResponseCreated(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }

    @Then("API should return response {int} BAD REQUEST")
    public void apiShouldReturnResponseBADREQUEST(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }

    @Then("API should return response {int} OK")
    public void apiShouldReturnResponseOK(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }

    @Then("API should return response {int} Not Found")
    public void apiShouldReturnResponseNotFound(int statusCode) {
        SerenityRest.then()
                .statusCode(statusCode);
    }
}
