package com.safonov.speedreading.application.ratedialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.p003v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.speedreading.alexander.speedreading.R;

public class RateDialog {
    private static final String DIALOG_LAUNCH_TIMES = "dialog_launch_times";
    private static final String DONT_SHOW_AGAIN_KEY = "dont_show_again";
    private static final String RATE_APP_DIALOG_SHARED_PREFERENCES = "rate_app_dialog";
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public AlertDialog dialog;
    private final int neededLaunchTimes;
    /* access modifiers changed from: private */
    public final SharedPreferences sharedPreferences;

    public RateDialog(Context context2) {
        this.context = context2;
        this.sharedPreferences = context2.getSharedPreferences(RATE_APP_DIALOG_SHARED_PREFERENCES, 0);
        this.neededLaunchTimes = context2.getResources().getInteger(R.integer.rate_app_dialog_launch_times);
    }

    public boolean isShouldShow() {
        if (this.sharedPreferences.getBoolean(DONT_SHOW_AGAIN_KEY, false)) {
            return false;
        }
        int dialogLaunchCount = this.sharedPreferences.getInt(DIALOG_LAUNCH_TIMES, 0) + 1;
        if (dialogLaunchCount >= this.neededLaunchTimes) {
            return true;
        }
        this.sharedPreferences.edit().putInt(DIALOG_LAUNCH_TIMES, dialogLaunchCount).apply();
        return false;
    }

    public void show() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        View rateDialog = LayoutInflater.from(this.context).inflate(R.layout.rate_app_dialog, (ViewGroup) null);
        ((Button) rateDialog.findViewById(R.id.rate_app_dialog_rate_now)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RateDialog.this.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + RateDialog.this.context.getPackageName())));
                RateDialog.this.sharedPreferences.edit().putBoolean(RateDialog.DONT_SHOW_AGAIN_KEY, true).apply();
                RateDialog.this.dialog.dismiss();
            }
        });
        ((Button) rateDialog.findViewById(R.id.rate_app_dialog_dont_show_again)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RateDialog.this.sharedPreferences.edit().putBoolean(RateDialog.DONT_SHOW_AGAIN_KEY, true).apply();
                RateDialog.this.dialog.dismiss();
            }
        });
        ((Button) rateDialog.findViewById(R.id.rate_app_dialog_remind_me_later)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RateDialog.this.dialog.dismiss();
            }
        });
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialog) {
                RateDialog.this.sharedPreferences.edit().putInt(RateDialog.DIALOG_LAUNCH_TIMES, 0).apply();
            }
        });
        builder.setView(rateDialog);
        this.dialog = builder.create();
        this.dialog.show();
    }
}
