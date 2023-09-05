package com.safonov.speedreading.training.fragment.wordpairs.passcourseresult.view;

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
import com.safonov.speedreading.training.fragment.passcource.CourseResultFragmentListener;
import com.safonov.speedreading.training.fragment.wordpairs.passcourseresult.presenter.IWordPairsPassCourseResultPresenter;
import com.safonov.speedreading.training.fragment.wordpairs.passcourseresult.presenter.WordPairsPassCourseResultPresenter;
import com.safonov.speedreading.training.fragment.wordpairs.repository.WordPairsRealmUtil;
import com.speedreading.alexander.speedreading.R;

public class WordPairsPassCourseResultFragment extends MvpFragment<IWordPairsPassCourseResultView, IWordPairsPassCourseResultPresenter> implements IWordPairsPassCourseResultView {
    private static final String TRAINING_RESULT_ID_PARAM = "training_result_id";
    @BindView(2131296310)
    TextView bestScoreTextView;
    private CourseResultFragmentListener fragmentCompleteListener;
    @BindView(2131296538)
    ImageView newBestScoreView;
    @BindView(2131296542)
    Button nextButton;
    @BindView(2131296562)
    TextView passCourseScoreTextView;
    @BindView(2131296648)
    TextView scoreTextView;
    private int trainingResultId;
    private Unbinder unbinder;
    private WordPairsRealmUtil wordPairsRealmUtil;

    @NonNull
    public IWordPairsPassCourseResultPresenter createPresenter() {
        this.wordPairsRealmUtil = new WordPairsRealmUtil(App.get().getWordPairsRealm());
        return new WordPairsPassCourseResultPresenter(this.wordPairsRealmUtil);
    }

    public static WordPairsPassCourseResultFragment newInstance(int trainingResultId2) {
        WordPairsPassCourseResultFragment fragment = new WordPairsPassCourseResultFragment();
        Bundle args = new Bundle();
        args.putInt(TRAINING_RESULT_ID_PARAM, trainingResultId2);
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
        View view = inflater.inflate(R.layout.word_pairs_pass_course_result_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((IWordPairsPassCourseResultPresenter) this.presenter).initTrainingResults(this.trainingResultId);
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
        this.wordPairsRealmUtil.close();
        this.wordPairsRealmUtil = null;
        this.presenter = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
        this.unbinder = null;
    }
}
