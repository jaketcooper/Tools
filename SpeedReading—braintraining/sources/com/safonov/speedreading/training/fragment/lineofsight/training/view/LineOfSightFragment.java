package com.safonov.speedreading.training.fragment.lineofsight.training.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
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
import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.training.activity.view.IAnimatedFragment;
import com.safonov.speedreading.training.fragment.lineofsight.repository.LineOfSightRealmUtil;
import com.safonov.speedreading.training.fragment.lineofsight.training.model.LineOfSightModel;
import com.safonov.speedreading.training.fragment.lineofsight.training.presenter.ILineOfSightPresenter;
import com.safonov.speedreading.training.fragment.lineofsight.training.presenter.LineOfSightPresenter;
import com.speedreading.alexander.speedreading.R;
import java.util.ArrayList;
import java.util.List;

public class LineOfSightFragment extends MvpFragment<ILineOfSightView, ILineOfSightPresenter> implements ILineOfSightView, IAnimatedFragment {
    public static final int FIELD_TYPE_0_ITEM_COUNT = 4;
    public static final int FIELD_TYPE_1_ITEM_COUNT = 8;
    private static final int ITEM_TEXT_SIZE_SP = 30;
    private static final int PRE_SHOW_DELAY_DURATION = 2000;
    private static final String TRAINING_CONFIG_ID_PARAM = "config_id";
    @BindColor(2131099679)
    int backgroundWhiteColor;
    @BindDimen(2131165322)
    int boardItemHeight;
    @BindDimen(2131165323)
    int boardWidth;
    @BindView(2131296477)
    Button checkButton;
    /* access modifiers changed from: private */
    public int[] checkedItemIndexes;
    private int configId;
    @BindColor(2131099674)
    int greenColor;
    @BindView(2131296478)
    GridLayout gridLayout;
    private int itemCount;
    /* access modifiers changed from: private */
    public List<TextView> itemList;
    private LineOfSightModel lineOfSightModel;
    private LineOfSightRealmUtil lineOfSightRealmUtil;
    private ValueAnimator preShowAnimator;
    @BindView(2131296480)
    ProgressBar progressBar;
    @BindColor(17170435)
    int textColorBlack;
    private LineOfSightTrainingCompleteListener trainingCompleteListener;
    private Unbinder unbinder;
    @BindColor(2131099777)
    int white;

    @NonNull
    public ILineOfSightPresenter createPresenter() {
        this.lineOfSightRealmUtil = new LineOfSightRealmUtil(((App) getActivity().getApplication()).getLineOfSightRealm());
        this.lineOfSightModel = new LineOfSightModel(getContext());
        return new LineOfSightPresenter(this.lineOfSightModel, this.lineOfSightRealmUtil);
    }

