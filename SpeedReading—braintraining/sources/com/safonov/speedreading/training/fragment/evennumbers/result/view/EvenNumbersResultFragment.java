package com.safonov.speedreading.training.fragment.evennumbers.result.view;

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
import com.safonov.speedreading.training.fragment.evennumbers.repository.EvenNumbersRealmUtil;
import com.safonov.speedreading.training.fragment.evennumbers.repository.entity.EvenNumbersResult;
import com.safonov.speedreading.training.fragment.evennumbers.result.presenter.EvenNumbersResultPresenter;
import com.safonov.speedreading.training.fragment.evennumbers.result.presenter.IEvenNumbersResultPresenter;
import com.speedreading.alexander.speedreading.R;
import java.util.ArrayList;
import java.util.List;

public class EvenNumbersResultFragment extends MvpFragment<IEvenNumbersResultView, IEvenNumbersResultPresenter> implements IEvenNumbersResultView {
    private static final String TRAINING_RESULT_ID_PARAM = "training_result_id";
    @BindView(2131296310)
    TextView bestScoreTextView;
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
    private EvenNumbersRealmUtil evenNumbersRealmUtil;
    @BindView(2131296394)
    LineChart lineChart;
    @BindView(2131296538)
    ImageView newBestScoreView;
    private int resultId;
    @BindView(2131296629)
    TextView scoreTextView;
    @BindString(2131624364)
    String scoreTitle;
    private Unbinder unbinder;

    @NonNull
    public IEvenNumbersResultPresenter createPresenter() {
        this.evenNumbersRealmUtil = new EvenNumbersRealmUtil(((App) getActivity().getApplication()).getEvenNumbersRealm());
        return new EvenNumbersResultPresenter(this.evenNumbersRealmUtil);
    }

    public static EvenNumbersResultFragment newInstance(int resultId2) {
        EvenNumbersResultFragment fragment = new EvenNumbersResultFragment();
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
        View view = inflater.inflate(R.layout.even_numbers_result_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((IEvenNumbersResultPresenter) this.presenter).initTrainingResults(this.resultId);
    }

    public void updateScoreView(int score) {
        this.scoreTextView.setText(String.valueOf(score));
    }

    public void updateBestScoreView(int score) {
        this.bestScoreTextView.setText(String.valueOf(score));
    }

    public void setNewBestScoreViewVisibility(boolean isVisible) {
        this.newBestScoreView.setVisibility(isVisible ? 0 : 4);
    }

    public void setChartViewData(List<EvenNumbersResult> evenNumbersResultList) {
        List<Entry> chartEntryList = new ArrayList<>();
        for (int i = 0; i < evenNumbersResultList.size(); i++) {
            chartEntryList.add(new Entry((float) i, (float) evenNumbersResultList.get(i).getScore()));
        }
        LineDataSet dataSet = new LineDataSet(chartEntryList, this.scoreTitle);
        dataSet.setColor(this.chartLineColor);
        dataSet.setMode(LineDataSet.Mode.LINEAR);
        dataSet.setLineWidth((float) this.chartLineWidthDp);
        dataSet.setValueTextSize((float) this.chartItemValueTextSizeDp);
        dataSet.setDrawCircleHole(false);
        dataSet.setCircleColor(this.chartItemColor);
        dataSet.setCircleRadius((float) this.chartItemCircleRadiusDp);
        dataSet.setHighlightEnabled(false);
        dataSet.setValueFormatter(new IValueFormatter() {
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return String.valueOf((int) value);
            }
        });
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
        this.evenNumbersRealmUtil.close();
        this.evenNumbersRealmUtil = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
        this.unbinder = null;
    }
}
