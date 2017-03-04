package com.example.developer.cropdiagnosis.mvp.model.impls;

import com.example.developer.cropdiagnosis.mvp.model.beans.UserModelBean;
import com.example.developer.cropdiagnosis.mvp.model.interfaces.UserInfoModelApi;
import com.example.developer.cropdiagnosis.mvp.view.UserInfoView;
import com.example.developer.cropdiagnosis.network.HttpMethod;
import com.example.developer.cropdiagnosis.network.HttpResult;
import com.example.developer.cropdiagnosis.network.apis.UserInfoApi;

import java.util.List;

import rx.Observable;
import rx.Subscription;

/**
 * Created by xiang on 2017/3/3.
 */

public class UserInfoModelApiImpl implements UserInfoModelApi {
    @Override
    public Subscription getUserInfo(String id, String password, UserInfoView view) {
        return HttpMethod.getInstance().getUserInfo(id, password, view);
    }
}
