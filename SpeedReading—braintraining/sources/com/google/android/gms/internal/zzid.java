package com.google.android.gms.internal;

import java.io.IOException;

public final class zzid {

    public static final class zza extends zzfem<zza, C1237zza> implements zzffs {
        /* access modifiers changed from: private */
        public static final zza zzbar;
        private static volatile zzffu<zza> zzbas;

        /* renamed from: com.google.android.gms.internal.zzid$zza$zza  reason: collision with other inner class name */
        public static final class C1237zza extends zzfen<zza, C1237zza> implements zzffs {
            private C1237zza() {
                super(zza.zzbar);
            }

            /* synthetic */ C1237zza(zzie zzie) {
                this();
            }
        }

        public enum zzb implements zzffa {
            UNKNOWN_EVENT_TYPE(0),
            AD_REQUEST(1),
            AD_LOADED(2),
            AD_FAILED_TO_LOAD(3),
            AD_FAILED_TO_LOAD_NO_FILL(4),
            AD_IMPRESSION(5),
            AD_FIRST_CLICK(6),
            AD_SUBSEQUENT_CLICK(7);
            
            private static final zzffb<zzb> zzbbb = null;
            private final int value;

            static {
                zzbbb = new zzif();
            }

            private zzb(int i) {
                this.value = i;
            }

            public final int zzhn() {
                return this.value;
            }
        }

        static {
            zza zza = new zza();
            zzbar = zza;
            zza.zza(zzfeu.zzpct, (Object) null, (Object) null);
            zza.zzpcg.zzbin();
        }

        private zza() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzie.zzbaq[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return zzbar;
                case 3:
                    return null;
                case 4:
                    return new C1237zza((zzie) null);
                case 5:
                    return this;
                case 6:
                    zzfdy zzfdy = (zzfdy) obj;
                    if (((zzfei) obj2) != null) {
                        boolean z = false;
                        while (!z) {
                            try {
                                int zzctt = zzfdy.zzctt();
                                switch (zzctt) {
                                    case 0:
                                        z = true;
                                        break;
                                    default:
                                        if (zza(zzctt, zzfdy)) {
                                            break;
                                        } else {
                                            z = true;
                                            break;
                                        }
                                }
                            } catch (zzffe e) {
                                throw new RuntimeException(e.zzh(this));
                            } catch (IOException e2) {
                                throw new RuntimeException(new zzffe(e2.getMessage()).zzh(this));
                            }
                        }
                        break;
                    } else {
                        throw new NullPointerException();
                    }
                case 7:
                    break;
                case 8:
                    if (zzbas == null) {
                        synchronized (zza.class) {
                            if (zzbas == null) {
                                zzbas = new zzfeo(zzbar);
                            }
                        }
                    }
                    return zzbas;
                default:
                    throw new UnsupportedOperationException();
            }
            return zzbar;
        }

        public final void zza(zzfed zzfed) throws IOException {
            this.zzpcg.zza(zzfed);
        }

        public final int zzhl() {
            int i = this.zzpch;
            if (i != -1) {
                return i;
            }
            int zzhl = this.zzpcg.zzhl() + 0;
            this.zzpch = zzhl;
            return zzhl;
        }
    }
}
