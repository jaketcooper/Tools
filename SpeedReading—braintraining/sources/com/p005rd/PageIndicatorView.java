package com.p005rd;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.text.TextUtilsCompat;
import android.support.p000v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import com.p005rd.animation.AbsAnimation;
import com.p005rd.animation.AnimationType;
import com.p005rd.animation.ColorAnimation;
import com.p005rd.animation.ValueAnimation;
import com.p005rd.pageindicatorview.C0695R;
import com.p005rd.utils.DensityUtils;

/* renamed from: com.rd.PageIndicatorView */
public class PageIndicatorView extends View implements ViewPager.OnPageChangeListener {
    private static final int COUNT_NOT_SET = -1;
    private static final int DEFAULT_CIRCLES_COUNT = 3;
    private static final int DEFAULT_PADDING_DP = 8;
    private static final int DEFAULT_RADIUS_DP = 6;
    private ValueAnimation animation;
    private long animationDuration;
    private AnimationType animationType = AnimationType.NONE;
    private int count;
    private boolean dynamicCount;
    private Paint fillPaint = new Paint();
    /* access modifiers changed from: private */
    public int frameColor;
    /* access modifiers changed from: private */
    public int frameColorReverse;
    /* access modifiers changed from: private */
    public int frameHeight;
    /* access modifiers changed from: private */
    public int frameLeftX;
    /* access modifiers changed from: private */
    public int frameRadiusPx;
    /* access modifiers changed from: private */
    public int frameRadiusReversePx;
    /* access modifiers changed from: private */
    public int frameRightX;
    /* access modifiers changed from: private */
    public int frameStrokePx;
    /* access modifiers changed from: private */
    public int frameStrokeReversePx;
    /* access modifiers changed from: private */
    public int frameX;
    /* access modifiers changed from: private */
    public int frameY;
    private boolean interactiveAnimation;
    private boolean isCountSet;
    private boolean isFrameValuesSet;
    /* access modifiers changed from: private */
    public int lastSelectedPosition;
    private int paddingPx;
    private int radiusPx;
    private RectF rect = new RectF();
    private RtlMode rtlMode = RtlMode.Off;
    private float scaleFactor;
    private int selectedColor;
    /* access modifiers changed from: private */
    public int selectedPosition;
    /* access modifiers changed from: private */
    public int selectingPosition;
    private DataSetObserver setObserver;
    private Paint strokePaint = new Paint();
    private int strokePx;
    private int unselectedColor;
    /* access modifiers changed from: private */
    public ViewPager viewPager;
    private int viewPagerId;

    public PageIndicatorView(Context context) {
        super(context);
        init((AttributeSet) null);
    }

