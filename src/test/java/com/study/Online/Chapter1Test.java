package com.study.Online;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.study.utilities.ConfigurationReader;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/* {
    "post code": "90210",
    "country": "United States",
    "country abbreviation": "US",
    "places": [
        {
            "place name": "Beverly Hills",
            "longitude": "-118.4065",
            "state": "California",
            "state abbreviation": "CA",
            "latitude": "34.0901"
        }
    ]
}*/

public class Chapter1Test {

    @BeforeClass
    public void setup() {

        baseURI = ConfigurationReader.get ("zippo_url");
    }

    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills() {

        given ().
                when ().get (baseURI).
                then ().
                assertThat ().
                body ("places[0].'place name'", equalTo ("Beverly Hills")).log ().all ();

    }

    @Test
    public void requestUsZipCode90210_checkStatusCode_expectHttp200() {
        given ().get (baseURI).then ().assertThat ().statusCode (200);

    }

    @Test
    public void requestUsZipCode90210_checkContentType_expectContentType() {

        given ().get (baseURI).then ().assertThat ().contentType (ContentType.JSON);

    }

    //logging request and response details
    @Test
    public void requestUsZipCode90210_logRequestAndResponseDetails() {
        given ().log ().all ()
                .when ().get (baseURI).then ().log ().body ();
    }

    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_ExpectBeverlyHills() {
        given ().get (baseURI).then ().assertThat ()
                .body ("places[0].'place name'", equalTo ("Beverly Hills"));

    }
    @Test
    public void requestUsZipCode90210_checkPlaceStateInResponseBody_ExpectCalifronia(){

        given ().get (baseURI).then ()
                .assertThat ().body ("places[0].state", equalTo ("California"));
    }
    @Test
    public void requestUsZipCode90210_checkPlaceSNameInResponseBody_ExpectContainName_Hamcrest() {

         given ().get (baseURI).then ().assertThat ().body ("places.'place name'" , hasItem ("Beverly Hills"));


    }
    @Test
    public void requestUsZipCode90210_checkPlaceSNameInResponseBody_ExpectNotContainName_Hamcrest() {

        given ().get (baseURI).then ().assertThat ().body ("places.'place name'" , not (hasItem ("Beverly Hills")));


    }
    @Test
    public void requestUsZipCode90210_checkNumberOfPlaceSNameInResponseBody_Expect1_Hamcrest() {

        when ().get (baseURI).then ().assertThat (). body("places.'place name'", hasSize(1));
    }
    }
