package com.safonov.speedreading.training.fragment.math.training.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.mozilla.universalchardet.prober.HebrewProber;
import org.mozilla.universalchardet.prober.contextanalysis.EUCJPContextAnalysis;
import org.mozilla.universalchardet.prober.contextanalysis.SJISContextAnalysis;

public class MathModel implements IMathModel {
    public static final int EXPRESSIONS_COUNT = 50;
    private static MathModel instance;
    private List<Expression> expressionsFirstComplexity;
    private List<Expression> expressionsFourthComplexity;
    private List<Expression> expressionsSecondComplexity;
    private List<Expression> expressionsThirdComplexity;

    private MathModel() {
        initExpressions();
    }

    public static MathModel getInstance() {
        if (instance == null) {
            synchronized (MathModel.class) {
                if (instance == null) {
                    instance = new MathModel();
                }
            }
        }
        return instance;
    }

    public Expression getExpression(int id, int complexity) {
        switch (complexity) {
            case 1:
                return this.expressionsFirstComplexity.get(id);
            case 2:
                return this.expressionsSecondComplexity.get(id);
            case 3:
                return this.expressionsThirdComplexity.get(id);
            case 4:
                return this.expressionsFourthComplexity.get(id);
            default:
                return null;
        }
    }

    public int[] getAllAnswers(int id, int complexity) {
        Expression expression = getExpression(id, complexity);
        int correctAnswer = expression.getCorrectAnswer();
        int[] incorrectAnswers = expression.getIncorrectAnswers();
        int[] result = new int[4];
        for (int i = 0; i < incorrectAnswers.length; i++) {
            result[i] = incorrectAnswers[i];
        }
        result[3] = correctAnswer;
        shuffleArray(result);
        return result;
    }

    public void shuffleExpressions() {
        Collections.shuffle(this.expressionsFirstComplexity);
        Collections.shuffle(this.expressionsSecondComplexity);
        Collections.shuffle(this.expressionsThirdComplexity);
        Collections.shuffle(this.expressionsFourthComplexity);
    }

