package javax.vecmath;

import java.io.Serializable;

public class Point4f extends Tuple4f implements Serializable {
    static final long serialVersionUID = 4643134103185764459L;

    public Point4f(float x, float y, float z, float w) {
        super(x, y, z, w);
    }

    public Point4f(float[] p) {
        super(p);
    }

    public Point4f(Point4f p1) {
        super((Tuple4f) p1);
    }

    public Point4f(Point4d p1) {
        super((Tuple4d) p1);
    }

    public Point4f(Tuple4f t1) {
        super(t1);
    }

    public Point4f(Tuple4d t1) {
        super(t1);
    }

    public Point4f(Tuple3f t1) {
        super(t1.f158x, t1.f159y, t1.f160z, 1.0f);
    }

    public Point4f() {
    }

    public final void set(Tuple3f t1) {
        this.f173x = t1.f158x;
        this.f174y = t1.f159y;
        this.f175z = t1.f160z;
        this.f172w = 1.0f;
    }

    public final float distanceSquared(Point4f p1) {
        float dx = this.f173x - p1.f173x;
        float dy = this.f174y - p1.f174y;
        float dz = this.f175z - p1.f175z;
        float dw = this.f172w - p1.f172w;
        return (dx * dx) + (dy * dy) + (dz * dz) + (dw * dw);
    }

    public final float distance(Point4f p1) {
        float dx = this.f173x - p1.f173x;
        float dy = this.f174y - p1.f174y;
        float dz = this.f175z - p1.f175z;
        float dw = this.f172w - p1.f172w;
        return (float) Math.sqrt((double) ((dx * dx) + (dy * dy) + (dz * dz) + (dw * dw)));
    }

    public final float distanceL1(Point4f p1) {
        return Math.abs(this.f173x - p1.f173x) + Math.abs(this.f174y - p1.f174y) + Math.abs(this.f175z - p1.f175z) + Math.abs(this.f172w - p1.f172w);
    }

    public final float distanceLinf(Point4f p1) {
        return Math.max(Math.max(Math.abs(this.f173x - p1.f173x), Math.abs(this.f174y - p1.f174y)), Math.max(Math.abs(this.f175z - p1.f175z), Math.abs(this.f172w - p1.f172w)));
    }

    public final void project(Point4f p1) {
        float oneOw = 1.0f / p1.f172w;
        this.f173x = p1.f173x * oneOw;
        this.f174y = p1.f174y * oneOw;
        this.f175z = p1.f175z * oneOw;
        this.f172w = 1.0f;
    }
}
