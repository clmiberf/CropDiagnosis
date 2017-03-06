package com.example.developer.cropdiagnosis.mvp.model.beans;

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

    /**
     * 电话号码
     */
    public String user_Tel;

    /**
     * 身份证号
     */
    public String user_IDcard;

    /**
     * 用户账号密码
     */
    public String password;

    /**
     * 用户账号id
     */
    public String user_Id;

    /**
     * 用户账号名
     */
    public String username;
    /**
     * 用户所在省
     */
    public String province;

    /**
     * 用户所在市
     */
    public String city;

    /**
     * 用户所在县
     */
    public String county;

    /**
     * 用户所在村
     */
    public String village;

    /**
     * 用户关注的作物
     */
    public List<String> crops;

    /**
     * 用户的邮箱
     */
    public String email;

    /**
     * 用户类型 “公司”还是“个人”
     */
    public int userType;



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
