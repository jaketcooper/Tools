package com.safonov.speedreading.training.fragment.math.training.model;

public interface IMathModel {
    int[] getAllAnswers(int i, int i2);

    Expression getExpression(int i, int i2);

    void shuffleExpressions();
}
