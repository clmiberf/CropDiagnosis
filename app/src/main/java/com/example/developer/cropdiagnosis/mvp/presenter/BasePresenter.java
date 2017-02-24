package com.example.developer.cropdiagnosis.mvp.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.developer.cropdiagnosis.mvp.view.base.BaseView;

/**
 * Created by Developer on 16-12-23.
 */

public abstract class BasePresenter<T extends BaseView> {
    protected T mView;

    public void onCreate(Bundle savedInstanceState) {
    }

    public void attachView(@NonNull T view) {
        mView = view;
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestory() {
    }
}
