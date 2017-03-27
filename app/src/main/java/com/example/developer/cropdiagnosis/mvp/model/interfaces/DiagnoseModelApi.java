package com.example.developer.cropdiagnosis.mvp.model.interfaces;

import com.example.developer.cropdiagnosis.mvp.view.DiagnoseView;

import rx.Subscription;

/**
 * Created by socer on 17-3-27.
 */

public interface DiagnoseModelApi {

    Subscription diagnoseResultEva(String eva, DiagnoseView view);
}
