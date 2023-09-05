package com.safonov.speedreading.training.fragment.evennumbers.training.view;

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
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.training.activity.view.IAnimatedFragment;
import com.safonov.speedreading.training.fragment.evennumbers.repository.EvenNumbersRealmUtil;
import com.safonov.speedreading.training.fragment.evennumbers.training.model.EvenNumbersModel;
import com.safonov.speedreading.training.fragment.evennumbers.training.model.NumberWrapper;
import com.safonov.speedreading.training.fragment.evennumbers.training.presenter.EvenNumbersPresenter;
import com.safonov.speedreading.training.fragment.evennumbers.training.presenter.IEvenNumbersPresenter;
import com.speedreading.alexander.speedreading.R;
import java.util.ArrayList;
import java.util.List;

public class EvenNumbersFragment extends MvpFragment<IEvenNumbersView, IEvenNumbersPresenter> implements IEvenNumbersView, IAnimatedFragment {
    private static final int ITEMS_ALPHA_ANIMATION_DURATION = 1000;
    private static final int ITEM_TEXT_SIZE_SP = 16;
    private static final String TRAINING_CONFIG_PARAM = "config_id";
    @BindColor(2131099694)
    int backgroundWhiteColor;
    private int configId;
    @BindColor(2131099674)
    int greenColor;
    @BindView(2131296393)
    GridLayout gridLayout;
    private int itemCount;
    private List<TextView> itemList;
    private View.OnTouchListener itemOnTouchListener = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent event) {
            switch (event.getActionMasked()) {
                case 0:
                    ((IEvenNumbersPresenter) EvenNumbersFragment.this.presenter).onItemTouchDown(EvenNumbersFragment.this.getItemIndex(view));
                    return true;
                case 1:
                case 3:
                    ((IEvenNumbersPresenter) EvenNumbersFragment.this.presenter).onItemTouchUp(EvenNumbersFragment.this.getItemIndex(view));
                    return false;
                default:
                    return false;
            }
        }
    };
    private ObjectAnimator itemsAlphaAnimator;
    @BindView(2131296590)
    ProgressBar progressBar;
    private EvenNumbersRealmUtil realmUtil;
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
    private EvenNumbersTrainingCompleteListener trainingCompleteListener;
    private Unbinder unbinder;

    @NonNull
    public IEvenNumbersPresenter createPresenter() {
        this.realmUtil = new EvenNumbersRealmUtil(((App) getActivity().getApplication()).getEvenNumbersRealm());
        return new EvenNumbersPresenter(new EvenNumbersModel(), this.realmUtil);
    }

    public static EvenNumbersFragment newInstance(int evenNumbersConfigId) {
        EvenNumbersFragment fragment = new EvenNumbersFragment();
        Bundle args = new Bundle();
        args.putInt(TRAINING_CONFIG_PARAM, evenNumbersConfigId);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.configId = getArguments().getInt(TRAINING_CONFIG_PARAM);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.even_numbers_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        this.itemsAlphaAnimator = ObjectAnimator.ofFloat(this.gridLayout, View.ALPHA, new float[]{0.0f, 1.0f}).setDuration(1000);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((IEvenNumbersPresenter) this.presenter).init(this.configId);
    }

    public void initBoard(int rowCount, int columnCount) {
        this.itemCount = columnCount * rowCount;
        this.itemList = new ArrayList(this.itemCount);
        this.gridLayout.removeAllViews();
        this.gridLayout.setRowCount(rowCount);
        this.gridLayout.setColumnCount(columnCount);
        for (int i = 0; i < this.itemCount; i++) {
            TextView itemTextView = new TextView(getContext());
            itemTextView.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(Integer.MIN_VALUE, 1.0f), GridLayout.spec(Integer.MIN_VALUE, 1.0f)));
            itemTextView.setGravity(17);
            itemTextView.setOnTouchListener(this.itemOnTouchListener);
            itemTextView.setTextSize(2, 16.0f);
            itemTextView.setBackgroundColor(this.backgroundWhiteColor);
            itemTextView.setTextColor(this.textColorBlack);
            this.itemList.add(itemTextView);
            this.gridLayout.addView(itemTextView);
        }
        ((IEvenNumbersPresenter) this.presenter).startTraining();
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

    public void setBoardItems(@NonNull List<NumberWrapper> itemsData) {
        for (int i = 0; i < this.itemCount; i++) {
            this.itemList.get(i).setText(itemsData.get(i).getNumber());
            this.itemList.get(i).setBackgroundColor(this.backgroundWhiteColor);
            this.itemList.get(i).setTextColor(this.textColorBlack);
            this.itemList.get(i).setEnabled(true);
        }
        this.itemsAlphaAnimator.start();
    }

    public void setBoardItemsEnable(boolean enable) {
        for (TextView itemView : this.itemList) {
            itemView.setEnabled(enable);
        }
    }

    public void itemTouchDown(int itemIndex, boolean isTrueAnswer) {
        TextView itemTextView = this.itemList.get(itemIndex);
        if (isTrueAnswer) {
            itemTextView.setBackgroundColor(this.greenColor);
            itemTextView.setTextColor(this.textColorWhite);
            return;
        }
        itemTextView.setBackgroundColor(this.redColor);
        itemTextView.setTextColor(this.textColorWhite);
    }

    public void itemTouchUp(int itemIndex, boolean isTrueAnswer) {
        TextView itemTextView = this.itemList.get(itemIndex);
        if (isTrueAnswer) {
            itemTextView.setEnabled(false);
            return;
        }
        itemTextView.setBackgroundColor(this.backgroundWhiteColor);
        itemTextView.setTextColor(this.textColorBlack);
    }

    public void initProgressBar(int max) {
        this.progressBar.setMax(max);
    }

    public void updateProgressBar(int progress) {
        this.progressBar.setProgress(progress);
    }

    public void updateScore(int score) {
        this.scoreTextView.setText(getString(R.string.even_numbers_score, Integer.valueOf(score)));
    }

    public void updateRecord(int record) {
        this.recordTextView.setText(getString(R.string.even_numbers_best_score, Integer.valueOf(record)));
    }

    public void pauseAnimations() {
        ((IEvenNumbersPresenter) this.presenter).pauseTraining();
    }

    public void resumeAnimations() {
        ((IEvenNumbersPresenter) this.presenter).resumeTraining();
    }

    public void onDestroy() {
        super.onDestroy();
        ((IEvenNumbersPresenter) this.presenter).cancelTraining();
        this.realmUtil.close();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
    }

    public void onEvenNumbersTrainingCompleted(int trainingResultId) {
        this.trainingCompleteListener.onEvenNumbersTrainingCompleted(trainingResultId);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof EvenNumbersTrainingCompleteListener) {
            this.trainingCompleteListener = (EvenNumbersTrainingCompleteListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement EvenNumbersTrainingCompleteListener");
    }

    public void onDetach() {
        super.onDetach();
        this.trainingCompleteListener = null;
    }
}
