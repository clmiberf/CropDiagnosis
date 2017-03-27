package com.example.developer.cropdiagnosis.mvp.model.impls;

import com.example.developer.cropdiagnosis.mvp.model.interfaces.RegisterModelApi;
import com.example.developer.cropdiagnosis.mvp.view.RegisterView;
import com.example.developer.cropdiagnosis.network.HttpMethod;

import rx.Subscription;

/**
 * Created by Developer on 16-12-23.
 * Wang Cheng is a intelligent Android developer.
 */

public class RegisterModelApiImpl implements RegisterModelApi {
    @Override
    public Subscription register(String phoneNumber, String password,String checkCode,RegisterView view) {
        return HttpMethod.getInstance().register(phoneNumber, password,checkCode,view);
    }
}
