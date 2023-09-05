package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.C0555R;
import com.google.android.gms.ads.internal.zzbs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.safonov.speedreading.reader.repository.dao.bookdescriptiondao.sqlliteimpl.BookDescriptionDatabaseHelper;
import java.util.Map;

@zzzb
public final class zzvt extends zzwg {
    /* access modifiers changed from: private */
    public final Context mContext;
    private final Map<String, String> zzbqw;
    private String zzcep = zzbj("description");
    private long zzceq = zzbk("start_ticks");
    private long zzcer = zzbk("end_ticks");
    private String zzces = zzbj("summary");
    private String zzcet = zzbj(FirebaseAnalytics.Param.LOCATION);

    public zzvt(zzama zzama, Map<String, String> map) {
        super(zzama, "createCalendarEvent");
        this.zzbqw = map;
        this.mContext = zzama.zzrz();
    }

    private final String zzbj(String str) {
        return TextUtils.isEmpty(this.zzbqw.get(str)) ? "" : this.zzbqw.get(str);
    }

    private final long zzbk(String str) {
        String str2 = this.zzbqw.get(str);
        if (str2 == null) {
            return -1;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(14)
    public final Intent createIntent() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra(BookDescriptionDatabaseHelper.BOOK_TITLE, this.zzcep);
        data.putExtra("eventLocation", this.zzcet);
        data.putExtra("description", this.zzces);
        if (this.zzceq > -1) {
            data.putExtra("beginTime", this.zzceq);
        }
        if (this.zzcer > -1) {
            data.putExtra("endTime", this.zzcer);
        }
        data.setFlags(268435456);
        return data;
    }

    public final void execute() {
        if (this.mContext == null) {
            zzbl("Activity context is not available.");
            return;
        }
        zzbs.zzec();
        if (!zzagr.zzak(this.mContext).zzio()) {
            zzbl("This feature is not available on the device.");
            return;
        }
        zzbs.zzec();
        AlertDialog.Builder zzaj = zzagr.zzaj(this.mContext);
        Resources resources = zzbs.zzeg().getResources();
        zzaj.setTitle(resources != null ? resources.getString(C0555R.string.f81s5) : "Create calendar event");
        zzaj.setMessage(resources != null ? resources.getString(C0555R.string.f82s6) : "Allow Ad to create a calendar event?");
        zzaj.setPositiveButton(resources != null ? resources.getString(C0555R.string.f79s3) : "Accept", new zzvu(this));
        zzaj.setNegativeButton(resources != null ? resources.getString(C0555R.string.f80s4) : "Decline", new zzvv(this));
        zzaj.create().show();
    }
}
