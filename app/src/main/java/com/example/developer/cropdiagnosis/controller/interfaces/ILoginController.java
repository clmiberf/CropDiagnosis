package com.example.developer.cropdiagnosis.controller.interfaces;

import com.example.developer.cropdiagnosis.ui.LoginActivity;

/**
 * Created by Developer on 16-12-15.
 */

public interface ILoginController {
    void login(String username, String password, LoginActivity.LoginCallback callback);
}
