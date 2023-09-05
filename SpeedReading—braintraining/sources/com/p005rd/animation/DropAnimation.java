package com.p005rd.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.p005rd.animation.ValueAnimation;
import java.util.Iterator;

/* renamed from: com.rd.animation.DropAnimation */
public class DropAnimation extends AbsAnimation<AnimatorSet> {
    private int center;
    private int frameRadius;
    private int frameX;
    private int frameY;
    private int radius;
    private int xFromValue;
    private int xToValue;

    /* renamed from: com.rd.animation.DropAnimation$AnimationType */
    public enum AnimationType {
        Width,
        Height,
        Radius
    }

    public DropAnimation(@NonNull ValueAnimation.UpdateListener listener) {
        super(listener);
    }

    @NonNull
    public AnimatorSet createAnimator() {
        AnimatorSet animator = new AnimatorSet();
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        return animator;
    }

    public DropAnimation progress(float progress) {
        if (this.animator != null) {
            long playTimeLeft = (long) (((float) this.animationDuration) * progress);
            boolean isReverse = false;
            Iterator<Animator> it = ((AnimatorSet) this.animator).getChildAnimations().iterator();
            while (it.hasNext()) {
                ValueAnimator animator = (ValueAnimator) it.next();
                long animDuration = animator.getDuration();
                long currPlayTime = playTimeLeft;
                if (isReverse) {
                    currPlayTime -= animDuration;
                }
                if (currPlayTime >= 0) {
                    if (currPlayTime >= animDuration) {
                        currPlayTime = animDuration;
                    }
                    if (animator.getValues() != null && animator.getValues().length > 0) {
                        animator.setCurrentPlayTime(currPlayTime);
                    }
                    if (!isReverse && animDuration >= this.animationDuration) {
                        isReverse = true;
                    }
                }
            }
        }
        return this;
    }

    public DropAnimation duration(long duration) {
        super.duration(duration);
        return this;
    }

    public DropAnimation with(int xFromValue2, int xToValue2, int center2, int radius2) {
        if (hasChanges(xFromValue2, xToValue2, center2, radius2)) {
            this.animator = createAnimator();
            this.xFromValue = xFromValue2;
            this.xToValue = xToValue2;
            this.center = center2;
            this.radius = radius2;
            int yFromValue = center2;
            int yToValue = center2 / 3;
            int fromSelectedRadius = radius2;
            int toSelectedRadius = (int) (((double) radius2) / 1.5d);
            long halfDuration = this.animationDuration / 2;
            this.frameX = xFromValue2;
            this.frameY = yFromValue;
            this.frameRadius = radius2;
            ValueAnimator widthAnimator = createValueAnimation(xFromValue2, xToValue2, this.animationDuration, AnimationType.Width);
            ValueAnimator heightForwardAnimator = createValueAnimation(yFromValue, yToValue, halfDuration, AnimationType.Height);
            ValueAnimator heightBackwardAnimator = createValueAnimation(yToValue, yFromValue, halfDuration, AnimationType.Height);
            ValueAnimator radiusForwardAnimator = createValueAnimation(fromSelectedRadius, toSelectedRadius, halfDuration, AnimationType.Radius);
            ((AnimatorSet) this.animator).play(heightForwardAnimator).with(radiusForwardAnimator).with(widthAnimator).before(heightBackwardAnimator).before(createValueAnimation(toSelectedRadius, fromSelectedRadius, halfDuration, AnimationType.Radius));
        }
        return this;
    }

    private ValueAnimator createValueAnimation(int fromValue, int toValue, long duration, final AnimationType type) {
        ValueAnimator anim = ValueAnimator.ofInt(new int[]{fromValue, toValue});
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.setDuration(duration);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                DropAnimation.this.onAnimatorUpdate(((Integer) animation.getAnimatedValue()).intValue(), type);
            }
        });
        return anim;
    }

    /* access modifiers changed from: private */
    public void onAnimatorUpdate(int value, AnimationType type) {
        switch (type) {
            case Width:
                this.frameX = value;
                break;
            case Height:
                this.frameY = value;
                break;
            case Radius:
                this.frameRadius = value;
                break;
        }
        if (this.listener != null) {
            this.listener.onDropAnimationUpdated(this.frameX, this.frameY, this.frameRadius);
        }
    }

    private boolean hasChanges(int fromValue, int toValue, int center2, int radius2) {
        if (this.xFromValue == fromValue && this.xToValue == toValue && this.center == center2 && this.radius == radius2) {
            return false;
        }
        return true;
    }
}
