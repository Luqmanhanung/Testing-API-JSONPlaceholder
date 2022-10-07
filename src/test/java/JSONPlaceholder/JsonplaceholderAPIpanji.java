package JSONPlaceholder;

import io.restassured.http.ContentType;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class JsonplaceholderAPIpanji {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR+"/src/test/resources/Jsonfile";
    public static String PUT_UPDATE = BASE_URL+"/posts/{id}";
    public static String GET_POSTS = BASE_URL+"/posts";
    public static String GET_POSTS_INVALID1 = BASE_URL+"/posts?501";
    public static String GET_POSTS_INVALID2 = BASE_URL+"/posts?wuuff";
    public static String GET_INVALID = BASE_URL+"/posts/{id}";
    public static String GET_LIMIT = BASE_URL+"/posts/{id}";

    @Step("Put Update posts {int}")
    public void putUpdatePosts(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get posts article")
    public void getPostsArticle(){
        SerenityRest.given();
    }

    @Step("Get posts invalid {string}")
    public void getPostsInvalid(String id) {
        SerenityRest.given().pathParam("id",id);
    }

    @Step("Get posts with id exceed the limit {int}")
    public void getPostsWithIdExceedTheLimit(int id){
        SerenityRest.given().pathParam("id",id);
    }

}
