package com.example.polypath;

import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class PdfViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);

        String subjectTitle = getIntent().getStringExtra("SUBJECT_NAME");
        String pdfId = getIntent().getStringExtra("PDF_ID");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(subjectTitle != null ? subjectTitle : "PDF Viewer");
        }

        WebView webView = findViewById(R.id.pdfWebView);
        WebSettings settings = webView.getSettings();

        settings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        // Zoom aur Scrolling set up
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        webView.setInitialScale(1);

        if (pdfId != null && !pdfId.isEmpty()) {
            String url = "https://drive.google.com/file/d/" + pdfId + "/preview";
            webView.loadUrl(url);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}