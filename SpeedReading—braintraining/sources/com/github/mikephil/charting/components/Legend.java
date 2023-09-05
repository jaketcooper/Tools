package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;

public class Legend extends ComponentBase {
    private List<Boolean> mCalculatedLabelBreakPoints;
    private List<FSize> mCalculatedLabelSizes;
    private List<FSize> mCalculatedLineSizes;
    private LegendDirection mDirection;
    private boolean mDrawInside;
    private LegendEntry[] mEntries;
    private LegendEntry[] mExtraEntries;
    private DashPathEffect mFormLineDashEffect;
    private float mFormLineWidth;
    private float mFormSize;
    private float mFormToTextSpace;
    private LegendHorizontalAlignment mHorizontalAlignment;
    private boolean mIsLegendCustom;
    private float mMaxSizePercent;
    public float mNeededHeight;
    public float mNeededWidth;
    private LegendOrientation mOrientation;
    private LegendForm mShape;
    private float mStackSpace;
    public float mTextHeightMax;
    public float mTextWidthMax;
    private LegendVerticalAlignment mVerticalAlignment;
    private boolean mWordWrapEnabled;
    private float mXEntrySpace;
    private float mYEntrySpace;

    public enum LegendDirection {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    public enum LegendForm {
        NONE,
        EMPTY,
        DEFAULT,
        SQUARE,
        CIRCLE,
        LINE
    }

    public enum LegendHorizontalAlignment {
        LEFT,
        CENTER,
        RIGHT
    }

    public enum LegendOrientation {
        HORIZONTAL,
        VERTICAL
    }

    @Deprecated
    public enum LegendPosition {
        RIGHT_OF_CHART,
        RIGHT_OF_CHART_CENTER,
        RIGHT_OF_CHART_INSIDE,
        LEFT_OF_CHART,
        LEFT_OF_CHART_CENTER,
        LEFT_OF_CHART_INSIDE,
        BELOW_CHART_LEFT,
        BELOW_CHART_RIGHT,
        BELOW_CHART_CENTER,
        ABOVE_CHART_LEFT,
        ABOVE_CHART_RIGHT,
        ABOVE_CHART_CENTER,
        PIECHART_CENTER
    }

    public enum LegendVerticalAlignment {
        TOP,
        CENTER,
        BOTTOM
    }

    public Legend() {
        this.mEntries = new LegendEntry[0];
        this.mIsLegendCustom = false;
        this.mHorizontalAlignment = LegendHorizontalAlignment.LEFT;
        this.mVerticalAlignment = LegendVerticalAlignment.BOTTOM;
        this.mOrientation = LegendOrientation.HORIZONTAL;
        this.mDrawInside = false;
        this.mDirection = LegendDirection.LEFT_TO_RIGHT;
        this.mShape = LegendForm.SQUARE;
        this.mFormSize = 8.0f;
        this.mFormLineWidth = 3.0f;
        this.mFormLineDashEffect = null;
        this.mXEntrySpace = 6.0f;
        this.mYEntrySpace = 0.0f;
        this.mFormToTextSpace = 5.0f;
        this.mStackSpace = 3.0f;
        this.mMaxSizePercent = 0.95f;
        this.mNeededWidth = 0.0f;
        this.mNeededHeight = 0.0f;
        this.mTextHeightMax = 0.0f;
        this.mTextWidthMax = 0.0f;
        this.mWordWrapEnabled = false;
        this.mCalculatedLabelSizes = new ArrayList(16);
        this.mCalculatedLabelBreakPoints = new ArrayList(16);
        this.mCalculatedLineSizes = new ArrayList(16);
        this.mTextSize = Utils.convertDpToPixel(10.0f);
        this.mXOffset = Utils.convertDpToPixel(5.0f);
        this.mYOffset = Utils.convertDpToPixel(3.0f);
    }

    public Legend(LegendEntry[] entries) {
        this();
        if (entries == null) {
            throw new IllegalArgumentException("entries array is NULL");
        }
        this.mEntries = entries;
    }

