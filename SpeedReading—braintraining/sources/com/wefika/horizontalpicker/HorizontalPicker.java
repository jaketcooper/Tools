package com.wefika.horizontalpicker;

import android.animation.ArgbEvaluator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p000v4.text.TextDirectionHeuristicCompat;
import android.support.p000v4.text.TextDirectionHeuristicsCompat;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.p000v4.widget.ExploreByTouchHelper;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import java.lang.ref.WeakReference;
import java.util.List;

public class HorizontalPicker extends View {
    private static final int SELECTOR_ADJUSTMENT_DURATION_MILLIS = 800;
    private static final int SELECTOR_MAX_FLING_VELOCITY_ADJUSTMENT = 4;
    public static final String TAG = "HorizontalTimePicker";
    private OverScroller adjustScrollerX;
    private BoringLayout.Metrics boringMetrics;
    /* access modifiers changed from: private */
    public float dividerSize;
    private TextUtils.TruncateAt ellipsize;
    private OverScroller flingScrollerX;
    private RectF itemClipBounds;
    private RectF itemClipBoundsOffset;
    /* access modifiers changed from: private */
    public int itemWidth;
    private float lastDownEventX;
    private BoringLayout[] layouts;
    private EdgeEffect leftEdgeEffect;
    private int mMinimumFlingVelocity;
    private VelocityTracker mVelocityTracker;
    private Marquee marquee;
    private int marqueeRepeatLimit;
    private int maximumFlingVelocity;
    /* access modifiers changed from: private */
    public OnItemClicked onItemClicked;
    /* access modifiers changed from: private */
    public OnItemSelected onItemSelected;
    private final int overscrollDistance;
    private int pressedItem;
    private int previousScrollerX;
    private EdgeEffect rightEdgeEffect;
    private boolean scrollingX;
    private int selectedItem;
    /* access modifiers changed from: private */
    public int sideItems;
    private ColorStateList textColor;
    private TextDirectionHeuristicCompat textDir;
    private TextPaint textPaint;
    private final PickerTouchHelper touchHelper;
    private int touchSlop;
    /* access modifiers changed from: private */
    public CharSequence[] values;

    public interface OnItemClicked {
        void onItemClicked(int i);
    }

    public interface OnItemSelected {
        void onItemSelected(int i);
    }

    public HorizontalPicker(Context context) {
        this(context, (AttributeSet) null);
    }

    public HorizontalPicker(Context context, AttributeSet attrs) {
        this(context, attrs, C1139R.attr.horizontalPickerStyle);
    }

