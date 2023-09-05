package javax.vecmath;

import java.awt.Color;
import java.io.Serializable;

public class Color3b extends Tuple3b implements Serializable {
    static final long serialVersionUID = 6632576088353444794L;

    public Color3b(byte c1, byte c2, byte c3) {
        super(c1, c2, c3);
    }

    public Color3b(byte[] c) {
        super(c);
    }

    public Color3b(Color3b c1) {
        super((Tuple3b) c1);
    }

    public Color3b(Tuple3b t1) {
        super(t1);
    }

    public Color3b(Color color) {
        super((byte) color.getRed(), (byte) color.getGreen(), (byte) color.getBlue());
    }

    public Color3b() {
    }

    public final void set(Color color) {
        this.f152x = (byte) color.getRed();
        this.f153y = (byte) color.getGreen();
        this.f154z = (byte) color.getBlue();
    }

    public final Color get() {
        return new Color(this.f152x & 255, this.f153y & 255, this.f154z & 255);
    }
}
