package com.example.developer.cropdiagnosis.mvp.controller.factory;

import com.example.developer.cropdiagnosis.mvp.controller.impls.LoginControllerImpl;
import com.example.developer.cropdiagnosis.mvp.controller.interfaces.ILoginController;

/**
 * Created by Developer on 16-12-15.
 * Wang Cheng is a intelligent Android developer.
 */

public class LoginControllerFactory {
    public static ILoginController createLoginController() {
        return new LoginControllerImpl();
    }
}
