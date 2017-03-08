package com.example.developer.cropdiagnosis.mvp.ui.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.mvp.model.beans.UserModelBean;
import com.example.developer.cropdiagnosis.mvp.model.impls.LoginModelApiImpl;
import com.example.developer.cropdiagnosis.mvp.ui.activities.base.BaseActivity;
import com.example.developer.cropdiagnosis.mvp.ui.component.interfaces.IMessagePromptDialog;
import com.example.developer.cropdiagnosis.mvp.view.LoginView;

import java.io.FileInputStream;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView {

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
                login();
                break;
        }
    }

    private IMessagePromptDialog messageDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initializeInjector() {

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
    }

    @Override
    protected void initViews() {
        // 初始化 ProgressDialog 和 MessageDialog
    }

    private boolean checkValueEmpty() {
        return false;
    }

    public void login() {
        LoginModelApiImpl loginModelApi = new LoginModelApiImpl();
        loginModelApi.login(etUsername.getText().toString(), etPassword.getText().toString(), this);
    }

    @Override
    public void showProgress() {
    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void loginSuccess(UserModelBean user) {
        pbLoad.setVisibility(View.GONE);
        if (user != null ) {
            saveToPreference(user);
        }
        Intent it = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(it);
        finish();
    }

    @Override
    public void loginFailed(String msg) {
    }

    private void saveToPreference(UserModelBean user) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this).edit();
        editor.putInt("user_Type", user.user_Type);
        editor.putString("user_Tel", user.user_Tel);
        editor.putString("city", user.city);
        editor.putString("user_Password", user.user_Password);
        editor.putString("IDcard", user.IDcard);
        editor.putString("county", user.county);
        editor.putString("user_Email", user.user_Email);
        editor.putString("user_Name", user.user_Name);
        editor.putString("province", user.province);
        editor.putString("user_Id", user.user_Id);
        editor.putString("user_Money", user.user_Money);
        editor.putString("village", user.village);
        editor.putBoolean("isLogined", true);
        editor.apply();
    }

}
