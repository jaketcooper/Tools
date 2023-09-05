package com.safonov.speedreading.training.fragment.prepare.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.safonov.speedreading.training.activity.view.IAnimatedFragment;
import com.safonov.speedreading.training.fragment.prepare.PrepareFragmentListener;
import com.speedreading.alexander.speedreading.R;

public class PrepareTrainingFragment extends Fragment implements IAnimatedFragment {
    private static final int SHOW_TIME = 1500;
    @BindView(2131296580)
    CircularProgressBar circularProgressBar;
    /* access modifiers changed from: private */
    public PrepareFragmentListener prepareFragmentListener;
    private ObjectAnimator progressAnimator;
    private Unbinder unbinder;

    public static PrepareTrainingFragment newInstance() {
        return new PrepareTrainingFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.prepare_fragment, container, false);
        this.unbinder = ButterKnife.bind((Object) this, view);
        this.progressAnimator = new ObjectAnimator();
        this.progressAnimator.setTarget(this.circularProgressBar);
        this.progressAnimator.setPropertyName("progress");
        this.progressAnimator.setIntValues(new int[]{0, 100});
        this.progressAnimator.setDuration(1500);
        this.progressAnimator.addListener(new AnimatorListenerAdapter() {
            private boolean isCanceled;

            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                this.isCanceled = false;
            }

            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                this.isCanceled = true;
            }

            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (!this.isCanceled) {
                    PrepareTrainingFragment.this.prepareFragmentListener.onPrepareFragmentCompleted();
                }
            }
        });
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.progressAnimator.start();
    }

    public void pauseAnimations() {
        if (this.progressAnimator != null) {
            this.progressAnimator.cancel();
        }
    }

    public void resumeAnimations() {
        if (this.progressAnimator != null) {
            this.progressAnimator.start();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.unbinder.unbind();
        this.unbinder = null;
        this.progressAnimator.cancel();
        this.progressAnimator = null;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PrepareFragmentListener) {
            this.prepareFragmentListener = (PrepareFragmentListener) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement PrepareFragmentListener");
    }

    public void onDetach() {
        super.onDetach();
        this.prepareFragmentListener = null;
    }
}
