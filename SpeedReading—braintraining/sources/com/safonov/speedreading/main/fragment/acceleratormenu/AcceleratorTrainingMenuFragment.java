package com.safonov.speedreading.main.fragment.acceleratormenu;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.safonov.speedreading.main.TrainingFragmentListener;
import com.safonov.speedreading.training.TrainingType;
import com.speedreading.alexander.speedreading.R;

public class AcceleratorTrainingMenuFragment extends Fragment {
    private TrainingFragmentListener menuFragmentListener;
    private Unbinder unbinder;

    public static AcceleratorTrainingMenuFragment newInstance() {
        return new AcceleratorTrainingMenuFragment();
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_accelerator_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof TrainingFragmentListener) {
            this.menuFragmentListener = (TrainingFragmentListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement TrainingFragmentListener");
    }

    public void onDetach() {
        super.onDetach();
        this.menuFragmentListener = null;
    }

    @OnClick({2131296802})
    public void onStartAcceleratorClick() {
        this.menuFragmentListener.requestToStartTraining(TrainingType.WORDS_COLUMNS);
    }

    @OnClick({2131296800})
    public void onStartWordBlockClick() {
        this.menuFragmentListener.requestToStartTraining(TrainingType.WORDS_BLOCK);
    }

    @OnClick({2131296791})
    public void onStartFlashWordClick() {
        this.menuFragmentListener.requestToStartTraining(TrainingType.FLASH_WORDS);
    }

    @OnClick({2131296787})
    public void onStartAcceleratorPassCourseClick() {
        this.menuFragmentListener.requestToStartTraining(TrainingType.ACCELERATOR_COURSE);
    }
}
