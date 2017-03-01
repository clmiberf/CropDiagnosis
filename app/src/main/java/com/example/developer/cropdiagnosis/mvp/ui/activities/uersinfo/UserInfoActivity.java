package com.example.developer.cropdiagnosis.mvp.ui.activities.uersinfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.mvp.presenter.UserInfoPresenter;
import com.example.developer.cropdiagnosis.mvp.ui.activities.base.BaseActivity;
import com.example.developer.cropdiagnosis.mvp.view.UserInfoView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class UserInfoActivity extends BaseActivity implements UserInfoView {

    @BindView(R.id.user_account)
    TextView userAccount;
    @BindView(R.id.plant_variety)
    TextView variety;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.user_id)
    TextView userId;
    @BindView(R.id.uer_location_selection)
    Spinner mspinLocation;
    @BindView(R.id.user_open_vip)
    Button userOpenVip;
    @BindView(R.id.btn_account_safe)
    Button btnAccountSafe;
    @BindView(R.id.content_user_information)
    LinearLayout contentUserInformation;
    UserInfoPresenter userInfoPresenter = new UserInfoPresenter();

    private ArrayAdapter<String> locationAdapter = null;

    @Override
    public int getLayoutId() {
        return R.layout.content_user_information;
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
        userInfoPresenter.attachView(this);
        userInfoPresenter.onCreate(savedInstanceState);
    }

    @Override
    protected void initializeInjector() {

    }



    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void loadUserAccount(String account) {
        userAccount.setText(account);
    }

    @Override
    public void loadUserVariety(String userVariety) {
        variety.setText(userVariety);
    }

    @Override
    public void loadUserName(String userNameText) {
        userName.setText(userNameText);
    }

    @Override
    public void loadUserId(String userIdText) {
        userId.setText(userIdText);
    }

    @Override
    public void loadUserSafeOnclik() {

    }

    @Override
    public void loadUserLocationSpinner(List<String> locationList) {
        locationAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, locationList);
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspinLocation.setAdapter(locationAdapter);
    }

    @OnClick({R.id.user_open_vip, R.id.btn_account_safe})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_open_vip:
                break;
            case R.id.btn_account_safe:
                Intent intent = new Intent(UserInfoActivity.this, UserInfoSafeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
