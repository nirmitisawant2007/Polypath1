package com.example.polypath;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class FeedbackActivity extends AppCompatActivity {

    private TableLayout table;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        // 1. Action Bar with Back Arrow
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Feedback & Ratings");
        }

        table = findViewById(R.id.tableFeedback);
        sharedPreferences = getSharedPreferences("FeedbackData", MODE_PRIVATE);

        EditText etName = findViewById(R.id.etFeedbackName);
        EditText etEmail = findViewById(R.id.etFeedbackEmail);
        EditText etComment = findViewById(R.id.etFeedbackComment);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        Button btnSubmit = findViewById(R.id.btnSubmitFeedback);

        // 2. Load existing data on start
        loadSavedFeedback();

        btnSubmit.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String comment = etComment.getText().toString().trim();
            String rating = String.valueOf(ratingBar.getRating());

            if (name.isEmpty() || email.isEmpty() || comment.isEmpty()) {
                Toast.makeText(this, "Bhai, saare fields bharo!", Toast.LENGTH_SHORT).show();
                return;
            }

            // UI mein sahi sequence mein dikhao: Name -> Rating -> Comment -> Email
            addTableRow(name, rating, comment, email);

            // Memory mein permanently save karo
            saveFeedbackLocally(name, rating, comment, email);

            // Form clear karo
            etName.setText("");
            etEmail.setText("");
            etComment.setText("");
            ratingBar.setRating(0);

            Toast.makeText(this, "Feedback Saved!", Toast.LENGTH_SHORT).show();
        });

        // FAQ Button define karo
        Button btnFaq = findViewById(R.id.btnOpenFAQs);

// FAQ Button ka Click Listener
        btnFaq.setOnClickListener(v -> {
            // Ye line FAQ interface ko open karegi
            Intent intent = new Intent(FeedbackActivity.this, FaqActivity.class);
            startActivity(intent);
        });
    }

    // Is method mein columns ka sequence tere header se match karta hai
    private void addTableRow(String n, String r, String c, String e) {
        TableRow row = new TableRow(this);
        row.setPadding(8, 15, 8, 15);

        // Column 1: Name
        TextView t1 = new TextView(this); t1.setText(n);
        t1.setLayoutParams(new TableRow.LayoutParams(0, -2, 1f));

        // Column 2: Rating
        TextView t2 = new TextView(this); t2.setText(r + "★");
        t2.setLayoutParams(new TableRow.LayoutParams(0, -2, 1f));

        // Column 3: Comment
        TextView t3 = new TextView(this); t3.setText(c);
        t3.setLayoutParams(new TableRow.LayoutParams(0, -2, 1f));

        // Column 4: Email
        TextView t4 = new TextView(this); t4.setText(e);
        t4.setLayoutParams(new TableRow.LayoutParams(0, -2, 1f));

        row.addView(t1);
        row.addView(t2);
        row.addView(t3);
        row.addView(t4);

        table.addView(row);
    }

    private void saveFeedbackLocally(String n, String r, String c, String e) {
        String existing = sharedPreferences.getString("all_data", "");
        // Saving in sequence: Name|Rating|Comment|Email
        String newData = existing + n + "|" + r + "|" + c + "|" + e + "###";
        sharedPreferences.edit().putString("all_data", newData).apply();
    }

    private void loadSavedFeedback() {
        String allData = sharedPreferences.getString("all_data", "");
        if (!allData.isEmpty()) {
            String[] rows = allData.split("###");
            for (String rowData : rows) {
                String[] parts = rowData.split("\\|");
                if (parts.length == 4) {
                    // Parts order: 0=Name, 1=Rating, 2=Comment, 3=Email
                    addTableRow(parts[0], parts[1], parts[2], parts[3]);
                }
            }
        }
    }

    // Back arrow functionality
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}