package com.study.Online;


import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import  static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import static  io.restassured.RestAssured.baseURI;

@RunWith (DataProviderRunner.class)
public class Chapter3 {

    /* {
        "post code": "12345",
        "country": "United States",
        "country abbreviation": "US",
        "places": [
            {
                "place name": "Schenectady",
                "longitude": "-74.058",
                "state": "New York",
                "state abbreviation": "NY",
                "latitude": "42.8333"
            }
        ]
    }
    */
//    @BeforeClass
//    public void setUp() {
//        baseURI = ConfigurationReader.get ("url2_us");
//
//    }

    @Test
    public void requestUSZipCode12345_checkPlaceNameInResponseBody_ExpectSchenectady() {
        when ().get (baseURI).then ().assertThat ().body ("places[0].'place name'", equalTo ("Schenectady"));

    }
//data drivern with parameter
    //path  including with url
    //query paramerter which follow by KEY and VALUE with ? mark

//this is very powerful method :

   @DataProvider
    public static Object [] [] zipCodeAsAndPlaces(){
        return new Object[][]{
                {"us", "90210", "Beverly Hills"},
                {"us", "12345", "Schenectady"},
                {"ca", "B2R", "Waverley"},
                {"nl", "1001","Amsterdam"}

        };

   }
// this is ve
   @Test
    @UseDataProvider("zipCodeAsAndPlaces")
    public  void requestZipCodeFromCollection_checkPlaceNameInRequestBody_expectedSpecifivpLacedName(String countryCode,String zipCode,String expectedPlceName){
        given ()
                .pathParam ("countryCode", countryCode)
                .pathParam ("zipCode" , zipCode)
                .get ("http://api.zippopotam.us/{countryCode}/{zipCode}" ).then ()
                .assertThat ().body ("places[0].'place name'", equalTo (expectedPlceName));
   }



}