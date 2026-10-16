package com.example.polypath;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView; // Ye import hona zaroori hai

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // 1. Back Arrow Setup
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Select Your Branch");
        }


        CardView btnComputer = findViewById(R.id.cardComputer);
        CardView btnElectrical = findViewById(R.id.cardElectrical);
        CardView btnCivil = findViewById(R.id.cardCivil);
        CardView btnMechanical = findViewById(R.id.cardMechanical);

        // 3. Click Listeners
        if (btnComputer != null) {
            btnComputer.setOnClickListener(v -> openSemester("COMPUTER"));
        }
        if (btnElectrical != null) {
            btnElectrical.setOnClickListener(v -> openSemester("ELECTRICAL"));
        }
        if (btnCivil != null) {
            btnCivil.setOnClickListener(v -> openSemester("CIVIL"));
        }
        if (btnMechanical != null) {
            btnMechanical.setOnClickListener(v -> openSemester("MECHANICAL"));
        }
    }


    private void openSemester(String branchName) {
        // Make sure SemesterActivity manifest mein add ho
        Intent intent = new Intent(DashboardActivity.this, SemesterActivity.class);
        intent.putExtra("BRANCH_NAME", branchName);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}