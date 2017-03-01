package com.example.developer.cropdiagnosis.mvp.ui.activities.uersinfo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.dagger2.component.DaggerActivityComponent;
import com.example.developer.cropdiagnosis.dagger2.module.ActivityModule;
import com.example.developer.cropdiagnosis.mvp.presenter.UserInfoSafePresenter;
import com.example.developer.cropdiagnosis.mvp.ui.activities.base.BaseActivity;
import com.example.developer.cropdiagnosis.mvp.view.UserInfoSafeView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class UserInfoSafeActivity extends BaseActivity implements UserInfoSafeView {
    @BindView(R.id.user_safe_account)
    TextView safeAccount;
    @BindView(R.id.user_safe_qq)
    TextView safeQQ;
    @BindView(R.id.user_safe_wechat)
    TextView safeWeChat;
    @BindView(R.id.user_safe_telephone)
    TextView safeTelephone;
    @BindView(R.id.user_safe_mailbox)
    TextView safeMailbox;
    @BindView(R.id.content_user_info_safe)
    LinearLayout contentUserInfoSafe;
    @BindView(R.id.user_safe_change_password)
    Button userSafeChangePassword;

    @Inject
    UserInfoSafePresenter mPresenter = new UserInfoSafePresenter();

    @Override
    public int getLayoutId() {
        return R.layout.content_user_info_safe;
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.attachView(this);
        mPresenter.onCreate(savedInstanceState);
    }

    @Override
    protected void initializeInjector() {
//        DaggerActivityComponent.builder()
//                .activityModule(new ActivityModule(this))
//                .build()
//                .inject(this);
    }

    @Override
    public void loadSafeUserAccount(String account) {
        safeAccount.setText(account);
    }

    @Override
    public void loadSafeUserQQ(String qq) {
        safeQQ.setText(qq);
    }

    @Override
    public void loadSafeUserWeChat(String weChat) {
        safeWeChat.setText(weChat);
    }

    @Override
    public void loadSafeTelephone(String telephone) {
        safeTelephone.setText(telephone);
    }

    @Override
    public void loadSafeUserMailbox(String mailbox) {
        safeMailbox.setText(mailbox);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @OnClick(R.id.user_safe_change_password)
    public void onClick() {
        Toast.makeText(UserInfoSafeActivity.this, "敬请期待", Toast.LENGTH_SHORT).show();
    }
}
