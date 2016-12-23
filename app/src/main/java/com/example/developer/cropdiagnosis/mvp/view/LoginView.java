package com.example.developer.cropdiagnosis.mvp.view;

import com.example.developer.cropdiagnosis.mvp.view.base.BaseView;

/**
 * Created by Developer on 16-12-23.
 * Wang Cheng is a intelligent Android developer.
 */

public interface LoginView extends BaseView {
    void loginSuccess();

    void loginFailed(String msg);
}
