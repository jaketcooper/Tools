package com.p005rd.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.p005rd.animation.ValueAnimation;
import com.p005rd.animation.WormAnimation;

/* renamed from: com.rd.animation.ThinWormAnimation */
public class ThinWormAnimation extends WormAnimation {
    private static final float PERCENTAGE_HEIGHT_DURATION = 0.25f;
    private static final float PERCENTAGE_REVERSE_HEIGHT_DELAY = 0.65f;
    private static final float PERCENTAGE_SIZE_DURATION_DELAY = 0.7f;
    /* access modifiers changed from: private */
    public int height;

    public ThinWormAnimation(@NonNull ValueAnimation.UpdateListener listener) {
        super(listener);
    }

    public ThinWormAnimation duration(long duration) {
        super.duration(duration);
        return this;
    }

    public WormAnimation with(int fromValue, int toValue, int radius, boolean isRightSide) {
        if (hasChanges(fromValue, toValue, radius, isRightSide)) {
            this.animator = createAnimator();
            this.fromValue = fromValue;
            this.toValue = toValue;
            this.radius = radius;
            this.height = radius * 2;
            this.isRightSide = isRightSide;
            this.rectLeftX = fromValue - radius;
            this.rectRightX = fromValue + radius;
            long straightSizeDuration = (long) (((float) this.animationDuration) * 0.7f);
            long reverseSizeDuration = this.animationDuration;
            long reverseHeightDelay = (long) (((float) this.animationDuration) * PERCENTAGE_REVERSE_HEIGHT_DELAY);
            WormAnimation.AnimationValues values = createAnimationValues(isRightSide);
            ValueAnimator straightAnimator = createWormAnimator(values.fromX, values.toX, straightSizeDuration, false);
            ValueAnimator straightHeightAnimator = createHeightAnimator(this.height, this.height / 2, 0);
            ((AnimatorSet) this.animator).playTogether(new Animator[]{straightAnimator, createWormAnimator(values.reverseFromX, values.reverseToX, reverseSizeDuration, true), straightHeightAnimator, createHeightAnimator(this.height / 2, this.height, reverseHeightDelay)});
        }
        return this;
    }

    private ValueAnimator createHeightAnimator(int fromHeight, int toHeight, long startDelay) {
        ValueAnimator anim = ValueAnimator.ofInt(new int[]{fromHeight, toHeight});
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.setDuration((long) (((float) this.animationDuration) * PERCENTAGE_HEIGHT_DURATION));
        anim.setStartDelay(startDelay);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                int unused = ThinWormAnimation.this.height = ((Integer) animation.getAnimatedValue()).intValue();
                ThinWormAnimation.this.listener.onThinWormAnimationUpdated(ThinWormAnimation.this.rectLeftX, ThinWormAnimation.this.rectRightX, ThinWormAnimation.this.height);
            }
        });
        return anim;
    }

    public ThinWormAnimation progress(float progress) {
        if (this.animator != null) {
            long duration = (long) (((float) this.animationDuration) * progress);
            int size = ((AnimatorSet) this.animator).getChildAnimations().size();
            long minus = (long) (((float) this.animationDuration) * PERCENTAGE_REVERSE_HEIGHT_DELAY);
            for (int i = 0; i < size; i++) {
                ValueAnimator anim = (ValueAnimator) ((AnimatorSet) this.animator).getChildAnimations().get(i);
                if (i == 3) {
                    if (duration < minus) {
                        break;
                    }
                    duration -= minus;
                }
                long currPlayTime = duration;
                if (currPlayTime >= anim.getDuration()) {
                    currPlayTime = anim.getDuration();
                }
                if (anim.getValues() != null && anim.getValues().length > 0) {
                    anim.setCurrentPlayTime(currPlayTime);
                }
            }
        }
        return this;
    }
}
