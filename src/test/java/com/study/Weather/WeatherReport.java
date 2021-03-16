package com.study.Weather;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherReport {
    public static void main(String[] args) throws IOException {

        String apiKey = "afc1387bb4cc87d707e38e9ac478f034";
        String serviceApi = "api.openweathermap.org/data/2.5/weather?q";
        String location = "New York City";
        String units = "metric";
        String URI = serviceApi + location + "&appid = " + apiKey + "&units=" + units;


        // Connection
        URL url = new URL(URI);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responseCode = conn.getResponseCode();


        //System.out.println(responseCode);

        // Check response code
        if (responseCode != 200) {
            System.out.println("Web Service Response Code: " + responseCode);
            System.exit(0);

        }

        StringBuilder inline = new StringBuilder();
        Scanner scanner = new Scanner(url.openStream());
        while (scanner.hasNext())
            inline.append(scanner.nextLine());
        System.out.println(inline);

        scanner.close();



    }
}