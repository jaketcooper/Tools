package com.safonov.speedreading.training.fragment.math.training.presenter;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.safonov.speedreading.training.fragment.math.repository.IMathRepository;
import com.safonov.speedreading.training.fragment.math.repository.entity.MathConfig;
import com.safonov.speedreading.training.fragment.math.repository.entity.MathResult;
import com.safonov.speedreading.training.fragment.math.training.model.Expression;
import com.safonov.speedreading.training.fragment.math.training.model.MathModel;
import com.safonov.speedreading.training.fragment.math.training.view.IMathView;

public class MathPresenter extends MvpBasePresenter<IMathView> implements IMathPresenter {
    public static final int INCORRECT_MAX_COUNT = 3;
    private MathResult bestResult;
    /* access modifiers changed from: private */
    public int complexity;
    private MathConfig config;
    private int configId;
    /* access modifiers changed from: private */
    public int currentCorrectAnswer;
    /* access modifiers changed from: private */
    public int currentExpressionId;
    /* access modifiers changed from: private */
    public float currentScoreBuff;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    /* access modifiers changed from: private */
    public int incorrectCount;
    /* access modifiers changed from: private */
    public MathModel model;
    /* access modifiers changed from: private */
    public Runnable postShowCorrectAnswer = new Runnable() {
        public void run() {
            ((IMathView) MathPresenter.this.getView()).refreshExpressionTextView();
            ((IMathView) MathPresenter.this.getView()).timerStart();
            ((IMathView) MathPresenter.this.getView()).setButtonsEnabled(true);
            MathPresenter.this.handler.postDelayed(MathPresenter.this.showExpressionRunnable, 20);
        }
    };
    /* access modifiers changed from: private */
    public Runnable postShowIncorrectAnswer = new Runnable() {
        public void run() {
            ((IMathView) MathPresenter.this.getView()).refreshExpressionTextView();
            ((IMathView) MathPresenter.this.getView()).timerStart();
            ((IMathView) MathPresenter.this.getView()).setButtonsEnabled(true);
            ((IMathView) MathPresenter.this.getView()).setCorrectAnswerGone();
            if (MathPresenter.this.incorrectCount >= 3) {
                MathPresenter.this.compleateTraining();
            } else {
                MathPresenter.this.handler.postDelayed(MathPresenter.this.showExpressionRunnable, 20);
            }
        }
    };
    private IMathRepository repository;
    private MathResult result;
    /* access modifiers changed from: private */
    public float score;
    private Runnable showCorrectAnswer = new Runnable() {
        public void run() {
            ((IMathView) MathPresenter.this.getView()).setCorrectAnswer();
            ((IMathView) MathPresenter.this.getView()).setButtonsEnabled(false);
            ((IMathView) MathPresenter.this.getView()).setPointsTextViewCorrect(MathPresenter.this.currentScoreBuff);
            MathPresenter.this.handler.postDelayed(MathPresenter.this.postShowCorrectAnswer, 500);
        }
    };
    /* access modifiers changed from: private */
    public int showCount;
    /* access modifiers changed from: private */
    public Runnable showExpressionRunnable = new Runnable() {
        public void run() {
            if (MathPresenter.this.showCount < 50) {
                MathPresenter.access$808(MathPresenter.this);
                Expression expression1 = MathPresenter.this.model.getExpression(MathPresenter.this.currentExpressionId, MathPresenter.this.complexity);
                int[] answers = MathPresenter.this.model.getAllAnswers(MathPresenter.this.currentExpressionId, MathPresenter.this.complexity);
                if (MathPresenter.this.isViewAttached()) {
                    ((IMathView) MathPresenter.this.getView()).setButtonsText(answers);
                    ((IMathView) MathPresenter.this.getView()).setExpressionText(expression1.getValue());
                    ((IMathView) MathPresenter.this.getView()).updateScoreView(Math.round(MathPresenter.this.score));
                    ((IMathView) MathPresenter.this.getView()).updateProgressBar(MathPresenter.this.showCount);
                    return;
                }
                return;
            }
            MathPresenter.this.compleateTraining();
        }
    };
    private Runnable showIncorrectAnswer = new Runnable() {
        public void run() {
            ((IMathView) MathPresenter.this.getView()).setIncorrectAnswer(MathPresenter.this.currentCorrectAnswer);
            ((IMathView) MathPresenter.this.getView()).setPointsTextViewIncorrect();
            ((IMathView) MathPresenter.this.getView()).setButtonsEnabled(false);
            MathPresenter.this.handler.postDelayed(MathPresenter.this.postShowIncorrectAnswer, 1000);
        }
    };

