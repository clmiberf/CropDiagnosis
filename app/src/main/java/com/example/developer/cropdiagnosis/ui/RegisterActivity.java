package com.example.developer.cropdiagnosis.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.model.beans.UserModelBean;
import com.example.developer.cropdiagnosis.view.interfaces.IMessagePromptDialog;
import com.example.developer.cropdiagnosis.view.interfaces.IProgressDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

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
    @BindView(R.id.spin_country_register)
    Spinner spinCountry;
    @BindView(R.id.et_village_register)
    EditText etVillage;
    @BindView(R.id.btn_register_register)
    Button btnRegister;
    @BindView(R.id.btn_reset_register)
    Button btnReset;
    @BindView(R.id.activity_register)
    LinearLayout activity;

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

    public interface RegisterCallback {
        void onGetCheckCodeSuccess(String checkCode);

        void onGetCheckCodeFailed();

        void onRegisterSuccess();

        void onRegisterFailed();
    }

    private IProgressDialog progressDialog = null;
    private IMessagePromptDialog messageDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        // 初始化 progressDialog 和 messageDialog
    }

    private void getCheckCode() {
        progressDialog.showProgressDialog();
    }

    private void register(UserModelBean user) {
        progressDialog.showProgressDialog();
    }
}
