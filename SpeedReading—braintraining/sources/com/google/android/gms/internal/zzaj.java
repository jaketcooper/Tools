package com.google.android.gms.internal;

import com.safonov.speedreading.training.fragment.truecolors.training.presenter.TrueColorsPresenter;
import java.io.IOException;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public final class zzaj implements zzam {
    private HttpClient zzca;

    public zzaj(HttpClient httpClient) {
        this.zzca = httpClient;
    }

    private static void zza(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, zzp<?> zzp) throws zza {
        byte[] zzg = zzp.zzg();
        if (zzg != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(zzg));
        }
    }

    private static void zza(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String next : map.keySet()) {
            httpUriRequest.setHeader(next, map.get(next));
        }
    }

    public final HttpResponse zza(zzp<?> zzp, Map<String, String> map) throws IOException, zza {
        HttpGet zzak;
        switch (zzp.getMethod()) {
            case -1:
                zzak = new HttpGet(zzp.getUrl());
                break;
            case 0:
                zzak = new HttpGet(zzp.getUrl());
                break;
            case 1:
                zzak = new HttpPost(zzp.getUrl());
                zzak.addHeader("Content-Type", zzp.zzf());
                zza((HttpEntityEnclosingRequestBase) zzak, zzp);
                break;
            case 2:
                zzak = new HttpPut(zzp.getUrl());
                zzak.addHeader("Content-Type", zzp.zzf());
                zza((HttpEntityEnclosingRequestBase) zzak, zzp);
                break;
            case 3:
                zzak = new HttpDelete(zzp.getUrl());
                break;
            case 4:
                zzak = new HttpHead(zzp.getUrl());
                break;
            case 5:
                zzak = new HttpOptions(zzp.getUrl());
                break;
            case 6:
                zzak = new HttpTrace(zzp.getUrl());
                break;
            case 7:
                zzak = new zzak(zzp.getUrl());
                zzak.addHeader("Content-Type", zzp.zzf());
                zza((HttpEntityEnclosingRequestBase) zzak, zzp);
                break;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
        zza((HttpUriRequest) zzak, map);
        zza((HttpUriRequest) zzak, zzp.getHeaders());
        HttpParams params = zzak.getParams();
        int zzi = zzp.zzi();
        HttpConnectionParams.setConnectionTimeout(params, TrueColorsPresenter.DEFAULT_LEVEL_DURATION);
        HttpConnectionParams.setSoTimeout(params, zzi);
        return this.zzca.execute(zzak);
    }
}
