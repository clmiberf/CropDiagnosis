package com.example.developer.cropdiagnosis.network.apis;

import com.example.developer.cropdiagnosis.model.beans.DiseaseModelBean;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Developer on 16-12-14.
 */

public interface DiseaseHistoryApi {
    @GET("diseaseHistory")
    Observable<List<DiseaseModelBean>> getDiseaseHistory();
}
