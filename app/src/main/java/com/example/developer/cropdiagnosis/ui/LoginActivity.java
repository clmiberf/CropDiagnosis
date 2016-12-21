package com.example.developer.cropdiagnosis.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.controller.factory.LoginControllerFactory;
import com.example.developer.cropdiagnosis.controller.interfaces.ILoginController;
import com.example.developer.cropdiagnosis.model.beans.UserModelBean;
import com.example.developer.cropdiagnosis.view.interfaces.IMessagePromptDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

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

    public interface LoginCallback {
        void onLoginFailed();

        void onLoginSuccess(UserModelBean bean);
    }

    private IMessagePromptDialog messageDialog;
    private ILoginController controller;
    private LoginCallback callback = new LoginCallback() {
        @Override
        public void onLoginFailed() {
            pbLoad.setVisibility(View.GONE);
        }

        @Override
        public void onLoginSuccess(UserModelBean userModelBean) {
            pbLoad.setVisibility(View.GONE);
            Intent it = new Intent(LoginActivity.this, HomeActivity.class);
            setResult(RESULT_OK);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);

        initConfig();
        initView();
    }

    private void initConfig() {
        controller = LoginControllerFactory.createLoginController();
    }

    private void initView() {
        // 初始化 ProgressDialog 和 MessageDialog
    }

    private boolean checkValueEmpty() {
        return false;
    }

    private void login() {
        pbLoad.setVisibility(View.VISIBLE);
        controller.login(etUsername.getText().toString().trim(), etPassword.getText().toString().trim(), callback);
    }
}
