package JSONPlaceholder;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import java.io.File;

public class JsonplaceholderAPI {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR+"/src/test/resources/Jsonfile";



    public static final String POST_CREATE_POST = BASE_URL+"/posts/";
    public static final String POST_CREATE_COMMENTS = BASE_URL+"/comments/";
    public static final String POST_INVALID_CREATE_POST = BASE_URL+"/post/";
    public static final String GET_LIST_ALBUMS = BASE_URL+"/albums/";
    public static final String GET_SINGLE_ALBUMS = BASE_URL+"/albums/{id}";
    public static final String GET_LIST_ALBUM_BY_TITLE = BASE_URL+"/albums?title={title}";
    //////////////
    public static final String GET_ALL_COMMENTS = BASE_URL + "/comments";
    public static final String GET_COMMENTS_ID = BASE_URL + "/comments/{id}";
    public static final String GET_COMMENTS_STRING = BASE_URL + "/comments/{stringID}";
    public static final String GET_COMMENTS_PARAMETER_ID = BASE_URL + "/comments?postId={id}";
    public static final String PATCH_POSTS_ID = BASE_URL + "/posts/{id}";
    public static final String PATCH_POSTS_STRING = BASE_URL + "/posts/{string}";
    public static final String DELETE_POSTS_ID = BASE_URL + "/posts/{id}";
    public static final String DELETE_POSTS_STRING = BASE_URL + "/posts/{string}";
    public static final String DELETE_COMMENTS_ID = BASE_URL + "/comments/{id}";
    public static final String DELETE_COMMENTS_STRING = BASE_URL + "/comments/{string}";
    ///////////////////
    public static String PUT_UPDATE = BASE_URL+"/posts/{id}";
    public static String GET_POSTS = BASE_URL+"/posts";
    public static String GET_POSTS_INVALID1 = BASE_URL+"/posts?501";
    public static String GET_POSTS_INVALID2 = BASE_URL+"/posts?wuuff";
    public static String GET_INVALID = BASE_URL+"/posts/{id}";
    public static String GET_LIMIT = BASE_URL+"/posts/{id}";



    @Step("Post create post")
    public void postCreatepost(File jsonFile){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(jsonFile);
    }

    @Step("GET list albums")
    public void getListAlbums(){
        SerenityRest.given();
    }

    @Step("Get Single album with valid id")
    public void getSingleAlbumWithValidId(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get Single album with invalid id")
    public void getSingleAlbumWithInvalidId(String id){
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("GET list albums with valid parameter")
    public void getListAlbumsWithValidParameter(String title){
        SerenityRest.given()
                .pathParam("title", title);
    }

    ////////////////////

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

    /////////////////
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
