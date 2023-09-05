package com.safonov.speedreading.training.fragment.wordsblock.training.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.application.util.PremiumUtil;
import com.safonov.speedreading.application.util.timeticker.TimeTickerConverterUtil;
import com.safonov.speedreading.training.activity.view.IAnimatedFragment;
import com.safonov.speedreading.training.fragment.wordsblock.repository.WordBlockRealmUtil;
import com.safonov.speedreading.training.fragment.wordsblock.training.presenter.IWordBlockPresenter;
import com.safonov.speedreading.training.fragment.wordsblock.training.presenter.WordBlockPresenter;
import com.speedreading.alexander.speedreading.R;

public class WordBlockFragment extends MvpFragment<IWordBlockView, IWordBlockPresenter> implements IWordBlockView, IAnimatedFragment {
    private static final String TRAINING_CONFIG_ID_PARAM = "training_config_id";
    @BindView(2131296290)
    AdView adView;
    private int configId;
    @BindView(2131296462)
    TextView itemTextView;
    private PremiumUtil premiumUtil = App.get().getPremiumUtil();
    private WordBlockRealmUtil realmUtil;
    @BindView(2131296711)
    TextView speedTextView;
    @BindView(2131296775)
    TextView timeTextView;
    private WordBlockTrainingCompleteListener trainingCompleteListener;
    private Unbinder unbinder;
    @BindView(2131296838)
    TextView wordCountTextView;

    @NonNull
    public IWordBlockPresenter createPresenter() {
        this.realmUtil = new WordBlockRealmUtil(App.get().getWordBlockRealm());
        return new WordBlockPresenter(getContext(), this.realmUtil);
    }

    public static WordBlockFragment newInstance(int configId2) {
        WordBlockFragment fragment = new WordBlockFragment();
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
        View view = inflater.inflate(R.layout.word_block_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        if (this.premiumUtil.isPremiumUser()) {
            this.adView.setVisibility(8);
        } else {
            this.adView.setAdListener(new AdListener() {
                public void onAdLoaded() {
                    super.onAdLoaded();
                    WordBlockFragment.this.adView.setVisibility(0);
                }

                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);
                    WordBlockFragment.this.adView.setVisibility(8);
                }
            });
            this.adView.loadAd(new AdRequest.Builder().build());
        }
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((IWordBlockPresenter) this.presenter).init(this.configId);
    }

    public void pauseAnimations() {
        ((IWordBlockPresenter) this.presenter).pauseTraining();
    }

    public void resumeAnimations() {
    }

    public void onPause() {
        this.adView.pause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.adView.resume();
    }

    public void setWordBlockItemText(String text) {
        this.itemTextView.setText(text);
    }

    @OnClick({2131296360})
    public void onContentViewClick() {
        ((IWordBlockPresenter) this.presenter).switchPauseStatus();
    }

    @OnClick({2131296682})
    public void onSpeedDownViewClick() {
        ((IWordBlockPresenter) this.presenter).speedDown();
    }

    @OnClick({2131296712})
    public void onSpeedUpViewClick() {
        ((IWordBlockPresenter) this.presenter).speedUp();
    }

    @OnClick({2131296532})
    public void onPlusViewClick() {
        ((IWordBlockPresenter) this.presenter).wordCountPlus();
    }

    @OnClick({2131296531})
    public void onMinusViewClick() {
        ((IWordBlockPresenter) this.presenter).wordCountMinus();
    }

    public void updateSpeedView(int speed) {
        this.speedTextView.setText(getString(R.string.word_block_speed, Integer.valueOf(speed)));
    }

    public void updateTimeView(long time) {
        this.timeTextView.setText(getString(R.string.word_block_time, TimeTickerConverterUtil.formatToSeconds(time)));
    }

    public void updateWordCountView(int wordCount) {
        this.wordCountTextView.setText(getString(R.string.words_block_word_count, Integer.valueOf(wordCount)));
    }

    public void onDestroy() {
        super.onDestroy();
        this.realmUtil.close();
    }

    public void onDestroyView() {
        super.onDestroyView();
        ((IWordBlockPresenter) this.presenter).cancelTraining();
        this.adView.destroy();
        this.unbinder.unbind();
    }

    public void onTrainingCompleted(int resultId) {
        this.trainingCompleteListener.onWordBlockTrainingCompleted(resultId);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof WordBlockTrainingCompleteListener) {
            this.trainingCompleteListener = (WordBlockTrainingCompleteListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement MultiBlockWordTrainingCompleteListener");
    }

    public void onDetach() {
        super.onDetach();
        this.trainingCompleteListener = null;
    }
}
