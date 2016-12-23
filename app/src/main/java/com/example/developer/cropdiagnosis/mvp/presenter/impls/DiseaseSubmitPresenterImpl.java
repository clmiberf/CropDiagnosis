package com.example.developer.cropdiagnosis.mvp.presenter.impls;

import com.example.developer.cropdiagnosis.mvp.model.impls.DiseaseSubmitModelApiImpl;
import com.example.developer.cropdiagnosis.mvp.model.interfaces.DiseaseSubmitModelApi;
import com.example.developer.cropdiagnosis.mvp.presenter.impls.base.BasePresenterImpl;
import com.example.developer.cropdiagnosis.mvp.presenter.interfaces.DiseaseSubmitPresenter;
import com.example.developer.cropdiagnosis.mvp.view.DiseaseSubmitView;

import java.io.File;
import java.util.List;

/**
 * Created by Developer on 16-12-21.
 * Wang Cheng is a intelligent Android developer.
 */

public class DiseaseSubmitPresenterImpl extends BasePresenterImpl<DiseaseSubmitView, Void> implements DiseaseSubmitPresenter {

    private DiseaseSubmitModelApi api = null;

    public DiseaseSubmitPresenterImpl() {
        super.onCreate();
        api = new DiseaseSubmitModelApiImpl();
    }

    @Override
    public void submitDisease(String userId, String cropKind, String description, List<File> imageFiles) {
        beforeRequest();
        mSubscription = api.submitDisease(userId, cropKind, description, imageFiles, this);
    }

    @Override
    public void beforeRequest() {
        super.beforeRequest();
    }

    @Override
    public void success(Void data) {
        super.success(data);
        mBaseView.submitSuccess();
    }

    @Override
    public void onError(String errorMsg) {
        super.onError(errorMsg);
        mBaseView.submitFailed(errorMsg);
    }
}
