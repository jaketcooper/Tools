package javax.vecmath;

import java.io.Serializable;

public class Point2f extends Tuple2f implements Serializable {
    static final long serialVersionUID = -4801347926528714435L;

    public Point2f(float x, float y) {
        super(x, y);
    }

    public Point2f(float[] p) {
        super(p);
    }

    public Point2f(Point2f p1) {
        super((Tuple2f) p1);
    }

    public Point2f(Point2d p1) {
        super((Tuple2d) p1);
    }

    public Point2f(Tuple2d t1) {
        super(t1);
    }

    public Point2f(Tuple2f t1) {
        super(t1);
    }

    public Point2f() {
    }

    public final float distanceSquared(Point2f p1) {
        float dx = this.f148x - p1.f148x;
        float dy = this.f149y - p1.f149y;
        return (dx * dx) + (dy * dy);
    }

    public final float distance(Point2f p1) {
        float dx = this.f148x - p1.f148x;
        float dy = this.f149y - p1.f149y;
        return (float) Math.sqrt((double) ((dx * dx) + (dy * dy)));
    }

    public final float distanceL1(Point2f p1) {
        return Math.abs(this.f148x - p1.f148x) + Math.abs(this.f149y - p1.f149y);
    }

    public final float distanceLinf(Point2f p1) {
        return Math.max(Math.abs(this.f148x - p1.f148x), Math.abs(this.f149y - p1.f149y));
    }
}