    private void shuffleArray(int[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    private void initExpressions() {
        this.expressionsFirstComplexity = new ArrayList();
        this.expressionsFirstComplexity.add(new Expression("2 + ? = 5", 3, new int[]{2, 4, 1}));
        this.expressionsFirstComplexity.add(new Expression("5 + 9 = ?", 14, new int[]{13, 11, 16}));
        this.expressionsFirstComplexity.add(new Expression("18 - 7 = ?", 11, new int[]{13, 12, 10}));
        this.expressionsFirstComplexity.add(new Expression("5 * ? = 45", 9, new int[]{7, 10, 8}));
        this.expressionsFirstComplexity.add(new Expression("? / 4 = 2", 8, new int[]{6, 10, 12}));
        this.expressionsFirstComplexity.add(new Expression("7 + 2 = ?", 9, new int[]{10, 8, 11}));
        this.expressionsFirstComplexity.add(new Expression("6 / 3 = ?", 2, new int[]{3, 4, 6}));
        this.expressionsFirstComplexity.add(new Expression("4 * ? = 12", 3, new int[]{4, 6, 2}));
        this.expressionsFirstComplexity.add(new Expression("7 - ? = 4", 3, new int[]{4, 2, 5}));
        this.expressionsFirstComplexity.add(new Expression("5 + 8 = ?", 13, new int[]{12, 11, 14}));
        this.expressionsFirstComplexity.add(new Expression("9 - ? = 5", 4, new int[]{3, 5, 6}));
        this.expressionsFirstComplexity.add(new Expression("5 * ? = 20", 4, new int[]{3, 6, 5}));
        this.expressionsFirstComplexity.add(new Expression("9 / ? = 3", 3, new int[]{2, 4, 6}));
        this.expressionsFirstComplexity.add(new Expression("4 + ? = 7", 3, new int[]{4, 2, 5}));
        this.expressionsFirstComplexity.add(new Expression("? * 2 = 8", 4, new int[]{6, 2, 3}));
        this.expressionsFirstComplexity.add(new Expression("4 / ? = 4", 1, new int[]{4, 2, 6}));
        this.expressionsFirstComplexity.add(new Expression("6 * ? = 24", 4, new int[]{6, 3, 5}));
        this.expressionsFirstComplexity.add(new Expression("12 - ? = 7", 5, new int[]{6, 4, 7}));
        this.expressionsFirstComplexity.add(new Expression("15 / 5 = ?", 3, new int[]{4, 2, 5}));
        this.expressionsFirstComplexity.add(new Expression("7 * ? = 49", 7, new int[]{6, 8, 5}));
        this.expressionsFirstComplexity.add(new Expression("9 - ? = 3", 6, new int[]{5, 7, 4}));
        this.expressionsFirstComplexity.add(new Expression("? * 3 = 9", 3, new int[]{4, 6, 5}));
        this.expressionsFirstComplexity.add(new Expression("7 + ? = 16", 9, new int[]{7, 8, 6}));
        this.expressionsFirstComplexity.add(new Expression("8 + 4 = ?", 12, new int[]{16, 18, 14}));
        this.expressionsFirstComplexity.add(new Expression("18 - ? = 9", 9, new int[]{7, 8, 10}));
        this.expressionsFirstComplexity.add(new Expression("4 * ? = 8", 2, new int[]{3, 5, 4}));
        this.expressionsFirstComplexity.add(new Expression("3 * 2 = ?", 6, new int[]{8, 9, 12}));
        this.expressionsFirstComplexity.add(new Expression("12 + 5 = ?", 17, new int[]{16, 18, 15}));
        this.expressionsFirstComplexity.add(new Expression("5 * ? = 25", 5, new int[]{6, 4, 3}));
        this.expressionsFirstComplexity.add(new Expression("6 * ? = 24", 4, new int[]{3, 7, 6}));
        this.expressionsFirstComplexity.add(new Expression("? + 4 = 13", 9, new int[]{7, 8, 10}));
        this.expressionsFirstComplexity.add(new Expression("8 * ? = 32", 4, new int[]{6, 3, 7}));
        this.expressionsFirstComplexity.add(new Expression("17 - 8 = ?", 9, new int[]{7, 8, 6}));
        this.expressionsFirstComplexity.add(new Expression("7 * ? = 42", 6, new int[]{7, 8, 5}));
        this.expressionsFirstComplexity.add(new Expression("4 * 8 = ?", 32, new int[]{40, 24, 16}));
        this.expressionsFirstComplexity.add(new Expression("? - 7 = 9", 16, new int[]{15, 26, 17}));
        this.expressionsFirstComplexity.add(new Expression("2 * 7 = ?", 14, new int[]{21, 28, 35}));
        this.expressionsFirstComplexity.add(new Expression("15 - ? = 6", 9, new int[]{7, 8, 10}));
        this.expressionsFirstComplexity.add(new Expression("9 * ? = 36", 4, new int[]{3, 6, 5}));
        this.expressionsFirstComplexity.add(new Expression("8 * ? = 16", 2, new int[]{3, 5, 4}));
        this.expressionsFirstComplexity.add(new Expression("4 * ? = 24", 6, new int[]{7, 8, 4}));
        this.expressionsFirstComplexity.add(new Expression("16 / ? = 8", 2, new int[]{3, 6, 4}));
        this.expressionsFirstComplexity.add(new Expression("18 / ? = 9", 2, new int[]{4, 9, 3}));
        this.expressionsFirstComplexity.add(new Expression("36 / ? = 9", 4, new int[]{3, 6, 5}));
        this.expressionsFirstComplexity.add(new Expression("48 / ? = 8", 6, new int[]{7, 8, 4}));
        this.expressionsFirstComplexity.add(new Expression("56 / ? = 7", 8, new int[]{7, 6, 9}));
        this.expressionsFirstComplexity.add(new Expression("14 - 8 = ?", 6, new int[]{7, 8, 4}));
        this.expressionsFirstComplexity.add(new Expression("20 / ? = 4", 5, new int[]{6, 3, 4}));
        this.expressionsFirstComplexity.add(new Expression("16 / ? = 4", 4, new int[]{3, 5, 6}));
        this.expressionsFirstComplexity.add(new Expression("2 - ? = 0", 2, new int[]{4, 3, 12}));
        this.expressionsFirstComplexity.add(new Expression("? - 1 = 8", 9, new int[]{8, 6, 10}));
        this.expressionsFirstComplexity.add(new Expression("7 + 3 = ?", 10, new int[]{9, 11, 12}));
        this.expressionsFirstComplexity.add(new Expression("8 + ? = 10", 2, new int[]{3, 4, 1}));
        this.expressionsFirstComplexity.add(new Expression("4 - ? = 2", 2, new int[]{4, 3, 1}));
        this.expressionsFirstComplexity.add(new Expression("9 + 3 = ?", 12, new int[]{14, 10, 16}));
        this.expressionsFirstComplexity.add(new Expression("? + 2 = 12", 10, new int[]{14, 12, 9}));
        this.expressionsFirstComplexity.add(new Expression("8 - 3 = ?", 5, new int[]{4, 8, 6}));
        this.expressionsFirstComplexity.add(new Expression("? + 1 = 11", 10, new int[]{9, 11, 12}));
        this.expressionsFirstComplexity.add(new Expression("4 - 1 = ?", 3, new int[]{4, 2, 5}));
        this.expressionsFirstComplexity.add(new Expression("8 * 7 = ?", 56, new int[]{54, 48, 46}));
        this.expressionsFirstComplexity.add(new Expression("2 * 3 = ?", 6, new int[]{8, 7, 12}));
        this.expressionsFirstComplexity.add(new Expression("5 * 8 = ?", 40, new int[]{35, 30, 45}));
        this.expressionsFirstComplexity.add(new Expression("30 / 5 = ?", 6, new int[]{4, 8, 5}));
        this.expressionsFirstComplexity.add(new Expression("8 * 6 = ?", 48, new int[]{54, 42, 58}));
        this.expressionsFirstComplexity.add(new Expression("7 * 6 = ?", 42, new int[]{49, 48, 52}));
        this.expressionsFirstComplexity.add(new Expression("21 / 7 = ?", 3, new int[]{4, 2, 7}));
        this.expressionsFirstComplexity.add(new Expression("4 * 2 = ?", 8, new int[]{4, 12, 6}));
        this.expressionsFirstComplexity.add(new Expression("4 * 7 = ?", 28, new int[]{24, 21, 34}));
        this.expressionsFirstComplexity.add(new Expression("15 / 3 = ?", 5, new int[]{7, 3, 15}));
        this.expressionsFirstComplexity.add(new Expression("48 / 6 = ?", 8, new int[]{6, 12, 2}));
        this.expressionsFirstComplexity.add(new Expression("24 / 4 = ?", 6, new int[]{7, 8, 4}));
        this.expressionsFirstComplexity.add(new Expression("28 / 4 = ?", 7, new int[]{8, 6, 4}));
        this.expressionsFirstComplexity.add(new Expression("32 / 8 = ?", 4, new int[]{6, 3, 2}));
        this.expressionsFirstComplexity.add(new Expression("5 * 7 = ?", 35, new int[]{45, 40, 30}));
        this.expressionsFirstComplexity.add(new Expression("21 / 3 = ?", 7, new int[]{8, 6, 4}));
        this.expressionsFirstComplexity.add(new Expression("72 / 9 = ?", 8, new int[]{6, 12, 4}));
        this.expressionsFirstComplexity.add(new Expression("20 / 5 = ?", 4, new int[]{3, 5, 6}));
        this.expressionsFirstComplexity.add(new Expression("45 / 9 = ?", 5, new int[]{15, 7, 25}));
        this.expressionsFirstComplexity.add(new Expression("42 / 7 = ?", 6, new int[]{8, 7, 4}));
        this.expressionsFirstComplexity.add(new Expression("28 / 7 = ?", 4, new int[]{6, 8, 7}));
        this.expressionsSecondComplexity = new ArrayList();
        this.expressionsSecondComplexity.add(new Expression("12 + ? = 25", 13, new int[]{14, 23, 24}));
        this.expressionsSecondComplexity.add(new Expression("19 - 10 = ?", 9, new int[]{8, 19, 7}));
        this.expressionsSecondComplexity.add(new Expression("32 + 7 = ?", 39, new int[]{37, 47, 49}));
        this.expressionsSecondComplexity.add(new Expression("12 * ? = 36", 3, new int[]{2, 4, 5}));
        this.expressionsSecondComplexity.add(new Expression("? + 12 = 24", 12, new int[]{11, 13, 14}));
        this.expressionsSecondComplexity.add(new Expression("48 / ? = 12", 4, new int[]{6, 3, 7}));
        this.expressionsSecondComplexity.add(new Expression("14 + 19 = ?", 33, new int[]{32, 34, 43}));
        this.expressionsSecondComplexity.add(new Expression("93 - 47 = ?", 46, new int[]{56, 47, 57}));
        this.expressionsSecondComplexity.add(new Expression("23 + 64 = ?", 87, new int[]{97, 88, 98}));
        this.expressionsSecondComplexity.add(new Expression("? + 72 = 94", 22, new int[]{12, 24, 14}));
        this.expressionsSecondComplexity.add(new Expression("72 / ? = 9", 8, new int[]{6, 7, 9}));
        this.expressionsSecondComplexity.add(new Expression("26 + ? = 74", 48, new int[]{47, 58, 46}));
        this.expressionsSecondComplexity.add(new Expression("68 / ? = 34", 2, new int[]{3, 4, 6}));
        this.expressionsSecondComplexity.add(new Expression("? / 6 = 11", 66, new int[]{76, 17, 65}));
        this.expressionsSecondComplexity.add(new Expression("95 - 19 = ?", 76, new int[]{66, 75, 86}));
        this.expressionsSecondComplexity.add(new Expression("75 / ? = 15", 5, new int[]{15, 10, 7}));
        this.expressionsSecondComplexity.add(new Expression("56 + ? = 74", 18, new int[]{17, 16, 15}));
        this.expressionsSecondComplexity.add(new Expression("? / 2 = 32", 64, new int[]{54, 68, 124}));
        this.expressionsSecondComplexity.add(new Expression("? + 92 = 97", 5, new int[]{12, 15, 125}));
        this.expressionsSecondComplexity.add(new Expression("88 / ? = 2", 44, new int[]{88, 34, 54}));
        this.expressionsSecondComplexity.add(new Expression("18 * ? = 54", 3, new int[]{5, 6, 4}));
        this.expressionsSecondComplexity.add(new Expression("56 + 28 = ?", 84, new int[]{74, 76, 83}));
        this.expressionsSecondComplexity.add(new Expression("84 - ? = 55", 29, new int[]{18, 19, 39}));
        this.expressionsSecondComplexity.add(new Expression("24 + 49 = ?", 73, new int[]{63, 76, 66}));
        this.expressionsSecondComplexity.add(new Expression("69 / ? = 23", 3, new int[]{13, 6, 4}));
        this.expressionsSecondComplexity.add(new Expression("19 * 4 = ?", 76, new int[]{66, 78, 68}));
        this.expressionsSecondComplexity.add(new Expression("28 * 3 = ?", 84, new int[]{86, 88, 76}));
        this.expressionsSecondComplexity.add(new Expression("33 * 3 = ?", 99, new int[]{11, 96, 89}));
        this.expressionsSecondComplexity.add(new Expression("76 - 24 = ?", 52, new int[]{42, 62, 63}));
        this.expressionsSecondComplexity.add(new Expression("89 - 56 = ?", 33, new int[]{23, 13, 26}));
        this.expressionsSecondComplexity.add(new Expression("27 * 3 = ?", 81, new int[]{71, 61, 91}));
        this.expressionsSecondComplexity.add(new Expression("75 - 38 = ?", 37, new int[]{27, 47, 28}));
        this.expressionsSecondComplexity.add(new Expression("47 + 39 = ?", 86, new int[]{76, 88, 78}));
        this.expressionsSecondComplexity.add(new Expression("25 * 3 = ?", 75, new int[]{85, 70, 65}));
        this.expressionsSecondComplexity.add(new Expression("43 + 28 = ?", 71, new int[]{81, 72, 82}));
        this.expressionsSecondComplexity.add(new Expression("16 * 6 = ?", 96, new int[]{86, 97, 136}));
        this.expressionsSecondComplexity.add(new Expression("84 / ? = 28", 3, new int[]{4, 6, 2}));
        this.expressionsSecondComplexity.add(new Expression("99 / ? = 3", 33, new int[]{34, 36, 23}));
        this.expressionsSecondComplexity.add(new Expression("24 + ? = 76", 52, new int[]{54, 42, 88}));
        this.expressionsSecondComplexity.add(new Expression("33 + ? = 89", 56, new int[]{57, 66, 46}));
        this.expressionsSecondComplexity.add(new Expression("81 / ? = 27", 3, new int[]{6, 7, 4}));
        this.expressionsSecondComplexity.add(new Expression("37 + ? = 75", 38, new int[]{48, 36, 44}));
        this.expressionsSecondComplexity.add(new Expression("86 - ? = 39", 47, new int[]{37, 57, 67}));
        this.expressionsSecondComplexity.add(new Expression("75 / ? = 3", 25, new int[]{35, 20, 30}));
        this.expressionsSecondComplexity.add(new Expression("71 - 43 = ?", 28, new int[]{18, 38, 34}));
        this.expressionsSecondComplexity.add(new Expression("96 / ? = 6", 16, new int[]{18, 26, 24}));
        this.expressionsSecondComplexity.add(new Expression("33 - ? = 19", 14, new int[]{24, 26, 16}));
        this.expressionsSecondComplexity.add(new Expression("72 / ? = 8", 9, new int[]{8, 7, 6}));
        this.expressionsSecondComplexity.add(new Expression("76 / 19 = ?", 4, new int[]{6, 8, 3}));
        this.expressionsSecondComplexity.add(new Expression("73 - 49 = ?", 24, new int[]{34, 14, 16}));
        this.expressionsSecondComplexity.add(new Expression("50 + 20 = ?", 70, new int[]{60, 80, 90}));
        this.expressionsSecondComplexity.add(new Expression("68 + ? = 97", 29, new int[]{27, 39, 37}));
        this.expressionsSecondComplexity.add(new Expression("? - 17 = 36", 53, new int[]{63, 64, 57}));
        this.expressionsSecondComplexity.add(new Expression("25 + 27 = ?", 52, new int[]{62, 61, 51}));
        this.expressionsSecondComplexity.add(new Expression("37 + 36 = ?", 73, new int[]{63, 67, 1}));
        this.expressionsSecondComplexity.add(new Expression("? - 32 = 32", 64, new int[]{54, 74, 86}));
        this.expressionsSecondComplexity.add(new Expression("45 + 40 = ?", 85, new int[]{95, 75, 5}));
        this.expressionsSecondComplexity.add(new Expression("48 - 45 = ?", 3, new int[]{93, 4, 13}));
        this.expressionsSecondComplexity.add(new Expression("14 + ? = 43", 29, new int[]{19, 39, 24}));
        this.expressionsSecondComplexity.add(new Expression("? - 78 = 14", 92, new int[]{98, 82, 88}));
        this.expressionsFourthComplexity = new ArrayList();
        this.expressionsFourthComplexity.add(new Expression("102 + ? = 245", EUCJPContextAnalysis.SINGLE_SHIFT_3, new int[]{153, 133, 123}));
        this.expressionsFourthComplexity.add(new Expression("189 - 90 = ?", 99, new int[]{89, 109, 79}));
        this.expressionsFourthComplexity.add(new Expression("321 + 48 = ?", 369, new int[]{379, 389, 365}));
        this.expressionsFourthComplexity.add(new Expression("12 * ? = 144", 12, new int[]{11, 13, 14}));
        this.expressionsFourthComplexity.add(new Expression("31 * ? = 186", 6, new int[]{8, 12, 4}));
        this.expressionsFourthComplexity.add(new Expression("963 - 624 = ?", 339, new int[]{329, 327, 337}));
        this.expressionsFourthComplexity.add(new Expression("436 / 4 = ?", 109, new int[]{119, 107, 117}));
        this.expressionsFourthComplexity.add(new Expression("264 + ? = 580", 316, new int[]{326, 317, 318}));
        this.expressionsFourthComplexity.add(new Expression("? - 328 = 301", 629, new int[]{639, 627, 529}));
        this.expressionsFourthComplexity.add(new Expression("54 * ? = 486", 9, new int[]{8, 7, 6}));
        this.expressionsFourthComplexity.add(new Expression("668 - ? = 455", 213, new int[]{223, 233, 243}));
        this.expressionsFourthComplexity.add(new Expression("? * 14 = 322", 23, new int[]{24, 43, 33}));
        this.expressionsFourthComplexity.add(new Expression("368 - 234 = ?", 134, new int[]{144, 154, 136}));
        this.expressionsFourthComplexity.add(new Expression("24 * 13 = ?", 312, new int[]{322, 314, 324}));
        this.expressionsFourthComplexity.add(new Expression("? - 368 = 121", 489, new int[]{499, 479, 487}));
        this.expressionsFourthComplexity.add(new Expression("794 - 236 = ?", 558, new int[]{538, 488, 398}));
        this.expressionsFourthComplexity.add(new Expression("36 * 9 = ?", 324, new int[]{314, 294, 424}));
        this.expressionsFourthComplexity.add(new Expression("235 - ? = 79", 156, new int[]{136, 146, 166}));
        this.expressionsFourthComplexity.add(new Expression("? * 6 = 288", 48, new int[]{26, 58, 28}));
        this.expressionsFourthComplexity.add(new Expression("245 - ? = 102", EUCJPContextAnalysis.SINGLE_SHIFT_3, new int[]{103, 93, 153}));
        this.expressionsFourthComplexity.add(new Expression("99 + ? = 189", 90, new int[]{80, 92, 82}));
        this.expressionsFourthComplexity.add(new Expression("369 - 321 = ?", 48, new int[]{58, 47, 46}));
        this.expressionsFourthComplexity.add(new Expression("144 / 12 = ?", 12, new int[]{14, 11, 13}));
        this.expressionsFourthComplexity.add(new Expression("186 / 31 = ?", 6, new int[]{8, 12, 4}));
        this.expressionsFourthComplexity.add(new Expression("624 + 339 = ?", 963, new int[]{933, 893, 973}));
        this.expressionsFourthComplexity.add(new Expression("109 * ? = 436", 4, new int[]{6, 7, 3}));
        this.expressionsFourthComplexity.add(new Expression("? - 316 = 264", 580, new int[]{680, 590, 570}));
        this.expressionsFourthComplexity.add(new Expression("? + 328 = 629", 301, new int[]{291, 201, 391}));
        this.expressionsFourthComplexity.add(new Expression("486 / 54 = ?", 9, new int[]{7, 8, 6}));
        this.expressionsFourthComplexity.add(new Expression("213 + 455 = ?", 668, new int[]{638, 468, 578}));
        this.expressionsFourthComplexity.add(new Expression("322 / 14 = ?", 23, new int[]{24, 19, 33}));
        this.expressionsFourthComplexity.add(new Expression("? + 234 = 368", 134, new int[]{94, 194, 154}));
        this.expressionsFourthComplexity.add(new Expression("312 / 13 = ?", 24, new int[]{28, 26, 14}));
        this.expressionsFourthComplexity.add(new Expression("121 + ? = 489", 368, new int[]{328, 298, 388}));
        this.expressionsFourthComplexity.add(new Expression("558 + ? = 794", 236, new int[]{216, 177, HebrewProber.NORMAL_TSADI}));
        this.expressionsFourthComplexity.add(new Expression("324 / ? = 9", 36, new int[]{26, 34, 28}));
        this.expressionsFourthComplexity.add(new Expression("? + 156 = 235", 79, new int[]{69, 129, 67}));
        this.expressionsFourthComplexity.add(new Expression("288 / 6 = ?", 48, new int[]{58, 46, 53}));
        this.expressionsFourthComplexity.add(new Expression("395 + ? = 862", 467, new int[]{407, 397, 447}));
        this.expressionsFourthComplexity.add(new Expression("862 - 395 = ?", 467, new int[]{407, 397, 447}));
        this.expressionsFourthComplexity.add(new Expression("389 + 536 = ?", 925, new int[]{935, 906, 896}));
        this.expressionsFourthComplexity.add(new Expression("? - 294 = 449", 743, new int[]{723, 813, 794}));
        this.expressionsFourthComplexity.add(new Expression("15 * ? = 180", 12, new int[]{16, 22, 14}));
        this.expressionsFourthComplexity.add(new Expression("472 - 247 = ?", 225, new int[]{205, 115, HebrewProber.FINAL_TSADI}));
        this.expressionsFourthComplexity.add(new Expression("257 + ? = 885", 628, new int[]{588, 618, 598}));
        this.expressionsFourthComplexity.add(new Expression("? * 24 = 624", 26, new int[]{28, 24, 36}));
        this.expressionsFourthComplexity.add(new Expression("745 - 625 = ?", 120, new int[]{SJISContextAnalysis.HIRAGANA_HIGHBYTE, 140, 104}));
        this.expressionsFourthComplexity.add(new Expression("426 + ? = 973", 547, new int[]{537, 437, 596}));
        this.expressionsFourthComplexity.add(new Expression("32 * ? = 512", 16, new int[]{18, 28, 26}));
        this.expressionsFourthComplexity.add(new Expression("? - 367 = 52", 419, new int[]{529, 409, 428}));
        this.expressionsFourthComplexity.add(new Expression("862 - 137 = ?", 725, new int[]{635, 755, 525}));
        this.expressionsFourthComplexity.add(new Expression("? - 103 = 690", 793, new int[]{743, 693, 643}));
        this.expressionsFourthComplexity.add(new Expression("560 + 200 = ?", 760, new int[]{860, 660, 960}));
        this.expressionsFourthComplexity.add(new Expression("728 - ? = 592", 136, new int[]{176, HebrewProber.NORMAL_TSADI, 326}));
        this.expressionsFourthComplexity.add(new Expression("? + 435 = 563", 128, new int[]{148, HebrewProber.NORMAL_MEM, 108}));
        this.expressionsFourthComplexity.add(new Expression("805 - 194 = ?", 611, new int[]{711, 621, 811}));
        this.expressionsFourthComplexity.add(new Expression("? - 137 = 419", 556, new int[]{536, 476, 516}));
        this.expressionsFourthComplexity.add(new Expression("866 - 104 = ?", 762, new int[]{712, 852, 692}));
        this.expressionsFourthComplexity.add(new Expression("405 + 200 = ?", 605, new int[]{615, 505, 205}));
        this.expressionsFourthComplexity.add(new Expression("473 + ? = 954", 481, new int[]{391, 491, 521}));
        this.expressionsThirdComplexity = new ArrayList();
        this.expressionsThirdComplexity.addAll(this.expressionsFirstComplexity);
        this.expressionsThirdComplexity.addAll(this.expressionsSecondComplexity);
        this.expressionsThirdComplexity.addAll(this.expressionsFourthComplexity);
    }
}
