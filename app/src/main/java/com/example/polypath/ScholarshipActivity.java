package com.example.polypath;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ScholarshipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Sabse pehle ye
        setContentView(R.layout.activity_scholarship); // Phir layout set karo

        // Ab Action Bar set karo
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Scholarship Info");
        }



        // PDF 1 Load Karo
        WebView webView1 = findViewById(R.id.webViewPdf1);
        loadMyPdf(webView1, "1hC1gnrBjrC8lURhwKphKNuYPMvvfcgrK");

        // MSBTE Official Portal Link
        Button btnApply = findViewById(R.id.btnApplyLink);
        btnApply.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://msbte.org.in/"));
            startActivity(intent);
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void loadMyPdf(WebView wv, String id) {
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient());
        String url = "https://docs.google.com/viewer?embedded=true&url=https://drive.google.com/uc?id=" + id;
        wv.loadUrl(url);
    }
}