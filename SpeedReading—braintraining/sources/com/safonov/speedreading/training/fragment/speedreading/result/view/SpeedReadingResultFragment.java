package com.safonov.speedreading.training.fragment.speedreading.result.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindColor;
import butterknife.BindInt;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.training.fragment.speedreading.repository.SpeedReadingRealmUtil;
import com.safonov.speedreading.training.fragment.speedreading.repository.entity.SpeedReadingResult;
import com.safonov.speedreading.training.fragment.speedreading.result.presenter.ISpeedReadingResultPresenter;
import com.safonov.speedreading.training.fragment.speedreading.result.presenter.SpeedReadingResultPresenter;
import com.speedreading.alexander.speedreading.R;
import java.util.ArrayList;
import java.util.List;

public class SpeedReadingResultFragment extends MvpFragment<ISpeedReadingResultView, ISpeedReadingResultPresenter> implements ISpeedReadingResultView {
    private static final String TRAINING_RESULT_ID_PARAM = "result_id";
    @BindColor(2131099759)
    int averageSpeedItemColor;
    @BindColor(2131099761)
    int averageSpeedLineColor;
    @BindView(2131296304)
    TextView averageSpeedTextView;
    @BindString(2131624339)
    String averageSpeedTitle;
    @BindView(2131296307)
    TextView bestAverageSpeedTextView;
    @BindView(2131296308)
    TextView bestMaxSpeedTextView;
    @BindInt(2131361805)
    int chartItemCircleRadiusDp;
    @BindInt(2131361806)
    int chartItemValueTextSizeDp;
    @BindInt(2131361807)
    int chartLineWidthDp;
    @BindView(2131296698)
    LineChart lineChart;
    @BindColor(2131099758)
    int maxSpeedItemColor;
    @BindColor(2131099760)
    int maxSpeedLineColor;
    @BindView(2131296515)
    TextView maxSpeedTextView;
    @BindString(2131624342)
    String maxSpeedTitle;
    private int resultId;
    private SpeedReadingRealmUtil speedReadingRealmUtil;
    private Unbinder unbinder;

    @NonNull
    public ISpeedReadingResultPresenter createPresenter() {
        this.speedReadingRealmUtil = new SpeedReadingRealmUtil(((App) getActivity().getApplication()).getSpeedReadingRealm());
        return new SpeedReadingResultPresenter(this.speedReadingRealmUtil);
    }

    public static SpeedReadingResultFragment newInstance(int resultId2) {
        SpeedReadingResultFragment fragment = new SpeedReadingResultFragment();
        Bundle args = new Bundle();
        args.putInt(TRAINING_RESULT_ID_PARAM, resultId2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.resultId = getArguments().getInt(TRAINING_RESULT_ID_PARAM);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.speed_reading_result_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((ISpeedReadingResultPresenter) this.presenter).initTrainingResults(this.resultId);
    }

    public void updateMaxSpeedView(int speed) {
        this.maxSpeedTextView.setText(String.valueOf(speed));
    }

    public void updateBestMaxSpeedView(int speed) {
        this.bestMaxSpeedTextView.setText(String.valueOf(speed));
    }

    public void setNewBestMaxSpeedViewVisibility(boolean isVisible) {
        if (!isVisible) {
            this.maxSpeedTextView.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public void updateAverageSpeedView(int speed) {
        this.averageSpeedTextView.setText(String.valueOf(speed));
    }

    public void updateBestAverageSpeedView(int speed) {
        this.bestAverageSpeedTextView.setText(String.valueOf(speed));
    }

    public void setNewBestAverageSpeedViewVisibility(boolean isVisible) {
        if (!isVisible) {
            this.averageSpeedTextView.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public void setChartViewData(List<SpeedReadingResult> speedReadingResultList) {
        List<Entry> maxSpeedEntryList = new ArrayList<>();
        List<Entry> averageSpeedEntryList = new ArrayList<>();
        for (int i = 0; i < speedReadingResultList.size(); i++) {
            maxSpeedEntryList.add(new Entry((float) i, (float) speedReadingResultList.get(i).getMaxSpeed()));
            averageSpeedEntryList.add(new Entry((float) i, (float) speedReadingResultList.get(i).getAverageSpeed()));
        }
        LineDataSet maxSpeedDataSet = new LineDataSet(maxSpeedEntryList, this.maxSpeedTitle);
        maxSpeedDataSet.setColor(this.maxSpeedLineColor);
        maxSpeedDataSet.setMode(LineDataSet.Mode.LINEAR);
        maxSpeedDataSet.setLineWidth((float) this.chartLineWidthDp);
        maxSpeedDataSet.setValueTextSize((float) this.chartItemValueTextSizeDp);
        maxSpeedDataSet.setDrawCircleHole(false);
        maxSpeedDataSet.setCircleColor(this.maxSpeedItemColor);
        maxSpeedDataSet.setCircleRadius((float) this.chartItemCircleRadiusDp);
        maxSpeedDataSet.setHighlightEnabled(false);
        maxSpeedDataSet.setValueFormatter(new IValueFormatter() {
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return String.valueOf((int) value);
            }
        });
        LineDataSet averageSpeedDataSet = new LineDataSet(averageSpeedEntryList, this.averageSpeedTitle);
        averageSpeedDataSet.setColor(this.averageSpeedLineColor);
        averageSpeedDataSet.setMode(LineDataSet.Mode.LINEAR);
        averageSpeedDataSet.setLineWidth((float) this.chartLineWidthDp);
        averageSpeedDataSet.setValueTextSize((float) this.chartItemValueTextSizeDp);
        averageSpeedDataSet.setDrawCircleHole(false);
        averageSpeedDataSet.setCircleColor(this.averageSpeedItemColor);
        averageSpeedDataSet.setCircleRadius((float) this.chartItemCircleRadiusDp);
        averageSpeedDataSet.setHighlightEnabled(false);
        averageSpeedDataSet.setValueFormatter(new IValueFormatter() {
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return String.valueOf((int) value);
            }
        });
        List<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(maxSpeedDataSet);
        dataSets.add(averageSpeedDataSet);
        LineData data = new LineData(dataSets);
        XAxis xAxis = this.lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        xAxis.setGranularity(1.0f);
        YAxis leftAxis = this.lineChart.getAxisLeft();
        leftAxis.setDrawLabels(false);
        leftAxis.setDrawGridLines(true);
        YAxis rightAxis = this.lineChart.getAxisRight();
        rightAxis.setDrawLabels(false);
        rightAxis.setDrawGridLines(true);
        this.lineChart.setDescription((Description) null);
        this.lineChart.setData(data);
        this.lineChart.invalidate();
    }

    public void onDestroy() {
        super.onDestroy();
        this.speedReadingRealmUtil.close();
        this.speedReadingRealmUtil = null;
        this.presenter = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
        this.unbinder = null;
    }
}
