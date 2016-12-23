package com.example.developer.cropdiagnosis.network.apis;

import com.example.developer.cropdiagnosis.mvp.model.beans.UserModelBean;
import com.example.developer.cropdiagnosis.network.HttpResult;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Developer on 16-12-23.
 * Wang Cheng is a intelligent Android developer.
 */

public interface RegisterApi {
    @POST("api/user/register")
    @FormUrlEncoded
    Observable<HttpResult<UserModelBean>> register(@Field("tel_number") String phoneNumber,
                                                   @Field("password") String password,
                                                   @Field("user_type") int userType,
                                                   @Field("province") String province,
                                                   @Field("city") String city,
                                                   @Field("county") String county,
                                                   @Field("village") String village);
}
