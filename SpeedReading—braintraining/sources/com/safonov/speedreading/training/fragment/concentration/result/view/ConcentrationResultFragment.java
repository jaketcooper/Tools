package com.safonov.speedreading.training.fragment.concentration.result.view;

import android.os.Bundle;
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
import com.safonov.speedreading.training.fragment.concentration.repository.ConcentrationRealmUtil;
import com.safonov.speedreading.training.fragment.concentration.repository.entity.ConcentrationResult;
import com.safonov.speedreading.training.fragment.concentration.result.presenter.ConcentrationResultPresenter;
import com.safonov.speedreading.training.fragment.concentration.result.presenter.IConcentrationResultPresenter;
import com.speedreading.alexander.speedreading.R;
import java.util.ArrayList;
import java.util.List;

public class ConcentrationResultFragment extends MvpFragment<IConcentrationResultView, IConcentrationResultPresenter> implements IConcentrationResultView {
    private static final String TRAINING_RESULT_ID_PARAM = "training_result_id";
    @BindView(2131296343)
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
    private ConcentrationRealmUtil concentrationRealmUtil;
    @BindView(2131296350)
    LineChart lineChart;
    @BindView(2131296540)
    ImageView newBestScoreView;
    private int resultId;
    @BindView(2131296351)
    TextView scoreTextView;
    @BindString(2131624272)
    String scoreTitle;
    private Unbinder unbinder;

    public IConcentrationResultPresenter createPresenter() {
        this.concentrationRealmUtil = new ConcentrationRealmUtil(((App) getActivity().getApplication()).getConcentrationRealm());
        return new ConcentrationResultPresenter(this.concentrationRealmUtil);
    }

    public static ConcentrationResultFragment newInstance(int resultId2) {
        ConcentrationResultFragment fragment = new ConcentrationResultFragment();
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
        View view = inflater.inflate(R.layout.concentration_result_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((IConcentrationResultPresenter) this.presenter).initTrainingResults(this.resultId);
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

    public void setChartViewData(List<ConcentrationResult> wordPairsResultList) {
        List<Entry> chartEntryList = new ArrayList<>();
        for (int i = 0; i < wordPairsResultList.size(); i++) {
            chartEntryList.add(new Entry((float) i, (float) wordPairsResultList.get(i).getScore()));
        }
        LineDataSet dataSet = new LineDataSet(chartEntryList, this.scoreTitle);
        dataSet.setColor(this.chartLineColor);
        dataSet.setMode(LineDataSet.Mode.LINEAR);
        dataSet.setLineWidth((float) this.chartLineWidthDp);
        dataSet.setValueTextSize((float) this.chartItemValueTextSizeDp);
        dataSet.setValueFormatter(new IValueFormatter() {
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return String.valueOf((int) value);
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
        this.concentrationRealmUtil.close();
        this.concentrationRealmUtil = null;
        this.presenter = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
        this.unbinder = null;
    }
}
