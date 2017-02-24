package com.example.developer.cropdiagnosis.mvp.model.impls;


import com.example.developer.cropdiagnosis.mvp.model.interfaces.DiseaseHistoryModelApi;
import com.example.developer.cropdiagnosis.network.HttpMethod;

import rx.Subscription;

public class DiseaseHistoryModelApiImpl implements DiseaseHistoryModelApi {

    @Override
    public Subscription loadDiseaseHistory(String userId) {
        return HttpMethod.getInstance().loadDiseaseHistory(userId);
    }
}
