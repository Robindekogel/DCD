package com.example.android.dcd_v31.Login;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.dcd_v31.R;

public class splashActivity extends AppCompatActivity {
    private  static int SPLASH_TIME_OUT = 700;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent goLogin2 = new Intent(splashActivity.this, LoginActivity.class);
                startActivity(goLogin2);
            }
        },SPLASH_TIME_OUT);
    }
}
