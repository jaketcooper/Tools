package com.safonov.speedreading.training.fragment.aceeleratorcourse.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.application.util.timeticker.TimeTickerConverterUtil;
import com.safonov.speedreading.training.fragment.aceeleratorcourse.presenter.AcceleratorCourseResultPresenter;
import com.safonov.speedreading.training.fragment.aceeleratorcourse.presenter.IAcceleratorCourseResultPresenter;
import com.safonov.speedreading.training.fragment.flashword.repository.FlashWordRealmUtil;
import com.safonov.speedreading.training.fragment.wordsblock.repository.WordBlockRealmUtil;
import com.safonov.speedreading.training.fragment.wordscolumns.repository.WordsColumnsRealmUtil;
import com.speedreading.alexander.speedreading.R;

public class AcceleratorCourseResultFragment extends MvpFragment<IAcceleratorCourseResultView, IAcceleratorCourseResultPresenter> implements IAcceleratorCourseResultView {
    private static final String COURSE_RESULT_ARRAY_ID_PARAM = "course_result_id_array";
    @BindView(2131296385)
    TextView durationTextView;
    private FlashWordRealmUtil flashWordRealmUtil;
    private int[] resultIds;
    private Unbinder unbinder;
    private WordBlockRealmUtil wordBlockRealmUtil;
    private WordsColumnsRealmUtil wordsColumnsRealmUtil;

    @NonNull
    public IAcceleratorCourseResultPresenter createPresenter() {
        this.wordsColumnsRealmUtil = new WordsColumnsRealmUtil(App.get().getWordsColumnsRealm());
        this.wordBlockRealmUtil = new WordBlockRealmUtil(App.get().getWordBlockRealm());
        this.flashWordRealmUtil = new FlashWordRealmUtil(App.get().getFlashWordsRealm());
        return new AcceleratorCourseResultPresenter(this.wordsColumnsRealmUtil, this.wordBlockRealmUtil, this.flashWordRealmUtil);
    }

    public static AcceleratorCourseResultFragment newInstance(int[] resultIds2) {
        AcceleratorCourseResultFragment fragment = new AcceleratorCourseResultFragment();
        Bundle args = new Bundle();
        args.putIntArray(COURSE_RESULT_ARRAY_ID_PARAM, resultIds2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.resultIds = getArguments().getIntArray(COURSE_RESULT_ARRAY_ID_PARAM);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.accelerator_course_result_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((IAcceleratorCourseResultPresenter) this.presenter).initTrainingResults(this.resultIds);
    }

    public void updateTrainingDurationView(long duration) {
        this.durationTextView.setText(getString(R.string.accelerator_result_min, TimeTickerConverterUtil.formatToMinutes(duration)));
    }

    public void onDestroy() {
        super.onDestroy();
        this.wordsColumnsRealmUtil.close();
        this.wordBlockRealmUtil.close();
        this.flashWordRealmUtil.close();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
    }
}
