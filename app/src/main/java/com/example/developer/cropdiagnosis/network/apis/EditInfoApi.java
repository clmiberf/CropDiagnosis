package com.example.developer.cropdiagnosis.network.apis;

import com.example.developer.cropdiagnosis.mvp.model.beans.UserModelBean;
import com.example.developer.cropdiagnosis.mvp.view.RegisterView;
import com.example.developer.cropdiagnosis.network.HttpResult;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;
import rx.Subscription;

/**
 * Created by socer on 17-3-27.
 */

public interface EditInfoApi {

    @POST("api/user/editInfo")
    @FormUrlEncoded
    Observable<HttpResult<UserModelBean>> editInfo(@Field("nickname") String nickname,
                                                   @Field("name") String name,
                                                   @Field("user_id") String userId);
}
