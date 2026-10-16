package com.example.polypath;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FeatureMenuActivity extends AppCompatActivity {

    TextView tvWelcomeName, tvExamTimer;
    Handler timerHandler = new Handler();
    Runnable timerRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature_menu);

        // 1. Views Connection
        tvWelcomeName = findViewById(R.id.tvWelcomeName);
        tvExamTimer = findViewById(R.id.tvExamTimer);

        // Simple Welcome Text (No Database Logic)
        tvWelcomeName.setText("Hello Students!");

        // 2. Timer Start
        startExamCountdown();

        // 3. All Cards Click Listeners

        // STUDY MATERIAL
        CardView cardStudy = findViewById(R.id.cardStudyMaterial);
        cardStudy.setOnClickListener(v -> {
            startActivity(new Intent(FeatureMenuActivity.this, DashboardActivity.class));
        });

        // SCHOLARSHIP
        CardView cardScholar = findViewById(R.id.cardScholarship);
        cardScholar.setOnClickListener(v -> {
            startActivity(new Intent(FeatureMenuActivity.this, ScholarshipActivity.class));
        });

        // ACADEMIC CALENDAR
        CardView cardCal = findViewById(R.id.cardCalendar);
        cardCal.setOnClickListener(v -> {
            startActivity(new Intent(FeatureMenuActivity.this, AcademicCalendarActivity.class));
        });

        // EXAM FORM
        CardView cardExam = findViewById(R.id.cardExam);
        cardExam.setOnClickListener(v -> {
            startActivity(new Intent(FeatureMenuActivity.this, ExamFormActivity.class));
        });

        // ANNOUNCEMENTS (Check your XML ID: btnAnnouncements)
        CardView cardAnnounce = findViewById(R.id.btnAnnouncements);
        cardAnnounce.setOnClickListener(v -> {
            startActivity(new Intent(FeatureMenuActivity.this, AnnouncementsActivity.class));
        });

        // SCIENCE QUIZ (Check your XML ID: btnQuiz)
        CardView cardQuiz = findViewById(R.id.btnQuiz);
        cardQuiz.setOnClickListener(v -> {
            startActivity(new Intent(FeatureMenuActivity.this, QuizLevelsActivity.class));
        });

        // FEEDBACK (Bottom Strip)
        CardView cardFeed = findViewById(R.id.btnFeedback);
        cardFeed.setOnClickListener(v -> {
            startActivity(new Intent(FeatureMenuActivity.this, FeedbackActivity.class));
        });

        // CHATBOT (Floating ImageView)
        ImageView imgChat = findViewById(R.id.btnChatbot);
        imgChat.setOnClickListener(v -> {
            startActivity(new Intent(FeatureMenuActivity.this, ChatbotActivity.class));
        });
    }

    // --- Countdown Logic ---
    private void startExamCountdown() {
        timerRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                    Date examDate = dateFormat.parse("2026-04-24");
                    Date now = new Date();
                    long diff = examDate.getTime() - now.getTime();

                    if (diff > 0) {
                        long days = diff / (24 * 60 * 60 * 1000);
                        long hours = (diff / (60 * 60 * 1000)) % 24;
                        long minutes = (diff / (60 * 1000)) % 60;
                        long seconds = (diff / 1000) % 60;
                        tvExamTimer.setText(String.format(Locale.getDefault(), "%02dD : %02dH : %02dM : %02dS", days, hours, minutes, seconds));
                        timerHandler.postDelayed(this, 1000);
                    } else {
                        tvExamTimer.setText("Exam Started!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        timerHandler.postDelayed(timerRunnable, 0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timerHandler.removeCallbacks(timerRunnable);
    }
}