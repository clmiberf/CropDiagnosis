package com.example.developer.cropdiagnosis.mvp.model.interfaces;

import com.example.developer.cropdiagnosis.mvp.view.DiseaseHistoryView;

import rx.Subscription;


public interface DiseaseHistoryModelApi {
    Subscription loadDiseaseHistory(String userId, DiseaseHistoryView view);
}
