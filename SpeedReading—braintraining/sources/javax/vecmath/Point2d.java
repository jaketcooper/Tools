package javax.vecmath;

import java.io.Serializable;

public class Point2d extends Tuple2d implements Serializable {
    static final long serialVersionUID = 1133748791492571954L;

    public Point2d(double x, double y) {
        super(x, y);
    }

    public Point2d(double[] p) {
        super(p);
    }

    public Point2d(Point2d p1) {
        super((Tuple2d) p1);
    }

    public Point2d(Point2f p1) {
        super((Tuple2f) p1);
    }

    public Point2d(Tuple2d t1) {
        super(t1);
    }

    public Point2d(Tuple2f t1) {
        super(t1);
    }

    public Point2d() {
    }

    public final double distanceSquared(Point2d p1) {
        double dx = this.f146x - p1.f146x;
        double dy = this.f147y - p1.f147y;
        return (dx * dx) + (dy * dy);
    }

    public final double distance(Point2d p1) {
        double dx = this.f146x - p1.f146x;
        double dy = this.f147y - p1.f147y;
        return Math.sqrt((dx * dx) + (dy * dy));
    }

    public final double distanceL1(Point2d p1) {
        return Math.abs(this.f146x - p1.f146x) + Math.abs(this.f147y - p1.f147y);
    }

    public final double distanceLinf(Point2d p1) {
        return Math.max(Math.abs(this.f146x - p1.f146x), Math.abs(this.f147y - p1.f147y));
    }
}