    @Deprecated
    public Legend(int[] colors, String[] labels) {
        this();
        if (colors == null || labels == null) {
            throw new IllegalArgumentException("colors array or labels array is NULL");
        } else if (colors.length != labels.length) {
            throw new IllegalArgumentException("colors array and labels array need to be of same size");
        } else {
            List<LegendEntry> entries = new ArrayList<>();
            for (int i = 0; i < Math.min(colors.length, labels.length); i++) {
                LegendEntry entry = new LegendEntry();
                entry.formColor = colors[i];
                entry.label = labels[i];
                if (entry.formColor == 1122868) {
                    entry.form = LegendForm.NONE;
                } else if (entry.formColor == 1122867 || entry.formColor == 0) {
                    entry.form = LegendForm.EMPTY;
                }
                entries.add(entry);
            }
            this.mEntries = (LegendEntry[]) entries.toArray(new LegendEntry[entries.size()]);
        }
    }

    @Deprecated
    public Legend(List<Integer> colors, List<String> labels) {
        this(Utils.convertIntegers(colors), Utils.convertStrings(labels));
    }

    public void setEntries(List<LegendEntry> entries) {
        this.mEntries = (LegendEntry[]) entries.toArray(new LegendEntry[entries.size()]);
    }

    public LegendEntry[] getEntries() {
        return this.mEntries;
    }

    public float getMaximumEntryWidth(Paint p) {
        float max = 0.0f;
        float maxFormSize = 0.0f;
        float formToTextSpace = Utils.convertDpToPixel(this.mFormToTextSpace);
        for (LegendEntry entry : this.mEntries) {
            float formSize = Utils.convertDpToPixel(Float.isNaN(entry.formSize) ? this.mFormSize : entry.formSize);
            if (formSize > maxFormSize) {
                maxFormSize = formSize;
            }
            String label = entry.label;
            if (label != null) {
                float length = (float) Utils.calcTextWidth(p, label);
                if (length > max) {
                    max = length;
                }
            }
        }
        return max + maxFormSize + formToTextSpace;
    }

    public float getMaximumEntryHeight(Paint p) {
        float max = 0.0f;
        for (LegendEntry entry : this.mEntries) {
            String label = entry.label;
            if (label != null) {
                float length = (float) Utils.calcTextHeight(p, label);
                if (length > max) {
                    max = length;
                }
            }
        }
        return max;
    }

    @Deprecated
    public int[] getColors() {
        int[] old = new int[this.mEntries.length];
        for (int i = 0; i < this.mEntries.length; i++) {
            old[i] = this.mEntries[i].form == LegendForm.NONE ? ColorTemplate.COLOR_SKIP : this.mEntries[i].form == LegendForm.EMPTY ? ColorTemplate.COLOR_NONE : this.mEntries[i].formColor;
        }
        return old;
    }

    @Deprecated
    public String[] getLabels() {
        String[] old = new String[this.mEntries.length];
        for (int i = 0; i < this.mEntries.length; i++) {
            old[i] = this.mEntries[i].label;
        }
        return old;
    }

    @Deprecated
    public int[] getExtraColors() {
        int[] old = new int[this.mExtraEntries.length];
        for (int i = 0; i < this.mExtraEntries.length; i++) {
            old[i] = this.mExtraEntries[i].form == LegendForm.NONE ? ColorTemplate.COLOR_SKIP : this.mExtraEntries[i].form == LegendForm.EMPTY ? ColorTemplate.COLOR_NONE : this.mExtraEntries[i].formColor;
        }
        return old;
    }

    @Deprecated
    public String[] getExtraLabels() {
        String[] old = new String[this.mExtraEntries.length];
        for (int i = 0; i < this.mExtraEntries.length; i++) {
            old[i] = this.mExtraEntries[i].label;
        }
        return old;
    }

    public LegendEntry[] getExtraEntries() {
        return this.mExtraEntries;
    }

    public void setExtra(List<LegendEntry> entries) {
        this.mExtraEntries = (LegendEntry[]) entries.toArray(new LegendEntry[entries.size()]);
    }

