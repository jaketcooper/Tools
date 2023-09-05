package com.safonov.speedreading.training.fragment.speedreading.passcourseresult.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
import com.safonov.speedreading.training.fragment.passcource.CourseResultFragmentListener;
import com.safonov.speedreading.training.fragment.speedreading.passcourseresult.presenter.ISpeedReadingPassCourseResultPresenter;
import com.safonov.speedreading.training.fragment.speedreading.passcourseresult.presenter.SpeedReadingPassCourseResultPresenter;
import com.safonov.speedreading.training.fragment.speedreading.repository.SpeedReadingRealmUtil;
import com.speedreading.alexander.speedreading.R;

public class SpeedReadingPassCourseResultFragment extends MvpFragment<ISpeedReadingPassCourseResultView, ISpeedReadingPassCourseResultPresenter> implements ISpeedReadingPassCourseResultView {
    private static final String TRAINING_RESULT_ID_PARAM = "result_id";
    @BindView(2131296304)
    TextView averageSpeedTextView;
    @BindView(2131296307)
    TextView bestAverageSpeedTextView;
    @BindView(2131296308)
    TextView bestMaxSpeedTextView;
    private CourseResultFragmentListener fragmentCompleteListener;
    @BindView(2131296515)
    TextView maxSpeedTextView;
    @BindView(2131296542)
    Button nextButton;
    @BindView(2131296562)
    TextView passCourseScoreTextView;
    private int resultId;
    private SpeedReadingRealmUtil speedReadingRealmUtil;
    private Unbinder unbinder;

    @NonNull
    public ISpeedReadingPassCourseResultPresenter createPresenter() {
        this.speedReadingRealmUtil = new SpeedReadingRealmUtil(App.get().getSpeedReadingRealm());
        return new SpeedReadingPassCourseResultPresenter(this.speedReadingRealmUtil);
    }

    public static SpeedReadingPassCourseResultFragment newInstance(int resultId2) {
        SpeedReadingPassCourseResultFragment fragment = new SpeedReadingPassCourseResultFragment();
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
        View view = inflater.inflate(R.layout.speed_reading_pass_course_result_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((ISpeedReadingPassCourseResultPresenter) this.presenter).initTrainingResults(this.resultId);
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
