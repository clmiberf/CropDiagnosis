package com.example.developer.cropdiagnosis.controller.interfaces;

import com.example.developer.cropdiagnosis.ui.LoginActivity;

/**
 * Created by Developer on 16-12-15.
 * Wang Cheng is a intelligent Android developer.
 */

public interface ILoginController {
    void login(String username, String password, LoginActivity.LoginCallback callback);
}
