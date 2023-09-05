package com.safonov.speedreading.reader.library.fileexplorer.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.speedreading.alexander.speedreading.R;

public class FileExplorerFragment_ViewBinding implements Unbinder {
    private FileExplorerFragment target;

    @UiThread
    public FileExplorerFragment_ViewBinding(FileExplorerFragment target2, View source) {
        this.target = target2;
        target2.recyclerView = (RecyclerView) Utils.findRequiredViewAsType(source, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
    }

    @CallSuper
    public void unbind() {
        FileExplorerFragment target2 = this.target;
        if (target2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        target2.recyclerView = null;
    }
}
