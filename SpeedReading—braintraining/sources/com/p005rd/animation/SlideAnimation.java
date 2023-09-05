package com.p005rd.animation;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import android.view.animation.DecelerateInterpolator;
import com.p005rd.animation.ValueAnimation;

/* renamed from: com.rd.animation.SlideAnimation */
public class SlideAnimation extends AbsAnimation<ValueAnimator> {
    private static final String ANIMATION_X_COORDINATE = "ANIMATION_X_COORDINATE";
    private static final int COORDINATE_NONE = -1;
    private int xEndCoordinate = -1;
    private int xStartCoordinate = -1;

    public SlideAnimation(@NonNull ValueAnimation.UpdateListener listener) {
        super(listener);
    }

    @NonNull
    public ValueAnimator createAnimator() {
        ValueAnimator animator = new ValueAnimator();
        animator.setDuration(350);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                SlideAnimation.this.onAnimateUpdated(animation);
            }
        });
        return animator;
    }

    public SlideAnimation progress(float progress) {
        if (this.animator != null) {
            long playTime = (long) (((float) this.animationDuration) * progress);
            if (((ValueAnimator) this.animator).getValues() != null && ((ValueAnimator) this.animator).getValues().length > 0) {
                ((ValueAnimator) this.animator).setCurrentPlayTime(playTime);
            }
        }
        return this;
    }

    @NonNull
    public SlideAnimation with(int startValue, int endValue) {
        if (this.animator != null && hasChanges(startValue, endValue)) {
            this.xStartCoordinate = startValue;
            this.xEndCoordinate = endValue;
            ((ValueAnimator) this.animator).setValues(new PropertyValuesHolder[]{createColorPropertyHolder()});
        }
        return this;
    }

    private PropertyValuesHolder createColorPropertyHolder() {
        PropertyValuesHolder holder = PropertyValuesHolder.ofInt(ANIMATION_X_COORDINATE, new int[]{this.xStartCoordinate, this.xEndCoordinate});
        holder.setEvaluator(new IntEvaluator());
        return holder;
    }

    /* access modifiers changed from: private */
    public void onAnimateUpdated(@NonNull ValueAnimator animation) {
        int xCoordinate = ((Integer) animation.getAnimatedValue(ANIMATION_X_COORDINATE)).intValue();
        if (this.listener != null) {
            this.listener.onSlideAnimationUpdated(xCoordinate);
        }
    }

    private boolean hasChanges(int startValue, int endValue) {
        if (this.xStartCoordinate == startValue && this.xEndCoordinate == endValue) {
            return false;
        }
        return true;
    }
}
