package javax.vecmath;

import java.io.Serializable;

public class Point3d extends Tuple3d implements Serializable {
    static final long serialVersionUID = 5718062286069042927L;

    public Point3d(double x, double y, double z) {
        super(x, y, z);
    }

    public Point3d(double[] p) {
        super(p);
    }

    public Point3d(Point3d p1) {
        super((Tuple3d) p1);
    }

    public Point3d(Point3f p1) {
        super((Tuple3f) p1);
    }

    public Point3d(Tuple3f t1) {
        super(t1);
    }

    public Point3d(Tuple3d t1) {
        super(t1);
    }

    public Point3d() {
    }

    public final double distanceSquared(Point3d p1) {
        double dx = this.f155x - p1.f155x;
        double dy = this.f156y - p1.f156y;
        double dz = this.f157z - p1.f157z;
        return (dx * dx) + (dy * dy) + (dz * dz);
    }

    public final double distance(Point3d p1) {
        double dx = this.f155x - p1.f155x;
        double dy = this.f156y - p1.f156y;
        double dz = this.f157z - p1.f157z;
        return Math.sqrt((dx * dx) + (dy * dy) + (dz * dz));
    }

    public final double distanceL1(Point3d p1) {
        return Math.abs(this.f155x - p1.f155x) + Math.abs(this.f156y - p1.f156y) + Math.abs(this.f157z - p1.f157z);
    }

    public final double distanceLinf(Point3d p1) {
        return Math.max(Math.max(Math.abs(this.f155x - p1.f155x), Math.abs(this.f156y - p1.f156y)), Math.abs(this.f157z - p1.f157z));
    }

    public final void project(Point4d p1) {
        double oneOw = 1.0d / p1.f168w;
        this.f155x = p1.f169x * oneOw;
        this.f156y = p1.f170y * oneOw;
        this.f157z = p1.f171z * oneOw;
    }
}
