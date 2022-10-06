package JSONPlaceholder;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import java.io.File;

public class JsonplaceholderAPI {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    public static final String POST_CREATE_POST = BASE_URL+"posts/";
    public static final String POST_CREATE_COMMENTS = BASE_URL+"comments/";
    public static final String POST_INVALID_CREATE_POST = BASE_URL+"post/";
    public static final String GET_LIST_ALBUMS = BASE_URL+"albums/";
    public static final String GET_SINGLE_ALBUMS = BASE_URL+"albums/{id}";
    public static final String GET_LIST_ALBUM_BY_TITLE = BASE_URL+"albums?title={title}";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR+"/src/test/resources/Jsonfile";

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



}
