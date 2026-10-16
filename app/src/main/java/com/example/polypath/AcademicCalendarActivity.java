package com.example.polypath;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class AcademicCalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_calendar);

        // 1. Action Bar Back Button & Title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Academic Calendar");
        }

        // 2. Load PDFs using Google Drive IDs
        loadPdf(findViewById(R.id.webViewCalendar1), "1EndAIBx9UGD7XWx-AyPGv2iR6FnXfvaP");


        // 3. Exam Form Portal Link
        Button btnExam = findViewById(R.id.btnExamForm);
        btnExam.setOnClickListener(v -> {
            String portalUrl = "https://msbte.org.in/";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(portalUrl));
            startActivity(intent);
        });
    }

    private void loadPdf(WebView wv, String id) {
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient());
        String url = "https://docs.google.com/viewer?embedded=true&url=https://drive.google.com/uc?id=" + id;
        wv.loadUrl(url);
    }

    // Back Arrow functionality
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}