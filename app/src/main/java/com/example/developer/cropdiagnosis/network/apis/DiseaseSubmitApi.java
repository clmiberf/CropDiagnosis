package com.example.developer.cropdiagnosis.network.apis;

import com.example.developer.cropdiagnosis.network.HttpResult;

import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Developer on 16-12-21.
 * Wang Cheng is a intelligent Android developer.
 */

public interface DiseaseSubmitApi {
//    String userId, String cropKind, String description, List<File> imageFiles, DiseaseSubmitFragment.Callback callback) {
    @POST("api/diseaseSubmit")
    @Multipart
    Observable<HttpResult<Void>> submitDisease(@Query("userId") String userId);
}
