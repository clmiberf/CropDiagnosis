package com.example.developer.cropdiagnosis.mvp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.mvp.model.impls.EditInfoApiImpl;
import com.example.developer.cropdiagnosis.mvp.ui.activities.base.BaseActivity;
import com.example.developer.cropdiagnosis.mvp.view.EditInfoView;

import butterknife.BindView;
import butterknife.OnClick;
import chihane.jdaddressselector.BottomDialog;
import chihane.jdaddressselector.OnAddressSelectedListener;
import chihane.jdaddressselector.model.City;
import chihane.jdaddressselector.model.County;
import chihane.jdaddressselector.model.Province;
import chihane.jdaddressselector.model.Street;

public class EditInfoActivity extends BaseActivity implements EditInfoView {

    @BindView(R.id.edit_info_back)
    ImageView editInfoBack;
    @BindView(R.id.edit_info_next)
    TextView editInfoNext;
    @BindView(R.id.edit_info_toolbar)
    Toolbar editInfoToolbar;
    @BindView(R.id.edit_info_nickname)
    EditText editInfoNickname;
    @BindView(R.id.edit_info_name)
    EditText editInfoName;
    @BindView(R.id.edit_info_id)
    EditText editInfoId;
    @BindView(R.id.edit_info_location_view)
    ImageView editInfoLocationView;
    @BindView(R.id.edit_info_location)
    TextView editInfoLocation;
    @BindView(R.id.edit_info_arrow)
    ImageView editInfoArrow;
    @BindView(R.id.relative_layout)
    RelativeLayout relativeLayout;
    @BindView(R.id.edit_info_load_register)
    ProgressBar editInfoLoadRegister;

    @Override
    public int getLayoutId() {
        return R.layout.activity_edit_info;
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
    }

    @Override
    protected void initializeInjector() {

    }


    @Override
    public void editInfoSuccess() {
        hideProgress();
        Intent intent = new Intent(EditInfoActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void editInfoFailed(String errMsg) {
        Toast.makeText(this, errMsg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showProgress() {
        editInfoLoadRegister.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        editInfoLoadRegister.setVisibility(View.GONE);

    }

    private void editInfo() {
        EditInfoApiImpl infoApi = new EditInfoApiImpl();
        infoApi.editInfo(editInfoNickname.getText().toString(),
                editInfoName.getText().toString(),
                editInfoId.getText().toString(),
                this);
        showProgress();
    }

    @OnClick({R.id.edit_info_back, R.id.relative_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit_info_back:
                Intent it = new Intent(EditInfoActivity.this, RegisterActivity.class);
                startActivity(it);
                break;
            case R.id.relative_layout:
                BottomDialog dialog = new BottomDialog(this);
                dialog.setOnAddressSelectedListener(new OnAddressSelectedListener() {
                    @Override
                    public void onAddressSelected(Province province, City city, County county, Street street) {
                        String location = "";
                        if (province != null) {
                            location += province.name;
                        }
                        if (city != null) {
                            location += ' ' + city.name;
                        }
                        if (county != null) {
                            location += ' ' + county.name;
                        }
                        if (street != null) {
                            location += ' ' + street.name;
                        }
                        editInfoLocation.setText(location);
                        dialog.dismiss();
                    }
                });
                dialog.show();
                break;
        }
    }
}
