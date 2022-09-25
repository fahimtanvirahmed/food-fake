package com.example.foodfake.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class NewMenu {
    public static void main(String[] args)  {
        JSONObject e = new JSONObject();
        try {
            e.put("name", "gfd");
            e.put("price", "sfs");
           // e.put("delivery_charge", "56");
            e.put("url", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Chicken_Nuggets.jpg/220px-Chicken_Nuggets.jpg");
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        try(FileWriter file=new FileWriter("restaurant.json")){

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
