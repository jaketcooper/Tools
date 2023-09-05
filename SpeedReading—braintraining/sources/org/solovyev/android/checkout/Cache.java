package org.solovyev.android.checkout;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface Cache {
    void clear();

    @Nullable
    Entry get(@Nonnull Key key);

    void init();

    void put(@Nonnull Key key, @Nonnull Entry entry);

    void remove(@Nonnull Key key);

    void removeAll(int i);

    public static final class Key {
        @Nonnull
        public final String key;
        public final int type;

        Key(int type2, @Nonnull String key2) {
            this.type = type2;
            this.key = key2;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Key)) {
                return false;
            }
            Key that = (Key) o;
            if (this.type != that.type) {
                return false;
            }
            if (!this.key.equals(that.key)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.type * 31) + this.key.hashCode();
        }

        public String toString() {
            return RequestType.getCacheKeyName(this.type) + "_" + this.key;
        }
    }

    public static final class Entry {
        @Nonnull
        public final Object data;
        public final long expiresAt;

        Entry(@Nonnull Object data2, long expiresAt2) {
            this.data = data2;
            this.expiresAt = expiresAt2;
        }
    }
}
