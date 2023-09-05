package com.p005rd.animation;

import android.animation.ArgbEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import android.view.animation.DecelerateInterpolator;
import com.p005rd.animation.ValueAnimation;

/* renamed from: com.rd.animation.ColorAnimation */
public class ColorAnimation extends AbsAnimation<ValueAnimator> {
    private static final String ANIMATION_COLOR = "ANIMATION_COLOR";
    private static final String ANIMATION_COLOR_REVERSE = "ANIMATION_COLOR_REVERSE";
    public static final String DEFAULT_SELECTED_COLOR = "#ffffff";
    public static final String DEFAULT_UNSELECTED_COLOR = "#33ffffff";
    protected int endColor;
    protected int startColor;

    public ColorAnimation(@NonNull ValueAnimation.UpdateListener listener) {
        super(listener);
    }

    @NonNull
    public ValueAnimator createAnimator() {
        ValueAnimator animator = new ValueAnimator();
        animator.setDuration(350);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                ColorAnimation.this.onAnimateUpdated(animation);
            }
        });
        return animator;
    }

    public ColorAnimation progress(float progress) {
        if (this.animator != null) {
            long playTime = (long) (((float) this.animationDuration) * progress);
            if (((ValueAnimator) this.animator).getValues() != null && ((ValueAnimator) this.animator).getValues().length > 0) {
                ((ValueAnimator) this.animator).setCurrentPlayTime(playTime);
            }
        }
        return this;
    }

    @NonNull
    public ColorAnimation with(int colorStartValue, int colorEndValue) {
        if (this.animator != null && hasChanges(colorStartValue, colorEndValue)) {
            this.startColor = colorStartValue;
            this.endColor = colorEndValue;
            ((ValueAnimator) this.animator).setValues(new PropertyValuesHolder[]{createColorPropertyHolder(false), createColorPropertyHolder(true)});
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public PropertyValuesHolder createColorPropertyHolder(boolean isReverse) {
        String propertyName;
        int startColorValue;
        int endColorValue;
        if (isReverse) {
            propertyName = ANIMATION_COLOR_REVERSE;
            startColorValue = this.endColor;
            endColorValue = this.startColor;
        } else {
            propertyName = ANIMATION_COLOR;
            startColorValue = this.startColor;
            endColorValue = this.endColor;
        }
        PropertyValuesHolder holder = PropertyValuesHolder.ofInt(propertyName, new int[]{startColorValue, endColorValue});
        holder.setEvaluator(new ArgbEvaluator());
        return holder;
    }

    private boolean hasChanges(int colorStartValue, int colorEndValue) {
        if (this.startColor == colorStartValue && this.endColor == colorEndValue) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void onAnimateUpdated(@NonNull ValueAnimator animation) {
        int color = ((Integer) animation.getAnimatedValue(ANIMATION_COLOR)).intValue();
        int colorReverse = ((Integer) animation.getAnimatedValue(ANIMATION_COLOR_REVERSE)).intValue();
        if (this.listener != null) {
            this.listener.onColorAnimationUpdated(color, colorReverse);
        }
    }
}
