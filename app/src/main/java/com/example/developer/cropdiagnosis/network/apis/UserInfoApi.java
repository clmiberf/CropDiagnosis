package com.example.developer.cropdiagnosis.network.apis;

import com.example.developer.cropdiagnosis.mvp.model.UserModel;
import com.example.developer.cropdiagnosis.mvp.model.beans.DiseaseModelBean;
import com.example.developer.cropdiagnosis.mvp.model.beans.UserModelBean;
import com.example.developer.cropdiagnosis.network.HttpResult;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by xiang on 2017/3/3.
 */

public interface UserInfoApi {

    @GET("userInfo")
    Observable<HttpResult<List<UserModelBean>>> getUserInfo(String id, String password);


}
