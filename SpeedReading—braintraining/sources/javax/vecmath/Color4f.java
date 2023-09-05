package javax.vecmath;

import java.awt.Color;
import java.io.Serializable;

public class Color4f extends Tuple4f implements Serializable {
    static final long serialVersionUID = 8577680141580006740L;

    public Color4f(float x, float y, float z, float w) {
        super(x, y, z, w);
    }

    public Color4f(float[] c) {
        super(c);
    }

    public Color4f(Color4f c1) {
        super((Tuple4f) c1);
    }

    public Color4f(Tuple4f t1) {
        super(t1);
    }

    public Color4f(Tuple4d t1) {
        super(t1);
    }

    public Color4f(Color color) {
        super(((float) color.getRed()) / 255.0f, ((float) color.getGreen()) / 255.0f, ((float) color.getBlue()) / 255.0f, ((float) color.getAlpha()) / 255.0f);
    }

    public Color4f() {
    }

    public final void set(Color color) {
        this.f173x = ((float) color.getRed()) / 255.0f;
        this.f174y = ((float) color.getGreen()) / 255.0f;
        this.f175z = ((float) color.getBlue()) / 255.0f;
        this.f172w = ((float) color.getAlpha()) / 255.0f;
    }

    public final Color get() {
        return new Color(Math.round(this.f173x * 255.0f), Math.round(this.f174y * 255.0f), Math.round(this.f175z * 255.0f), Math.round(this.f172w * 255.0f));
    }
}
