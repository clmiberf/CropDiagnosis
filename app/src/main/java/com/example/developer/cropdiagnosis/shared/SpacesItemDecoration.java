package com.example.developer.cropdiagnosis.shared;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by socer on 17-3-26.
 */

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

    private int space;

    public SpacesItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = 0;

        // Add top margin only for the first item to avoid double space between items
        if(parent.getChildPosition(view) == 0)
            outRect.top = 0;
    }

}
