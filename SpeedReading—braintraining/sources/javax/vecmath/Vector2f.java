package javax.vecmath;

import java.io.Serializable;

public class Vector2f extends Tuple2f implements Serializable {
    static final long serialVersionUID = -2168194326883512320L;

    public Vector2f(float x, float y) {
        super(x, y);
    }

    public Vector2f(float[] v) {
        super(v);
    }

    public Vector2f(Vector2f v1) {
        super((Tuple2f) v1);
    }

    public Vector2f(Vector2d v1) {
        super((Tuple2d) v1);
    }

    public Vector2f(Tuple2f t1) {
        super(t1);
    }

    public Vector2f(Tuple2d t1) {
        super(t1);
    }

    public Vector2f() {
    }

    public final float dot(Vector2f v1) {
        return (this.f148x * v1.f148x) + (this.f149y * v1.f149y);
    }

    public final float length() {
        return (float) Math.sqrt((double) ((this.f148x * this.f148x) + (this.f149y * this.f149y)));
    }

    public final float lengthSquared() {
        return (this.f148x * this.f148x) + (this.f149y * this.f149y);
    }

    public final void normalize(Vector2f v1) {
        float norm = (float) (1.0d / Math.sqrt((double) ((v1.f148x * v1.f148x) + (v1.f149y * v1.f149y))));
        this.f148x = v1.f148x * norm;
        this.f149y = v1.f149y * norm;
    }

    public final void normalize() {
        float norm = (float) (1.0d / Math.sqrt((double) ((this.f148x * this.f148x) + (this.f149y * this.f149y))));
        this.f148x *= norm;
        this.f149y *= norm;
    }

    public final float angle(Vector2f v1) {
        double vDot = (double) (dot(v1) / (length() * v1.length()));
        if (vDot < -1.0d) {
            vDot = -1.0d;
        }
        if (vDot > 1.0d) {
            vDot = 1.0d;
        }
        return (float) Math.acos(vDot);
    }
}
