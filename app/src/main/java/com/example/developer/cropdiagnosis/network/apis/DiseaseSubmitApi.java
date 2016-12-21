package com.example.developer.cropdiagnosis.network.apis;

import com.example.developer.cropdiagnosis.network.HttpResult;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
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
    Observable<HttpResult<Void>> submitDisease(@Part("userId") RequestBody userId,
                                               @Part("cropKind") RequestBody cropKind,
                                               @Part("description") RequestBody description,
                                               @PartMap() Map<String, RequestBody> maps);
}
