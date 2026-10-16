package com.example.polypath;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.polypath.QuizPlayActivity;

public class QuizLevelsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_levels);
        refreshLevels();
    }



    private void refreshLevels() {
        int[] ids = {R.id.lvl1, R.id.lvl2, R.id.lvl3, R.id.lvl4, R.id.lvl5, R.id.lvl6, R.id.lvl7, R.id.lvl8};
        SharedPreferences prefs = getSharedPreferences("QuizProg", MODE_PRIVATE);

        // Agar koi level lock karna hai (Level 2 maan lo)
        Button lvl2 = findViewById(R.id.lvl2);
        boolean isLevel1Cleared = true; // Ye teri game logic se aayega

        if (isLevel1Cleared) {
            lvl2.setEnabled(true);
            // Unlocked look (Pale Green jo humne XML mein dala tha)
        } else {
            lvl2.setEnabled(false);
            lvl2.setAlpha(0.5f); // Button thoda dhundla dikhega
        }

        for (int i = 0; i < ids.length; i++) {
            int levelNum = i + 1;
            Button btn = findViewById(ids[i]);
            // Level 1 hamesha khula rahega
            boolean unlocked = (levelNum == 1) || prefs.getBoolean("level" + levelNum, false);

            if (unlocked) {
                btn.setEnabled(true);
                btn.setBackgroundColor(Color.GREEN);
                btn.setOnClickListener(v -> {
                    Intent intent = new Intent(this, QuizPlayActivity.class);
                    intent.putExtra("L_NUM", levelNum);
                    startActivity(intent);
                });
            } else {
                btn.setEnabled(false);
                btn.setBackgroundColor(Color.GRAY);
                btn.setText("L" + levelNum + " 🔒");
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshLevels(); // Jab quiz khel kar wapas aao toh naya level khul jaye
    }
}