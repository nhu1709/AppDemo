package com.example.appdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout mLoginByAccountLayout, mLoginByQrLayout;
    TextView mForgotPassword;
    Button mLoginByAccount, mLoginByQr, mLogin, mRegister;
    EditText mEmail, mPassword;
    ImageView mQrImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        mLoginByAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginByAccountLayout.setVisibility(View.VISIBLE);
                mLoginByQrLayout.setVisibility(View.GONE);
            }
        });
        mLoginByQr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginByAccountLayout.setVisibility(View.GONE);
                mLoginByQrLayout.setVisibility(View.VISIBLE);
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView(){
        mLoginByAccountLayout = findViewById(R.id.login_by_account_layout);
        mLoginByQrLayout = findViewById(R.id.login_by_qr_layout);
        mForgotPassword = findViewById(R.id.fogot_password);
        mLoginByAccount = findViewById(R.id.login_by_account);
        mLoginByQr = findViewById(R.id.login_by_qr);
        mLogin = findViewById(R.id.login_button);
        mRegister = findViewById(R.id.register_button);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mQrImage = findViewById(R.id.qr);
    }
}