package com.example.developer.cropdiagnosis.mvp.model.interfaces;

import com.example.developer.cropdiagnosis.mvp.view.RegisterView;

import rx.Subscription;

/**
 * Created by Developer on 16-12-23.
 * Wang Cheng is a intelligent Android developer.
 */

public interface RegisterModelApi {
    Subscription register(String phoneNumber, String password, RegisterView view);
}
