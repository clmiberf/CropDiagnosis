package com.example.developer.cropdiagnosis.mvp.controller.impls;

import android.text.TextUtils;

import com.example.developer.cropdiagnosis.CropApplication;
import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.mvp.controller.interfaces.ILoginController;
import com.example.developer.cropdiagnosis.mvp.model.beans.UserModelBean;
import com.example.developer.cropdiagnosis.mvp.ui.activities.LoginActivity;
import com.example.developer.cropdiagnosis.network.HttpMethod;
import com.example.developer.cropdiagnosis.network.HttpResult;
import com.example.developer.cropdiagnosis.shared.ConfigManager;

/**
 * Created by Developer on 16-12-15.
 * Wang Cheng is a intelligent Android developer.
 */

public class LoginControllerImpl implements ILoginController {

    public interface LoginCallback {
        void onLoginFailed(Throwable e);

        void onLoginSuccess(HttpResult<UserModelBean> result);
    }

    public class LoginCallbackImpl implements LoginCallback {
        private LoginActivity.LoginCallback callback = null;

        public LoginCallbackImpl(LoginActivity.LoginCallback callback) {
            this.callback = callback;
        }

        @Override
        public void onLoginFailed(Throwable e) {
            callback.onLoginFailed(e.toString());
        }

        @Override
        public void onLoginSuccess(HttpResult<UserModelBean> result) {
            ConfigManager.saveUserInfo(result.getData());
            callback.onLoginSuccess(result.getData());
        }
    }

    @Override
    public void login(String username, String password, LoginActivity.LoginCallback callback) {
        if (TextUtils.isEmpty(username)) {
            callback.onLoginFailed(CropApplication.getInstance().getResources().getString(R.string.username_not_allow_empty));
            return;
        }
        if (TextUtils.isEmpty(password)) {
            callback.onLoginFailed(CropApplication.getInstance().getResources().getString(R.string.password_not_allow_empty));
            return;
        }
        HttpMethod.getInstance().login(username, password, new LoginCallbackImpl(callback));
    }
}
