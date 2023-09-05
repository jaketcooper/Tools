package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.support.annotation.BinderThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

public final class zzn extends zze {
    private /* synthetic */ zzd zzfwq;
    private IBinder zzfwu;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @BinderThread
    public zzn(zzd zzd, int i, IBinder iBinder, Bundle bundle) {
        super(zzd, i, bundle);
        this.zzfwq = zzd;
        this.zzfwu = iBinder;
    }

    /* access modifiers changed from: protected */
    public final boolean zzakg() {
        try {
            String interfaceDescriptor = this.zzfwu.getInterfaceDescriptor();
            if (!this.zzfwq.zzhg().equals(interfaceDescriptor)) {
                String zzhg = this.zzfwq.zzhg();
                Log.e("GmsClient", new StringBuilder(String.valueOf(zzhg).length() + 34 + String.valueOf(interfaceDescriptor).length()).append("service descriptor mismatch: ").append(zzhg).append(" vs. ").append(interfaceDescriptor).toString());
                return false;
            }
            IInterface zzd = this.zzfwq.zzd(this.zzfwu);
            if (zzd == null) {
                return false;
            }
            if (!this.zzfwq.zza(2, 4, zzd) && !this.zzfwq.zza(3, 4, zzd)) {
                return false;
            }
            ConnectionResult unused = this.zzfwq.zzfwl = null;
            Bundle zzaex = this.zzfwq.zzaex();
            if (this.zzfwq.zzfwh != null) {
                this.zzfwq.zzfwh.onConnected(zzaex);
            }
            return true;
        } catch (RemoteException e) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzj(ConnectionResult connectionResult) {
        if (this.zzfwq.zzfwi != null) {
            this.zzfwq.zzfwi.onConnectionFailed(connectionResult);
        }
        this.zzfwq.onConnectionFailed(connectionResult);
    }
}
