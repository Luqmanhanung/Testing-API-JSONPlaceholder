package JSONPlaceholder;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class JsonplaceholderAPIIlham {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR+"/src/test/resources/Jsonfile";


    public static final String GET_ALL_COMMENTS = BASE_URL + "/comments";
    public static final String GET_COMMENTS_ID = BASE_URL + "/comments/{id}";
    public static final String GET_COMMENTS_STRING = BASE_URL + "/comments/{stringID}";
    public static final String GET_COMMENTS_PARAMETER_ID = BASE_URL + "/comments?postId={id}";
    public static final String GET_COMMENTS_PARAMETER_QUERY = BASE_URL + "/comments?name={string}";
    public static final String PATCH_POSTS_ID = BASE_URL + "/posts/{id}";
    public static final String PATCH_POSTS_STRING = BASE_URL + "/posts/{string}";
    public static final String DELETE_POSTS_ID = BASE_URL + "/posts/{id}";
    public static final String DELETE_POSTS_STRING = BASE_URL + "/posts/{string}";
    public static final String DELETE_COMMENTS_ID = BASE_URL + "/comments/{id}";
    public static final String DELETE_COMMENTS_STRING = BASE_URL + "/comments/{string}";


    @Step("Get all comments")
    public void getAllComments(){
        SerenityRest.given();
    }

    @Step("Get comments ID")
    public void getCommentsID(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get comments string")
    public void getCommentsString(String id){
        SerenityRest.given()
                .pathParam("stringID", id);
    }

    @Step("Get comments parameter ID")
    public void getCommentsParameterID(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get comments parameter string")
    public void getCommentsParameterString(String query){
        SerenityRest.given().pathParam("string", query);
    }

    @Step("Patch posts ID")
    public void patchPostsID(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Patch posts string")
    public void patchPostsString(String id, File json){
        SerenityRest.given()
                .pathParam("string", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete posts ID")
    public void deletePostsID(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Delete posts string")
    public void deletePostsString(String id){
        SerenityRest.given()
                .pathParam("string", id);
    }

    @Step("Delete comments ID")
    public void deleteCommentsID(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Delete comments string")
    public void deleteCommentsString(String id){
        SerenityRest.given()
                .pathParam("string", id);
    }




}
