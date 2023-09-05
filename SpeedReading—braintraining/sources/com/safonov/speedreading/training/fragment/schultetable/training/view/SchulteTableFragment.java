package com.safonov.speedreading.training.fragment.schultetable.training.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.p003v7.widget.GridLayout;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.application.util.timeticker.TimeTickerConverterUtil;
import com.safonov.speedreading.training.activity.view.IAnimatedFragment;
import com.safonov.speedreading.training.fragment.schultetable.repository.SchulteTableRealmUtil;
import com.safonov.speedreading.training.fragment.schultetable.training.model.SchulteTableModel;
import com.safonov.speedreading.training.fragment.schultetable.training.presenter.ISchulteTablePresenter;
import com.safonov.speedreading.training.fragment.schultetable.training.presenter.SchulteTablePresenter;
import com.speedreading.alexander.speedreading.R;
import java.util.ArrayList;
import java.util.List;

public class SchulteTableFragment extends MvpFragment<ISchulteTableView, ISchulteTablePresenter> implements ISchulteTableView, IAnimatedFragment {
    private static final int BIG_BOARD_ITEM_TEXT_SIZE_SP = 26;
    public static final String NON_INITIALIZATION_VALUE = "-";
    private static final int SMALL_BOARD_ITEM_TEXT_SIZE_SP = 36;
    private static final String TRAINING_CONFIG_ID_PARAM = "config_id";
    @BindColor(2131099679)
    int backgroundWhiteColor;
    @BindView(2131296639)
    TextView bestTimeTextView;
    private int configId;
    @BindColor(2131099674)
    int greenColor;
    @BindView(2131296640)
    GridLayout gridLayout;
    private int itemCount;
    private List<TextView> itemList;
    @BindDimen(2131165350)
    int itemMargin;
    private View.OnTouchListener itemOnTouchListener = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent event) {
            switch (event.getActionMasked()) {
                case 0:
                    ((ISchulteTablePresenter) SchulteTableFragment.this.presenter).onItemTouchDown(SchulteTableFragment.this.getItemIndex(view));
                    return true;
                case 1:
                case 3:
                    ((ISchulteTablePresenter) SchulteTableFragment.this.presenter).onItemTouchUp(SchulteTableFragment.this.getItemIndex(view));
                    return false;
                default:
                    return false;
            }
        }
    };
    @BindView(2131296641)
    TextView nextItemTextView;
    @BindColor(2131099757)
    int redColor;
    private SchulteTableModel schulteTableModel;
    private SchulteTableRealmUtil schulteTableRealmUtil;
    @BindView(2131296642)
    View statisticsPanel;
    @BindColor(2131099764)
    int tableEdgeColor;
    @BindColor(17170435)
    int textColorBlack;
    @BindColor(17170443)
    int textColorWhite;
    @BindView(2131296647)
    TextView timeTextView;
    private SchulteTableTrainingCompleteListener trainingFragmentListener;
    private Unbinder unbinder;

    @NonNull
    public ISchulteTablePresenter createPresenter() {
        this.schulteTableRealmUtil = new SchulteTableRealmUtil(App.get().getSchulteTableRealm());
        this.schulteTableModel = new SchulteTableModel();
        return new SchulteTablePresenter(this.schulteTableModel, this.schulteTableRealmUtil);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.configId = getArguments().getInt(TRAINING_CONFIG_ID_PARAM);
        }
    }

    public static SchulteTableFragment newInstance(int configId2) {
        SchulteTableFragment fragment = new SchulteTableFragment();
        Bundle args = new Bundle();
        args.putInt(TRAINING_CONFIG_ID_PARAM, configId2);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.schulte_table_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((ISchulteTablePresenter) this.presenter).init(this.configId);
    }

    public void pauseAnimations() {
        ((ISchulteTablePresenter) this.presenter).pauseTraining();
    }

    public void resumeAnimations() {
        ((ISchulteTablePresenter) this.presenter).resumeTraining();
    }

    public void initBoard(int rowCount, int columnCount, boolean isFullscreen) {
        this.itemCount = rowCount * columnCount;
        if (isFullscreen) {
            this.statisticsPanel.setVisibility(8);
        }
        initGridLayout(rowCount, columnCount, isFullscreen);
    }

    private void initGridLayout(int rowCount, int columnCount, boolean isFullScreen) {
        int textSizeSp;
        this.gridLayout.removeAllViews();
        this.gridLayout.setBackgroundColor(this.tableEdgeColor);
        this.gridLayout.setRowCount(rowCount);
        this.gridLayout.setColumnCount(columnCount);
        if (isFullScreen) {
            ((ConstraintLayout.LayoutParams) this.gridLayout.getLayoutParams()).dimensionRatio = null;
        } else {
            ((ConstraintLayout.LayoutParams) this.gridLayout.getLayoutParams()).dimensionRatio = columnCount + ":" + rowCount;
        }
        if (rowCount > 6 || columnCount > 6) {
            textSizeSp = 26;
        } else {
            textSizeSp = 36;
        }
        this.itemList = new ArrayList(rowCount * columnCount);
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                TextView item = new TextView(getContext());
                GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(GridLayout.spec(Integer.MIN_VALUE, 1.0f), GridLayout.spec(Integer.MIN_VALUE, 1.0f));
                int topMargin = this.itemMargin;
                int bottomMargin = 0;
                int leftMargin = this.itemMargin;
                int rightMargin = 0;
                if (i == rowCount - 1) {
                    bottomMargin = this.itemMargin;
                }
                if (j == columnCount - 1) {
                    rightMargin = this.itemMargin;
                }
                layoutParams.setMargins(leftMargin, topMargin, rightMargin, bottomMargin);
                item.setLayoutParams(layoutParams);
                item.setGravity(17);
                item.setTextColor(this.textColorBlack);
                item.setTextSize(2, (float) textSizeSp);
                item.setBackgroundColor(this.backgroundWhiteColor);
                item.setOnTouchListener(this.itemOnTouchListener);
                this.itemList.add(item);
                this.gridLayout.addView(item);
            }
        }
        ((ISchulteTablePresenter) this.presenter).startTraining();
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

    public void setBoardItems(@NonNull List<String> itemsData) {
        for (int i = 0; i < this.itemCount; i++) {
            this.itemList.get(i).setText(itemsData.get(i));
        }
    }

    public void setBoardItemsEnable(boolean enable) {
        for (TextView itemView : this.itemList) {
            itemView.setEnabled(enable);
        }
    }

    public void updateCurrentTimeView(long time) {
        this.timeTextView.setText(getString(R.string.schulte_table_time, TimeTickerConverterUtil.formatToSeconds(time)));
    }

    public void updateBestTimeView(long time) {
        this.bestTimeTextView.setText(getString(R.string.schulte_table_best_time, time == 0 ? NON_INITIALIZATION_VALUE : TimeTickerConverterUtil.formatToSeconds(time)));
    }

    public void updateNextItemView(String nextItem) {
        this.nextItemTextView.setText(getString(R.string.schulte_table_next_item, nextItem));
    }

    public void itemTouchDown(int itemIndex, boolean isTrueAnswer) {
        TextView itemView = this.itemList.get(itemIndex);
        if (isTrueAnswer) {
            itemView.setBackgroundColor(this.greenColor);
            itemView.setTextColor(this.textColorWhite);
            return;
        }
        itemView.setBackgroundColor(this.redColor);
        itemView.setTextColor(this.textColorWhite);
    }

    public void itemTouchUp(int itemIndex, boolean isTrueAnswer) {
        TextView itemView = this.itemList.get(itemIndex);
        itemView.setBackgroundColor(this.backgroundWhiteColor);
        itemView.setTextColor(this.textColorBlack);
    }

    public void onDestroy() {
        super.onDestroy();
        ((ISchulteTablePresenter) this.presenter).cancelTraining();
        this.schulteTableRealmUtil.close();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
    }

    public void onSchulteTableTrainingCompleted(int trainingResultId) {
        this.trainingFragmentListener.onSchulteTableTrainingCompleted(trainingResultId);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SchulteTableTrainingCompleteListener) {
            this.trainingFragmentListener = (SchulteTableTrainingCompleteListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement SchulteTableTrainingCompleteListener");
    }

    public void onDetach() {
        super.onDetach();
        this.trainingFragmentListener = null;
    }
}
