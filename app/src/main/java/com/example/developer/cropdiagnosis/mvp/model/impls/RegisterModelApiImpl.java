package com.example.developer.cropdiagnosis.mvp.model.impls;

import com.example.developer.cropdiagnosis.mvp.model.beans.UserModelBean;
import com.example.developer.cropdiagnosis.mvp.model.interfaces.RegisterModelApi;
import com.example.developer.cropdiagnosis.mvp.presenter.interfaces.base.RequestCallback;
import com.example.developer.cropdiagnosis.network.HttpMethod;

import rx.Subscription;

/**
 * Created by Developer on 16-12-23.
 * Wang Cheng is a intelligent Android developer.
 */

public class RegisterModelApiImpl implements RegisterModelApi {
    @Override
    public Subscription register(String phoneNumber, String password, int userType, String province, String city, String county, String village, RequestCallback<UserModelBean> callback) {
        return HttpMethod.getInstance().register(phoneNumber, password, userType, province, city, county, village, callback);
    }
}
