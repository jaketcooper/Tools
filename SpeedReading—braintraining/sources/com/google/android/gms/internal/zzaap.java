package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.util.zzn;
import java.io.DataInputStream;
import java.io.IOException;

@zzzb
public final class zzaap extends zzbej {
    public static final Parcelable.Creator<zzaap> CREATOR = new zzaar();
    private ParcelFileDescriptor zzcoi;
    private Parcelable zzcoj;
    private boolean zzcok;

    public zzaap(ParcelFileDescriptor parcelFileDescriptor) {
        this.zzcoi = parcelFileDescriptor;
        this.zzcoj = null;
        this.zzcok = true;
    }

    public zzaap(zzben zzben) {
        this.zzcoi = null;
        this.zzcoj = zzben;
        this.zzcok = false;
    }

    private final <T> ParcelFileDescriptor zze(byte[] bArr) {
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(createPipe[1]);
            try {
                new Thread(new zzaaq(this, autoCloseOutputStream, bArr)).start();
                return createPipe[0];
            } catch (IOException e) {
                e = e;
            }
        } catch (IOException e2) {
            e = e2;
            autoCloseOutputStream = null;
            zzafj.zzb("Error transporting the ad response", e);
            zzbs.zzeg().zza((Throwable) e, "LargeParcelTeleporter.pipeData.2");
            zzn.closeQuietly(autoCloseOutputStream);
            return null;
        }
    }

    /* JADX INFO: finally extract failed */
    private final ParcelFileDescriptor zznh() {
        if (this.zzcoi == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.zzcoj.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                this.zzcoi = zze(marshall);
            } catch (Throwable th) {
                obtain.recycle();
                throw th;
            }
        }
        return this.zzcoi;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        zznh();
        int zze = zzbem.zze(parcel);
        zzbem.zza(parcel, 2, (Parcelable) this.zzcoi, i, false);
        zzbem.zzai(parcel, zze);
    }

    /* JADX INFO: finally extract failed */
    public final <T extends zzben> T zza(Parcelable.Creator<T> creator) {
        if (this.zzcok) {
            if (this.zzcoi == null) {
                zzafj.m12e("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.zzcoi));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr, 0, bArr.length);
                zzn.closeQuietly(dataInputStream);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.unmarshall(bArr, 0, bArr.length);
                    obtain.setDataPosition(0);
                    this.zzcoj = (zzben) creator.createFromParcel(obtain);
                    obtain.recycle();
                    this.zzcok = false;
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            } catch (IOException e) {
                zzafj.zzb("Could not read from parcel file descriptor", e);
                zzn.closeQuietly(dataInputStream);
                return null;
            } catch (Throwable th2) {
                zzn.closeQuietly(dataInputStream);
                throw th2;
            }
        }
        return (zzben) this.zzcoj;
    }
}
