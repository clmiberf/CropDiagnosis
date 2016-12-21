package com.example.developer.cropdiagnosis;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

import com.example.developer.cropdiagnosis.shared.ThemeManager;

/**
 * Created by Developer on 16-12-17.
 * Wang Cheng is a intelligent Android developer.
 */

public class CropApplication extends Application {
    private static Context instance;

    public static Context getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initDayNightMode();
    }

    private void initDayNightMode() {
        if (ThemeManager.isNightMode()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}
