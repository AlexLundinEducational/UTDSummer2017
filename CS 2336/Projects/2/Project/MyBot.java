//Alex Lundin
//08-06-2017
import org.jibble.pircbot.*;
import com.google.gson.*;
import com.google.gson.Gson;
import com.google.gson.Gson.*;
import com.google.gson.GsonBuilder;
import java.net.*;
import java.net.HttpURLConnection;
import java.lang.*;
import java.net.*;
import java.io.*;
import java.util.Random;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.Reader;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyBot extends PircBot {
    
    public MyBot() {
        this.setName("AlexLundinChatBot");
    }
    

      //https://webchat.freenode.net/
      // Chatbot message parse  
    public void onMessage(String channel, String sender,
                       String login, String hostname, String message) {
                       
        String time = new java.util.Date().toString();               
        if (message.equalsIgnoreCase("time")) {
            sendMessage(channel, sender + "Chatbot found time request:" );
            sendMessage(channel, sender + ": The time is now " + time);
        } 
        
        String urlString = "null url";
        
        if (message.equalsIgnoreCase("zip")) {
            urlString ="http://freegeoip.net/json/";
            sendMessage(channel, sender + "Chatbot found zip code request:" );
        }   
         
       //functional example of openweather URL call
       //http://api.openweathermap.org/data/2.5/forecast?zip=75070&APPID=b495859f342150f25327b5251f7710e2&units=imperial
       //this URL has two parameters explaned below
       //
       //explanation of setting up your own URL call    
       //this is the weather api url
       //replace {APIKEY} with any valid api key from registration
       //http://api.openweathermap.org/data/2.5/forecast?zip={ZIP}&APPID={APIKEY}&units={UNITSOFMEASURE}
       //keys
       //
       //{UNITSOFMEASURE}
       //units of measure for weather
       //       
       //{ZIP}
       //any valid zipcode
       //
       //{APIKEY}
       //default
       //62807aeaac56fce9b58b58a74a01bed7
       //AlexLundin
       //b495859f342150f25327b5251f7710e2
       //
       //extra information about using city ID's
       //city id's are more reliable         
       //optional {ZIP} replacement
       //you can swap this parameter with city id, replace zip={ZIP} with id={CITYID} and fill in {CITYID}
       //any valid city ID found here, http://openweathermap.org/help/city_list.txt  
       
        String weatherKeyWord = "weather";
        String zipString = "null Zip";     
         
         
        // weather message parse      
        if (message.toLowerCase().contains(weatherKeyWord.toLowerCase())) {

            // use regex pattern to search for digits grouped together
            // combine them into a group
            Pattern zipCode = Pattern.compile("\\d+");
            Matcher makeMatch = zipCode.matcher(message);
            makeMatch.find();
            zipString = makeMatch.group();

            // create URL string from zip code
            if (zipString != "null Zip"){
                  urlString = "http://api.openweathermap.org/data/2.5/forecast?zip=" + zipString + "&APPID=b495859f342150f25327b5251f7710e2&units=imperial";
                  sendMessage(channel, sender + "Chatbot found weather request:" );            
            }
            // alert client if zip code not found
            else{
                  zipString = "null Zip";
                  sendMessage(channel, sender + "Chatbot couldn't find a formated zipcode in weather request:" ); 
            }
        }
        
        
        String spaceKeyWord = "humans";

        // humans in space parse     
        if (message.toLowerCase().contains(spaceKeyWord.toLowerCase())) {

            urlString = "http://api.open-notify.org/astros.json/";
            sendMessage(channel, sender + "Chatbot found request for number of humans in space:");            



        }   
             
        // try catch to connect to URL
        // alert server with connection results
        if  (urlString != "null"){
            try{
            String returnData = connectToURL(urlString, zipString);
            sendMessage(channel, sender + "Connection to " + urlString + " succeeded.");
            sendMessage(channel, sender + returnData); 
            } catch (IOException e) {
            sendMessage(channel, sender + "Unhandled error in Chatbot URL connection.");
            sendMessage(channel, sender + "Connection to " + urlString + " failed.");
            sendMessage(channel, sender + time);
            throw new RuntimeException(e);
            }       
        }       
    }
    
    // URL connection
    public String connectToURL(String urlString, String zipString) throws IOException {
         String Data = "nullConnectionData";
         
         // Connect to the URL using java's native library
         URL url = new URL(urlString);
         HttpURLConnection request = (HttpURLConnection) url.openConnection();
         request.connect();
        
         // store a JSON object to parse
         JsonParser jp = new JsonParser(); //from gson
         JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
         Data = parseJSON(urlString,zipString,root);
         return Data;
    }    
    
    
    // parse json, depending on which url was hit
    public String parseJSON(String urlString, String zipString, JsonElement root){
         String Data = "nullJSONData";

         JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
          
          
         // if url string is for zipcode website
         // parse rootobj for zipcode          
         if (urlString == "http://freegeoip.net/json/"){
            String zipcode = rootobj.get("zip_code").getAsString(); //just grab the zipcode 
            
            Data = "The zipcode is " + zipcode;
         }
         
         
         // if message from user contained a zip code
         // parse rootobj for weather data
         if (zipString != "null Zip"){
         
            String message = rootobj.get("message").getAsString(); //just grab the message
            Double listCount = rootobj.get("cnt").getAsDouble(); //just grab the message
            JsonArray JSONdataArray = rootobj.get("list").getAsJsonArray(); //grab list array, which is 
            
            // the first item in the array is a JSON Object
            // this first object has the tempurate stored in a nested object called main
            JsonObject firstObject = JSONdataArray.get(0).getAsJsonObject();
            JsonObject mainObject = firstObject.get("main").getAsJsonObject();
            String temperature = mainObject.get("temp").getAsString();
            Data = "The tempurature is " + temperature + " degrees Fahrenheit.";           
         
         }
         

         // parse rootobj for number of humans in space
         if (urlString == "http://api.open-notify.org/astros.json/"){
         
            String number = rootobj.get("number").getAsString(); //just grab the message
            Data = "There are currently " + number + " humans ins space."; 

         
         }          
                 
         return Data;
    
    } 
    



    
   
    
}