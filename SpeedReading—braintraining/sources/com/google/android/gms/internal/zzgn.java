package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzbs;
import java.util.ArrayList;

@zzzb
public final class zzgn {
    private final Object mLock = new Object();
    private final int zzaxi;
    private final int zzaxj;
    private final int zzaxk;
    private final zzha zzaxl;
    private final zzhj zzaxm;
    private ArrayList<String> zzaxn = new ArrayList<>();
    private ArrayList<String> zzaxo = new ArrayList<>();
    private ArrayList<zzgy> zzaxp = new ArrayList<>();
    private int zzaxq = 0;
    private int zzaxr = 0;
    private int zzaxs = 0;
    private int zzaxt;
    private String zzaxu = "";
    private String zzaxv = "";
    private String zzaxw = "";

    public zzgn(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.zzaxi = i;
        this.zzaxj = i2;
        this.zzaxk = i3;
        this.zzaxl = new zzha(i4);
        this.zzaxm = new zzhj(i5, i6, i7);
    }

    private static String zza(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList2.get(i2);
            i2++;
            stringBuffer.append((String) obj);
            stringBuffer.append(' ');
            if (stringBuffer.length() > 100) {
                break;
            }
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() >= 100 ? stringBuffer2.substring(0, 100) : stringBuffer2;
    }

    private final void zzc(@Nullable String str, boolean z, float f, float f2, float f3, float f4) {
        if (str != null && str.length() >= this.zzaxk) {
            synchronized (this.mLock) {
                this.zzaxn.add(str);
                this.zzaxq += str.length();
                if (z) {
                    this.zzaxo.add(str);
                    this.zzaxp.add(new zzgy(f, f2, f3, f4, this.zzaxo.size() - 1));
                }
            }
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgn)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzgn zzgn = (zzgn) obj;
        return zzgn.zzaxu != null && zzgn.zzaxu.equals(this.zzaxu);
    }

    public final int getScore() {
        return this.zzaxt;
    }

    public final int hashCode() {
        return this.zzaxu.hashCode();
    }

    public final String toString() {
        int i = this.zzaxr;
        int i2 = this.zzaxt;
        int i3 = this.zzaxq;
        String zza = zza(this.zzaxn, 100);
        String zza2 = zza(this.zzaxo, 100);
        String str = this.zzaxu;
        String str2 = this.zzaxv;
        String str3 = this.zzaxw;
        return new StringBuilder(String.valueOf(zza).length() + 165 + String.valueOf(zza2).length() + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length()).append("ActivityContent fetchId: ").append(i).append(" score:").append(i2).append(" total_length:").append(i3).append("\n text: ").append(zza).append("\n viewableText").append(zza2).append("\n signture: ").append(str).append("\n viewableSignture: ").append(str2).append("\n viewableSignatureForVertical: ").append(str3).toString();
    }

    public final void zza(String str, boolean z, float f, float f2, float f3, float f4) {
        zzc(str, z, f, f2, f3, f4);
        synchronized (this.mLock) {
            if (this.zzaxs < 0) {
                zzafj.zzbw("ActivityContent: negative number of WebViews.");
            }
            zzgn();
        }
    }

    public final void zzb(String str, boolean z, float f, float f2, float f3, float f4) {
        zzc(str, z, f, f2, f3, f4);
    }

    public final boolean zzgg() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzaxs == 0;
        }
        return z;
    }

    public final String zzgh() {
        return this.zzaxu;
    }

    public final String zzgi() {
        return this.zzaxv;
    }

    public final String zzgj() {
        return this.zzaxw;
    }

    public final void zzgk() {
        synchronized (this.mLock) {
            this.zzaxt -= 100;
        }
    }

    public final void zzgl() {
        synchronized (this.mLock) {
            this.zzaxs--;
        }
    }

    public final void zzgm() {
        synchronized (this.mLock) {
            this.zzaxs++;
        }
    }

    public final void zzgn() {
        synchronized (this.mLock) {
            int i = (this.zzaxq * this.zzaxi) + (this.zzaxr * this.zzaxj);
            if (i > this.zzaxt) {
                this.zzaxt = i;
                if (((Boolean) zzbs.zzep().zzd(zzmq.zzbig)).booleanValue() && !zzbs.zzeg().zzos()) {
                    this.zzaxu = this.zzaxl.zza(this.zzaxn);
                    this.zzaxv = this.zzaxl.zza(this.zzaxo);
                }
                if (((Boolean) zzbs.zzep().zzd(zzmq.zzbii)).booleanValue() && !zzbs.zzeg().zzot()) {
                    this.zzaxw = this.zzaxm.zza(this.zzaxo, this.zzaxp);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzgo() {
        return this.zzaxq;
    }

    public final void zzo(int i) {
        this.zzaxr = i;
    }
}
