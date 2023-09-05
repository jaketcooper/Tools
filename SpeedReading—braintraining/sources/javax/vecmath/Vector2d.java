package javax.vecmath;

import java.io.Serializable;

public class Vector2d extends Tuple2d implements Serializable {
    static final long serialVersionUID = 8572646365302599857L;

    public Vector2d(double x, double y) {
        super(x, y);
    }

    public Vector2d(double[] v) {
        super(v);
    }

    public Vector2d(Vector2d v1) {
        super((Tuple2d) v1);
    }

    public Vector2d(Vector2f v1) {
        super((Tuple2f) v1);
    }

    public Vector2d(Tuple2d t1) {
        super(t1);
    }

    public Vector2d(Tuple2f t1) {
        super(t1);
    }

    public Vector2d() {
    }

    public final double dot(Vector2d v1) {
        return (this.f146x * v1.f146x) + (this.f147y * v1.f147y);
    }

    public final double length() {
        return Math.sqrt((this.f146x * this.f146x) + (this.f147y * this.f147y));
    }

    public final double lengthSquared() {
        return (this.f146x * this.f146x) + (this.f147y * this.f147y);
    }

    public final void normalize(Vector2d v1) {
        double norm = 1.0d / Math.sqrt((v1.f146x * v1.f146x) + (v1.f147y * v1.f147y));
        this.f146x = v1.f146x * norm;
        this.f147y = v1.f147y * norm;
    }

    public final void normalize() {
        double norm = 1.0d / Math.sqrt((this.f146x * this.f146x) + (this.f147y * this.f147y));
        this.f146x *= norm;
        this.f147y *= norm;
    }

    public final double angle(Vector2d v1) {
        double vDot = dot(v1) / (length() * v1.length());
        if (vDot < -1.0d) {
            vDot = -1.0d;
        }
        if (vDot > 1.0d) {
            vDot = 1.0d;
        }
        return Math.acos(vDot);
    }
}
