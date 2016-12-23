package com.example.developer.cropdiagnosis.mvp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.mvp.presenter.impls.LoginPresenterImpl;
import com.example.developer.cropdiagnosis.mvp.presenter.interfaces.LoginPresenter;
import com.example.developer.cropdiagnosis.mvp.ui.activities.base.BaseActivity;
import com.example.developer.cropdiagnosis.mvp.ui.component.interfaces.IMessagePromptDialog;
import com.example.developer.cropdiagnosis.mvp.view.LoginView;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    @BindView(R.id.et_username_login)
    EditText etUsername;
    @BindView(R.id.et_password_login)
    EditText etPassword;
    @BindView(R.id.btn_forget_pwsd_login)
    Button btnForgetPwsd;
    @BindView(R.id.btn_login_login)
    Button btnLogin;
    @BindView(R.id.pb_load_login)
    ProgressBar pbLoad;

    @OnClick({R.id.et_username_login, R.id.et_password_login, R.id.btn_forget_pwsd_login, R.id.btn_login_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.et_username_login:
                break;
            case R.id.et_password_login:
                break;
            case R.id.btn_forget_pwsd_login:
                break;
            case R.id.btn_login_login:
                login(etUsername.getText().toString().trim(), etPassword.getText().toString().trim());
                break;
        }
    }

    private IMessagePromptDialog messageDialog;
//    private LoginCallback callback = new LoginCallback() {
//        @Override
//        public void onLoginFailed(String message) {
//            pbLoad.setVisibility(View.GONE);
//            Toast.makeText(LoginActivity.this, "failed" + message, Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        public void onLoginSuccess(UserModelBean userModelBean) {

//        }
//    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initVariables() {
        initPrsenter();
    }

    private void initPrsenter() {
        mPresenter = new LoginPresenterImpl();
        mPresenter.attachView(this);
    }

    @Override
    protected void initViews() {
        // 初始化 ProgressDialog 和 MessageDialog
    }

    private boolean checkValueEmpty() {
        return false;
    }

    public void login(String username, String password) {
        pbLoad.setVisibility(View.VISIBLE);
        mPresenter.login(username, password);
    }

    @Override
    public void showProgress() {
    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void loginSuccess() {
        pbLoad.setVisibility(View.GONE);
        Intent it = new Intent(LoginActivity.this, HomeActivity.class);
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public void loginFailed(String msg) {

    }
}
