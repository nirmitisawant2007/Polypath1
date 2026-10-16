package com.example.polypath;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // This creates a 3-second delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This starts the next screen (MainActivity)
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // This closes the splash screen so the user can't go back to it
            }
        }, 5000);
    }
}