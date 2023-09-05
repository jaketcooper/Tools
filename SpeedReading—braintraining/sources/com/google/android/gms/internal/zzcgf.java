package com.google.android.gms.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.zzd;

public final class zzcgf extends zzcii {
    private final zzcgg zzizc = new zzcgg(this, getContext(), "google_app_measurement_local.db");
    private boolean zzizd;

    zzcgf(zzchj zzchj) {
        super(zzchj);
    }

    @WorkerThread
    private final SQLiteDatabase getWritableDatabase() {
        if (this.zzizd) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zzizc.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzizd = true;
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cf, code lost:
        r6 = r6 + 1;
     */
    @android.support.annotation.WorkerThread
    @android.annotation.TargetApi(11)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzb(int r14, byte[] r15) {
        /*
            r13 = this;
            r13.zzut()
            boolean r0 = r13.zzizd
            if (r0 == 0) goto L_0x0009
            r0 = 0
        L_0x0008:
            return r0
        L_0x0009:
            android.content.ContentValues r7 = new android.content.ContentValues
            r7.<init>()
            java.lang.String r0 = "type"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r14)
            r7.put(r0, r1)
            java.lang.String r0 = "entry"
            r7.put(r0, r15)
            r1 = 5
            r0 = 0
            r6 = r0
            r0 = r1
        L_0x0020:
            r1 = 5
            if (r6 >= r1) goto L_0x0118
            r3 = 0
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r13.getWritableDatabase()     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteException -> 0x00d4 }
            if (r3 != 0) goto L_0x0035
            r1 = 1
            r13.zzizd = r1     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteException -> 0x00d4 }
            if (r3 == 0) goto L_0x0033
            r3.close()
        L_0x0033:
            r0 = 0
            goto L_0x0008
        L_0x0035:
            r3.beginTransaction()     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteException -> 0x00d4 }
            r4 = 0
            java.lang.String r1 = "select count(1) from messages"
            r8 = 0
            android.database.Cursor r2 = r3.rawQuery(r1, r8)     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteException -> 0x00d4 }
            if (r2 == 0) goto L_0x004e
            boolean r1 = r2.moveToFirst()     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteException -> 0x00d4 }
            if (r1 == 0) goto L_0x004e
            r1 = 0
            long r4 = r2.getLong(r1)     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteException -> 0x00d4 }
        L_0x004e:
            r8 = 100000(0x186a0, double:4.94066E-319)
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 < 0) goto L_0x009b
            com.google.android.gms.internal.zzcgj r1 = r13.zzawn()     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteException -> 0x00d4 }
            com.google.android.gms.internal.zzcgl r1 = r1.zzays()     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteException -> 0x00d4 }
            java.lang.String r8 = "Data loss, local db full"
            r1.log(r8)     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteException -> 0x00d4 }
            r8 = 100000(0x186a0, double:4.94066E-319)
            long r4 = r8 - r4
            r8 = 1
            long r4 = r4 + r8
            java.lang.String r1 = "messages"
            java.lang.String r8 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            r9 = 1
            java.lang.String[] r9 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteException -> 0x00d4 }
            r10 = 0
            java.lang.String r11 = java.lang.Long.toString(r4)     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteException -> 0x00d4 }
            r9[r10] = r11     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteException -> 0x00d4 }
            int r1 = r3.delete(r1, r8, r9)     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteException -> 0x00d4 }
            long r8 = (long) r1     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteException -> 0x00d4 }
            int r1 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x009b
            com.google.android.gms.internal.zzcgj r1 = r13.zzawn()     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteException -> 0x00d4 }
            com.google.android.gms.internal.zzcgl r1 = r1.zzays()     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteException -> 0x00d4 }
            java.lang.String r10 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r11 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteException -> 0x00d4 }
            java.lang.Long r12 = java.lang.Long.valueOf(r8)     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteException -> 0x00d4 }
            long r4 = r4 - r8
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteException -> 0x00d4 }
            r1.zzd(r10, r11, r12, r4)     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteException -> 0x00d4 }
        L_0x009b:
            java.lang.String r1 = "messages"
            r4 = 0
            r3.insertOrThrow(r1, r4, r7)     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteException -> 0x00d4 }
            r3.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteException -> 0x00d4 }
            r3.endTransaction()     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteException -> 0x00d4 }
            if (r2 == 0) goto L_0x00ac
            r2.close()
        L_0x00ac:
            if (r3 == 0) goto L_0x00b1
            r3.close()
        L_0x00b1:
            r0 = 1
            goto L_0x0008
        L_0x00b4:
            r1 = move-exception
            com.google.android.gms.internal.zzcgj r4 = r13.zzawn()     // Catch:{ all -> 0x010c }
            com.google.android.gms.internal.zzcgl r4 = r4.zzays()     // Catch:{ all -> 0x010c }
            java.lang.String r5 = "Error writing entry to local database"
            r4.zzj(r5, r1)     // Catch:{ all -> 0x010c }
            r1 = 1
            r13.zzizd = r1     // Catch:{ all -> 0x010c }
            if (r2 == 0) goto L_0x00ca
            r2.close()
        L_0x00ca:
            if (r3 == 0) goto L_0x00cf
            r3.close()
        L_0x00cf:
            int r1 = r6 + 1
            r6 = r1
            goto L_0x0020
        L_0x00d4:
            r1 = move-exception
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x010c }
            r5 = 11
            if (r4 < r5) goto L_0x00f0
            boolean r4 = r1 instanceof android.database.sqlite.SQLiteDatabaseLockedException     // Catch:{ all -> 0x010c }
            if (r4 == 0) goto L_0x00f0
            long r4 = (long) r0     // Catch:{ all -> 0x010c }
            android.os.SystemClock.sleep(r4)     // Catch:{ all -> 0x010c }
            int r0 = r0 + 20
        L_0x00e5:
            if (r2 == 0) goto L_0x00ea
            r2.close()
        L_0x00ea:
            if (r3 == 0) goto L_0x00cf
            r3.close()
            goto L_0x00cf
        L_0x00f0:
            if (r3 == 0) goto L_0x00fb
            boolean r4 = r3.inTransaction()     // Catch:{ all -> 0x010c }
            if (r4 == 0) goto L_0x00fb
            r3.endTransaction()     // Catch:{ all -> 0x010c }
        L_0x00fb:
            com.google.android.gms.internal.zzcgj r4 = r13.zzawn()     // Catch:{ all -> 0x010c }
            com.google.android.gms.internal.zzcgl r4 = r4.zzays()     // Catch:{ all -> 0x010c }
            java.lang.String r5 = "Error writing entry to local database"
            r4.zzj(r5, r1)     // Catch:{ all -> 0x010c }
            r1 = 1
            r13.zzizd = r1     // Catch:{ all -> 0x010c }
            goto L_0x00e5
        L_0x010c:
            r0 = move-exception
            if (r2 == 0) goto L_0x0112
            r2.close()
        L_0x0112:
            if (r3 == 0) goto L_0x0117
            r3.close()
        L_0x0117:
            throw r0
        L_0x0118:
            com.google.android.gms.internal.zzcgj r0 = r13.zzawn()
            com.google.android.gms.internal.zzcgl r0 = r0.zzayu()
            java.lang.String r1 = "Failed to write entry to local database"
            r0.log(r1)
            r0 = 0
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgf.zzb(int, byte[]):boolean");
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    public final void resetAnalyticsData() {
        zzut();
        try {
            int delete = getWritableDatabase().delete("messages", (String) null, (String[]) null) + 0;
            if (delete > 0) {
                zzawn().zzayy().zzj("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzawn().zzays().zzj("Error resetting local analytics data. error", e);
        }
    }

    public final boolean zza(zzcfx zzcfx) {
        Parcel obtain = Parcel.obtain();
        zzcfx.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zzb(0, marshall);
        }
        zzawn().zzayu().log("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzckk zzckk) {
        Parcel obtain = Parcel.obtain();
        zzckk.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zzb(1, marshall);
        }
        zzawn().zzayu().log("User property too long for local database. Sending directly to service");
        return false;
    }

    public final /* bridge */ /* synthetic */ void zzavx() {
        super.zzavx();
    }

    public final /* bridge */ /* synthetic */ void zzavy() {
        super.zzavy();
    }

    public final /* bridge */ /* synthetic */ zzcfa zzavz() {
        return super.zzavz();
    }

    public final /* bridge */ /* synthetic */ zzcfh zzawa() {
        return super.zzawa();
    }

    public final /* bridge */ /* synthetic */ zzcik zzawb() {
        return super.zzawb();
    }

    public final /* bridge */ /* synthetic */ zzcge zzawc() {
        return super.zzawc();
    }

    public final /* bridge */ /* synthetic */ zzcfr zzawd() {
        return super.zzawd();
    }

    public final /* bridge */ /* synthetic */ zzcjd zzawe() {
        return super.zzawe();
    }

    public final /* bridge */ /* synthetic */ zzciz zzawf() {
        return super.zzawf();
    }

    public final /* bridge */ /* synthetic */ zzcgf zzawg() {
        return super.zzawg();
    }

    public final /* bridge */ /* synthetic */ zzcfl zzawh() {
        return super.zzawh();
    }

    public final /* bridge */ /* synthetic */ zzcgh zzawi() {
        return super.zzawi();
    }

    public final /* bridge */ /* synthetic */ zzckn zzawj() {
        return super.zzawj();
    }

    public final /* bridge */ /* synthetic */ zzchd zzawk() {
        return super.zzawk();
    }

    public final /* bridge */ /* synthetic */ zzckc zzawl() {
        return super.zzawl();
    }

    public final /* bridge */ /* synthetic */ zzche zzawm() {
        return super.zzawm();
    }

    public final /* bridge */ /* synthetic */ zzcgj zzawn() {
        return super.zzawn();
    }

    public final /* bridge */ /* synthetic */ zzcgu zzawo() {
        return super.zzawo();
    }

    public final /* bridge */ /* synthetic */ zzcfk zzawp() {
        return super.zzawp();
    }

    /* access modifiers changed from: protected */
    public final boolean zzaxo() {
        return false;
    }

    public final boolean zzc(zzcfi zzcfi) {
        zzawj();
        byte[] zza = zzckn.zza((Parcelable) zzcfi);
        if (zza.length <= 131072) {
            return zzb(2, zza);
        }
        zzawn().zzayu().log("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x00b6 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00dc A[Catch:{ all -> 0x01fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00fd  */
    @android.annotation.TargetApi(11)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.zzbej> zzec(int r15) {
        /*
            r14 = this;
            r14.zzut()
            boolean r0 = r14.zzizd
            if (r0 == 0) goto L_0x0009
            r0 = 0
        L_0x0008:
            return r0
        L_0x0009:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            android.content.Context r0 = r14.getContext()
            java.lang.String r1 = "google_app_measurement_local.db"
            java.io.File r0 = r0.getDatabasePath(r1)
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0020
            r0 = r10
            goto L_0x0008
        L_0x0020:
            r9 = 5
            r0 = 0
            r12 = r0
        L_0x0023:
            r0 = 5
            if (r12 >= r0) goto L_0x01dc
            r1 = 0
            r11 = 0
            android.database.sqlite.SQLiteDatabase r0 = r14.getWritableDatabase()     // Catch:{ SQLiteFullException -> 0x020b, SQLiteException -> 0x0200, all -> 0x01ec }
            if (r0 != 0) goto L_0x0038
            r1 = 1
            r14.zzizd = r1     // Catch:{ SQLiteFullException -> 0x0210, SQLiteException -> 0x0204, all -> 0x01f0 }
            if (r0 == 0) goto L_0x0036
            r0.close()
        L_0x0036:
            r0 = 0
            goto L_0x0008
        L_0x0038:
            r0.beginTransaction()     // Catch:{ SQLiteFullException -> 0x0210, SQLiteException -> 0x0204, all -> 0x01f0 }
            java.lang.String r1 = "messages"
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteFullException -> 0x0210, SQLiteException -> 0x0204, all -> 0x01f0 }
            r3 = 0
            java.lang.String r4 = "rowid"
            r2[r3] = r4     // Catch:{ SQLiteFullException -> 0x0210, SQLiteException -> 0x0204, all -> 0x01f0 }
            r3 = 1
            java.lang.String r4 = "type"
            r2[r3] = r4     // Catch:{ SQLiteFullException -> 0x0210, SQLiteException -> 0x0204, all -> 0x01f0 }
            r3 = 2
            java.lang.String r4 = "entry"
            r2[r3] = r4     // Catch:{ SQLiteFullException -> 0x0210, SQLiteException -> 0x0204, all -> 0x01f0 }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "rowid asc"
            r8 = 100
            java.lang.String r8 = java.lang.Integer.toString(r8)     // Catch:{ SQLiteFullException -> 0x0210, SQLiteException -> 0x0204, all -> 0x01f0 }
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteFullException -> 0x0210, SQLiteException -> 0x0204, all -> 0x01f0 }
            r4 = -1
        L_0x0061:
            boolean r1 = r2.moveToNext()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            if (r1 == 0) goto L_0x0186
            r1 = 0
            long r4 = r2.getLong(r1)     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            r1 = 1
            int r1 = r2.getInt(r1)     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            r3 = 2
            byte[] r6 = r2.getBlob(r3)     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            if (r1 != 0) goto L_0x0101
            android.os.Parcel r3 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            r1 = 0
            int r7 = r6.length     // Catch:{ zzbel -> 0x00bc }
            r3.unmarshall(r6, r1, r7)     // Catch:{ zzbel -> 0x00bc }
            r1 = 0
            r3.setDataPosition(r1)     // Catch:{ zzbel -> 0x00bc }
            android.os.Parcelable$Creator<com.google.android.gms.internal.zzcfx> r1 = com.google.android.gms.internal.zzcfx.CREATOR     // Catch:{ zzbel -> 0x00bc }
            java.lang.Object r1 = r1.createFromParcel(r3)     // Catch:{ zzbel -> 0x00bc }
            com.google.android.gms.internal.zzcfx r1 = (com.google.android.gms.internal.zzcfx) r1     // Catch:{ zzbel -> 0x00bc }
            r3.recycle()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            if (r1 == 0) goto L_0x0061
            r10.add(r1)     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            goto L_0x0061
        L_0x0096:
            r1 = move-exception
            r13 = r1
            r1 = r2
            r2 = r0
            r0 = r13
        L_0x009b:
            com.google.android.gms.internal.zzcgj r3 = r14.zzawn()     // Catch:{ all -> 0x01f7 }
            com.google.android.gms.internal.zzcgl r3 = r3.zzays()     // Catch:{ all -> 0x01f7 }
            java.lang.String r4 = "Error reading entries from local database"
            r3.zzj(r4, r0)     // Catch:{ all -> 0x01f7 }
            r0 = 1
            r14.zzizd = r0     // Catch:{ all -> 0x01f7 }
            if (r1 == 0) goto L_0x00b0
            r1.close()
        L_0x00b0:
            if (r2 == 0) goto L_0x0216
            r2.close()
            r0 = r9
        L_0x00b6:
            int r1 = r12 + 1
            r12 = r1
            r9 = r0
            goto L_0x0023
        L_0x00bc:
            r1 = move-exception
            com.google.android.gms.internal.zzcgj r1 = r14.zzawn()     // Catch:{ all -> 0x00ed }
            com.google.android.gms.internal.zzcgl r1 = r1.zzays()     // Catch:{ all -> 0x00ed }
            java.lang.String r6 = "Failed to load event from local database"
            r1.log(r6)     // Catch:{ all -> 0x00ed }
            r3.recycle()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            goto L_0x0061
        L_0x00ce:
            r1 = move-exception
            r13 = r1
            r1 = r0
            r0 = r13
        L_0x00d2:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01fd }
            r4 = 11
            if (r3 < r4) goto L_0x01be
            boolean r3 = r0 instanceof android.database.sqlite.SQLiteDatabaseLockedException     // Catch:{ all -> 0x01fd }
            if (r3 == 0) goto L_0x01be
            long r4 = (long) r9     // Catch:{ all -> 0x01fd }
            android.os.SystemClock.sleep(r4)     // Catch:{ all -> 0x01fd }
            int r0 = r9 + 20
        L_0x00e2:
            if (r2 == 0) goto L_0x00e7
            r2.close()
        L_0x00e7:
            if (r1 == 0) goto L_0x00b6
            r1.close()
            goto L_0x00b6
        L_0x00ed:
            r1 = move-exception
            r3.recycle()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            throw r1     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
        L_0x00f2:
            r1 = move-exception
            r13 = r1
            r1 = r0
            r0 = r13
        L_0x00f6:
            if (r2 == 0) goto L_0x00fb
            r2.close()
        L_0x00fb:
            if (r1 == 0) goto L_0x0100
            r1.close()
        L_0x0100:
            throw r0
        L_0x0101:
            r3 = 1
            if (r1 != r3) goto L_0x013c
            android.os.Parcel r7 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            r3 = 0
            r1 = 0
            int r8 = r6.length     // Catch:{ zzbel -> 0x0124 }
            r7.unmarshall(r6, r1, r8)     // Catch:{ zzbel -> 0x0124 }
            r1 = 0
            r7.setDataPosition(r1)     // Catch:{ zzbel -> 0x0124 }
            android.os.Parcelable$Creator<com.google.android.gms.internal.zzckk> r1 = com.google.android.gms.internal.zzckk.CREATOR     // Catch:{ zzbel -> 0x0124 }
            java.lang.Object r1 = r1.createFromParcel(r7)     // Catch:{ zzbel -> 0x0124 }
            com.google.android.gms.internal.zzckk r1 = (com.google.android.gms.internal.zzckk) r1     // Catch:{ zzbel -> 0x0124 }
            r7.recycle()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
        L_0x011d:
            if (r1 == 0) goto L_0x0061
            r10.add(r1)     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            goto L_0x0061
        L_0x0124:
            r1 = move-exception
            com.google.android.gms.internal.zzcgj r1 = r14.zzawn()     // Catch:{ all -> 0x0137 }
            com.google.android.gms.internal.zzcgl r1 = r1.zzays()     // Catch:{ all -> 0x0137 }
            java.lang.String r6 = "Failed to load user property from local database"
            r1.log(r6)     // Catch:{ all -> 0x0137 }
            r7.recycle()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            r1 = r3
            goto L_0x011d
        L_0x0137:
            r1 = move-exception
            r7.recycle()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            throw r1     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
        L_0x013c:
            r3 = 2
            if (r1 != r3) goto L_0x0177
            android.os.Parcel r7 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            r3 = 0
            r1 = 0
            int r8 = r6.length     // Catch:{ zzbel -> 0x015f }
            r7.unmarshall(r6, r1, r8)     // Catch:{ zzbel -> 0x015f }
            r1 = 0
            r7.setDataPosition(r1)     // Catch:{ zzbel -> 0x015f }
            android.os.Parcelable$Creator<com.google.android.gms.internal.zzcfi> r1 = com.google.android.gms.internal.zzcfi.CREATOR     // Catch:{ zzbel -> 0x015f }
            java.lang.Object r1 = r1.createFromParcel(r7)     // Catch:{ zzbel -> 0x015f }
            com.google.android.gms.internal.zzcfi r1 = (com.google.android.gms.internal.zzcfi) r1     // Catch:{ zzbel -> 0x015f }
            r7.recycle()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
        L_0x0158:
            if (r1 == 0) goto L_0x0061
            r10.add(r1)     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            goto L_0x0061
        L_0x015f:
            r1 = move-exception
            com.google.android.gms.internal.zzcgj r1 = r14.zzawn()     // Catch:{ all -> 0x0172 }
            com.google.android.gms.internal.zzcgl r1 = r1.zzays()     // Catch:{ all -> 0x0172 }
            java.lang.String r6 = "Failed to load user property from local database"
            r1.log(r6)     // Catch:{ all -> 0x0172 }
            r7.recycle()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            r1 = r3
            goto L_0x0158
        L_0x0172:
            r1 = move-exception
            r7.recycle()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            throw r1     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
        L_0x0177:
            com.google.android.gms.internal.zzcgj r1 = r14.zzawn()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            com.google.android.gms.internal.zzcgl r1 = r1.zzays()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            java.lang.String r3 = "Unknown record type in local database"
            r1.log(r3)     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            goto L_0x0061
        L_0x0186:
            java.lang.String r1 = "messages"
            java.lang.String r3 = "rowid <= ?"
            r6 = 1
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            r7 = 0
            java.lang.String r4 = java.lang.Long.toString(r4)     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            r6[r7] = r4     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            int r1 = r0.delete(r1, r3, r6)     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            int r3 = r10.size()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            if (r1 >= r3) goto L_0x01ab
            com.google.android.gms.internal.zzcgj r1 = r14.zzawn()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            com.google.android.gms.internal.zzcgl r1 = r1.zzays()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            java.lang.String r3 = "Fewer entries removed from local database than expected"
            r1.log(r3)     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
        L_0x01ab:
            r0.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            r0.endTransaction()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteException -> 0x00ce, all -> 0x00f2 }
            if (r2 == 0) goto L_0x01b6
            r2.close()
        L_0x01b6:
            if (r0 == 0) goto L_0x01bb
            r0.close()
        L_0x01bb:
            r0 = r10
            goto L_0x0008
        L_0x01be:
            if (r1 == 0) goto L_0x01c9
            boolean r3 = r1.inTransaction()     // Catch:{ all -> 0x01fd }
            if (r3 == 0) goto L_0x01c9
            r1.endTransaction()     // Catch:{ all -> 0x01fd }
        L_0x01c9:
            com.google.android.gms.internal.zzcgj r3 = r14.zzawn()     // Catch:{ all -> 0x01fd }
            com.google.android.gms.internal.zzcgl r3 = r3.zzays()     // Catch:{ all -> 0x01fd }
            java.lang.String r4 = "Error reading entries from local database"
            r3.zzj(r4, r0)     // Catch:{ all -> 0x01fd }
            r0 = 1
            r14.zzizd = r0     // Catch:{ all -> 0x01fd }
            r0 = r9
            goto L_0x00e2
        L_0x01dc:
            com.google.android.gms.internal.zzcgj r0 = r14.zzawn()
            com.google.android.gms.internal.zzcgl r0 = r0.zzayu()
            java.lang.String r1 = "Failed to read events from database in reasonable time"
            r0.log(r1)
            r0 = 0
            goto L_0x0008
        L_0x01ec:
            r0 = move-exception
            r2 = r11
            goto L_0x00f6
        L_0x01f0:
            r1 = move-exception
            r2 = r11
            r13 = r1
            r1 = r0
            r0 = r13
            goto L_0x00f6
        L_0x01f7:
            r0 = move-exception
            r13 = r1
            r1 = r2
            r2 = r13
            goto L_0x00f6
        L_0x01fd:
            r0 = move-exception
            goto L_0x00f6
        L_0x0200:
            r0 = move-exception
            r2 = r11
            goto L_0x00d2
        L_0x0204:
            r1 = move-exception
            r2 = r11
            r13 = r1
            r1 = r0
            r0 = r13
            goto L_0x00d2
        L_0x020b:
            r0 = move-exception
            r2 = r1
            r1 = r11
            goto L_0x009b
        L_0x0210:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r11
            goto L_0x009b
        L_0x0216:
            r0 = r9
            goto L_0x00b6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcgf.zzec(int):java.util.List");
    }

    public final /* bridge */ /* synthetic */ void zzut() {
        super.zzut();
    }

    public final /* bridge */ /* synthetic */ zzd zzwh() {
        return super.zzwh();
    }
}
