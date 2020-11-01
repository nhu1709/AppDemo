package com.example.appdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button  mLogin, mRegister;
    EditText mEmail, mPassword;
    TextView textView;
    Group group;
    boolean isResgisterSs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();


        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateLogin()){
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Register.class));
            }
        });
    }


    private boolean validateLogin(){
        return true;
    }

    private void initView(){
        group = findViewById(R.id.group_register);
        textView  = findViewById(R.id.title);
        mLogin = findViewById(R.id.login_button);
        mRegister = findViewById(R.id.register_button);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
    }
}