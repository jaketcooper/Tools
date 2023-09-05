package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@zzzb
public final class zzha {
    private final int zzazj;
    private final int zzazk;
    private final int zzazl;
    private final zzgz zzazm = new zzhe();

    public zzha(int i) {
        this.zzazk = i;
        this.zzazj = 6;
        this.zzazl = 0;
    }

    private final String zzy(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        zzhc zzhc = new zzhc();
        PriorityQueue priorityQueue = new PriorityQueue(this.zzazk, new zzhb(this));
        for (String zzb : split) {
            String[] zzb2 = zzhd.zzb(zzb, false);
            if (zzb2.length != 0) {
                zzhg.zza(zzb2, this.zzazk, this.zzazj, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzhc.write(this.zzazm.zzx(((zzhh) it.next()).zzazq));
            } catch (IOException e) {
                zzafj.zzb("Error while writing hash to byteStream", e);
            }
        }
        return zzhc.toString();
    }

    public final String zza(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            stringBuffer.append(((String) obj).toLowerCase(Locale.US));
            stringBuffer.append(10);
        }
        return zzy(stringBuffer.toString());
    }
}
