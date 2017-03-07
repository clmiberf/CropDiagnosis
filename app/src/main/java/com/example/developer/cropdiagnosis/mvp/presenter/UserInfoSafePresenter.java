package com.example.developer.cropdiagnosis.mvp.presenter;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.developer.cropdiagnosis.mvp.view.UserInfoSafeView;

import javax.inject.Inject;

/**
 * Created by xiang on 2017/3/1.
 */

public class UserInfoSafePresenter extends BasePresenter<UserInfoSafeView> {

    @Inject
    public UserInfoSafePresenter() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        initData();
    }

    //获取数据就在这里
    public void getData(SharedPreferences preferences) {
        loadSafeUserAccount(preferences.getString("user_Id", "123456"));
        loadSafeTelephone(preferences.getString("user_Tel", "12345678910"));
        loadSafeUserMailbox(preferences.getString("user_Email", "34543213@qq.com"));
    }

    //假数据在这里
    private void initData() {
        loadSafeTelephone("13838438");
        loadSafeUserWeChat("weChat");
        loadSafeUserMailbox("xiangsanliu@gmail.com");
        loadSafeUserAccount("123456");
        loadSafeUserQQ("12345678");
    }

    private void loadSafeUserAccount(String account) {
        mView.loadSafeUserAccount(account);
    }
    private void loadSafeUserQQ(String qq){
        mView.loadSafeUserQQ(qq);

    }
    private void loadSafeUserWeChat(String weChat){
        mView.loadSafeUserWeChat(weChat);
    }
    private void loadSafeTelephone(String telephone){
        mView.loadSafeTelephone(telephone);
    }
    private void loadSafeUserMailbox(String mailbox){
        mView.loadSafeUserMailbox(mailbox);
    }

}
