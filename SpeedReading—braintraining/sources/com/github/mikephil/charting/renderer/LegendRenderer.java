package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;

public class LegendRenderer extends Renderer {
    protected List<LegendEntry> computedEntries = new ArrayList(16);
    protected Paint.FontMetrics legendFontMetrics = new Paint.FontMetrics();
    protected Legend mLegend;
    protected Paint mLegendFormPaint;
    protected Paint mLegendLabelPaint;
    private Path mLineFormPath = new Path();

    public LegendRenderer(ViewPortHandler viewPortHandler, Legend legend) {
        super(viewPortHandler);
        this.mLegend = legend;
        this.mLegendLabelPaint = new Paint(1);
        this.mLegendLabelPaint.setTextSize(Utils.convertDpToPixel(9.0f));
        this.mLegendLabelPaint.setTextAlign(Paint.Align.LEFT);
        this.mLegendFormPaint = new Paint(1);
        this.mLegendFormPaint.setStyle(Paint.Style.FILL);
    }

    public Paint getLabelPaint() {
        return this.mLegendLabelPaint;
    }

    public Paint getFormPaint() {
        return this.mLegendFormPaint;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: com.github.mikephil.charting.data.ChartData<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: com.github.mikephil.charting.data.ChartData<?>} */
    /* JADX WARNING: type inference failed for: r25v0, types: [com.github.mikephil.charting.interfaces.datasets.IDataSet] */
    /* JADX WARNING: type inference failed for: r2v19, types: [com.github.mikephil.charting.interfaces.datasets.IDataSet] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void computeLegend(com.github.mikephil.charting.data.ChartData<?> r33) {
        /*
            r32 = this;
            r0 = r32
            com.github.mikephil.charting.components.Legend r2 = r0.mLegend
            boolean r2 = r2.isLegendCustom()
            if (r2 != 0) goto L_0x0207
            r0 = r32
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r2 = r0.computedEntries
            r2.clear()
            r27 = 0
        L_0x0013:
            int r2 = r33.getDataSetCount()
            r0 = r27
            if (r0 >= r2) goto L_0x01e3
            r0 = r33
            r1 = r27
            com.github.mikephil.charting.interfaces.datasets.IDataSet r25 = r0.getDataSetByIndex(r1)
            java.util.List r24 = r25.getColors()
            int r26 = r25.getEntryCount()
            r0 = r25
            boolean r2 = r0 instanceof com.github.mikephil.charting.interfaces.datasets.IBarDataSet
            if (r2 == 0) goto L_0x00ad
            r2 = r25
            com.github.mikephil.charting.interfaces.datasets.IBarDataSet r2 = (com.github.mikephil.charting.interfaces.datasets.IBarDataSet) r2
            boolean r2 = r2.isStacked()
            if (r2 == 0) goto L_0x00ad
            r23 = r25
            com.github.mikephil.charting.interfaces.datasets.IBarDataSet r23 = (com.github.mikephil.charting.interfaces.datasets.IBarDataSet) r23
            java.lang.String[] r30 = r23.getStackLabels()
            r28 = 0
        L_0x0045:
            int r2 = r24.size()
            r0 = r28
            if (r0 >= r2) goto L_0x0089
            int r2 = r23.getStackSize()
            r0 = r28
            if (r0 >= r2) goto L_0x0089
            r0 = r32
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r10 = r0.computedEntries
            com.github.mikephil.charting.components.LegendEntry r2 = new com.github.mikephil.charting.components.LegendEntry
            r0 = r30
            int r3 = r0.length
            int r3 = r28 % r3
            r3 = r30[r3]
            com.github.mikephil.charting.components.Legend$LegendForm r4 = r25.getForm()
            float r5 = r25.getFormSize()
            float r6 = r25.getFormLineWidth()
            android.graphics.DashPathEffect r7 = r25.getFormLineDashEffect()
            r0 = r24
            r1 = r28
            java.lang.Object r9 = r0.get(r1)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r8 = r9.intValue()
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r10.add(r2)
            int r28 = r28 + 1
            goto L_0x0045
        L_0x0089:
            java.lang.String r2 = r23.getLabel()
            if (r2 == 0) goto L_0x00a9
            r0 = r32
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r9 = r0.computedEntries
            com.github.mikephil.charting.components.LegendEntry r2 = new com.github.mikephil.charting.components.LegendEntry
            java.lang.String r3 = r25.getLabel()
            com.github.mikephil.charting.components.Legend$LegendForm r4 = com.github.mikephil.charting.components.Legend.LegendForm.NONE
            r5 = 2143289344(0x7fc00000, float:NaN)
            r6 = 2143289344(0x7fc00000, float:NaN)
            r7 = 0
            r8 = 1122867(0x112233, float:1.573472E-39)
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r9.add(r2)
        L_0x00a9:
            int r27 = r27 + 1
            goto L_0x0013
        L_0x00ad:
            r0 = r25
            boolean r2 = r0 instanceof com.github.mikephil.charting.interfaces.datasets.IPieDataSet
            if (r2 == 0) goto L_0x0123
            r29 = r25
            com.github.mikephil.charting.interfaces.datasets.IPieDataSet r29 = (com.github.mikephil.charting.interfaces.datasets.IPieDataSet) r29
            r28 = 0
        L_0x00b9:
            int r2 = r24.size()
            r0 = r28
            if (r0 >= r2) goto L_0x0102
            r0 = r28
            r1 = r26
            if (r0 >= r1) goto L_0x0102
            r0 = r32
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r10 = r0.computedEntries
            com.github.mikephil.charting.components.LegendEntry r2 = new com.github.mikephil.charting.components.LegendEntry
            r0 = r29
            r1 = r28
            com.github.mikephil.charting.data.Entry r3 = r0.getEntryForIndex(r1)
            com.github.mikephil.charting.data.PieEntry r3 = (com.github.mikephil.charting.data.PieEntry) r3
            java.lang.String r3 = r3.getLabel()
            com.github.mikephil.charting.components.Legend$LegendForm r4 = r25.getForm()
            float r5 = r25.getFormSize()
            float r6 = r25.getFormLineWidth()
            android.graphics.DashPathEffect r7 = r25.getFormLineDashEffect()
            r0 = r24
            r1 = r28
            java.lang.Object r9 = r0.get(r1)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r8 = r9.intValue()
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r10.add(r2)
            int r28 = r28 + 1
            goto L_0x00b9
        L_0x0102:
            java.lang.String r2 = r29.getLabel()
            if (r2 == 0) goto L_0x00a9
            r0 = r32
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r9 = r0.computedEntries
            com.github.mikephil.charting.components.LegendEntry r2 = new com.github.mikephil.charting.components.LegendEntry
            java.lang.String r3 = r25.getLabel()
            com.github.mikephil.charting.components.Legend$LegendForm r4 = com.github.mikephil.charting.components.Legend.LegendForm.NONE
            r5 = 2143289344(0x7fc00000, float:NaN)
            r6 = 2143289344(0x7fc00000, float:NaN)
            r7 = 0
            r8 = 1122867(0x112233, float:1.573472E-39)
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r9.add(r2)
            goto L_0x00a9
        L_0x0123:
            r0 = r25
            boolean r2 = r0 instanceof com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
            if (r2 == 0) goto L_0x0185
            r2 = r25
            com.github.mikephil.charting.interfaces.datasets.ICandleDataSet r2 = (com.github.mikephil.charting.interfaces.datasets.ICandleDataSet) r2
            int r2 = r2.getDecreasingColor()
            r3 = 1122867(0x112233, float:1.573472E-39)
            if (r2 == r3) goto L_0x0185
            r2 = r25
            com.github.mikephil.charting.interfaces.datasets.ICandleDataSet r2 = (com.github.mikephil.charting.interfaces.datasets.ICandleDataSet) r2
            int r8 = r2.getDecreasingColor()
            r2 = r25
            com.github.mikephil.charting.interfaces.datasets.ICandleDataSet r2 = (com.github.mikephil.charting.interfaces.datasets.ICandleDataSet) r2
            int r15 = r2.getIncreasingColor()
            r0 = r32
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r9 = r0.computedEntries
            com.github.mikephil.charting.components.LegendEntry r2 = new com.github.mikephil.charting.components.LegendEntry
            r3 = 0
            com.github.mikephil.charting.components.Legend$LegendForm r4 = r25.getForm()
            float r5 = r25.getFormSize()
            float r6 = r25.getFormLineWidth()
            android.graphics.DashPathEffect r7 = r25.getFormLineDashEffect()
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r9.add(r2)
            r0 = r32
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r2 = r0.computedEntries
            com.github.mikephil.charting.components.LegendEntry r9 = new com.github.mikephil.charting.components.LegendEntry
            java.lang.String r10 = r25.getLabel()
            com.github.mikephil.charting.components.Legend$LegendForm r11 = r25.getForm()
            float r12 = r25.getFormSize()
            float r13 = r25.getFormLineWidth()
            android.graphics.DashPathEffect r14 = r25.getFormLineDashEffect()
            r9.<init>(r10, r11, r12, r13, r14, r15)
            r2.add(r9)
            goto L_0x00a9
        L_0x0185:
            r28 = 0
        L_0x0187:
            int r2 = r24.size()
            r0 = r28
            if (r0 >= r2) goto L_0x00a9
            r0 = r28
            r1 = r26
            if (r0 >= r1) goto L_0x00a9
            int r2 = r24.size()
            int r2 = r2 + -1
            r0 = r28
            if (r0 >= r2) goto L_0x01d6
            int r2 = r26 + -1
            r0 = r28
            if (r0 >= r2) goto L_0x01d6
            r17 = 0
        L_0x01a7:
            r0 = r32
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r3 = r0.computedEntries
            com.github.mikephil.charting.components.LegendEntry r16 = new com.github.mikephil.charting.components.LegendEntry
            com.github.mikephil.charting.components.Legend$LegendForm r18 = r25.getForm()
            float r19 = r25.getFormSize()
            float r20 = r25.getFormLineWidth()
            android.graphics.DashPathEffect r21 = r25.getFormLineDashEffect()
            r0 = r24
            r1 = r28
            java.lang.Object r2 = r0.get(r1)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r22 = r2.intValue()
            r16.<init>(r17, r18, r19, r20, r21, r22)
            r0 = r16
            r3.add(r0)
            int r28 = r28 + 1
            goto L_0x0187
        L_0x01d6:
            r0 = r33
            r1 = r27
            com.github.mikephil.charting.interfaces.datasets.IDataSet r2 = r0.getDataSetByIndex(r1)
            java.lang.String r17 = r2.getLabel()
            goto L_0x01a7
        L_0x01e3:
            r0 = r32
            com.github.mikephil.charting.components.Legend r2 = r0.mLegend
            com.github.mikephil.charting.components.LegendEntry[] r2 = r2.getExtraEntries()
            if (r2 == 0) goto L_0x01fc
            r0 = r32
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r2 = r0.computedEntries
            r0 = r32
            com.github.mikephil.charting.components.Legend r3 = r0.mLegend
            com.github.mikephil.charting.components.LegendEntry[] r3 = r3.getExtraEntries()
            java.util.Collections.addAll(r2, r3)
        L_0x01fc:
            r0 = r32
            com.github.mikephil.charting.components.Legend r2 = r0.mLegend
            r0 = r32
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r3 = r0.computedEntries
            r2.setEntries(r3)
        L_0x0207:
            r0 = r32
            com.github.mikephil.charting.components.Legend r2 = r0.mLegend
            android.graphics.Typeface r31 = r2.getTypeface()
            if (r31 == 0) goto L_0x021a
            r0 = r32
            android.graphics.Paint r2 = r0.mLegendLabelPaint
            r0 = r31
            r2.setTypeface(r0)
        L_0x021a:
            r0 = r32
            android.graphics.Paint r2 = r0.mLegendLabelPaint
            r0 = r32
            com.github.mikephil.charting.components.Legend r3 = r0.mLegend
            float r3 = r3.getTextSize()
            r2.setTextSize(r3)
            r0 = r32
            android.graphics.Paint r2 = r0.mLegendLabelPaint
            r0 = r32
            com.github.mikephil.charting.components.Legend r3 = r0.mLegend
            int r3 = r3.getTextColor()
            r2.setColor(r3)
            r0 = r32
            com.github.mikephil.charting.components.Legend r2 = r0.mLegend
            r0 = r32
            android.graphics.Paint r3 = r0.mLegendLabelPaint
            r0 = r32
            com.github.mikephil.charting.utils.ViewPortHandler r4 = r0.mViewPortHandler
            r2.calculateDimensions(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.LegendRenderer.computeLegend(com.github.mikephil.charting.data.ChartData):void");
    }

    public void renderLegend(Canvas c) {
        float originPosX;
        double d;
        float originPosX2;
        float posY;
        float posY2;
        float formSize;
        float f;
        float f2;
        float f3;
        if (this.mLegend.isEnabled()) {
            Typeface tf = this.mLegend.getTypeface();
            if (tf != null) {
                this.mLegendLabelPaint.setTypeface(tf);
            }
            this.mLegendLabelPaint.setTextSize(this.mLegend.getTextSize());
            this.mLegendLabelPaint.setColor(this.mLegend.getTextColor());
            float labelLineHeight = Utils.getLineHeight(this.mLegendLabelPaint, this.legendFontMetrics);
            float labelLineSpacing = Utils.getLineSpacing(this.mLegendLabelPaint, this.legendFontMetrics) + Utils.convertDpToPixel(this.mLegend.getYEntrySpace());
            float formYOffset = labelLineHeight - (((float) Utils.calcTextHeight(this.mLegendLabelPaint, "ABC")) / 2.0f);
            LegendEntry[] entries = this.mLegend.getEntries();
            float formToTextSpace = Utils.convertDpToPixel(this.mLegend.getFormToTextSpace());
            float xEntrySpace = Utils.convertDpToPixel(this.mLegend.getXEntrySpace());
            Legend.LegendOrientation orientation = this.mLegend.getOrientation();
            Legend.LegendHorizontalAlignment horizontalAlignment = this.mLegend.getHorizontalAlignment();
            Legend.LegendVerticalAlignment verticalAlignment = this.mLegend.getVerticalAlignment();
            Legend.LegendDirection direction = this.mLegend.getDirection();
            float defaultFormSize = Utils.convertDpToPixel(this.mLegend.getFormSize());
            float stackSpace = Utils.convertDpToPixel(this.mLegend.getStackSpace());
            float yoffset = this.mLegend.getYOffset();
            float xoffset = this.mLegend.getXOffset();
            float originPosX3 = 0.0f;
            switch (horizontalAlignment) {
                case LEFT:
                    if (orientation == Legend.LegendOrientation.VERTICAL) {
                        originPosX3 = xoffset;
                    } else {
                        originPosX3 = this.mViewPortHandler.contentLeft() + xoffset;
                    }
                    if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                        originPosX3 += this.mLegend.mNeededWidth;
                        break;
                    }
                    break;
                case RIGHT:
                    if (orientation == Legend.LegendOrientation.VERTICAL) {
                        originPosX2 = this.mViewPortHandler.getChartWidth() - xoffset;
                    } else {
                        originPosX2 = this.mViewPortHandler.contentRight() - xoffset;
                    }
                    if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                        originPosX3 -= this.mLegend.mNeededWidth;
                        break;
                    }
                    break;
                case CENTER:
                    if (orientation == Legend.LegendOrientation.VERTICAL) {
                        originPosX = this.mViewPortHandler.getChartWidth() / 2.0f;
                    } else {
                        originPosX = this.mViewPortHandler.contentLeft() + (this.mViewPortHandler.contentWidth() / 2.0f);
                    }
                    originPosX3 = originPosX + (direction == Legend.LegendDirection.LEFT_TO_RIGHT ? xoffset : -xoffset);
                    if (orientation == Legend.LegendOrientation.VERTICAL) {
                        double d2 = (double) originPosX3;
                        if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                            d = (((double) (-this.mLegend.mNeededWidth)) / 2.0d) + ((double) xoffset);
                        } else {
                            d = (((double) this.mLegend.mNeededWidth) / 2.0d) - ((double) xoffset);
                        }
                        originPosX3 = (float) (d + d2);
                        break;
                    }
                    break;
            }
            switch (orientation) {
                case HORIZONTAL:
                    List<FSize> calculatedLineSizes = this.mLegend.getCalculatedLineSizes();
                    List<FSize> calculatedLabelSizes = this.mLegend.getCalculatedLabelSizes();
                    List<Boolean> calculatedLabelBreakPoints = this.mLegend.getCalculatedLabelBreakPoints();
                    float posX = originPosX3;
                    float posY3 = 0.0f;
                    switch (verticalAlignment) {
                        case TOP:
                            posY3 = yoffset;
                            break;
                        case BOTTOM:
                            posY3 = (this.mViewPortHandler.getChartHeight() - yoffset) - this.mLegend.mNeededHeight;
                            break;
                        case CENTER:
                            posY3 = ((this.mViewPortHandler.getChartHeight() - this.mLegend.mNeededHeight) / 2.0f) + yoffset;
                            break;
                    }
                    int lineIndex = 0;
                    int count = entries.length;
                    for (int i = 0; i < count; i++) {
                        LegendEntry e = entries[i];
                        boolean drawingForm = e.form != Legend.LegendForm.NONE;
                        if (Float.isNaN(e.formSize)) {
                            formSize = defaultFormSize;
                        } else {
                            formSize = Utils.convertDpToPixel(e.formSize);
                        }
                        if (i < calculatedLabelBreakPoints.size() && calculatedLabelBreakPoints.get(i).booleanValue()) {
                            posX = originPosX3;
                            posY3 += labelLineHeight + labelLineSpacing;
                        }
                        if (posX == originPosX3 && horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER && lineIndex < calculatedLineSizes.size()) {
                            if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                                f3 = calculatedLineSizes.get(lineIndex).width;
                            } else {
                                f3 = -calculatedLineSizes.get(lineIndex).width;
                            }
                            posX += f3 / 2.0f;
                            lineIndex++;
                        }
                        boolean isStacked = e.label == null;
                        if (drawingForm) {
                            if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                                posX -= formSize;
                            }
                            drawForm(c, posX, posY3 + formYOffset, e, this.mLegend);
                            if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                                posX += formSize;
                            }
                        }
                        if (!isStacked) {
                            if (drawingForm) {
                                if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                                    f2 = -formToTextSpace;
                                } else {
                                    f2 = formToTextSpace;
                                }
                                posX += f2;
                            }
                            if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                                posX -= calculatedLabelSizes.get(i).width;
                            }
                            drawLabel(c, posX, posY3 + labelLineHeight, e.label);
                            if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                                posX += calculatedLabelSizes.get(i).width;
                            }
                            f = direction == Legend.LegendDirection.RIGHT_TO_LEFT ? -xEntrySpace : xEntrySpace;
                        } else {
                            f = direction == Legend.LegendDirection.RIGHT_TO_LEFT ? -stackSpace : stackSpace;
                        }
                        posX += f;
                    }
                    return;
                case VERTICAL:
                    float stack = 0.0f;
                    boolean wasStacked = false;
                    float posY4 = 0.0f;
                    switch (verticalAlignment) {
                        case TOP:
                            if (horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER) {
                                posY2 = 0.0f;
                            } else {
                                posY2 = this.mViewPortHandler.contentTop();
                            }
                            posY4 = posY2 + yoffset;
                            break;
                        case BOTTOM:
                            if (horizontalAlignment == Legend.LegendHorizontalAlignment.CENTER) {
                                posY = this.mViewPortHandler.getChartHeight();
                            } else {
                                posY = this.mViewPortHandler.contentBottom();
                            }
                            posY4 = posY - (this.mLegend.mNeededHeight + yoffset);
                            break;
                        case CENTER:
                            posY4 = ((this.mViewPortHandler.getChartHeight() / 2.0f) - (this.mLegend.mNeededHeight / 2.0f)) + this.mLegend.getYOffset();
                            break;
                    }
                    for (int i2 = 0; i2 < entries.length; i2++) {
                        LegendEntry e2 = entries[i2];
                        boolean drawingForm2 = e2.form != Legend.LegendForm.NONE;
                        float formSize2 = Float.isNaN(e2.formSize) ? defaultFormSize : Utils.convertDpToPixel(e2.formSize);
                        float posX2 = originPosX3;
                        if (drawingForm2) {
                            if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                                posX2 += stack;
                            } else {
                                posX2 -= formSize2 - stack;
                            }
                            drawForm(c, posX2, posY4 + formYOffset, e2, this.mLegend);
                            if (direction == Legend.LegendDirection.LEFT_TO_RIGHT) {
                                posX2 += formSize2;
                            }
                        }
                        if (e2.label != null) {
                            if (drawingForm2 && !wasStacked) {
                                posX2 += direction == Legend.LegendDirection.LEFT_TO_RIGHT ? formToTextSpace : -formToTextSpace;
                            } else if (wasStacked) {
                                posX2 = originPosX3;
                            }
                            if (direction == Legend.LegendDirection.RIGHT_TO_LEFT) {
                                posX2 -= (float) Utils.calcTextWidth(this.mLegendLabelPaint, e2.label);
                            }
                            if (!wasStacked) {
                                drawLabel(c, posX2, posY4 + labelLineHeight, e2.label);
                            } else {
                                posY4 += labelLineHeight + labelLineSpacing;
                                drawLabel(c, posX2, posY4 + labelLineHeight, e2.label);
                            }
                            posY4 += labelLineHeight + labelLineSpacing;
                            stack = 0.0f;
                        } else {
                            stack += formSize2 + stackSpace;
                            wasStacked = true;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawForm(Canvas c, float x, float y, LegendEntry entry, Legend legend) {
        float f;
        DashPathEffect formLineDashEffect;
        if (entry.formColor != 1122868 && entry.formColor != 1122867 && entry.formColor != 0) {
            int restoreCount = c.save();
            Legend.LegendForm form = entry.form;
            if (form == Legend.LegendForm.DEFAULT) {
                form = legend.getForm();
            }
            this.mLegendFormPaint.setColor(entry.formColor);
            if (Float.isNaN(entry.formSize)) {
                f = legend.getFormSize();
            } else {
                f = entry.formSize;
            }
            float formSize = Utils.convertDpToPixel(f);
            float half = formSize / 2.0f;
            switch (form) {
                case DEFAULT:
                case CIRCLE:
                    this.mLegendFormPaint.setStyle(Paint.Style.FILL);
                    c.drawCircle(x + half, y, half, this.mLegendFormPaint);
                    break;
                case SQUARE:
                    this.mLegendFormPaint.setStyle(Paint.Style.FILL);
                    c.drawRect(x, y - half, x + formSize, y + half, this.mLegendFormPaint);
                    break;
                case LINE:
                    float formLineWidth = Utils.convertDpToPixel(Float.isNaN(entry.formLineWidth) ? legend.getFormLineWidth() : entry.formLineWidth);
                    if (entry.formLineDashEffect == null) {
                        formLineDashEffect = legend.getFormLineDashEffect();
                    } else {
                        formLineDashEffect = entry.formLineDashEffect;
                    }
                    this.mLegendFormPaint.setStyle(Paint.Style.STROKE);
                    this.mLegendFormPaint.setStrokeWidth(formLineWidth);
                    this.mLegendFormPaint.setPathEffect(formLineDashEffect);
                    this.mLineFormPath.reset();
                    this.mLineFormPath.moveTo(x, y);
                    this.mLineFormPath.lineTo(x + formSize, y);
                    c.drawPath(this.mLineFormPath, this.mLegendFormPaint);
                    break;
            }
            c.restoreToCount(restoreCount);
        }
    }

    /* access modifiers changed from: protected */
    public void drawLabel(Canvas c, float x, float y, String label) {
        c.drawText(label, x, y, this.mLegendLabelPaint);
    }
}
