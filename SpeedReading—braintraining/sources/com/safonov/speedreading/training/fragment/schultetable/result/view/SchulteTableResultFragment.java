package com.safonov.speedreading.training.fragment.schultetable.result.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.safonov.speedreading.application.util.timeticker.TimeTickerConverterUtil;
import com.safonov.speedreading.training.fragment.schultetable.repository.SchulteTableRealmUtil;
import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableResult;
import com.safonov.speedreading.training.fragment.schultetable.result.presenter.ISchulteTableResultPresenter;
import com.safonov.speedreading.training.fragment.schultetable.result.presenter.SchulteTableResultPresenter;
import com.speedreading.alexander.speedreading.R;
import java.util.ArrayList;
import java.util.List;

public class SchulteTableResultFragment extends MvpFragment<ISchulteTableResultView, ISchulteTableResultPresenter> implements ISchulteTableResultView {
    private static final String TRAINING_RESULT_ID_PARAM = "training_result_id";
    @BindView(2131296643)
    TextView bestTimeTextView;
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
    @BindView(2131296644)
    LineChart lineChart;
    @BindView(2131296645)
    ImageView newBestTimeView;
    private SchulteTableRealmUtil schulteTableRealmUtil;
    @BindView(2131296646)
    TextView timeTextView;
    @BindString(2131624300)
    String timeTitle;
    private int trainingResultId;
    private Unbinder unbinder;

    @NonNull
    public ISchulteTableResultPresenter createPresenter() {
        this.schulteTableRealmUtil = new SchulteTableRealmUtil(App.get().getSchulteTableRealm());
        return new SchulteTableResultPresenter(this.schulteTableRealmUtil);
    }

    public static SchulteTableResultFragment newInstance(int resultId) {
        SchulteTableResultFragment fragment = new SchulteTableResultFragment();
        Bundle args = new Bundle();
        args.putInt(TRAINING_RESULT_ID_PARAM, resultId);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.trainingResultId = getArguments().getInt(TRAINING_RESULT_ID_PARAM);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.schulte_table_result_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((ISchulteTableResultPresenter) this.presenter).initTrainingResults(this.trainingResultId);
    }

    public void updateTimeView(long time) {
        this.timeTextView.setText(TimeTickerConverterUtil.formatToSeconds(time));
    }

    public void updateBestTimeView(long time) {
        this.bestTimeTextView.setText(TimeTickerConverterUtil.formatToSeconds(time));
    }

    public void setNewBestTimeViewVisibility(boolean isVisible) {
        this.newBestTimeView.setVisibility(isVisible ? 0 : 4);
    }

    public void setData(List<SchulteTableResult> schulteTableResultList) {
        List<Entry> chartEntryList = new ArrayList<>();
        for (int i = 0; i < schulteTableResultList.size(); i++) {
            chartEntryList.add(new Entry((float) i, (float) schulteTableResultList.get(i).getTime()));
        }
        LineDataSet dataSet = new LineDataSet(chartEntryList, this.timeTitle);
        dataSet.setColor(this.chartLineColor);
        dataSet.setMode(LineDataSet.Mode.LINEAR);
        dataSet.setLineWidth((float) this.chartLineWidthDp);
        dataSet.setValueTextSize((float) this.chartItemValueTextSizeDp);
        dataSet.setValueFormatter(new IValueFormatter() {
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return TimeTickerConverterUtil.formatToSeconds((long) value);
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
        this.schulteTableRealmUtil.close();
        this.schulteTableRealmUtil = null;
        this.presenter = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
        this.unbinder = null;
    }
}