    static /* synthetic */ int access$808(MathPresenter x0) {
        int i = x0.currentExpressionId;
        x0.currentExpressionId = i + 1;
        return i;
    }

    public MathPresenter(@NonNull IMathRepository repository2) {
        this.repository = repository2;
    }

    public void startTraining(int configId2) {
        this.configId = configId2;
        this.config = this.repository.getConfig(configId2);
        this.bestResult = this.repository.getBestResult(configId2);
        this.complexity = this.config.getComplexity();
        this.incorrectCount = 0;
        this.model = MathModel.getInstance();
        this.model.shuffleExpressions();
        Expression expression = this.model.getExpression(this.currentExpressionId, this.complexity);
        int[] answers = this.model.getAllAnswers(this.currentExpressionId, this.complexity);
        ((IMathView) getView()).updateScoreView(0);
        ((IMathView) getView()).updateBestScoreView(this.bestResult == null ? 0 : this.bestResult.getScore());
        ((IMathView) getView()).setButtonsText(answers);
        ((IMathView) getView()).setExpressionText(expression.getValue());
        ((IMathView) getView()).initProgressBar(50);
        ((IMathView) getView()).updateProgressBar(0);
        ((IMathView) getView()).initCountDownTimer(this.config.getDuration());
    }

    public void compleateTraining() {
        this.handler.removeCallbacks(this.showCorrectAnswer);
        this.handler.removeCallbacks(this.postShowCorrectAnswer);
        this.handler.removeCallbacks(this.showIncorrectAnswer);
        this.handler.removeCallbacks(this.postShowIncorrectAnswer);
        this.handler.removeCallbacks(this.showExpressionRunnable);
        this.handler = null;
        MathResult result2 = new MathResult();
        result2.setScore(Math.round(this.score));
        this.repository.addResult(result2, this.configId, new IMathRepository.OnSingleTransactionCallback() {
            public void onTransactionCompleted(int id) {
                if (MathPresenter.this.isViewAttached()) {
                    ((IMathView) MathPresenter.this.getView()).onMathTrainingCompleted(id);
                }
            }
        });
    }

    public void onNumberButtonPressed(int value) {
        Expression expression = MathModel.getInstance().getExpression(this.currentExpressionId, this.complexity);
        this.showCount++;
        if (expression.getCorrectAnswer() == value) {
            this.currentScoreBuff = (float) (0.5d + ((double) (((float) this.complexity) / 2.0f)) + ((double) (3000.0f / ((float) this.config.getDuration()))));
            this.score += this.currentScoreBuff;
            ((IMathView) getView()).timerPause();
            this.handler.postDelayed(this.showCorrectAnswer, 10);
        } else {
            this.incorrectCount++;
            this.score -= 1.0f;
            this.currentCorrectAnswer = expression.getCorrectAnswer();
            ((IMathView) getView()).timerPause();
            this.handler.postDelayed(this.showIncorrectAnswer, 10);
        }
        if (this.score < 0.0f) {
            this.score = 0.0f;
        }
    }

    public void shuffleArray() {
        this.model.shuffleExpressions();
        this.handler.postDelayed(this.showExpressionRunnable, 20);
    }

    public void pauseGame() {
        ((IMathView) getView()).refreshExpressionTextView();
        ((IMathView) getView()).setCorrectAnswerGone();
        this.handler.removeCallbacks(this.showCorrectAnswer);
        this.handler.removeCallbacks(this.postShowCorrectAnswer);
        this.handler.removeCallbacks(this.showIncorrectAnswer);
        this.handler.removeCallbacks(this.postShowIncorrectAnswer);
        this.handler.removeCallbacks(this.showExpressionRunnable);
    }
}
