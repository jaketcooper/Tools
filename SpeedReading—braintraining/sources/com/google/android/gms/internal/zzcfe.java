package com.google.android.gms.internal;

import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;

final class zzcfe {
    private final String mAppId;
    private String zzcvg;
    private String zzdoc;
    private String zzgdr;
    private final zzchj zzitu;
    private String zziul;
    private String zzium;
    private long zziun;
    private long zziuo;
    private long zziup;
    private long zziuq;
    private String zziur;
    private long zzius;
    private long zziut;
    private boolean zziuu;
    private long zziuv;
    private boolean zziuw;
    private long zziux;
    private long zziuy;
    private long zziuz;
    private long zziva;
    private long zzivb;
    private long zzivc;
    private String zzivd;
    private boolean zzive;
    private long zzivf;
    private long zzivg;

    @WorkerThread
    zzcfe(zzchj zzchj, String str) {
        zzbq.checkNotNull(zzchj);
        zzbq.zzgi(str);
        this.zzitu = zzchj;
        this.mAppId = str;
        this.zzitu.zzawm().zzut();
    }

    @WorkerThread
    public final String getAppId() {
        this.zzitu.zzawm().zzut();
        return this.mAppId;
    }

    @WorkerThread
    public final String getAppInstanceId() {
        this.zzitu.zzawm().zzut();
        return this.zzgdr;
    }

    @WorkerThread
    public final String getGmpAppId() {
        this.zzitu.zzawm().zzut();
        return this.zzcvg;
    }

    @WorkerThread
    public final void setAppVersion(String str) {
        this.zzitu.zzawm().zzut();
        this.zzive = (!zzckn.zzas(this.zzdoc, str)) | this.zzive;
        this.zzdoc = str;
    }

    @WorkerThread
    public final void setMeasurementEnabled(boolean z) {
        this.zzitu.zzawm().zzut();
        this.zzive = (this.zziuu != z) | this.zzive;
        this.zziuu = z;
    }

    @WorkerThread
    public final void zzak(long j) {
        this.zzitu.zzawm().zzut();
        this.zzive = (this.zziuo != j) | this.zzive;
        this.zziuo = j;
    }

    @WorkerThread
    public final void zzal(long j) {
        this.zzitu.zzawm().zzut();
        this.zzive = (this.zziup != j) | this.zzive;
        this.zziup = j;
    }

    @WorkerThread
    public final void zzam(long j) {
        this.zzitu.zzawm().zzut();
        this.zzive = (this.zziuq != j) | this.zzive;
        this.zziuq = j;
    }

    @WorkerThread
    public final void zzan(long j) {
        this.zzitu.zzawm().zzut();
        this.zzive = (this.zzius != j) | this.zzive;
        this.zzius = j;
    }

    @WorkerThread
    public final void zzao(long j) {
        this.zzitu.zzawm().zzut();
        this.zzive = (this.zziut != j) | this.zzive;
        this.zziut = j;
    }

    @WorkerThread
    public final void zzap(long j) {
        boolean z = true;
        zzbq.checkArgument(j >= 0);
        this.zzitu.zzawm().zzut();
        boolean z2 = this.zzive;
        if (this.zziun == j) {
            z = false;
        }
        this.zzive = z2 | z;
        this.zziun = j;
    }

    @WorkerThread
    public final void zzaq(long j) {
        this.zzitu.zzawm().zzut();
        this.zzive = (this.zzivf != j) | this.zzive;
        this.zzivf = j;
    }

    @WorkerThread
    public final void zzar(long j) {
        this.zzitu.zzawm().zzut();
        this.zzive = (this.zzivg != j) | this.zzive;
        this.zzivg = j;
    }

    @WorkerThread
    public final void zzas(long j) {
        this.zzitu.zzawm().zzut();
        this.zzive = (this.zziux != j) | this.zzive;
        this.zziux = j;
    }

    @WorkerThread
    public final void zzat(long j) {
        this.zzitu.zzawm().zzut();
        this.zzive = (this.zziuy != j) | this.zzive;
        this.zziuy = j;
    }

    @WorkerThread
    public final void zzau(long j) {
        this.zzitu.zzawm().zzut();
        this.zzive = (this.zziuz != j) | this.zzive;
        this.zziuz = j;
    }

    @WorkerThread
    public final void zzav(long j) {
        this.zzitu.zzawm().zzut();
        this.zzive = (this.zziva != j) | this.zzive;
        this.zziva = j;
    }

    @WorkerThread
    public final void zzaw(long j) {
        this.zzitu.zzawm().zzut();
        this.zzive = (this.zzivc != j) | this.zzive;
        this.zzivc = j;
    }

    @WorkerThread
    public final void zzawq() {
        this.zzitu.zzawm().zzut();
        this.zzive = false;
    }

    @WorkerThread
    public final String zzawr() {
        this.zzitu.zzawm().zzut();
        return this.zziul;
    }

    @WorkerThread
    public final String zzaws() {
        this.zzitu.zzawm().zzut();
        return this.zzium;
    }

