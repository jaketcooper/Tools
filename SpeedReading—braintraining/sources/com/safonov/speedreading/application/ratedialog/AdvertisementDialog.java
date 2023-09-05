package com.safonov.speedreading.application.ratedialog;

import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.support.p003v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.speedreading.alexander.speedreading.R;
import java.util.Locale;

public class AdvertisementDialog {
    private static final String ADVERTISEMENT_DIALOG_SHARED_PREFERENCES = "advertisement_russian_dialog";
    private static final String DIALOG_LAUNCH_TIMES = "launch_times";
    private static final int NEEDED_LAUNCH_TIMES = 4;
    private static final String SHOULD_SHOW_KEY = "should_show";
    private static final String appId = "com.greenkeycompany.exam";
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public AlertDialog dialog;
    /* access modifiers changed from: private */
    public final SharedPreferences sharedPreferences;

    public boolean isShouldShow() {
        if (!this.sharedPreferences.getBoolean(SHOULD_SHOW_KEY, true)) {
            return false;
        }
        int dialogLaunchCount = this.sharedPreferences.getInt(DIALOG_LAUNCH_TIMES, 0) + 1;
        if (dialogLaunchCount < 4) {
            this.sharedPreferences.edit().putInt(DIALOG_LAUNCH_TIMES, dialogLaunchCount).apply();
            return false;
        } else if (isRussianLocale()) {
            return true;
        } else {
            return false;
        }
    }

    public AdvertisementDialog(Context context2) {
        this.context = context2;
        this.sharedPreferences = context2.getSharedPreferences(ADVERTISEMENT_DIALOG_SHARED_PREFERENCES, 0);
    }

    @TargetApi(24)
    private Locale getCurrentLocale() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.context.getResources().getConfiguration().getLocales().get(0);
        }
        return this.context.getResources().getConfiguration().locale;
    }

    private boolean isRussianLocale() {
        return getCurrentLocale().getLanguage().equals("ru") || getCurrentLocale().getLanguage().equals("ua");
    }

    public void show() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        View rateDialog = LayoutInflater.from(this.context).inflate(R.layout.ad_russian_dialog, (ViewGroup) null);
        ((Button) rateDialog.findViewById(R.id.show_market_view)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    AdvertisementDialog.this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://com.greenkeycompany.exam")));
                } catch (ActivityNotFoundException e) {
                    AdvertisementDialog.this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.greenkeycompany.exam")));
                }
                AdvertisementDialog.this.dialog.dismiss();
            }
        });
        ((Button) rateDialog.findViewById(R.id.close_dialog_view)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AdvertisementDialog.this.dialog.dismiss();
            }
        });
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialog) {
                AdvertisementDialog.this.sharedPreferences.edit().putBoolean(AdvertisementDialog.SHOULD_SHOW_KEY, false).apply();
            }
        });
        builder.setView(rateDialog);
        this.dialog = builder.create();
        this.dialog.show();
    }
}
