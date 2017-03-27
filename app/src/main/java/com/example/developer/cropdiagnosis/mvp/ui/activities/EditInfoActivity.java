package com.example.developer.cropdiagnosis.mvp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.mvp.model.impls.EditInfoApiImpl;
import com.example.developer.cropdiagnosis.mvp.ui.activities.base.BaseActivity;
import com.example.developer.cropdiagnosis.mvp.view.EditInfoView;

import butterknife.BindView;
import butterknife.OnClick;

public class EditInfoActivity extends BaseActivity implements EditInfoView{

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
    @BindView(R.id.edit_info_load_register)
    ProgressBar progressBar;



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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_next,menu);
//        return super.onCreateOptionsMenu(menu);
//    }

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
                editInfo();
                break;
            case R.id.edit_info_back:
                Intent it = new Intent(EditInfoActivity.this,RegisterActivity.class);
                startActivity(it);
                break;
        }
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.next:
//                editInfo();
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void editInfoSuccess() {
        hideProgress();
        Intent intent = new Intent(EditInfoActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void editInfoFailed(String errMsg) {
        Toast.makeText(this,errMsg,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showProgress() { progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() { progressBar.setVisibility(View.GONE);

    }

    private void editInfo(){
        EditInfoApiImpl infoApi = new EditInfoApiImpl();
        infoApi.editInfo(editInfoNickname.getText().toString(),
                editInfoName.getText().toString(),
                editInfoId.getText().toString(),
               this);
        showProgress();
    }
}
