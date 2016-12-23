package com.example.developer.cropdiagnosis.mvp.presenter.impls;

import com.example.developer.cropdiagnosis.mvp.model.beans.UserModelBean;
import com.example.developer.cropdiagnosis.mvp.model.impls.LoginModelApiImpl;
import com.example.developer.cropdiagnosis.mvp.model.interfaces.LoginModelApi;
import com.example.developer.cropdiagnosis.mvp.presenter.impls.base.BasePresenterImpl;
import com.example.developer.cropdiagnosis.mvp.presenter.interfaces.LoginPresenter;
import com.example.developer.cropdiagnosis.mvp.view.LoginView;

/**
 * Created by Developer on 16-12-15.
 * Wang Cheng is a intelligent Android developer.
 */

public class LoginPresenterImpl extends BasePresenterImpl<LoginView, UserModelBean> implements LoginPresenter {

    private LoginModelApi api = null;

    public LoginPresenterImpl() {
        super.onCreate();
        api = new LoginModelApiImpl();
    }

    @Override
    public void login(String username, String password) {
        if (api != null) {
            beforeRequest();
            mSubscription = api.login(username, password, this);
        }
    }

    @Override
    public void success(UserModelBean data) {
        super.success(data);
        mBaseView.loginSuccess();
    }

    @Override
    public void onError(String errorMsg) {
        super.onError(errorMsg);
        mBaseView.loginFailed(errorMsg);
    }
}
