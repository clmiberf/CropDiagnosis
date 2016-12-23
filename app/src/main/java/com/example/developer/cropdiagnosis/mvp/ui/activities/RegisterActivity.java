package com.example.developer.cropdiagnosis.mvp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.mvp.model.beans.UserModelBean;
import com.example.developer.cropdiagnosis.mvp.presenter.impls.RegisterPresenterImpl;
import com.example.developer.cropdiagnosis.mvp.presenter.interfaces.RegisterPresenter;
import com.example.developer.cropdiagnosis.mvp.ui.activities.base.BaseActivity;
import com.example.developer.cropdiagnosis.mvp.ui.component.interfaces.IMessagePromptDialog;
import com.example.developer.cropdiagnosis.mvp.ui.component.interfaces.IProgressDialog;
import com.example.developer.cropdiagnosis.mvp.view.RegisterView;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterView {

    @BindView(R.id.et_tel_number_register)
    EditText etTelNumber;
    @BindView(R.id.et_check_code_register)
    EditText etCheckCode;
    @BindView(R.id.et_password_register)
    EditText etPassword;
    @BindView(R.id.et_repassword_register)
    EditText etRepassword;
    @BindView(R.id.rd_person_register)
    RadioButton rdPerson;
    @BindView(R.id.rd_company_register)
    RadioButton rdCompany;
    @BindView(R.id.spin_province_register)
    Spinner spinProvince;
    @BindView(R.id.spin_city_register)
    Spinner spinCity;
    @BindView(R.id.spin_county_register)
    Spinner spinCountry;
    @BindView(R.id.et_village_register)
    EditText etVillage;
    @BindView(R.id.btn_register_register)
    Button btnRegister;
    @BindView(R.id.btn_reset_register)
    Button btnReset;
    @BindView(R.id.activity_register)
    LinearLayout activity;
    @BindView(R.id.pb_load_register)
    ProgressBar pbLoad;

    @OnClick({R.id.rd_person_register, R.id.rd_company_register, R.id.btn_register_register, R.id.btn_reset_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rd_person_register:
                break;
            case R.id.rd_company_register:
                break;
            case R.id.btn_register_register:
                Intent it = new Intent(RegisterActivity.this, HomeActivity.class);
                setResult(RESULT_OK);
                finish();
                break;
            case R.id.btn_reset_register:
                break;
        }
    }

    private IProgressDialog progressDialog = null;
    private IMessagePromptDialog messageDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initVariables() {
        initPresenter();
    }

    private void initPresenter() {
        mPresenter = new RegisterPresenterImpl();
        mPresenter.attachView(this);
        mPresenter.onCreate();
    }

    @Override
    protected void initViews() {
        // 初始化 progressDialog 和 messageDialog
    }

    private void getCheckCode() {
        progressDialog.showProgressDialog();
    }

    private void register(UserModelBean user) {
        progressDialog.showProgressDialog();
    }

    @Override
    public void registerSuccess() {
        Intent it = new Intent(RegisterActivity.this, HomeActivity.class);
        startActivity(it);
        finish();
    }

    @Override
    public void registerFailed(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        pbLoad.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbLoad.setVisibility(View.GONE);
    }
}
