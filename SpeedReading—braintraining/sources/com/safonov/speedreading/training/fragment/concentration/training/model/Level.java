package com.safonov.speedreading.training.fragment.concentration.training.model;

public class Level {
    private int circleCount;
    private int circleCountTrue;
    private int circleRadius;
    private int circleSpeed;
    private int score;

    public int getScore() {
        return this.score;
    }

    public void setScore(int score2) {
        this.score = score2;
    }

    public Level(int circleCount2, int circleCountTrue2, int circleRadius2, int circleSpeed2) {
        this.circleCount = circleCount2;
        this.circleCountTrue = circleCountTrue2;
        this.circleRadius = circleRadius2;
        this.circleSpeed = circleSpeed2;
    }

    public int getCircleCount() {
        return this.circleCount;
    }

    public void setCircleCount(int circleCount2) {
        this.circleCount = circleCount2;
    }

    public int getCircleCountTrue() {
        return this.circleCountTrue;
    }

    public void setCircleCountTrue(int circleCountTrue2) {
        this.circleCountTrue = circleCountTrue2;
    }

    public int getCircleRadius() {
        return this.circleRadius;
    }

    public void setCircleRadius(int circleRadius2) {
        this.circleRadius = circleRadius2;
    }

    public int getCircleSpeed() {
        return this.circleSpeed;
    }

    public void setCircleSpeed(int circleSpeed2) {
        this.circleSpeed = circleSpeed2;
    }
}
