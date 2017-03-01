package com.example.developer.cropdiagnosis.mvp.presenter;

import android.os.Bundle;

import com.example.developer.cropdiagnosis.mvp.view.UserInfoView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiang on 2017/3/1.
 */

public class UserInfoPresenter extends BasePresenter<UserInfoView> {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
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

    //获取数据就在这里
    public void getData() {

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