    public PageIndicatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public PageIndicatorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @TargetApi(21)
    public PageIndicatorView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        findViewPager();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        unRegisterSetObserver();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        PositionSavedState positionSavedState = new PositionSavedState(super.onSaveInstanceState());
        positionSavedState.setSelectedPosition(this.selectedPosition);
        positionSavedState.setSelectingPosition(this.selectingPosition);
        positionSavedState.setLastSelectedPosition(this.lastSelectedPosition);
        return positionSavedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof PositionSavedState) {
            PositionSavedState positionSavedState = (PositionSavedState) state;
            this.selectedPosition = positionSavedState.getSelectedPosition();
            this.selectingPosition = positionSavedState.getSelectingPosition();
            this.lastSelectedPosition = positionSavedState.getLastSelectedPosition();
            super.onRestoreInstanceState(positionSavedState.getSuperState());
            return;
        }
        super.onRestoreInstanceState(state);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width;
        int height;
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);
        int circleDiameterPx = this.radiusPx * 2;
        int desiredHeight = circleDiameterPx + this.strokePx;
        int desiredWidth = 0;
        if (this.count != 0) {
            int diameterSum = circleDiameterPx * this.count;
            int strokeSum = this.strokePx * 2 * this.count;
            desiredWidth = diameterSum + strokeSum + (this.paddingPx * (this.count - 1));
        }
        if (widthMode == 1073741824) {
            width = widthSize;
        } else if (widthMode == Integer.MIN_VALUE) {
            width = Math.min(desiredWidth, widthSize);
        } else {
            width = desiredWidth;
        }
        if (heightMode == 1073741824) {
            height = heightSize;
        } else if (heightMode == Integer.MIN_VALUE) {
            height = Math.min(desiredHeight, heightSize);
        } else {
            height = desiredHeight;
        }
        if (this.animationType == AnimationType.DROP) {
            height *= 2;
        }
        if (width < 0) {
            width = 0;
        }
        if (height < 0) {
            height = 0;
        }
        setMeasuredDimension(width, height);
    }

    private boolean isViewMeasured() {
        return (getMeasuredHeight() == 0 && getMeasuredWidth() == 0) ? false : true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        setupFrameValues();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        drawIndicatorView(canvas);
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (isViewMeasured() && this.interactiveAnimation) {
            onPageScroll(position, positionOffset);
        }
    }

    public void onPageSelected(int position) {
        if ((this.viewPager != null && this.viewPager.getAdapter() != null && this.viewPager.getAdapter().getCount() < this.count) || !isViewMeasured()) {
            return;
        }
        if (!this.interactiveAnimation || this.animationType == AnimationType.NONE) {
            if (isRtl()) {
                position = (this.count - 1) - position;
            }
            setSelection(position);
        }
    }

    public void onPageScrollStateChanged(int state) {
    }

    public void setCount(int count2) {
        if (this.count != count2) {
            this.count = count2;
            this.isCountSet = true;
            requestLayout();
        }
    }

    public int getCount() {
        return this.count;
    }

    public void setDynamicCount(boolean dynamicCount2) {
        this.dynamicCount = dynamicCount2;
        if (dynamicCount2) {
            registerSetObserver();
        } else {
            unRegisterSetObserver();
        }
    }

    public void setRadius(int radiusDp) {
        if (radiusDp < 0) {
            radiusDp = 0;
        }
        this.radiusPx = DensityUtils.dpToPx(radiusDp);
        invalidate();
    }

    public void setRadius(float radiusPx2) {
        if (radiusPx2 < 0.0f) {
            radiusPx2 = 0.0f;
        }
        this.radiusPx = (int) radiusPx2;
        invalidate();
    }

    public int getRadius() {
        return this.radiusPx;
    }

    public void setPadding(int paddingDp) {
        if (paddingDp < 0) {
            paddingDp = 0;
        }
        this.paddingPx = DensityUtils.dpToPx(paddingDp);
        invalidate();
    }

    public void setPadding(float paddingPx2) {
        if (paddingPx2 < 0.0f) {
            paddingPx2 = 0.0f;
        }
        this.paddingPx = (int) paddingPx2;
        invalidate();
    }

    public int getPadding() {
        return this.paddingPx;
    }

    public void setScaleFactor(float factor) {
        if (factor > 1.0f) {
            factor = 1.0f;
        } else if (factor < 0.3f) {
            factor = 0.3f;
        }
        this.scaleFactor = factor;
    }

    public float getScaleFactor() {
        return this.scaleFactor;
    }

    public void setStrokeWidth(float strokePx2) {
        if (strokePx2 < 0.0f) {
            strokePx2 = 0.0f;
        } else if (strokePx2 > ((float) this.radiusPx)) {
            strokePx2 = (float) this.radiusPx;
        }
        this.strokePx = (int) strokePx2;
        invalidate();
    }

    public void setStrokeWidth(int strokeDp) {
        int strokePx2 = DensityUtils.dpToPx(strokeDp);
        if (strokePx2 < 0) {
            strokePx2 = 0;
        } else if (strokePx2 > this.radiusPx) {
            strokePx2 = this.radiusPx;
        }
        this.strokePx = strokePx2;
        invalidate();
    }

    public int getStrokeWidth() {
        return this.strokePx;
    }

    public void setUnselectedColor(int color) {
        this.unselectedColor = color;
        invalidate();
    }

    public int getUnselectedColor() {
        return this.unselectedColor;
    }

    public void setSelectedColor(int color) {
        this.selectedColor = color;
        invalidate();
    }

    public int getSelectedColor() {
        return this.selectedColor;
    }

    public void setAnimationDuration(long duration) {
        this.animationDuration = duration;
    }

    public long getAnimationDuration() {
        return this.animationDuration;
    }

    public void setAnimationType(@Nullable AnimationType type) {
        if (type != null) {
            this.animationType = type;
        } else {
            this.animationType = AnimationType.NONE;
        }
    }

    public void setInteractiveAnimation(boolean isInteractive) {
        this.interactiveAnimation = isInteractive;
    }

    public void setProgress(int selectingPosition2, float progress) {
        if (this.interactiveAnimation) {
            if (this.count <= 0 || selectingPosition2 < 0) {
                selectingPosition2 = 0;
            } else if (selectingPosition2 > this.count - 1) {
                selectingPosition2 = this.count - 1;
            }
            if (progress < 0.0f) {
                progress = 0.0f;
            } else if (progress > 1.0f) {
                progress = 1.0f;
            }
            this.selectingPosition = selectingPosition2;
            setAnimationProgress(progress);
        }
    }

    public void setSelection(int position) {
        if (position < 0) {
            position = 0;
        } else if (position > this.count - 1) {
            position = this.count - 1;
        }
        this.lastSelectedPosition = this.selectedPosition;
        this.selectedPosition = position;
        switch (this.animationType) {
            case NONE:
                invalidate();
                return;
            case COLOR:
                startColorAnimation();
                return;
            case SCALE:
                startScaleAnimation();
                return;
            case WORM:
                startWormAnimation();
                return;
            case FILL:
                startFillAnimation();
                return;
            case SLIDE:
                startSlideAnimation();
                return;
            case THIN_WORM:
                startThinWormAnimation();
                return;
            case DROP:
                startDropAnimation();
                return;
            case SWAP:
                startSwapAnimation();
                return;
            default:
                return;
        }
    }

    public int getSelection() {
        return this.selectedPosition;
    }

    public void setViewPager(@Nullable ViewPager pager) {
        releaseViewPager();
        if (pager != null) {
            this.viewPager = pager;
            this.viewPager.addOnPageChangeListener(this);
            setDynamicCount(this.dynamicCount);
            if (!this.isCountSet) {
                int count2 = getViewPagerCount();
                if (isRtl()) {
                    this.selectedPosition = (count2 - 1) - this.viewPager.getCurrentItem();
                }
                setCount(count2);
            }
        }
    }

    public void releaseViewPager() {
        if (this.viewPager != null) {
            this.viewPager.removeOnPageChangeListener(this);
            this.viewPager = null;
        }
    }

    public void setRtlMode(@Nullable RtlMode mode) {
        if (mode == null) {
            this.rtlMode = RtlMode.Off;
        } else {
            this.rtlMode = mode;
        }
    }

    private void onPageScroll(int position, float positionOffset) {
        Pair<Integer, Float> progressPair = getProgress(position, positionOffset);
        int selectingPosition2 = ((Integer) progressPair.first).intValue();
        float selectingProgress = ((Float) progressPair.second).floatValue();
        if (selectingProgress == 1.0f) {
            this.lastSelectedPosition = this.selectedPosition;
            this.selectedPosition = selectingPosition2;
        }
        setProgress(selectingPosition2, selectingProgress);
    }

    private void drawIndicatorView(@NonNull Canvas canvas) {
        int y = getYCoordinate();
        for (int i = 0; i < this.count; i++) {
            drawCircle(canvas, i, getXCoordinate(i), y);
        }
    }

    private void drawCircle(@NonNull Canvas canvas, int position, int x, int y) {
        boolean selectedItem;
        boolean selectingItem;
        if (this.interactiveAnimation || !(position == this.selectedPosition || position == this.lastSelectedPosition)) {
            selectedItem = false;
        } else {
            selectedItem = true;
        }
        if (!this.interactiveAnimation || !(position == this.selectingPosition || position == this.selectedPosition)) {
            selectingItem = false;
        } else {
            selectingItem = true;
        }
        if (selectedItem || selectingItem) {
            drawWithAnimationEffect(canvas, position, x, y);
        } else {
            drawWithNoEffect(canvas, position, x, y);
        }
    }

    private void drawWithAnimationEffect(@NonNull Canvas canvas, int position, int x, int y) {
        switch (this.animationType) {
            case NONE:
                drawWithNoEffect(canvas, position, x, y);
                return;
            case COLOR:
                drawWithColorAnimation(canvas, position, x, y);
                return;
            case SCALE:
                drawWithScaleAnimation(canvas, position, x, y);
                return;
            case WORM:
                drawWithWormAnimation(canvas, x, y);
                return;
            case FILL:
                drawWithFillAnimation(canvas, position, x, y);
                return;
            case SLIDE:
                drawWithSlideAnimation(canvas, position, x, y);
                return;
            case THIN_WORM:
                drawWithThinWormAnimation(canvas, x, y);
                return;
            case DROP:
                drawWithDropAnimation(canvas, x, y);
                return;
            case SWAP:
                drawWithSwapAnimation(canvas, position, x, y);
                return;
            default:
                return;
        }
    }

    private void drawWithNoEffect(@NonNull Canvas canvas, int position, int x, int y) {
        Paint paint;
        float radius = (float) this.radiusPx;
        if (this.animationType == AnimationType.SCALE) {
            radius *= this.scaleFactor;
        }
        int color = this.unselectedColor;
        if (position == this.selectedPosition) {
            color = this.selectedColor;
        }
        if (this.animationType == AnimationType.FILL) {
            paint = this.strokePaint;
            paint.setStrokeWidth((float) this.strokePx);
        } else {
            paint = this.fillPaint;
        }
        paint.setColor(color);
        canvas.drawCircle((float) x, (float) y, radius, paint);
    }

    private void drawWithColorAnimation(@NonNull Canvas canvas, int position, int x, int y) {
        int color = this.unselectedColor;
        if (this.interactiveAnimation) {
            if (position == this.selectingPosition) {
                color = this.frameColor;
            } else if (position == this.selectedPosition) {
                color = this.frameColorReverse;
            }
        } else if (position == this.selectedPosition) {
            color = this.frameColor;
        } else if (position == this.lastSelectedPosition) {
            color = this.frameColorReverse;
        }
        this.fillPaint.setColor(color);
        canvas.drawCircle((float) x, (float) y, (float) this.radiusPx, this.fillPaint);
    }

    private void drawWithScaleAnimation(@NonNull Canvas canvas, int position, int x, int y) {
        int color = this.unselectedColor;
        int radius = this.radiusPx;
        if (this.interactiveAnimation) {
            if (position == this.selectingPosition) {
                radius = this.frameRadiusPx;
                color = this.frameColor;
            } else if (position == this.selectedPosition) {
                radius = this.frameRadiusReversePx;
                color = this.frameColorReverse;
            }
        } else if (position == this.selectedPosition) {
            radius = this.frameRadiusPx;
            color = this.frameColor;
        } else if (position == this.lastSelectedPosition) {
            radius = this.frameRadiusReversePx;
            color = this.frameColorReverse;
        }
        this.fillPaint.setColor(color);
        canvas.drawCircle((float) x, (float) y, (float) radius, this.fillPaint);
    }

    private void drawWithSlideAnimation(@NonNull Canvas canvas, int position, int x, int y) {
        this.fillPaint.setColor(this.unselectedColor);
        canvas.drawCircle((float) x, (float) y, (float) this.radiusPx, this.fillPaint);
        if (this.interactiveAnimation && (position == this.selectingPosition || position == this.selectedPosition)) {
            this.fillPaint.setColor(this.selectedColor);
            canvas.drawCircle((float) this.frameX, (float) y, (float) this.radiusPx, this.fillPaint);
        } else if (this.interactiveAnimation) {
        } else {
            if (position == this.selectedPosition || position == this.lastSelectedPosition) {
                this.fillPaint.setColor(this.selectedColor);
                canvas.drawCircle((float) this.frameX, (float) y, (float) this.radiusPx, this.fillPaint);
            }
        }
    }

    private void drawWithWormAnimation(@NonNull Canvas canvas, int x, int y) {
        int radius = this.radiusPx;
        int left = this.frameLeftX;
        int right = this.frameRightX;
        this.rect.left = (float) left;
        this.rect.right = (float) right;
        this.rect.top = (float) (y - radius);
        this.rect.bottom = (float) (y + radius);
        this.fillPaint.setColor(this.unselectedColor);
        canvas.drawCircle((float) x, (float) y, (float) radius, this.fillPaint);
        this.fillPaint.setColor(this.selectedColor);
        canvas.drawRoundRect(this.rect, (float) this.radiusPx, (float) this.radiusPx, this.fillPaint);
    }

    private void drawWithFillAnimation(@NonNull Canvas canvas, int position, int x, int y) {
        int color = this.unselectedColor;
        float radius = (float) this.radiusPx;
        int stroke = this.strokePx;
        if (this.interactiveAnimation) {
            if (position == this.selectingPosition) {
                color = this.frameColor;
                radius = (float) this.frameRadiusPx;
                stroke = this.frameStrokePx;
            } else if (position == this.selectedPosition) {
                color = this.frameColorReverse;
                radius = (float) this.frameRadiusReversePx;
                stroke = this.frameStrokeReversePx;
            }
        } else if (position == this.selectedPosition) {
            color = this.frameColor;
            radius = (float) this.frameRadiusPx;
            stroke = this.frameStrokePx;
        } else if (position == this.lastSelectedPosition) {
            color = this.frameColorReverse;
            radius = (float) this.frameRadiusReversePx;
            stroke = this.frameStrokeReversePx;
        }
        this.strokePaint.setColor(color);
        this.strokePaint.setStrokeWidth((float) this.strokePx);
        canvas.drawCircle((float) x, (float) y, (float) this.radiusPx, this.strokePaint);
        this.strokePaint.setStrokeWidth((float) stroke);
        canvas.drawCircle((float) x, (float) y, radius, this.strokePaint);
    }

    private void drawWithThinWormAnimation(@NonNull Canvas canvas, int x, int y) {
        int radius = this.radiusPx;
        int left = this.frameLeftX;
        int right = this.frameRightX;
        int top = y - (this.frameHeight / 2);
        int bot = y + (this.frameHeight / 2);
        this.rect.left = (float) left;
        this.rect.right = (float) right;
        this.rect.top = (float) top;
        this.rect.bottom = (float) bot;
        this.fillPaint.setColor(this.unselectedColor);
        canvas.drawCircle((float) x, (float) y, (float) radius, this.fillPaint);
        this.fillPaint.setColor(this.selectedColor);
        canvas.drawRoundRect(this.rect, (float) this.radiusPx, (float) this.radiusPx, this.fillPaint);
    }

    private void drawWithDropAnimation(@NonNull Canvas canvas, int x, int y) {
        this.fillPaint.setColor(this.unselectedColor);
        canvas.drawCircle((float) x, (float) y, (float) this.radiusPx, this.fillPaint);
        this.fillPaint.setColor(this.selectedColor);
        canvas.drawCircle((float) this.frameX, (float) this.frameY, (float) this.frameRadiusPx, this.fillPaint);
    }

    private void drawWithSwapAnimation(@NonNull Canvas canvas, int position, int x, int y) {
        this.fillPaint.setColor(this.unselectedColor);
        if (position == this.selectedPosition) {
            this.fillPaint.setColor(this.selectedColor);
            canvas.drawCircle((float) this.frameX, (float) y, (float) this.radiusPx, this.fillPaint);
        } else if (this.interactiveAnimation && position == this.selectingPosition) {
            canvas.drawCircle((float) (x - (this.frameX - getXCoordinate(this.selectedPosition))), (float) y, (float) this.radiusPx, this.fillPaint);
        } else if (!this.interactiveAnimation) {
            canvas.drawCircle((float) (x - (this.frameX - getXCoordinate(this.selectedPosition))), (float) y, (float) this.radiusPx, this.fillPaint);
        } else {
            canvas.drawCircle((float) x, (float) y, (float) this.radiusPx, this.fillPaint);
        }
    }

    private void init(@Nullable AttributeSet attrs) {
        setupId();
        initAttributes(attrs);
        initAnimation();
        this.fillPaint.setStyle(Paint.Style.FILL);
        this.fillPaint.setAntiAlias(true);
        this.strokePaint.setStyle(Paint.Style.STROKE);
        this.strokePaint.setAntiAlias(true);
        this.strokePaint.setStrokeWidth((float) this.strokePx);
    }

    private void setupId() {
        if (getId() == -1) {
            setId(Utils.generateViewId());
        }
    }

    private void initAttributes(@Nullable AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, C0695R.styleable.PageIndicatorView, 0, 0);
        initCountAttribute(typedArray);
        initColorAttribute(typedArray);
        initAnimationAttribute(typedArray);
        initSizeAttribute(typedArray);
    }

    private void initCountAttribute(@NonNull TypedArray typedArray) {
        this.dynamicCount = typedArray.getBoolean(C0695R.styleable.PageIndicatorView_piv_dynamicCount, false);
        this.count = typedArray.getInt(C0695R.styleable.PageIndicatorView_piv_count, -1);
        if (this.count != -1) {
            this.isCountSet = true;
        } else {
            this.count = 3;
        }
        int position = typedArray.getInt(C0695R.styleable.PageIndicatorView_piv_select, 0);
        if (position < 0) {
            position = 0;
        } else if (this.count > 0 && position > this.count - 1) {
            position = this.count - 1;
        }
        this.selectedPosition = position;
        this.selectingPosition = position;
        this.viewPagerId = typedArray.getResourceId(C0695R.styleable.PageIndicatorView_piv_viewPager, 0);
    }

    private void initColorAttribute(@NonNull TypedArray typedArray) {
        this.unselectedColor = typedArray.getColor(C0695R.styleable.PageIndicatorView_piv_unselectedColor, Color.parseColor(ColorAnimation.DEFAULT_UNSELECTED_COLOR));
        this.selectedColor = typedArray.getColor(C0695R.styleable.PageIndicatorView_piv_selectedColor, Color.parseColor(ColorAnimation.DEFAULT_SELECTED_COLOR));
    }

    private void initAnimationAttribute(@NonNull TypedArray typedArray) {
        this.animationDuration = (long) typedArray.getInt(C0695R.styleable.PageIndicatorView_piv_animationDuration, AbsAnimation.DEFAULT_ANIMATION_TIME);
        this.interactiveAnimation = typedArray.getBoolean(C0695R.styleable.PageIndicatorView_piv_interactiveAnimation, false);
        this.animationType = getAnimationType(typedArray.getInt(C0695R.styleable.PageIndicatorView_piv_animationType, AnimationType.NONE.ordinal()));
        this.rtlMode = getRtlMode(typedArray.getInt(C0695R.styleable.PageIndicatorView_piv_rtl_mode, RtlMode.Off.ordinal()));
    }

    private void initSizeAttribute(@NonNull TypedArray typedArray) {
        this.radiusPx = (int) typedArray.getDimension(C0695R.styleable.PageIndicatorView_piv_radius, (float) DensityUtils.dpToPx(6));
        this.paddingPx = (int) typedArray.getDimension(C0695R.styleable.PageIndicatorView_piv_padding, (float) DensityUtils.dpToPx(8));
        this.scaleFactor = typedArray.getFloat(C0695R.styleable.PageIndicatorView_piv_scaleFactor, 0.7f);
        if (this.scaleFactor < 0.3f) {
            this.scaleFactor = 0.3f;
        } else if (this.scaleFactor > 1.0f) {
            this.scaleFactor = 1.0f;
        }
        this.strokePx = (int) typedArray.getDimension(C0695R.styleable.PageIndicatorView_piv_strokeWidth, (float) DensityUtils.dpToPx(1));
        if (this.strokePx > this.radiusPx) {
            this.strokePx = this.radiusPx;
        }
        if (this.animationType != AnimationType.FILL) {
            this.strokePx = 0;
        }
    }

    private void initAnimation() {
        this.animation = new ValueAnimation(new ValueAnimation.UpdateListener() {
            public void onColorAnimationUpdated(int color, int colorReverse) {
                int unused = PageIndicatorView.this.frameColor = color;
                int unused2 = PageIndicatorView.this.frameColorReverse = colorReverse;
                PageIndicatorView.this.invalidate();
            }

            public void onScaleAnimationUpdated(int color, int colorReverse, int radius, int radiusReverse) {
                int unused = PageIndicatorView.this.frameColor = color;
                int unused2 = PageIndicatorView.this.frameColorReverse = colorReverse;
                int unused3 = PageIndicatorView.this.frameRadiusPx = radius;
                int unused4 = PageIndicatorView.this.frameRadiusReversePx = radiusReverse;
                PageIndicatorView.this.invalidate();
            }

            public void onSlideAnimationUpdated(int xCoordinate) {
                int unused = PageIndicatorView.this.frameX = xCoordinate;
                PageIndicatorView.this.invalidate();
            }

            public void onWormAnimationUpdated(int leftX, int rightX) {
                int unused = PageIndicatorView.this.frameLeftX = leftX;
                int unused2 = PageIndicatorView.this.frameRightX = rightX;
                PageIndicatorView.this.invalidate();
            }

            public void onThinWormAnimationUpdated(int leftX, int rightX, int height) {
                int unused = PageIndicatorView.this.frameLeftX = leftX;
                int unused2 = PageIndicatorView.this.frameRightX = rightX;
                int unused3 = PageIndicatorView.this.frameHeight = height;
                PageIndicatorView.this.invalidate();
            }

            public void onFillAnimationUpdated(int color, int colorReverse, int radius, int radiusReverse, int stroke, int strokeReverse) {
                int unused = PageIndicatorView.this.frameColor = color;
                int unused2 = PageIndicatorView.this.frameColorReverse = colorReverse;
                int unused3 = PageIndicatorView.this.frameRadiusPx = radius;
                int unused4 = PageIndicatorView.this.frameRadiusReversePx = radiusReverse;
                int unused5 = PageIndicatorView.this.frameStrokePx = stroke;
                int unused6 = PageIndicatorView.this.frameStrokeReversePx = strokeReverse;
                PageIndicatorView.this.invalidate();
            }

            public void onDropAnimationUpdated(int x, int y, int selectedRadius) {
                int unused = PageIndicatorView.this.frameX = x;
                int unused2 = PageIndicatorView.this.frameY = y;
                int unused3 = PageIndicatorView.this.frameRadiusPx = selectedRadius;
                PageIndicatorView.this.invalidate();
            }

            public void onSwapAnimationUpdated(int xCoordinate) {
                int unused = PageIndicatorView.this.frameX = xCoordinate;
                PageIndicatorView.this.invalidate();
            }
        });
    }

    private AnimationType getAnimationType(int index) {
        switch (index) {
            case 0:
                return AnimationType.NONE;
            case 1:
                return AnimationType.COLOR;
            case 2:
                return AnimationType.SCALE;
            case 3:
                return AnimationType.WORM;
            case 4:
                return AnimationType.SLIDE;
            case 5:
                return AnimationType.FILL;
            case 6:
                return AnimationType.THIN_WORM;
            case 7:
                return AnimationType.DROP;
            case 8:
                return AnimationType.SWAP;
            default:
                return AnimationType.NONE;
        }
    }

    private RtlMode getRtlMode(int index) {
        switch (index) {
            case 0:
                return RtlMode.On;
            case 1:
                return RtlMode.Off;
            case 2:
                return RtlMode.Auto;
            default:
                return RtlMode.Auto;
        }
    }

    /* access modifiers changed from: private */
    public void resetFrameValues() {
        this.isFrameValuesSet = false;
        setupFrameValues();
    }

    private void setupFrameValues() {
        if (!this.isFrameValuesSet) {
            this.frameColor = this.selectedColor;
            this.frameColorReverse = this.unselectedColor;
            this.frameRadiusPx = this.radiusPx;
            this.frameRadiusReversePx = this.radiusPx;
            int xCoordinate = getXCoordinate(this.selectedPosition);
            if (xCoordinate - this.radiusPx >= 0) {
                this.frameLeftX = xCoordinate - this.radiusPx;
                this.frameRightX = this.radiusPx + xCoordinate;
            } else {
                this.frameLeftX = xCoordinate;
                this.frameRightX = (this.radiusPx * 2) + xCoordinate;
            }
            this.frameX = xCoordinate;
            this.frameY = getYCoordinate();
            this.frameStrokePx = this.radiusPx;
            this.frameStrokeReversePx = this.radiusPx / 2;
            if (this.animationType == AnimationType.FILL) {
                this.frameRadiusPx = this.radiusPx / 2;
                this.frameRadiusReversePx = this.radiusPx;
            }
            this.frameHeight = this.radiusPx * 2;
            this.isFrameValuesSet = true;
        }
    }

    private void startColorAnimation() {
        this.animation.color().end();
        this.animation.color().with(this.unselectedColor, this.selectedColor).duration(this.animationDuration).start();
    }

    private void startScaleAnimation() {
        this.animation.scale().end();
        this.animation.scale().with(this.unselectedColor, this.selectedColor, this.radiusPx, this.scaleFactor).duration(this.animationDuration).start();
    }

    private void startSlideAnimation() {
        int fromX = getXCoordinate(this.lastSelectedPosition);
        int toX = getXCoordinate(this.selectedPosition);
        this.animation.slide().end();
        this.animation.slide().with(fromX, toX).duration(this.animationDuration).start();
    }

    private void startWormAnimation() {
        int fromX = getXCoordinate(this.lastSelectedPosition);
        int toX = getXCoordinate(this.selectedPosition);
        boolean isRightSide = this.selectedPosition > this.lastSelectedPosition;
        this.animation.worm().end();
        this.animation.worm().duration(this.animationDuration).with(fromX, toX, this.radiusPx, isRightSide).start();
    }

    private void startFillAnimation() {
        this.animation.fill().end();
        this.animation.fill().with(this.unselectedColor, this.selectedColor, this.radiusPx, this.strokePx).duration(this.animationDuration).start();
    }

    private void startThinWormAnimation() {
        int fromX = getXCoordinate(this.lastSelectedPosition);
        int toX = getXCoordinate(this.selectedPosition);
        boolean isRightSide = this.selectedPosition > this.lastSelectedPosition;
        this.animation.thinWorm().end();
        this.animation.thinWorm().duration(this.animationDuration).with(fromX, toX, this.radiusPx, isRightSide).start();
    }

    private void startDropAnimation() {
        int fromX = getXCoordinate(this.lastSelectedPosition);
        int toX = getXCoordinate(this.selectedPosition);
        int fromY = getYCoordinate();
        this.animation.drop().end();
        this.animation.drop().duration(this.animationDuration).with(fromX, toX, fromY, this.radiusPx).start();
    }

    private void startSwapAnimation() {
        int fromX = getXCoordinate(this.lastSelectedPosition);
        int toX = getXCoordinate(this.selectedPosition);
        this.animation.swap().end();
        this.animation.swap().with(fromX, toX).duration(this.animationDuration).start();
    }

    @Nullable
    private AbsAnimation setAnimationProgress(float progress) {
        switch (this.animationType) {
            case COLOR:
                return this.animation.color().with(this.unselectedColor, this.selectedColor).progress(progress);
            case SCALE:
                return this.animation.scale().with(this.unselectedColor, this.selectedColor, this.radiusPx, this.scaleFactor).progress(progress);
            case WORM:
            case SLIDE:
            case THIN_WORM:
            case DROP:
            case SWAP:
                int fromX = getXCoordinate(this.selectedPosition);
                int toX = getXCoordinate(this.selectingPosition);
                if (this.animationType == AnimationType.SLIDE) {
                    return this.animation.slide().with(fromX, toX).progress(progress);
                }
                if (this.animationType == AnimationType.SWAP) {
                    return this.animation.swap().with(fromX, toX).progress(progress);
                }
                if (this.animationType == AnimationType.WORM || this.animationType == AnimationType.THIN_WORM) {
                    boolean isRightSide = this.selectingPosition > this.selectedPosition;
                    if (this.animationType == AnimationType.WORM) {
                        return this.animation.worm().with(fromX, toX, this.radiusPx, isRightSide).progress(progress);
                    }
                    if (this.animationType == AnimationType.THIN_WORM) {
                        return this.animation.thinWorm().with(fromX, toX, this.radiusPx, isRightSide).progress(progress);
                    }
                } else {
                    return this.animation.drop().with(fromX, toX, getYCoordinate(), this.radiusPx).progress(progress);
                }
                break;
            case FILL:
                return this.animation.fill().with(this.unselectedColor, this.selectedColor, this.radiusPx, this.strokePx).progress(progress);
        }
        return null;
    }

    private void registerSetObserver() {
        if (this.setObserver == null && this.viewPager != null && this.viewPager.getAdapter() != null) {
            this.setObserver = new DataSetObserver() {
                public void onChanged() {
                    if (PageIndicatorView.this.viewPager != null && PageIndicatorView.this.viewPager.getAdapter() != null) {
                        int newCount = PageIndicatorView.this.viewPager.getAdapter().getCount();
                        int currItem = PageIndicatorView.this.viewPager.getCurrentItem();
                        int unused = PageIndicatorView.this.selectedPosition = currItem;
                        int unused2 = PageIndicatorView.this.selectingPosition = currItem;
                        int unused3 = PageIndicatorView.this.lastSelectedPosition = currItem;
                        PageIndicatorView.this.endAnimation();
                        PageIndicatorView.this.setCount(newCount);
                        PageIndicatorView.this.resetFrameValues();
                        PageIndicatorView.this.setProgress(PageIndicatorView.this.selectingPosition, 1.0f);
                    }
                }
            };
            try {
                this.viewPager.getAdapter().registerDataSetObserver(this.setObserver);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void endAnimation() {
        AbsAnimation anim = null;
        switch (this.animationType) {
            case COLOR:
                anim = this.animation.color();
                break;
            case SCALE:
                anim = this.animation.scale();
                break;
            case WORM:
                anim = this.animation.worm();
                break;
            case FILL:
                anim = this.animation.fill();
                break;
            case SLIDE:
                anim = this.animation.slide();
                break;
            case THIN_WORM:
                anim = this.animation.thinWorm();
                break;
            case DROP:
                anim = this.animation.drop();
                break;
            case SWAP:
                anim = this.animation.swap();
                break;
        }
        if (anim != null) {
            anim.end();
        }
    }

    private void unRegisterSetObserver() {
        if (this.setObserver != null && this.viewPager != null && this.viewPager.getAdapter() != null) {
            try {
                this.viewPager.getAdapter().unregisterDataSetObserver(this.setObserver);
                this.setObserver = null;
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    private int getViewPagerCount() {
        if (this.viewPager == null || this.viewPager.getAdapter() == null) {
            return this.count;
        }
        return this.viewPager.getAdapter().getCount();
    }

    private void findViewPager() {
        View view;
        if (this.viewPagerId != 0 && (getContext() instanceof Activity) && (view = ((Activity) getContext()).findViewById(this.viewPagerId)) != null && (view instanceof ViewPager)) {
            setViewPager((ViewPager) view);
        }
    }

    private int getXCoordinate(int position) {
        int x = 0;
        for (int i = 0; i < this.count; i++) {
            int x2 = x + this.radiusPx + this.strokePx;
            if (position == i) {
                return x2;
            }
            x = x2 + this.radiusPx + this.paddingPx;
        }
        return x;
    }

    private int getYCoordinate() {
        int y = getHeight() / 2;
        if (this.animationType == AnimationType.DROP) {
            return y + this.radiusPx;
        }
        return y;
    }

    private Pair<Integer, Float> getProgress(int position, float positionOffset) {
        boolean isRightOverScrolled;
        boolean isLeftOverScrolled;
        boolean isSlideToRightSide;
        int selectingPosition2;
        float selectingProgress;
        if (isRtl() && (position = (this.count - 1) - position) < 0) {
            position = 0;
        }
        if (position > this.selectedPosition) {
            isRightOverScrolled = true;
        } else {
            isRightOverScrolled = false;
        }
        if (isRtl()) {
            isLeftOverScrolled = position + -1 < this.selectedPosition;
        } else {
            isLeftOverScrolled = position + 1 < this.selectedPosition;
        }
        if (isRightOverScrolled || isLeftOverScrolled) {
            this.selectedPosition = position;
        }
        if (this.selectedPosition != position || positionOffset == 0.0f) {
            isSlideToRightSide = false;
        } else {
            isSlideToRightSide = true;
        }
        if (isSlideToRightSide) {
            selectingPosition2 = isRtl() ? position - 1 : position + 1;
            selectingProgress = positionOffset;
        } else {
            selectingPosition2 = position;
            selectingProgress = 1.0f - positionOffset;
        }
        if (selectingProgress > 1.0f) {
            selectingProgress = 1.0f;
        } else if (selectingProgress < 0.0f) {
            selectingProgress = 0.0f;
        }
        return new Pair<>(Integer.valueOf(selectingPosition2), Float.valueOf(selectingProgress));
    }

    private boolean isRtl() {
        switch (this.rtlMode) {
            case On:
                return true;
            case Off:
                return false;
            case Auto:
                return TextUtilsCompat.getLayoutDirectionFromLocale(getContext().getResources().getConfiguration().locale) == 1;
            default:
                return false;
        }
    }
}
