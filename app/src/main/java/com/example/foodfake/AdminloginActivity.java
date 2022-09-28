package com.example.foodfake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminloginActivity extends AppCompatActivity {
    private EditText aName;
    private EditText aPassword;
    private Button aLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        aName = (EditText) findViewById(R.id.AdetName);
        aPassword = (EditText) findViewById(R.id.AdetPassword);
        aLogin = (Button) findViewById(R.id.AdbtnLogin);

        aLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pass = aName.getText().toString().trim();
                String repass = aPassword.getText().toString().trim();
                validate(pass, repass);
            }
        });

    }

    private void validate(String userName, String userPassword) {
        if ((userName.equals("Admin")) && (userPassword.equals("12345678")) ){
            startActivity(new Intent(AdminloginActivity.this, MainActivity.class));
        } else {
            Toast.makeText(AdminloginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(AdminloginActivity.this, Orderlist.class));
        }

    }
}