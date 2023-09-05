package com.google.android.gms.common.api;

import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Result;

public class Response<T extends Result> {
    private T zzfku;

    public Response() {
    }

    protected Response(@NonNull T t) {
        this.zzfku = t;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public T getResult() {
        return this.zzfku;
    }

    public void setResult(@NonNull T t) {
        this.zzfku = t;
    }
}
