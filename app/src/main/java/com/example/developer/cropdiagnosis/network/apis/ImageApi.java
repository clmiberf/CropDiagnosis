package com.example.developer.cropdiagnosis.network.apis;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Developer on 16-12-15.
 */

public interface ImageApi {
    @GET("images")
    Observable<ResponseBody> downloadImage();
}