    public HorizontalPicker(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.pressedItem = -1;
        this.marqueeRepeatLimit = 3;
        this.dividerSize = 0.0f;
        this.sideItems = 1;
        TextPaint paint = new TextPaint();
        paint.setAntiAlias(true);
        this.textPaint = paint;
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, C1139R.styleable.HorizontalPicker, defStyle, 0);
        int sideItems2 = this.sideItems;
        try {
            this.textColor = a.getColorStateList(C1139R.styleable.HorizontalPicker_android_textColor);
            if (this.textColor == null) {
                this.textColor = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
            }
            CharSequence[] values2 = a.getTextArray(C1139R.styleable.HorizontalPicker_values);
            int ellipsize2 = a.getInt(C1139R.styleable.HorizontalPicker_android_ellipsize, 3);
            this.marqueeRepeatLimit = a.getInt(C1139R.styleable.HorizontalPicker_android_marqueeRepeatLimit, this.marqueeRepeatLimit);
            this.dividerSize = a.getDimension(C1139R.styleable.HorizontalPicker_dividerSize, this.dividerSize);
            int sideItems3 = a.getInt(C1139R.styleable.HorizontalPicker_sideItems, sideItems2);
            float textSize = a.getDimension(C1139R.styleable.HorizontalPicker_android_textSize, -1.0f);
            if (textSize > -1.0f) {
                setTextSize(textSize);
            }
            switch (ellipsize2) {
                case 1:
                    setEllipsize(TextUtils.TruncateAt.START);
                    break;
                case 2:
                    setEllipsize(TextUtils.TruncateAt.MIDDLE);
                    break;
                case 3:
                    setEllipsize(TextUtils.TruncateAt.END);
                    break;
                case 4:
                    setEllipsize(TextUtils.TruncateAt.MARQUEE);
                    break;
            }
            Paint.FontMetricsInt fontMetricsInt = this.textPaint.getFontMetricsInt();
            this.boringMetrics = new BoringLayout.Metrics();
            this.boringMetrics.ascent = fontMetricsInt.ascent;
            this.boringMetrics.bottom = fontMetricsInt.bottom;
            this.boringMetrics.descent = fontMetricsInt.descent;
            this.boringMetrics.leading = fontMetricsInt.leading;
            this.boringMetrics.top = fontMetricsInt.top;
            this.boringMetrics.width = this.itemWidth;
            setWillNotDraw(false);
            this.flingScrollerX = new OverScroller(context);
            this.adjustScrollerX = new OverScroller(context, new DecelerateInterpolator(2.5f));
            ViewConfiguration configuration = ViewConfiguration.get(context);
            this.touchSlop = configuration.getScaledTouchSlop();
            this.mMinimumFlingVelocity = configuration.getScaledMinimumFlingVelocity();
            this.maximumFlingVelocity = configuration.getScaledMaximumFlingVelocity() / 4;
            this.overscrollDistance = configuration.getScaledOverscrollDistance();
            this.previousScrollerX = Integer.MIN_VALUE;
            setValues(values2);
            setSideItems(sideItems3);
            this.touchHelper = new PickerTouchHelper(this);
            ViewCompat.setAccessibilityDelegate(this, this.touchHelper);
        } finally {
            a.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height;
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int width = View.MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);
        if (heightMode == 1073741824) {
            height = heightSize;
        } else {
            Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
            int heightText = ((int) (Math.abs(fontMetrics.ascent) + Math.abs(fontMetrics.descent))) + getPaddingTop() + getPaddingBottom();
            if (heightMode == Integer.MIN_VALUE) {
                height = Math.min(heightSize, heightText);
            } else {
                height = heightText;
            }
        }
        setMeasuredDimension(width, height);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        RectF clipBounds;
        super.onDraw(canvas);
        int saveCount = canvas.getSaveCount();
        canvas.save();
        int selectedItem2 = this.selectedItem;
        float itemWithPadding = ((float) this.itemWidth) + this.dividerSize;
        canvas.translate(((float) this.sideItems) * itemWithPadding, 0.0f);
        if (this.values != null) {
            for (int i = 0; i < this.values.length; i++) {
                this.textPaint.setColor(getTextColor(i));
                BoringLayout layout = this.layouts[i];
                int saveCountHeight = canvas.getSaveCount();
                canvas.save();
                float x = 0.0f;
                float lineWidth = layout.getLineWidth(0);
                if (lineWidth > ((float) this.itemWidth)) {
                    if (isRtl(this.values[i])) {
                        x = 0.0f + ((lineWidth - ((float) this.itemWidth)) / 2.0f);
                    } else {
                        x = 0.0f - ((lineWidth - ((float) this.itemWidth)) / 2.0f);
                    }
                }
                if (this.marquee != null && i == selectedItem2) {
                    x += this.marquee.getScroll();
                }
                canvas.translate(-x, (float) ((canvas.getHeight() - layout.getHeight()) / 2));
                if (x == 0.0f) {
                    clipBounds = this.itemClipBounds;
                } else {
                    clipBounds = this.itemClipBoundsOffset;
                    clipBounds.set(this.itemClipBounds);
                    clipBounds.offset(x, 0.0f);
                }
                canvas.clipRect(clipBounds);
                layout.draw(canvas);
                if (this.marquee != null && i == selectedItem2 && this.marquee.shouldDrawGhost()) {
                    canvas.translate(this.marquee.getGhostOffset(), 0.0f);
                    layout.draw(canvas);
                }
                canvas.restoreToCount(saveCountHeight);
                canvas.translate(itemWithPadding, 0.0f);
            }
        }
        canvas.restoreToCount(saveCount);
        drawEdgeEffect(canvas, this.leftEdgeEffect, 270);
        drawEdgeEffect(canvas, this.rightEdgeEffect, 90);
    }

    @TargetApi(17)
    public void onRtlPropertiesChanged(int layoutDirection) {
        super.onRtlPropertiesChanged(layoutDirection);
        this.textDir = getTextDirectionHeuristic();
    }

    private boolean isRtl(CharSequence text) {
        if (this.textDir == null) {
            this.textDir = getTextDirectionHeuristic();
        }
        return this.textDir.isRtl(text, 0, text.length());
    }

    private TextDirectionHeuristicCompat getTextDirectionHeuristic() {
        boolean defaultIsRtl = true;
        if (Build.VERSION.SDK_INT < 17) {
            return TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        }
        if (getLayoutDirection() != 1) {
            defaultIsRtl = false;
        }
        switch (getTextDirection()) {
            case 2:
                return TextDirectionHeuristicsCompat.ANYRTL_LTR;
            case 3:
                return TextDirectionHeuristicsCompat.LTR;
            case 4:
                return TextDirectionHeuristicsCompat.RTL;
            case 5:
                return TextDirectionHeuristicsCompat.LOCALE;
            default:
                if (defaultIsRtl) {
                    return TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
                }
                return TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        }
    }

    private void remakeLayout() {
        if (this.layouts != null && this.layouts.length > 0 && getWidth() > 0) {
            for (int i = 0; i < this.layouts.length; i++) {
                this.layouts[i].replaceOrMake(this.values[i], this.textPaint, this.itemWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, this.boringMetrics, false, this.ellipsize, this.itemWidth);
            }
        }
    }

    private void drawEdgeEffect(Canvas canvas, EdgeEffect edgeEffect, int degrees) {
        if (canvas != null && edgeEffect != null) {
            if ((degrees == 90 || degrees == 270) && !edgeEffect.isFinished()) {
                int restoreCount = canvas.getSaveCount();
                int width = getWidth();
                int height = getHeight();
                canvas.rotate((float) degrees);
                if (degrees == 270) {
                    canvas.translate((float) (-height), (float) Math.max(0, getScrollX()));
                } else {
                    canvas.translate(0.0f, -(Math.max((float) getScrollRange(), getScaleX()) + ((float) width)));
                }
                edgeEffect.setSize(height, width);
                if (edgeEffect.draw(canvas)) {
                    if (Build.VERSION.SDK_INT >= 16) {
                        postInvalidateOnAnimation();
                    } else {
                        postInvalidate();
                    }
                }
                canvas.restoreToCount(restoreCount);
            }
        }
    }

    private int getTextColor(int item) {
        int scrollX = getScrollX();
        int color = this.textColor.getDefaultColor();
        int itemWithPadding = (int) (((float) this.itemWidth) + this.dividerSize);
        if (scrollX > (itemWithPadding * item) - (itemWithPadding / 2) && scrollX < ((item + 1) * itemWithPadding) - (itemWithPadding / 2)) {
            return getColor(scrollX - (itemWithPadding / 2), item);
        }
        if (item != this.pressedItem) {
            return color;
        }
        return this.textColor.getColorForState(new int[]{16842919}, color);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        calculateItemSize(w, h);
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnabled()) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(event);
        switch (event.getActionMasked()) {
            case 0:
                if (!this.adjustScrollerX.isFinished()) {
                    this.adjustScrollerX.forceFinished(true);
                } else if (!this.flingScrollerX.isFinished()) {
                    this.flingScrollerX.forceFinished(true);
                } else {
                    this.scrollingX = false;
                }
                this.lastDownEventX = event.getX();
                if (!this.scrollingX) {
                    this.pressedItem = getPositionFromTouch(event.getX());
                }
                invalidate();
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, (float) this.maximumFlingVelocity);
                int initialVelocityX = (int) velocityTracker.getXVelocity();
                if (this.scrollingX && Math.abs(initialVelocityX) > this.mMinimumFlingVelocity) {
                    flingX(initialVelocityX);
                } else if (this.values != null) {
                    float positionX = event.getX();
                    if (!this.scrollingX) {
                        int relativePos = getPositionOnScreen(positionX) - this.sideItems;
                        if (relativePos == 0) {
                            selectItem();
                        } else {
                            smoothScrollBy(relativePos);
                        }
                    } else if (this.scrollingX) {
                        finishScrolling();
                    }
                }
                this.mVelocityTracker.recycle();
                this.mVelocityTracker = null;
                if (this.leftEdgeEffect != null) {
                    this.leftEdgeEffect.onRelease();
                    this.rightEdgeEffect.onRelease();
                    break;
                }
                break;
            case 2:
                float currentMoveX = event.getX();
                int deltaMoveX = (int) (this.lastDownEventX - currentMoveX);
                if (this.scrollingX || (Math.abs(deltaMoveX) > this.touchSlop && this.values != null && this.values.length > 0)) {
                    if (!this.scrollingX) {
                        deltaMoveX = 0;
                        this.pressedItem = -1;
                        this.scrollingX = true;
                        getParent().requestDisallowInterceptTouchEvent(true);
                        stopMarqueeIfNeeded();
                    }
                    int range = getScrollRange();
                    if (overScrollBy(deltaMoveX, 0, getScrollX(), 0, range, 0, this.overscrollDistance, 0, true)) {
                        this.mVelocityTracker.clear();
                    }
                    float pulledToX = (float) (getScrollX() + deltaMoveX);
                    if (pulledToX < 0.0f) {
                        this.leftEdgeEffect.onPull(((float) deltaMoveX) / ((float) getWidth()));
                        if (!this.rightEdgeEffect.isFinished()) {
                            this.rightEdgeEffect.onRelease();
                        }
                    } else if (pulledToX > ((float) range)) {
                        this.rightEdgeEffect.onPull(((float) deltaMoveX) / ((float) getWidth()));
                        if (!this.leftEdgeEffect.isFinished()) {
                            this.leftEdgeEffect.onRelease();
                        }
                    }
                    this.lastDownEventX = currentMoveX;
                    invalidate();
                    break;
                }
            case 3:
                break;
        }
        this.pressedItem = -1;
        invalidate();
        if (this.leftEdgeEffect != null) {
            this.leftEdgeEffect.onRelease();
            this.rightEdgeEffect.onRelease();
        }
        return true;
    }

    private void selectItem() {
        if (this.onItemClicked != null) {
            post(new Runnable() {
                public void run() {
                    HorizontalPicker.this.onItemClicked.onItemClicked(HorizontalPicker.this.getSelectedItem());
                }
            });
        }
        adjustToNearestItemX();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (!isEnabled()) {
            return super.onKeyDown(keyCode, event);
        }
        switch (keyCode) {
            case 21:
                smoothScrollBy(-1);
                return true;
            case 22:
                smoothScrollBy(1);
                return true;
            case 23:
            case 66:
                selectItem();
                return true;
            default:
                return super.onKeyDown(keyCode, event);
        }
    }

    /* access modifiers changed from: protected */
    public boolean dispatchHoverEvent(MotionEvent event) {
        if (this.touchHelper.dispatchHoverEvent(event)) {
            return true;
        }
        return super.dispatchHoverEvent(event);
    }

    public void computeScroll() {
        computeScrollX();
    }

    public void getFocusedRect(Rect r) {
        super.getFocusedRect(r);
    }

    public void setOnItemSelectedListener(OnItemSelected onItemSelected2) {
        this.onItemSelected = onItemSelected2;
    }

    public void setOnItemClickedListener(OnItemClicked onItemClicked2) {
        this.onItemClicked = onItemClicked2;
    }

    public int getSelectedItem() {
        return getPositionFromCoordinates(getScrollX());
    }

    public void setSelectedItem(int index) {
        this.selectedItem = index;
        scrollToItem(index);
    }

    public int getMarqueeRepeatLimit() {
        return this.marqueeRepeatLimit;
    }

    public void setMarqueeRepeatLimit(int marqueeRepeatLimit2) {
        this.marqueeRepeatLimit = marqueeRepeatLimit2;
    }

    public int getSideItems() {
        return this.sideItems;
    }

    public void setSideItems(int sideItems2) {
        if (this.sideItems < 0) {
            throw new IllegalArgumentException("Number of items on each side must be grater or equal to 0.");
        } else if (this.sideItems != sideItems2) {
            this.sideItems = sideItems2;
            calculateItemSize(getWidth(), getHeight());
        }
    }

    public CharSequence[] getValues() {
        return this.values;
    }

    public void setValues(CharSequence[] values2) {
        if (this.values != values2) {
            this.values = values2;
            if (this.values != null) {
                this.layouts = new BoringLayout[this.values.length];
                for (int i = 0; i < this.layouts.length; i++) {
                    this.layouts[i] = new BoringLayout(this.values[i], this.textPaint, this.itemWidth, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, this.boringMetrics, false, this.ellipsize, this.itemWidth);
                }
            } else {
                this.layouts = new BoringLayout[0];
            }
            if (getWidth() > 0) {
                startMarqueeIfNeeded();
            }
            requestLayout();
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());
        setSelectedItem(ss.mSelItem);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int unused = savedState.mSelItem = this.selectedItem;
        return savedState;
    }

    public void setOverScrollMode(int overScrollMode) {
        if (overScrollMode != 2) {
            Context context = getContext();
            this.leftEdgeEffect = new EdgeEffect(context);
            this.rightEdgeEffect = new EdgeEffect(context);
        } else {
            this.leftEdgeEffect = null;
            this.rightEdgeEffect = null;
        }
        super.setOverScrollMode(overScrollMode);
    }

    public TextUtils.TruncateAt getEllipsize() {
        return this.ellipsize;
    }

    public void setEllipsize(TextUtils.TruncateAt ellipsize2) {
        if (this.ellipsize != ellipsize2) {
            this.ellipsize = ellipsize2;
            remakeLayout();
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        super.scrollTo(scrollX, scrollY);
        if (!this.flingScrollerX.isFinished() && clampedX) {
            this.flingScrollerX.springBack(scrollX, scrollY, 0, getScrollRange(), 0, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    private int getPositionFromTouch(float x) {
        return getPositionFromCoordinates((int) ((((float) getScrollX()) - ((((float) this.itemWidth) + this.dividerSize) * (((float) this.sideItems) + 0.5f))) + x));
    }

    private void computeScrollX() {
        OverScroller scroller = this.flingScrollerX;
        if (scroller.isFinished()) {
            scroller = this.adjustScrollerX;
            if (scroller.isFinished()) {
                return;
            }
        }
        if (scroller.computeScrollOffset()) {
            int currentScrollerX = scroller.getCurrX();
            if (this.previousScrollerX == Integer.MIN_VALUE) {
                this.previousScrollerX = scroller.getStartX();
            }
            int range = getScrollRange();
            if (this.previousScrollerX >= 0 && currentScrollerX < 0) {
                this.leftEdgeEffect.onAbsorb((int) scroller.getCurrVelocity());
            } else if (this.previousScrollerX <= range && currentScrollerX > range) {
                this.rightEdgeEffect.onAbsorb((int) scroller.getCurrVelocity());
            }
            overScrollBy(currentScrollerX - this.previousScrollerX, 0, this.previousScrollerX, getScrollY(), getScrollRange(), 0, this.overscrollDistance, 0, false);
            this.previousScrollerX = currentScrollerX;
            if (scroller.isFinished()) {
                onScrollerFinishedX(scroller);
            }
            postInvalidate();
        }
    }

    private void flingX(int velocityX) {
        this.previousScrollerX = Integer.MIN_VALUE;
        this.flingScrollerX.fling(getScrollX(), getScrollY(), -velocityX, 0, 0, (this.values.length - 1) * ((int) (((float) this.itemWidth) + this.dividerSize)), 0, 0, getWidth() / 2, 0);
        invalidate();
    }

    private void adjustToNearestItemX() {
        int x = getScrollX();
        int item = Math.round(((float) x) / (((float) this.itemWidth) + (this.dividerSize * 1.0f)));
        if (item < 0) {
            item = 0;
        } else if (item > this.values.length) {
            item = this.values.length;
        }
        this.selectedItem = item;
        this.previousScrollerX = Integer.MIN_VALUE;
        this.adjustScrollerX.startScroll(x, 0, ((this.itemWidth + ((int) this.dividerSize)) * item) - x, 0, SELECTOR_ADJUSTMENT_DURATION_MILLIS);
        invalidate();
    }

    private void calculateItemSize(int w, int h) {
        int items = (this.sideItems * 2) + 1;
        this.itemWidth = (w - (((int) this.dividerSize) * (items - 1))) / items;
        this.itemClipBounds = new RectF(0.0f, 0.0f, (float) this.itemWidth, (float) h);
        this.itemClipBoundsOffset = new RectF(this.itemClipBounds);
        scrollToItem(this.selectedItem);
        remakeLayout();
        startMarqueeIfNeeded();
    }

    private void onScrollerFinishedX(OverScroller scroller) {
        if (scroller == this.flingScrollerX) {
            finishScrolling();
        }
    }

    private void finishScrolling() {
        adjustToNearestItemX();
        this.scrollingX = false;
        startMarqueeIfNeeded();
        if (this.onItemSelected != null) {
            post(new Runnable() {
                public void run() {
                    HorizontalPicker.this.onItemSelected.onItemSelected(HorizontalPicker.this.getPositionFromCoordinates(HorizontalPicker.this.getScrollX()));
                }
            });
        }
    }

    private void startMarqueeIfNeeded() {
        stopMarqueeIfNeeded();
        int item = getSelectedItem();
        if (this.layouts != null && this.layouts.length > item) {
            Layout layout = this.layouts[item];
            if (this.ellipsize == TextUtils.TruncateAt.MARQUEE && ((float) this.itemWidth) < layout.getLineWidth(0)) {
                this.marquee = new Marquee(this, layout, isRtl(this.values[item]));
                this.marquee.start(this.marqueeRepeatLimit);
            }
        }
    }

    private void stopMarqueeIfNeeded() {
        if (this.marquee != null) {
            this.marquee.stop();
            this.marquee = null;
        }
    }

    private int getPositionOnScreen(float x) {
        return (int) (x / (((float) this.itemWidth) + this.dividerSize));
    }

    private void smoothScrollBy(int i) {
        int deltaMoveX = getRelativeInBound((this.itemWidth + ((int) this.dividerSize)) * i);
        this.previousScrollerX = Integer.MIN_VALUE;
        this.flingScrollerX.startScroll(getScrollX(), 0, deltaMoveX, 0);
        stopMarqueeIfNeeded();
        invalidate();
    }

    private int getColor(int scrollX, int position) {
        float proportion;
        int defaultColor;
        int selectedColor;
        int itemWithPadding = (int) (((float) this.itemWidth) + this.dividerSize);
        float proportion2 = Math.abs((((1.0f * ((float) scrollX)) % ((float) itemWithPadding)) / 2.0f) / (((float) itemWithPadding) / 2.0f));
        if (((double) proportion2) > 0.5d) {
            proportion = proportion2 - 0.5f;
        } else {
            proportion = 0.5f - proportion2;
        }
        float proportion3 = proportion * 2.0f;
        if (this.pressedItem == position) {
            defaultColor = this.textColor.getColorForState(new int[]{16842919}, this.textColor.getDefaultColor());
            selectedColor = this.textColor.getColorForState(new int[]{16842919, 16842913}, defaultColor);
        } else {
            defaultColor = this.textColor.getDefaultColor();
            selectedColor = this.textColor.getColorForState(new int[]{16842913}, defaultColor);
        }
        return ((Integer) new ArgbEvaluator().evaluate(proportion3, Integer.valueOf(selectedColor), Integer.valueOf(defaultColor))).intValue();
    }

    private void setTextSize(float size) {
        if (size != this.textPaint.getTextSize()) {
            this.textPaint.setTextSize(size);
            requestLayout();
            invalidate();
        }
    }

    /* access modifiers changed from: private */
    public int getPositionFromCoordinates(int x) {
        return Math.round(((float) x) / (((float) this.itemWidth) + this.dividerSize));
    }

    private void scrollToItem(int index) {
        scrollTo((this.itemWidth + ((int) this.dividerSize)) * index, 0);
    }

    private int getRelativeInBound(int x) {
        int scrollX = getScrollX();
        return getInBoundsX(scrollX + x) - scrollX;
    }

    private int getInBoundsX(int x) {
        if (x < 0) {
            return 0;
        }
        if (x > (this.itemWidth + ((int) this.dividerSize)) * (this.values.length - 1)) {
            return (this.itemWidth + ((int) this.dividerSize)) * (this.values.length - 1);
        }
        return x;
    }

    private int getScrollRange() {
        if (this.values == null || this.values.length == 0) {
            return 0;
        }
        return Math.max(0, (this.itemWidth + ((int) this.dividerSize)) * (this.values.length - 1));
    }

    private static final class Marquee extends Handler {
        private static final int MARQUEE_DELAY = 1200;
        private static final float MARQUEE_DELTA_MAX = 0.07f;
        private static final int MARQUEE_PIXELS_PER_SECOND = 30;
        private static final int MARQUEE_RESOLUTION = 33;
        private static final int MARQUEE_RESTART_DELAY = 1200;
        private static final byte MARQUEE_RUNNING = 2;
        private static final byte MARQUEE_STARTING = 1;
        private static final byte MARQUEE_STOPPED = 0;
        private static final int MESSAGE_RESTART = 3;
        private static final int MESSAGE_START = 1;
        private static final int MESSAGE_TICK = 2;
        private float mFadeStop;
        private float mGhostOffset;
        private float mGhostStart;
        private final WeakReference<Layout> mLayout;
        private float mMaxFadeScroll;
        private float mMaxScroll;
        private int mRepeatLimit;
        private boolean mRtl;
        private float mScroll;
        private final float mScrollUnit;
        private byte mStatus = 0;
        private final WeakReference<HorizontalPicker> mView;

        Marquee(HorizontalPicker v, Layout l, boolean rtl) {
            float scrollUnit = (30.0f * v.getContext().getResources().getDisplayMetrics().density) / 33.0f;
            if (rtl) {
                this.mScrollUnit = -scrollUnit;
            } else {
                this.mScrollUnit = scrollUnit;
            }
            this.mView = new WeakReference<>(v);
            this.mLayout = new WeakReference<>(l);
            this.mRtl = rtl;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    this.mStatus = 2;
                    tick();
                    return;
                case 2:
                    tick();
                    return;
                case 3:
                    if (this.mStatus == 2) {
                        if (this.mRepeatLimit >= 0) {
                            this.mRepeatLimit--;
                        }
                        start(this.mRepeatLimit);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        /* access modifiers changed from: package-private */
        public void tick() {
            if (this.mStatus == 2) {
                removeMessages(2);
                HorizontalPicker view = (HorizontalPicker) this.mView.get();
                Layout layout = (Layout) this.mLayout.get();
                if (view != null && layout != null) {
                    if (view.isFocused() || view.isSelected()) {
                        this.mScroll += this.mScrollUnit;
                        if (Math.abs(this.mScroll) > this.mMaxScroll) {
                            this.mScroll = this.mMaxScroll;
                            if (this.mRtl) {
                                this.mScroll *= -1.0f;
                            }
                            sendEmptyMessageDelayed(3, 1200);
                        } else {
                            sendEmptyMessageDelayed(2, 33);
                        }
                        view.invalidate();
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void stop() {
            this.mStatus = 0;
            removeMessages(1);
            removeMessages(3);
            removeMessages(2);
            resetScroll();
        }

        private void resetScroll() {
            this.mScroll = 0.0f;
            HorizontalPicker view = (HorizontalPicker) this.mView.get();
            if (view != null) {
                view.invalidate();
            }
        }

        /* access modifiers changed from: package-private */
        public void start(int repeatLimit) {
            if (repeatLimit == 0) {
                stop();
                return;
            }
            this.mRepeatLimit = repeatLimit;
            HorizontalPicker view = (HorizontalPicker) this.mView.get();
            Layout layout = (Layout) this.mLayout.get();
            if (view != null && layout != null) {
                this.mStatus = 1;
                this.mScroll = 0.0f;
                int textWidth = view.itemWidth;
                float lineWidth = layout.getLineWidth(0);
                float gap = ((float) textWidth) / 3.0f;
                this.mGhostStart = (lineWidth - ((float) textWidth)) + gap;
                this.mMaxScroll = this.mGhostStart + ((float) textWidth);
                this.mGhostOffset = lineWidth + gap;
                this.mFadeStop = (((float) textWidth) / 6.0f) + lineWidth;
                this.mMaxFadeScroll = this.mGhostStart + lineWidth + lineWidth;
                if (this.mRtl) {
                    this.mGhostOffset *= -1.0f;
                }
                view.invalidate();
                sendEmptyMessageDelayed(1, 1200);
            }
        }

        /* access modifiers changed from: package-private */
        public float getGhostOffset() {
            return this.mGhostOffset;
        }

        /* access modifiers changed from: package-private */
        public float getScroll() {
            return this.mScroll;
        }

        /* access modifiers changed from: package-private */
        public float getMaxFadeScroll() {
            return this.mMaxFadeScroll;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldDrawLeftFade() {
            return this.mScroll <= this.mFadeStop;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldDrawGhost() {
            return this.mStatus == 2 && Math.abs(this.mScroll) > this.mGhostStart;
        }

        /* access modifiers changed from: package-private */
        public boolean isRunning() {
            return this.mStatus == 2;
        }

        /* access modifiers changed from: package-private */
        public boolean isStopped() {
            return this.mStatus == 0;
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        /* access modifiers changed from: private */
        public int mSelItem;

        public SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.mSelItem = in.readInt();
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.mSelItem);
        }

        public String toString() {
            return "HorizontalPicker.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selItem=" + this.mSelItem + "}";
        }
    }

    private static class PickerTouchHelper extends ExploreByTouchHelper {
        private HorizontalPicker mPicker;

        public PickerTouchHelper(HorizontalPicker picker) {
            super(picker);
            this.mPicker = picker;
        }

        /* access modifiers changed from: protected */
        public int getVirtualViewAt(float x, float y) {
            float itemWidth = ((float) this.mPicker.itemWidth) + this.mPicker.dividerSize;
            float item = ((((float) this.mPicker.getScrollX()) + x) - (((float) this.mPicker.sideItems) * itemWidth)) / itemWidth;
            if (item < 0.0f || item > ((float) this.mPicker.values.length)) {
                return Integer.MIN_VALUE;
            }
            return (int) item;
        }

        /* access modifiers changed from: protected */
        public void getVisibleVirtualViews(List<Integer> virtualViewIds) {
            float itemWidth = ((float) this.mPicker.itemWidth) + this.mPicker.dividerSize;
            float position = ((float) this.mPicker.getScrollX()) - (((float) this.mPicker.sideItems) * itemWidth);
            int first = (int) (position / itemWidth);
            int items = (this.mPicker.sideItems * 2) + 1;
            if (position % itemWidth != 0.0f) {
                items++;
            }
            if (first < 0) {
                items += first;
                first = 0;
            } else if (first + items > this.mPicker.values.length) {
                items = this.mPicker.values.length - first;
            }
            for (int i = 0; i < items; i++) {
                virtualViewIds.add(Integer.valueOf(first + i));
            }
        }

        /* access modifiers changed from: protected */
        public void onPopulateEventForVirtualView(int virtualViewId, AccessibilityEvent event) {
            event.setContentDescription(this.mPicker.values[virtualViewId]);
        }

        /* access modifiers changed from: protected */
        public void onPopulateNodeForVirtualView(int virtualViewId, AccessibilityNodeInfoCompat node) {
            float itemWidth = ((float) this.mPicker.itemWidth) + this.mPicker.dividerSize;
            int left = (int) ((((float) virtualViewId) * itemWidth) - (((float) this.mPicker.getScrollX()) - (((float) this.mPicker.sideItems) * itemWidth)));
            int right = left + this.mPicker.itemWidth;
            node.setContentDescription(this.mPicker.values[virtualViewId]);
            node.setBoundsInParent(new Rect(left, 0, right, this.mPicker.getHeight()));
            node.addAction(16);
        }

        /* access modifiers changed from: protected */
        public boolean onPerformActionForVirtualView(int virtualViewId, int action, Bundle arguments) {
            return false;
        }
    }
}
