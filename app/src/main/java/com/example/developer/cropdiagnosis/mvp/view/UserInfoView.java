package com.example.developer.cropdiagnosis.mvp.view;

import com.example.developer.cropdiagnosis.mvp.view.base.BaseView;

import java.util.List;

/**
 * Created by clmiberf on 2017/3/1.
 */

public interface UserInfoView extends BaseView {


    void loadUserAccount(String account);
    void loadUserName(String userName);
    void loadUserId(String userId);
    void loadUserSafeOnclik();
    void loadUserLocationSpinner(List<String> locationList);
    void getUserInfoSuccess();
}
