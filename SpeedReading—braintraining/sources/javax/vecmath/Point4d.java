package javax.vecmath;

import java.io.Serializable;

public class Point4d extends Tuple4d implements Serializable {
    static final long serialVersionUID = 1733471895962736949L;

    public Point4d(double x, double y, double z, double w) {
        super(x, y, z, w);
    }

    public Point4d(double[] p) {
        super(p);
    }

    public Point4d(Point4d p1) {
        super((Tuple4d) p1);
    }

    public Point4d(Point4f p1) {
        super((Tuple4f) p1);
    }

    public Point4d(Tuple4f t1) {
        super(t1);
    }

    public Point4d(Tuple4d t1) {
        super(t1);
    }

    public Point4d(Tuple3d t1) {
        super(t1.f155x, t1.f156y, t1.f157z, 1.0d);
    }

    public Point4d() {
    }

    public final void set(Tuple3d t1) {
        this.f169x = t1.f155x;
        this.f170y = t1.f156y;
        this.f171z = t1.f157z;
        this.f168w = 1.0d;
    }

    public final double distanceSquared(Point4d p1) {
        double dx = this.f169x - p1.f169x;
        double dy = this.f170y - p1.f170y;
        double dz = this.f171z - p1.f171z;
        double dw = this.f168w - p1.f168w;
        return (dx * dx) + (dy * dy) + (dz * dz) + (dw * dw);
    }

    public final double distance(Point4d p1) {
        double dx = this.f169x - p1.f169x;
        double dy = this.f170y - p1.f170y;
        double dz = this.f171z - p1.f171z;
        double dw = this.f168w - p1.f168w;
        return Math.sqrt((dx * dx) + (dy * dy) + (dz * dz) + (dw * dw));
    }

    public final double distanceL1(Point4d p1) {
        return Math.abs(this.f169x - p1.f169x) + Math.abs(this.f170y - p1.f170y) + Math.abs(this.f171z - p1.f171z) + Math.abs(this.f168w - p1.f168w);
    }

    public final double distanceLinf(Point4d p1) {
        return Math.max(Math.max(Math.abs(this.f169x - p1.f169x), Math.abs(this.f170y - p1.f170y)), Math.max(Math.abs(this.f171z - p1.f171z), Math.abs(this.f168w - p1.f168w)));
    }

    public final void project(Point4d p1) {
        double oneOw = 1.0d / p1.f168w;
        this.f169x = p1.f169x * oneOw;
        this.f170y = p1.f170y * oneOw;
        this.f171z = p1.f171z * oneOw;
        this.f168w = 1.0d;
    }
}
