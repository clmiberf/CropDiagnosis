package com.example.developer.cropdiagnosis.controller.factory;

import com.example.developer.cropdiagnosis.controller.impls.LoginControllerImpl;
import com.example.developer.cropdiagnosis.controller.interfaces.ILoginController;

/**
 * Created by Developer on 16-12-15.
 */

public class LoginControllerFactory {
    public static ILoginController createLoginController() {
        return new LoginControllerImpl();
    }
}
