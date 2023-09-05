package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.zzv;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

final class zzab {
    private Context zzaif;
    final SharedPreferences zzids;

    public zzab(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    private zzab(Context context, String str) {
        this.zzaif = context;
        this.zzids = context.getSharedPreferences(str, 0);
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("-no-backup");
        File file = new File(zzv.getNoBackupFilesDir(this.zzaif), valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !isEmpty()) {
                    Log.i("InstanceID/Store", "App restored, clearing state");
                    zzauy();
                    zzi.zza(this.zzaif, (Bundle) null).zzche();
                }
            } catch (IOException e) {
                if (Log.isLoggable("InstanceID/Store", 3)) {
                    String valueOf3 = String.valueOf(e.getMessage());
                    Log.d("InstanceID/Store", valueOf3.length() != 0 ? "Error creating file in no backup dir: ".concat(valueOf3) : new String("Error creating file in no backup dir: "));
                }
            }
        }
    }

    private static String zzbm(String str, String str2) {
        return new StringBuilder(String.valueOf(str).length() + String.valueOf("|S|").length() + String.valueOf(str2).length()).append(str).append("|S|").append(str2).toString();
    }

    private final void zzhu(String str) {
        SharedPreferences.Editor edit = this.zzids.edit();
        for (String next : this.zzids.getAll().keySet()) {
            if (next.startsWith(str)) {
                edit.remove(next);
            }
        }
        edit.commit();
    }

    private static String zzn(String str, String str2, String str3) {
        return new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf("|T|").length() + String.valueOf(str2).length() + String.valueOf(str3).length()).append(str).append("|T|").append(str2).append("|").append(str3).toString();
    }

    public final synchronized boolean isEmpty() {
        return this.zzids.getAll().isEmpty();
    }

    public final synchronized void zza(String str, String str2, String str3, String str4, String str5) {
        String zzc = zzac.zzc(str4, str5, System.currentTimeMillis());
        if (zzc != null) {
            SharedPreferences.Editor edit = this.zzids.edit();
            edit.putString(zzn(str, str2, str3), zzc);
            edit.commit();
        }
    }

    public final synchronized void zzauy() {
        this.zzids.edit().clear().commit();
    }

    public final synchronized void zzf(String str, String str2, String str3) {
        String zzn = zzn(str, str2, str3);
        SharedPreferences.Editor edit = this.zzids.edit();
        edit.remove(zzn);
        edit.commit();
    }

    public final synchronized void zzhv(String str) {
        zzhu(String.valueOf(str).concat("|T|"));
    }

    public final synchronized zzac zzo(String str, String str2, String str3) {
        return zzac.zzqy(this.zzids.getString(zzn(str, str2, str3), (String) null));
    }

    public final synchronized long zzqu(String str) {
        long j;
        String string = this.zzids.getString(zzbm(str, "cre"), (String) null);
        if (string != null) {
            try {
                j = Long.parseLong(string);
            } catch (NumberFormatException e) {
            }
        }
        j = 0;
        return j;
    }

    /* access modifiers changed from: package-private */
    public final synchronized KeyPair zzqv(String str) {
        KeyPair zzaur;
        zzaur = zza.zzaur();
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = this.zzids.edit();
        edit.putString(zzbm(str, "|P|"), FirebaseInstanceId.zzn(zzaur.getPublic().getEncoded()));
        edit.putString(zzbm(str, "|K|"), FirebaseInstanceId.zzn(zzaur.getPrivate().getEncoded()));
        edit.putString(zzbm(str, "cre"), Long.toString(currentTimeMillis));
        edit.commit();
        return zzaur;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzqw(String str) {
        zzhu(String.valueOf(str).concat("|"));
    }

    public final synchronized KeyPair zzqx(String str) {
        KeyPair keyPair;
        String string = this.zzids.getString(zzbm(str, "|P|"), (String) null);
        String string2 = this.zzids.getString(zzbm(str, "|K|"), (String) null);
        if (string == null || string2 == null) {
            keyPair = null;
        } else {
            try {
                byte[] decode = Base64.decode(string, 8);
                byte[] decode2 = Base64.decode(string2, 8);
                KeyFactory instance = KeyFactory.getInstance("RSA");
                keyPair = new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                String valueOf = String.valueOf(e);
                Log.w("InstanceID/Store", new StringBuilder(String.valueOf(valueOf).length() + 19).append("Invalid key stored ").append(valueOf).toString());
                zzi.zza(this.zzaif, (Bundle) null).zzche();
                keyPair = null;
            }
        }
        return keyPair;
    }
}
