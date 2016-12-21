package com.example.developer.cropdiagnosis.shared;

import android.content.Context;

import com.example.developer.cropdiagnosis.CropApplication;

/**
 * Created by Developer on 16-12-17.
 * Wang Cheng is a intelligent Android developer.
 */

public class ThemeManager {
    private static final String CROP_SHARES = "crop_shares";
    private static final String NIGHT_THEME_MODE = "night_mode";

    public static boolean isNightMode() {
        return CropApplication.getInstance().getSharedPreferences(CROP_SHARES, Context.MODE_PRIVATE).getBoolean(NIGHT_THEME_MODE, false);
    }
}
