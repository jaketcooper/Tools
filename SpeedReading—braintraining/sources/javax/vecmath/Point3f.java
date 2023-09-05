package javax.vecmath;

import java.io.Serializable;

public class Point3f extends Tuple3f implements Serializable {
    static final long serialVersionUID = -8689337816398030143L;

    public Point3f(float x, float y, float z) {
        super(x, y, z);
    }

    public Point3f(float[] p) {
        super(p);
    }

    public Point3f(Point3f p1) {
        super((Tuple3f) p1);
    }

    public Point3f(Point3d p1) {
        super((Tuple3d) p1);
    }

    public Point3f(Tuple3f t1) {
        super(t1);
    }

    public Point3f(Tuple3d t1) {
        super(t1);
    }

    public Point3f() {
    }

    public final float distanceSquared(Point3f p1) {
        float dx = this.f158x - p1.f158x;
        float dy = this.f159y - p1.f159y;
        float dz = this.f160z - p1.f160z;
        return (dx * dx) + (dy * dy) + (dz * dz);
    }

    public final float distance(Point3f p1) {
        float dx = this.f158x - p1.f158x;
        float dy = this.f159y - p1.f159y;
        float dz = this.f160z - p1.f160z;
        return (float) Math.sqrt((double) ((dx * dx) + (dy * dy) + (dz * dz)));
    }

    public final float distanceL1(Point3f p1) {
        return Math.abs(this.f158x - p1.f158x) + Math.abs(this.f159y - p1.f159y) + Math.abs(this.f160z - p1.f160z);
    }

    public final float distanceLinf(Point3f p1) {
        return Math.max(Math.max(Math.abs(this.f158x - p1.f158x), Math.abs(this.f159y - p1.f159y)), Math.abs(this.f160z - p1.f160z));
    }

    public final void project(Point4f p1) {
        float oneOw = 1.0f / p1.f172w;
        this.f158x = p1.f173x * oneOw;
        this.f159y = p1.f174y * oneOw;
        this.f160z = p1.f175z * oneOw;
    }
}
