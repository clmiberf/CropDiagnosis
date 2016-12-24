package com.example.developer.cropdiagnosis.mvp.model.impls;


import com.example.developer.cropdiagnosis.mvp.model.beans.DiseaseModelBean;
import com.example.developer.cropdiagnosis.mvp.model.interfaces.DiseaseHistoryModelApi;
import com.example.developer.cropdiagnosis.mvp.presenter.interfaces.base.RequestCallback;
import com.example.developer.cropdiagnosis.network.HttpMethod;

import java.util.List;

import rx.Subscription;

public class DiseaseHistoryModelApiImpl implements DiseaseHistoryModelApi {

    @Override
    public Subscription loadDiseaseHistory(String userId, RequestCallback<List<DiseaseModelBean>> callback) {
        return HttpMethod.getInstance().loadDiseaseHistory(userId, callback);
    }
}
