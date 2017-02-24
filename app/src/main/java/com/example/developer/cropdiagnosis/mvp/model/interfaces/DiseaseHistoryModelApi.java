package com.example.developer.cropdiagnosis.mvp.model.interfaces;

import rx.Subscription;


public interface DiseaseHistoryModelApi {
    Subscription loadDiseaseHistory(String userId);
}
