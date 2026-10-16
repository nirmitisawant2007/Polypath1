package com.example.polypath;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class SubjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        String branch = getIntent().getStringExtra("BRANCH_NAME");
        String sem = getIntent().getStringExtra("SEMESTER");

        TextView tvHeaderTitle = findViewById(R.id.tvHeaderTitle);
        TextView tvHeaderSubTitle = findViewById(R.id.tvHeaderSubTitle);
        GridLayout container = findViewById(R.id.glSubjectList);

        if (branch != null && sem != null) {
            tvHeaderTitle.setText(branch);
            tvHeaderSubTitle.setText("Sem " + sem);

            // 3. Subject logic based on your previous work
            String[] subjects;

            if (branch.equals("COMPUTER")) {
                if (sem.equals("1st")) {
                    subjects = new String[]{"Basic Mathematics", "English", "Physics","Chemistry","Fundamentals of ICT","Yoga and Meditation","Engineering Workshop ","Engineering Graphics"};
                } else { // 2nd Semester
                    subjects = new String[]{"Programming in C", "Basic Electrical and Electronics ", "Applied Mathematics","Linux Basics","Professional Communication","Social and Life Skills","Web Page Designing"};
                }
            }
            else if (branch.equals("MECHANICAL")) {
                if (sem.equals("1st")) {
                    subjects = new String[]{"Basic Mathematics", "Englsih", "Physics","Chemistry","Fundamentals of ICT","Yoga and Meditation","Engineering Workshop ","Engineering Graphics"};
                } else { // 2nd Semester
                    subjects = new String[]{"Applied Mathematics", "Engineering Drawing", "Applied Physics","Applied Chemistry","Eng. Mechanics","Manufacturing Technology","Professional Communication","Social and life skills"};
                }
            }
            else if (branch.equals("ELECTRICAL")) {
                if (sem.equals("1st")) {
                    subjects = new String[]{"Basic Mathematics", "English", "Physics","Chemistry","Fundamentals of ICT","Yoga and Meditation","Engineering Workshop ","Engineering Graphics"};
                } else { // 2nd Semester
                    subjects = new String[]{"Elements of Electronics", "Applied Mathematics","Applied Physics","Applied Chemistry", "Basic Mechanical Engineering","Fundamentals of Electrical Engineering ","Professional Communication","Social life and Skills"};
                }
            }
            else if (branch.equals("CIVIL")) {
                if (sem.equals("1st")) {
                    subjects = new String[]{"Basic Mathematics", "English", "Physics","Chemistry","Fundamentals of ICT","Yoga and Meditation","Engineering Workshop ","Engineering Graphics"};
                } else { // 2nd Semester
                    subjects = new String[]{"Applied Mathematics", "Applied Physics","Applied Chemistry","Surveying","Engineering Mechanics","Professional Communication","Social and Life Skills"};
                }
            }
            else {
                subjects = new String[]{"General Subject 1", "General Subject 2"};
            }

            // 2. Loop through subjects to create PREMIUM CARDS
            for (String subName : subjects) {
                // Naya CardView banana
                CardView card = new CardView(this);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.width = 0;
                params.height = (int) (160 * getResources().getDisplayMetrics().density); // Perfect size
                params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
                params.setMargins(12, 12, 12, 12);
                card.setLayoutParams(params);
                card.setRadius(30);
                card.setCardElevation(6);
                card.setCardBackgroundColor(Color.WHITE); // White card background

                // Card ke andar layout (Logo + Text)
                LinearLayout innerLayout = new LinearLayout(this);
                innerLayout.setOrientation(LinearLayout.VERTICAL);
                innerLayout.setGravity(Gravity.CENTER);
                innerLayout.setPadding(10, 10, 10, 10);

                // --- APNA LOGO ADD KARNA ---
                ImageView imgLogo = new ImageView(this);
                imgLogo.setImageResource(R.drawable.my_subject_logo); // <-- APNE LOGO KA NAAM LIKHO
                LinearLayout.LayoutParams imgParams = new LinearLayout.LayoutParams(
                        (int) (75 * getResources().getDisplayMetrics().density), // 55 se 75 kar diya
                        (int) (75 * getResources().getDisplayMetrics().density)); // 55 se 75 kar diya
                imgLogo.setLayoutParams(imgParams);
                innerLayout.addView(imgLogo);

                // --- SUBJECT NAME ---
                TextView tv = new TextView(this);
                tv.setText(subName);
                tv.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
                tv.setTextColor(Color.parseColor("#2E7D32")); // Greenish text
                tv.setTextSize(16); // 13 se 16 kar diya
                tv.setTypeface(null, Typeface.BOLD);
                tv.setPadding(0, 12, 0, 0);
                tv.setLineSpacing(0, 1.1f);
                innerLayout.addView(tv);


                card.addView(innerLayout);

                // Click to open next page
                card.setOnClickListener(v -> {
                    Intent intent = new Intent(SubjectActivity.this, SubjectHubActivity.class);
                    intent.putExtra("SUBJECT_NAME", subName);
                    startActivity(intent);
                });

                container.addView(card);
            }
        }
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