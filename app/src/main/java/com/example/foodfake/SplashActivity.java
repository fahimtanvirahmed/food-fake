package com.example.foodfake;



import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private  TextView  foradmin;
    private  TextView  foruser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        foradmin = (TextView) findViewById(R.id.foradmin);
        foruser = (TextView) findViewById(R.id.foruser);
        foradmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this,AdminloginActivity.class));
            }
        });
        foruser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this,loginActivity.class));
            }
        });


        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        /*

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, loginActivity.class));
                finish();
            }
        }, 2000);

         */
    }
}