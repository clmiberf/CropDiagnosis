package com.example.developer.cropdiagnosis.mvp.model.impls;

import com.example.developer.cropdiagnosis.mvp.model.interfaces.DiseaseSubmitModelApi;
import com.example.developer.cropdiagnosis.mvp.presenter.interfaces.base.RequestCallback;
import com.example.developer.cropdiagnosis.network.HttpMethod;

import java.io.File;
import java.util.List;

import rx.Subscription;

/**
 * Created by Developer on 16-12-24.
 * Wang Cheng is a intelligent Android developer.
 */

public class DiseaseSubmitModelApiImpl implements DiseaseSubmitModelApi {
    @Override
    public Subscription submitDisease(String userId, String cropKind, String description, List<File> imageFiles, RequestCallback<Void> callback) {
        return HttpMethod.getInstance().submitDisease(userId, cropKind, description, imageFiles, callback);
    }
}