    public void setExtra(LegendEntry[] entries) {
        if (entries == null) {
            entries = new LegendEntry[0];
        }
        this.mExtraEntries = entries;
    }

    @Deprecated
    public void setExtra(List<Integer> colors, List<String> labels) {
        setExtra(Utils.convertIntegers(colors), Utils.convertStrings(labels));
    }

    public void setExtra(int[] colors, String[] labels) {
        List<LegendEntry> entries = new ArrayList<>();
        for (int i = 0; i < Math.min(colors.length, labels.length); i++) {
            LegendEntry entry = new LegendEntry();
            entry.formColor = colors[i];
            entry.label = labels[i];
            if (entry.formColor == 1122868 || entry.formColor == 0) {
                entry.form = LegendForm.NONE;
            } else if (entry.formColor == 1122867) {
                entry.form = LegendForm.EMPTY;
            }
            entries.add(entry);
        }
        this.mExtraEntries = (LegendEntry[]) entries.toArray(new LegendEntry[entries.size()]);
    }

    public void setCustom(LegendEntry[] entries) {
        this.mEntries = entries;
        this.mIsLegendCustom = true;
    }

    public void setCustom(List<LegendEntry> entries) {
        this.mEntries = (LegendEntry[]) entries.toArray(new LegendEntry[entries.size()]);
        this.mIsLegendCustom = true;
    }

    public void resetCustom() {
        this.mIsLegendCustom = false;
    }

    public boolean isLegendCustom() {
        return this.mIsLegendCustom;
    }

    @Deprecated
    public LegendPosition getPosition() {
        if (this.mOrientation == LegendOrientation.VERTICAL && this.mHorizontalAlignment == LegendHorizontalAlignment.CENTER && this.mVerticalAlignment == LegendVerticalAlignment.CENTER) {
            return LegendPosition.PIECHART_CENTER;
        }
        if (this.mOrientation == LegendOrientation.HORIZONTAL) {
            if (this.mVerticalAlignment == LegendVerticalAlignment.TOP) {
                if (this.mHorizontalAlignment == LegendHorizontalAlignment.LEFT) {
                    return LegendPosition.ABOVE_CHART_LEFT;
                }
                return this.mHorizontalAlignment == LegendHorizontalAlignment.RIGHT ? LegendPosition.ABOVE_CHART_RIGHT : LegendPosition.ABOVE_CHART_CENTER;
            } else if (this.mHorizontalAlignment == LegendHorizontalAlignment.LEFT) {
                return LegendPosition.BELOW_CHART_LEFT;
            } else {
                return this.mHorizontalAlignment == LegendHorizontalAlignment.RIGHT ? LegendPosition.BELOW_CHART_RIGHT : LegendPosition.BELOW_CHART_CENTER;
            }
        } else if (this.mHorizontalAlignment == LegendHorizontalAlignment.LEFT) {
            if (this.mVerticalAlignment != LegendVerticalAlignment.TOP || !this.mDrawInside) {
                return this.mVerticalAlignment == LegendVerticalAlignment.CENTER ? LegendPosition.LEFT_OF_CHART_CENTER : LegendPosition.LEFT_OF_CHART;
            }
            return LegendPosition.LEFT_OF_CHART_INSIDE;
        } else if (this.mVerticalAlignment != LegendVerticalAlignment.TOP || !this.mDrawInside) {
            return this.mVerticalAlignment == LegendVerticalAlignment.CENTER ? LegendPosition.RIGHT_OF_CHART_CENTER : LegendPosition.RIGHT_OF_CHART;
        } else {
            return LegendPosition.RIGHT_OF_CHART_INSIDE;
        }
    }

