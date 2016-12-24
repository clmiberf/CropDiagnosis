package com.example.developer.cropdiagnosis.mvp.model.interfaces;

import com.example.developer.cropdiagnosis.mvp.model.beans.DiseaseModelBean;
import com.example.developer.cropdiagnosis.mvp.presenter.interfaces.base.RequestCallback;

import java.util.List;

import rx.Subscription;


public interface DiseaseHistoryModelApi {
	Subscription loadDiseaseHistory(String userId, RequestCallback<List<DiseaseModelBean>> callback);
}
