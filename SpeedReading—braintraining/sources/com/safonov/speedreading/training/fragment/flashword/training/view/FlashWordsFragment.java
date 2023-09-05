package com.safonov.speedreading.training.fragment.flashword.training.view;

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
import com.safonov.speedreading.training.fragment.flashword.repository.FlashWordRealmUtil;
import com.safonov.speedreading.training.fragment.flashword.training.presenter.FlashWordsPresenter;
import com.safonov.speedreading.training.fragment.flashword.training.presenter.IFlashWordsPresenter;
import com.speedreading.alexander.speedreading.R;
import java.util.ArrayList;
import java.util.List;

public class FlashWordsFragment extends MvpFragment<IFlashWordsView, IFlashWordsPresenter> implements IFlashWordsView, IAnimatedFragment {
    private static final String EMPTY_STRING = "";
    private static final int ITEM_COUNT_PER_PART = 4;
    private static final String TRAINING_CONFIG_ID_PARAM = "training_config_id";
    @BindView(2131296290)
    AdView adView;
    private int configId;
    @BindView(2131296360)
    ViewGroup contentView;
    private List<TextView> itemTextViewList;
    @BindView(2131296471)
    TextView levelTextView;
    private PremiumUtil premiumUtil = App.get().getPremiumUtil();
    private FlashWordRealmUtil realmUtil;
    @BindView(2131296711)
    TextView speedTextView;
    @BindView(2131296775)
    TextView timeTextView;
    private FlashWordsTrainingCompleteListener trainingCompleteListener;
    private Unbinder unbinder;

    @NonNull
    public IFlashWordsPresenter createPresenter() {
        this.realmUtil = new FlashWordRealmUtil(App.get().getFlashWordsRealm());
        return new FlashWordsPresenter(getContext(), this.realmUtil);
    }

