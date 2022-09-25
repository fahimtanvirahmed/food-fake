package com.example.foodfake;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.foodfake.model.RestaurantModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class OrderSucceessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_succeess);


        RestaurantModel restaurantModel = getIntent().getParcelableExtra("RestaurantModel");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(restaurantModel.getName());
        actionBar.setSubtitle(restaurantModel.getAddress());
        actionBar.setDisplayHomeAsUpEnabled(false);


        TextView buttonDone = findViewById(R.id.buttonDone);
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newmenu();

                finish();
            }
        });
    }
   public void newmenu() {
        JSONObject e = new JSONObject();

       try {
           e.put("name", "gfd");
           e.put("price", "sfs");
           // e.put("delivery_charge", "56");
           e.put("url", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Chicken_Nuggets.jpg");
       } catch (JSONException ex) {
           ex.printStackTrace();
       }



        try{
            FileWriter file=new FileWriter("C:\\Users\\Rakib\\AndroidStudioProjects\\foodfake\\app\\src\\main\\res\\raw\\restaurants.json");
            file.write(e.toString());
            file.flush();
            file.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}