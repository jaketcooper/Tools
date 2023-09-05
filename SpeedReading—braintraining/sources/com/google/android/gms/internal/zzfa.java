package com.google.android.gms.internal;

import org.json.JSONObject;

@zzzb
public final class zzfa {
    private final String zzaup;
    private final JSONObject zzauq;
    private final String zzaur;
    private final String zzaus;
    private final boolean zzaut;
    private final boolean zzauu;

    public zzfa(String str, zzaiy zzaiy, String str2, JSONObject jSONObject, boolean z, boolean z2) {
        this.zzaus = zzaiy.zzcp;
        this.zzauq = jSONObject;
        this.zzaur = str;
        this.zzaup = str2;
        this.zzaut = z;
        this.zzauu = z2;
    }

    public final String zzfn() {
        return this.zzaup;
    }

    public final String zzfo() {
        return this.zzaus;
    }

    public final JSONObject zzfp() {
        return this.zzauq;
    }

    public final String zzfq() {
        return this.zzaur;
    }

    public final boolean zzfr() {
        return this.zzaut;
    }

    public final boolean zzfs() {
        return this.zzauu;
    }
}
