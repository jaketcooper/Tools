package com.safonov.speedreading.training.fragment.wordpairs.training.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p003v7.widget.GridLayout;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.training.activity.view.IAnimatedFragment;
import com.safonov.speedreading.training.fragment.wordpairs.repository.WordPairsRealmUtil;
import com.safonov.speedreading.training.fragment.wordpairs.training.model.WordPair;
import com.safonov.speedreading.training.fragment.wordpairs.training.model.WordPairsModel;
import com.safonov.speedreading.training.fragment.wordpairs.training.presenter.IWordPairsPresenter;
import com.safonov.speedreading.training.fragment.wordpairs.training.presenter.WordPairsPresenter;
import com.speedreading.alexander.speedreading.R;
import java.util.ArrayList;
import java.util.List;

public class WordPairsFragment extends MvpFragment<IWordPairsView, IWordPairsPresenter> implements IWordPairsView, IAnimatedFragment {
    private static final int ITEMS_ALPHA_ANIMATION_DURATION = 1000;
    private static final int ITEM_TEXT_SIZE_DP = 16;
    private static final String TRAINING_CONFIG_ID_PARAM = "config_id";
    @BindColor(2131099694)
    int backgroundWhiteColor;
    private int configId;
    @BindColor(2131099674)
    int greenColor;
    @BindView(2131296839)
    GridLayout gridLayout;
    private int itemCount;
    private List<WordPairItemView> itemList;
    private View.OnTouchListener itemOnTouchListener = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent event) {
            switch (event.getActionMasked()) {
                case 0:
                    ((IWordPairsPresenter) WordPairsFragment.this.presenter).onItemTouchDown(WordPairsFragment.this.getItemIndex(view));
                    return true;
                case 1:
                case 3:
                    ((IWordPairsPresenter) WordPairsFragment.this.presenter).onItemTouchUp(WordPairsFragment.this.getItemIndex(view));
                    return false;
                default:
                    return false;
            }
        }
    };
    private ObjectAnimator itemsAlphaAnimator;
    @BindView(2131296590)
    ProgressBar progressBar;
    @BindView(2131296607)
    TextView recordTextView;
    @BindColor(2131099757)
    int redColor;
    @BindView(2131296648)
    TextView scoreTextView;
    @BindColor(17170435)
    int textColorBlack;
    @BindColor(17170443)
    int textColorWhite;
    private Unbinder unbinder;
    private WordPairsModel wordPairsModel;
    private WordPairsRealmUtil wordPairsRealmUtil;
    private WordPairsTrainingCompleteListener wordPairsTrainingCompleteListener;

    @NonNull
    public IWordPairsPresenter createPresenter() {
        this.wordPairsRealmUtil = new WordPairsRealmUtil(((App) getActivity().getApplication()).getWordPairsRealm());
        this.wordPairsModel = new WordPairsModel(getContext());
        return new WordPairsPresenter(this.wordPairsModel, this.wordPairsRealmUtil);
    }

    public static WordPairsFragment newInstance(int configId2) {
        WordPairsFragment fragment = new WordPairsFragment();
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
        View view = inflater.inflate(R.layout.word_pairs_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        this.itemsAlphaAnimator = ObjectAnimator.ofFloat(this.gridLayout, View.ALPHA, new float[]{0.0f, 1.0f}).setDuration(1000);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((IWordPairsPresenter) this.presenter).init(this.configId);
    }

    public void pauseAnimations() {
        ((IWordPairsPresenter) this.presenter).pauseTraining();
    }

    public void resumeAnimations() {
        ((IWordPairsPresenter) this.presenter).resumeTraining();
    }

    public void onDestroy() {
        super.onDestroy();
        ((IWordPairsPresenter) this.presenter).cancelTraining();
        this.wordPairsRealmUtil.close();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
    }

    private static class WordPairItemView extends LinearLayout {
        private TextView firstWordTextView;
        private TextView secondWordTextView;

        public WordPairItemView(Context context) {
            super(context);
            setOrientation(1);
            setGravity(17);
            this.firstWordTextView = new TextView(context);
            this.secondWordTextView = new TextView(context);
            this.firstWordTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.secondWordTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            this.firstWordTextView.setTextSize(2, 16.0f);
            this.secondWordTextView.setTextSize(2, 16.0f);
            addView(this.firstWordTextView);
            addView(this.secondWordTextView);
        }

        public void setText(CharSequence firstText, CharSequence secondText) {
            this.firstWordTextView.setText(firstText);
            this.secondWordTextView.setText(secondText);
        }

        public void setTextColor(int color) {
            this.firstWordTextView.setTextColor(color);
            this.secondWordTextView.setTextColor(color);
        }
    }

    public void initBoard(int rowCount, int columnCount) {
        this.itemCount = rowCount * columnCount;
        this.itemList = new ArrayList(this.itemCount);
        this.gridLayout.removeAllViews();
        this.gridLayout.setColumnCount(columnCount);
        this.gridLayout.setRowCount(rowCount);
        for (int i = 0; i < this.itemCount; i++) {
            WordPairItemView itemTextView = new WordPairItemView(getContext());
            itemTextView.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(Integer.MIN_VALUE, 1.0f), GridLayout.spec(Integer.MIN_VALUE, 1.0f)));
            itemTextView.setOnTouchListener(this.itemOnTouchListener);
            itemTextView.setBackgroundColor(this.backgroundWhiteColor);
            itemTextView.setTextColor(this.textColorBlack);
            this.itemList.add(itemTextView);
            this.gridLayout.addView(itemTextView);
        }
        ((IWordPairsPresenter) this.presenter).startTraining();
    }

    /* access modifiers changed from: private */
    public int getItemIndex(View itemView) {
        for (int i = 0; i < this.itemCount; i++) {
            if (itemView == this.itemList.get(i)) {
                return i;
            }
        }
        return 0;
    }

    public void setBoardItems(@NonNull List<WordPair> itemsData) {
        for (int i = 0; i < this.itemCount; i++) {
            WordPair wordPair = itemsData.get(i);
            this.itemList.get(i).setText(wordPair.getFirstWord(), wordPair.getSecondWord());
            this.itemList.get(i).setBackgroundColor(this.backgroundWhiteColor);
            this.itemList.get(i).setTextColor(this.textColorBlack);
            this.itemList.get(i).setEnabled(true);
        }
        this.itemsAlphaAnimator.start();
    }

    public void setBoardItemsEnable(boolean enable) {
        for (WordPairItemView itemView : this.itemList) {
            itemView.setEnabled(enable);
        }
    }

    public void itemTouchDown(int itemIndex, boolean isTrueAnswer) {
        WordPairItemView itemView = this.itemList.get(itemIndex);
        if (isTrueAnswer) {
            itemView.setBackgroundColor(this.greenColor);
            itemView.setTextColor(this.textColorWhite);
            return;
        }
        itemView.setBackgroundColor(this.redColor);
        itemView.setTextColor(this.textColorWhite);
    }

    public void itemTouchUp(int itemIndex, boolean isTrueAnswer) {
        WordPairItemView itemView = this.itemList.get(itemIndex);
        if (isTrueAnswer) {
            itemView.setEnabled(false);
            return;
        }
        itemView.setBackgroundColor(this.backgroundWhiteColor);
        itemView.setTextColor(this.textColorBlack);
    }

    public void initProgressBar(int max) {
        this.progressBar.setMax(max);
    }

    public void updateProgressBar(int progress) {
        this.progressBar.setProgress(progress);
    }

    public void updateScore(int score) {
        this.scoreTextView.setText(getString(R.string.word_pairs_score, Integer.valueOf(score)));
    }

    public void updateRecord(int record) {
        this.recordTextView.setText(getString(R.string.word_pairs_best_score, Integer.valueOf(record)));
    }

    public void onWordPairsTrainingCompleted(int trainingResultId) {
        this.wordPairsTrainingCompleteListener.onWordPairsTrainingCompleted(trainingResultId);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof WordPairsTrainingCompleteListener) {
            this.wordPairsTrainingCompleteListener = (WordPairsTrainingCompleteListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement WordPairsTrainingCompleteListener");
    }

    public void onDetach() {
        super.onDetach();
        this.wordPairsTrainingCompleteListener = null;
    }
}
