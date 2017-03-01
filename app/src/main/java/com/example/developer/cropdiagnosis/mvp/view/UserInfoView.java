package com.example.developer.cropdiagnosis.mvp.view;

import com.example.developer.cropdiagnosis.mvp.view.base.BaseView;

import java.util.List;

/**
 * Created by clmiberf on 2017/3/1.
 */

public interface UserInfoView extends BaseView {


    void initUserAccount(String account);
    void initUserVariety(String variety);
    void initUserName(String userName);
    void initUserId(String userId);
    void initUserSafeOnclik();
    void initUserLocationSpinner(List<String> locationList);
}
