package com.safonov.speedreading.reader.reader.settings;

import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.p003v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class ReaderSettingsActivity_ViewBinding implements Unbinder {
    private ReaderSettingsActivity target;

    @UiThread
    public ReaderSettingsActivity_ViewBinding(ReaderSettingsActivity target2) {
        this(target2, target2.getWindow().getDecorView());
    }

    @UiThread
    public ReaderSettingsActivity_ViewBinding(ReaderSettingsActivity target2, View source) {
        this.target = target2;
        target2.toolbar = (Toolbar) Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
        Resources res = source.getContext().getResources();
        target2.textSizeKey = res.getString(R.string.reader_settings_text_size_key);
        target2.textSizeDefaultValue = res.getString(R.string.reader_settings_text_size_default_value);
    }

    @CallSuper
    public void unbind() {
        ReaderSettingsActivity target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.toolbar = null;
    }
}
