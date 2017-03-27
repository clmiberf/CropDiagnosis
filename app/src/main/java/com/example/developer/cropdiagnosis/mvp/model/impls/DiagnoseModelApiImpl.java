package com.example.developer.cropdiagnosis.mvp.model.impls;

import com.example.developer.cropdiagnosis.mvp.model.interfaces.DiagnoseModelApi;
import com.example.developer.cropdiagnosis.mvp.view.DiagnoseView;
import com.example.developer.cropdiagnosis.network.HttpMethod;

import rx.Subscription;

/**
 * Created by socer on 17-3-27.
 */

public class DiagnoseModelApiImpl implements DiagnoseModelApi {
    @Override
    public Subscription diagnoseResultEva(String eva, DiagnoseView view) {
        return HttpMethod.getInstance().diagnoseResultEva(eva,view);
    }
}
