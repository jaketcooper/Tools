package com.safonov.speedreading.training.fragment.cuptimer.training.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.training.activity.view.IAnimatedFragment;
import com.safonov.speedreading.training.fragment.cuptimer.repository.CupTimerRealmUtil;
import com.safonov.speedreading.training.fragment.cuptimer.training.presenter.CupTimerPresenter;
import com.safonov.speedreading.training.fragment.cuptimer.training.presenter.ICupTimerPresenter;
import com.speedreading.alexander.speedreading.R;

public class CupTimerFragment extends MvpFragment<ICupTimerView, ICupTimerPresenter> implements ICupTimerView, IAnimatedFragment {
    private static final String TRAINING_CONFIG_ID_PARAM = "config_id";
    private CupTimerCompleteListener completeListener;
    private int configId;
    private CupTimerRealmUtil cupTimerRealmUtil;
    @BindView(2131296466)
    ImageView imageView;
    @BindView(2131296582)
    TextView previewTitle;
    @BindView(2131296364)
    ProgressBar timerBar;
    private Unbinder unbinder;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cuptimer_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    @NonNull
    public ICupTimerPresenter createPresenter() {
        this.cupTimerRealmUtil = new CupTimerRealmUtil(((App) getActivity().getApplication()).getCupTimerRealm());
        return new CupTimerPresenter(this.cupTimerRealmUtil);
    }

    public void hideProgressBar() {
        this.timerBar.setVisibility(8);
    }

    public static CupTimerFragment newInstance(int configId2) {
        CupTimerFragment fragment = new CupTimerFragment();
        Bundle args = new Bundle();
        args.putInt(TRAINING_CONFIG_ID_PARAM, configId2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCupTimerTrainingCompleted(int trainingResultId) {
        this.completeListener.onCupTimerTrainingCompleted(trainingResultId);
    }

    public void pauseAnimations() {
        ((ICupTimerPresenter) this.presenter).pauseTraining();
    }

    public void resumeAnimations() {
        ((ICupTimerPresenter) this.presenter).resumeTraining();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.configId = getArguments().getInt(TRAINING_CONFIG_ID_PARAM);
        }
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((ICupTimerPresenter) this.presenter).startTraining(this.configId);
    }

    public void setImage(int resourceImage) {
        this.imageView.setImageResource(resourceImage);
    }

    public void setProgress(int progress) {
        this.timerBar.setProgress(progress);
    }

    public void setMaxProgress(long maxProgress) {
        this.timerBar.setMax((int) maxProgress);
    }

    public void showNotification(int notification) {
        this.previewTitle.setVisibility(0);
        this.previewTitle.setText(notification);
        this.previewTitle.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.points_alpha));
    }

    public void hideNotification() {
        this.previewTitle.setVisibility(8);
    }

    public void showImage() {
        Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.points_alpha);
        this.imageView.setVisibility(0);
        this.imageView.startAnimation(anim);
    }

    public void hideImage() {
        this.imageView.setVisibility(8);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CupTimerCompleteListener) {
            this.completeListener = (CupTimerCompleteListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement GreenDotTrainingCompleteListener");
    }

    public void onDetach() {
        super.onDetach();
        this.completeListener = null;
    }

    public void onDestroy() {
        super.onDestroy();
        this.cupTimerRealmUtil.close();
        this.cupTimerRealmUtil = null;
        ((ICupTimerPresenter) this.presenter).cancelTraining();
        this.presenter = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
        this.unbinder = null;
    }
}
