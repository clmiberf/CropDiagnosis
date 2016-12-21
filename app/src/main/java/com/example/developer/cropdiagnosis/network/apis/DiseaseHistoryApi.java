package com.example.developer.cropdiagnosis.network.apis;

import com.example.developer.cropdiagnosis.mvp.model.beans.DiseaseModelBean;
import com.example.developer.cropdiagnosis.network.HttpResult;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Developer on 16-12-14.
 * Wang Cheng is a intelligent Android developer.
 */

public interface DiseaseHistoryApi {
    @GET("diseaseHistory")
    Observable<HttpResult<List<DiseaseModelBean>>> getDiseaseHistory(@Query("userId") String userId);
}
