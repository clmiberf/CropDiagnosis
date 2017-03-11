package com.example.developer.cropdiagnosis.mvp.presenter;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.developer.cropdiagnosis.mvp.view.UserInfoView;
import com.example.developer.cropdiagnosis.network.HttpResult;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by xiang on 2017/3/1.
 */

public class UserInfoPresenter extends BasePresenter<UserInfoView> {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        initData();
    }

    //假数据在这里
    private void initData() {
        List<String> list = new ArrayList<>();
        list.add("北京");
        list.add("上海");
        list.add("武汉");
        list.add("广州");
        loadUserAccount("123456");
        loadUserVariety("variety");
        loadUserId("id");
        loadUserName("xiangsanliu");
        loadUserLocationSpinner(list);
    }

    //从本地获取id和password
    String id = null;
    String password = null;

    //获取数据就在这里
    public void getData(SharedPreferences preferences) {
        loadUserAccount(preferences.getString("user_Id", "123456"));
        loadUserName(preferences.getString("user_Name", "项三六"));
        loadUserId(preferences.getString("IDcard", "3623***********"));
    }

    public void onGetDataSuccess() {

    }

    private void loadUserAccount(String account) {
        mView.loadUserAccount(account);
    }

    private void loadUserVariety(String variety) {
        mView.loadUserVariety(variety);
    }

    private void loadUserName(String userName) {
        mView.loadUserName(userName);
    }
    private void loadUserId(String userId) {
        mView.loadUserId(userId);
    }
    private void loadUserLocationSpinner(List<String> locationList) {
        mView.loadUserLocationSpinner(locationList);
    }

}
