package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;

public final class zzcs {
    private static final String[] zzahs = {"/aclk", "/pcs/click"};
    private String zzaho = "googleads.g.doubleclick.net";
    private String zzahp = "/pagead/ads";
    private String zzahq = "ad.doubleclick.net";
    private String[] zzahr = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private zzco zzaht;

    public zzcs(zzco zzco) {
        this.zzaht = zzco;
    }

    private final Uri zza(Uri uri, Context context, String str, boolean z, View view) throws zzct {
        try {
            boolean zza = zza(uri);
            if (zza) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzct("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new zzct("Query parameter already exists: ms");
            }
            String zza2 = z ? this.zzaht.zza(context, str, view) : this.zzaht.zza(context);
            if (zza) {
                String uri2 = uri.toString();
                int indexOf = uri2.indexOf(";adurl");
                if (indexOf != -1) {
                    return Uri.parse(uri2.substring(0, indexOf + 1) + "dc_ms" + "=" + zza2 + ";" + uri2.substring(indexOf + 1));
                }
                String encodedPath = uri.getEncodedPath();
                int indexOf2 = uri2.indexOf(encodedPath);
                return Uri.parse(uri2.substring(0, encodedPath.length() + indexOf2) + ";" + "dc_ms" + "=" + zza2 + ";" + uri2.substring(encodedPath.length() + indexOf2));
            }
            String uri3 = uri.toString();
            int indexOf3 = uri3.indexOf("&adurl");
            if (indexOf3 == -1) {
                indexOf3 = uri3.indexOf("?adurl");
            }
            return indexOf3 != -1 ? Uri.parse(uri3.substring(0, indexOf3 + 1) + "ms" + "=" + zza2 + "&" + uri3.substring(indexOf3 + 1)) : uri.buildUpon().appendQueryParameter("ms", zza2).build();
        } catch (UnsupportedOperationException e) {
            throw new zzct("Provided Uri is not in a valid state");
        }
    }

    private final boolean zza(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.zzahq);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public final Uri zza(Uri uri, Context context) throws zzct {
        return zza(uri, context, (String) null, false, (View) null);
    }

    public final Uri zza(Uri uri, Context context, View view) throws zzct {
        try {
            return zza(uri, context, uri.getQueryParameter("ai"), true, view);
        } catch (UnsupportedOperationException e) {
            throw new zzct("Provided Uri is not in a valid state");
        }
    }

    public final void zza(MotionEvent motionEvent) {
        this.zzaht.zza(motionEvent);
    }

    public final zzco zzad() {
        return this.zzaht;
    }

    public final boolean zzb(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.zzahr) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public final boolean zzc(Uri uri) {
        if (!zzb(uri)) {
            return false;
        }
        for (String endsWith : zzahs) {
            if (uri.getPath().endsWith(endsWith)) {
                return true;
            }
        }
        return false;
    }
}
