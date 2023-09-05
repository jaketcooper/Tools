package com.safonov.speedreading.training.fragment.math.complexity.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.training.fragment.math.complexity.presenter.IMathComplexityPresenter;
import com.safonov.speedreading.training.fragment.math.complexity.presenter.MathComplexityPresenter;
import com.safonov.speedreading.training.fragment.math.repository.MathRealmUtil;
import com.safonov.speedreading.training.fragment.math.repository.entity.MathConfig;
import com.speedreading.alexander.speedreading.R;

public class MathComplexityFragment extends MvpFragment<IMathComplexityFragment, IMathComplexityPresenter> implements IMathComplexityFragment {
    private static final String TRAINING_CONFIG_ID_PARAM = "config_id";
    @BindView(2131296495)
    TextView complexityButton1;
    @BindView(2131296496)
    TextView complexityButton2;
    @BindView(2131296497)
    TextView complexityButton3;
    private MathConfig config;
    private int configId;
    private MathComplexityFragmentListner fragmentListner;
    private MathRealmUtil mathRealmUtil;
    private Unbinder unbinder;

    public IMathComplexityPresenter createPresenter() {
        this.mathRealmUtil = new MathRealmUtil(((App) getActivity().getApplication()).getMathRealm());
        return new MathComplexityPresenter(this.mathRealmUtil);
    }

    public static MathComplexityFragment newInstance(int configId2) {
        MathComplexityFragment fragment = new MathComplexityFragment();
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

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.math_complexity_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((IMathComplexityPresenter) this.presenter).initConfig(this.configId);
    }

    @OnClick({2131296495})
    public void setComplexityFirst(TextView textView) {
        ((IMathComplexityPresenter) this.presenter).setComplexity(1);
        this.fragmentListner.onMathComplexityStartClick();
    }

    @OnClick({2131296496})
    public void setComplexitySecond(TextView textView) {
        ((IMathComplexityPresenter) this.presenter).setComplexity(2);
        this.fragmentListner.onMathComplexityStartClick();
    }

    @OnClick({2131296497})
    public void setComplexityThird(TextView textView) {
        ((IMathComplexityPresenter) this.presenter).setComplexity(3);
        this.fragmentListner.onMathComplexityStartClick();
    }

    @OnClick({2131296498})
    public void setComplexityFourth(TextView textView) {
        ((IMathComplexityPresenter) this.presenter).setComplexity(4);
        this.fragmentListner.onMathComplexityStartClick();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MathComplexityFragmentListner) {
            this.fragmentListner = (MathComplexityFragmentListner) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement GreenDotTrainingCompleteListener");
    }
}
