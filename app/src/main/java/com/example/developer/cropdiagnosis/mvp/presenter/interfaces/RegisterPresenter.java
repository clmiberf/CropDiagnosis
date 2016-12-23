package com.example.developer.cropdiagnosis.mvp.presenter.interfaces;

import com.example.developer.cropdiagnosis.mvp.presenter.interfaces.base.BasePresenter;

/**
 * Created by Developer on 16-12-23.
 * Wang Cheng is a intelligent Android developer.
 */

public interface RegisterPresenter extends BasePresenter {
    void register(String phoneNumber,
                  String password,
                  int userType,
                  String province,
                  String city,
                  String county,
                  String village);
}
