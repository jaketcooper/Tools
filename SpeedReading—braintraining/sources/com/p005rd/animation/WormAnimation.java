package com.p005rd.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.p005rd.animation.ValueAnimation;
import java.util.Iterator;

/* renamed from: com.rd.animation.WormAnimation */
public class WormAnimation extends AbsAnimation<AnimatorSet> {
    int fromValue;
    boolean isRightSide;
    int radius;
    int rectLeftX;
    int rectRightX;
    int toValue;

    public WormAnimation(@NonNull ValueAnimation.UpdateListener listener) {
        super(listener);
    }

    @NonNull
    public AnimatorSet createAnimator() {
        AnimatorSet animator = new AnimatorSet();
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        return animator;
    }

    public WormAnimation duration(long duration) {
        super.duration(duration);
        return this;
    }

    public WormAnimation with(int fromValue2, int toValue2, int radius2, boolean isRightSide2) {
        if (hasChanges(fromValue2, toValue2, radius2, isRightSide2)) {
            this.animator = createAnimator();
            this.fromValue = fromValue2;
            this.toValue = toValue2;
            this.radius = radius2;
            this.isRightSide = isRightSide2;
            this.rectLeftX = fromValue2 - radius2;
            this.rectRightX = fromValue2 + radius2;
            AnimationValues values = createAnimationValues(isRightSide2);
            long duration = this.animationDuration / 2;
            ((AnimatorSet) this.animator).playSequentially(new Animator[]{createWormAnimator(values.fromX, values.toX, duration, false), createWormAnimator(values.reverseFromX, values.reverseToX, duration, true)});
        }
        return this;
    }

    public WormAnimation progress(float progress) {
        if (this.animator != null) {
            long playTimeLeft = (long) (((float) this.animationDuration) * progress);
            Iterator<Animator> it = ((AnimatorSet) this.animator).getChildAnimations().iterator();
            while (it.hasNext()) {
                ValueAnimator animator = (ValueAnimator) it.next();
                long animDuration = animator.getDuration();
                if (playTimeLeft < 0) {
                    playTimeLeft = 0;
                }
                long currPlayTime = playTimeLeft;
                if (currPlayTime >= animDuration) {
                    currPlayTime = animDuration;
                }
                if (animator.getValues() != null && animator.getValues().length > 0) {
                    animator.setCurrentPlayTime(currPlayTime);
                }
                playTimeLeft -= currPlayTime;
            }
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public ValueAnimator createWormAnimator(int fromX, int toX, long duration, final boolean isReverse) {
        ValueAnimator anim = ValueAnimator.ofInt(new int[]{fromX, toX});
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.setDuration(duration);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = ((Integer) animation.getAnimatedValue()).intValue();
                if (!isReverse) {
                    if (WormAnimation.this.isRightSide) {
                        WormAnimation.this.rectRightX = value;
                    } else {
                        WormAnimation.this.rectLeftX = value;
                    }
                } else if (WormAnimation.this.isRightSide) {
                    WormAnimation.this.rectLeftX = value;
                } else {
                    WormAnimation.this.rectRightX = value;
                }
                WormAnimation.this.listener.onWormAnimationUpdated(WormAnimation.this.rectLeftX, WormAnimation.this.rectRightX);
            }
        });
        return anim;
    }

    /* access modifiers changed from: package-private */
    public boolean hasChanges(int fromValue2, int toValue2, int radius2, boolean isRightSide2) {
        if (this.fromValue == fromValue2 && this.toValue == toValue2 && this.radius == radius2 && this.isRightSide == isRightSide2) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public AnimationValues createAnimationValues(boolean isRightSide2) {
        int fromX;
        int toX;
        int reverseFromX;
        int reverseToX;
        if (isRightSide2) {
            fromX = this.fromValue + this.radius;
            toX = this.toValue + this.radius;
            reverseFromX = this.fromValue - this.radius;
            reverseToX = this.toValue - this.radius;
        } else {
            fromX = this.fromValue - this.radius;
            toX = this.toValue - this.radius;
            reverseFromX = this.fromValue + this.radius;
            reverseToX = this.toValue + this.radius;
        }
        return new AnimationValues(fromX, toX, reverseFromX, reverseToX);
    }

    /* renamed from: com.rd.animation.WormAnimation$AnimationValues */
    class AnimationValues {
        final int fromX;
        final int reverseFromX;
        final int reverseToX;
        final int toX;

        AnimationValues(int fromX2, int toX2, int reverseFromX2, int reverseToX2) {
            this.fromX = fromX2;
            this.toX = toX2;
            this.reverseFromX = reverseFromX2;
            this.reverseToX = reverseToX2;
        }
    }
}
