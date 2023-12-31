package com.github.mikephil.charting.listener;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class BarLineChartTouchListener extends ChartTouchListener<BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>>> {
    private IDataSet mClosestDataSetToTouch;
    private MPPointF mDecelerationCurrentPoint = MPPointF.getInstance(0.0f, 0.0f);
    private long mDecelerationLastTime = 0;
    private MPPointF mDecelerationVelocity = MPPointF.getInstance(0.0f, 0.0f);
    private float mDragTriggerDist;
    private Matrix mMatrix = new Matrix();
    private float mMinScalePointerDistance;
    private float mSavedDist = 1.0f;
    private Matrix mSavedMatrix = new Matrix();
    private float mSavedXDist = 1.0f;
    private float mSavedYDist = 1.0f;
    private MPPointF mTouchPointCenter = MPPointF.getInstance(0.0f, 0.0f);
    private MPPointF mTouchStartPoint = MPPointF.getInstance(0.0f, 0.0f);
    private VelocityTracker mVelocityTracker;

    public BarLineChartTouchListener(BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>> chart, Matrix touchMatrix, float dragTriggerDistance) {
        super(chart);
        this.mMatrix = touchMatrix;
        this.mDragTriggerDist = Utils.convertDpToPixel(dragTriggerDistance);
        this.mMinScalePointerDistance = Utils.convertDpToPixel(3.5f);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View v, MotionEvent event) {
        int i = 2;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(event);
        if (event.getActionMasked() == 3 && this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        if (this.mTouchMode == 0) {
            this.mGestureDetector.onTouchEvent(event);
        }
        if (((BarLineChartBase) this.mChart).isDragEnabled() || ((BarLineChartBase) this.mChart).isScaleXEnabled() || ((BarLineChartBase) this.mChart).isScaleYEnabled()) {
            switch (event.getAction() & 255) {
                case 0:
                    startAction(event);
                    stopDeceleration();
                    saveTouchStart(event);
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    int pointerId = event.getPointerId(0);
                    velocityTracker.computeCurrentVelocity(1000, (float) Utils.getMaximumFlingVelocity());
                    float velocityY = velocityTracker.getYVelocity(pointerId);
                    float velocityX = velocityTracker.getXVelocity(pointerId);
                    if ((Math.abs(velocityX) > ((float) Utils.getMinimumFlingVelocity()) || Math.abs(velocityY) > ((float) Utils.getMinimumFlingVelocity())) && this.mTouchMode == 1 && ((BarLineChartBase) this.mChart).isDragDecelerationEnabled()) {
                        stopDeceleration();
                        this.mDecelerationLastTime = AnimationUtils.currentAnimationTimeMillis();
                        this.mDecelerationCurrentPoint.f75x = event.getX();
                        this.mDecelerationCurrentPoint.f76y = event.getY();
                        this.mDecelerationVelocity.f75x = velocityX;
                        this.mDecelerationVelocity.f76y = velocityY;
                        Utils.postInvalidateOnAnimation(this.mChart);
                    }
                    if (this.mTouchMode == 2 || this.mTouchMode == 3 || this.mTouchMode == 4 || this.mTouchMode == 5) {
                        ((BarLineChartBase) this.mChart).calculateOffsets();
                        ((BarLineChartBase) this.mChart).postInvalidate();
                    }
                    this.mTouchMode = 0;
                    ((BarLineChartBase) this.mChart).enableScroll();
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                    }
                    endAction(event);
                    break;
                case 2:
                    if (this.mTouchMode != 1) {
                        if (this.mTouchMode != 2 && this.mTouchMode != 3 && this.mTouchMode != 4) {
                            if (this.mTouchMode == 0 && Math.abs(distance(event.getX(), this.mTouchStartPoint.f75x, event.getY(), this.mTouchStartPoint.f76y)) > this.mDragTriggerDist) {
                                if (!((BarLineChartBase) this.mChart).hasNoDragOffset()) {
                                    if (((BarLineChartBase) this.mChart).isDragEnabled()) {
                                        this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
                                        this.mTouchMode = 1;
                                        break;
                                    }
                                } else if (!((BarLineChartBase) this.mChart).isFullyZoomedOut() && ((BarLineChartBase) this.mChart).isDragEnabled()) {
                                    this.mTouchMode = 1;
                                    break;
                                } else {
                                    this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
                                    if (((BarLineChartBase) this.mChart).isHighlightPerDragEnabled()) {
                                        performHighlightDrag(event);
                                        break;
                                    }
                                }
                            }
                        } else {
                            ((BarLineChartBase) this.mChart).disableScroll();
                            if (((BarLineChartBase) this.mChart).isScaleXEnabled() || ((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                                performZoom(event);
                                break;
                            }
                        }
                    } else {
                        ((BarLineChartBase) this.mChart).disableScroll();
                        performDrag(event);
                        break;
                    }
                    break;
                case 3:
                    this.mTouchMode = 0;
                    endAction(event);
                    break;
                case 5:
                    if (event.getPointerCount() >= 2) {
                        ((BarLineChartBase) this.mChart).disableScroll();
                        saveTouchStart(event);
                        this.mSavedXDist = getXDist(event);
                        this.mSavedYDist = getYDist(event);
                        this.mSavedDist = spacing(event);
                        if (this.mSavedDist > 10.0f) {
                            if (((BarLineChartBase) this.mChart).isPinchZoomEnabled()) {
                                this.mTouchMode = 4;
                            } else if (((BarLineChartBase) this.mChart).isScaleXEnabled() != ((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                                this.mTouchMode = ((BarLineChartBase) this.mChart).isScaleXEnabled() ? 2 : 3;
                            } else {
                                if (this.mSavedXDist <= this.mSavedYDist) {
                                    i = 3;
                                }
                                this.mTouchMode = i;
                            }
                        }
                        midPoint(this.mTouchPointCenter, event);
                        break;
                    }
                    break;
                case 6:
                    Utils.velocityTrackerPointerUpCleanUpIfNecessary(event, this.mVelocityTracker);
                    this.mTouchMode = 5;
                    break;
            }
            this.mMatrix = ((BarLineChartBase) this.mChart).getViewPortHandler().refresh(this.mMatrix, this.mChart, true);
        }
        return true;
    }

    private void saveTouchStart(MotionEvent event) {
        this.mSavedMatrix.set(this.mMatrix);
        this.mTouchStartPoint.f75x = event.getX();
        this.mTouchStartPoint.f76y = event.getY();
        this.mClosestDataSetToTouch = ((BarLineChartBase) this.mChart).getDataSetByTouchPoint(event.getX(), event.getY());
    }

    private void performDrag(MotionEvent event) {
        float dX;
        float dY;
        this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
        this.mMatrix.set(this.mSavedMatrix);
        OnChartGestureListener l = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (!inverted()) {
            dX = event.getX() - this.mTouchStartPoint.f75x;
            dY = event.getY() - this.mTouchStartPoint.f76y;
        } else if (this.mChart instanceof HorizontalBarChart) {
            dX = -(event.getX() - this.mTouchStartPoint.f75x);
            dY = event.getY() - this.mTouchStartPoint.f76y;
        } else {
            dX = event.getX() - this.mTouchStartPoint.f75x;
            dY = -(event.getY() - this.mTouchStartPoint.f76y);
        }
        this.mMatrix.postTranslate(dX, dY);
        if (l != null) {
            l.onChartTranslate(event, dX, dY);
        }
    }

    private void performZoom(MotionEvent event) {
        boolean canZoomMoreY;
        boolean canZoomMoreX;
        boolean canZoomMoreX2;
        boolean canZoomMoreY2;
        if (event.getPointerCount() >= 2) {
            OnChartGestureListener l = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
            float totalDist = spacing(event);
            if (totalDist > this.mMinScalePointerDistance) {
                MPPointF t = getTrans(this.mTouchPointCenter.f75x, this.mTouchPointCenter.f76y);
                ViewPortHandler h = ((BarLineChartBase) this.mChart).getViewPortHandler();
                if (this.mTouchMode == 4) {
                    this.mLastGesture = ChartTouchListener.ChartGesture.PINCH_ZOOM;
                    float scale = totalDist / this.mSavedDist;
                    boolean isZoomingOut = scale < 1.0f;
                    if (isZoomingOut) {
                        canZoomMoreX2 = h.canZoomOutMoreX();
                    } else {
                        canZoomMoreX2 = h.canZoomInMoreX();
                    }
                    if (isZoomingOut) {
                        canZoomMoreY2 = h.canZoomOutMoreY();
                    } else {
                        canZoomMoreY2 = h.canZoomInMoreY();
                    }
                    float scaleX = ((BarLineChartBase) this.mChart).isScaleXEnabled() ? scale : 1.0f;
                    float scaleY = ((BarLineChartBase) this.mChart).isScaleYEnabled() ? scale : 1.0f;
                    if (canZoomMoreY2 || canZoomMoreX2) {
                        this.mMatrix.set(this.mSavedMatrix);
                        this.mMatrix.postScale(scaleX, scaleY, t.f75x, t.f76y);
                        if (l != null) {
                            l.onChartScale(event, scaleX, scaleY);
                        }
                    }
                } else if (this.mTouchMode == 2 && ((BarLineChartBase) this.mChart).isScaleXEnabled()) {
                    this.mLastGesture = ChartTouchListener.ChartGesture.X_ZOOM;
                    float scaleX2 = getXDist(event) / this.mSavedXDist;
                    if (scaleX2 < 1.0f) {
                        canZoomMoreX = h.canZoomOutMoreX();
                    } else {
                        canZoomMoreX = h.canZoomInMoreX();
                    }
                    if (canZoomMoreX) {
                        this.mMatrix.set(this.mSavedMatrix);
                        this.mMatrix.postScale(scaleX2, 1.0f, t.f75x, t.f76y);
                        if (l != null) {
                            l.onChartScale(event, scaleX2, 1.0f);
                        }
                    }
                } else if (this.mTouchMode == 3 && ((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                    this.mLastGesture = ChartTouchListener.ChartGesture.Y_ZOOM;
                    float scaleY2 = getYDist(event) / this.mSavedYDist;
                    if (scaleY2 < 1.0f) {
                        canZoomMoreY = h.canZoomOutMoreY();
                    } else {
                        canZoomMoreY = h.canZoomInMoreY();
                    }
                    if (canZoomMoreY) {
                        this.mMatrix.set(this.mSavedMatrix);
                        this.mMatrix.postScale(1.0f, scaleY2, t.f75x, t.f76y);
                        if (l != null) {
                            l.onChartScale(event, 1.0f, scaleY2);
                        }
                    }
                }
                MPPointF.recycleInstance(t);
            }
        }
    }

    private void performHighlightDrag(MotionEvent e) {
        Highlight h = ((BarLineChartBase) this.mChart).getHighlightByTouchPoint(e.getX(), e.getY());
        if (h != null && !h.equalTo(this.mLastHighlighted)) {
            this.mLastHighlighted = h;
            ((BarLineChartBase) this.mChart).highlightValue(h, true);
        }
    }

    private static void midPoint(MPPointF point, MotionEvent event) {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        point.f75x = x / 2.0f;
        point.f76y = y / 2.0f;
    }

    private static float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    private static float getXDist(MotionEvent e) {
        return Math.abs(e.getX(0) - e.getX(1));
    }

    private static float getYDist(MotionEvent e) {
        return Math.abs(e.getY(0) - e.getY(1));
    }

    public MPPointF getTrans(float x, float y) {
        float yTrans;
        ViewPortHandler vph = ((BarLineChartBase) this.mChart).getViewPortHandler();
        float xTrans = x - vph.offsetLeft();
        if (inverted()) {
            yTrans = -(y - vph.offsetTop());
        } else {
            yTrans = -((((float) ((BarLineChartBase) this.mChart).getMeasuredHeight()) - y) - vph.offsetBottom());
        }
        return MPPointF.getInstance(xTrans, yTrans);
    }

    private boolean inverted() {
        return (this.mClosestDataSetToTouch == null && ((BarLineChartBase) this.mChart).isAnyAxisInverted()) || (this.mClosestDataSetToTouch != null && ((BarLineChartBase) this.mChart).isInverted(this.mClosestDataSetToTouch.getAxisDependency()));
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public void setDragTriggerDist(float dragTriggerDistance) {
        this.mDragTriggerDist = Utils.convertDpToPixel(dragTriggerDistance);
    }

    public boolean onDoubleTap(MotionEvent e) {
        float f;
        float f2 = 1.4f;
        this.mLastGesture = ChartTouchListener.ChartGesture.DOUBLE_TAP;
        OnChartGestureListener l = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (l != null) {
            l.onChartDoubleTapped(e);
        }
        if (((BarLineChartBase) this.mChart).isDoubleTapToZoomEnabled() && ((BarLineScatterCandleBubbleData) ((BarLineChartBase) this.mChart).getData()).getEntryCount() > 0) {
            MPPointF trans = getTrans(e.getX(), e.getY());
            BarLineChartBase barLineChartBase = (BarLineChartBase) this.mChart;
            if (((BarLineChartBase) this.mChart).isScaleXEnabled()) {
                f = 1.4f;
            } else {
                f = 1.0f;
            }
            if (!((BarLineChartBase) this.mChart).isScaleYEnabled()) {
                f2 = 1.0f;
            }
            barLineChartBase.zoom(f, f2, trans.f75x, trans.f76y);
            if (((BarLineChartBase) this.mChart).isLogEnabled()) {
                Log.i("BarlineChartTouch", "Double-Tap, Zooming In, x: " + trans.f75x + ", y: " + trans.f76y);
            }
            MPPointF.recycleInstance(trans);
        }
        return super.onDoubleTap(e);
    }

    public void onLongPress(MotionEvent e) {
        this.mLastGesture = ChartTouchListener.ChartGesture.LONG_PRESS;
        OnChartGestureListener l = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (l != null) {
            l.onChartLongPressed(e);
        }
    }

    public boolean onSingleTapUp(MotionEvent e) {
        this.mLastGesture = ChartTouchListener.ChartGesture.SINGLE_TAP;
        OnChartGestureListener l = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (l != null) {
            l.onChartSingleTapped(e);
        }
        if (!((BarLineChartBase) this.mChart).isHighlightPerTapEnabled()) {
            return false;
        }
        performHighlight(((BarLineChartBase) this.mChart).getHighlightByTouchPoint(e.getX(), e.getY()), e);
        return super.onSingleTapUp(e);
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        this.mLastGesture = ChartTouchListener.ChartGesture.FLING;
        OnChartGestureListener l = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (l != null) {
            l.onChartFling(e1, e2, velocityX, velocityY);
        }
        return super.onFling(e1, e2, velocityX, velocityY);
    }

    public void stopDeceleration() {
        this.mDecelerationVelocity.f75x = 0.0f;
        this.mDecelerationVelocity.f76y = 0.0f;
    }

    public void computeScroll() {
        if (this.mDecelerationVelocity.f75x != 0.0f || this.mDecelerationVelocity.f76y != 0.0f) {
            long currentTime = AnimationUtils.currentAnimationTimeMillis();
            MPPointF mPPointF = this.mDecelerationVelocity;
            mPPointF.f75x = ((BarLineChartBase) this.mChart).getDragDecelerationFrictionCoef() * mPPointF.f75x;
            MPPointF mPPointF2 = this.mDecelerationVelocity;
            mPPointF2.f76y = ((BarLineChartBase) this.mChart).getDragDecelerationFrictionCoef() * mPPointF2.f76y;
            float timeInterval = ((float) (currentTime - this.mDecelerationLastTime)) / 1000.0f;
            float distanceX = this.mDecelerationVelocity.f75x * timeInterval;
            float distanceY = this.mDecelerationVelocity.f76y * timeInterval;
            this.mDecelerationCurrentPoint.f75x += distanceX;
            this.mDecelerationCurrentPoint.f76y += distanceY;
            MotionEvent event = MotionEvent.obtain(currentTime, currentTime, 2, this.mDecelerationCurrentPoint.f75x, this.mDecelerationCurrentPoint.f76y, 0);
            performDrag(event);
            event.recycle();
            this.mMatrix = ((BarLineChartBase) this.mChart).getViewPortHandler().refresh(this.mMatrix, this.mChart, false);
            this.mDecelerationLastTime = currentTime;
            if (((double) Math.abs(this.mDecelerationVelocity.f75x)) >= 0.01d || ((double) Math.abs(this.mDecelerationVelocity.f76y)) >= 0.01d) {
                Utils.postInvalidateOnAnimation(this.mChart);
                return;
            }
            ((BarLineChartBase) this.mChart).calculateOffsets();
            ((BarLineChartBase) this.mChart).postInvalidate();
            stopDeceleration();
        }
    }
}
