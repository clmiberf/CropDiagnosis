package com.example.developer.cropdiagnosis.mvp.model.beans;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Developer on 16-12-14.
 * 用来保存用户信息
 */

public class UserModelBean {

    /**
     * Default constructor
     */
    public UserModelBean() {
    }

    public int user_Type;
    public String user_Tel;
    public String city;
    public String user_Password;
    public String IDcard;
    public String county;
    public String user_Email;
    public String user_Name;
    public String province;
    public String user_Id;
    public String user_Money;
    public String village;

    public Bitmap user_Photo;

    List<String> crops;



    /**
     * 检查UserModelBean的值是否合法
     *
     * @return
     */
    public boolean checkRegisterValue() {
        // TODO implement here
        return false;
    }
}
