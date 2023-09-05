package com.safonov.speedreading.training.fragment.concentration.complexity.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.training.fragment.concentration.complexity.presenter.ConcentrationComplexityPresenter;
import com.safonov.speedreading.training.fragment.concentration.complexity.presenter.IConcentrationComplexityPresenter;
import com.safonov.speedreading.training.fragment.concentration.repository.ConcentrationRealmUtil;
import com.speedreading.alexander.speedreading.R;

public class ConcentrationComplexityFragment extends MvpFragment<IConcentrationComplexityFragment, IConcentrationComplexityPresenter> implements IConcentrationComplexityFragment {
    private static final String TRAINING_CONFIG_ID_PARAM = "config_id";
    private int configId;
    private IConcentrationComplexityListner fragmentListner;
    private ConcentrationRealmUtil mathRealmUtil;
    private Unbinder unbinder;

    public IConcentrationComplexityPresenter createPresenter() {
        this.mathRealmUtil = new ConcentrationRealmUtil(((App) getActivity().getApplication()).getConcentrationRealm());
        return new ConcentrationComplexityPresenter(this.mathRealmUtil);
    }

    public static ConcentrationComplexityFragment newInstance(int configId2) {
        ConcentrationComplexityFragment fragment = new ConcentrationComplexityFragment();
        Bundle args = new Bundle();
        args.putInt(TRAINING_CONFIG_ID_PARAM, configId2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.configId = getArguments().getInt(TRAINING_CONFIG_ID_PARAM);
        }
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((IConcentrationComplexityPresenter) this.presenter).initConfig(this.configId);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.concentration_complexity_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    @OnClick({2131296345})
    public void setComplexityFirst(TextView textView) {
        ((IConcentrationComplexityPresenter) this.presenter).setComplexity(1);
        this.fragmentListner.onConcentrationComplexityStartClick();
    }

    @OnClick({2131296346})
    public void setComplexitySecond(TextView textView) {
        ((IConcentrationComplexityPresenter) this.presenter).setComplexity(2);
        this.fragmentListner.onConcentrationComplexityStartClick();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IConcentrationComplexityListner) {
            this.fragmentListner = (IConcentrationComplexityListner) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement GreenDotTrainingCompleteListener");
    }
}
