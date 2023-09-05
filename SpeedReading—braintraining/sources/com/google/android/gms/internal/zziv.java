package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zzzb
public final class zziv {
    public static final zziv zzbcz = new zziv();

    protected zziv() {
    }

    public static zzis zza(Context context, zzlc zzlc) {
        Date birthday = zzlc.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1;
        String contentUrl = zzlc.getContentUrl();
        int gender = zzlc.getGender();
        Set<String> keywords = zzlc.getKeywords();
        List unmodifiableList = !keywords.isEmpty() ? Collections.unmodifiableList(new ArrayList(keywords)) : null;
        boolean isTestDevice = zzlc.isTestDevice(context);
        int zzii = zzlc.zzii();
        Location location = zzlc.getLocation();
        Bundle networkExtrasBundle = zzlc.getNetworkExtrasBundle(AdMobAdapter.class);
        boolean manualImpressionsEnabled = zzlc.getManualImpressionsEnabled();
        String publisherProvidedId = zzlc.getPublisherProvidedId();
        SearchAdRequest zzif = zzlc.zzif();
        zzlw zzlw = zzif != null ? new zzlw(zzif) : null;
        String str = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzjk.zzhx();
            str = zzais.zza(Thread.currentThread().getStackTrace(), packageName);
        }
        return new zzis(7, time, networkExtrasBundle, gender, unmodifiableList, isTestDevice, zzii, manualImpressionsEnabled, publisherProvidedId, zzlw, location, contentUrl, zzlc.zzih(), zzlc.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(zzlc.zzij())), zzlc.zzie(), str, zzlc.isDesignedForFamilies());
    }
}
