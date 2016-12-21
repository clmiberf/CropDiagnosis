package com.example.developer.cropdiagnosis.shared;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.developer.cropdiagnosis.CropApplication;
import com.example.developer.cropdiagnosis.mvp.model.beans.UserModelBean;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Developer on 16-12-21.
 * Wang Cheng is a intelligent Android developer.
 */

public class ConfigManager {
    private static final String USER_SHARES = "user_shares";
    private static final String USER_ID = "user_id";
    private static final String USER_CROPS = "user_crops";
    private static final String USER_PASSWORD = "user_password";
    private static final String USER_EMAIL = "user_email";
    private static final String USER_ID_NUMBER = "user_id_number";
    private static final String USER_CITY = "user_city";
    private static final String USER_COUNTY = "user_county";
    private static final String USER_PHONE_NUMBER = "user_phone_number";
    private static final String USER_VILLAGE = "user_village";
    private static final String USER_PROVINCE = "user_province";

    public static boolean saveUserInfo(UserModelBean bean) {
        SharedPreferences.Editor edit = CropApplication.getInstance().getSharedPreferences(USER_SHARES, Context.MODE_PRIVATE).edit();
        edit.putString(USER_PASSWORD, bean.password);
        edit.putString(USER_EMAIL, bean.email);
        edit.putString(USER_ID_NUMBER, bean.idNumber);
        edit.putString(USER_CITY, bean.city);
        edit.putString(USER_COUNTY, bean.county);
        edit.putString(USER_PHONE_NUMBER, bean.phoneNumber);
        edit.putString(USER_VILLAGE, bean.village);
        edit.putString(USER_PROVINCE, bean.province);
        edit.putStringSet(USER_CROPS, new HashSet<>(bean.crops));
        edit.commit();
        return true;
    }

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
