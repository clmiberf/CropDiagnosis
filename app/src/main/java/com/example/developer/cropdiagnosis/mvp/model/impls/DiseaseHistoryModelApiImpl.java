package com.example.developer.cropdiagnosis.mvp.model.impls;


import com.example.developer.cropdiagnosis.mvp.model.interfaces.DiseaseHistoryModelApi;
import com.example.developer.cropdiagnosis.mvp.view.DiseaseHistoryView;
import com.example.developer.cropdiagnosis.network.HttpMethod;

import rx.Subscription;

public class DiseaseHistoryModelApiImpl implements DiseaseHistoryModelApi {

    @Override
    public Subscription loadDiseaseHistory(String userId, DiseaseHistoryView view) {
        return HttpMethod.getInstance().loadDiseaseHistory(userId, view);
    }
}
