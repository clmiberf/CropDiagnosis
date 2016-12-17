package com.example.developer.cropdiagnosis.controller.impls;

import com.example.developer.cropdiagnosis.controller.interfaces.ILoginController;
import com.example.developer.cropdiagnosis.network.HttpMethod;
import com.example.developer.cropdiagnosis.ui.LoginActivity;

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
