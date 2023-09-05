package com.safonov.speedreading.training.fragment.speedreading.training.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p003v7.widget.GridLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindColor;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.training.activity.view.IAnimatedFragment;
import com.safonov.speedreading.training.fragment.speedreading.repository.SpeedReadingRealmUtil;
import com.safonov.speedreading.training.fragment.speedreading.training.model.SpeedReadingModel;
import com.safonov.speedreading.training.fragment.speedreading.training.presenter.ISpeedReadingPresenter;
import com.safonov.speedreading.training.fragment.speedreading.training.presenter.SpeedReadingPresenter;
import com.speedreading.alexander.speedreading.R;
import java.util.List;

public class SpeedReadingFragment extends MvpFragment<ISpeedReadingView, ISpeedReadingPresenter> implements ISpeedReadingView, IAnimatedFragment {
    private static final int ANSWER_ANIMATION_DURATION = 1000;
    public static final int ANSWER_ITEMS_COLUMN_COUNT = 2;
    public static final int ANSWER_ITEMS_COUNT = 6;
    public static final int ANSWER_ITEMS_ROW_COUNT = 3;
    public static final int ITEMS_COLUMN_COUNT = 3;
    public static final int ITEMS_COUNT = 9;
    public static final int ITEMS_ROW_COUNT = 3;
    private static final String TRAINING_CONFIG_ID_PARAM = "config_id";
    @BindViews({2131296683, 2131296684, 2131296685, 2131296686, 2131296687, 2131296688})
    List<Button> answerButtons;
    @BindView(2131296689)
    GridLayout answerGridLayout;
    @BindView(2131296690)
    TextView answerSpeedTextView;
    @BindView(2131296691)
    TextView answerSpeedTitleTextView;
    private int configId;
    @BindColor(2131099674)
    int greenColor;
    private Handler handler = new Handler();
    @BindView(2131296697)
    ProgressBar progressBar;
    @BindColor(2131099757)
    int redColor;
    private SpeedReadingModel speedReadingModel;
    private SpeedReadingRealmUtil speedReadingRealmUtil;
    @BindView(2131296699)
    TextView speedTextView;
    @BindView(2131296700)
    View statisticsView;
    @BindColor(17170435)
    int textColorBlack;
    private SpeedReadingTrainingCompleteListener trainingCompleteListener;
    private Unbinder unbinder;
    @BindViews({2131296701, 2131296702, 2131296703, 2131296704, 2131296705, 2131296706, 2131296707, 2131296708, 2131296709})
    List<TextView> wordsTextViewList;
    @BindView(2131296710)
    View wordsView;

    @NonNull
    public ISpeedReadingPresenter createPresenter() {
        this.speedReadingRealmUtil = new SpeedReadingRealmUtil(((App) getActivity().getApplication()).getSpeedReadingRealm());
        this.speedReadingModel = new SpeedReadingModel(getContext());
        return new SpeedReadingPresenter(this.speedReadingModel, this.speedReadingRealmUtil);
    }

    public static SpeedReadingFragment newInstance(int speedReadingConfigId) {
        SpeedReadingFragment fragment = new SpeedReadingFragment();
        Bundle args = new Bundle();
        args.putInt(TRAINING_CONFIG_ID_PARAM, speedReadingConfigId);
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
        View view = inflater.inflate(R.layout.speed_reading_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    @OnClick({2131296683, 2131296684, 2131296685, 2131296686, 2131296687, 2131296688})
    public void onAnswerButtonClick(View view) {
        ((ISpeedReadingPresenter) this.presenter).answerButtonClick(getAnswerButtonIndex(view));
    }

    private int getAnswerButtonIndex(View buttonView) {
        for (int i = 0; i < 6; i++) {
            if (this.answerButtons.get(i) == buttonView) {
                return i;
            }
        }
        return 0;
    }

    public void setAnswerItems(List<String> answers) {
        for (int i = 0; i < 6; i++) {
            this.answerButtons.get(i).setText(answers.get(i));
        }
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((ISpeedReadingPresenter) this.presenter).startTraining(this.configId);
    }

    public void pauseAnimations() {
        ((ISpeedReadingPresenter) this.presenter).pauseTraining();
    }

    public void resumeAnimations() {
        ((ISpeedReadingPresenter) this.presenter).resumeTraining();
    }

    public void onDestroy() {
        super.onDestroy();
        this.speedReadingModel = null;
        this.speedReadingRealmUtil.close();
        this.speedReadingRealmUtil = null;
        ((ISpeedReadingPresenter) this.presenter).cancelTraining();
        this.presenter = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
        this.unbinder = null;
    }

    public void showWordsView() {
        this.statisticsView.setVisibility(0);
        this.wordsView.setVisibility(0);
    }

    public void hideWordsView() {
        this.statisticsView.setVisibility(8);
        this.wordsView.setVisibility(8);
    }

    public void showAnswerView() {
        this.answerSpeedTextView.setVisibility(0);
        this.answerSpeedTitleTextView.setVisibility(0);
        this.answerGridLayout.setVisibility(0);
    }

    public void hideAnswerView() {
        this.answerSpeedTextView.setVisibility(8);
        this.answerSpeedTitleTextView.setVisibility(8);
        this.answerGridLayout.setVisibility(8);
    }

    public void setWordItem(int index, String word) {
        this.wordsTextViewList.get(index).setText(word);
    }

    public void setAnswerButtonsEnabled(boolean isEnabled) {
        for (Button button : this.answerButtons) {
            button.setEnabled(isEnabled);
        }
    }

    public void updateAnswerSpeed(int speed) {
        this.answerSpeedTextView.setText(String.valueOf(speed));
        this.answerSpeedTextView.setTextColor(this.textColorBlack);
    }

    public void updateAnswerSpeedWithAnimation(int speed, boolean isTrueAnswer) {
        this.answerSpeedTextView.setText(String.valueOf(speed));
        if (isTrueAnswer) {
            this.answerSpeedTextView.setTextColor(this.greenColor);
        } else {
            this.answerSpeedTextView.setTextColor(this.redColor);
        }
        this.handler.postDelayed(new Runnable() {
            public void run() {
                if (SpeedReadingFragment.this.presenter != null) {
                    ((ISpeedReadingPresenter) SpeedReadingFragment.this.presenter).answerAnimationEnded();
                }
            }
        }, 1000);
    }

    public void initProgressBar(int max) {
        this.progressBar.setMax(max);
    }

    public void updateProgressBar(int progress) {
        this.progressBar.setProgress(progress);
    }

    public void updateSpeed(int speed) {
        this.speedTextView.setText(getString(R.string.speed_reading_speed, Integer.valueOf(speed)));
    }

    public void onSpeedReadingTrainingCompleted(int trainingResultId) {
        this.trainingCompleteListener.onSpeedReadingTrainingCompleted(trainingResultId);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SpeedReadingTrainingCompleteListener) {
            this.trainingCompleteListener = (SpeedReadingTrainingCompleteListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement SpeedReadingTrainingCompleteListener");
    }

    public void onDetach() {
        super.onDetach();
        this.trainingCompleteListener = null;
    }
}
