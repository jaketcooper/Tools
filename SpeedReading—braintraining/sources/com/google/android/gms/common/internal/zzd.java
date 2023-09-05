package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zze;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzd<T extends IInterface> {
    private static String[] zzfwo = {"service_esmobile", "service_googleme"};
    private final Context mContext;
    final Handler mHandler;
    private final Object mLock;
    private final Looper zzakm;
    private final zze zzfns;
    private int zzfvt;
    private long zzfvu;
    private long zzfvv;
    private int zzfvw;
    private long zzfvx;
    private zzam zzfvy;
    private final zzag zzfvz;
    /* access modifiers changed from: private */
    public final Object zzfwa;
    /* access modifiers changed from: private */
    public zzay zzfwb;
    protected zzj zzfwc;
    private T zzfwd;
    /* access modifiers changed from: private */
    public final ArrayList<zzi<?>> zzfwe;
    private zzl zzfwf;
    private int zzfwg;
    /* access modifiers changed from: private */
    public final zzf zzfwh;
    /* access modifiers changed from: private */
    public final zzg zzfwi;
    private final int zzfwj;
    private final String zzfwk;
    /* access modifiers changed from: private */
    public ConnectionResult zzfwl;
    /* access modifiers changed from: private */
    public boolean zzfwm;
    protected AtomicInteger zzfwn;

    protected zzd(Context context, Looper looper, int i, zzf zzf, zzg zzg, String str) {
        this(context, looper, zzag.zzcl(context), zze.zzafn(), i, (zzf) zzbq.checkNotNull(zzf), (zzg) zzbq.checkNotNull(zzg), (String) null);
    }

    protected zzd(Context context, Looper looper, zzag zzag, zze zze, int i, zzf zzf, zzg zzg, String str) {
        this.mLock = new Object();
        this.zzfwa = new Object();
        this.zzfwe = new ArrayList<>();
        this.zzfwg = 1;
        this.zzfwl = null;
        this.zzfwm = false;
        this.zzfwn = new AtomicInteger(0);
        this.mContext = (Context) zzbq.checkNotNull(context, "Context must not be null");
        this.zzakm = (Looper) zzbq.checkNotNull(looper, "Looper must not be null");
        this.zzfvz = (zzag) zzbq.checkNotNull(zzag, "Supervisor must not be null");
        this.zzfns = (zze) zzbq.checkNotNull(zze, "API availability must not be null");
        this.mHandler = new zzh(this, looper);
        this.zzfwj = i;
        this.zzfwh = zzf;
        this.zzfwi = zzg;
        this.zzfwk = str;
    }

    /* access modifiers changed from: private */
    public final void zza(int i, T t) {
        boolean z = true;
        if ((i == 4) != (t != null)) {
            z = false;
        }
        zzbq.checkArgument(z);
        synchronized (this.mLock) {
            this.zzfwg = i;
            this.zzfwd = t;
            switch (i) {
                case 1:
                    if (this.zzfwf != null) {
                        this.zzfvz.zza(zzhf(), zzajw(), 129, this.zzfwf, zzajx());
                        this.zzfwf = null;
                        break;
                    }
                    break;
                case 2:
                case 3:
                    if (!(this.zzfwf == null || this.zzfvy == null)) {
                        String zzald = this.zzfvy.zzald();
                        String packageName = this.zzfvy.getPackageName();
                        Log.e("GmsClient", new StringBuilder(String.valueOf(zzald).length() + 70 + String.valueOf(packageName).length()).append("Calling connect() while still connected, missing disconnect() for ").append(zzald).append(" on ").append(packageName).toString());
                        this.zzfvz.zza(this.zzfvy.zzald(), this.zzfvy.getPackageName(), this.zzfvy.zzakz(), this.zzfwf, zzajx());
                        this.zzfwn.incrementAndGet();
                    }
                    this.zzfwf = new zzl(this, this.zzfwn.get());
                    this.zzfvy = new zzam(zzajw(), zzhf(), false, 129);
                    if (!this.zzfvz.zza(new zzah(this.zzfvy.zzald(), this.zzfvy.getPackageName(), this.zzfvy.zzakz()), (ServiceConnection) this.zzfwf, zzajx())) {
                        String zzald2 = this.zzfvy.zzald();
                        String packageName2 = this.zzfvy.getPackageName();
                        Log.e("GmsClient", new StringBuilder(String.valueOf(zzald2).length() + 34 + String.valueOf(packageName2).length()).append("unable to connect to service: ").append(zzald2).append(" on ").append(packageName2).toString());
                        zza(16, (Bundle) null, this.zzfwn.get());
                        break;
                    }
                    break;
                case 4:
                    zza(t);
                    break;
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean zza(int i, int i2, T t) {
        boolean z;
        synchronized (this.mLock) {
            if (this.zzfwg != i) {
                z = false;
            } else {
                zza(i2, t);
                z = true;
            }
        }
        return z;
    }

    @Nullable
    private final String zzajx() {
        return this.zzfwk == null ? this.mContext.getClass().getName() : this.zzfwk;
    }

    private final boolean zzajz() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzfwg == 3;
        }
        return z;
    }

    /* access modifiers changed from: private */
    public final boolean zzakf() {
        if (this.zzfwm || TextUtils.isEmpty(zzhg()) || TextUtils.isEmpty((CharSequence) null)) {
            return false;
        }
        try {
            Class.forName(zzhg());
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final void zzcg(int i) {
        int i2;
        if (zzajz()) {
            i2 = 5;
            this.zzfwm = true;
        } else {
            i2 = 4;
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(i2, this.zzfwn.get(), 16));
    }

    public void disconnect() {
        this.zzfwn.incrementAndGet();
        synchronized (this.zzfwe) {
            int size = this.zzfwe.size();
            for (int i = 0; i < size; i++) {
                this.zzfwe.get(i).removeListener();
            }
            this.zzfwe.clear();
        }
        synchronized (this.zzfwa) {
            this.zzfwb = null;
        }
        zza(1, (IInterface) null);
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        T t;
        zzay zzay;
        synchronized (this.mLock) {
            i = this.zzfwg;
            t = this.zzfwd;
        }
        synchronized (this.zzfwa) {
            zzay = this.zzfwb;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("REMOTE_CONNECTING");
                break;
            case 3:
                printWriter.print("LOCAL_CONNECTING");
                break;
            case 4:
                printWriter.print("CONNECTED");
                break;
            case 5:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.append("null");
        } else {
            printWriter.append(zzhg()).append("@").append(Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (zzay == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(zzay.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzfvv > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j = this.zzfvv;
            String format = simpleDateFormat.format(new Date(this.zzfvv));
            append.println(new StringBuilder(String.valueOf(format).length() + 21).append(j).append(" ").append(format).toString());
        }
        if (this.zzfvu > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            switch (this.zzfvt) {
                case 1:
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    printWriter.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    printWriter.append(String.valueOf(this.zzfvt));
                    break;
            }
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.zzfvu;
            String format2 = simpleDateFormat.format(new Date(this.zzfvu));
            append2.println(new StringBuilder(String.valueOf(format2).length() + 21).append(j2).append(" ").append(format2).toString());
        }
        if (this.zzfvx > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.zzfvw));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j3 = this.zzfvx;
            String format3 = simpleDateFormat.format(new Date(this.zzfvx));
            append3.println(new StringBuilder(String.valueOf(format3).length() + 21).append(j3).append(" ").append(format3).toString());
        }
    }

    public Account getAccount() {
        return null;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zzakm;
    }

    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public final boolean isConnected() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzfwg == 4;
        }
        return z;
    }

    public final boolean isConnecting() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzfwg == 2 || this.zzfwg == 3;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzfvw = connectionResult.getErrorCode();
        this.zzfvx = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void onConnectionSuspended(int i) {
        this.zzfvt = i;
        this.zzfvu = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public final void zza(int i, @Nullable Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(7, i2, -1, new zzo(this, i, (Bundle) null)));
    }

    /* access modifiers changed from: protected */
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i2, -1, new zzn(this, i, iBinder, bundle)));
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void zza(@NonNull T t) {
        this.zzfvv = System.currentTimeMillis();
    }

    @WorkerThread
    public final void zza(zzan zzan, Set<Scope> set) {
        Bundle zzaae = zzaae();
        zzz zzz = new zzz(this.zzfwj);
        zzz.zzfxj = this.mContext.getPackageName();
        zzz.zzfxm = zzaae;
        if (set != null) {
            zzz.zzfxl = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (zzaan()) {
            zzz.zzfxn = getAccount() != null ? getAccount() : new Account("<<default account>>", "com.google");
            if (zzan != null) {
                zzz.zzfxk = zzan.asBinder();
            }
        } else if (zzakd()) {
            zzz.zzfxn = getAccount();
        }
        zzz.zzfxo = zzaka();
        try {
            synchronized (this.zzfwa) {
                if (this.zzfwb != null) {
                    this.zzfwb.zza(new zzk(this, this.zzfwn.get()), zzz);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            zzcf(1);
        } catch (SecurityException e2) {
            throw e2;
        } catch (RemoteException | RuntimeException e3) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e3);
            zza(8, (IBinder) null, (Bundle) null, this.zzfwn.get());
        }
    }

    public void zza(@NonNull zzj zzj) {
        this.zzfwc = (zzj) zzbq.checkNotNull(zzj, "Connection progress callbacks cannot be null.");
        zza(2, (IInterface) null);
    }

    /* access modifiers changed from: protected */
    public final void zza(@NonNull zzj zzj, int i, @Nullable PendingIntent pendingIntent) {
        this.zzfwc = (zzj) zzbq.checkNotNull(zzj, "Connection progress callbacks cannot be null.");
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzfwn.get(), i, pendingIntent));
    }

    public void zza(@NonNull zzp zzp) {
        zzp.zzaiu();
    }

    /* access modifiers changed from: protected */
    public Bundle zzaae() {
        return new Bundle();
    }

    public boolean zzaan() {
        return false;
    }

    public boolean zzaax() {
        return false;
    }

    public Bundle zzaex() {
        return null;
    }

    public boolean zzafv() {
        return true;
    }

    @Nullable
    public final IBinder zzafw() {
        IBinder asBinder;
        synchronized (this.zzfwa) {
            asBinder = this.zzfwb == null ? null : this.zzfwb.asBinder();
        }
        return asBinder;
    }

    /* access modifiers changed from: protected */
    public String zzajw() {
        return "com.google.android.gms";
    }

    public final void zzajy() {
        int isGooglePlayServicesAvailable = this.zzfns.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            zza(1, (IInterface) null);
            zza((zzj) new zzm(this), isGooglePlayServicesAvailable, (PendingIntent) null);
            return;
        }
        zza((zzj) new zzm(this));
    }

    public zzc[] zzaka() {
        return new zzc[0];
    }

    /* access modifiers changed from: protected */
    public final void zzakb() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T zzakc() throws DeadObjectException {
        T t;
        synchronized (this.mLock) {
            if (this.zzfwg == 5) {
                throw new DeadObjectException();
            }
            zzakb();
            zzbq.zza(this.zzfwd != null, (Object) "Client is connected but service is null");
            t = this.zzfwd;
        }
        return t;
    }

    public boolean zzakd() {
        return false;
    }

    /* access modifiers changed from: protected */
    public Set<Scope> zzake() {
        return Collections.EMPTY_SET;
    }

    public final void zzcf(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(6, this.zzfwn.get(), i));
    }

    /* access modifiers changed from: protected */
    @Nullable
    public abstract T zzd(IBinder iBinder);

    /* access modifiers changed from: protected */
    @NonNull
    public abstract String zzhf();

    /* access modifiers changed from: protected */
    @NonNull
    public abstract String zzhg();
}
