package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.zzn;
import java.util.List;

@zzzb
public final class zznq extends RelativeLayout {
    private static final float[] zzbrt = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    @Nullable
    private AnimationDrawable zzbru;

    public zznq(Context context, zznp zznp, RelativeLayout.LayoutParams layoutParams) {
        super(context);
        zzbq.checkNotNull(zznp);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(zzbrt, (RectF) null, (float[]) null));
        shapeDrawable.getPaint().setColor(zznp.getBackgroundColor());
        setLayoutParams(layoutParams);
        zzbs.zzee().setBackground(this, shapeDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(zznp.getText())) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(zznp.getText());
            textView.setTextColor(zznp.getTextColor());
            textView.setTextSize((float) zznp.getTextSize());
            zzjk.zzhx();
            int zzc = zzais.zzc(context, 4);
            zzjk.zzhx();
            textView.setPadding(zzc, 0, zzais.zzc(context, 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<zznr> zzjh = zznp.zzjh();
        if (zzjh != null && zzjh.size() > 1) {
            this.zzbru = new AnimationDrawable();
            for (zznr zzjl : zzjh) {
                try {
                    this.zzbru.addFrame((Drawable) zzn.zzx(zzjl.zzjl()), zznp.zzji());
                } catch (Exception e) {
                    zzafj.zzb("Error while getting drawable.", e);
                }
            }
            zzbs.zzee().setBackground(imageView, this.zzbru);
        } else if (zzjh.size() == 1) {
            try {
                imageView.setImageDrawable((Drawable) zzn.zzx(zzjh.get(0).zzjl()));
            } catch (Exception e2) {
                zzafj.zzb("Error while getting drawable.", e2);
            }
        }
        addView(imageView);
    }

    public final void onAttachedToWindow() {
        if (this.zzbru != null) {
            this.zzbru.start();
        }
        super.onAttachedToWindow();
    }
}
