package com.example.developer.cropdiagnosis.mvp.ui.activities.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.mvp.presenter.BasePresenter;
import com.example.developer.cropdiagnosis.shared.ThemeManager;

import butterknife.ButterKnife;
import rx.Subscription;

/**
 * Created by Developer on 16-12-17.
 * Wang Cheng is a intelligent Android developer.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Subscription mSubscription = null;

    private Toolbar toolbar;

    public abstract int getLayoutId();

    protected abstract void initVariables();

    // 先初始化配置，在初始化布局
    protected abstract void initViews();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getLayoutId();
        setNigthOrDayMode();
        setContentView(layoutId);
        ButterKnife.bind(this);
        initVariables();
        initViews();
        setUpToolbar();
    }

    private void setNigthOrDayMode() {
        if (ThemeManager.isNightMode()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    protected abstract void initializeInjector();

    private void setUpToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null ) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("");
            Log.d("xiangjianjian", "xiangjianjian");
        }
    }

}
