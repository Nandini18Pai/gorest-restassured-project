package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class PostsAssertionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        response = given()
                .queryParam("page", "1")
                .queryParam("per_page", "25")
                .get("/posts")
                .then().statusCode(200);
    }


    //    1. Verify the if the total record is 25
    @Test
    public void Test001() {
        response.body("total.size", equalTo(25));

    }


//   2. Verify the if the title of id = 56992 is equal to ”Defetiscor eius labore utrum deporto."”

    @Test
    public void Test002() {
        response.body("find{it.id=56992}.title", equalTo("Defetiscor eius labore utrum deporto."));
    }


    //   3. Check the single user_id in the Array list (4040709)
    @Test
    public void Test003() {
        response.body("user_id", hasItem(4040709));
    }

// 4. Check the multiple ids in the ArrayList (4040692, 4040691, 4040691)

    @Test
    public void Test004() {
        response.body("user_id", hasItems(4040692, 4040691, 4040691));
    }


// 5. Verify the body of userid = 56992 is equal “Aperio uredo vesper. Supplanto suasoria adiuvo. Vulgus stella demulceo. Consequatur chirographum vomica. Eos consequatur cilicium. Ipsa cedo vallum. Tenax repellat aestivus. Sint accipio viscus. Vado aggero stillicidium. Coepi claustrum conforto. Vetus curtus accusantium. Capto ipsam pax. Aperio consuasor vero. Aut tredecim terror."


    @Test
    public void Test005() {
        response.body("find{it.user_id=56992}.body",equalTo("Aperio uredo vesper. Supplanto suasoria adiuvo. Vulgus stella demulceo. Consequatur chirographum vomica. Eos consequatur cilicium. Ipsa cedo vallum. Tenax repellat aestivus. Sint accipio viscus. Vado aggero stillicidium. Coepi claustrum conforto. Vetus curtus accusantium. Capto ipsam pax. Aperio consuasor vero. Aut tredecim terror."));

    }


}






