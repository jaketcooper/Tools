package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@zzzb
public final class zzlc {
    private final boolean zzals;
    private final int zzbcm;
    private final int zzbcp;
    private final String zzbcq;
    private final String zzbcs;
    private final Bundle zzbcu;
    private final String zzbcw;
    private final boolean zzbcy;
    private final Bundle zzbef;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzbeg;
    private final SearchAdRequest zzbeh;
    private final Set<String> zzbei;
    private final Set<String> zzbej;
    private final Date zzha;
    private final Set<String> zzhc;
    private final Location zzhe;

    public zzlc(zzld zzld) {
        this(zzld, (SearchAdRequest) null);
    }

    public zzlc(zzld zzld, SearchAdRequest searchAdRequest) {
        this.zzha = zzld.zzha;
        this.zzbcs = zzld.zzbcs;
        this.zzbcm = zzld.zzbcm;
        this.zzhc = Collections.unmodifiableSet(zzld.zzbek);
        this.zzhe = zzld.zzhe;
        this.zzals = zzld.zzals;
        this.zzbef = zzld.zzbef;
        this.zzbeg = Collections.unmodifiableMap(zzld.zzbel);
        this.zzbcq = zzld.zzbcq;
        this.zzbcw = zzld.zzbcw;
        this.zzbeh = searchAdRequest;
        this.zzbcp = zzld.zzbcp;
        this.zzbei = Collections.unmodifiableSet(zzld.zzbem);
        this.zzbcu = zzld.zzbcu;
        this.zzbej = Collections.unmodifiableSet(zzld.zzben);
        this.zzbcy = zzld.zzbcy;
    }

    public final Date getBirthday() {
        return this.zzha;
    }

    public final String getContentUrl() {
        return this.zzbcs;
    }

    public final Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.zzbef.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final Bundle getCustomTargeting() {
        return this.zzbcu;
    }

    public final int getGender() {
        return this.zzbcm;
    }

    public final Set<String> getKeywords() {
        return this.zzhc;
    }

    public final Location getLocation() {
        return this.zzhe;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzals;
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (NetworkExtras) this.zzbeg.get(cls);
    }

    public final Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> cls) {
        return this.zzbef.getBundle(cls.getName());
    }

    public final String getPublisherProvidedId() {
        return this.zzbcq;
    }

    public final boolean isDesignedForFamilies() {
        return this.zzbcy;
    }

    public final boolean isTestDevice(Context context) {
        Set<String> set = this.zzbei;
        zzjk.zzhx();
        return set.contains(zzais.zzbb(context));
    }

    public final String zzie() {
        return this.zzbcw;
    }

    public final SearchAdRequest zzif() {
        return this.zzbeh;
    }

    public final Map<Class<? extends NetworkExtras>, NetworkExtras> zzig() {
        return this.zzbeg;
    }

    public final Bundle zzih() {
        return this.zzbef;
    }

    public final int zzii() {
        return this.zzbcp;
    }

    public final Set<String> zzij() {
        return this.zzbej;
    }
}
