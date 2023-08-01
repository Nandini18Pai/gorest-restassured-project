package com.gorest.crudtest;

import com.gorest.model.PostsPojo;
import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import com.gorest.utils.TestUtils;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {



    // to create new user
    @Test
    public void verifyUserCreatedSuccessfully() {

        String email = TestUtils.getRandomValue() + "kelly@gmail.com";

        PostsPojo postsPojo = new PostsPojo();

        postsPojo.setName("Chino Kelly");
        postsPojo.setEmail(email);
        postsPojo.setGender("male");
        postsPojo.setStatus("active");


        // make request to server to create new user
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 900a38611f746a0858001015fcdb1cd10f828a43237c1e9b3acf7dbc9cf3a925 " )
                .when()
                .body(postsPojo)
                .post("/users");
        response.prettyPrint();
        //To fetch response from server
        response.then().log().all().statusCode(201);



    }


    @Test
    public void verifyUserUpdateSuccessfully() {

        String email = TestUtils.getRandomValue() + "parmar12354@gmail.com";
        UserPojo userPojo = new UserPojo();

        userPojo.setName("Ritu Parmar");
        userPojo.setEmail(email);
        userPojo.setStatus("Inactive");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 900a38611f746a0858001015fcdb1cd10f828a43237c1e9b3acf7dbc9cf3a925 " )
                .when()
                .body(userPojo)
                .put("/users/4138047");

        response.then().log().all().statusCode(200);






    }


    @Test

    public void VerifyUserDeleteSuccessfully() {

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 900a38611f746a0858001015fcdb1cd10f828a43237c1e9b3acf7dbc9cf3a925 " )
                .when()
                .delete("/users/4138047");
        response.then().statusCode(204);
        response.prettyPrint();



    }


}
