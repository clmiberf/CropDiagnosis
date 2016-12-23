package com.example.developer.cropdiagnosis.mvp.model.interfaces;

import com.example.developer.cropdiagnosis.mvp.model.beans.UserModelBean;
import com.example.developer.cropdiagnosis.mvp.presenter.interfaces.base.RequestCallback;

import rx.Subscription;

/**
 * Created by Developer on 16-12-23.
 * Wang Cheng is a intelligent Android developer.
 */

public interface LoginModelApi {
    Subscription login(String username, String password, RequestCallback<UserModelBean> callback);
}
