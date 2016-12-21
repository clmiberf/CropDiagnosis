package com.example.developer.cropdiagnosis.mvp.controller.interfaces;

import com.example.developer.cropdiagnosis.mvp.ui.activities.LoginActivity;

/**
 * Created by Developer on 16-12-15.
 * Wang Cheng is a intelligent Android developer.
 */

public interface ILoginController {
    void login(String username, String password, LoginActivity.LoginCallback callback);
}
