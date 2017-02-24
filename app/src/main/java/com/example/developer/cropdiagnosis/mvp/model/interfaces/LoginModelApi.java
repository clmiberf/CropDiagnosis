package com.example.developer.cropdiagnosis.mvp.model.interfaces;

import rx.Subscription;

/**
 * Created by Developer on 16-12-23.
 * Wang Cheng is a intelligent Android developer.
 */

public interface LoginModelApi {
    Subscription login(String username, String password);
}
