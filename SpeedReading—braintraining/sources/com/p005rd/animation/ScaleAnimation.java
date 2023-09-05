package com.p005rd.animation;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import android.view.animation.DecelerateInterpolator;
import com.p005rd.animation.ValueAnimation;

/* renamed from: com.rd.animation.ScaleAnimation */
public class ScaleAnimation extends ColorAnimation {
    private static final String ANIMATION_COLOR = "ANIMATION_COLOR";
    private static final String ANIMATION_COLOR_REVERSE = "ANIMATION_COLOR_REVERSE";
    private static final String ANIMATION_SCALE = "ANIMATION_SCALE";
    private static final String ANIMATION_SCALE_REVERSE = "ANIMATION_SCALE_REVERSE";
    public static final float DEFAULT_SCALE_FACTOR = 0.7f;
    public static final float MAX_SCALE_FACTOR = 1.0f;
    public static final float MIN_SCALE_FACTOR = 0.3f;
    private int radiusPx;
    private float scaleFactor;

    public ScaleAnimation(@NonNull ValueAnimation.UpdateListener listener) {
        super(listener);
    }

    @NonNull
    public ValueAnimator createAnimator() {
        ValueAnimator animator = new ValueAnimator();
        animator.setDuration(350);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                ScaleAnimation.this.onAnimateUpdated(animation);
            }
        });
        return animator;
    }

    @NonNull
    public ScaleAnimation with(int colorStartValue, int colorEndValue, int radiusValue, float scaleFactorValue) {
        if (this.animator != null && hasChanges(colorStartValue, colorEndValue, radiusValue, scaleFactorValue)) {
            this.startColor = colorStartValue;
            this.endColor = colorEndValue;
            this.radiusPx = radiusValue;
            this.scaleFactor = scaleFactorValue;
            ((ValueAnimator) this.animator).setValues(new PropertyValuesHolder[]{createColorPropertyHolder(false), createColorPropertyHolder(true), createScalePropertyHolder(false), createScalePropertyHolder(true)});
        }
        return this;
    }

    /* access modifiers changed from: private */
    public void onAnimateUpdated(@NonNull ValueAnimator animation) {
        int color = ((Integer) animation.getAnimatedValue(ANIMATION_COLOR)).intValue();
        int colorReverse = ((Integer) animation.getAnimatedValue(ANIMATION_COLOR_REVERSE)).intValue();
        int radius = ((Integer) animation.getAnimatedValue(ANIMATION_SCALE)).intValue();
        int radiusReverse = ((Integer) animation.getAnimatedValue(ANIMATION_SCALE_REVERSE)).intValue();
        if (this.listener != null) {
            this.listener.onScaleAnimationUpdated(color, colorReverse, radius, radiusReverse);
        }
    }

    @NonNull
    private PropertyValuesHolder createScalePropertyHolder(boolean isReverse) {
        String propertyName;
        int startRadiusValue;
        int endRadiusValue;
        if (isReverse) {
            propertyName = ANIMATION_SCALE_REVERSE;
            startRadiusValue = this.radiusPx;
            endRadiusValue = (int) (((float) this.radiusPx) * this.scaleFactor);
        } else {
            propertyName = ANIMATION_SCALE;
            startRadiusValue = (int) (((float) this.radiusPx) * this.scaleFactor);
            endRadiusValue = this.radiusPx;
        }
        PropertyValuesHolder holder = PropertyValuesHolder.ofInt(propertyName, new int[]{startRadiusValue, endRadiusValue});
        holder.setEvaluator(new IntEvaluator());
        return holder;
    }

    private boolean hasChanges(int colorStartValue, int colorEndValue, int radiusValue, float scaleFactorValue) {
        if (this.startColor == colorStartValue && this.endColor == colorEndValue && this.radiusPx == radiusValue && this.scaleFactor == scaleFactorValue) {
            return false;
        }
        return true;
    }
}
