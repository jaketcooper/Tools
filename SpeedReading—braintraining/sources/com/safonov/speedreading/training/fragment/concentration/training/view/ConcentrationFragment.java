package com.safonov.speedreading.training.fragment.concentration.training.view;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p003v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.training.activity.view.IAnimatedFragment;
import com.safonov.speedreading.training.fragment.concentration.repository.ConcentrationRealmUtil;
import com.safonov.speedreading.training.fragment.concentration.repository.IConcentrationRepository;
import com.safonov.speedreading.training.fragment.concentration.repository.entity.ConcentrationConfig;
import com.safonov.speedreading.training.fragment.concentration.training.model.MovementView;
import com.safonov.speedreading.training.fragment.concentration.training.presenter.ConcentrationPresenter;
import com.safonov.speedreading.training.fragment.concentration.training.presenter.IConcentrationPresenter;
import com.speedreading.alexander.speedreading.R;
import java.util.Locale;

public class ConcentrationFragment extends MvpFragment<IConcentrationView, IConcentrationPresenter> implements IConcentrationView, IAnimatedFragment {
    private static final String TRAINING_CONFIG_ID_PARAM = "config_id";
    AlertDialog.Builder builder;
    @BindView(2131296333)
    LinearLayout circlesContatiner;
    MovementView circlesView;
    @BindView(2131296347)
    TextView concentrationPointsTextView;
    /* access modifiers changed from: private */
    public ConcentrationRealmUtil concentrationRealmUtil;
    private ConcentrationConfig config;
    private int configId;
    boolean isPause = false;
    @BindView(2131296353)
    LinearLayout layout;
    @BindView(2131296348)
    ProgressBar progressBar;
    @BindView(2131296349)
    TextView recordTextView;
    @BindView(2131296351)
    TextView scoreTextView;
    private ConcentrationCompleteListener trainingCompleteListener;
    private Unbinder unbinder;

    @NonNull
    public IConcentrationPresenter createPresenter() {
        return new ConcentrationPresenter(this.concentrationRealmUtil);
    }

    public static ConcentrationFragment newInstance(int configId2) {
        Log.d("concentration config", "" + configId2);
        ConcentrationFragment fragment = new ConcentrationFragment();
        Bundle args = new Bundle();
        args.putInt(TRAINING_CONFIG_ID_PARAM, configId2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.concentrationRealmUtil = new ConcentrationRealmUtil(((App) getActivity().getApplication()).getConcentrationRealm());
        if (getArguments() != null) {
            this.configId = getArguments().getInt(TRAINING_CONFIG_ID_PARAM);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.concentration_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ConcentrationConfig config2 = this.concentrationRealmUtil.getConfig(this.configId);
        if (config2.getComplexity() == 1) {
            this.circlesView = new MovementView((Context) getActivity(), (IConcentrationRepository) this.concentrationRealmUtil, this.configId, (IConcentrationView) this, this.isPause);
            this.circlesContatiner.addView(this.circlesView);
            setVisibleStatistics(true);
        }
        if (config2.getComplexity() == 2) {
            View promptsView = getLayoutInflater().inflate(R.layout.concentration_dialog, (ViewGroup) null);
            setVisibleStatistics(false);
            this.builder = new AlertDialog.Builder(getContext());
            this.builder.setView(promptsView);
            final NumberPicker count = (NumberPicker) promptsView.findViewById(R.id.cirlesCount);
            final NumberPicker size = (NumberPicker) promptsView.findViewById(R.id.cirlesRadius);
            final NumberPicker speed = (NumberPicker) promptsView.findViewById(R.id.circlesSpeed);
            count.setMaxValue(30);
            count.setValue(config2.getCirclesCountCustom());
            count.setMinValue(4);
            final String[] speedValues = {"1", "3", "5", "7", "9", "14"};
            speed.setMinValue(0);
            speed.setDisplayedValues(speedValues);
            speed.setMaxValue(speedValues.length - 1);
            for (int i = 0; i < speedValues.length; i++) {
                if (config2.getCirclesSpeedCustom() == Integer.parseInt(speedValues[i])) {
                    speed.setValue(i);
                }
            }
            final String[] valueSet = {"30", "50", "70", "90", "110"};
            size.setMinValue(0);
            size.setDisplayedValues(valueSet);
            size.setMaxValue(valueSet.length - 1);
            for (int i2 = 0; i2 < valueSet.length; i2++) {
                if (config2.getCirclesSizeCustom() == Integer.parseInt(valueSet[i2])) {
                    size.setValue(i2);
                }
            }
            this.builder.setPositiveButton((CharSequence) "Запустить", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    int starCount = count.getValue();
                    int speedStr = Integer.parseInt(speedValues[speed.getValue()]);
                    int sizeStr = Integer.parseInt(valueSet[size.getValue()]);
                    ConcentrationFragment.this.concentrationRealmUtil.updateConfigCustom(config2.getId(), starCount, sizeStr, speedStr);
                    ConcentrationFragment.this.circlesView = new MovementView((Context) ConcentrationFragment.this.getActivity(), starCount, speedStr, sizeStr, ConcentrationFragment.this.isPause);
                    ConcentrationFragment.this.circlesContatiner.addView(ConcentrationFragment.this.circlesView);
                }
            });
            this.builder.create().show();
        }
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

    public void setVisibleStatistics(boolean visible) {
        if (visible) {
            this.layout.setVisibility(0);
        } else {
            this.layout.setVisibility(8);
        }
    }

    public void setPointsTextViewCorrect(int points) {
        this.concentrationPointsTextView.setVisibility(0);
        Locale locale = getResources().getConfiguration().locale;
        this.concentrationPointsTextView.setText("+" + points);
        this.concentrationPointsTextView.setTextColor(getResources().getColor(R.color.accept_green));
        this.concentrationPointsTextView.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.points_scale));
    }

    public void hidePointsTextView() {
        this.concentrationPointsTextView.setVisibility(8);
    }

    public void onConcentrationTrainingCompleted(int trainingResultId) {
        this.trainingCompleteListener.onConcentrationTrainingCompleted(trainingResultId);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ConcentrationCompleteListener) {
            this.trainingCompleteListener = (ConcentrationCompleteListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement GreenDotTrainingCompleteListener");
    }

    public void onDetach() {
        this.isPause = true;
        super.onDetach();
        if (this.circlesView != null) {
            this.circlesView.cancelGame();
        }
        this.trainingCompleteListener = null;
    }

    public void pauseAnimations() {
        this.isPause = true;
        if (this.circlesView != null) {
            this.circlesView.cancelGame();
        }
    }

    public void resumeAnimations() {
        this.isPause = false;
        if (this.circlesView != null) {
            this.circlesView.startLevel();
        }
    }
}
