package com.example.developer.cropdiagnosis.mvp.ui.component.factory;

import android.content.Context;

import com.example.developer.cropdiagnosis.mvp.ui.component.impls.ProgressDialogImpl;
import com.example.developer.cropdiagnosis.mvp.ui.component.interfaces.IProgressDialog;

/**
 * Created by Developer on 16-12-16.
 * He is a intelligent Android developer.
 */

public class ProgressDialogFactory {
    public static IProgressDialog createProgressDialog(Context context) {
        return new ProgressDialogImpl(context);
    }
}
