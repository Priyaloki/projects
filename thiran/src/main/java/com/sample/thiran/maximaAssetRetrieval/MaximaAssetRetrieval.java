package com.sample.thiran.maximaAssetRetrieval;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MaximaAssetRetrieval {


    public void getMaximaAsset(){
        try {
            // Maximo API URL for retrieving asset information
            String apiUrl = "https://bportaluri.com/wp-content/MaximoJavaDocs76/";
    
            // Set up connection to Maximo API
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
    
            // Add authentication if required
            // connection.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString("username:password".getBytes()));
    
            // Check if connection is successful
            if (connection.getResponseCode() != 200) {
                System.out.println("Failed : HTTP error code : " + connection.getResponseCode());
            }
    
            // Read response from API
            BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));
            StringBuilder responseBuilder = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                responseBuilder.append(output);
            }
    
            // Parse JSON response
            JSONParser parser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) parser.parse(responseBuilder.toString());
    
            // Extract asset information
            JSONArray assetArray = (JSONArray) jsonResponse.get("member");
            for (Object assetObj : assetArray) {
                JSONObject asset = (JSONObject) assetObj;
                String assetNum = (String) asset.get("AssetNum");
                String description = (String) asset.get("Description");
                String location = (String) asset.get("Location");
    
                // Print asset information
                System.out.println("Asset Number: " + assetNum);
                System.out.println("Description: " + description);
                System.out.println("Location: " + location);
                System.out.println();
            }
    
            // Close connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    
    
}
