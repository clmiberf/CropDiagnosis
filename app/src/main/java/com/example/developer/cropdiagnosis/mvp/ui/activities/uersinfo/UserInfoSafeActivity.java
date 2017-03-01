package com.example.developer.cropdiagnosis.mvp.ui.activities.uersinfo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.mvp.ui.activities.base.BaseActivity;
import com.example.developer.cropdiagnosis.mvp.view.UserInfoSafeView;

import org.w3c.dom.Text;

import butterknife.BindView;

public class UserInfoSafeActivity extends BaseActivity implements UserInfoSafeView{
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
    @BindView(R.id.user_safe_change_password)
    Button safeChangePwBtn;



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
        initSafeChangePassword();
    }

    @Override
    public void initSafeUserAccount(String account) {
        this.safeAccount.setText(account);
    }

    @Override
    public void initSafeUserQQ(String qq) {
        this.safeQQ.setText(qq);
    }

    @Override
    public void initSafeUserWeChat(String weChat) {
        this.safeWeChat.setText(weChat);
    }

    @Override
    public void initSafeTelephone(String telephone) {
        this.safeTelephone.setText(telephone);
    }

    @Override
    public void initSafeUserMailbox(String mailbox) {
        this.safeMailbox.setText(mailbox);
    }

    @Override
    public void initSafeChangePassword() {
        safeChangePwBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UserInfoSafeActivity.this,"敬请期待",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
