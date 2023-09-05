package com.safonov.speedreading.training.fragment.prepare.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.p000v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.view.View;
import com.safonov.speedreading.C0699R;

public class CircularProgressBar extends View {
    private int backLineColor = -7829368;
    private RectF drawCircle;
    private int frontLineColor = SupportMenu.CATEGORY_MASK;
    private float lineWidth = 10.0f;
    private int maxProgress = 100;
    private float maxSweepAngle = 360.0f;
    private Paint paint;
    private int progress = 0;
    private final float startAngle = -90.0f;
    private float sweepAngle = 0.0f;

    public CircularProgressBar(Context context) {
        super(context);
        init((AttributeSet) null, 0);
    }

    public CircularProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CircularProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, C0699R.styleable.CircularProgressBar, defStyle, 0);
        this.frontLineColor = a.getColor(1, this.frontLineColor);
        this.backLineColor = a.getColor(0, this.frontLineColor);
        this.lineWidth = a.getDimension(2, this.lineWidth);
        this.progress = a.getInt(3, this.progress);
        this.sweepAngle = calcSweepAngleFromProgress(this.progress);
        a.recycle();
        this.paint = new Paint(1);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initMeasure();
        drawDefaultArc(canvas);
        drawArc(canvas);
    }

    private void initMeasure() {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int paddingTop = getPaddingTop();
        float diameter = (float) Math.min((getWidth() - paddingLeft) - paddingRight, (getHeight() - paddingTop) - paddingBottom);
        this.drawCircle = new RectF(((float) paddingLeft) + this.lineWidth, ((float) paddingTop) + this.lineWidth, (((float) paddingLeft) + diameter) - this.lineWidth, (((float) paddingTop) + diameter) - this.lineWidth);
    }

    private void drawDefaultArc(Canvas canvas) {
        this.paint.setColor(this.backLineColor);
        this.paint.setStrokeWidth(this.lineWidth);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(this.drawCircle, -90.0f, this.maxSweepAngle, false, this.paint);
    }

    private void drawArc(Canvas canvas) {
        this.paint.setColor(this.frontLineColor);
        this.paint.setStrokeWidth(this.lineWidth);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(this.drawCircle, -90.0f, this.sweepAngle, false, this.paint);
    }

    public int getFrontLineColor() {
        return this.frontLineColor;
    }

    public void setFrontLineColor(int frontLineColor2) {
        this.frontLineColor = frontLineColor2;
        invalidate();
    }

    public float getLineWidth() {
        return this.lineWidth;
    }

    public void setLineWidth(float lineWidth2) {
        this.lineWidth = lineWidth2;
        invalidate();
    }

    private float calcSweepAngleFromProgress(int progress2) {
        return (this.maxSweepAngle / ((float) this.maxProgress)) * ((float) progress2);
    }

    public void setProgress(int progress2) {
        if (progress2 <= this.maxProgress) {
            this.progress = progress2;
            this.sweepAngle = calcSweepAngleFromProgress(progress2);
            invalidate();
        }
    }
}
