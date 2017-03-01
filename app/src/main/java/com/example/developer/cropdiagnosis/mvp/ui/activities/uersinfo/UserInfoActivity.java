package com.example.developer.cropdiagnosis.mvp.ui.activities.uersinfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.mvp.ui.activities.base.BaseActivity;
import com.example.developer.cropdiagnosis.mvp.view.UserInfoView;

import java.util.List;

import butterknife.BindView;

public class UserInfoActivity extends BaseActivity implements UserInfoView{

    @BindView(R.id.user_account)
    TextView userAccount;
    @BindView(R.id.user_open_vip)
    Button vipBtn;
    @BindView(R.id.btn_account_safe)
    Button userSafeBtn;
    @BindView(R.id.plant_variety)
    TextView variety;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.user_id)
    TextView userId;
    @BindView(R.id.uer_location_selection)
    Spinner mspinLocation;

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
        initUserSafeOnclik();
    }

    @Override
    public void initUserAccount(String account) {
        this.userAccount.setText(account);
    }

    @Override
    public void initUserVariety(String variety) {
        this.variety.setText(variety);
    }

    @Override
    public void initUserName(String userName) {
        this.userName.setText(userName);
    }

    @Override
    public void initUserId(String userId) {
        this.userId.setText(userId);
    }

    @Override
    public void initUserSafeOnclik() {
        userSafeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserInfoActivity.this,UserInfoSafeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initUserLocationSpinner(List<String> locationList) {
        locationAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,locationList);
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspinLocation.setAdapter(locationAdapter);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
