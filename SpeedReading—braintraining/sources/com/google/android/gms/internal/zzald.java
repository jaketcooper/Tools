package com.google.android.gms.internal;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import org.mozilla.universalchardet.prober.contextanalysis.SJISContextAnalysis;

@zzzb
final class zzald implements SensorEventListener {
    private final SensorManager zzdfd;
    private final Object zzdfe = new Object();
    private final Display zzdff;
    private final float[] zzdfg = new float[9];
    private final float[] zzdfh = new float[9];
    private float[] zzdfi;
    private Handler zzdfj;
    private zzalf zzdfk;

    zzald(Context context) {
        this.zzdfd = (SensorManager) context.getSystemService("sensor");
        this.zzdff = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    private final void zzg(int i, int i2) {
        float f = this.zzdfh[i];
        this.zzdfh[i] = this.zzdfh[i2];
        this.zzdfh[i2] = f;
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] != 0.0f || fArr[1] != 0.0f || fArr[2] != 0.0f) {
            synchronized (this.zzdfe) {
                if (this.zzdfi == null) {
                    this.zzdfi = new float[9];
                }
            }
            SensorManager.getRotationMatrixFromVector(this.zzdfg, fArr);
            switch (this.zzdff.getRotation()) {
                case 1:
                    SensorManager.remapCoordinateSystem(this.zzdfg, 2, 129, this.zzdfh);
                    break;
                case 2:
                    SensorManager.remapCoordinateSystem(this.zzdfg, 129, SJISContextAnalysis.HIRAGANA_HIGHBYTE, this.zzdfh);
                    break;
                case 3:
                    SensorManager.remapCoordinateSystem(this.zzdfg, SJISContextAnalysis.HIRAGANA_HIGHBYTE, 1, this.zzdfh);
                    break;
                default:
                    System.arraycopy(this.zzdfg, 0, this.zzdfh, 0, 9);
                    break;
            }
            zzg(1, 3);
            zzg(2, 6);
            zzg(5, 7);
            synchronized (this.zzdfe) {
                System.arraycopy(this.zzdfh, 0, this.zzdfi, 0, 9);
            }
            if (this.zzdfk != null) {
                this.zzdfk.zzms();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void start() {
        if (this.zzdfj == null) {
            Sensor defaultSensor = this.zzdfd.getDefaultSensor(11);
            if (defaultSensor == null) {
                zzafj.m12e("No Sensor of TYPE_ROTATION_VECTOR");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
            handlerThread.start();
            this.zzdfj = new Handler(handlerThread.getLooper());
            if (!this.zzdfd.registerListener(this, defaultSensor, 0, this.zzdfj)) {
                zzafj.m12e("SensorManager.registerListener failed.");
                stop();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void stop() {
        if (this.zzdfj != null) {
            this.zzdfd.unregisterListener(this);
            this.zzdfj.post(new zzale(this));
            this.zzdfj = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzalf zzalf) {
        this.zzdfk = zzalf;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(float[] fArr) {
        boolean z = false;
        synchronized (this.zzdfe) {
            if (this.zzdfi != null) {
                System.arraycopy(this.zzdfi, 0, fArr, 0, this.zzdfi.length);
                z = true;
            }
        }
        return z;
    }
}
