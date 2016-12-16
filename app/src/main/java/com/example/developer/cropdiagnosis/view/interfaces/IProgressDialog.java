package com.example.developer.cropdiagnosis.view.interfaces;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by Developer on 16-12-14.
 */

public interface IProgressDialog {
    void showProgressDialog();

//    void setLayoutParams(FrameLayout.LayoutParams layoutParams);

//    ViewGroup.LayoutParams getLayoutParams();

    void cancelProgressDialog();
}
