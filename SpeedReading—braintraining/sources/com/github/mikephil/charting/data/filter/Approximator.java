package com.github.mikephil.charting.data.filter;

import android.annotation.TargetApi;
import java.util.Arrays;

public class Approximator {
    @TargetApi(9)
    public float[] reduceWithDouglasPeucker(float[] points, float tolerance) {
        int greatestIndex = 0;
        float greatestDistance = 0.0f;
        Line line = new Line(points[0], points[1], points[points.length - 2], points[points.length - 1]);
        for (int i = 2; i < points.length - 2; i += 2) {
            float distance = line.distance(points[i], points[i + 1]);
            if (distance > greatestDistance) {
                greatestDistance = distance;
                greatestIndex = i;
            }
        }
        if (greatestDistance <= tolerance) {
            return line.getPoints();
        }
        float[] reduced1 = reduceWithDouglasPeucker(Arrays.copyOfRange(points, 0, greatestIndex + 2), tolerance);
        float[] reduced2 = reduceWithDouglasPeucker(Arrays.copyOfRange(points, greatestIndex, points.length), tolerance);
        return concat(reduced1, Arrays.copyOfRange(reduced2, 2, reduced2.length));
    }

    /* access modifiers changed from: package-private */
    public float[] concat(float[]... arrays) {
        int length = 0;
        for (float[] array : arrays) {
            length += array.length;
        }
        float[] result = new float[length];
        int pos = 0;
        for (float[] array2 : arrays) {
            for (float element : arrays[r7]) {
                result[pos] = element;
                pos++;
            }
        }
        return result;
    }

    private class Line {

        /* renamed from: dx */
        private float f60dx;

        /* renamed from: dy */
        private float f61dy;
        private float exsy;
        private float length = ((float) Math.sqrt((double) ((this.f60dx * this.f60dx) + (this.f61dy * this.f61dy))));
        private float[] points;
        private float sxey;

        public Line(float x1, float y1, float x2, float y2) {
            this.f60dx = x1 - x2;
            this.f61dy = y1 - y2;
            this.sxey = x1 * y2;
            this.exsy = x2 * y1;
            this.points = new float[]{x1, y1, x2, y2};
        }

        public float distance(float x, float y) {
            return Math.abs((((this.f61dy * x) - (this.f60dx * y)) + this.sxey) - this.exsy) / this.length;
        }

        public float[] getPoints() {
            return this.points;
        }
    }
}
