package com.google.firebase.iid;

import android.content.Intent;

final class zzc implements Runnable {
    private /* synthetic */ Intent val$intent;
    private /* synthetic */ Intent zzicg;
    private /* synthetic */ zzb zznud;

    zzc(zzb zzb, Intent intent, Intent intent2) {
        this.zznud = zzb;
        this.val$intent = intent;
        this.zzicg = intent2;
    }

    public final void run() {
        this.zznud.handleIntent(this.val$intent);
        this.zznud.zzh(this.zzicg);
    }
}
