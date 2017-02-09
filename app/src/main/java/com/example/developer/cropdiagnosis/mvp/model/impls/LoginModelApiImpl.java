package com.example.developer.cropdiagnosis.mvp.model.impls;

import com.example.developer.cropdiagnosis.mvp.model.beans.UserModelBean;
import com.example.developer.cropdiagnosis.mvp.model.interfaces.LoginModelApi;
import com.example.developer.cropdiagnosis.mvp.presenter.interfaces.base.RequestCallback;
import com.example.developer.cropdiagnosis.network.HttpMethod;

import rx.Subscription;

/**
 * Created by Developer on 16-12-23.
 * Wang Cheng is a intelligent Android developer.
 */

public class LoginModelApiImpl implements LoginModelApi {
    @Override
    public Subscription login(String username, String password, RequestCallback<UserModelBean> callback) {
        callback.beforeRequest();
        return HttpMethod.getInstance().login(username, password, callback);
    }
}
