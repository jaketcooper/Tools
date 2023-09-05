package com.google.android.gms.ads.mediation;

import android.os.Bundle;

public interface MediationAdapter {

    public static class zza {
        private int zzdkv;

        public final zza zzah(int i) {
            this.zzdkv = 1;
            return this;
        }

        public final Bundle zztz() {
            Bundle bundle = new Bundle();
            bundle.putInt("capabilities", this.zzdkv);
            return bundle;
        }
    }

    void onDestroy();

    void onPause();

    void onResume();
}
