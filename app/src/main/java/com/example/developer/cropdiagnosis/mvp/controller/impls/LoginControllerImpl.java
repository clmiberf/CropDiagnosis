package com.example.developer.cropdiagnosis.mvp.controller.impls;

import com.example.developer.cropdiagnosis.mvp.controller.interfaces.ILoginController;
import com.example.developer.cropdiagnosis.network.HttpMethod;
import com.example.developer.cropdiagnosis.mvp.ui.activities.LoginActivity;

/**
 * Created by Developer on 16-12-15.
 * Wang Cheng is a intelligent Android developer.
 */

public class LoginControllerImpl implements ILoginController {
    @Override
    public void login(String username, String password, LoginActivity.LoginCallback callback) {
        HttpMethod.getInstance().login(username, password, callback);
    }
}
