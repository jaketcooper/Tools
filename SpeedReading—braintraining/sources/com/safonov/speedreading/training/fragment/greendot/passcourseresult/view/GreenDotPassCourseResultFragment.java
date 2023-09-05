package com.safonov.speedreading.training.fragment.greendot.passcourseresult.view;

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
import com.safonov.speedreading.training.fragment.greendot.passcourseresult.presenter.GreenDotPassCourseResultPresenter;
import com.safonov.speedreading.training.fragment.greendot.passcourseresult.presenter.IGreenDotPassCourseResultPresenter;
import com.safonov.speedreading.training.fragment.greendot.repository.GreenDotRealmUtil;
import com.safonov.speedreading.training.fragment.greendot.util.GreenDotTimeConverterUtil;
import com.safonov.speedreading.training.fragment.passcource.CourseResultFragmentListener;
import com.speedreading.alexander.speedreading.R;

public class GreenDotPassCourseResultFragment extends MvpFragment<IGreenDotPassCourseResultView, IGreenDotPassCourseResultPresenter> implements IGreenDotPassCourseResultView {
    private static final String TRAINING_RESULT_ID_PARAM = "training_result_id";
    @BindView(2131296418)
    TextView durationTextView;
    private CourseResultFragmentListener fragmentCompleteListener;
    private GreenDotRealmUtil greenDotRealmUtil;
    @BindView(2131296542)
    Button nextButton;
    @BindView(2131296562)
    TextView passCourseScoreTextView;
    private int resultId;
    private GreenDotTimeConverterUtil timeConverterUtil = new GreenDotTimeConverterUtil();
    private Unbinder unbinder;

    @NonNull
    public IGreenDotPassCourseResultPresenter createPresenter() {
        this.greenDotRealmUtil = new GreenDotRealmUtil(App.get().getGreenDotRealm());
        return new GreenDotPassCourseResultPresenter(this.greenDotRealmUtil);
    }

    public static GreenDotPassCourseResultFragment newInstance(int resultId2) {
        GreenDotPassCourseResultFragment fragment = new GreenDotPassCourseResultFragment();
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
        View view = inflater.inflate(R.layout.green_dot_pass_course_result_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((IGreenDotPassCourseResultPresenter) this.presenter).initTrainingResults(this.resultId);
    }

    public void updateTrainingDurationView(long duration) {
        this.durationTextView.setText(this.timeConverterUtil.format(duration));
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
