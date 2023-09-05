package p006io.realm;

/* renamed from: io.realm.Case */
public enum Case {
    SENSITIVE(true),
    INSENSITIVE(false);
    
    private final boolean value;

    private Case(boolean value2) {
        this.value = value2;
    }

    public boolean getValue() {
        return this.value;
    }
}
