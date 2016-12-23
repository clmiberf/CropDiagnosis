package com.example.developer.cropdiagnosis.mvp.presenter.factory;

import com.example.developer.cropdiagnosis.mvp.presenter.impls.LoginPresenterImpl;
import com.example.developer.cropdiagnosis.mvp.presenter.interfaces.LoginPresenter;

/**
 * Created by Developer on 16-12-15.
 * Wang Cheng is a intelligent Android developer.
 */

public class LoginControllerFactory {
    public static LoginPresenter createLoginController() {
        return new LoginPresenterImpl();
    }
}
