package com.example.polypath;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FaqActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        // Action Bar setup (Back button aur title ke liye)
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("FAQs");
        }

        // --- 13 FAQs SETUP LOGIC ---
        // Ye loop khud hi layout_faq1 se layout_faq13 tak ki IDs dhund lega
        for (int i = 1; i <= 13; i++) {
            final int index = i;

            // XML se IDs nikalna dynamic tarike se
            int resQuestionId = getResources().getIdentifier("layout_faq" + index, "id", getPackageName());
            int resAnswerId = getResources().getIdentifier("tv_answer" + index, "id", getPackageName());
            int resArrowId = getResources().getIdentifier("iv_arrow" + index, "id", getPackageName());

            View layoutQuestion = findViewById(resQuestionId);
            final TextView tvAnswer = findViewById(resAnswerId);
            final ImageView ivArrow = findViewById(resArrowId);

            // Click listener set karna
            if (layoutQuestion != null && tvAnswer != null) {
                layoutQuestion.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (tvAnswer.getVisibility() == View.GONE) {
                            tvAnswer.setVisibility(View.VISIBLE);
                            if (ivArrow != null) ivArrow.animate().rotation(180f).setDuration(300).start();
                        } else {
                            tvAnswer.setVisibility(View.GONE);
                            if (ivArrow != null) ivArrow.animate().rotation(0f).setDuration(300).start();
                        }
                    }
                });
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // Back button press handle karne ke liye
        return true;
    }
}