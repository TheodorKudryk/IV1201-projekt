package com.iv1201.client.integration;

import com.iv1201.client.model.Person;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject; 

/**
 *
 * @author leohj
 */
public class DBHandler {
    
    private static StringBuilder dbAPICallPost(String urlString, String body) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            StringBuilder content;
            connection.setRequestProperty("Accept", "application/json");
            
            JSONObject myJsonObj = new JSONObject(body);
            connection.setDoOutput(true);
            try(OutputStream os = connection.getOutputStream()) {
                byte[] input = myJsonObj.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
                os.flush();
                os.close();
            }
            BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
            String line;
            content = new StringBuilder();
            while ((line = input.readLine()) != null) {
                // Append each line of the response and separate them
                content.append(line);
                content.append(System.lineSeparator());
            }
            connection.disconnect();

            return content;
        } catch (Exception ex) {
            System.out.println("Error in dbAPICallPost()");
            ex.printStackTrace();
        }
        return null;
    }
    
    private static StringBuilder dbAPICallGet(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            StringBuilder content;
            
            BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            content = new StringBuilder();
            while ((line = input.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }

            connection.disconnect();
            return content;
        } catch (Exception ex) {
            System.out.println("Error in dbAPICall()");
            ex.printStackTrace();
        }
        return null;
    }
    
    public static Person validateLogin(String username, String password) {
        StringBuilder content = dbAPICallGet("http://localhost:8081/user/" + username);
        if (content == null)
            return null;
        JSONObject myJsonObj = new JSONObject(content.toString());
        
        Person person = new Person(myJsonObj.getInt("id"), myJsonObj.getString("name"),myJsonObj.getJSONObject("role").getString("name"));
        return person;
    }
    

}
