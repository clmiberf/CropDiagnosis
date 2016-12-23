package com.example.developer.cropdiagnosis.mvp.presenter.interfaces.base;

/**
 * Created by Developer on 16-12-23.
 * Wang Cheng is a intelligent Android developer.
 */

public interface RequestCallback<T> {
    void beforeRequest();

    void success(T data);

    void onError(String errorMsg);
}
