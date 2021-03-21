package com.study.Online;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Chapter5Test {


    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expecteBeverly() {

        given ().
                when ().
                get ("http://api.zippopotam.us/us/9021").then ()
                .assertThat ().body ("response.places.place.placeName", equalTo ("Beverly Hills"));
    }
        @Test
        public void requestUsZipCode24848_checkThirdPlaceNameInResponseBody_expectKroop_XML(){


    }


















}
