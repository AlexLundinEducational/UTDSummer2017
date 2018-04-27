package chatBot;


import org.jibble.pircbot.*;
import com.google.gson.*;
import com.google.gson.Gson;
import com.google.gson.Gson.*;
import com.google.gson.GsonBuilder;
import java.net.*;
import java.net.HttpURLConnection;
import java.io.*;

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

public class MyBot extends PircBot {
    
    public MyBot() {
        this.setName("AlexLundint22");
    }
    
    public void onMessage(String channel, String sender,
                       String login, String hostname, String message) {
        if (message.equalsIgnoreCase("time")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, sender + ": The time is now " + time);
            

                         
//            String sURL = "http://freegeoip.net/json/"; //just a string
//       
//             // Connect to the URL using java's native library
//             URL url = new URL("http://freegeoip.net/json/");
//             HttpURLConnection request = (HttpURLConnection) url.openConnection();
//             request.connect();
//             
//             // Convert to a JSON object to print data
//             JsonParser jp = new JsonParser(); //from gson
//             JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
//             JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
//             String zipcode = rootobj.get("zip_code").getAsString(); //just grab the zipcode            
//             
//             sendMessage(channel, sender + ": The time is now " + zipcode);  
               
        }
    }
    
    //weather api key
    //default
    //62807aeaac56fce9b58b58a74a01bed7
    //AlexLundin
    //b495859f342150f25327b5251f7710e2
    //api.openweathermap.org/data/2.5/forecast?id=524901&APPID=1111111111 
    //api.openweathermap.org/data/2.5/forecast?id=524901&APPID=62807aeaac56fce9b58b58a74a01bed7
    
   
    
}