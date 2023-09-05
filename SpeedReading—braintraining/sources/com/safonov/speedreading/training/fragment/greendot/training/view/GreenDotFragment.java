package com.safonov.speedreading.training.fragment.greendot.training.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.safonov.speedreading.application.App;
import com.safonov.speedreading.training.activity.view.IAnimatedFragment;
import com.safonov.speedreading.training.fragment.greendot.repository.GreenDotRealmUtil;
import com.safonov.speedreading.training.fragment.greendot.training.presenter.GreenDotPresenter;
import com.safonov.speedreading.training.fragment.greendot.training.presenter.IGreenDotPresenter;
import com.speedreading.alexander.speedreading.R;

public class GreenDotFragment extends MvpFragment<IGreenDotView, IGreenDotPresenter> implements IGreenDotView, IAnimatedFragment {
    private static final String TRAINING_CONFIG_ID_PARAM = "config_id";
    private GreenDotTrainingCompleteListener completeListener;
    /* access modifiers changed from: private */
    public int configId;
    private GreenDotRealmUtil greenDotRealmUtil;
    @BindString(2131624078)
    String greenDotText;
    @BindView(2131296421)
    GreenDotTextView greenDotTextView;
    private Unbinder unbinder;

    @NonNull
    public IGreenDotPresenter createPresenter() {
        this.greenDotRealmUtil = new GreenDotRealmUtil(((App) getActivity().getApplication()).getGreenDotRealm());
        return new GreenDotPresenter(this.greenDotRealmUtil);
    }

    public static GreenDotFragment newInstance(int configId2) {
        GreenDotFragment fragment = new GreenDotFragment();
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

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.green_dot_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.greenDotTextView.setProgress(0);
        this.greenDotTextView.post(new Runnable() {
            public void run() {
                GreenDotFragment.this.greenDotTextView.setText(GreenDotFragment.this.trimGreenDotText(GreenDotFragment.this.greenDotText, GreenDotFragment.this.greenDotTextView.getPaint(), (GreenDotFragment.this.greenDotTextView.getWidth() - GreenDotFragment.this.greenDotTextView.getPaddingLeft()) - GreenDotFragment.this.greenDotTextView.getPaddingRight(), (GreenDotFragment.this.greenDotTextView.getHeight() - GreenDotFragment.this.greenDotTextView.getPaddingTop()) - GreenDotFragment.this.greenDotTextView.getPaddingBottom()));
                ((IGreenDotPresenter) GreenDotFragment.this.presenter).startTraining(GreenDotFragment.this.configId);
            }
        });
    }

    /* access modifiers changed from: private */
    public String trimGreenDotText(String text, TextPaint textPaint, int viewWidth, int viewHeight) {
        int lastCharacterIndex;
        StringBuilder temp = new StringBuilder();
        temp.append(text);
        temp.append(' ');
        temp.append(text);
        temp.append(' ');
        temp.append(text);
        temp.append(' ');
        temp.append(text);
        StaticLayout tempLayout = new StaticLayout(temp.toString(), textPaint, viewWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        int lastVisibleLine = tempLayout.getLineForVertical(viewHeight);
        if (tempLayout.getLineBottom(lastVisibleLine) > viewHeight) {
            lastCharacterIndex = tempLayout.getLineEnd(lastVisibleLine - 1);
        } else {
            lastCharacterIndex = tempLayout.getLineEnd(lastVisibleLine);
        }
        return temp.substring(0, lastCharacterIndex);
    }

    public void setGreenDotViewProgress(int progress) {
        this.greenDotTextView.setProgress(progress);
    }

    public void onDestroy() {
        super.onDestroy();
        this.greenDotRealmUtil.close();
        this.greenDotRealmUtil = null;
        ((IGreenDotPresenter) this.presenter).cancelTraining();
        this.presenter = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
        this.unbinder = null;
    }

    public void pauseAnimations() {
        ((IGreenDotPresenter) this.presenter).pauseTraining();
    }

    public void resumeAnimations() {
        ((IGreenDotPresenter) this.presenter).resumeTraining();
    }

    public void onGreenDotTrainingCompleted(int trainingResultId) {
        this.completeListener.onGreenDotTrainingCompleted(trainingResultId);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof GreenDotTrainingCompleteListener) {
            this.completeListener = (GreenDotTrainingCompleteListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement GreenDotTrainingCompleteListener");
    }

    public void onDetach() {
        super.onDetach();
        this.completeListener = null;
    }
}