    public static LineOfSightFragment newInstance(int configId2) {
        LineOfSightFragment fragment = new LineOfSightFragment();
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
        View view = inflater.inflate(R.layout.line_of_sight_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        this.preShowAnimator = ValueAnimator.ofInt(new int[]{this.backgroundWhiteColor, this.greenColor});
        this.preShowAnimator.setEvaluator(new ArgbEvaluator());
        this.preShowAnimator.setDuration(2000);
        this.preShowAnimator.setRepeatCount(1);
        this.preShowAnimator.setRepeatMode(2);
        this.preShowAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                int backgroundColor = ((Integer) animation.getAnimatedValue()).intValue();
                for (int itemIndex : LineOfSightFragment.this.checkedItemIndexes) {
                    ((TextView) LineOfSightFragment.this.itemList.get(itemIndex)).setBackgroundColor(backgroundColor);
                }
            }
        });
        this.preShowAnimator.addListener(new AnimatorListenerAdapter() {
            private boolean isCanceled;

            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                this.isCanceled = false;
            }

            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                this.isCanceled = true;
            }

            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (!this.isCanceled) {
                    ((ILineOfSightPresenter) LineOfSightFragment.this.presenter).onPreShowAnimationCompleted();
                }
            }
        });
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((ILineOfSightPresenter) this.presenter).init(this.configId);
    }

    public void onDestroy() {
        super.onDestroy();
        this.preShowAnimator.cancel();
        this.preShowAnimator = null;
        this.lineOfSightRealmUtil.close();
        this.lineOfSightRealmUtil = null;
        this.lineOfSightModel = null;
        ((ILineOfSightPresenter) this.presenter).cancelTraining();
        this.presenter = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
        this.unbinder = null;
    }

    private void initGridLayout(int rowCount, int columnCount) {
        this.gridLayout.removeAllViews();
        this.gridLayout.setRowCount(rowCount);
        this.gridLayout.setColumnCount(columnCount);
        int itemHeight = this.boardItemHeight;
        int itemWidth = this.boardWidth / columnCount;
        this.itemList = new ArrayList(rowCount * columnCount);
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                TextView item = new TextView(getContext());
                item.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(i, 1), GridLayout.spec(j, 1)));
                item.getLayoutParams().height = itemHeight;
                item.getLayoutParams().width = itemWidth;
                item.setGravity(17);
                item.setTextColor(this.textColorBlack);
                item.setTextSize(2, 30.0f);
                item.setBackgroundColor(this.backgroundWhiteColor);
                this.itemList.add(item);
                this.gridLayout.addView(item);
            }
        }
    }

    @OnClick({2131296477})
    public void onCheckButtonClick() {
        ((ILineOfSightPresenter) this.presenter).onCheckButtonPressed();
    }

    public void initProgressBar(int max) {
        this.progressBar.setMax(max);
    }

    public void updateProgressBar(int progress) {
        this.progressBar.setProgress(progress);
    }

    public void startPreShowAnimation() {
        this.preShowAnimator.start();
    }

    public void cancelPreShowAnimation() {
        this.preShowAnimator.cancel();
    }

    public void setCheckButtonEnabled(boolean isEnabled) {
        this.checkButton.setEnabled(isEnabled);
    }

    public void initBoardView(int rowCount, int columnCount, int fieldType) {
        this.itemCount = rowCount * columnCount;
        if (fieldType == 0) {
            this.checkedItemIndexes = new int[]{columnCount / 2, (rowCount / 2) * columnCount, (((rowCount / 2) * columnCount) + columnCount) - 1, ((columnCount * rowCount) - (columnCount / 2)) - 1};
        } else if (fieldType == 1) {
            this.checkedItemIndexes = new int[]{0, columnCount / 2, columnCount - 1, (rowCount / 2) * columnCount, (((rowCount / 2) * columnCount) + columnCount) - 1, (rowCount * columnCount) - columnCount, ((columnCount * rowCount) - (columnCount / 2)) - 1, (rowCount * columnCount) - 1};
        }
        initGridLayout(rowCount, columnCount);
        ((ILineOfSightPresenter) this.presenter).startTraining();
    }

    public void setItemsData(@NonNull List<String> itemsData) {
        for (int i = 0; i < this.itemCount; i++) {
            this.itemList.get(i).setText(itemsData.get(i));
        }
    }

    public void setCheckedItemsData(@NonNull List<String> checkedItemsData) {
        for (int i = 0; i < this.checkedItemIndexes.length; i++) {
            this.itemList.get(this.checkedItemIndexes[i]).setText(checkedItemsData.get(i));
        }
    }

    public void pauseAnimations() {
        ((ILineOfSightPresenter) this.presenter).pauseTraining();
    }

    public void resumeAnimations() {
        ((ILineOfSightPresenter) this.presenter).resumeTraining();
    }

    public void onLineOfSightTrainingCompleted(int trainingResultId) {
        this.trainingCompleteListener.onLineOfSightTrainingCompleted(trainingResultId);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof LineOfSightTrainingCompleteListener) {
            this.trainingCompleteListener = (LineOfSightTrainingCompleteListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement LineOfSightTrainingCompleteListener");
    }

    public void onDetach() {
        super.onDetach();
        this.trainingCompleteListener = null;
    }
}
