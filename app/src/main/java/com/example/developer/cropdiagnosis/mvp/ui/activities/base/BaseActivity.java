package com.example.developer.cropdiagnosis.mvp.ui.activities.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import com.example.developer.cropdiagnosis.shared.ThemeManager;

import butterknife.ButterKnife;

/**
 * Created by Developer on 16-12-17.
 * Wang Cheng is a intelligent Android developer.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public abstract int getLayoutId();

    // 先初始化配置，在初始化布局
    protected abstract void initViews();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutId();
        setNigthOrDayMode();
        setContentView(layoutId);
        ButterKnife.bind(this);
        initViews();
    }

    private void setNigthOrDayMode() {
        if (ThemeManager.isNightMode()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

}
