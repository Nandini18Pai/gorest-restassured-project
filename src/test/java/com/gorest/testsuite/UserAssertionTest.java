package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserAssertionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        response = given()
                .queryParam("page", "1")
                .queryParam("per_page", "20")
                .get("/users")
                .then().statusCode(200);
    }


//            1. Verify the if the total record is 20

    @Test
    public void test001() {
        response.body("total.size", equalTo(20));

    }


    //           Verify the if the name of id = 5487 is equal to ”Ekaling Marar"
    @Test
    public void test002() {
        response.body("[2].name", equalTo("Ekaling Marar"));

    }


    // 3. Check the single ‘Name’ in the Array list (Inder Kapoor Sr.)
    @Test
    public void test003() {
        response.body("[0].name", equalTo("Inder Kapoor Sr."));

    }

//            4.  Check the multiple ‘Names’ in the ArrayList (Tushar Ahluwalia,Manisha Khan,Bhima Acharya)

    @Test
    public void test004() {
        response.body("name", hasItems("Tushar Ahluwalia","Manisha Khan","Bhima Acharya"));

    }

    //            5.Verify the email of userid = 4040714 is equal “preity_patel_mr@bogan-willms.example”
    @Test
    public void test005() {
        response.body("[5].email", equalTo("preity_patel_mr@bogan-willms.example"));

    }

    //            6. Verify the status is “active” of user name is “Anish Reddy Sr.”
    @Test
    public void test006() {
        response.body("[5].status", equalTo("active"));

    }

//            7. Verify the Gender = female of user name is “Deeptimay Panicker”

    @Test
    public void test007() {
        response.body("[4].gender", equalTo("female"));

    }
}
