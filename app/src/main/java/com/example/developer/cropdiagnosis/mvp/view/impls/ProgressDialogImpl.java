package com.example.developer.cropdiagnosis.mvp.view.impls;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.mvp.view.interfaces.IProgressDialog;

import butterknife.BindView;

/**
 * Created by Developer on 16-12-16.
 * He is a intelligent Android developer.
 */

public class ProgressDialogImpl extends FrameLayout implements IProgressDialog {

    @BindView(R.id.pb_load_view)
    ProgressBar pbLoad;

    public ProgressDialogImpl(Context context) {
        super(context);
        initView(context);
    }

    public ProgressDialogImpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProgressDialogImpl(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ProgressDialogImpl(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_progress_dialog, this, true);
        view.setVisibility(GONE);
    }

//    @Override
//    public ViewGroup.LayoutParams getLayoutParams() {
//        return this.getLayoutParams();
//    }

    @Override
    public void showProgressDialog() {
        pbLoad.setVisibility(VISIBLE);
    }

//    @Override
//    public void setLayoutParams(LayoutParams layoutParams) {
//        this.setLayoutParams(layoutParams);
//    }

    @Override
    public void cancelProgressDialog() {
        pbLoad.setVisibility(GONE);
    }
}
