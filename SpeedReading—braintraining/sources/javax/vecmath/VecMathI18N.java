package javax.vecmath;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

class VecMathI18N {
    VecMathI18N() {
    }

    static String getString(String key) {
        try {
            return ResourceBundle.getBundle("javax.vecmath.ExceptionStrings").getString(key);
        } catch (MissingResourceException e) {
            System.err.println("VecMathI18N: Error looking up: " + key);
            return key;
        }
    }
}
