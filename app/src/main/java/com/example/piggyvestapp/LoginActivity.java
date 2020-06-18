package com.example.piggyvestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class LoginActivity extends AppCompatActivity {

    EditText email;
    ProgressBar progressBar;
    EditText password;
    Button button;
    public static final String USERKEY = "USERKEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.field_email);
        password = findViewById(R.id.field_password);
        button = findViewById(R.id.button_sign_in);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar = new ProgressBar(getApplicationContext());
                signIn();
            }
        });



    }


    public void signIn(){

        if(!(email.getText()).equals(null) &&!(password.getText()).equals(null)){
            Intent intent = new Intent(this, DashboardActivity.class);
            intent.putExtra(USERKEY, email.getText().toString());
            startActivity(intent);
        }
    }
}
