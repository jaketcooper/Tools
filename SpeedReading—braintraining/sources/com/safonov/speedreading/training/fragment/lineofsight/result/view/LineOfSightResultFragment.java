package com.safonov.speedreading.training.fragment.lineofsight.result.view;

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
import com.safonov.speedreading.training.fragment.lineofsight.repository.LineOfSightRealmUtil;
import com.safonov.speedreading.training.fragment.lineofsight.repository.entity.LineOfSightResult;
import com.safonov.speedreading.training.fragment.lineofsight.result.presenter.ILineOfSightResultPresenter;
import com.safonov.speedreading.training.fragment.lineofsight.result.presenter.LineOfSightResultPresenter;
import com.speedreading.alexander.speedreading.R;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LineOfSightResultFragment extends MvpFragment<ILineOfSightResultView, ILineOfSightResultPresenter> implements ILineOfSightResultView {
    private static final String TRAINING_RESULT_ID_PARAM = "training_result_id";
    @BindInt(2131361805)
    int chartItemCircleRadiusDp;
    @BindColor(2131099758)
    int chartItemColor;
    @BindInt(2131361806)
    int chartItemValueTextSizeDp;
    @BindColor(2131099760)
    int chartLineColor;
    @BindInt(2131361807)
    int chartLineWidthDp;
    @BindView(2131296262)
    TextView foundMistakesPercentTextView;
    @BindString(2131624110)
    String foundMistakesPercentTitle;
    @BindView(2131296413)
    TextView foundMistakesTextView;
    @BindView(2131296475)
    LineChart lineChart;
    private LineOfSightRealmUtil lineOfSightRealmUtil;
    @BindView(2131296520)
    TextView mistakesTextView;
    /* access modifiers changed from: private */
    public NumberFormat numberFormat;
    private int resultId;
    private Unbinder unbinder;

    @NonNull
    public ILineOfSightResultPresenter createPresenter() {
        this.lineOfSightRealmUtil = new LineOfSightRealmUtil(((App) getActivity().getApplication()).getLineOfSightRealm());
        return new LineOfSightResultPresenter(this.lineOfSightRealmUtil);
    }

    public static LineOfSightResultFragment newInstance(int resultId2) {
        LineOfSightResultFragment fragment = new LineOfSightResultFragment();
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
        View view = inflater.inflate(R.layout.line_of_sight_result_fragment, container, false);
        this.numberFormat = NumberFormat.getPercentInstance(Locale.getDefault());
        this.numberFormat.setMaximumFractionDigits(1);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((ILineOfSightResultPresenter) this.presenter).initTrainingResults(this.resultId);
    }

    public void updateMistakesView(int mistakesCount) {
        this.mistakesTextView.setText(String.valueOf(mistakesCount));
    }

    public void updateFoundMistakesView(int mistakesCount) {
        this.foundMistakesTextView.setText(String.valueOf(mistakesCount));
    }

    public void updateFoundMistakesPercentView(float foundMistakesPercent) {
        this.foundMistakesPercentTextView.setText(this.numberFormat.format((double) foundMistakesPercent));
    }

    public void setChartViewData(List<LineOfSightResult> lineOfSightResultList) {
        List<Entry> chartEntryList = new ArrayList<>();
        for (int i = 0; i < lineOfSightResultList.size(); i++) {
            chartEntryList.add(new Entry((float) i, lineOfSightResultList.get(i).getFoundMistakesAccuracy()));
        }
        LineDataSet dataSet = new LineDataSet(chartEntryList, this.foundMistakesPercentTitle);
        dataSet.setColor(this.chartLineColor);
        dataSet.setMode(LineDataSet.Mode.LINEAR);
        dataSet.setLineWidth((float) this.chartLineWidthDp);
        dataSet.setValueTextSize((float) this.chartItemValueTextSizeDp);
        dataSet.setValueFormatter(new IValueFormatter() {
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return LineOfSightResultFragment.this.numberFormat.format((double) value);
            }
        });
        dataSet.setDrawCircleHole(false);
        dataSet.setCircleColor(this.chartItemColor);
        dataSet.setCircleRadius((float) this.chartItemCircleRadiusDp);
        dataSet.setHighlightEnabled(false);
        List<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSet);
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
        this.lineOfSightRealmUtil.close();
        this.lineOfSightRealmUtil = null;
        this.numberFormat = null;
        this.presenter = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
        this.unbinder = null;
    }
}
