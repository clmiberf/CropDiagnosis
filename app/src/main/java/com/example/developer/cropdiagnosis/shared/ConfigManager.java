package com.example.developer.cropdiagnosis.shared;

import android.content.Context;

import com.example.developer.cropdiagnosis.CropApplication;

import java.util.Set;

/**
 * Created by Developer on 16-12-21.
 * Wang Cheng is a intelligent Android developer.
 */

public class ConfigManager {
    private static final String USER_SHARES = "user_shares";
    private static final String USER_ID = "user_id";
    private static final String USER_CROPS = "user_crops";

    /**
     * 获取用户的id
     *
     * @param context
     * @return 用户的id
     */
    public static String getUserId(Context context) {
        return CropApplication.getInstance().getSharedPreferences(USER_SHARES, Context.MODE_PRIVATE).getString(USER_ID, null);
    }

    /**
     * 获取用户关注的作物
     *
     * @param context
     * @return
     */
    public static Set<String> getCrops(Context context) {
        return CropApplication.getInstance().getSharedPreferences(USER_SHARES, Context.MODE_PRIVATE).getStringSet(USER_CROPS, null);
    }
}
