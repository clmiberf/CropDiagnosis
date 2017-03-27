package com.example.developer.cropdiagnosis.network.apis;

import com.example.developer.cropdiagnosis.mvp.model.beans.UserModelBean;
import com.example.developer.cropdiagnosis.network.HttpResult;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by socer on 17-3-27.
 */

public interface DiagnoseApi {

    @POST("api/user/diagnoseResultEva")
    @FormUrlEncoded
    Observable<HttpResult<UserModelBean>> editInfo(@Field("evaluation") String eva
                                                   );
}
