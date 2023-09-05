package org.mozilla.universalchardet.prober.statemachine;

public abstract class SMModel {
    public static final int ERROR = 1;
    public static final int ITSME = 2;
    public static final int START = 0;
    protected int[] charLenTable;
    protected int classFactor;
    protected PkgInt classTable;
    protected String name;
    protected PkgInt stateTable;

    public SMModel(PkgInt classTable2, int classFactor2, PkgInt stateTable2, int[] charLenTable2, String name2) {
        this.classTable = classTable2;
        this.classFactor = classFactor2;
        this.stateTable = stateTable2;
        this.charLenTable = charLenTable2;
        this.name = name2;
    }

    public int getClass(byte b) {
        return this.classTable.unpack(b & 255);
    }

    public int getNextState(int cls, int currentState) {
        return this.stateTable.unpack((this.classFactor * currentState) + cls);
    }

    public int getCharLen(int cls) {
        return this.charLenTable[cls];
    }

    public String getName() {
        return this.name;
    }
}
