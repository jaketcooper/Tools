package org.mozilla.universalchardet.prober;

import java.nio.ByteBuffer;
import org.mozilla.universalchardet.prober.CharsetProber;
import org.mozilla.universalchardet.prober.sequence.HebrewModel;
import org.mozilla.universalchardet.prober.sequence.Ibm855Model;
import org.mozilla.universalchardet.prober.sequence.Ibm866Model;
import org.mozilla.universalchardet.prober.sequence.Koi8rModel;
import org.mozilla.universalchardet.prober.sequence.Latin5BulgarianModel;
import org.mozilla.universalchardet.prober.sequence.Latin5Model;
import org.mozilla.universalchardet.prober.sequence.Latin7Model;
import org.mozilla.universalchardet.prober.sequence.MacCyrillicModel;
import org.mozilla.universalchardet.prober.sequence.SequenceModel;
import org.mozilla.universalchardet.prober.sequence.Win1251BulgarianModel;
import org.mozilla.universalchardet.prober.sequence.Win1251Model;
import org.mozilla.universalchardet.prober.sequence.Win1253Model;

public class SBCSGroupProber extends CharsetProber {
    private static final SequenceModel hebrewModel = new HebrewModel();
    private static final SequenceModel ibm855Model = new Ibm855Model();
    private static final SequenceModel ibm866Model = new Ibm866Model();
    private static final SequenceModel koi8rModel = new Koi8rModel();
    private static final SequenceModel latin5BulgarianModel = new Latin5BulgarianModel();
    private static final SequenceModel latin5Model = new Latin5Model();
    private static final SequenceModel latin7Model = new Latin7Model();
    private static final SequenceModel macCyrillicModel = new MacCyrillicModel();
    private static final SequenceModel win1251BulgarianModel = new Win1251BulgarianModel();
    private static final SequenceModel win1251Model = new Win1251Model();
    private static final SequenceModel win1253Model = new Win1253Model();
    private int activeNum;
    private int bestGuess;
    private boolean[] isActive = new boolean[13];
    private CharsetProber[] probers = new CharsetProber[13];
    private CharsetProber.ProbingState state;

    public SBCSGroupProber() {
        this.probers[0] = new SingleByteCharsetProber(win1251Model);
        this.probers[1] = new SingleByteCharsetProber(koi8rModel);
        this.probers[2] = new SingleByteCharsetProber(latin5Model);
        this.probers[3] = new SingleByteCharsetProber(macCyrillicModel);
        this.probers[4] = new SingleByteCharsetProber(ibm866Model);
        this.probers[5] = new SingleByteCharsetProber(ibm855Model);
        this.probers[6] = new SingleByteCharsetProber(latin7Model);
        this.probers[7] = new SingleByteCharsetProber(win1253Model);
        this.probers[8] = new SingleByteCharsetProber(latin5BulgarianModel);
        this.probers[9] = new SingleByteCharsetProber(win1251BulgarianModel);
        HebrewProber hebprober = new HebrewProber();
        this.probers[10] = hebprober;
        this.probers[11] = new SingleByteCharsetProber(hebrewModel, false, hebprober);
        this.probers[12] = new SingleByteCharsetProber(hebrewModel, true, hebprober);
        hebprober.setModalProbers(this.probers[11], this.probers[12]);
        reset();
    }

    public String getCharSetName() {
        if (this.bestGuess == -1) {
            getConfidence();
            if (this.bestGuess == -1) {
                this.bestGuess = 0;
            }
        }
        return this.probers[this.bestGuess].getCharSetName();
    }

    public float getConfidence() {
        float bestConf = 0.0f;
        if (this.state == CharsetProber.ProbingState.FOUND_IT) {
            return 0.99f;
        }
        if (this.state == CharsetProber.ProbingState.NOT_ME) {
            return 0.01f;
        }
        for (int i = 0; i < this.probers.length; i++) {
            if (this.isActive[i]) {
                float cf = this.probers[i].getConfidence();
                if (bestConf < cf) {
                    bestConf = cf;
                    this.bestGuess = i;
                }
            }
        }
        return bestConf;
    }

    public CharsetProber.ProbingState getState() {
        return this.state;
    }

    public CharsetProber.ProbingState handleData(byte[] buf, int offset, int length) {
        ByteBuffer newbuf = filterWithoutEnglishLetters(buf, offset, length);
        if (newbuf.position() != 0) {
            int i = 0;
            while (true) {
                if (i >= this.probers.length) {
                    break;
                }
                if (this.isActive[i]) {
                    CharsetProber.ProbingState st = this.probers[i].handleData(newbuf.array(), 0, newbuf.position());
                    if (st == CharsetProber.ProbingState.FOUND_IT) {
                        this.bestGuess = i;
                        this.state = CharsetProber.ProbingState.FOUND_IT;
                        break;
                    } else if (st == CharsetProber.ProbingState.NOT_ME) {
                        this.isActive[i] = false;
                        this.activeNum--;
                        if (this.activeNum <= 0) {
                            this.state = CharsetProber.ProbingState.NOT_ME;
                            break;
                        }
                    } else {
                        continue;
                    }
                }
                i++;
            }
        }
        return this.state;
    }

    public void reset() {
        this.activeNum = 0;
        for (int i = 0; i < this.probers.length; i++) {
            this.probers[i].reset();
            this.isActive[i] = true;
            this.activeNum++;
        }
        this.bestGuess = -1;
        this.state = CharsetProber.ProbingState.DETECTING;
    }

    public void setOption() {
    }
}
