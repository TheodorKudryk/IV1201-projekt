package com.iv1201.client.integration;

import com.iv1201.client.model.Competence;
import com.iv1201.client.model.Person;
import com.iv1201.client.model.UserDTO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject; 

/**
 *
 * @author leohj
 */
public class DBHandler {
    private static StringBuilder dbAPICallPostAuth(String urlString, String body) throws ConnectException {

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            StringBuilder content;
            connection.setRequestProperty("Accept", "application/json");
            
            connection.setDoOutput(true);
            try(OutputStream os = connection.getOutputStream()) {
                byte[] input = body.getBytes("utf-8");
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
        } catch(ConnectException ex){
            throw ex;
        } catch (Exception ex) {
            System.out.println("Error in dbAPICallPostAuth()");
            ex.printStackTrace();
        }
        return null;

    }
    
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
    
    private static StringBuilder dbAPICallGet(String urlString, String token) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            if (token != "")
                connection.setRequestProperty("Authorization", "Bearer "+token);
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
    
    public static Person validateLogin(String username, String password) throws ConnectException {
        String body = "username="+username+"&password="+password;
        StringBuilder content = dbAPICallPostAuth("http://localhost:8081/login", body);
        if (content == null)
            return null;
         
        JSONObject myJsonObj = new JSONObject(content.toString());
        StringBuilder contentUser = dbAPICallGet("http://localhost:8081/user/"+username, myJsonObj.getString("access_Token"));
        JSONObject myJsonObj2 = new JSONObject(contentUser.toString());
        Person person = new Person(myJsonObj2.getString("name"),myJsonObj.getString("access_Token"), myJsonObj2.getJSONObject("role").getString("name"));
        return person;
    }
    
    public static void updateUser(UserDTO user){
        String body = "{"
                + "'username': '" + user.getUsername() + "',"
                + "'password': '" + user.getPassword() + "',"
                + "'email': '" + user.getEmail() + "'"
                + "}";
        dbAPICallPost("http://localhost:8081/updateuser", body);
    }
    
    public static List<Competence> loadCompetence(String language) {
        List<Competence> competenceList = new ArrayList<Competence>();
        StringBuilder content = dbAPICallGet("http://localhost:8081/competences", "");
        JSONArray myJsonArray = new JSONArray(content.toString());
        int j = 0;
        if(language.contains(languages.sv.toString())){
            j = (1*(myJsonArray.length()/languages.values().length));            
        }else{
            j = (0*(myJsonArray.length()/languages.values().length));
    }
        for(int i = 0; i < (myJsonArray.length()/languages.values().length); i++){
            
            competenceList.add(new Competence(myJsonArray.getJSONObject(i+j).getInt("id"), myJsonArray.getJSONObject(i+j).getString("name")));
        }
        
        return competenceList;
    }
        
}
enum languages { en, sv;}