package com.example.developer.cropdiagnosis.mvp.model.impls;

import com.example.developer.cropdiagnosis.mvp.model.interfaces.DiseaseSubmitModelApi;
import com.example.developer.cropdiagnosis.network.HttpMethod;
import com.example.developer.cropdiagnosis.network.HttpResult;

import java.io.File;
import java.util.List;

import rx.Observable;
import rx.Subscription;

/**
 * Created by Developer on 16-12-24.
 * Wang Cheng is a intelligent Android developer.
 */

public class DiseaseSubmitModelApiImpl implements DiseaseSubmitModelApi {
    @Override
    public Observable<HttpResult<Void>> submitDisease(String userId, String cropKind, String description, List<File> imageFiles) {
        return HttpMethod.getInstance().submitDisease(userId, cropKind, description, imageFiles);
    }
}
