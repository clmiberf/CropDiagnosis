package com.example.developer.cropdiagnosis.mvp.model.interfaces;

import android.text.style.SubscriptSpan;

import com.example.developer.cropdiagnosis.mvp.presenter.UserInfoPresenter;
import com.example.developer.cropdiagnosis.mvp.view.UserInfoView;

import rx.Subscription;

/**
 * Created by xiang on 2017/3/3.
 */

public interface UserInfoModelApi {
    Subscription getUserInfo(String id, String password,UserInfoPresenter presenter);
}
