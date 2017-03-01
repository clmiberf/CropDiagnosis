package com.example.developer.cropdiagnosis.mvp.view;

import com.example.developer.cropdiagnosis.mvp.view.base.BaseView;

import java.util.List;

/**
 * Created by clmiberf on 2017/3/1.
 */

public interface UserInfoSafeView extends BaseView {
    void initSafeUserAccount(String account);
    void initSafeUserQQ(String qq);
    void initSafeUserWeChat(String weChat);
    void initSafeTelephone(String telephone);
    void initSafeUserMailbox(String mailbox);
    void initSafeChangePassword();
}
