package com.safonov.speedreading.training.fragment.passcource.result.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.p003v7.widget.DividerItemDecoration;
import android.support.p003v7.widget.LinearLayoutManager;
import android.support.p003v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindColor;
import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
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
import com.safonov.speedreading.training.fragment.evennumbers.repository.EvenNumbersRealmUtil;
import com.safonov.speedreading.training.fragment.evennumbers.repository.entity.EvenNumbersResult;
import com.safonov.speedreading.training.fragment.greendot.repository.GreenDotRealmUtil;
import com.safonov.speedreading.training.fragment.greendot.repository.entity.GreenDotResult;
import com.safonov.speedreading.training.fragment.greendot.util.GreenDotTimeConverterUtil;
import com.safonov.speedreading.training.fragment.lineofsight.repository.LineOfSightRealmUtil;
import com.safonov.speedreading.training.fragment.lineofsight.repository.entity.LineOfSightResult;
import com.safonov.speedreading.training.fragment.passcource.repository.PassCourseRealmUtil;
import com.safonov.speedreading.training.fragment.passcource.repository.etity.PassCourseResult;
import com.safonov.speedreading.training.fragment.passcource.result.presenter.IPassCourseResultPresenter;
import com.safonov.speedreading.training.fragment.passcource.result.presenter.PassCourseResultPresenter;
import com.safonov.speedreading.training.fragment.passcource.util.EvenNumbersScoreUtil;
import com.safonov.speedreading.training.fragment.passcource.util.GreenDotScoreUtil;
import com.safonov.speedreading.training.fragment.passcource.util.LineOfSightScoreUtil;
import com.safonov.speedreading.training.fragment.passcource.util.RememberNumberScoreUtil;
import com.safonov.speedreading.training.fragment.passcource.util.SchulteTableScoreUtil;
import com.safonov.speedreading.training.fragment.passcource.util.SpeedReadingScoreUtil;
import com.safonov.speedreading.training.fragment.passcource.util.WordPairsScoreUtil;
import com.safonov.speedreading.training.fragment.remembernumber.repository.RememberNumberRealmUtil;
import com.safonov.speedreading.training.fragment.remembernumber.repository.entity.RememberNumberResult;
import com.safonov.speedreading.training.fragment.schultetable.repository.SchulteTableRealmUtil;
import com.safonov.speedreading.training.fragment.schultetable.repository.entity.SchulteTableResult;
import com.safonov.speedreading.training.fragment.speedreading.repository.SpeedReadingRealmUtil;
import com.safonov.speedreading.training.fragment.speedreading.repository.entity.SpeedReadingResult;
import com.safonov.speedreading.training.fragment.wordpairs.repository.WordPairsRealmUtil;
import com.safonov.speedreading.training.fragment.wordpairs.repository.entity.WordPairsResult;
import com.speedreading.alexander.speedreading.R;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PassCourseResultFragment extends MvpFragment<IPassCourseResultView, IPassCourseResultPresenter> implements IPassCourseResultView {
    private static final String PASS_COURSE_RESULT_ARRAY_PARAM = "pass_course_result_array";
    @BindColor(2131099758)
    int chartItem1Color;
    @BindColor(2131099759)
    int chartItem2Color;
    @BindInt(2131361805)
    int chartItemCircleRadiusDp;
    @BindInt(2131361806)
    int chartItemValueTextSizeDp;
    @BindColor(2131099760)
    int chartLine1Color;
    @BindColor(2131099761)
    int chartLine2Color;
    @BindInt(2131361807)
    int chartLineWidthDp;
    private EvenNumbersRealmUtil evenNumbersRealmUtil;
    private GreenDotRealmUtil greenDotRealmUtil;
    @BindView(2131296561)
    LinearLayout layout;
    private LineOfSightRealmUtil lineOfSightRealmUtil;
    private PassCourseRealmUtil passCourseRealmUtil;
    private ProgressDialog progressDialog;
    private RememberNumberRealmUtil rememberNumberRealmUtil;
    private int[] resultIds;
    private SchulteTableRealmUtil schulteTableRealmUtil;
    private SpeedReadingRealmUtil speedReadingRealmUtil;
    private Unbinder unbinder;
    private WordPairsRealmUtil wordPairsRealmUtil;

    class SchulteTableAdapter extends RecyclerView.Adapter<ViewHolder> {
        private List<SchulteTableResult> itemList;

        public class ViewHolder_ViewBinding implements Unbinder {
            private ViewHolder target;

            @UiThread
            public ViewHolder_ViewBinding(ViewHolder target2, View source) {
                this.target = target2;
                target2.titTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.title_text_view, "field 'titTextView'", TextView.class);
                target2.timeTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.time_text_view, "field 'timeTextView'", TextView.class);
                target2.passCourseScoreTextView = (TextView) Utils.findRequiredViewAsType(source, R.id.pass_course_score_text_view, "field 'passCourseScoreTextView'", TextView.class);
            }

            @CallSuper
            public void unbind() {
                ViewHolder target2 = this.target;
                if (target2 == null) {
                    throw new IllegalStateException("Bindings already cleared.");
                }
                this.target = null;
                target2.titTextView = null;
                target2.timeTextView = null;
                target2.passCourseScoreTextView = null;
            }
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            @BindView(2131296562)
            TextView passCourseScoreTextView;
            @BindView(2131296775)
            TextView timeTextView;
            @BindView(2131296780)
            TextView titTextView;

            ViewHolder(View view) {
                super(view);
                ButterKnife.bind((Object) this, view);
            }
        }

        SchulteTableAdapter(@NonNull List<SchulteTableResult> itemList2) {
            this.itemList = itemList2;
        }

        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pass_course_result_schulte_table_item, parent, false));
        }

        public void onBindViewHolder(ViewHolder holder, int position) {
            SchulteTableResult result = this.itemList.get(position);
            holder.timeTextView.setText(PassCourseResultFragment.this.getString(R.string.schulte_table_time, TimeTickerConverterUtil.formatToSeconds(result.getTime())));
            holder.titTextView.setText(PassCourseResultFragment.this.getString(R.string.pass_course_training_number, Integer.valueOf(position + 1)));
            holder.passCourseScoreTextView.setText(String.valueOf(SchulteTableScoreUtil.getPassCourseScore(result.getTime())));
        }

        public int getItemCount() {
            return this.itemList.size();
        }
    }

    @NonNull
    public IPassCourseResultPresenter createPresenter() {
        App app = (App) getActivity().getApplication();
        this.passCourseRealmUtil = new PassCourseRealmUtil(app.getPassCourseConfiguration());
        this.schulteTableRealmUtil = new SchulteTableRealmUtil(app.getSchulteTableRealm());
        this.rememberNumberRealmUtil = new RememberNumberRealmUtil(app.getRememberNumberRealm());
        this.lineOfSightRealmUtil = new LineOfSightRealmUtil(app.getLineOfSightRealm());
        this.evenNumbersRealmUtil = new EvenNumbersRealmUtil(app.getEvenNumbersRealm());
        this.wordPairsRealmUtil = new WordPairsRealmUtil(app.getWordPairsRealm());
        this.speedReadingRealmUtil = new SpeedReadingRealmUtil(app.getSpeedReadingRealm());
        this.greenDotRealmUtil = new GreenDotRealmUtil(app.getGreenDotRealm());
        return new PassCourseResultPresenter(this.passCourseRealmUtil, this.schulteTableRealmUtil, this.rememberNumberRealmUtil, this.lineOfSightRealmUtil, this.speedReadingRealmUtil, this.evenNumbersRealmUtil, this.wordPairsRealmUtil, this.greenDotRealmUtil);
    }

    public static PassCourseResultFragment newInstance(int[] resultIds2) {
        PassCourseResultFragment fragment = new PassCourseResultFragment();
        Bundle args = new Bundle();
        args.putIntArray(PASS_COURSE_RESULT_ARRAY_PARAM, resultIds2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.resultIds = getArguments().getIntArray(PASS_COURSE_RESULT_ARRAY_PARAM);
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pass_course_result, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((IPassCourseResultPresenter) this.presenter).init(this.resultIds);
    }

    public void addSchulteTableResultView(List<SchulteTableResult> resultList, List<SchulteTableResult> list) {
        View resultHolderView = LayoutInflater.from(getContext()).inflate(R.layout.pass_course_result_holder, this.layout, false);
        ((TextView) ButterKnife.findById(resultHolderView, (int) R.id.title_text_view)).setText(R.string.schulte_table);
        RecyclerView recyclerView = new RecyclerView(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), 1));
        recyclerView.setAdapter(new SchulteTableAdapter(resultList));
        ((LinearLayout) ButterKnife.findById(resultHolderView, (int) R.id.content_holder_linear_layout)).addView(recyclerView);
        this.layout.addView(resultHolderView);
    }

    public void addRememberNumberResultView(RememberNumberResult result, List<RememberNumberResult> list) {
        if (result != null) {
            View resultHolderView = LayoutInflater.from(getContext()).inflate(R.layout.pass_course_result_holder, this.layout, false);
            ((TextView) ButterKnife.findById(resultHolderView, (int) R.id.title_text_view)).setText(R.string.remember_number);
            LinearLayout itemHolderLayout = (LinearLayout) ButterKnife.findById(resultHolderView, (int) R.id.content_holder_linear_layout);
            View itemView = LayoutInflater.from(getContext()).inflate(R.layout.pass_course_result_remember_number_item, itemHolderLayout, false);
            ((TextView) ButterKnife.findById(itemView, (int) R.id.title_text_view)).setText(getString(R.string.pass_course_training_number, 1));
            ((TextView) ButterKnife.findById(itemView, (int) R.id.score_text_view)).setText(getString(R.string.remember_number_score, Integer.valueOf(result.getScore())));
            ((TextView) ButterKnife.findById(itemView, (int) R.id.pass_course_score_text_view)).setText(String.valueOf(RememberNumberScoreUtil.getPassCourseScore(result.getScore())));
            itemHolderLayout.addView(itemView);
            this.layout.addView(resultHolderView);
        }
    }

    public void addLineOfSightResultView(LineOfSightResult result, List<LineOfSightResult> list) {
        if (result != null) {
            View resultHolderView = LayoutInflater.from(getContext()).inflate(R.layout.pass_course_result_holder, this.layout, false);
            ((TextView) ButterKnife.findById(resultHolderView, (int) R.id.title_text_view)).setText(R.string.line_of_sight);
            LinearLayout itemHolderLayout = (LinearLayout) ButterKnife.findById(resultHolderView, (int) R.id.content_holder_linear_layout);
            View itemView = LayoutInflater.from(getContext()).inflate(R.layout.pass_course_result_line_of_sight_item, itemHolderLayout, false);
            NumberFormat numberFormat = NumberFormat.getPercentInstance(Locale.getDefault());
            numberFormat.setMaximumFractionDigits(1);
            ((TextView) ButterKnife.findById(itemView, (int) R.id.title_text_view)).setText(getString(R.string.pass_course_training_number, 1));
            ((TextView) ButterKnife.findById(itemView, (int) R.id.mistakes_text_view)).setText(getString(R.string.line_of_sight_pass_course_result_mistakes, Integer.valueOf(result.getMistakeCount())));
            ((TextView) ButterKnife.findById(itemView, (int) R.id.found_mistakes_text_view)).setText(getString(R.string.line_of_sight_pass_course_result_found_mistakes, Integer.valueOf(result.getFoundMistakeCount())));
            ((TextView) ButterKnife.findById(itemView, (int) R.id.accuracy_text_view)).setText(getString(R.string.line_of_sight_pass_course_result_accuracy, numberFormat.format((double) result.getFoundMistakesAccuracy())));
            ((TextView) ButterKnife.findById(itemView, (int) R.id.pass_course_score_text_view)).setText(String.valueOf(LineOfSightScoreUtil.getPassCourseScore(result.getMistakeCount(), result.getFoundMistakeCount())));
            itemHolderLayout.addView(itemView);
            this.layout.addView(resultHolderView);
        }
    }

    public void addSpeedReadingResultView(SpeedReadingResult result, List<SpeedReadingResult> list) {
        if (result != null) {
            View resultHolderView = LayoutInflater.from(getContext()).inflate(R.layout.pass_course_result_holder, this.layout, false);
            ((TextView) ButterKnife.findById(resultHolderView, (int) R.id.title_text_view)).setText(R.string.speed_reading);
            LinearLayout itemHolderLayout = (LinearLayout) ButterKnife.findById(resultHolderView, (int) R.id.content_holder_linear_layout);
            View itemView = LayoutInflater.from(getContext()).inflate(R.layout.pass_course_result_speed_reading_item, itemHolderLayout, false);
            ((TextView) ButterKnife.findById(itemView, (int) R.id.title_text_view)).setText(getString(R.string.pass_course_training_number, 1));
            ((TextView) ButterKnife.findById(itemView, (int) R.id.max_speed_text_view)).setText(getString(R.string.speed_reading_pass_course_result_max_speed, Integer.valueOf(result.getMaxSpeed())));
            ((TextView) ButterKnife.findById(itemView, (int) R.id.average_speed_text_view)).setText(getString(R.string.speed_reading_pass_course_result_average_speed, Integer.valueOf(result.getAverageSpeed())));
            ((TextView) ButterKnife.findById(itemView, (int) R.id.pass_course_score_text_view)).setText(String.valueOf(SpeedReadingScoreUtil.getPassCourseScore(result.getMaxSpeed())));
            itemHolderLayout.addView(itemView);
            this.layout.addView(resultHolderView);
        }
    }

    public void addWordPairsResultView(WordPairsResult result, List<WordPairsResult> list) {
        if (result != null) {
            View resultHolderView = LayoutInflater.from(getContext()).inflate(R.layout.pass_course_result_holder, this.layout, false);
            ((TextView) ButterKnife.findById(resultHolderView, (int) R.id.title_text_view)).setText(R.string.word_pairs);
            LinearLayout itemHolderLayout = (LinearLayout) ButterKnife.findById(resultHolderView, (int) R.id.content_holder_linear_layout);
            View itemView = LayoutInflater.from(getContext()).inflate(R.layout.pass_course_result_word_pairs_item, itemHolderLayout, false);
            ((TextView) ButterKnife.findById(itemView, (int) R.id.title_text_view)).setText(getString(R.string.pass_course_training_number, 1));
            ((TextView) ButterKnife.findById(itemView, (int) R.id.score_text_view)).setText(getString(R.string.word_pairs_score, Integer.valueOf(result.getScore())));
            ((TextView) ButterKnife.findById(itemView, (int) R.id.pass_course_score_text_view)).setText(String.valueOf(WordPairsScoreUtil.getPassCourseScore(result.getScore())));
            itemHolderLayout.addView(itemView);
            this.layout.addView(resultHolderView);
        }
    }

    public void addEvenNumbersResultView(EvenNumbersResult result, List<EvenNumbersResult> list) {
        if (result != null) {
            View resultHolderView = LayoutInflater.from(getContext()).inflate(R.layout.pass_course_result_holder, this.layout, false);
            ((TextView) ButterKnife.findById(resultHolderView, (int) R.id.title_text_view)).setText(R.string.even_numbers);
            LinearLayout itemHolderLayout = (LinearLayout) ButterKnife.findById(resultHolderView, (int) R.id.content_holder_linear_layout);
            View itemView = LayoutInflater.from(getContext()).inflate(R.layout.pass_course_result_even_numbers_item, itemHolderLayout, false);
            ((TextView) ButterKnife.findById(itemView, (int) R.id.title_text_view)).setText(getString(R.string.pass_course_training_number, 1));
            ((TextView) ButterKnife.findById(itemView, (int) R.id.score_text_view)).setText(getString(R.string.even_numbers_score, Integer.valueOf(result.getScore())));
            ((TextView) ButterKnife.findById(itemView, (int) R.id.pass_course_score_text_view)).setText(String.valueOf(EvenNumbersScoreUtil.getPassCourseScore(result.getScore())));
            itemHolderLayout.addView(itemView);
            this.layout.addView(resultHolderView);
        }
    }

    public void addGreenDotResultView(GreenDotResult result) {
        if (result != null) {
            View resultHolderView = LayoutInflater.from(getContext()).inflate(R.layout.pass_course_result_holder, this.layout, false);
            ((TextView) ButterKnife.findById(resultHolderView, (int) R.id.title_text_view)).setText(R.string.green_dot);
            LinearLayout itemHolderLayout = (LinearLayout) ButterKnife.findById(resultHolderView, (int) R.id.content_holder_linear_layout);
            View itemView = LayoutInflater.from(getContext()).inflate(R.layout.pass_course_result_green_dot_item, itemHolderLayout, false);
            long duration = result.getConfig().getDuration();
            String formattedDuration = new GreenDotTimeConverterUtil().format(duration);
            ((TextView) ButterKnife.findById(itemView, (int) R.id.title_text_view)).setText(getString(R.string.pass_course_training_number, 1));
            ((TextView) ButterKnife.findById(itemView, (int) R.id.duration_text_view)).setText(getString(R.string.green_dot_pass_course_result_duration, formattedDuration));
            ((TextView) ButterKnife.findById(itemView, (int) R.id.pass_course_score_text_view)).setText(String.valueOf(GreenDotScoreUtil.getPassCourseScore(duration)));
            itemHolderLayout.addView(itemView);
            ((LineChart) ButterKnife.findById(resultHolderView, (int) R.id.line_chart)).setVisibility(8);
            this.layout.addView(resultHolderView);
        }
    }

    public void addPassCourseResultView(PassCourseResult result, List<PassCourseResult> chartResultList) {
        if (result != null) {
            View resultHolderView = LayoutInflater.from(getContext()).inflate(R.layout.pass_course_result_holder, this.layout, false);
            ((TextView) ButterKnife.findById(resultHolderView, R.id.title_text_view)).setText(R.string.pass_course);
            LinearLayout itemHolderLayout = (LinearLayout) ButterKnife.findById(resultHolderView, R.id.content_holder_linear_layout);
            View itemView = LayoutInflater.from(getContext()).inflate(R.layout.pass_course_result_pass_course_item, itemHolderLayout, false);
            ((TextView) ButterKnife.findById(itemView, R.id.title_text_view)).setText(R.string.pass_course_result_t);
            ((TextView) ButterKnife.findById(itemView, R.id.pass_course_score_text_view)).setText(String.valueOf(String.valueOf(result.getScore())));
            itemHolderLayout.addView(itemView);
            LineChart lineChart = (LineChart) ButterKnife.findById(resultHolderView, R.id.line_chart);
            lineChart.setVisibility(0);
            List<Entry> chartEntryList = new ArrayList<>();
            for (int i = 0; i < chartResultList.size(); i++) {
                chartEntryList.add(new Entry((float) i, (float) chartResultList.get(i).getScore()));
            }
            LineDataSet dataSet = new LineDataSet(chartEntryList, getString(R.string.pass_course_score));
            dataSet.setColor(this.chartLine1Color);
            dataSet.setMode(LineDataSet.Mode.LINEAR);
            dataSet.setLineWidth((float) this.chartLineWidthDp);
            dataSet.setValueTextSize((float) this.chartItemValueTextSizeDp);
            dataSet.setDrawCircleHole(false);
            dataSet.setCircleColor(this.chartItem1Color);
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
            XAxis xAxis = lineChart.getXAxis();
            xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
            xAxis.setGranularity(1.0f);
            YAxis leftAxis = lineChart.getAxisLeft();
            leftAxis.setDrawLabels(false);
            leftAxis.setDrawGridLines(true);
            YAxis rightAxis = lineChart.getAxisRight();
            rightAxis.setDrawLabels(false);
            rightAxis.setDrawGridLines(true);
            lineChart.setDescription((Description) null);
            lineChart.setData(data);
            lineChart.invalidate();
            this.layout.addView(resultHolderView);
        }
    }

    public void showProgressDialog() {
        this.progressDialog = new ProgressDialog(getContext());
        this.progressDialog.setCancelable(false);
    }

    public void dismissProgressDialog() {
        this.progressDialog.dismiss();
    }

    public void onDestroy() {
        super.onDestroy();
        this.passCourseRealmUtil.close();
        this.schulteTableRealmUtil.close();
        this.rememberNumberRealmUtil.close();
        this.lineOfSightRealmUtil.close();
        this.speedReadingRealmUtil.close();
        this.wordPairsRealmUtil.close();
        this.evenNumbersRealmUtil.close();
        this.greenDotRealmUtil.close();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
    }
}
