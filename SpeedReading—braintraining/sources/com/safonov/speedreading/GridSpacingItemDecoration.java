package com.safonov.speedreading;

import android.graphics.Rect;
import android.support.p003v7.widget.RecyclerView;
import android.view.View;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private boolean includeEdge;
    private int spacing;
    private int spanCount;

    public GridSpacingItemDecoration(int spanCount2, int spacing2, boolean includeEdge2) {
        this.spanCount = spanCount2;
        this.spacing = spacing2;
        this.includeEdge = includeEdge2;
    }

    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        int column = position % this.spanCount;
        if (this.includeEdge) {
            outRect.left = this.spacing - ((this.spacing * column) / this.spanCount);
            outRect.right = ((column + 1) * this.spacing) / this.spanCount;
            if (position < this.spanCount) {
                outRect.top = this.spacing;
            }
            outRect.bottom = this.spacing;
            return;
        }
        outRect.left = (this.spacing * column) / this.spanCount;
        outRect.right = this.spacing - (((column + 1) * this.spacing) / this.spanCount);
        if (position >= this.spanCount) {
            outRect.top = this.spacing;
        }
    }
}
