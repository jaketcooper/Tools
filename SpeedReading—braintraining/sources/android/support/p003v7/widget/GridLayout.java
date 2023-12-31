package android.support.p003v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.p000v4.view.GravityCompat;
import android.support.p000v4.view.ViewCompat;
import android.support.p000v4.view.ViewGroupCompat;
import android.support.p000v4.widget.Space;
import android.support.p003v7.gridlayout.C0362R;
import android.util.AttributeSet;
import android.util.LogPrinter;
import android.util.Pair;
import android.util.Printer;
import android.view.View;
import android.view.ViewGroup;
import com.safonov.speedreading.training.fragment.schultetable.training.view.SchulteTableFragment;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: android.support.v7.widget.GridLayout */
public class GridLayout extends ViewGroup {
    private static final int ALIGNMENT_MODE = C0362R.styleable.GridLayout_alignmentMode;
    public static final int ALIGN_BOUNDS = 0;
    public static final int ALIGN_MARGINS = 1;
    public static final Alignment BASELINE = new Alignment() {
        /* access modifiers changed from: package-private */
        public int getGravityOffset(View view, int cellDelta) {
            return 0;
        }

        public int getAlignmentValue(View view, int viewSize, int mode) {
            if (view.getVisibility() == 8) {
                return 0;
            }
            int baseline = view.getBaseline();
            if (baseline == -1) {
                return Integer.MIN_VALUE;
            }
            return baseline;
        }

        public Bounds getBounds() {
            return new Bounds() {
                private int size;

                /* access modifiers changed from: protected */
                public void reset() {
                    super.reset();
                    this.size = Integer.MIN_VALUE;
                }

                /* access modifiers changed from: protected */
                public void include(int before, int after) {
                    super.include(before, after);
                    this.size = Math.max(this.size, before + after);
                }

                /* access modifiers changed from: protected */
                public int size(boolean min) {
                    return Math.max(super.size(min), this.size);
                }

                /* access modifiers changed from: protected */
                public int getOffset(GridLayout gl, View c, Alignment a, int size2, boolean hrz) {
                    return Math.max(0, super.getOffset(gl, c, a, size2, hrz));
                }
            };
        }

        /* access modifiers changed from: package-private */
        public String getDebugString() {
            return "BASELINE";
        }
    };
    public static final Alignment BOTTOM = TRAILING;
    static final int CAN_STRETCH = 2;
    public static final Alignment CENTER = new Alignment() {
        /* access modifiers changed from: package-private */
        public int getGravityOffset(View view, int cellDelta) {
            return cellDelta >> 1;
        }

        public int getAlignmentValue(View view, int viewSize, int mode) {
            return viewSize >> 1;
        }

        /* access modifiers changed from: package-private */
        public String getDebugString() {
            return "CENTER";
        }
    };
    private static final int COLUMN_COUNT = C0362R.styleable.GridLayout_columnCount;
    private static final int COLUMN_ORDER_PRESERVED = C0362R.styleable.GridLayout_columnOrderPreserved;
    private static final int DEFAULT_ALIGNMENT_MODE = 1;
    static final int DEFAULT_CONTAINER_MARGIN = 0;
    private static final int DEFAULT_COUNT = Integer.MIN_VALUE;
    static final boolean DEFAULT_ORDER_PRESERVED = true;
    private static final int DEFAULT_ORIENTATION = 0;
    private static final boolean DEFAULT_USE_DEFAULT_MARGINS = false;
    public static final Alignment END = TRAILING;
    public static final Alignment FILL = new Alignment() {
        /* access modifiers changed from: package-private */
        public int getGravityOffset(View view, int cellDelta) {
            return 0;
        }

        public int getAlignmentValue(View view, int viewSize, int mode) {
            return Integer.MIN_VALUE;
        }

        public int getSizeInCell(View view, int viewSize, int cellSize) {
            return cellSize;
        }

        /* access modifiers changed from: package-private */
        public String getDebugString() {
            return "FILL";
        }
    };
    public static final int HORIZONTAL = 0;
    static final int INFLEXIBLE = 0;
    private static final Alignment LEADING = new Alignment() {
        /* access modifiers changed from: package-private */
        public int getGravityOffset(View view, int cellDelta) {
            return 0;
        }

        public int getAlignmentValue(View view, int viewSize, int mode) {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public String getDebugString() {
            return "LEADING";
        }
    };
    public static final Alignment LEFT = createSwitchingAlignment(START, END);
    static final Printer LOG_PRINTER = new LogPrinter(3, GridLayout.class.getName());
    static final int MAX_SIZE = 100000;
    static final Printer NO_PRINTER = new Printer() {
        public void println(String x) {
        }
    };
    private static final int ORIENTATION = C0362R.styleable.GridLayout_orientation;
    public static final Alignment RIGHT = createSwitchingAlignment(END, START);
    private static final int ROW_COUNT = C0362R.styleable.GridLayout_rowCount;
    private static final int ROW_ORDER_PRESERVED = C0362R.styleable.GridLayout_rowOrderPreserved;
    public static final Alignment START = LEADING;
    public static final Alignment TOP = LEADING;
    private static final Alignment TRAILING = new Alignment() {
        /* access modifiers changed from: package-private */
        public int getGravityOffset(View view, int cellDelta) {
            return cellDelta;
        }

        public int getAlignmentValue(View view, int viewSize, int mode) {
            return viewSize;
        }

        /* access modifiers changed from: package-private */
        public String getDebugString() {
            return "TRAILING";
        }
    };
    public static final int UNDEFINED = Integer.MIN_VALUE;
    static final Alignment UNDEFINED_ALIGNMENT = new Alignment() {
        /* access modifiers changed from: package-private */
        public int getGravityOffset(View view, int cellDelta) {
            return Integer.MIN_VALUE;
        }

        public int getAlignmentValue(View view, int viewSize, int mode) {
            return Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public String getDebugString() {
            return "UNDEFINED";
        }
    };
    static final int UNINITIALIZED_HASH = 0;
    private static final int USE_DEFAULT_MARGINS = C0362R.styleable.GridLayout_useDefaultMargins;
    public static final int VERTICAL = 1;
    int mAlignmentMode;
    int mDefaultGap;
    final Axis mHorizontalAxis;
    int mLastLayoutParamsHashCode;
    int mOrientation;
    Printer mPrinter;
    boolean mUseDefaultMargins;
    final Axis mVerticalAxis;

    public GridLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mHorizontalAxis = new Axis(true);
        this.mVerticalAxis = new Axis(false);
        this.mOrientation = 0;
        this.mUseDefaultMargins = false;
        this.mAlignmentMode = 1;
        this.mLastLayoutParamsHashCode = 0;
        this.mPrinter = LOG_PRINTER;
        this.mDefaultGap = context.getResources().getDimensionPixelOffset(C0362R.dimen.default_gap);
        TypedArray a = context.obtainStyledAttributes(attrs, C0362R.styleable.GridLayout);
        try {
            setRowCount(a.getInt(ROW_COUNT, Integer.MIN_VALUE));
            setColumnCount(a.getInt(COLUMN_COUNT, Integer.MIN_VALUE));
            setOrientation(a.getInt(ORIENTATION, 0));
            setUseDefaultMargins(a.getBoolean(USE_DEFAULT_MARGINS, false));
            setAlignmentMode(a.getInt(ALIGNMENT_MODE, 1));
            setRowOrderPreserved(a.getBoolean(ROW_ORDER_PRESERVED, true));
            setColumnOrderPreserved(a.getBoolean(COLUMN_ORDER_PRESERVED, true));
        } finally {
            a.recycle();
        }
    }

    public GridLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GridLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int orientation) {
        if (this.mOrientation != orientation) {
            this.mOrientation = orientation;
            invalidateStructure();
            requestLayout();
        }
    }

