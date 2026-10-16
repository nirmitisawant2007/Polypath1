package com.example.polypath;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ExamFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_form); // Layout hamesha pehle load karein

        // Action Bar for Top Left Back Arrow
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Exam Form Details");
        }

        // Initialize WebViews
        WebView wv1 = findViewById(R.id.webViewExamPdf1);


        // Load your Google Drive IDs
        loadPdf(wv1, "1Z7Ba4Qgl-HczGfp8QAJdLMo8Z2n-2AZJ");


        // Apply Button
        Button btnApply = findViewById(R.id.btnApplyExam);
        btnApply.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://msbte.org.in/"));
            startActivity(intent);
        });
    }

    private void loadPdf(WebView wv, String fileId) {
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient());
        String url = "https://docs.google.com/viewer?embedded=true&url=https://drive.google.com/uc?id=" + fileId;
        wv.loadUrl(url);
    }

    // Yeh upar wale back arrow ko back activity par le jayega
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}