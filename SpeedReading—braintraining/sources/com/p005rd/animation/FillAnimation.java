package com.p005rd.animation;

import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import android.view.animation.DecelerateInterpolator;
import com.p005rd.animation.ValueAnimation;

/* renamed from: com.rd.animation.FillAnimation */
public class FillAnimation extends ColorAnimation {
    private static final String ANIMATION_COLOR = "ANIMATION_COLOR";
    private static final String ANIMATION_COLOR_REVERSE = "ANIMATION_COLOR_REVERSE";
    private static final String ANIMATION_RADIUS = "ANIMATION_RADIUS";
    private static final String ANIMATION_RADIUS_REVERSE = "ANIMATION_RADIUS_REVERSE";
    private static final String ANIMATION_STROKE = "ANIMATION_STROKE";
    private static final String ANIMATION_STROKE_REVERSE = "ANIMATION_STROKE_REVERSE";
    public static final int DEFAULT_STROKE_DP = 1;
    private int radiusPx;
    private int strokePx;

    public FillAnimation(@NonNull ValueAnimation.UpdateListener listener) {
        super(listener);
    }

    @NonNull
    public ValueAnimator createAnimator() {
        ValueAnimator animator = new ValueAnimator();
        animator.setDuration(350);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                FillAnimation.this.onAnimateUpdated(animation);
            }
        });
        return animator;
    }

    @NonNull
    public FillAnimation with(int colorStartValue, int colorEndValue, int radiusValue, int strokeValue) {
        if (this.animator != null && hasChanges(colorStartValue, colorEndValue, radiusValue, strokeValue)) {
            this.startColor = colorStartValue;
            this.endColor = colorEndValue;
            this.radiusPx = radiusValue;
            this.strokePx = strokeValue;
            ((ValueAnimator) this.animator).setValues(new PropertyValuesHolder[]{createColorPropertyHolder(false), createColorPropertyHolder(true), createRadiusPropertyHolder(false), createRadiusPropertyHolder(true), createStrokePropertyHolder(false), createStrokePropertyHolder(true)});
        }
        return this;
    }

    @NonNull
    private PropertyValuesHolder createRadiusPropertyHolder(boolean isReverse) {
        String propertyName;
        int startRadiusValue;
        int endRadiusValue;
        if (isReverse) {
            propertyName = ANIMATION_RADIUS_REVERSE;
            startRadiusValue = this.radiusPx / 2;
            endRadiusValue = this.radiusPx;
        } else {
            propertyName = ANIMATION_RADIUS;
            startRadiusValue = this.radiusPx;
            endRadiusValue = this.radiusPx / 2;
        }
        PropertyValuesHolder holder = PropertyValuesHolder.ofInt(propertyName, new int[]{startRadiusValue, endRadiusValue});
        holder.setEvaluator(new IntEvaluator());
        return holder;
    }

    @NonNull
    private PropertyValuesHolder createStrokePropertyHolder(boolean isReverse) {
        String propertyName;
        int startStrokeValue;
        int endStrokeValue;
        if (isReverse) {
            propertyName = ANIMATION_STROKE_REVERSE;
            startStrokeValue = this.radiusPx;
            endStrokeValue = 0;
        } else {
            propertyName = ANIMATION_STROKE;
            startStrokeValue = 0;
            endStrokeValue = this.radiusPx;
        }
        PropertyValuesHolder holder = PropertyValuesHolder.ofInt(propertyName, new int[]{startStrokeValue, endStrokeValue});
        holder.setEvaluator(new IntEvaluator());
        return holder;
    }

    /* access modifiers changed from: private */
    public void onAnimateUpdated(@NonNull ValueAnimator animation) {
        int color = ((Integer) animation.getAnimatedValue(ANIMATION_COLOR)).intValue();
        int colorReverse = ((Integer) animation.getAnimatedValue(ANIMATION_COLOR_REVERSE)).intValue();
        int radius = ((Integer) animation.getAnimatedValue(ANIMATION_RADIUS)).intValue();
        int radiusReverse = ((Integer) animation.getAnimatedValue(ANIMATION_RADIUS_REVERSE)).intValue();
        int stroke = ((Integer) animation.getAnimatedValue(ANIMATION_STROKE)).intValue();
        int strokeReverse = ((Integer) animation.getAnimatedValue(ANIMATION_STROKE_REVERSE)).intValue();
        if (this.listener != null) {
            this.listener.onFillAnimationUpdated(color, colorReverse, radius, radiusReverse, stroke, strokeReverse);
        }
    }

    private boolean hasChanges(int colorStartValue, int colorEndValue, int radiusValue, int strokeValue) {
        if (this.startColor == colorStartValue && this.endColor == colorEndValue && this.radiusPx == radiusValue && this.strokePx == strokeValue) {
            return false;
        }
        return true;
    }
}