    public int getRowCount() {
        return this.mVerticalAxis.getCount();
    }

    public void setRowCount(int rowCount) {
        this.mVerticalAxis.setCount(rowCount);
        invalidateStructure();
        requestLayout();
    }

    public int getColumnCount() {
        return this.mHorizontalAxis.getCount();
    }

    public void setColumnCount(int columnCount) {
        this.mHorizontalAxis.setCount(columnCount);
        invalidateStructure();
        requestLayout();
    }

    public boolean getUseDefaultMargins() {
        return this.mUseDefaultMargins;
    }

    public void setUseDefaultMargins(boolean useDefaultMargins) {
        this.mUseDefaultMargins = useDefaultMargins;
        requestLayout();
    }

    public int getAlignmentMode() {
        return this.mAlignmentMode;
    }

    public void setAlignmentMode(int alignmentMode) {
        this.mAlignmentMode = alignmentMode;
        requestLayout();
    }

    public boolean isRowOrderPreserved() {
        return this.mVerticalAxis.isOrderPreserved();
    }

    public void setRowOrderPreserved(boolean rowOrderPreserved) {
        this.mVerticalAxis.setOrderPreserved(rowOrderPreserved);
        invalidateStructure();
        requestLayout();
    }

    public boolean isColumnOrderPreserved() {
        return this.mHorizontalAxis.isOrderPreserved();
    }

    public void setColumnOrderPreserved(boolean columnOrderPreserved) {
        this.mHorizontalAxis.setOrderPreserved(columnOrderPreserved);
        invalidateStructure();
        requestLayout();
    }

    public Printer getPrinter() {
        return this.mPrinter;
    }

    public void setPrinter(Printer printer) {
        if (printer == null) {
            printer = NO_PRINTER;
        }
        this.mPrinter = printer;
    }

    static int max2(int[] a, int valueIfEmpty) {
        int result = valueIfEmpty;
        for (int max : a) {
            result = Math.max(result, max);
        }
        return result;
    }

