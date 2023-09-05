package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import com.google.android.gms.ads.internal.zzbs;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

@zzzb
@TargetApi(14)
public final class zzalg extends Thread implements SurfaceTexture.OnFrameAvailableListener, zzalf {
    private static final float[] zzdfl = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private int zzakw;
    private int zzakx;
    private final float[] zzdfi;
    private final zzald zzdfm;
    private final float[] zzdfn;
    private final float[] zzdfo;
    private final float[] zzdfp;
    private final float[] zzdfq;
    private final float[] zzdfr;
    private final float[] zzdfs;
    private float zzdft;
    private float zzdfu;
    private float zzdfv;
    private SurfaceTexture zzdfw;
    private SurfaceTexture zzdfx;
    private int zzdfy;
    private int zzdfz;
    private int zzdga;
    private FloatBuffer zzdgb = ByteBuffer.allocateDirect(zzdfl.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private final CountDownLatch zzdgc;
    private final Object zzdgd;
    private EGL10 zzdge;
    private EGLDisplay zzdgf;
    private EGLContext zzdgg;
    private EGLSurface zzdgh;
    private volatile boolean zzdgi;
    private volatile boolean zzdgj;

    public zzalg(Context context) {
        super("SphericalVideoProcessor");
        this.zzdgb.put(zzdfl).position(0);
        this.zzdfi = new float[9];
        this.zzdfn = new float[9];
        this.zzdfo = new float[9];
        this.zzdfp = new float[9];
        this.zzdfq = new float[9];
        this.zzdfr = new float[9];
        this.zzdfs = new float[9];
        this.zzdft = Float.NaN;
        this.zzdfm = new zzald(context);
        this.zzdfm.zza((zzalf) this);
        this.zzdgc = new CountDownLatch(1);
        this.zzdgd = new Object();
    }

    private static void zza(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = (float) Math.cos((double) f);
        fArr[5] = (float) (-Math.sin((double) f));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin((double) f);
        fArr[8] = (float) Math.cos((double) f);
    }

    private static void zza(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3]) + (fArr2[2] * fArr3[6]);
        fArr[1] = (fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4]) + (fArr2[2] * fArr3[7]);
        fArr[2] = (fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5]) + (fArr2[2] * fArr3[8]);
        fArr[3] = (fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3]) + (fArr2[5] * fArr3[6]);
        fArr[4] = (fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4]) + (fArr2[5] * fArr3[7]);
        fArr[5] = (fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5]) + (fArr2[5] * fArr3[8]);
        fArr[6] = (fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3]) + (fArr2[8] * fArr3[6]);
        fArr[7] = (fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4]) + (fArr2[8] * fArr3[7]);
        fArr[8] = (fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5]) + (fArr2[8] * fArr3[8]);
    }

    private static void zzb(float[] fArr, float f) {
        fArr[0] = (float) Math.cos((double) f);
        fArr[1] = (float) (-Math.sin((double) f));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin((double) f);
        fArr[4] = (float) Math.cos((double) f);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private static void zzcq(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("SphericalVideoRenderer", new StringBuilder(String.valueOf(str).length() + 21).append(str).append(": glError ").append(glGetError).toString());
        }
    }

    private static int zzd(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        zzcq("createShader");
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            zzcq("shaderSource");
            GLES20.glCompileShader(glCreateShader);
            zzcq("compileShader");
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            zzcq("getShaderiv");
            if (iArr[0] == 0) {
                Log.e("SphericalVideoRenderer", new StringBuilder(37).append("Could not compile shader ").append(i).append(":").toString());
                Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                zzcq("deleteShader");
                return 0;
            }
        }
        return glCreateShader;
    }

    private final void zzru() {
        while (this.zzdga > 0) {
            this.zzdfw.updateTexImage();
            this.zzdga--;
        }
        if (this.zzdfm.zza(this.zzdfi)) {
            if (Float.isNaN(this.zzdft)) {
                float[] fArr = this.zzdfi;
                float[] fArr2 = {0.0f, 1.0f, 0.0f};
                float[] fArr3 = {(fArr[0] * fArr2[0]) + (fArr[1] * fArr2[1]) + (fArr[2] * fArr2[2]), (fArr[3] * fArr2[0]) + (fArr[4] * fArr2[1]) + (fArr[5] * fArr2[2]), (fArr[8] * fArr2[2]) + (fArr[6] * fArr2[0]) + (fArr[7] * fArr2[1])};
                this.zzdft = -(((float) Math.atan2((double) fArr3[1], (double) fArr3[0])) - 1.5707964f);
            }
            zzb(this.zzdfr, this.zzdft + this.zzdfu);
        } else {
            zza(this.zzdfi, -1.5707964f);
            zzb(this.zzdfr, this.zzdfu);
        }
        zza(this.zzdfn, 1.5707964f);
        zza(this.zzdfo, this.zzdfr, this.zzdfn);
        zza(this.zzdfp, this.zzdfi, this.zzdfo);
        zza(this.zzdfq, this.zzdfv);
        zza(this.zzdfs, this.zzdfq, this.zzdfp);
        GLES20.glUniformMatrix3fv(this.zzdfz, 1, false, this.zzdfs, 0);
        GLES20.glDrawArrays(5, 0, 4);
        zzcq("drawArrays");
        GLES20.glFinish();
        this.zzdge.eglSwapBuffers(this.zzdgf, this.zzdgh);
    }

    private final boolean zzrv() {
        boolean z = false;
        if (!(this.zzdgh == null || this.zzdgh == EGL10.EGL_NO_SURFACE)) {
            z = this.zzdge.eglMakeCurrent(this.zzdgf, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT) | false | this.zzdge.eglDestroySurface(this.zzdgf, this.zzdgh);
            this.zzdgh = null;
        }
        if (this.zzdgg != null) {
            z |= this.zzdge.eglDestroyContext(this.zzdgf, this.zzdgg);
            this.zzdgg = null;
        }
        if (this.zzdgf == null) {
            return z;
        }
        boolean eglTerminate = z | this.zzdge.eglTerminate(this.zzdgf);
        this.zzdgf = null;
        return eglTerminate;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzdga++;
        synchronized (this.zzdgd) {
            this.zzdgd.notifyAll();
        }
    }

    public final void run() {
        boolean z;
        int glCreateProgram;
        boolean z2 = true;
        if (this.zzdfx == null) {
            zzafj.m12e("SphericalVideoProcessor started with no output texture.");
            this.zzdgc.countDown();
            return;
        }
        this.zzdge = (EGL10) EGLContext.getEGL();
        this.zzdgf = this.zzdge.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.zzdgf == EGL10.EGL_NO_DISPLAY) {
            z = false;
        } else {
            if (!this.zzdge.eglInitialize(this.zzdgf, new int[2])) {
                z = false;
            } else {
                int[] iArr = new int[1];
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                EGLConfig eGLConfig = (!this.zzdge.eglChooseConfig(this.zzdgf, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344}, eGLConfigArr, 1, iArr) || iArr[0] <= 0) ? null : eGLConfigArr[0];
                if (eGLConfig == null) {
                    z = false;
                } else {
                    this.zzdgg = this.zzdge.eglCreateContext(this.zzdgf, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                    if (this.zzdgg == null || this.zzdgg == EGL10.EGL_NO_CONTEXT) {
                        z = false;
                    } else {
                        this.zzdgh = this.zzdge.eglCreateWindowSurface(this.zzdgf, eGLConfig, this.zzdfx, (int[]) null);
                        z = (this.zzdgh == null || this.zzdgh == EGL10.EGL_NO_SURFACE) ? false : this.zzdge.eglMakeCurrent(this.zzdgf, this.zzdgh, this.zzdgh, this.zzdgg);
                    }
                }
            }
        }
        zzmg zzmg = zzmq.zzbkv;
        int zzd = zzd(35633, !((String) zzbs.zzep().zzd(zzmg)).equals(zzmg.zzip()) ? (String) zzbs.zzep().zzd(zzmg) : "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}");
        if (zzd == 0) {
            glCreateProgram = 0;
        } else {
            zzmg zzmg2 = zzmq.zzbkw;
            int zzd2 = zzd(35632, !((String) zzbs.zzep().zzd(zzmg2)).equals(zzmg2.zzip()) ? (String) zzbs.zzep().zzd(zzmg2) : "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}");
            if (zzd2 == 0) {
                glCreateProgram = 0;
            } else {
                glCreateProgram = GLES20.glCreateProgram();
                zzcq("createProgram");
                if (glCreateProgram != 0) {
                    GLES20.glAttachShader(glCreateProgram, zzd);
                    zzcq("attachShader");
                    GLES20.glAttachShader(glCreateProgram, zzd2);
                    zzcq("attachShader");
                    GLES20.glLinkProgram(glCreateProgram);
                    zzcq("linkProgram");
                    int[] iArr2 = new int[1];
                    GLES20.glGetProgramiv(glCreateProgram, 35714, iArr2, 0);
                    zzcq("getProgramiv");
                    if (iArr2[0] != 1) {
                        Log.e("SphericalVideoRenderer", "Could not link program: ");
                        Log.e("SphericalVideoRenderer", GLES20.glGetProgramInfoLog(glCreateProgram));
                        GLES20.glDeleteProgram(glCreateProgram);
                        zzcq("deleteProgram");
                        glCreateProgram = 0;
                    } else {
                        GLES20.glValidateProgram(glCreateProgram);
                        zzcq("validateProgram");
                    }
                }
            }
        }
        this.zzdfy = glCreateProgram;
        GLES20.glUseProgram(this.zzdfy);
        zzcq("useProgram");
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.zzdfy, "aPosition");
        GLES20.glVertexAttribPointer(glGetAttribLocation, 3, 5126, false, 12, this.zzdgb);
        zzcq("vertexAttribPointer");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        zzcq("enableVertexAttribArray");
        int[] iArr3 = new int[1];
        GLES20.glGenTextures(1, iArr3, 0);
        zzcq("genTextures");
        int i = iArr3[0];
        GLES20.glBindTexture(36197, i);
        zzcq("bindTextures");
        GLES20.glTexParameteri(36197, 10240, 9729);
        zzcq("texParameteri");
        GLES20.glTexParameteri(36197, 10241, 9729);
        zzcq("texParameteri");
        GLES20.glTexParameteri(36197, 10242, 33071);
        zzcq("texParameteri");
        GLES20.glTexParameteri(36197, 10243, 33071);
        zzcq("texParameteri");
        this.zzdfz = GLES20.glGetUniformLocation(this.zzdfy, "uVMat");
        GLES20.glUniformMatrix3fv(this.zzdfz, 1, false, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, 0);
        if (this.zzdfy == 0) {
            z2 = false;
        }
        if (!z || !z2) {
            String valueOf = String.valueOf(GLUtils.getEGLErrorString(this.zzdge.eglGetError()));
            String concat = valueOf.length() != 0 ? "EGL initialization failed: ".concat(valueOf) : new String("EGL initialization failed: ");
            zzafj.m12e(concat);
            zzbs.zzeg().zza(new Throwable(concat), "SphericalVideoProcessor.run.1");
            zzrv();
            this.zzdgc.countDown();
            return;
        }
        this.zzdfw = new SurfaceTexture(i);
        this.zzdfw.setOnFrameAvailableListener(this);
        this.zzdgc.countDown();
        this.zzdfm.start();
        try {
            this.zzdgi = true;
            while (!this.zzdgj) {
                zzru();
                if (this.zzdgi) {
                    GLES20.glViewport(0, 0, this.zzakw, this.zzakx);
                    zzcq("viewport");
                    int glGetUniformLocation = GLES20.glGetUniformLocation(this.zzdfy, "uFOVx");
                    int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.zzdfy, "uFOVy");
                    if (this.zzakw > this.zzakx) {
                        GLES20.glUniform1f(glGetUniformLocation, 0.87266463f);
                        GLES20.glUniform1f(glGetUniformLocation2, (((float) this.zzakx) * 0.87266463f) / ((float) this.zzakw));
                    } else {
                        GLES20.glUniform1f(glGetUniformLocation, (((float) this.zzakw) * 0.87266463f) / ((float) this.zzakx));
                        GLES20.glUniform1f(glGetUniformLocation2, 0.87266463f);
                    }
                    this.zzdgi = false;
                }
                try {
                    synchronized (this.zzdgd) {
                        if (!this.zzdgj && !this.zzdgi && this.zzdga == 0) {
                            this.zzdgd.wait();
                        }
                    }
                } catch (InterruptedException e) {
                }
            }
        } catch (IllegalStateException e2) {
            zzafj.zzco("SphericalVideoProcessor halted unexpectedly.");
        } catch (Throwable th) {
            zzafj.zzb("SphericalVideoProcessor died.", th);
            zzbs.zzeg().zza(th, "SphericalVideoProcessor.run.2");
        } finally {
            this.zzdfm.stop();
            this.zzdfw.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
            this.zzdfw = null;
            zzrv();
        }
    }

    public final void zza(SurfaceTexture surfaceTexture, int i, int i2) {
        this.zzakw = i;
        this.zzakx = i2;
        this.zzdfx = surfaceTexture;
    }

    public final void zzb(float f, float f2) {
        float f3;
        float f4;
        if (this.zzakw > this.zzakx) {
            f3 = (1.7453293f * f) / ((float) this.zzakw);
            f4 = (1.7453293f * f2) / ((float) this.zzakw);
        } else {
            f3 = (1.7453293f * f) / ((float) this.zzakx);
            f4 = (1.7453293f * f2) / ((float) this.zzakx);
        }
        this.zzdfu -= f3;
        this.zzdfv -= f4;
        if (this.zzdfv < -1.5707964f) {
            this.zzdfv = -1.5707964f;
        }
        if (this.zzdfv > 1.5707964f) {
            this.zzdfv = 1.5707964f;
        }
    }

    public final void zzh(int i, int i2) {
        synchronized (this.zzdgd) {
            this.zzakw = i;
            this.zzakx = i2;
            this.zzdgi = true;
            this.zzdgd.notifyAll();
        }
    }

    public final void zzms() {
        synchronized (this.zzdgd) {
            this.zzdgd.notifyAll();
        }
    }

    public final void zzrs() {
        synchronized (this.zzdgd) {
            this.zzdgj = true;
            this.zzdfx = null;
            this.zzdgd.notifyAll();
        }
    }

    public final SurfaceTexture zzrt() {
        if (this.zzdfx == null) {
            return null;
        }
        try {
            this.zzdgc.await();
        } catch (InterruptedException e) {
        }
        return this.zzdfw;
    }
}
