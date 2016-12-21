package com.example.developer.cropdiagnosis.network.apis;

import com.example.developer.cropdiagnosis.mvp.model.beans.UserModelBean;
import com.example.developer.cropdiagnosis.network.HttpResult;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Developer on 16-12-15.
 * Wang Cheng is a intelligent Android developer.
 */

public interface LoginApi {
    @POST("api/user/login")
    @FormUrlEncoded
    Observable<HttpResult<UserModelBean>> login(@Field("username") String username, @Field("password") String password);
}
