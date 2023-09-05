package org.mozilla.universalchardet;

import java.io.FileInputStream;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.EscCharsetProber;
import org.mozilla.universalchardet.prober.Latin1Prober;
import org.mozilla.universalchardet.prober.MBCSGroupProber;
import org.mozilla.universalchardet.prober.SBCSGroupProber;

public class UniversalDetector {
    public static final float MINIMUM_THRESHOLD = 0.2f;
    public static final float SHORTCUT_THRESHOLD = 0.95f;
    private String detectedCharset;
    private boolean done;
    private CharsetProber escCharsetProber = null;
    private boolean gotData;
    private InputState inputState;
    private byte lastChar;
    private CharsetListener listener;
    private CharsetProber[] probers = new CharsetProber[3];
    private boolean start;

    public enum InputState {
        PURE_ASCII,
        ESC_ASCII,
        HIGHBYTE
    }

    public UniversalDetector(CharsetListener listener2) {
        this.listener = listener2;
        for (int i = 0; i < this.probers.length; i++) {
            this.probers[i] = null;
        }
        reset();
    }

    public boolean isDone() {
        return this.done;
    }

    public String getDetectedCharset() {
        return this.detectedCharset;
    }

    public void setListener(CharsetListener listener2) {
        this.listener = listener2;
    }

    public CharsetListener getListener() {
        return this.listener;
    }

    public void handleData(byte[] buf, int offset, int length) {
        if (!this.done) {
            if (length > 0) {
                this.gotData = true;
            }
            if (this.start) {
                this.start = false;
                if (length > 3) {
                    int b1 = buf[offset] & 255;
                    int b2 = buf[offset + 1] & 255;
                    int b3 = buf[offset + 2] & 255;
                    int b4 = buf[offset + 3] & 255;
                    switch (b1) {
                        case 0:
                            if (b2 != 0 || b3 != 254 || b4 != 255) {
                                if (b2 == 0 && b3 == 255 && b4 == 254) {
                                    this.detectedCharset = Constants.CHARSET_X_ISO_10646_UCS_4_2143;
                                    break;
                                }
                            } else {
                                this.detectedCharset = Constants.CHARSET_UTF_32BE;
                                break;
                            }
                            break;
                        case 239:
                            if (b2 == 187 && b3 == 191) {
                                this.detectedCharset = Constants.CHARSET_UTF_8;
                                break;
                            }
                        case 254:
                            if (b2 != 255 || b3 != 0 || b4 != 0) {
                                if (b2 == 255) {
                                    this.detectedCharset = Constants.CHARSET_UTF_16BE;
                                    break;
                                }
                            } else {
                                this.detectedCharset = Constants.CHARSET_X_ISO_10646_UCS_4_3412;
                                break;
                            }
                            break;
                        case 255:
                            if (b2 != 254 || b3 != 0 || b4 != 0) {
                                if (b2 == 254) {
                                    this.detectedCharset = Constants.CHARSET_UTF_16LE;
                                    break;
                                }
                            } else {
                                this.detectedCharset = Constants.CHARSET_UTF_32LE;
                                break;
                            }
                            break;
                    }
                    if (this.detectedCharset != null) {
                        this.done = true;
                        return;
                    }
                }
            }
            int maxPos = offset + length;
            for (int i = offset; i < maxPos; i++) {
                int c = buf[i] & 255;
                if ((c & 128) == 0 || c == 160) {
                    if (this.inputState == InputState.PURE_ASCII && (c == 27 || (c == 123 && this.lastChar == 126))) {
                        this.inputState = InputState.ESC_ASCII;
                    }
                    this.lastChar = buf[i];
                } else if (this.inputState != InputState.HIGHBYTE) {
                    this.inputState = InputState.HIGHBYTE;
                    if (this.escCharsetProber != null) {
                        this.escCharsetProber = null;
                    }
                    if (this.probers[0] == null) {
                        this.probers[0] = new MBCSGroupProber();
                    }
                    if (this.probers[1] == null) {
                        this.probers[1] = new SBCSGroupProber();
                    }
                    if (this.probers[2] == null) {
                        this.probers[2] = new Latin1Prober();
                    }
                }
            }
            if (this.inputState == InputState.ESC_ASCII) {
                if (this.escCharsetProber == null) {
                    this.escCharsetProber = new EscCharsetProber();
                }
                if (this.escCharsetProber.handleData(buf, offset, length) == CharsetProber.ProbingState.FOUND_IT) {
                    this.done = true;
                    this.detectedCharset = this.escCharsetProber.getCharSetName();
                }
            } else if (this.inputState == InputState.HIGHBYTE) {
                for (int i2 = 0; i2 < this.probers.length; i2++) {
                    if (this.probers[i2].handleData(buf, offset, length) == CharsetProber.ProbingState.FOUND_IT) {
                        this.done = true;
                        this.detectedCharset = this.probers[i2].getCharSetName();
                        return;
                    }
                }
            }
        }
    }

    public void dataEnd() {
        if (this.gotData) {
            if (this.detectedCharset != null) {
                this.done = true;
                if (this.listener != null) {
                    this.listener.report(this.detectedCharset);
                }
            } else if (this.inputState == InputState.HIGHBYTE) {
                float maxProberConfidence = 0.0f;
                int maxProber = 0;
                for (int i = 0; i < this.probers.length; i++) {
                    float proberConfidence = this.probers[i].getConfidence();
                    if (proberConfidence > maxProberConfidence) {
                        maxProberConfidence = proberConfidence;
                        maxProber = i;
                    }
                }
                if (maxProberConfidence > 0.2f) {
                    this.detectedCharset = this.probers[maxProber].getCharSetName();
                    if (this.listener != null) {
                        this.listener.report(this.detectedCharset);
                    }
                }
            } else {
                if (this.inputState == InputState.ESC_ASCII) {
                }
            }
        }
    }

    public void reset() {
        this.done = false;
        this.start = true;
        this.detectedCharset = null;
        this.gotData = false;
        this.inputState = InputState.PURE_ASCII;
        this.lastChar = 0;
        if (this.escCharsetProber != null) {
            this.escCharsetProber.reset();
        }
        for (int i = 0; i < this.probers.length; i++) {
            if (this.probers[i] != null) {
                this.probers[i].reset();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("USAGE: java UniversalDetector filename");
            return;
        }
        UniversalDetector detector = new UniversalDetector(new CharsetListener() {
            public void report(String name) {
                System.out.println("charset = " + name);
            }
        });
        byte[] buf = new byte[4096];
        FileInputStream fis = new FileInputStream(args[0]);
        while (true) {
            int nread = fis.read(buf);
            if (nread <= 0 || detector.isDone()) {
                detector.dataEnd();
            } else {
                detector.handleData(buf, 0, nread);
            }
        }
        detector.dataEnd();
    }
}
