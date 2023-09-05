package com.google.android.gms.internal;

import java.io.IOException;
import org.mozilla.universalchardet.prober.HebrewProber;
import org.mozilla.universalchardet.prober.contextanalysis.SJISContextAnalysis;

public final class zzclb extends zzfhm<zzclb> {
    private static volatile zzclb[] zzjjc;
    public String zzch = null;
    public String zzcv = null;
    public Long zzfib = null;
    public String zzida = null;
    public String zzivh = null;
    public String zzivi = null;
    public String zzivl = null;
    public String zzivp = null;
    public Integer zzjjd = null;
    public zzcky[] zzjje = zzcky.zzbaw();
    public zzcld[] zzjjf = zzcld.zzbaz();
    public Long zzjjg = null;
    public Long zzjjh = null;
    public Long zzjji = null;
    public Long zzjjj = null;
    public Long zzjjk = null;
    public String zzjjl = null;
    public String zzjjm = null;
    public String zzjjn = null;
    public Integer zzjjo = null;
    public Long zzjjp = null;
    public Long zzjjq = null;
    public String zzjjr = null;
    public Boolean zzjjs = null;
    public String zzjjt = null;
    public Long zzjju = null;
    public Integer zzjjv = null;
    public Boolean zzjjw = null;
    public zzckx[] zzjjx = zzckx.zzbav();
    public Integer zzjjy = null;
    private Integer zzjjz = null;
    private Integer zzjka = null;
    public String zzjkb = null;
    public Long zzjkc = null;
    public String zzjkd = null;

    public zzclb() {
        this.zzphm = null;
        this.zzpaw = -1;
    }

