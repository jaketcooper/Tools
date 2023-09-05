package com.safonov.speedreading.training.fragment.math.training.view;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.training.activity.view.IAnimatedFragment;
import com.safonov.speedreading.training.fragment.math.repository.MathRealmUtil;
import com.safonov.speedreading.training.fragment.math.training.presenter.IMathPresenter;
import com.safonov.speedreading.training.fragment.math.training.presenter.MathPresenter;
import com.speedreading.alexander.speedreading.R;
import java.util.List;
import java.util.Locale;

public class MathFragment extends MvpFragment<IMathView, IMathPresenter> implements IMathView, IAnimatedFragment {
    public static final int COUNT_DOWN_INTERVAL = 10;
    private static final String TRAINING_CONFIG_ID_PARAM = "config_id";
    @BindViews({2131296504, 2131296505, 2131296506, 2131296507})
    List<Button> buttons;
    private int configId;
    @BindView(2131296499)
    TextView correctAnswerTextView;
    private int expressionId;
    @BindView(2131296509)
    TextView expressionTextView;
    private CountDownTimer mCountDownTimer;
    @BindView(2131296500)
    TextView mathPointsTextView;
    private MathRealmUtil mathRealmUtil;
    @BindView(2131296510)
    ProgressBar progressBar;
    @BindView(2131296511)
    TextView recordTextView;
    @BindView(2131296512)
    TextView scoreTextView;
    @BindView(2131296514)
    ProgressBar timerBar;
    private MathTrainingCompleteListener trainingCompleteListener;
    private Unbinder unbinder;

    public IMathPresenter createPresenter() {
        this.mathRealmUtil = new MathRealmUtil(((App) getActivity().getApplication()).getMathRealm());
        return new MathPresenter(this.mathRealmUtil);
    }

    public static MathFragment newInstance(int configId2) {
        MathFragment fragment = new MathFragment();
        Bundle args = new Bundle();
        args.putInt(TRAINING_CONFIG_ID_PARAM, configId2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.configId = getArguments().getInt(TRAINING_CONFIG_ID_PARAM);
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.math_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    @OnClick({2131296504, 2131296505, 2131296506, 2131296507})
    public void onNumberButtonClick(Button button) {
        ((IMathPresenter) this.presenter).onNumberButtonPressed(Integer.parseInt(button.getText().toString()));
    }

    public void onDestroy() {
        super.onDestroy();
        this.mathRealmUtil.close();
        this.mathRealmUtil = null;
        this.presenter = null;
        if (this.mCountDownTimer != null) {
            this.mCountDownTimer.cancel();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
        this.unbinder = null;
        if (this.mCountDownTimer != null) {
            this.mCountDownTimer.cancel();
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MathTrainingCompleteListener) {
            this.trainingCompleteListener = (MathTrainingCompleteListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement GreenDotTrainingCompleteListener");
    }

    public void onDetach() {
        super.onDetach();
        this.trainingCompleteListener = null;
        if (this.mCountDownTimer != null) {
            this.mCountDownTimer.cancel();
        }
    }

    public void onMathTrainingCompleted(int trainingResultId) {
        this.trainingCompleteListener.onMathTrainingCompleted(trainingResultId);
    }

    public void updateScoreView(int score) {
        this.scoreTextView.setText(String.valueOf(score));
    }

    public void initProgressBar(int maxProgress) {
        this.progressBar.setMax(maxProgress);
    }

    public void updateProgressBar(int progress) {
        this.progressBar.setProgress(progress);
    }

    public void updateBestScoreView(int record) {
        this.recordTextView.setText(getString(R.string.remember_number_best_score, Integer.valueOf(record)));
    }

    public void setButtonsText(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            this.buttons.get(i).setText(String.valueOf(numbers[i]));
        }
    }

    public void setExpressionText(String text) {
        this.expressionTextView.setText(text);
    }

    public void initCountDownTimer(long seconds) {
        this.timerBar.setMax((int) seconds);
        this.timerBar.setProgress(0);
        final long j = seconds;
        this.mCountDownTimer = new CountDownTimer(seconds, 10) {
            public void onTick(long millisUntilFinished) {
                MathFragment.this.timerBar.setProgress((int) (j - millisUntilFinished));
            }

            public void onFinish() {
                ((IMathPresenter) MathFragment.this.presenter).compleateTraining();
            }
        };
        this.mCountDownTimer.start();
    }

    public void timerPause() {
        this.mCountDownTimer.cancel();
    }

    public void timerStart() {
        this.mCountDownTimer.start();
    }

    public void setIncorrectAnswer(int correctAnswer) {
        this.expressionTextView.setTextColor(getResources().getColor(R.color.reject_red));
        this.correctAnswerTextView.setText(getString(R.string.math_correct_answer, Integer.valueOf(correctAnswer)));
        this.correctAnswerTextView.setVisibility(0);
    }

    public void setCorrectAnswer() {
        this.expressionTextView.setTextColor(getResources().getColor(R.color.accept_green));
    }

    public void refreshExpressionTextView() {
        this.expressionTextView.setTextColor(getResources().getColor(17170441));
        this.mathPointsTextView.setVisibility(8);
    }

    public void setCorrectAnswerGone() {
        this.correctAnswerTextView.setVisibility(8);
    }

    public void setPointsTextViewCorrect(float points) {
        this.mathPointsTextView.setVisibility(0);
        Locale currentLocale = getResources().getConfiguration().locale;
        this.mathPointsTextView.setText(String.format(currentLocale, "+%.2g", new Object[]{Float.valueOf(points)}));
        this.mathPointsTextView.setTextColor(getResources().getColor(R.color.accept_green));
        this.mathPointsTextView.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.points_scale));
    }

    public void setPointsTextViewIncorrect() {
        this.mathPointsTextView.setVisibility(0);
        this.mathPointsTextView.setText("-1");
        this.mathPointsTextView.setTextColor(getResources().getColor(R.color.reject_red));
        this.mathPointsTextView.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.points_scale));
    }

    public void setButtonsEnabled(boolean enabled) {
        for (Button button : this.buttons) {
            button.setEnabled(enabled);
        }
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((IMathPresenter) this.presenter).startTraining(this.configId);
    }

    public void pauseAnimations() {
        ((IMathPresenter) this.presenter).pauseGame();
        setButtonsEnabled(false);
        timerPause();
    }

    public void resumeAnimations() {
        ((IMathPresenter) this.presenter).shuffleArray();
        setButtonsEnabled(true);
        timerStart();
    }
}
