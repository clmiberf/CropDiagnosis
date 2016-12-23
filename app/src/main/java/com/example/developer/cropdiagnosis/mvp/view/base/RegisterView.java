package com.example.developer.cropdiagnosis.mvp.view.base;

/**
 * Created by Developer on 16-12-23.
 * Wang Cheng is a intelligent Android developer.
 */

public interface RegisterView extends BaseView {
    void registerSuccess();

    void registerFailed(String errorMsg);
}