    public static zzclb[] zzbay() {
        if (zzjjc == null) {
            synchronized (zzfhq.zzphu) {
                if (zzjjc == null) {
                    zzjjc = new zzclb[0];
                }
            }
        }
        return zzjjc;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzclb)) {
            return false;
        }
        zzclb zzclb = (zzclb) obj;
        if (this.zzjjd == null) {
            if (zzclb.zzjjd != null) {
                return false;
            }
        } else if (!this.zzjjd.equals(zzclb.zzjjd)) {
            return false;
        }
        if (!zzfhq.equals((Object[]) this.zzjje, (Object[]) zzclb.zzjje)) {
            return false;
        }
        if (!zzfhq.equals((Object[]) this.zzjjf, (Object[]) zzclb.zzjjf)) {
            return false;
        }
        if (this.zzjjg == null) {
            if (zzclb.zzjjg != null) {
                return false;
            }
        } else if (!this.zzjjg.equals(zzclb.zzjjg)) {
            return false;
        }
        if (this.zzjjh == null) {
            if (zzclb.zzjjh != null) {
                return false;
            }
        } else if (!this.zzjjh.equals(zzclb.zzjjh)) {
            return false;
        }
        if (this.zzjji == null) {
            if (zzclb.zzjji != null) {
                return false;
            }
        } else if (!this.zzjji.equals(zzclb.zzjji)) {
            return false;
        }
        if (this.zzjjj == null) {
            if (zzclb.zzjjj != null) {
                return false;
            }
        } else if (!this.zzjjj.equals(zzclb.zzjjj)) {
            return false;
        }
        if (this.zzjjk == null) {
            if (zzclb.zzjjk != null) {
                return false;
            }
        } else if (!this.zzjjk.equals(zzclb.zzjjk)) {
            return false;
        }
        if (this.zzjjl == null) {
            if (zzclb.zzjjl != null) {
                return false;
            }
        } else if (!this.zzjjl.equals(zzclb.zzjjl)) {
            return false;
        }
        if (this.zzcv == null) {
            if (zzclb.zzcv != null) {
                return false;
            }
        } else if (!this.zzcv.equals(zzclb.zzcv)) {
            return false;
        }
        if (this.zzjjm == null) {
            if (zzclb.zzjjm != null) {
                return false;
            }
        } else if (!this.zzjjm.equals(zzclb.zzjjm)) {
            return false;
        }
        if (this.zzjjn == null) {
            if (zzclb.zzjjn != null) {
                return false;
            }
        } else if (!this.zzjjn.equals(zzclb.zzjjn)) {
            return false;
        }
        if (this.zzjjo == null) {
            if (zzclb.zzjjo != null) {
                return false;
            }
        } else if (!this.zzjjo.equals(zzclb.zzjjo)) {
            return false;
        }
        if (this.zzivi == null) {
            if (zzclb.zzivi != null) {
                return false;
            }
        } else if (!this.zzivi.equals(zzclb.zzivi)) {
            return false;
        }
        if (this.zzch == null) {
            if (zzclb.zzch != null) {
                return false;
            }
        } else if (!this.zzch.equals(zzclb.zzch)) {
            return false;
        }
        if (this.zzida == null) {
            if (zzclb.zzida != null) {
                return false;
            }
        } else if (!this.zzida.equals(zzclb.zzida)) {
            return false;
        }
        if (this.zzjjp == null) {
            if (zzclb.zzjjp != null) {
                return false;
            }
        } else if (!this.zzjjp.equals(zzclb.zzjjp)) {
            return false;
        }
        if (this.zzjjq == null) {
            if (zzclb.zzjjq != null) {
                return false;
            }
        } else if (!this.zzjjq.equals(zzclb.zzjjq)) {
            return false;
        }
        if (this.zzjjr == null) {
            if (zzclb.zzjjr != null) {
                return false;
            }
        } else if (!this.zzjjr.equals(zzclb.zzjjr)) {
            return false;
        }
        if (this.zzjjs == null) {
            if (zzclb.zzjjs != null) {
                return false;
            }
        } else if (!this.zzjjs.equals(zzclb.zzjjs)) {
            return false;
        }
        if (this.zzjjt == null) {
            if (zzclb.zzjjt != null) {
                return false;
            }
        } else if (!this.zzjjt.equals(zzclb.zzjjt)) {
            return false;
        }
        if (this.zzjju == null) {
            if (zzclb.zzjju != null) {
                return false;
            }
        } else if (!this.zzjju.equals(zzclb.zzjju)) {
            return false;
        }
        if (this.zzjjv == null) {
            if (zzclb.zzjjv != null) {
                return false;
            }
        } else if (!this.zzjjv.equals(zzclb.zzjjv)) {
            return false;
        }
        if (this.zzivl == null) {
            if (zzclb.zzivl != null) {
                return false;
            }
        } else if (!this.zzivl.equals(zzclb.zzivl)) {
            return false;
        }
        if (this.zzivh == null) {
            if (zzclb.zzivh != null) {
                return false;
            }
        } else if (!this.zzivh.equals(zzclb.zzivh)) {
            return false;
        }
        if (this.zzjjw == null) {
            if (zzclb.zzjjw != null) {
                return false;
            }
        } else if (!this.zzjjw.equals(zzclb.zzjjw)) {
            return false;
        }
        if (!zzfhq.equals((Object[]) this.zzjjx, (Object[]) zzclb.zzjjx)) {
            return false;
        }
        if (this.zzivp == null) {
            if (zzclb.zzivp != null) {
                return false;
            }
        } else if (!this.zzivp.equals(zzclb.zzivp)) {
            return false;
        }
        if (this.zzjjy == null) {
            if (zzclb.zzjjy != null) {
                return false;
            }
        } else if (!this.zzjjy.equals(zzclb.zzjjy)) {
            return false;
        }
        if (this.zzjjz == null) {
            if (zzclb.zzjjz != null) {
                return false;
            }
        } else if (!this.zzjjz.equals(zzclb.zzjjz)) {
            return false;
        }
        if (this.zzjka == null) {
            if (zzclb.zzjka != null) {
                return false;
            }
        } else if (!this.zzjka.equals(zzclb.zzjka)) {
            return false;
        }
        if (this.zzjkb == null) {
            if (zzclb.zzjkb != null) {
                return false;
            }
        } else if (!this.zzjkb.equals(zzclb.zzjkb)) {
            return false;
        }
        if (this.zzjkc == null) {
            if (zzclb.zzjkc != null) {
                return false;
            }
        } else if (!this.zzjkc.equals(zzclb.zzjkc)) {
            return false;
        }
        if (this.zzfib == null) {
            if (zzclb.zzfib != null) {
                return false;
            }
        } else if (!this.zzfib.equals(zzclb.zzfib)) {
            return false;
        }
        if (this.zzjkd == null) {
            if (zzclb.zzjkd != null) {
                return false;
            }
        } else if (!this.zzjkd.equals(zzclb.zzjkd)) {
            return false;
        }
        return (this.zzphm == null || this.zzphm.isEmpty()) ? zzclb.zzphm == null || zzclb.zzphm.isEmpty() : this.zzphm.equals(zzclb.zzphm);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.zzjkd == null ? 0 : this.zzjkd.hashCode()) + (((this.zzfib == null ? 0 : this.zzfib.hashCode()) + (((this.zzjkc == null ? 0 : this.zzjkc.hashCode()) + (((this.zzjkb == null ? 0 : this.zzjkb.hashCode()) + (((this.zzjka == null ? 0 : this.zzjka.hashCode()) + (((this.zzjjz == null ? 0 : this.zzjjz.hashCode()) + (((this.zzjjy == null ? 0 : this.zzjjy.hashCode()) + (((this.zzivp == null ? 0 : this.zzivp.hashCode()) + (((((this.zzjjw == null ? 0 : this.zzjjw.hashCode()) + (((this.zzivh == null ? 0 : this.zzivh.hashCode()) + (((this.zzivl == null ? 0 : this.zzivl.hashCode()) + (((this.zzjjv == null ? 0 : this.zzjjv.hashCode()) + (((this.zzjju == null ? 0 : this.zzjju.hashCode()) + (((this.zzjjt == null ? 0 : this.zzjjt.hashCode()) + (((this.zzjjs == null ? 0 : this.zzjjs.hashCode()) + (((this.zzjjr == null ? 0 : this.zzjjr.hashCode()) + (((this.zzjjq == null ? 0 : this.zzjjq.hashCode()) + (((this.zzjjp == null ? 0 : this.zzjjp.hashCode()) + (((this.zzida == null ? 0 : this.zzida.hashCode()) + (((this.zzch == null ? 0 : this.zzch.hashCode()) + (((this.zzivi == null ? 0 : this.zzivi.hashCode()) + (((this.zzjjo == null ? 0 : this.zzjjo.hashCode()) + (((this.zzjjn == null ? 0 : this.zzjjn.hashCode()) + (((this.zzjjm == null ? 0 : this.zzjjm.hashCode()) + (((this.zzcv == null ? 0 : this.zzcv.hashCode()) + (((this.zzjjl == null ? 0 : this.zzjjl.hashCode()) + (((this.zzjjk == null ? 0 : this.zzjjk.hashCode()) + (((this.zzjjj == null ? 0 : this.zzjjj.hashCode()) + (((this.zzjji == null ? 0 : this.zzjji.hashCode()) + (((this.zzjjh == null ? 0 : this.zzjjh.hashCode()) + (((this.zzjjg == null ? 0 : this.zzjjg.hashCode()) + (((((((this.zzjjd == null ? 0 : this.zzjjd.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzfhq.hashCode((Object[]) this.zzjje)) * 31) + zzfhq.hashCode((Object[]) this.zzjjf)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + zzfhq.hashCode((Object[]) this.zzjjx)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.zzphm != null && !this.zzphm.isEmpty()) {
            i = this.zzphm.hashCode();
        }
        return hashCode + i;
    }

    public final /* synthetic */ zzfhs zza(zzfhj zzfhj) throws IOException {
        while (true) {
            int zzctt = zzfhj.zzctt();
            switch (zzctt) {
                case 0:
                    break;
                case 8:
                    this.zzjjd = Integer.valueOf(zzfhj.zzcui());
                    continue;
                case 18:
                    int zzb = zzfhv.zzb(zzfhj, 18);
                    int length = this.zzjje == null ? 0 : this.zzjje.length;
                    zzcky[] zzckyArr = new zzcky[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzjje, 0, zzckyArr, 0, length);
                    }
                    while (length < zzckyArr.length - 1) {
                        zzckyArr[length] = new zzcky();
                        zzfhj.zza(zzckyArr[length]);
                        zzfhj.zzctt();
                        length++;
                    }
                    zzckyArr[length] = new zzcky();
                    zzfhj.zza(zzckyArr[length]);
                    this.zzjje = zzckyArr;
                    continue;
                case 26:
                    int zzb2 = zzfhv.zzb(zzfhj, 26);
                    int length2 = this.zzjjf == null ? 0 : this.zzjjf.length;
                    zzcld[] zzcldArr = new zzcld[(zzb2 + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzjjf, 0, zzcldArr, 0, length2);
                    }
                    while (length2 < zzcldArr.length - 1) {
                        zzcldArr[length2] = new zzcld();
                        zzfhj.zza(zzcldArr[length2]);
                        zzfhj.zzctt();
                        length2++;
                    }
                    zzcldArr[length2] = new zzcld();
                    zzfhj.zza(zzcldArr[length2]);
                    this.zzjjf = zzcldArr;
                    continue;
                case 32:
                    this.zzjjg = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 40:
                    this.zzjjh = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 48:
                    this.zzjji = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 56:
                    this.zzjjk = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 66:
                    this.zzjjl = zzfhj.readString();
                    continue;
                case 74:
                    this.zzcv = zzfhj.readString();
                    continue;
                case 82:
                    this.zzjjm = zzfhj.readString();
                    continue;
                case 90:
                    this.zzjjn = zzfhj.readString();
                    continue;
                case 96:
                    this.zzjjo = Integer.valueOf(zzfhj.zzcui());
                    continue;
                case 106:
                    this.zzivi = zzfhj.readString();
                    continue;
                case 114:
                    this.zzch = zzfhj.readString();
                    continue;
                case SJISContextAnalysis.HIRAGANA_HIGHBYTE /*130*/:
                    this.zzida = zzfhj.readString();
                    continue;
                case 136:
                    this.zzjjp = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 144:
                    this.zzjjq = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 154:
                    this.zzjjr = zzfhj.readString();
                    continue;
                case 160:
                    this.zzjjs = Boolean.valueOf(zzfhj.zzctz());
                    continue;
                case 170:
                    this.zzjjt = zzfhj.readString();
                    continue;
                case 176:
                    this.zzjju = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 184:
                    this.zzjjv = Integer.valueOf(zzfhj.zzcui());
                    continue;
                case 194:
                    this.zzivl = zzfhj.readString();
                    continue;
                case 202:
                    this.zzivh = zzfhj.readString();
                    continue;
                case 208:
                    this.zzjjj = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 224:
                    this.zzjjw = Boolean.valueOf(zzfhj.zzctz());
                    continue;
                case HebrewProber.FINAL_KAF /*234*/:
                    int zzb3 = zzfhv.zzb(zzfhj, HebrewProber.FINAL_KAF);
                    int length3 = this.zzjjx == null ? 0 : this.zzjjx.length;
                    zzckx[] zzckxArr = new zzckx[(zzb3 + length3)];
                    if (length3 != 0) {
                        System.arraycopy(this.zzjjx, 0, zzckxArr, 0, length3);
                    }
                    while (length3 < zzckxArr.length - 1) {
                        zzckxArr[length3] = new zzckx();
                        zzfhj.zza(zzckxArr[length3]);
                        zzfhj.zzctt();
                        length3++;
                    }
                    zzckxArr[length3] = new zzckx();
                    zzfhj.zza(zzckxArr[length3]);
                    this.zzjjx = zzckxArr;
                    continue;
                case 242:
                    this.zzivp = zzfhj.readString();
                    continue;
                case 248:
                    this.zzjjy = Integer.valueOf(zzfhj.zzcui());
                    continue;
                case 256:
                    this.zzjjz = Integer.valueOf(zzfhj.zzcui());
                    continue;
                case 264:
                    this.zzjka = Integer.valueOf(zzfhj.zzcui());
                    continue;
                case 274:
                    this.zzjkb = zzfhj.readString();
                    continue;
                case 280:
                    this.zzjkc = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 288:
                    this.zzfib = Long.valueOf(zzfhj.zzcun());
                    continue;
                case 298:
                    this.zzjkd = zzfhj.readString();
                    continue;
                default:
                    if (!super.zza(zzfhj, zzctt)) {
                        break;
                    } else {
                        continue;
                    }
            }
        }
        return this;
    }

    public final void zza(zzfhk zzfhk) throws IOException {
        if (this.zzjjd != null) {
            zzfhk.zzaa(1, this.zzjjd.intValue());
        }
        if (this.zzjje != null && this.zzjje.length > 0) {
            for (zzcky zzcky : this.zzjje) {
                if (zzcky != null) {
                    zzfhk.zza(2, (zzfhs) zzcky);
                }
            }
        }
        if (this.zzjjf != null && this.zzjjf.length > 0) {
            for (zzcld zzcld : this.zzjjf) {
                if (zzcld != null) {
                    zzfhk.zza(3, (zzfhs) zzcld);
                }
            }
        }
        if (this.zzjjg != null) {
            zzfhk.zzf(4, this.zzjjg.longValue());
        }
        if (this.zzjjh != null) {
            zzfhk.zzf(5, this.zzjjh.longValue());
        }
        if (this.zzjji != null) {
            zzfhk.zzf(6, this.zzjji.longValue());
        }
        if (this.zzjjk != null) {
            zzfhk.zzf(7, this.zzjjk.longValue());
        }
        if (this.zzjjl != null) {
            zzfhk.zzn(8, this.zzjjl);
        }
        if (this.zzcv != null) {
            zzfhk.zzn(9, this.zzcv);
        }
        if (this.zzjjm != null) {
            zzfhk.zzn(10, this.zzjjm);
        }
        if (this.zzjjn != null) {
            zzfhk.zzn(11, this.zzjjn);
        }
        if (this.zzjjo != null) {
            zzfhk.zzaa(12, this.zzjjo.intValue());
        }
        if (this.zzivi != null) {
            zzfhk.zzn(13, this.zzivi);
        }
        if (this.zzch != null) {
            zzfhk.zzn(14, this.zzch);
        }
        if (this.zzida != null) {
            zzfhk.zzn(16, this.zzida);
        }
        if (this.zzjjp != null) {
            zzfhk.zzf(17, this.zzjjp.longValue());
        }
        if (this.zzjjq != null) {
            zzfhk.zzf(18, this.zzjjq.longValue());
        }
        if (this.zzjjr != null) {
            zzfhk.zzn(19, this.zzjjr);
        }
        if (this.zzjjs != null) {
            zzfhk.zzl(20, this.zzjjs.booleanValue());
        }
        if (this.zzjjt != null) {
            zzfhk.zzn(21, this.zzjjt);
        }
        if (this.zzjju != null) {
            zzfhk.zzf(22, this.zzjju.longValue());
        }
        if (this.zzjjv != null) {
            zzfhk.zzaa(23, this.zzjjv.intValue());
        }
        if (this.zzivl != null) {
            zzfhk.zzn(24, this.zzivl);
        }
        if (this.zzivh != null) {
            zzfhk.zzn(25, this.zzivh);
        }
        if (this.zzjjj != null) {
            zzfhk.zzf(26, this.zzjjj.longValue());
        }
        if (this.zzjjw != null) {
            zzfhk.zzl(28, this.zzjjw.booleanValue());
        }
        if (this.zzjjx != null && this.zzjjx.length > 0) {
            for (zzckx zzckx : this.zzjjx) {
                if (zzckx != null) {
                    zzfhk.zza(29, (zzfhs) zzckx);
                }
            }
        }
        if (this.zzivp != null) {
            zzfhk.zzn(30, this.zzivp);
        }
        if (this.zzjjy != null) {
            zzfhk.zzaa(31, this.zzjjy.intValue());
        }
        if (this.zzjjz != null) {
            zzfhk.zzaa(32, this.zzjjz.intValue());
        }
        if (this.zzjka != null) {
            zzfhk.zzaa(33, this.zzjka.intValue());
        }
        if (this.zzjkb != null) {
            zzfhk.zzn(34, this.zzjkb);
        }
        if (this.zzjkc != null) {
            zzfhk.zzf(35, this.zzjkc.longValue());
        }
        if (this.zzfib != null) {
            zzfhk.zzf(36, this.zzfib.longValue());
        }
        if (this.zzjkd != null) {
            zzfhk.zzn(37, this.zzjkd);
        }
        super.zza(zzfhk);
    }

    /* access modifiers changed from: protected */
    public final int zzo() {
        int zzo = super.zzo();
        if (this.zzjjd != null) {
            zzo += zzfhk.zzad(1, this.zzjjd.intValue());
        }
        if (this.zzjje != null && this.zzjje.length > 0) {
            int i = zzo;
            for (zzcky zzcky : this.zzjje) {
                if (zzcky != null) {
                    i += zzfhk.zzb(2, (zzfhs) zzcky);
                }
            }
            zzo = i;
        }
        if (this.zzjjf != null && this.zzjjf.length > 0) {
            int i2 = zzo;
            for (zzcld zzcld : this.zzjjf) {
                if (zzcld != null) {
                    i2 += zzfhk.zzb(3, (zzfhs) zzcld);
                }
            }
            zzo = i2;
        }
        if (this.zzjjg != null) {
            zzo += zzfhk.zzc(4, this.zzjjg.longValue());
        }
        if (this.zzjjh != null) {
            zzo += zzfhk.zzc(5, this.zzjjh.longValue());
        }
        if (this.zzjji != null) {
            zzo += zzfhk.zzc(6, this.zzjji.longValue());
        }
        if (this.zzjjk != null) {
            zzo += zzfhk.zzc(7, this.zzjjk.longValue());
        }
        if (this.zzjjl != null) {
            zzo += zzfhk.zzo(8, this.zzjjl);
        }
        if (this.zzcv != null) {
            zzo += zzfhk.zzo(9, this.zzcv);
        }
        if (this.zzjjm != null) {
            zzo += zzfhk.zzo(10, this.zzjjm);
        }
        if (this.zzjjn != null) {
            zzo += zzfhk.zzo(11, this.zzjjn);
        }
        if (this.zzjjo != null) {
            zzo += zzfhk.zzad(12, this.zzjjo.intValue());
        }
        if (this.zzivi != null) {
            zzo += zzfhk.zzo(13, this.zzivi);
        }
        if (this.zzch != null) {
            zzo += zzfhk.zzo(14, this.zzch);
        }
        if (this.zzida != null) {
            zzo += zzfhk.zzo(16, this.zzida);
        }
        if (this.zzjjp != null) {
            zzo += zzfhk.zzc(17, this.zzjjp.longValue());
        }
        if (this.zzjjq != null) {
            zzo += zzfhk.zzc(18, this.zzjjq.longValue());
        }
        if (this.zzjjr != null) {
            zzo += zzfhk.zzo(19, this.zzjjr);
        }
        if (this.zzjjs != null) {
            this.zzjjs.booleanValue();
            zzo += zzfhk.zzkx(20) + 1;
        }
        if (this.zzjjt != null) {
            zzo += zzfhk.zzo(21, this.zzjjt);
        }
        if (this.zzjju != null) {
            zzo += zzfhk.zzc(22, this.zzjju.longValue());
        }
        if (this.zzjjv != null) {
            zzo += zzfhk.zzad(23, this.zzjjv.intValue());
        }
        if (this.zzivl != null) {
            zzo += zzfhk.zzo(24, this.zzivl);
        }
        if (this.zzivh != null) {
            zzo += zzfhk.zzo(25, this.zzivh);
        }
        if (this.zzjjj != null) {
            zzo += zzfhk.zzc(26, this.zzjjj.longValue());
        }
        if (this.zzjjw != null) {
            this.zzjjw.booleanValue();
            zzo += zzfhk.zzkx(28) + 1;
        }
        if (this.zzjjx != null && this.zzjjx.length > 0) {
            for (zzckx zzckx : this.zzjjx) {
                if (zzckx != null) {
                    zzo += zzfhk.zzb(29, (zzfhs) zzckx);
                }
            }
        }
        if (this.zzivp != null) {
            zzo += zzfhk.zzo(30, this.zzivp);
        }
        if (this.zzjjy != null) {
            zzo += zzfhk.zzad(31, this.zzjjy.intValue());
        }
        if (this.zzjjz != null) {
            zzo += zzfhk.zzad(32, this.zzjjz.intValue());
        }
        if (this.zzjka != null) {
            zzo += zzfhk.zzad(33, this.zzjka.intValue());
        }
        if (this.zzjkb != null) {
            zzo += zzfhk.zzo(34, this.zzjkb);
        }
        if (this.zzjkc != null) {
            zzo += zzfhk.zzc(35, this.zzjkc.longValue());
        }
        if (this.zzfib != null) {
            zzo += zzfhk.zzc(36, this.zzfib.longValue());
        }
        return this.zzjkd != null ? zzo + zzfhk.zzo(37, this.zzjkd) : zzo;
    }
}
