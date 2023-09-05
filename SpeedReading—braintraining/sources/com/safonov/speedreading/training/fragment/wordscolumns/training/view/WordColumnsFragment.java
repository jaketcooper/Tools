package com.safonov.speedreading.training.fragment.wordscolumns.training.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p003v7.widget.GridLayout;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindColor;
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
import com.safonov.speedreading.training.fragment.wordscolumns.repository.WordsColumnsRealmUtil;
import com.safonov.speedreading.training.fragment.wordscolumns.training.presenter.IWordColumnsPresenter;
import com.safonov.speedreading.training.fragment.wordscolumns.training.presenter.WordColumnsPresenter;
import com.speedreading.alexander.speedreading.R;
import java.util.ArrayList;
import java.util.List;

public class WordColumnsFragment extends MvpFragment<IWordColumnsView, IWordColumnsPresenter> implements IWordColumnsView, IAnimatedFragment {
    private static final int ITEM_TEXT_SIZE_SP = 16;
    private static final String TRAINING_CONFIG_ID_PARAM = "training_config_id";
    @BindView(2131296290)
    AdView adView;
    private int configId;
    @BindView(2131296422)
    GridLayout gridLayout;
    private int itemCount;
    private List<TextView> itemList;
    @BindColor(17170436)
    int itemTextColor;
    private PremiumUtil premiumUtil = App.get().getPremiumUtil();
    private WordsColumnsRealmUtil realmUtil;
    @BindView(2131296711)
    TextView speedTextView;
    @BindView(2131296775)
    TextView timeTextView;
    private WordColumnsTrainingCompleteListener trainingCompleteListener;
    private Unbinder unbinder;

    @NonNull
    public IWordColumnsPresenter createPresenter() {
        this.realmUtil = new WordsColumnsRealmUtil(App.get().getWordsColumnsRealm());
        return new WordColumnsPresenter(getContext(), this.realmUtil);
    }

    public static WordColumnsFragment newInstance(int configId2) {
        WordColumnsFragment fragment = new WordColumnsFragment();
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
        View view = inflater.inflate(R.layout.words_columns_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        if (this.premiumUtil.isPremiumUser()) {
            this.adView.setVisibility(8);
        } else {
            this.adView.setAdListener(new AdListener() {
                public void onAdLoaded() {
                    super.onAdLoaded();
                    WordColumnsFragment.this.adView.setVisibility(0);
                }

                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);
                    WordColumnsFragment.this.adView.setVisibility(8);
                }
            });
            this.adView.loadAd(new AdRequest.Builder().build());
        }
        this.gridLayout.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != 0) {
                    return true;
                }
                ((IWordColumnsPresenter) WordColumnsFragment.this.presenter).switchTrainingPauseStatus();
                return true;
            }
        });
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((IWordColumnsPresenter) this.presenter).init(this.configId);
    }

    public void pauseAnimations() {
        ((IWordColumnsPresenter) this.presenter).pauseTraining();
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

    @OnClick({2131296682})
    public void onSpeedDownViewClick() {
        ((IWordColumnsPresenter) this.presenter).speedDown();
    }

    @OnClick({2131296712})
    public void onSpeedUpViewClick() {
        ((IWordColumnsPresenter) this.presenter).speedUp();
    }

    public void initGridLayout(int rowCount, int columnCount) {
        this.itemCount = rowCount * columnCount;
        this.itemList = new ArrayList(this.itemCount);
        this.gridLayout.removeAllViews();
        this.gridLayout.setRowCount(rowCount);
        this.gridLayout.setColumnCount(columnCount);
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                TextView itemTextView = new TextView(getContext());
                GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(GridLayout.spec(Integer.MIN_VALUE, 1.0f), GridLayout.spec(Integer.MIN_VALUE, 1.0f));
                layoutParams.setGravity(1);
                itemTextView.setLayoutParams(layoutParams);
                itemTextView.setTextSize(2, 16.0f);
                itemTextView.setTextColor(this.itemTextColor);
                this.itemList.add(itemTextView);
                this.gridLayout.addView(itemTextView);
            }
        }
        ((IWordColumnsPresenter) this.presenter).startTraining();
    }

    public void setItems(@NonNull String[] items) {
        for (int i = 0; i < this.itemCount; i++) {
            this.itemList.get(i).setText(items[i]);
        }
    }

    public void selectItem(int index) {
        this.itemList.get(index).setBackgroundColor(-16711681);
    }

    public void deselectItem(int index) {
        this.itemList.get(index).setBackgroundColor(0);
    }

    public void updateSpeedView(int speed) {
        this.speedTextView.setText(getString(R.string.accelerator_speed, Integer.valueOf(speed)));
    }

    public void updateTimeView(long time) {
        this.timeTextView.setText(getString(R.string.accelerator_time, TimeTickerConverterUtil.formatToSeconds(time)));
    }

    public void onDestroy() {
        super.onDestroy();
        this.realmUtil.close();
    }

    public void onDestroyView() {
        super.onDestroyView();
        ((IWordColumnsPresenter) this.presenter).cancelTraining();
        this.adView.destroy();
        this.unbinder.unbind();
    }

    public void onTrainingCompleted(int resultId) {
        this.trainingCompleteListener.onWordColumnsTrainingCompleted(resultId);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof WordColumnsTrainingCompleteListener) {
            this.trainingCompleteListener = (WordColumnsTrainingCompleteListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement FlashWordsTrainingCompleteListener");
    }

    public void onDetach() {
        super.onDetach();
        this.trainingCompleteListener = null;
    }
}
