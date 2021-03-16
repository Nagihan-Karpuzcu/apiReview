package com.study.pojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class PersonOBJ {


@Test
        public void PersonPojoo()

    {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .pathParam("name", "Eddard Stark")
                .when().get("https://api.got.show/api/show/ages/{name}");
        System.out.println("response.path(\"name\") = " + response.path("name"));
        List as = response.body().as(List.class);
        System.out.println("as = " + as);
        System.out.println("as.get(0) = " + as.get(0));
        String s = as.get(0).toString();
        System.out.println("s = " + s);
        String[] split = s.split(",");
        System.out.println("split[1] = " + split[1]);
        String[] split1 = split[1].split("=");
        System.out.println( split1[1]);//name

    }

}