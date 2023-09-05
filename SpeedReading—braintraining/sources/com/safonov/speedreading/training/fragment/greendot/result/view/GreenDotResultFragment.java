package com.safonov.speedreading.training.fragment.greendot.result.view;

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
import com.safonov.speedreading.training.fragment.greendot.repository.GreenDotRealmUtil;
import com.safonov.speedreading.training.fragment.greendot.repository.entity.GreenDotResult;
import com.safonov.speedreading.training.fragment.greendot.result.presenter.GreenDotResultPresenter;
import com.safonov.speedreading.training.fragment.greendot.result.presenter.IGreenDotResultPresenter;
import com.safonov.speedreading.training.fragment.greendot.util.GreenDotTimeConverterUtil;
import com.speedreading.alexander.speedreading.R;
import java.util.ArrayList;
import java.util.List;

public class GreenDotResultFragment extends MvpFragment<IGreenDotResultView, IGreenDotResultPresenter> implements IGreenDotResultView {
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
    @BindView(2131296418)
    TextView durationTextView;
    @BindString(2131624073)
    String durationTitle;
    private GreenDotRealmUtil greenDotRealmUtil;
    @BindView(2131296420)
    LineChart lineChart;
    private int resultId;
    /* access modifiers changed from: private */
    public GreenDotTimeConverterUtil timeConverterUtil = new GreenDotTimeConverterUtil();
    private Unbinder unbinder;

    @NonNull
    public IGreenDotResultPresenter createPresenter() {
        this.greenDotRealmUtil = new GreenDotRealmUtil(((App) getActivity().getApplication()).getGreenDotRealm());
        return new GreenDotResultPresenter(this.greenDotRealmUtil);
    }

    public static GreenDotResultFragment newInstance(int resultId2) {
        GreenDotResultFragment fragment = new GreenDotResultFragment();
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
        View view = inflater.inflate(R.layout.green_dot_result_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((IGreenDotResultPresenter) this.presenter).initTrainingResults(this.resultId);
    }

    public void updateTrainingDurationView(long duration) {
        this.durationTextView.setText(this.timeConverterUtil.format(duration));
    }

    public void setChartViewData(List<GreenDotResult> greenDotResultList) {
        List<Entry> chartEntryList = new ArrayList<>();
        for (int i = 0; i < greenDotResultList.size(); i++) {
            chartEntryList.add(new Entry((float) i, (float) greenDotResultList.get(i).getConfig().getDuration()));
        }
        LineDataSet dataSet = new LineDataSet(chartEntryList, this.durationTitle);
        dataSet.setColor(this.chartLineColor);
        dataSet.setMode(LineDataSet.Mode.LINEAR);
        dataSet.setLineWidth((float) this.chartLineWidthDp);
        dataSet.setValueTextSize((float) this.chartItemValueTextSizeDp);
        dataSet.setValueFormatter(new IValueFormatter() {
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return GreenDotResultFragment.this.timeConverterUtil.format((long) value);
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
        this.timeConverterUtil = null;
        this.greenDotRealmUtil.close();
        this.greenDotRealmUtil = null;
        this.presenter = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
        this.unbinder = null;
    }
}