    public static FlashWordsFragment newInstance(int configId2) {
        FlashWordsFragment fragment = new FlashWordsFragment();
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
        View view = inflater.inflate(R.layout.flash_words_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        if (this.premiumUtil.isPremiumUser()) {
            this.adView.setVisibility(8);
        } else {
            this.adView.setAdListener(new AdListener() {
                public void onAdLoaded() {
                    super.onAdLoaded();
                    FlashWordsFragment.this.adView.setVisibility(0);
                }

                public void onAdFailedToLoad(int errorCode) {
                    super.onAdFailedToLoad(errorCode);
                    FlashWordsFragment.this.adView.setVisibility(8);
                }
            });
            this.adView.loadAd(new AdRequest.Builder().build());
        }
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((IFlashWordsPresenter) this.presenter).init(this.configId);
    }

    public void pauseAnimations() {
        ((IFlashWordsPresenter) this.presenter).pauseTraining();
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

    @OnClick({2131296360})
    public void onContentViewClick() {
        ((IFlashWordsPresenter) this.presenter).switchTrainingPause();
    }

    @OnClick({2131296682})
    public void onSpeedDownViewClick() {
        ((IFlashWordsPresenter) this.presenter).speedDown();
    }

    @OnClick({2131296712})
    public void onSpeedUpViewClick() {
        ((IFlashWordsPresenter) this.presenter).speedUp();
    }

    @OnClick({2131296531})
    public void onMinusViewClick() {
        ((IFlashWordsPresenter) this.presenter).levelDown();
    }

    @OnClick({2131296532})
    public void onPlusViewClick() {
        ((IFlashWordsPresenter) this.presenter).levelUp();
    }

    public void updateSpeedView(int speed) {
        this.speedTextView.setText(getString(R.string.accelerator_speed, Integer.valueOf(speed)));
    }

    public void updateTimeView(long time) {
        this.timeTextView.setText(getString(R.string.accelerator_time, TimeTickerConverterUtil.formatToSeconds(time)));
    }

    public void updateLevelView(int level) {
        this.levelTextView.setText(getString(R.string.flash_words_level, Integer.valueOf(level)));
    }

    public void initBoardView(int boardType) {
        this.contentView.removeAllViews();
        this.itemTextViewList = new ArrayList();
        LayoutInflater inflater = getActivity().getLayoutInflater();
        switch (boardType) {
            case 1:
                View view = inflater.inflate(R.layout.flash_words_content_type_1, this.contentView, true);
                this.itemTextViewList.add((TextView) view.findViewById(R.id.item_1_text_view));
                this.itemTextViewList.add((TextView) view.findViewById(R.id.item_2_text_view));
                this.itemTextViewList.add((TextView) view.findViewById(R.id.item_3_text_view));
                this.itemTextViewList.add((TextView) view.findViewById(R.id.item_4_text_view));
                this.itemTextViewList.add((TextView) view.findViewById(R.id.item_5_text_view));
                this.itemTextViewList.add((TextView) view.findViewById(R.id.item_6_text_view));
                this.itemTextViewList.add((TextView) view.findViewById(R.id.item_7_text_view));
                this.itemTextViewList.add((TextView) view.findViewById(R.id.item_8_text_view));
                this.itemTextViewList.add((TextView) view.findViewById(R.id.item_9_text_view));
                this.itemTextViewList.add((TextView) view.findViewById(R.id.item_10_text_view));
                this.itemTextViewList.add((TextView) view.findViewById(R.id.item_11_text_view));
                this.itemTextViewList.add((TextView) view.findViewById(R.id.item_12_text_view));
                break;
            case 2:
                View view2 = inflater.inflate(R.layout.flash_words_content_type_2, this.contentView, true);
                this.itemTextViewList.add((TextView) view2.findViewById(R.id.item_1_text_view));
                this.itemTextViewList.add((TextView) view2.findViewById(R.id.item_2_text_view));
                this.itemTextViewList.add((TextView) view2.findViewById(R.id.item_3_text_view));
                this.itemTextViewList.add((TextView) view2.findViewById(R.id.item_4_text_view));
                this.itemTextViewList.add((TextView) view2.findViewById(R.id.item_5_text_view));
                this.itemTextViewList.add((TextView) view2.findViewById(R.id.item_6_text_view));
                this.itemTextViewList.add((TextView) view2.findViewById(R.id.item_7_text_view));
                this.itemTextViewList.add((TextView) view2.findViewById(R.id.item_8_text_view));
                break;
            case 3:
                View view3 = inflater.inflate(R.layout.flash_words_content_type_3, this.contentView, true);
                this.itemTextViewList.add((TextView) view3.findViewById(R.id.item_1_text_view));
                this.itemTextViewList.add((TextView) view3.findViewById(R.id.item_2_text_view));
                this.itemTextViewList.add((TextView) view3.findViewById(R.id.item_3_text_view));
                this.itemTextViewList.add((TextView) view3.findViewById(R.id.item_4_text_view));
                break;
        }
        ((IFlashWordsPresenter) this.presenter).startTraining();
    }

    public void setItemsText(int partIndex, @NonNull List<String> wordList) {
        int endItemIndex = (partIndex + 1) * 4;
        int wordIndex = 0;
        for (int i = partIndex * 4; i < endItemIndex; i++) {
            this.itemTextViewList.get(i).setText(wordList.get(wordIndex));
            wordIndex++;
        }
    }

    public void setItemsEmptyText() {
        for (TextView itemTextView : this.itemTextViewList) {
            itemTextView.setText("");
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.realmUtil.close();
    }

    public void onDestroyView() {
        super.onDestroyView();
        ((IFlashWordsPresenter) this.presenter).cancelTraining();
        this.adView.destroy();
        this.unbinder.unbind();
    }

    public void onTrainingCompleted(int resultId) {
        this.trainingCompleteListener.onFlashWordsTrainingCompleted(resultId);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FlashWordsTrainingCompleteListener) {
            this.trainingCompleteListener = (FlashWordsTrainingCompleteListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement FlashWordsTrainingCompleteListener");
    }

    public void onDetach() {
        super.onDetach();
        this.trainingCompleteListener = null;
    }
}
