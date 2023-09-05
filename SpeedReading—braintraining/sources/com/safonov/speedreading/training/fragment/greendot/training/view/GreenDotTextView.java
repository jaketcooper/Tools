package com.safonov.speedreading.training.fragment.greendot.training.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.p000v4.internal.view.SupportMenu;
import android.support.p003v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import com.safonov.speedreading.C0699R;

public class GreenDotTextView extends AppCompatTextView {
    private static final float MAX_SWEEP_ANGLE = 360.0f;
    private static final float START_ANGLE = -90.0f;
    private final int MAX_PROGRESS = 100;
    private RectF dotRect;
    private int frameColor = -16711936;
    private float greenDotFrameSize = 50.0f;
    private float greenDotHeight = 100.0f;
    private float greenDotWidth = 100.0f;
    private int mainColor = SupportMenu.CATEGORY_MASK;
    private Paint paint;
    private int progress = 50;
    private int shadowColor = -16776961;
    private float sweepAngle = 0.0f;

    public GreenDotTextView(Context context) {
        super(context);
        init((AttributeSet) null, 0);
    }

    public GreenDotTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public GreenDotTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        this.paint = new Paint(1);
        TypedArray a = getContext().obtainStyledAttributes(attrs, C0699R.styleable.GreenDotTextView, defStyle, 0);
        this.progress = a.getInt(5, this.progress);
        this.greenDotHeight = a.getDimension(2, this.greenDotWidth);
        this.greenDotWidth = a.getDimension(3, this.greenDotWidth);
        this.greenDotFrameSize = a.getDimension(1, this.greenDotFrameSize);
        this.frameColor = a.getColor(0, this.frameColor);
        this.shadowColor = a.getColor(4, this.shadowColor);
        this.mainColor = a.getColor(6, this.mainColor);
        a.recycle();
        setProgress(this.progress);
    }

    private float calcSweepAngleFromProgress(int progress2) {
        if (progress2 == 0) {
            return 0.0f;
        }
        if (progress2 == 100) {
            return MAX_SWEEP_ANGLE;
        }
        return 3.6f * ((float) progress2);
    }

    public void setProgress(int progress2) {
        if (progress2 <= 0) {
            this.progress = 0;
        } else if (progress2 >= 100) {
            this.progress = 100;
        } else {
            this.progress = progress2;
        }
        this.sweepAngle = calcSweepAngleFromProgress(progress2);
        invalidate();
    }

    public int getProgress() {
        return this.progress;
    }

    private void initDotMeasurments() {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int width = (getWidth() - paddingLeft) - paddingRight;
        int height = (getHeight() - paddingBottom) - paddingTop;
        float left = ((float) ((width / 2) + paddingLeft)) - (this.greenDotWidth / 2.0f);
        float right = left + this.greenDotWidth;
        float top = ((float) ((height / 2) + paddingTop)) - (this.greenDotHeight / 2.0f);
        this.dotRect = new RectF(left, top, right, top + this.greenDotHeight);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initDotMeasurments();
        drawMainOval(canvas);
        drawShadowShape(canvas);
    }

    private void drawFrame(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        this.paint.setColor(this.frameColor);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.paint.setAntiAlias(true);
        PointF a = new PointF(0.0f, 0.0f);
        PointF b = new PointF(0.0f, this.greenDotFrameSize);
        PointF c = new PointF(this.greenDotFrameSize, 0.0f);
        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.moveTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.lineTo(a.x, a.y);
        path.close();
        canvas.drawPath(path, this.paint);
        PointF a2 = new PointF(((float) width) - this.greenDotFrameSize, 0.0f);
        PointF b2 = new PointF((float) width, 0.0f);
        PointF c2 = new PointF((float) width, this.greenDotFrameSize);
        Path path2 = new Path();
        path2.setFillType(Path.FillType.EVEN_ODD);
        path2.moveTo(b2.x, b2.y);
        path2.lineTo(c2.x, c2.y);
        path2.lineTo(a2.x, a2.y);
        path2.close();
        canvas.drawPath(path2, this.paint);
        PointF a3 = new PointF(0.0f, ((float) height) - this.greenDotFrameSize);
        PointF b3 = new PointF(0.0f, (float) height);
        PointF c3 = new PointF(this.greenDotFrameSize, (float) height);
        Path path3 = new Path();
        path3.setFillType(Path.FillType.EVEN_ODD);
        path3.moveTo(b3.x, b3.y);
        path3.lineTo(c3.x, c3.y);
        path3.lineTo(a3.x, a3.y);
        path3.close();
        canvas.drawPath(path3, this.paint);
        PointF a4 = new PointF(((float) width) - this.greenDotFrameSize, (float) height);
        PointF b4 = new PointF((float) width, ((float) height) - this.greenDotFrameSize);
        PointF c4 = new PointF((float) width, (float) height);
        Path path4 = new Path();
        path4.setFillType(Path.FillType.WINDING);
        path4.moveTo(b4.x, b4.y);
        path4.lineTo(c4.x, c4.y);
        path4.lineTo(a4.x, a4.y);
        path4.close();
        canvas.drawPath(path4, this.paint);
    }

    private void drawMainOval(Canvas canvas) {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.mainColor);
        canvas.drawOval(this.dotRect, this.paint);
    }

    private void drawShadowShape(Canvas canvas) {
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.shadowColor);
        canvas.drawArc(this.dotRect, START_ANGLE, this.sweepAngle, true, this.paint);
    }
}
