package com.safonov.speedreading.training.fragment.schultetable.passcourseresult.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.application.util.timeticker.TimeTickerConverterUtil;
import com.safonov.speedreading.training.fragment.passcource.CourseResultFragmentListener;
import com.safonov.speedreading.training.fragment.schultetable.passcourseresult.presenter.ISchulteTablePassCourseResultPresenter;
import com.safonov.speedreading.training.fragment.schultetable.passcourseresult.presenter.SchulteTablePassCourseResultPresenter;
import com.safonov.speedreading.training.fragment.schultetable.repository.SchulteTableRealmUtil;
import com.speedreading.alexander.speedreading.R;

public class SchulteTablePassCourseResultFragment extends MvpFragment<ISchulteTablePassCourseResultView, ISchulteTablePassCourseResultPresenter> implements ISchulteTablePassCourseResultView {
    private static final String TRAINING_RESULT_ID_PARAM = "training_result_id";
    @BindView(2131296312)
    TextView bestTimeTextView;
    private CourseResultFragmentListener fragmentCompleteListener;
    @BindView(2131296539)
    ImageView newBestTimeView;
    @BindView(2131296542)
    Button nextButton;
    @BindView(2131296562)
    TextView passCourseScoreTextView;
    private SchulteTableRealmUtil schulteTableRealmUtil;
    @BindView(2131296775)
    TextView timeTextView;
    private int trainingResultId;
    private Unbinder unbinder;

    @NonNull
    public ISchulteTablePassCourseResultPresenter createPresenter() {
        this.schulteTableRealmUtil = new SchulteTableRealmUtil(App.get().getSchulteTableRealm());
        return new SchulteTablePassCourseResultPresenter(this.schulteTableRealmUtil);
    }

    public static SchulteTablePassCourseResultFragment newInstance(int resultId) {
        SchulteTablePassCourseResultFragment fragment = new SchulteTablePassCourseResultFragment();
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
        View view = inflater.inflate(R.layout.schulte_table_pass_course_result_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((ISchulteTablePassCourseResultPresenter) this.presenter).initTrainingResults(this.trainingResultId);
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
