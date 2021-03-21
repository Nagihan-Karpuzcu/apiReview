package com.study.Online;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Chapter3Test {

    private static RequestSpecification requestSpec;

    //her seferinde acacak baseUri gibi
    @BeforeClass
    public static void createRequestSpeccification(){

        requestSpec = new RequestSpecBuilder ().
                setBaseUri("http://api.zippopotam.us").build();
        }


        @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_ExpectBeverly_withRequestSpec(){

        given().spec (requestSpec).when ()
                .get ("us/90210").then ().assertThat ().statusCode (200);

        }

}
