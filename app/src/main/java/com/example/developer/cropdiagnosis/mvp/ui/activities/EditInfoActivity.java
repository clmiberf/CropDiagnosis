package com.example.developer.cropdiagnosis.mvp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.mvp.ui.activities.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class EditInfoActivity extends BaseActivity {

    @BindView(R.id.edit_info_next)
    TextView next;
    @BindView(R.id.edit_info_toolbar)
    Toolbar editInfoToolbar;
    @BindView(R.id.edit_info_nickname)
    EditText editInfoNickname;
    @BindView(R.id.edit_info_name)
    EditText editInfoName;
//    @BindView(R.id.edit_info_sex)
//    EditText editInfoSex;
    @BindView(R.id.edit_info_id)
    EditText editInfoId;
    @BindView(R.id.edit_info_location)
    TextView editInfoLocation;
    @BindView(R.id.edit_info_arrow)
    ImageView editInfoArrow;


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

    @OnClick({R.id.edit_info_toolbar, R.id.edit_info_nickname, R.id.edit_info_name, R.id.edit_info_id, R.id.edit_info_location,R.id.edit_info_next,R.id.edit_info_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit_info_toolbar:
                break;
            case R.id.edit_info_nickname:
                break;
            case R.id.edit_info_name:
                break;
//            case R.id.edit_info_sex:
//                break;
            case R.id.edit_info_id:
                break;
            case R.id.edit_info_location:
                break;
            case R.id.edit_info_next:
                Intent intent = new Intent(EditInfoActivity.this,HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.edit_info_back:
                Intent it = new Intent(EditInfoActivity.this,RegisterActivity.class);
                startActivity(it);
                break;
        }
    }
}