    static <T> T[] append(T[] a, T[] b) {
        T[] result = (Object[]) ((Object[]) Array.newInstance(a.getClass().getComponentType(), a.length + b.length));
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    static Alignment getAlignment(int gravity, boolean horizontal) {
        switch ((gravity & (horizontal ? 7 : 112)) >> (horizontal ? 0 : 4)) {
            case 1:
                return CENTER;
            case 3:
                return horizontal ? LEFT : TOP;
            case 5:
                return horizontal ? RIGHT : BOTTOM;
            case 7:
                return FILL;
            case GravityCompat.START:
                return START;
            case GravityCompat.END:
                return END;
            default:
                return UNDEFINED_ALIGNMENT;
        }
    }

    private int getDefaultMargin(View c, boolean horizontal, boolean leading) {
        if (c.getClass() == Space.class) {
            return 0;
        }
        return this.mDefaultGap / 2;
    }

    private int getDefaultMargin(View c, boolean isAtEdge, boolean horizontal, boolean leading) {
        return getDefaultMargin(c, horizontal, leading);
    }

    private int getDefaultMargin(View c, LayoutParams p, boolean horizontal, boolean leading) {
        boolean isAtEdge = true;
        if (!this.mUseDefaultMargins) {
            return 0;
        }
        Spec spec = horizontal ? p.columnSpec : p.rowSpec;
        Axis axis = horizontal ? this.mHorizontalAxis : this.mVerticalAxis;
        Interval span = spec.span;
        if ((!horizontal || !isLayoutRtlCompat()) ? leading : !leading) {
            if (span.min != 0) {
                isAtEdge = false;
            }
        } else if (span.max != axis.getCount()) {
            isAtEdge = false;
        }
        return getDefaultMargin(c, isAtEdge, horizontal, leading);
    }

    /* access modifiers changed from: package-private */
    public int getMargin1(View view, boolean horizontal, boolean leading) {
        LayoutParams lp = getLayoutParams(view);
        int margin = horizontal ? leading ? lp.leftMargin : lp.rightMargin : leading ? lp.topMargin : lp.bottomMargin;
        return margin == Integer.MIN_VALUE ? getDefaultMargin(view, lp, horizontal, leading) : margin;
    }

    private boolean isLayoutRtlCompat() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    private int getMargin(View view, boolean horizontal, boolean leading) {
        if (this.mAlignmentMode == 1) {
            return getMargin1(view, horizontal, leading);
        }
        Axis axis = horizontal ? this.mHorizontalAxis : this.mVerticalAxis;
        int[] margins = leading ? axis.getLeadingMargins() : axis.getTrailingMargins();
        LayoutParams lp = getLayoutParams(view);
        Spec spec = horizontal ? lp.columnSpec : lp.rowSpec;
        return margins[leading ? spec.span.min : spec.span.max];
    }

    private int getTotalMargin(View child, boolean horizontal) {
        return getMargin(child, horizontal, true) + getMargin(child, horizontal, false);
    }

    private static boolean fits(int[] a, int value, int start, int end) {
        if (end > a.length) {
            return false;
        }
        for (int i = start; i < end; i++) {
            if (a[i] > value) {
                return false;
            }
        }
        return true;
    }

    private static void procrusteanFill(int[] a, int start, int end, int value) {
        int length = a.length;
        Arrays.fill(a, Math.min(start, length), Math.min(end, length), value);
    }

    private static void setCellGroup(LayoutParams lp, int row, int rowSpan, int col, int colSpan) {
        lp.setRowSpecSpan(new Interval(row, row + rowSpan));
        lp.setColumnSpecSpan(new Interval(col, col + colSpan));
    }

    private static int clip(Interval minorRange, boolean minorWasDefined, int count) {
        int size = minorRange.size();
        if (count == 0) {
            return size;
        }
        return Math.min(size, count - (minorWasDefined ? Math.min(minorRange.min, count) : 0));
    }

    private void validateLayoutParams() {
        boolean horizontal = this.mOrientation == 0;
        Axis axis = horizontal ? this.mHorizontalAxis : this.mVerticalAxis;
        int count = axis.definedCount != Integer.MIN_VALUE ? axis.definedCount : 0;
        int major = 0;
        int minor = 0;
        int[] maxSizes = new int[count];
        int N = getChildCount();
        for (int i = 0; i < N; i++) {
            LayoutParams lp = (LayoutParams) getChildAt(i).getLayoutParams();
            Spec majorSpec = horizontal ? lp.rowSpec : lp.columnSpec;
            Interval majorRange = majorSpec.span;
            boolean majorWasDefined = majorSpec.startDefined;
            int majorSpan = majorRange.size();
            if (majorWasDefined) {
                major = majorRange.min;
            }
            Spec minorSpec = horizontal ? lp.columnSpec : lp.rowSpec;
            Interval minorRange = minorSpec.span;
            boolean minorWasDefined = minorSpec.startDefined;
            int minorSpan = clip(minorRange, minorWasDefined, count);
            if (minorWasDefined) {
                minor = minorRange.min;
            }
            if (count != 0) {
                if (!majorWasDefined || !minorWasDefined) {
                    while (!fits(maxSizes, major, minor, minor + minorSpan)) {
                        if (minorWasDefined) {
                            major++;
                        } else if (minor + minorSpan <= count) {
                            minor++;
                        } else {
                            minor = 0;
                            major++;
                        }
                    }
                }
                procrusteanFill(maxSizes, minor, minor + minorSpan, major + majorSpan);
            }
            if (horizontal) {
                setCellGroup(lp, major, majorSpan, minor, minorSpan);
            } else {
                setCellGroup(lp, minor, minorSpan, major, majorSpan);
            }
            minor += minorSpan;
        }
    }

    private void invalidateStructure() {
        this.mLastLayoutParamsHashCode = 0;
        if (this.mHorizontalAxis != null) {
            this.mHorizontalAxis.invalidateStructure();
        }
        if (this.mVerticalAxis != null) {
            this.mVerticalAxis.invalidateStructure();
        }
        invalidateValues();
    }

    private void invalidateValues() {
        if (this.mHorizontalAxis != null && this.mVerticalAxis != null) {
            this.mHorizontalAxis.invalidateValues();
            this.mVerticalAxis.invalidateValues();
        }
    }

    /* access modifiers changed from: package-private */
    public final LayoutParams getLayoutParams(View c) {
        return (LayoutParams) c.getLayoutParams();
    }

    static void handleInvalidParams(String msg) {
        throw new IllegalArgumentException(msg + ". ");
    }

    private void checkLayoutParams(LayoutParams lp, boolean horizontal) {
        String groupName = horizontal ? "column" : "row";
        Interval span = (horizontal ? lp.columnSpec : lp.rowSpec).span;
        if (span.min != Integer.MIN_VALUE && span.min < 0) {
            handleInvalidParams(groupName + " indices must be positive");
        }
        int count = (horizontal ? this.mHorizontalAxis : this.mVerticalAxis).definedCount;
        if (count != Integer.MIN_VALUE) {
            if (span.max > count) {
                handleInvalidParams(groupName + " indices (start + span) mustn't exceed the " + groupName + " count");
            }
            if (span.size() > count) {
                handleInvalidParams(groupName + " span mustn't exceed the " + groupName + " count");
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        if (!(p instanceof LayoutParams)) {
            return false;
        }
        LayoutParams lp = (LayoutParams) p;
        checkLayoutParams(lp, true);
        checkLayoutParams(lp, false);
        return true;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        if (lp instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) lp);
        }
        if (lp instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) lp);
        }
        return new LayoutParams(lp);
    }

    private void drawLine(Canvas graphics, int x1, int y1, int x2, int y2, Paint paint) {
        if (isLayoutRtlCompat()) {
            int width = getWidth();
            graphics.drawLine((float) (width - x1), (float) y1, (float) (width - x2), (float) y2, paint);
            return;
        }
        graphics.drawLine((float) x1, (float) y1, (float) x2, (float) y2, paint);
    }

    private int computeLayoutParamsHashCode() {
        int result = 1;
        int N = getChildCount();
        for (int i = 0; i < N; i++) {
            View c = getChildAt(i);
            if (c.getVisibility() != 8) {
                result = (result * 31) + ((LayoutParams) c.getLayoutParams()).hashCode();
            }
        }
        return result;
    }

    private void consistencyCheck() {
        if (this.mLastLayoutParamsHashCode == 0) {
            validateLayoutParams();
            this.mLastLayoutParamsHashCode = computeLayoutParamsHashCode();
        } else if (this.mLastLayoutParamsHashCode != computeLayoutParamsHashCode()) {
            this.mPrinter.println("The fields of some layout parameters were modified in between layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec.");
            invalidateStructure();
            consistencyCheck();
        }
    }

    private void measureChildWithMargins2(View child, int parentWidthSpec, int parentHeightSpec, int childWidth, int childHeight) {
        child.measure(getChildMeasureSpec(parentWidthSpec, getTotalMargin(child, true), childWidth), getChildMeasureSpec(parentHeightSpec, getTotalMargin(child, false), childHeight));
    }

    private void measureChildrenWithMargins(int widthSpec, int heightSpec, boolean firstPass) {
        int N = getChildCount();
        for (int i = 0; i < N; i++) {
            View c = getChildAt(i);
            if (c.getVisibility() != 8) {
                LayoutParams lp = getLayoutParams(c);
                if (firstPass) {
                    measureChildWithMargins2(c, widthSpec, heightSpec, lp.width, lp.height);
                } else {
                    boolean horizontal = this.mOrientation == 0;
                    Spec spec = horizontal ? lp.columnSpec : lp.rowSpec;
                    if (spec.getAbsoluteAlignment(horizontal) == FILL) {
                        Interval span = spec.span;
                        int[] locations = (horizontal ? this.mHorizontalAxis : this.mVerticalAxis).getLocations();
                        int viewSize = (locations[span.max] - locations[span.min]) - getTotalMargin(c, horizontal);
                        if (horizontal) {
                            measureChildWithMargins2(c, widthSpec, heightSpec, viewSize, lp.height);
                        } else {
                            measureChildWithMargins2(c, widthSpec, heightSpec, lp.width, viewSize);
                        }
                    }
                }
            }
        }
    }

    static int adjust(int measureSpec, int delta) {
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(measureSpec + delta), View.MeasureSpec.getMode(measureSpec));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthSpec, int heightSpec) {
        int heightSansPadding;
        int widthSansPadding;
        consistencyCheck();
        invalidateValues();
        int hPadding = getPaddingLeft() + getPaddingRight();
        int vPadding = getPaddingTop() + getPaddingBottom();
        int widthSpecSansPadding = adjust(widthSpec, -hPadding);
        int heightSpecSansPadding = adjust(heightSpec, -vPadding);
        measureChildrenWithMargins(widthSpecSansPadding, heightSpecSansPadding, true);
        if (this.mOrientation == 0) {
            widthSansPadding = this.mHorizontalAxis.getMeasure(widthSpecSansPadding);
            measureChildrenWithMargins(widthSpecSansPadding, heightSpecSansPadding, false);
            heightSansPadding = this.mVerticalAxis.getMeasure(heightSpecSansPadding);
        } else {
            heightSansPadding = this.mVerticalAxis.getMeasure(heightSpecSansPadding);
            measureChildrenWithMargins(widthSpecSansPadding, heightSpecSansPadding, false);
            widthSansPadding = this.mHorizontalAxis.getMeasure(widthSpecSansPadding);
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(widthSansPadding + hPadding, getSuggestedMinimumWidth()), widthSpec, 0), View.resolveSizeAndState(Math.max(heightSansPadding + vPadding, getSuggestedMinimumHeight()), heightSpec, 0));
    }

    private int getMeasurement(View c, boolean horizontal) {
        return horizontal ? c.getMeasuredWidth() : c.getMeasuredHeight();
    }

    /* access modifiers changed from: package-private */
    public final int getMeasurementIncludingMargin(View c, boolean horizontal) {
        if (c.getVisibility() == 8) {
            return 0;
        }
        return getMeasurement(c, horizontal) + getTotalMargin(c, horizontal);
    }

    public void requestLayout() {
        super.requestLayout();
        invalidateStructure();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        consistencyCheck();
        int targetWidth = right - left;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        this.mHorizontalAxis.layout((targetWidth - paddingLeft) - paddingRight);
        this.mVerticalAxis.layout(((bottom - top) - paddingTop) - paddingBottom);
        int[] hLocations = this.mHorizontalAxis.getLocations();
        int[] vLocations = this.mVerticalAxis.getLocations();
        int N = getChildCount();
        for (int i = 0; i < N; i++) {
            View c = getChildAt(i);
            if (c.getVisibility() != 8) {
                LayoutParams lp = getLayoutParams(c);
                Spec columnSpec = lp.columnSpec;
                Spec rowSpec = lp.rowSpec;
                Interval colSpan = columnSpec.span;
                Interval rowSpan = rowSpec.span;
                int x1 = hLocations[colSpan.min];
                int y1 = vLocations[rowSpan.min];
                int cellWidth = hLocations[colSpan.max] - x1;
                int cellHeight = vLocations[rowSpan.max] - y1;
                int pWidth = getMeasurement(c, true);
                int pHeight = getMeasurement(c, false);
                Alignment hAlign = columnSpec.getAbsoluteAlignment(true);
                Alignment vAlign = rowSpec.getAbsoluteAlignment(false);
                Bounds boundsX = this.mHorizontalAxis.getGroupBounds().getValue(i);
                Bounds boundsY = this.mVerticalAxis.getGroupBounds().getValue(i);
                int gravityOffsetX = hAlign.getGravityOffset(c, cellWidth - boundsX.size(true));
                int gravityOffsetY = vAlign.getGravityOffset(c, cellHeight - boundsY.size(true));
                int leftMargin = getMargin(c, true, true);
                int topMargin = getMargin(c, false, true);
                int rightMargin = getMargin(c, true, false);
                int sumMarginsX = leftMargin + rightMargin;
                int sumMarginsY = topMargin + getMargin(c, false, false);
                int alignmentOffsetX = boundsX.getOffset(this, c, hAlign, pWidth + sumMarginsX, true);
                int alignmentOffsetY = boundsY.getOffset(this, c, vAlign, pHeight + sumMarginsY, false);
                int width = hAlign.getSizeInCell(c, pWidth, cellWidth - sumMarginsX);
                int height = vAlign.getSizeInCell(c, pHeight, cellHeight - sumMarginsY);
                int dx = x1 + gravityOffsetX + alignmentOffsetX;
                int cx = !isLayoutRtlCompat() ? paddingLeft + leftMargin + dx : (((targetWidth - width) - paddingRight) - rightMargin) - dx;
                int cy = paddingTop + y1 + gravityOffsetY + alignmentOffsetY + topMargin;
                if (!(width == c.getMeasuredWidth() && height == c.getMeasuredHeight())) {
                    c.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
                }
                c.layout(cx, cy, cx + width, cy + height);
            }
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$Axis */
    final class Axis {
        static final /* synthetic */ boolean $assertionsDisabled = (!GridLayout.class.desiredAssertionStatus());
        static final int COMPLETE = 2;
        static final int NEW = 0;
        static final int PENDING = 1;
        public Arc[] arcs;
        public boolean arcsValid = false;
        PackedMap<Interval, MutableInt> backwardLinks;
        public boolean backwardLinksValid = false;
        public int definedCount = Integer.MIN_VALUE;
        public int[] deltas;
        PackedMap<Interval, MutableInt> forwardLinks;
        public boolean forwardLinksValid = false;
        PackedMap<Spec, Bounds> groupBounds;
        public boolean groupBoundsValid = false;
        public boolean hasWeights;
        public boolean hasWeightsValid = false;
        public final boolean horizontal;
        public int[] leadingMargins;
        public boolean leadingMarginsValid = false;
        public int[] locations;
        public boolean locationsValid = false;
        private int maxIndex = Integer.MIN_VALUE;
        boolean orderPreserved = true;
        private MutableInt parentMax = new MutableInt(-100000);
        private MutableInt parentMin = new MutableInt(0);
        public int[] trailingMargins;
        public boolean trailingMarginsValid = false;

        Axis(boolean horizontal2) {
            this.horizontal = horizontal2;
        }

        private int calculateMaxIndex() {
            int result = -1;
            int N = GridLayout.this.getChildCount();
            for (int i = 0; i < N; i++) {
                LayoutParams params = GridLayout.this.getLayoutParams(GridLayout.this.getChildAt(i));
                Interval span = (this.horizontal ? params.columnSpec : params.rowSpec).span;
                result = Math.max(Math.max(Math.max(result, span.min), span.max), span.size());
            }
            if (result == -1) {
                return Integer.MIN_VALUE;
            }
            return result;
        }

        private int getMaxIndex() {
            if (this.maxIndex == Integer.MIN_VALUE) {
                this.maxIndex = Math.max(0, calculateMaxIndex());
            }
            return this.maxIndex;
        }

        public int getCount() {
            return Math.max(this.definedCount, getMaxIndex());
        }

        public void setCount(int count) {
            if (count != Integer.MIN_VALUE && count < getMaxIndex()) {
                GridLayout.handleInvalidParams((this.horizontal ? "column" : "row") + "Count must be greater than or equal to the maximum of all grid indices " + "(and spans) defined in the LayoutParams of each child");
            }
            this.definedCount = count;
        }

        public boolean isOrderPreserved() {
            return this.orderPreserved;
        }

        public void setOrderPreserved(boolean orderPreserved2) {
            this.orderPreserved = orderPreserved2;
            invalidateStructure();
        }

        private PackedMap<Spec, Bounds> createGroupBounds() {
            Assoc<Spec, Bounds> assoc = Assoc.m9of(Spec.class, Bounds.class);
            int N = GridLayout.this.getChildCount();
            for (int i = 0; i < N; i++) {
                LayoutParams lp = GridLayout.this.getLayoutParams(GridLayout.this.getChildAt(i));
                Spec spec = this.horizontal ? lp.columnSpec : lp.rowSpec;
                assoc.put(spec, spec.getAbsoluteAlignment(this.horizontal).getBounds());
            }
            return assoc.pack();
        }

        private void computeGroupBounds() {
            int i;
            Bounds[] values = (Bounds[]) this.groupBounds.values;
            for (Bounds reset : values) {
                reset.reset();
            }
            int N = GridLayout.this.getChildCount();
            for (int i2 = 0; i2 < N; i2++) {
                View c = GridLayout.this.getChildAt(i2);
                LayoutParams lp = GridLayout.this.getLayoutParams(c);
                Spec spec = this.horizontal ? lp.columnSpec : lp.rowSpec;
                int measurementIncludingMargin = GridLayout.this.getMeasurementIncludingMargin(c, this.horizontal);
                if (spec.weight == 0.0f) {
                    i = 0;
                } else {
                    i = getDeltas()[i2];
                }
                this.groupBounds.getValue(i2).include(GridLayout.this, c, spec, this, measurementIncludingMargin + i);
            }
        }

        public PackedMap<Spec, Bounds> getGroupBounds() {
            if (this.groupBounds == null) {
                this.groupBounds = createGroupBounds();
            }
            if (!this.groupBoundsValid) {
                computeGroupBounds();
                this.groupBoundsValid = true;
            }
            return this.groupBounds;
        }

        private PackedMap<Interval, MutableInt> createLinks(boolean min) {
            Assoc<Interval, MutableInt> result = Assoc.m9of(Interval.class, MutableInt.class);
            Spec[] keys = (Spec[]) getGroupBounds().keys;
            int N = keys.length;
            for (int i = 0; i < N; i++) {
                result.put(min ? keys[i].span : keys[i].span.inverse(), new MutableInt());
            }
            return result.pack();
        }

        private void computeLinks(PackedMap<Interval, MutableInt> links, boolean min) {
            MutableInt[] spans = (MutableInt[]) links.values;
            for (MutableInt reset : spans) {
                reset.reset();
            }
            Bounds[] bounds = (Bounds[]) getGroupBounds().values;
            for (int i = 0; i < bounds.length; i++) {
                int size = bounds[i].size(min);
                MutableInt valueHolder = links.getValue(i);
                int i2 = valueHolder.value;
                if (!min) {
                    size = -size;
                }
                valueHolder.value = Math.max(i2, size);
            }
        }

        private PackedMap<Interval, MutableInt> getForwardLinks() {
            if (this.forwardLinks == null) {
                this.forwardLinks = createLinks(true);
            }
            if (!this.forwardLinksValid) {
                computeLinks(this.forwardLinks, true);
                this.forwardLinksValid = true;
            }
            return this.forwardLinks;
        }

        private PackedMap<Interval, MutableInt> getBackwardLinks() {
            if (this.backwardLinks == null) {
                this.backwardLinks = createLinks(false);
            }
            if (!this.backwardLinksValid) {
                computeLinks(this.backwardLinks, false);
                this.backwardLinksValid = true;
            }
            return this.backwardLinks;
        }

        private void include(List<Arc> arcs2, Interval key, MutableInt size, boolean ignoreIfAlreadyPresent) {
            if (key.size() != 0) {
                if (ignoreIfAlreadyPresent) {
                    for (Arc arc : arcs2) {
                        if (arc.span.equals(key)) {
                            return;
                        }
                    }
                }
                arcs2.add(new Arc(key, size));
            }
        }

        private void include(List<Arc> arcs2, Interval key, MutableInt size) {
            include(arcs2, key, size, true);
        }

        /* access modifiers changed from: package-private */
        public Arc[][] groupArcsByFirstVertex(Arc[] arcs2) {
            int N = getCount() + 1;
            Arc[][] result = new Arc[N][];
            int[] sizes = new int[N];
            for (Arc arc : arcs2) {
                int i = arc.span.min;
                sizes[i] = sizes[i] + 1;
            }
            for (int i2 = 0; i2 < sizes.length; i2++) {
                result[i2] = new Arc[sizes[i2]];
            }
            Arrays.fill(sizes, 0);
            for (Arc arc2 : arcs2) {
                int i3 = arc2.span.min;
                Arc[] arcArr = result[i3];
                int i4 = sizes[i3];
                sizes[i3] = i4 + 1;
                arcArr[i4] = arc2;
            }
            return result;
        }

        private Arc[] topologicalSort(final Arc[] arcs2) {
            return new Object() {
                static final /* synthetic */ boolean $assertionsDisabled = (!GridLayout.class.desiredAssertionStatus());
                Arc[][] arcsByVertex = Axis.this.groupArcsByFirstVertex(arcs2);
                int cursor = (this.result.length - 1);
                Arc[] result = new Arc[arcs2.length];
                int[] visited = new int[(Axis.this.getCount() + 1)];

                /* access modifiers changed from: package-private */
                public void walk(int loc) {
                    switch (this.visited[loc]) {
                        case 0:
                            this.visited[loc] = 1;
                            for (Arc arc : this.arcsByVertex[loc]) {
                                walk(arc.span.max);
                                Arc[] arcArr = this.result;
                                int i = this.cursor;
                                this.cursor = i - 1;
                                arcArr[i] = arc;
                            }
                            this.visited[loc] = 2;
                            return;
                        case 1:
                            if (!$assertionsDisabled) {
                                throw new AssertionError();
                            }
                            return;
                        default:
                            return;
                    }
                }

                /* access modifiers changed from: package-private */
                public Arc[] sort() {
                    int N = this.arcsByVertex.length;
                    for (int loc = 0; loc < N; loc++) {
                        walk(loc);
                    }
                    if ($assertionsDisabled || this.cursor == -1) {
                        return this.result;
                    }
                    throw new AssertionError();
                }
            }.sort();
        }

        private Arc[] topologicalSort(List<Arc> arcs2) {
            return topologicalSort((Arc[]) arcs2.toArray(new Arc[arcs2.size()]));
        }

        private void addComponentSizes(List<Arc> result, PackedMap<Interval, MutableInt> links) {
            for (int i = 0; i < ((Interval[]) links.keys).length; i++) {
                include(result, ((Interval[]) links.keys)[i], ((MutableInt[]) links.values)[i], false);
            }
        }

        private Arc[] createArcs() {
            List<Arc> mins = new ArrayList<>();
            List<Arc> maxs = new ArrayList<>();
            addComponentSizes(mins, getForwardLinks());
            addComponentSizes(maxs, getBackwardLinks());
            if (this.orderPreserved) {
                for (int i = 0; i < getCount(); i++) {
                    include(mins, new Interval(i, i + 1), new MutableInt(0));
                }
            }
            int N = getCount();
            include(mins, new Interval(0, N), this.parentMin, false);
            include(maxs, new Interval(N, 0), this.parentMax, false);
            return (Arc[]) GridLayout.append(topologicalSort(mins), topologicalSort(maxs));
        }

        private void computeArcs() {
            getForwardLinks();
            getBackwardLinks();
        }

        public Arc[] getArcs() {
            if (this.arcs == null) {
                this.arcs = createArcs();
            }
            if (!this.arcsValid) {
                computeArcs();
                this.arcsValid = true;
            }
            return this.arcs;
        }

        private boolean relax(int[] locations2, Arc entry) {
            if (!entry.valid) {
                return false;
            }
            Interval span = entry.span;
            int u = span.min;
            int v = span.max;
            int candidate = locations2[u] + entry.value.value;
            if (candidate <= locations2[v]) {
                return false;
            }
            locations2[v] = candidate;
            return true;
        }

        private void init(int[] locations2) {
            Arrays.fill(locations2, 0);
        }

        private String arcsToString(List<Arc> arcs2) {
            String str;
            String var = this.horizontal ? "x" : "y";
            StringBuilder result = new StringBuilder();
            boolean first = true;
            for (Arc arc : arcs2) {
                if (first) {
                    first = false;
                } else {
                    result = result.append(", ");
                }
                int src = arc.span.min;
                int dst = arc.span.max;
                int value = arc.value.value;
                if (src < dst) {
                    str = var + dst + SchulteTableFragment.NON_INITIALIZATION_VALUE + var + src + ">=" + value;
                } else {
                    str = var + src + SchulteTableFragment.NON_INITIALIZATION_VALUE + var + dst + "<=" + (-value);
                }
                result.append(str);
            }
            return result.toString();
        }

        private void logError(String axisName, Arc[] arcs2, boolean[] culprits0) {
            List<Arc> culprits = new ArrayList<>();
            List<Arc> removed = new ArrayList<>();
            for (int c = 0; c < arcs2.length; c++) {
                Arc arc = arcs2[c];
                if (culprits0[c]) {
                    culprits.add(arc);
                }
                if (!arc.valid) {
                    removed.add(arc);
                }
            }
            GridLayout.this.mPrinter.println(axisName + " constraints: " + arcsToString(culprits) + " are inconsistent; permanently removing: " + arcsToString(removed) + ". ");
        }

        private boolean solve(Arc[] arcs2, int[] locations2) {
            return solve(arcs2, locations2, true);
        }

        private boolean solve(Arc[] arcs2, int[] locations2, boolean modifyOnError) {
            String axisName = this.horizontal ? "horizontal" : "vertical";
            int N = getCount() + 1;
            boolean[] originalCulprits = null;
            for (int p = 0; p < arcs2.length; p++) {
                init(locations2);
                for (int i = 0; i < N; i++) {
                    boolean changed = false;
                    for (Arc relax : arcs2) {
                        changed |= relax(locations2, relax);
                    }
                    if (!changed) {
                        if (originalCulprits != null) {
                            logError(axisName, arcs2, originalCulprits);
                        }
                        return true;
                    }
                }
                if (!modifyOnError) {
                    return false;
                }
                boolean[] culprits = new boolean[arcs2.length];
                for (int i2 = 0; i2 < N; i2++) {
                    int length = arcs2.length;
                    for (int j = 0; j < length; j++) {
                        culprits[j] = culprits[j] | relax(locations2, arcs2[j]);
                    }
                }
                if (p == 0) {
                    originalCulprits = culprits;
                }
                int i3 = 0;
                while (true) {
                    if (i3 >= arcs2.length) {
                        break;
                    }
                    if (culprits[i3]) {
                        Arc arc = arcs2[i3];
                        if (arc.span.min >= arc.span.max) {
                            arc.valid = false;
                            break;
                        }
                    }
                    i3++;
                }
            }
            return true;
        }

        private void computeMargins(boolean leading) {
            int[] margins = leading ? this.leadingMargins : this.trailingMargins;
            int N = GridLayout.this.getChildCount();
            for (int i = 0; i < N; i++) {
                View c = GridLayout.this.getChildAt(i);
                if (c.getVisibility() != 8) {
                    LayoutParams lp = GridLayout.this.getLayoutParams(c);
                    Interval span = (this.horizontal ? lp.columnSpec : lp.rowSpec).span;
                    int index = leading ? span.min : span.max;
                    margins[index] = Math.max(margins[index], GridLayout.this.getMargin1(c, this.horizontal, leading));
                }
            }
        }

        public int[] getLeadingMargins() {
            if (this.leadingMargins == null) {
                this.leadingMargins = new int[(getCount() + 1)];
            }
            if (!this.leadingMarginsValid) {
                computeMargins(true);
                this.leadingMarginsValid = true;
            }
            return this.leadingMargins;
        }

        public int[] getTrailingMargins() {
            if (this.trailingMargins == null) {
                this.trailingMargins = new int[(getCount() + 1)];
            }
            if (!this.trailingMarginsValid) {
                computeMargins(false);
                this.trailingMarginsValid = true;
            }
            return this.trailingMargins;
        }

        private boolean solve(int[] a) {
            return solve(getArcs(), a);
        }

        private boolean computeHasWeights() {
            int N = GridLayout.this.getChildCount();
            for (int i = 0; i < N; i++) {
                View child = GridLayout.this.getChildAt(i);
                if (child.getVisibility() != 8) {
                    LayoutParams lp = GridLayout.this.getLayoutParams(child);
                    if ((this.horizontal ? lp.columnSpec : lp.rowSpec).weight != 0.0f) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean hasWeights() {
            if (!this.hasWeightsValid) {
                this.hasWeights = computeHasWeights();
                this.hasWeightsValid = true;
            }
            return this.hasWeights;
        }

        public int[] getDeltas() {
            if (this.deltas == null) {
                this.deltas = new int[GridLayout.this.getChildCount()];
            }
            return this.deltas;
        }

        private void shareOutDelta(int totalDelta, float totalWeight) {
            Arrays.fill(this.deltas, 0);
            int N = GridLayout.this.getChildCount();
            for (int i = 0; i < N; i++) {
                View c = GridLayout.this.getChildAt(i);
                if (c.getVisibility() != 8) {
                    LayoutParams lp = GridLayout.this.getLayoutParams(c);
                    float weight = (this.horizontal ? lp.columnSpec : lp.rowSpec).weight;
                    if (weight != 0.0f) {
                        int delta = Math.round((((float) totalDelta) * weight) / totalWeight);
                        this.deltas[i] = delta;
                        totalDelta -= delta;
                        totalWeight -= weight;
                    }
                }
            }
        }

        private void solveAndDistributeSpace(int[] a) {
            Arrays.fill(getDeltas(), 0);
            solve(a);
            int deltaMax = (this.parentMin.value * GridLayout.this.getChildCount()) + 1;
            if (deltaMax >= 2) {
                int deltaMin = 0;
                float totalWeight = calculateTotalWeight();
                int validDelta = -1;
                boolean validSolution = true;
                while (deltaMin < deltaMax) {
                    int delta = (int) ((((long) deltaMin) + ((long) deltaMax)) / 2);
                    invalidateValues();
                    shareOutDelta(delta, totalWeight);
                    validSolution = solve(getArcs(), a, false);
                    if (validSolution) {
                        validDelta = delta;
                        deltaMin = delta + 1;
                    } else {
                        deltaMax = delta;
                    }
                }
                if (validDelta > 0 && !validSolution) {
                    invalidateValues();
                    shareOutDelta(validDelta, totalWeight);
                    solve(a);
                }
            }
        }

        private float calculateTotalWeight() {
            float totalWeight = 0.0f;
            int N = GridLayout.this.getChildCount();
            for (int i = 0; i < N; i++) {
                View c = GridLayout.this.getChildAt(i);
                if (c.getVisibility() != 8) {
                    LayoutParams lp = GridLayout.this.getLayoutParams(c);
                    totalWeight += (this.horizontal ? lp.columnSpec : lp.rowSpec).weight;
                }
            }
            return totalWeight;
        }

        private void computeLocations(int[] a) {
            if (!hasWeights()) {
                solve(a);
            } else {
                solveAndDistributeSpace(a);
            }
            if (!this.orderPreserved) {
                int a0 = a[0];
                int N = a.length;
                for (int i = 0; i < N; i++) {
                    a[i] = a[i] - a0;
                }
            }
        }

        public int[] getLocations() {
            if (this.locations == null) {
                this.locations = new int[(getCount() + 1)];
            }
            if (!this.locationsValid) {
                computeLocations(this.locations);
                this.locationsValid = true;
            }
            return this.locations;
        }

        private int size(int[] locations2) {
            return locations2[getCount()];
        }

        private void setParentConstraints(int min, int max) {
            this.parentMin.value = min;
            this.parentMax.value = -max;
            this.locationsValid = false;
        }

        private int getMeasure(int min, int max) {
            setParentConstraints(min, max);
            return size(getLocations());
        }

        public int getMeasure(int measureSpec) {
            int mode = View.MeasureSpec.getMode(measureSpec);
            int size = View.MeasureSpec.getSize(measureSpec);
            switch (mode) {
                case Integer.MIN_VALUE:
                    return getMeasure(0, size);
                case 0:
                    return getMeasure(0, GridLayout.MAX_SIZE);
                case 1073741824:
                    return getMeasure(size, size);
                default:
                    if ($assertionsDisabled) {
                        return 0;
                    }
                    throw new AssertionError();
            }
        }

        public void layout(int size) {
            setParentConstraints(size, size);
            getLocations();
        }

        public void invalidateStructure() {
            this.maxIndex = Integer.MIN_VALUE;
            this.groupBounds = null;
            this.forwardLinks = null;
            this.backwardLinks = null;
            this.leadingMargins = null;
            this.trailingMargins = null;
            this.arcs = null;
            this.locations = null;
            this.deltas = null;
            this.hasWeightsValid = false;
            invalidateValues();
        }

        public void invalidateValues() {
            this.groupBoundsValid = false;
            this.forwardLinksValid = false;
            this.backwardLinksValid = false;
            this.leadingMarginsValid = false;
            this.trailingMarginsValid = false;
            this.arcsValid = false;
            this.locationsValid = false;
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$LayoutParams */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int BOTTOM_MARGIN = C0362R.styleable.GridLayout_Layout_android_layout_marginBottom;
        private static final int COLUMN = C0362R.styleable.GridLayout_Layout_layout_column;
        private static final int COLUMN_SPAN = C0362R.styleable.GridLayout_Layout_layout_columnSpan;
        private static final int COLUMN_WEIGHT = C0362R.styleable.GridLayout_Layout_layout_columnWeight;
        private static final int DEFAULT_COLUMN = Integer.MIN_VALUE;
        private static final int DEFAULT_HEIGHT = -2;
        private static final int DEFAULT_MARGIN = Integer.MIN_VALUE;
        private static final int DEFAULT_ROW = Integer.MIN_VALUE;
        private static final Interval DEFAULT_SPAN = new Interval(Integer.MIN_VALUE, -2147483647);
        private static final int DEFAULT_SPAN_SIZE = DEFAULT_SPAN.size();
        private static final int DEFAULT_WIDTH = -2;
        private static final int GRAVITY = C0362R.styleable.GridLayout_Layout_layout_gravity;
        private static final int LEFT_MARGIN = C0362R.styleable.GridLayout_Layout_android_layout_marginLeft;
        private static final int MARGIN = C0362R.styleable.GridLayout_Layout_android_layout_margin;
        private static final int RIGHT_MARGIN = C0362R.styleable.GridLayout_Layout_android_layout_marginRight;
        private static final int ROW = C0362R.styleable.GridLayout_Layout_layout_row;
        private static final int ROW_SPAN = C0362R.styleable.GridLayout_Layout_layout_rowSpan;
        private static final int ROW_WEIGHT = C0362R.styleable.GridLayout_Layout_layout_rowWeight;
        private static final int TOP_MARGIN = C0362R.styleable.GridLayout_Layout_android_layout_marginTop;
        public Spec columnSpec;
        public Spec rowSpec;

        private LayoutParams(int width, int height, int left, int top, int right, int bottom, Spec rowSpec2, Spec columnSpec2) {
            super(width, height);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
            setMargins(left, top, right, bottom);
            this.rowSpec = rowSpec2;
            this.columnSpec = columnSpec2;
        }

        public LayoutParams(Spec rowSpec2, Spec columnSpec2) {
            this(-2, -2, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, rowSpec2, columnSpec2);
        }

        public LayoutParams() {
            this(Spec.UNDEFINED, Spec.UNDEFINED);
        }

        public LayoutParams(ViewGroup.LayoutParams params) {
            super(params);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams params) {
            super(params);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
        }

        public LayoutParams(LayoutParams source) {
            super(source);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
            this.rowSpec = source.rowSpec;
            this.columnSpec = source.columnSpec;
        }

        public LayoutParams(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.rowSpec = Spec.UNDEFINED;
            this.columnSpec = Spec.UNDEFINED;
            reInitSuper(context, attrs);
            init(context, attrs);
        }

        private void reInitSuper(Context context, AttributeSet attrs) {
            TypedArray a = context.obtainStyledAttributes(attrs, C0362R.styleable.GridLayout_Layout);
            try {
                int margin = a.getDimensionPixelSize(MARGIN, Integer.MIN_VALUE);
                this.leftMargin = a.getDimensionPixelSize(LEFT_MARGIN, margin);
                this.topMargin = a.getDimensionPixelSize(TOP_MARGIN, margin);
                this.rightMargin = a.getDimensionPixelSize(RIGHT_MARGIN, margin);
                this.bottomMargin = a.getDimensionPixelSize(BOTTOM_MARGIN, margin);
            } finally {
                a.recycle();
            }
        }

        private void init(Context context, AttributeSet attrs) {
            TypedArray a = context.obtainStyledAttributes(attrs, C0362R.styleable.GridLayout_Layout);
            try {
                int gravity = a.getInt(GRAVITY, 0);
                this.columnSpec = GridLayout.spec(a.getInt(COLUMN, Integer.MIN_VALUE), a.getInt(COLUMN_SPAN, DEFAULT_SPAN_SIZE), GridLayout.getAlignment(gravity, true), a.getFloat(COLUMN_WEIGHT, 0.0f));
                this.rowSpec = GridLayout.spec(a.getInt(ROW, Integer.MIN_VALUE), a.getInt(ROW_SPAN, DEFAULT_SPAN_SIZE), GridLayout.getAlignment(gravity, false), a.getFloat(ROW_WEIGHT, 0.0f));
            } finally {
                a.recycle();
            }
        }

        public void setGravity(int gravity) {
            this.rowSpec = this.rowSpec.copyWriteAlignment(GridLayout.getAlignment(gravity, false));
            this.columnSpec = this.columnSpec.copyWriteAlignment(GridLayout.getAlignment(gravity, true));
        }

        /* access modifiers changed from: protected */
        public void setBaseAttributes(TypedArray attributes, int widthAttr, int heightAttr) {
            this.width = attributes.getLayoutDimension(widthAttr, -2);
            this.height = attributes.getLayoutDimension(heightAttr, -2);
        }

        /* access modifiers changed from: package-private */
        public final void setRowSpecSpan(Interval span) {
            this.rowSpec = this.rowSpec.copyWriteSpan(span);
        }

        /* access modifiers changed from: package-private */
        public final void setColumnSpecSpan(Interval span) {
            this.columnSpec = this.columnSpec.copyWriteSpan(span);
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            LayoutParams that = (LayoutParams) o;
            if (!this.columnSpec.equals(that.columnSpec)) {
                return false;
            }
            if (!this.rowSpec.equals(that.rowSpec)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.rowSpec.hashCode() * 31) + this.columnSpec.hashCode();
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$Arc */
    static final class Arc {
        public final Interval span;
        public boolean valid = true;
        public final MutableInt value;

        public Arc(Interval span2, MutableInt value2) {
            this.span = span2;
            this.value = value2;
        }

        public String toString() {
            return this.span + " " + (!this.valid ? "+>" : "->") + " " + this.value;
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$MutableInt */
    static final class MutableInt {
        public int value;

        public MutableInt() {
            reset();
        }

        public MutableInt(int value2) {
            this.value = value2;
        }

        public void reset() {
            this.value = Integer.MIN_VALUE;
        }

        public String toString() {
            return Integer.toString(this.value);
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$Assoc */
    static final class Assoc<K, V> extends ArrayList<Pair<K, V>> {
        private final Class<K> keyType;
        private final Class<V> valueType;

        private Assoc(Class<K> keyType2, Class<V> valueType2) {
            this.keyType = keyType2;
            this.valueType = valueType2;
        }

        /* renamed from: of */
        public static <K, V> Assoc<K, V> m9of(Class<K> keyType2, Class<V> valueType2) {
            return new Assoc<>(keyType2, valueType2);
        }

        public void put(K key, V value) {
            add(Pair.create(key, value));
        }

        public PackedMap<K, V> pack() {
            int N = size();
            K[] keys = (Object[]) ((Object[]) Array.newInstance(this.keyType, N));
            V[] values = (Object[]) ((Object[]) Array.newInstance(this.valueType, N));
            for (int i = 0; i < N; i++) {
                keys[i] = ((Pair) get(i)).first;
                values[i] = ((Pair) get(i)).second;
            }
            return new PackedMap<>(keys, values);
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$PackedMap */
    static final class PackedMap<K, V> {
        public final int[] index;
        public final K[] keys;
        public final V[] values;

        PackedMap(K[] keys2, V[] values2) {
            this.index = createIndex(keys2);
            this.keys = compact(keys2, this.index);
            this.values = compact(values2, this.index);
        }

        public V getValue(int i) {
            return this.values[this.index[i]];
        }

        private static <K> int[] createIndex(K[] keys2) {
            int size = keys2.length;
            int[] result = new int[size];
            Map<K, Integer> keyToIndex = new HashMap<>();
            for (int i = 0; i < size; i++) {
                K key = keys2[i];
                Integer index2 = keyToIndex.get(key);
                if (index2 == null) {
                    index2 = Integer.valueOf(keyToIndex.size());
                    keyToIndex.put(key, index2);
                }
                result[i] = index2.intValue();
            }
            return result;
        }

        private static <K> K[] compact(K[] a, int[] index2) {
            int size = a.length;
            K[] result = (Object[]) ((Object[]) Array.newInstance(a.getClass().getComponentType(), GridLayout.max2(index2, -1) + 1));
            for (int i = 0; i < size; i++) {
                result[index2[i]] = a[i];
            }
            return result;
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$Bounds */
    static class Bounds {
        public int after;
        public int before;
        public int flexibility;

        Bounds() {
            reset();
        }

        /* access modifiers changed from: protected */
        public void reset() {
            this.before = Integer.MIN_VALUE;
            this.after = Integer.MIN_VALUE;
            this.flexibility = 2;
        }

        /* access modifiers changed from: protected */
        public void include(int before2, int after2) {
            this.before = Math.max(this.before, before2);
            this.after = Math.max(this.after, after2);
        }

        /* access modifiers changed from: protected */
        public int size(boolean min) {
            if (min || !GridLayout.canStretch(this.flexibility)) {
                return this.before + this.after;
            }
            return GridLayout.MAX_SIZE;
        }

        /* access modifiers changed from: protected */
        public int getOffset(GridLayout gl, View c, Alignment a, int size, boolean horizontal) {
            return this.before - a.getAlignmentValue(c, size, ViewGroupCompat.getLayoutMode(gl));
        }

        /* access modifiers changed from: protected */
        public final void include(GridLayout gl, View c, Spec spec, Axis axis, int size) {
            this.flexibility &= spec.getFlexibility();
            int before2 = spec.getAbsoluteAlignment(axis.horizontal).getAlignmentValue(c, size, ViewGroupCompat.getLayoutMode(gl));
            include(before2, size - before2);
        }

        public String toString() {
            return "Bounds{before=" + this.before + ", after=" + this.after + '}';
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$Interval */
    static final class Interval {
        public final int max;
        public final int min;

        public Interval(int min2, int max2) {
            this.min = min2;
            this.max = max2;
        }

        /* access modifiers changed from: package-private */
        public int size() {
            return this.max - this.min;
        }

        /* access modifiers changed from: package-private */
        public Interval inverse() {
            return new Interval(this.max, this.min);
        }

        public boolean equals(Object that) {
            if (this == that) {
                return true;
            }
            if (that == null || getClass() != that.getClass()) {
                return false;
            }
            Interval interval = (Interval) that;
            if (this.max != interval.max) {
                return false;
            }
            if (this.min != interval.min) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.min * 31) + this.max;
        }

        public String toString() {
            return "[" + this.min + ", " + this.max + "]";
        }
    }

    /* renamed from: android.support.v7.widget.GridLayout$Spec */
    public static class Spec {
        static final float DEFAULT_WEIGHT = 0.0f;
        static final Spec UNDEFINED = GridLayout.spec(Integer.MIN_VALUE);
        final Alignment alignment;
        final Interval span;
        final boolean startDefined;
        final float weight;

        private Spec(boolean startDefined2, Interval span2, Alignment alignment2, float weight2) {
            this.startDefined = startDefined2;
            this.span = span2;
            this.alignment = alignment2;
            this.weight = weight2;
        }

        Spec(boolean startDefined2, int start, int size, Alignment alignment2, float weight2) {
            this(startDefined2, new Interval(start, start + size), alignment2, weight2);
        }

        public Alignment getAbsoluteAlignment(boolean horizontal) {
            if (this.alignment != GridLayout.UNDEFINED_ALIGNMENT) {
                return this.alignment;
            }
            if (this.weight == 0.0f) {
                return horizontal ? GridLayout.START : GridLayout.BASELINE;
            }
            return GridLayout.FILL;
        }

        /* access modifiers changed from: package-private */
        public final Spec copyWriteSpan(Interval span2) {
            return new Spec(this.startDefined, span2, this.alignment, this.weight);
        }

        /* access modifiers changed from: package-private */
        public final Spec copyWriteAlignment(Alignment alignment2) {
            return new Spec(this.startDefined, this.span, alignment2, this.weight);
        }

        /* access modifiers changed from: package-private */
        public final int getFlexibility() {
            return (this.alignment == GridLayout.UNDEFINED_ALIGNMENT && this.weight == 0.0f) ? 0 : 2;
        }

        public boolean equals(Object that) {
            if (this == that) {
                return true;
            }
            if (that == null || getClass() != that.getClass()) {
                return false;
            }
            Spec spec = (Spec) that;
            if (!this.alignment.equals(spec.alignment)) {
                return false;
            }
            if (!this.span.equals(spec.span)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.span.hashCode() * 31) + this.alignment.hashCode();
        }
    }

    public static Spec spec(int start, int size, Alignment alignment, float weight) {
        return new Spec(start != Integer.MIN_VALUE, start, size, alignment, weight);
    }

    public static Spec spec(int start, Alignment alignment, float weight) {
        return spec(start, 1, alignment, weight);
    }

    public static Spec spec(int start, int size, float weight) {
        return spec(start, size, UNDEFINED_ALIGNMENT, weight);
    }

    public static Spec spec(int start, float weight) {
        return spec(start, 1, weight);
    }

    public static Spec spec(int start, int size, Alignment alignment) {
        return spec(start, size, alignment, 0.0f);
    }

    public static Spec spec(int start, Alignment alignment) {
        return spec(start, 1, alignment);
    }

    public static Spec spec(int start, int size) {
        return spec(start, size, UNDEFINED_ALIGNMENT);
    }

    public static Spec spec(int start) {
        return spec(start, 1);
    }

    /* renamed from: android.support.v7.widget.GridLayout$Alignment */
    public static abstract class Alignment {
        /* access modifiers changed from: package-private */
        public abstract int getAlignmentValue(View view, int i, int i2);

        /* access modifiers changed from: package-private */
        public abstract String getDebugString();

        /* access modifiers changed from: package-private */
        public abstract int getGravityOffset(View view, int i);

        Alignment() {
        }

        /* access modifiers changed from: package-private */
        public int getSizeInCell(View view, int viewSize, int cellSize) {
            return viewSize;
        }

        /* access modifiers changed from: package-private */
        public Bounds getBounds() {
            return new Bounds();
        }

        public String toString() {
            return "Alignment:" + getDebugString();
        }
    }

    private static Alignment createSwitchingAlignment(final Alignment ltr, final Alignment rtl) {
        return new Alignment() {
            /* access modifiers changed from: package-private */
            public int getGravityOffset(View view, int cellDelta) {
                boolean isLayoutRtl = true;
                if (ViewCompat.getLayoutDirection(view) != 1) {
                    isLayoutRtl = false;
                }
                return (!isLayoutRtl ? ltr : rtl).getGravityOffset(view, cellDelta);
            }

            public int getAlignmentValue(View view, int viewSize, int mode) {
                boolean isLayoutRtl = true;
                if (ViewCompat.getLayoutDirection(view) != 1) {
                    isLayoutRtl = false;
                }
                return (!isLayoutRtl ? ltr : rtl).getAlignmentValue(view, viewSize, mode);
            }

            /* access modifiers changed from: package-private */
            public String getDebugString() {
                return "SWITCHING[L:" + ltr.getDebugString() + ", R:" + rtl.getDebugString() + "]";
            }
        };
    }

    static boolean canStretch(int flexibility) {
        return (flexibility & 2) != 0;
    }
}
