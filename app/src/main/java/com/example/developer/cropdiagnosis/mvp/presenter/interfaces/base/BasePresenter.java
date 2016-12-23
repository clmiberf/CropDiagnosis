package com.example.developer.cropdiagnosis.mvp.presenter.interfaces.base;

import android.support.annotation.NonNull;

import com.example.developer.cropdiagnosis.mvp.view.base.BaseView;

/**
 * Created by Developer on 16-12-23.
 */

public interface BasePresenter {
    // when presenter created.
    void onCreate();

    // when BaseView is attached to presenter.
    void attachView(@NonNull BaseView view);

    // when BaseView is destoryed.
    void onDestory();
}
