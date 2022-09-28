package com.example.foodfake;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginActivity extends AppCompatActivity {



            private EditText Name;
            private EditText Password;
            private TextView Info;
            private Button Login;
            private int counter = 5;
            private TextView userRegistration;
            private FirebaseAuth firebaseAuth;
            private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


                Name = (EditText) findViewById(R.id.etName);
                Password = (EditText) findViewById(R.id.etPassword);
                Info = (TextView) findViewById(R.id.tvInfo);
                Login = (Button) findViewById(R.id.btnLogin);
                userRegistration = (TextView)findViewById(R.id.tvRegister);

                Info.setText("No of attempts remaining: 5");
                firebaseAuth=FirebaseAuth.getInstance();
                progressDialog = new ProgressDialog(this);
                FirebaseUser user=firebaseAuth.getCurrentUser();

                Login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String pass = Name.getText().toString().trim();
                        String repass = Password.getText().toString().trim();
                        validate(pass, repass);
                    }
                });

                userRegistration.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(loginActivity.this, RegistrationActivity.class));
                       // startActivity(new Intent(loginActivity.this, MainActivity.class));
                    }
                });

            }

            private void validate(String userName, String userPassword) {
                progressDialog.setMessage("Wait for some time!");
                progressDialog.show();

                firebaseAuth.signInWithEmailAndPassword(userName,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // DialogFragment progressDialog;
                        if(task.isSuccessful()){
                            progressDialog.dismiss();


                            // Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            // startActivity(new Intent(MainActivity.this,SecondActivity.class));
                            checkEmailVerification();
                        }else{
                            Toast.makeText(loginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            counter--;
                            Info.setText("No of attempts remaining: " + counter);
                            progressDialog.dismiss();
                            if(counter == 0){
                                Login.setEnabled(false);
                            }
                        }


                    }
                });
            }
            private void checkEmailVerification(){
                FirebaseUser firebaseUser = firebaseAuth.getInstance().getCurrentUser();
                assert firebaseUser != null;
                Boolean emailflag = firebaseUser.isEmailVerified();

                // startActivity(new Intent(MainActivity.this, SecondActivity.class));

                if(emailflag){
                    finish();
                    startActivity(new Intent(loginActivity.this, MainActivity.class));
                }else{
                    Toast.makeText(this, "Verify your email", Toast.LENGTH_SHORT).show();
                    firebaseAuth.signOut();

                }
            }
        }

