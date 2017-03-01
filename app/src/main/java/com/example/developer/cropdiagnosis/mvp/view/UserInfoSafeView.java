package com.example.developer.cropdiagnosis.mvp.view;

import com.example.developer.cropdiagnosis.mvp.view.base.BaseView;

import java.util.List;

/**
 * Created by clmiberf on 2017/3/1.
 */

public interface UserInfoSafeView extends BaseView {
    void loadSafeUserAccount(String account);
    void loadSafeUserQQ(String qq);
    void loadSafeUserWeChat(String weChat);
    void loadSafeTelephone(String telephone);
    void loadSafeUserMailbox(String mailbox);
}
