package com.safonov.speedreading.training.fragment.truecolors.training.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.safonov.speedreading.training.fragment.truecolors.repository.TrueColorsRealmUtil;
import com.safonov.speedreading.training.fragment.truecolors.training.model.TrueColorsModel;
import com.safonov.speedreading.training.fragment.truecolors.training.presenter.ITrueColorsPresenter;
import com.safonov.speedreading.training.fragment.truecolors.training.presenter.TrueColorsPresenter;
import com.speedreading.alexander.speedreading.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TrueColorsFragment extends MvpFragment<ITrueColorsView, ITrueColorsPresenter> implements ITrueColorsView, IAnimatedFragment {
    public static final int COUNT_DOWN_INTERVAL = 10;
    private static final String TRAINING_CONFIG_ID_PARAM = "config_id";
    @BindViews({2131296814, 2131296815, 2131296816, 2131296817})
    List<TextView> answerButtons;
    @BindView(2131296465)
    ImageView answerImageView;
    private int configId;
    /* access modifiers changed from: private */
    public long currentProgress;
    private CountDownTimer mCountDownTimer;
    @BindView(2131296821)
    ProgressBar progressBar;
    @BindView(2131296822)
    TextView questionTV;
    @BindView(2131296823)
    TextView recordTextView;
    TrueColorsModel rightAnswer;
    @BindView(2131296825)
    TextView scoreTextView;
    @BindView(2131296829)
    ProgressBar timerBar;
    private TrueColorsTrainingCompleteListener trainingCompleteListener;
    private TrueColorsRealmUtil trueColorsRealmUtil;
    private Unbinder unbinder;

    @NonNull
    public ITrueColorsPresenter createPresenter() {
        this.trueColorsRealmUtil = new TrueColorsRealmUtil(((App) getActivity().getApplication()).getTrueColorsRealm());
        return new TrueColorsPresenter(this.trueColorsRealmUtil);
    }

    public static TrueColorsFragment newInstance(int configId2) {
        Log.d("configId", "" + configId2);
        TrueColorsFragment fragment = new TrueColorsFragment();
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

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.true_colors_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    public void updateScoreView(int score) {
        this.scoreTextView.setText(getString(R.string.remember_number_score, Integer.valueOf(score)));
    }

    public void updateBestScoreView(int record) {
        this.recordTextView.setText(getString(R.string.remember_number_best_score, Integer.valueOf(record)));
    }

    public void initProgressBar(int maxProgress) {
        this.progressBar.setMax(maxProgress);
    }

    public void updateProgressBar(int progress) {
        this.progressBar.setProgress(progress);
    }

    public void setAnswerImage(boolean isCorrect) {
        if (isCorrect) {
            this.answerImageView.setImageResource(R.drawable.checked);
        } else {
            this.answerImageView.setImageResource(R.drawable.cancel);
        }
        this.answerImageView.setVisibility(0);
    }

    public void hideAnswerImage() {
        this.answerImageView.setVisibility(8);
    }

    public void initCountDownTimer(long milliseconds) {
        this.timerBar.setMax((int) milliseconds);
        this.timerBar.setProgress(0);
        final long j = milliseconds;
        this.mCountDownTimer = new CountDownTimer(milliseconds, 10) {
            public void onTick(long millisUntilFinished) {
                long unused = TrueColorsFragment.this.currentProgress = j - millisUntilFinished;
                TrueColorsFragment.this.timerBar.setProgress((int) TrueColorsFragment.this.currentProgress);
            }

            public void onFinish() {
                ((ITrueColorsPresenter) TrueColorsFragment.this.presenter).finishTraining();
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

    public long getProgress() {
        return this.currentProgress;
    }

    public List<TrueColorsModel> getColors() {
        TypedArray ta = getResources().obtainTypedArray(R.array.true_colors_list);
        int[] colors = new int[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            colors[i] = ta.getColor(i, 0);
        }
        ta.recycle();
        String[] colorNames = getResources().getStringArray(R.array.true_colors_words);
        List<TrueColorsModel> result = new ArrayList<>();
        for (int i2 = 0; i2 < colorNames.length; i2++) {
            result.add(new TrueColorsModel(colorNames[i2], colors[i2]));
        }
        return result;
    }

    public void disableButtons() {
        for (int i = 0; i < this.answerButtons.size(); i++) {
            this.answerButtons.get(i).setEnabled(false);
        }
    }

    public void enableButtons() {
        for (int i = 0; i < this.answerButtons.size(); i++) {
            this.answerButtons.get(i).setEnabled(true);
        }
    }

    public void showLevel(TrueColorsModel correctAnswer, List<TrueColorsModel> incorrectAnswers) {
        int randomColorIndex = new Random().nextInt(3) + 1;
        this.questionTV.setText(correctAnswer.getColorName());
        this.rightAnswer = incorrectAnswers.get(randomColorIndex);
        this.questionTV.setTextColor(this.rightAnswer.getColor());
        for (int i = 0; i < this.answerButtons.size(); i++) {
            this.answerButtons.get(i).setText(incorrectAnswers.get(i).getColorName());
        }
    }

    @OnClick({2131296814, 2131296815, 2131296816, 2131296817})
    public void onNumberButtonClick(TextView button) {
        ((ITrueColorsPresenter) this.presenter).onNumberButtonPressed(this.rightAnswer, String.valueOf(button.getText()));
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((ITrueColorsPresenter) this.presenter).startTraining(this.configId);
    }

    public void pauseAnimations() {
        ((ITrueColorsPresenter) this.presenter).pauseTraining();
    }

    public void resumeAnimations() {
        ((ITrueColorsPresenter) this.presenter).resumeTraining();
    }

    public void onDestroy() {
        super.onDestroy();
        this.trueColorsRealmUtil.close();
        this.trueColorsRealmUtil = null;
        ((ITrueColorsPresenter) this.presenter).cancelTraining();
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

    public void onTrueColorsTrainingCompleted(int trainingResultId) {
        this.trainingCompleteListener.onTrueColorsTrainingCompleted(trainingResultId);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof TrueColorsTrainingCompleteListener) {
            this.trainingCompleteListener = (TrueColorsTrainingCompleteListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement RememberNumberTrainingCompleteListener");
    }

    public void onDetach() {
        super.onDetach();
        this.trainingCompleteListener = null;
        if (this.mCountDownTimer != null) {
            this.mCountDownTimer.cancel();
        }
    }
}
