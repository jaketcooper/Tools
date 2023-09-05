package com.safonov.speedreading.training.fragment.lineofsight.passcourseresult.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.training.fragment.lineofsight.passcourseresult.presenter.ILineOfSightPassCourseResultPresenter;
import com.safonov.speedreading.training.fragment.lineofsight.passcourseresult.presenter.LineOfSightPassCourseResultPresenter;
import com.safonov.speedreading.training.fragment.lineofsight.repository.LineOfSightRealmUtil;
import com.safonov.speedreading.training.fragment.passcource.CourseResultFragmentListener;
import com.speedreading.alexander.speedreading.R;
import java.text.NumberFormat;
import java.util.Locale;

public class LineOfSightPassCourseResultFragment extends MvpFragment<ILineOfSightPassCourseResultView, ILineOfSightPassCourseResultPresenter> implements ILineOfSightPassCourseResultView {
    private static final String TRAINING_RESULT_ID_PARAM = "training_result_id";
    @BindView(2131296262)
    TextView foundMistakesPercentTextView;
    @BindView(2131296413)
    TextView foundMistakesTextView;
    private CourseResultFragmentListener fragmentCompleteListener;
    private LineOfSightRealmUtil lineOfSightRealmUtil;
    @BindView(2131296520)
    TextView mistakesTextView;
    @BindView(2131296542)
    Button nextButton;
    private NumberFormat numberFormat;
    @BindView(2131296562)
    TextView passCourseScoreTextView;
    private int resultId;
    private Unbinder unbinder;

    @NonNull
    public ILineOfSightPassCourseResultPresenter createPresenter() {
        this.lineOfSightRealmUtil = new LineOfSightRealmUtil(((App) getActivity().getApplication()).getLineOfSightRealm());
        return new LineOfSightPassCourseResultPresenter(this.lineOfSightRealmUtil);
    }

    public static LineOfSightPassCourseResultFragment newInstance(int resultId2) {
        LineOfSightPassCourseResultFragment fragment = new LineOfSightPassCourseResultFragment();
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
        View view = inflater.inflate(R.layout.line_of_sight_pass_course_result_fragment, container, false);
        this.numberFormat = NumberFormat.getPercentInstance(Locale.getDefault());
        this.numberFormat.setMaximumFractionDigits(1);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((ILineOfSightPassCourseResultPresenter) this.presenter).initTrainingResults(this.resultId);
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

    public void updatePassCoursePointsView(int points) {
        this.passCourseScoreTextView.setText(String.valueOf(points));
    }

    @OnClick({2131296542})
    public void onNextClick() {
        this.nextButton.setEnabled(false);
        this.fragmentCompleteListener.onCourseResultNextClick();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CourseResultFragmentListener) {
            this.fragmentCompleteListener = (CourseResultFragmentListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement CourseResultFragmentListener");
    }

    public void onDetach() {
        super.onDetach();
        this.fragmentCompleteListener = null;
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
