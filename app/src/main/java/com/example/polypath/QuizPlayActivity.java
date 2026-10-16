package com.example.polypath;

import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class QuizPlayActivity extends AppCompatActivity {

    TextView tvQuestion, tvCount;
    Button b1, b2, b3, b4, btnNext, btnPrev;
    List<QuizQuestion> questionList;
    int currentPos = 0, score = 0, levelNum;

    // User answers storage
    int[] userAnswers = new int[30];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_play);

        // UI Binding
        tvQuestion = findViewById(R.id.tv_question);
        tvCount = findViewById(R.id.tvQuestionCount);
        b1 = findViewById(R.id.btnOpt1);
        b2 = findViewById(R.id.btnOpt2);
        b3 = findViewById(R.id.btnOpt3);
        b4 = findViewById(R.id.btnOpt4);
        btnNext = findViewById(R.id.btn_next);
        btnPrev = findViewById(R.id.btn_prev);

        // Init answers with -1
        for (int i = 0; i < 30; i++) userAnswers[i] = -1;

        levelNum = getIntent().getIntExtra("L_NUM", 1);
        questionList = QuestionBank.getQuestions(levelNum);

        updateQuestion();

        // Option Clicks
        b1.setOnClickListener(v -> selectOption(1));
        b2.setOnClickListener(v -> selectOption(2));
        b3.setOnClickListener(v -> selectOption(3));
        b4.setOnClickListener(v -> selectOption(4));

        // Navigation
        btnNext.setOnClickListener(v -> {
            if (userAnswers[currentPos] == -1) {
                Toast.makeText(this, "Pehle ek option choose karo!", Toast.LENGTH_SHORT).show();
                return;
            }
            if (currentPos < questionList.size() - 1) {
                currentPos++;
                updateQuestion();
            } else {
                calculateScoreAndShowResult();
            }
        });

        btnPrev.setOnClickListener(v -> {
            if (currentPos > 0) {
                currentPos--;
                updateQuestion();
            }
        });
    }

    private void updateQuestion() {
        if (currentPos < questionList.size()) {
            QuizQuestion q = questionList.get(currentPos);
            tvCount.setText("Level " + levelNum + " | Question: " + (currentPos + 1) + "/" + questionList.size());
            tvQuestion.setText(q.question);
            b1.setText(q.opt1);
            b2.setText(q.opt2);
            b3.setText(q.opt3);
            b4.setText(q.opt4);

            resetButtonsUI();

            if (userAnswers[currentPos] != -1) {
                highlightButton(userAnswers[currentPos]);
            }
        }
    }

    private void selectOption(int opt) {
        userAnswers[currentPos] = opt;
        resetButtonsUI();
        highlightButton(opt);
    }

    private void resetButtonsUI() {
        // Default Blue Color
        int defaultColor = Color.parseColor("#2D305A");
        ColorStateList csl = ColorStateList.valueOf(defaultColor);

        b1.setBackgroundTintList(csl);
        b2.setBackgroundTintList(csl);
        b3.setBackgroundTintList(csl);
        b4.setBackgroundTintList(csl);
    }

    private void highlightButton(int opt) {
        // Orange Color for selection
        int selectedColor = Color.parseColor("#FF6F00");
        ColorStateList csl = ColorStateList.valueOf(selectedColor);

        if (opt == 1) b1.setBackgroundTintList(csl);
        else if (opt == 2) b2.setBackgroundTintList(csl);
        else if (opt == 3) b3.setBackgroundTintList(csl);
        else if (opt == 4) b4.setBackgroundTintList(csl);
    }

    private void calculateScoreAndShowResult() {
        score = 0;
        for (int i = 0; i < questionList.size(); i++) {
            if (userAnswers[i] == questionList.get(i).correctAns) score++;
        }

        boolean passed = (score >= 26);
        if (passed) {
            SharedPreferences prefs = getSharedPreferences("QuizProg", MODE_PRIVATE);
            prefs.edit().putBoolean("level" + (levelNum + 1), true).apply();
        }

        new AlertDialog.Builder(this)
                .setTitle(passed ? "Mubarak Ho! ✅" : "Wapas Koshish Karein! ❌")
                .setMessage("Level " + levelNum + " Complete\nYour Score: " + score + "/" + questionList.size())
                .setCancelable(false)
                .setPositiveButton("Main Menu", (d, w) -> finish())
                .show();
    }
}