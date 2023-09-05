package javax.vecmath;

import java.awt.Color;
import java.io.Serializable;

public class Color4b extends Tuple4b implements Serializable {
    static final long serialVersionUID = -105080578052502155L;

    public Color4b(byte b1, byte b2, byte b3, byte b4) {
        super(b1, b2, b3, b4);
    }

    public Color4b(byte[] c) {
        super(c);
    }

    public Color4b(Color4b c1) {
        super((Tuple4b) c1);
    }

    public Color4b(Tuple4b t1) {
        super(t1);
    }

    public Color4b(Color color) {
        super((byte) color.getRed(), (byte) color.getGreen(), (byte) color.getBlue(), (byte) color.getAlpha());
    }

    public Color4b() {
    }

    public final void set(Color color) {
        this.f165x = (byte) color.getRed();
        this.f166y = (byte) color.getGreen();
        this.f167z = (byte) color.getBlue();
        this.f164w = (byte) color.getAlpha();
    }

    public final Color get() {
        return new Color(this.f165x & 255, this.f166y & 255, this.f167z & 255, this.f164w & 255);
    }
}