    @Deprecated
    public void setPosition(LegendPosition newValue) {
        LegendHorizontalAlignment legendHorizontalAlignment;
        switch (newValue) {
            case LEFT_OF_CHART:
            case LEFT_OF_CHART_INSIDE:
            case LEFT_OF_CHART_CENTER:
                this.mHorizontalAlignment = LegendHorizontalAlignment.LEFT;
                this.mVerticalAlignment = newValue == LegendPosition.LEFT_OF_CHART_CENTER ? LegendVerticalAlignment.CENTER : LegendVerticalAlignment.TOP;
                this.mOrientation = LegendOrientation.VERTICAL;
                break;
            case RIGHT_OF_CHART:
            case RIGHT_OF_CHART_INSIDE:
            case RIGHT_OF_CHART_CENTER:
                this.mHorizontalAlignment = LegendHorizontalAlignment.RIGHT;
                this.mVerticalAlignment = newValue == LegendPosition.RIGHT_OF_CHART_CENTER ? LegendVerticalAlignment.CENTER : LegendVerticalAlignment.TOP;
                this.mOrientation = LegendOrientation.VERTICAL;
                break;
            case ABOVE_CHART_LEFT:
            case ABOVE_CHART_CENTER:
            case ABOVE_CHART_RIGHT:
                if (newValue == LegendPosition.ABOVE_CHART_LEFT) {
                    legendHorizontalAlignment = LegendHorizontalAlignment.LEFT;
                } else {
                    legendHorizontalAlignment = newValue == LegendPosition.ABOVE_CHART_RIGHT ? LegendHorizontalAlignment.RIGHT : LegendHorizontalAlignment.CENTER;
                }
                this.mHorizontalAlignment = legendHorizontalAlignment;
                this.mVerticalAlignment = LegendVerticalAlignment.TOP;
                this.mOrientation = LegendOrientation.HORIZONTAL;
                break;
            case BELOW_CHART_LEFT:
            case BELOW_CHART_CENTER:
            case BELOW_CHART_RIGHT:
                this.mHorizontalAlignment = newValue == LegendPosition.BELOW_CHART_LEFT ? LegendHorizontalAlignment.LEFT : newValue == LegendPosition.BELOW_CHART_RIGHT ? LegendHorizontalAlignment.RIGHT : LegendHorizontalAlignment.CENTER;
                this.mVerticalAlignment = LegendVerticalAlignment.BOTTOM;
                this.mOrientation = LegendOrientation.HORIZONTAL;
                break;
            case PIECHART_CENTER:
                this.mHorizontalAlignment = LegendHorizontalAlignment.CENTER;
                this.mVerticalAlignment = LegendVerticalAlignment.CENTER;
                this.mOrientation = LegendOrientation.VERTICAL;
                break;
        }
        this.mDrawInside = newValue == LegendPosition.LEFT_OF_CHART_INSIDE || newValue == LegendPosition.RIGHT_OF_CHART_INSIDE;
    }

    public LegendHorizontalAlignment getHorizontalAlignment() {
        return this.mHorizontalAlignment;
    }

    public void setHorizontalAlignment(LegendHorizontalAlignment value) {
        this.mHorizontalAlignment = value;
    }

    public LegendVerticalAlignment getVerticalAlignment() {
        return this.mVerticalAlignment;
    }

    public void setVerticalAlignment(LegendVerticalAlignment value) {
        this.mVerticalAlignment = value;
    }

    public LegendOrientation getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(LegendOrientation value) {
        this.mOrientation = value;
    }

    public boolean isDrawInsideEnabled() {
        return this.mDrawInside;
    }

    public void setDrawInside(boolean value) {
        this.mDrawInside = value;
    }

    public LegendDirection getDirection() {
        return this.mDirection;
    }

    public void setDirection(LegendDirection pos) {
        this.mDirection = pos;
    }

    public LegendForm getForm() {
        return this.mShape;
    }

    public void setForm(LegendForm shape) {
        this.mShape = shape;
    }

    public void setFormSize(float size) {
        this.mFormSize = size;
    }

    public float getFormSize() {
        return this.mFormSize;
    }

    public void setFormLineWidth(float size) {
        this.mFormLineWidth = size;
    }

    public float getFormLineWidth() {
        return this.mFormLineWidth;
    }

