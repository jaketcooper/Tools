package com.safonov.speedreading.training.fragment.math.training.model;

public class Expression {
    private int correctAnswer;
    private int[] incorrectAnswers;
    private String value;

    public Expression(String value2, int correctAnswer2, int[] incorrectAnswers2) {
        this.value = value2;
        this.correctAnswer = correctAnswer2;
        this.incorrectAnswers = incorrectAnswers2;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value2) {
        this.value = value2;
    }

    public int getCorrectAnswer() {
        return this.correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer2) {
        this.correctAnswer = correctAnswer2;
    }

    public int[] getIncorrectAnswers() {
        return this.incorrectAnswers;
    }

    public void setIncorrectAnswers(int[] incorrectAnswers2) {
        this.incorrectAnswers = incorrectAnswers2;
    }
}
