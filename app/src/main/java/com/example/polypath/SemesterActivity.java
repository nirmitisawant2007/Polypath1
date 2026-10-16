package com.example.polypath;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

public class SemesterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester);

        // 1. Action Bar Setup (Back Arrow)
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // 2. Intent se Branch Name lena
        String branch = getIntent().getStringExtra("BRANCH_NAME");

        // 3. Title Update karna
        TextView title = findViewById(R.id.tvSemesterTitle);
        if (branch != null) {
            title.setText(branch);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle(branch + " Semesters");
            }
        }

        // 4. CardView Click Listeners (Buttons ki jagah Cards)
        CardView cardSem1 = findViewById(R.id.cardSem1);
        CardView cardSem2 = findViewById(R.id.cardSem2);

        cardSem1.setOnClickListener(v -> openSubjectPage(branch, "1st"));
        cardSem2.setOnClickListener(v -> openSubjectPage(branch, "2nd"));

        // 5. Numbers (1 aur 2) par Gradient Effect lagana
        applyGradientToNumber(findViewById(R.id.tvNum1));
        applyGradientToNumber(findViewById(R.id.tvNum2));
    }

    // Gradient Shader apply karne ka function
    private void applyGradientToNumber(TextView textView) {
        if (textView == null) return;

        textView.post(() -> {
            // Reference image ke colors (Orange -> Green -> Blue mix)
            int colorStart = ContextCompat.getColor(this, android.R.color.holo_orange_light);
            int colorMid = ContextCompat.getColor(this, android.R.color.holo_green_light);
            int colorEnd = ContextCompat.getColor(this, android.R.color.holo_blue_light);

            Shader textShader = new LinearGradient(0, 0, 0, textView.getTextSize(),
                    new int[]{colorStart, colorMid, colorEnd},
                    new float[]{0f, 0.5f, 1f}, Shader.TileMode.CLAMP);

            textView.getPaint().setShader(textShader);
            textView.invalidate();
        });
    }

    // Next page par jane ka logic
    private void openSubjectPage(String branch, String semester) {
        Intent intent = new Intent(SemesterActivity.this, SubjectActivity.class);
        intent.putExtra("BRANCH_NAME", branch);
        intent.putExtra("SEMESTER", semester);
        startActivity(intent);
    }

    // Back arrow click handle karne ke liye
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}