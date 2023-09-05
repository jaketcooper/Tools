package com.safonov.speedreading.training.fragment.wordsblock.passcourseresult.view;

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
import com.safonov.speedreading.application.util.timeticker.TimeTickerConverterUtil;
import com.safonov.speedreading.training.fragment.passcource.CourseResultFragmentListener;
import com.safonov.speedreading.training.fragment.wordsblock.passcourseresult.presenter.IWordBlockPassCourseResultPresenter;
import com.safonov.speedreading.training.fragment.wordsblock.passcourseresult.presenter.WordBlockPassCourseResultPresenter;
import com.safonov.speedreading.training.fragment.wordsblock.repository.WordBlockRealmUtil;
import com.speedreading.alexander.speedreading.R;

public class WordBlockPassCourseResultFragment extends MvpFragment<IWordBlockPassCourseResultView, IWordBlockPassCourseResultPresenter> implements IWordBlockPassCourseResultView {
    private static final String TRAINING_RESULT_ID_PARAM = "training_result_id";
    @BindView(2131296385)
    TextView durationTextView;
    private CourseResultFragmentListener fragmentCompleteListener;
    @BindView(2131296542)
    Button nextButton;
    private WordBlockRealmUtil realmUtil;
    private int resultId;
    private Unbinder unbinder;

    @NonNull
    public IWordBlockPassCourseResultPresenter createPresenter() {
        this.realmUtil = new WordBlockRealmUtil(App.get().getWordBlockRealm());
        return new WordBlockPassCourseResultPresenter(this.realmUtil);
    }

    public static WordBlockPassCourseResultFragment newInstance(int resultId2) {
        WordBlockPassCourseResultFragment fragment = new WordBlockPassCourseResultFragment();
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
        View view = inflater.inflate(R.layout.word_block_pass_course_result_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((IWordBlockPassCourseResultPresenter) this.presenter).initTrainingResults(this.resultId);
    }

    public void updateTrainingDurationView(long duration) {
        this.durationTextView.setText(getString(R.string.word_block_result_sec, TimeTickerConverterUtil.formatToSeconds(duration)));
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
        this.realmUtil.close();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
    }
}
