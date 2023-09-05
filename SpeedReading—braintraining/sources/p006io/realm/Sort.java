package p006io.realm;

/* renamed from: io.realm.Sort */
public enum Sort {
    ASCENDING(true),
    DESCENDING(false);
    
    private final boolean value;

    private Sort(boolean value2) {
        this.value = value2;
    }

    public boolean getValue() {
        return this.value;
    }
}
