package com.example.polypath;

public class QuizQuestion {
    public String question, opt1, opt2, opt3, opt4;
    public int correctAns; // 1, 2, 3, ya 4

    public QuizQuestion(String question, String opt1, String opt2, String opt3, String opt4, int correctAns) {
        this.question = question;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.opt4 = opt4;
        this.correctAns = correctAns;
    }
}