    public void setFormLineDashEffect(DashPathEffect dashPathEffect) {
        this.mFormLineDashEffect = dashPathEffect;
    }

    public DashPathEffect getFormLineDashEffect() {
        return this.mFormLineDashEffect;
    }

    public float getXEntrySpace() {
        return this.mXEntrySpace;
    }

    public void setXEntrySpace(float space) {
        this.mXEntrySpace = space;
    }

    public float getYEntrySpace() {
        return this.mYEntrySpace;
    }

    public void setYEntrySpace(float space) {
        this.mYEntrySpace = space;
    }

    public float getFormToTextSpace() {
        return this.mFormToTextSpace;
    }

    public void setFormToTextSpace(float space) {
        this.mFormToTextSpace = space;
    }

    public float getStackSpace() {
        return this.mStackSpace;
    }

    public void setStackSpace(float space) {
        this.mStackSpace = space;
    }

    public void setWordWrapEnabled(boolean enabled) {
        this.mWordWrapEnabled = enabled;
    }

    public boolean isWordWrapEnabled() {
        return this.mWordWrapEnabled;
    }

    public float getMaxSizePercent() {
        return this.mMaxSizePercent;
    }

    public void setMaxSizePercent(float maxSize) {
        this.mMaxSizePercent = maxSize;
    }

    public List<FSize> getCalculatedLabelSizes() {
        return this.mCalculatedLabelSizes;
    }

    public List<Boolean> getCalculatedLabelBreakPoints() {
        return this.mCalculatedLabelBreakPoints;
    }

    public List<FSize> getCalculatedLineSizes() {
        return this.mCalculatedLineSizes;
    }