    @WorkerThread
    public final long zzawt() {
        this.zzitu.zzawm().zzut();
        return this.zziuo;
    }

    @WorkerThread
    public final long zzawu() {
        this.zzitu.zzawm().zzut();
        return this.zziup;
    }

    @WorkerThread
    public final long zzawv() {
        this.zzitu.zzawm().zzut();
        return this.zziuq;
    }

    @WorkerThread
    public final String zzaww() {
        this.zzitu.zzawm().zzut();
        return this.zziur;
    }

    @WorkerThread
    public final long zzawx() {
        this.zzitu.zzawm().zzut();
        return this.zzius;
    }

    @WorkerThread
    public final long zzawy() {
        this.zzitu.zzawm().zzut();
        return this.zziut;
    }

    @WorkerThread
    public final boolean zzawz() {
        this.zzitu.zzawm().zzut();
        return this.zziuu;
    }

    @WorkerThread
    public final void zzax(long j) {
        this.zzitu.zzawm().zzut();
        this.zzive = (this.zzivb != j) | this.zzive;
        this.zzivb = j;
    }

    @WorkerThread
    public final long zzaxa() {
        this.zzitu.zzawm().zzut();
        return this.zziun;
    }

    @WorkerThread
    public final long zzaxb() {
        this.zzitu.zzawm().zzut();
        return this.zzivf;
    }

    @WorkerThread
    public final long zzaxc() {
        this.zzitu.zzawm().zzut();
        return this.zzivg;
    }

    @WorkerThread
    public final void zzaxd() {
        this.zzitu.zzawm().zzut();
        long j = this.zziun + 1;
        if (j > 2147483647L) {
            this.zzitu.zzawn().zzayu().zzj("Bundle index overflow. appId", zzcgj.zzjf(this.mAppId));
            j = 0;
        }
        this.zzive = true;
        this.zziun = j;
    }

    @WorkerThread
    public final long zzaxe() {
        this.zzitu.zzawm().zzut();
        return this.zziux;
    }

    @WorkerThread
    public final long zzaxf() {
        this.zzitu.zzawm().zzut();
        return this.zziuy;
    }

    @WorkerThread
    public final long zzaxg() {
        this.zzitu.zzawm().zzut();
        return this.zziuz;
    }

    @WorkerThread
    public final long zzaxh() {
        this.zzitu.zzawm().zzut();
        return this.zziva;
    }

    @WorkerThread
    public final long zzaxi() {
        this.zzitu.zzawm().zzut();
        return this.zzivc;
    }

    @WorkerThread
    public final long zzaxj() {
        this.zzitu.zzawm().zzut();
        return this.zzivb;
    }

    @WorkerThread
    public final String zzaxk() {
        this.zzitu.zzawm().zzut();
        return this.zzivd;
    }

    @WorkerThread
    public final String zzaxl() {
        this.zzitu.zzawm().zzut();
        String str = this.zzivd;
        zzir((String) null);
        return str;
    }

    @WorkerThread
    public final long zzaxm() {
        this.zzitu.zzawm().zzut();
        return this.zziuv;
    }

    @WorkerThread
    public final boolean zzaxn() {
        this.zzitu.zzawm().zzut();
        return this.zziuw;
    }

    @WorkerThread
    public final void zzay(long j) {
        this.zzitu.zzawm().zzut();
        this.zzive = (this.zziuv != j) | this.zzive;
        this.zziuv = j;
    }

    @WorkerThread
    public final void zzbk(boolean z) {
        this.zzitu.zzawm().zzut();
        this.zzive = this.zziuw != z;
        this.zziuw = z;
    }

    @WorkerThread
    public final void zzim(String str) {
        this.zzitu.zzawm().zzut();
        this.zzive = (!zzckn.zzas(this.zzgdr, str)) | this.zzive;
        this.zzgdr = str;
    }

    @WorkerThread
    public final void zzin(String str) {
        this.zzitu.zzawm().zzut();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzive = (!zzckn.zzas(this.zzcvg, str)) | this.zzive;
        this.zzcvg = str;
    }

    @WorkerThread
    public final void zzio(String str) {
        this.zzitu.zzawm().zzut();
        this.zzive = (!zzckn.zzas(this.zziul, str)) | this.zzive;
        this.zziul = str;
    }

    @WorkerThread
    public final void zzip(String str) {
        this.zzitu.zzawm().zzut();
        this.zzive = (!zzckn.zzas(this.zzium, str)) | this.zzive;
        this.zzium = str;
    }

    @WorkerThread
    public final void zziq(String str) {
        this.zzitu.zzawm().zzut();
        this.zzive = (!zzckn.zzas(this.zziur, str)) | this.zzive;
        this.zziur = str;
    }

    @WorkerThread
    public final void zzir(String str) {
        this.zzitu.zzawm().zzut();
        this.zzive = (!zzckn.zzas(this.zzivd, str)) | this.zzive;
        this.zzivd = str;
    }

    @WorkerThread
    public final String zzuy() {
        this.zzitu.zzawm().zzut();
        return this.zzdoc;
    }
}
