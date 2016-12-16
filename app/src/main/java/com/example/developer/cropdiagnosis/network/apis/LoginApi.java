package com.example.developer.cropdiagnosis.network.apis;

import com.example.developer.cropdiagnosis.model.beans.UserModelBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Developer on 16-12-15.
 */

public interface LoginApi {
    @GET("login")
    Observable<UserModelBean> login(@Query("username") String username, @Query("password") String password);
}