    public void calculateDimensions(Paint labelpaint, ViewPortHandler viewPortHandler) {
        int size;
        float formSize;
        float requiredWidth;
        float requiredSpacing;
        int i;
        float formSize2;
        float defaultFormSize = Utils.convertDpToPixel(this.mFormSize);
        float stackSpace = Utils.convertDpToPixel(this.mStackSpace);
        float formToTextSpace = Utils.convertDpToPixel(this.mFormToTextSpace);
        float xEntrySpace = Utils.convertDpToPixel(this.mXEntrySpace);
        float yEntrySpace = Utils.convertDpToPixel(this.mYEntrySpace);
        boolean wordWrapEnabled = this.mWordWrapEnabled;
        LegendEntry[] entries = this.mEntries;
        int entryCount = entries.length;
        this.mTextWidthMax = getMaximumEntryWidth(labelpaint);
        this.mTextHeightMax = getMaximumEntryHeight(labelpaint);
        switch (this.mOrientation) {
            case VERTICAL:
                float maxWidth = 0.0f;
                float maxHeight = 0.0f;
                float width = 0.0f;
                float labelLineHeight = Utils.getLineHeight(labelpaint);
                boolean wasStacked = false;
                for (int i2 = 0; i2 < entryCount; i2++) {
                    LegendEntry e = entries[i2];
                    boolean drawingForm = e.form != LegendForm.NONE;
                    if (Float.isNaN(e.formSize)) {
                        formSize2 = defaultFormSize;
                    } else {
                        formSize2 = Utils.convertDpToPixel(e.formSize);
                    }
                    String label = e.label;
                    if (!wasStacked) {
                        width = 0.0f;
                    }
                    if (drawingForm) {
                        if (wasStacked) {
                            width += stackSpace;
                        }
                        width += formSize2;
                    }
                    if (label != null) {
                        if (drawingForm && !wasStacked) {
                            width += formToTextSpace;
                        } else if (wasStacked) {
                            maxWidth = Math.max(maxWidth, width);
                            maxHeight += labelLineHeight + yEntrySpace;
                            width = 0.0f;
                            wasStacked = false;
                        }
                        width += (float) Utils.calcTextWidth(labelpaint, label);
                        if (i2 < entryCount - 1) {
                            maxHeight += labelLineHeight + yEntrySpace;
                        }
                    } else {
                        wasStacked = true;
                        width += formSize2;
                        if (i2 < entryCount - 1) {
                            width += stackSpace;
                        }
                    }
                    maxWidth = Math.max(maxWidth, width);
                }
                this.mNeededWidth = maxWidth;
                this.mNeededHeight = maxHeight;
                break;
            case HORIZONTAL:
                float labelLineHeight2 = Utils.getLineHeight(labelpaint);
                float labelLineSpacing = Utils.getLineSpacing(labelpaint) + yEntrySpace;
                float contentWidth = viewPortHandler.contentWidth() * this.mMaxSizePercent;
                float maxLineWidth = 0.0f;
                float currentLineWidth = 0.0f;
                float requiredWidth2 = 0.0f;
                int stackedStartIndex = -1;
                this.mCalculatedLabelBreakPoints.clear();
                this.mCalculatedLabelSizes.clear();
                this.mCalculatedLineSizes.clear();
                for (int i3 = 0; i3 < entryCount; i3++) {
                    LegendEntry e2 = entries[i3];
                    boolean drawingForm2 = e2.form != LegendForm.NONE;
                    if (Float.isNaN(e2.formSize)) {
                        formSize = defaultFormSize;
                    } else {
                        formSize = Utils.convertDpToPixel(e2.formSize);
                    }
                    String label2 = e2.label;
                    this.mCalculatedLabelBreakPoints.add(false);
                    if (stackedStartIndex == -1) {
                        requiredWidth = 0.0f;
                    } else {
                        requiredWidth = requiredWidth2 + stackSpace;
                    }
                    if (label2 != null) {
                        this.mCalculatedLabelSizes.add(Utils.calcTextSize(labelpaint, label2));
                        requiredWidth2 = requiredWidth + (drawingForm2 ? formToTextSpace + formSize : 0.0f) + this.mCalculatedLabelSizes.get(i3).width;
                    } else {
                        this.mCalculatedLabelSizes.add(FSize.getInstance(0.0f, 0.0f));
                        if (!drawingForm2) {
                            formSize = 0.0f;
                        }
                        requiredWidth2 = requiredWidth + formSize;
                        if (stackedStartIndex == -1) {
                            stackedStartIndex = i3;
                        }
                    }
                    if (label2 != null || i3 == entryCount - 1) {
                        if (currentLineWidth == 0.0f) {
                            requiredSpacing = 0.0f;
                        } else {
                            requiredSpacing = xEntrySpace;
                        }
                        if (!wordWrapEnabled || currentLineWidth == 0.0f || contentWidth - currentLineWidth >= requiredSpacing + requiredWidth2) {
                            currentLineWidth += requiredSpacing + requiredWidth2;
                        } else {
                            this.mCalculatedLineSizes.add(FSize.getInstance(currentLineWidth, labelLineHeight2));
                            maxLineWidth = Math.max(maxLineWidth, currentLineWidth);
                            List<Boolean> list = this.mCalculatedLabelBreakPoints;
                            if (stackedStartIndex > -1) {
                                i = stackedStartIndex;
                            } else {
                                i = i3;
                            }
                            list.set(i, 1);
                            currentLineWidth = requiredWidth2;
                        }
                        if (i3 == entryCount - 1) {
                            this.mCalculatedLineSizes.add(FSize.getInstance(currentLineWidth, labelLineHeight2));
                            maxLineWidth = Math.max(maxLineWidth, currentLineWidth);
                        }
                    }
                    if (label2 != null) {
                        stackedStartIndex = -1;
                    }
                }
                this.mNeededWidth = maxLineWidth;
                float size2 = labelLineHeight2 * ((float) this.mCalculatedLineSizes.size());
                if (this.mCalculatedLineSizes.size() == 0) {
                    size = 0;
                } else {
                    size = this.mCalculatedLineSizes.size() - 1;
                }
                this.mNeededHeight = (((float) size) * labelLineSpacing) + size2;
                break;
        }
        this.mNeededHeight += this.mYOffset;
        this.mNeededWidth += this.mXOffset;
    }
}
