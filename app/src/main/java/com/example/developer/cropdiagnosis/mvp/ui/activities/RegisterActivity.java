package com.example.developer.cropdiagnosis.mvp.ui.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.mvp.model.beans.UserModelBean;
import com.example.developer.cropdiagnosis.mvp.model.impls.RegisterModelApiImpl;
import com.example.developer.cropdiagnosis.mvp.ui.activities.base.BaseActivity;
import com.example.developer.cropdiagnosis.mvp.ui.component.interfaces.IMessagePromptDialog;
import com.example.developer.cropdiagnosis.mvp.ui.component.interfaces.IProgressDialog;
import com.example.developer.cropdiagnosis.mvp.view.RegisterView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.smssdk.EventHandler;

public class RegisterActivity extends BaseActivity implements RegisterView {

    @BindView(R.id.et_tel_number_register)
    EditText etTelNumber;
    @BindView(R.id.et_check_code_register)
    EditText etCheckCode;
    @BindView(R.id.et_password_register)
    EditText etPassword;
    @BindView(R.id.et_repassword_register)
    EditText etRepassword;
//    @BindView(R.id.rd_person_register)
//    RadioButton rdPerson;
//    @BindView(R.id.rd_company_register)
//    RadioButton rdCompany;
//    @BindView(R.id.spin_province_register)
//    Spinner spinProvince;
//    @BindView(R.id.spin_city_register)
//    Spinner spinCity;
//    @BindView(R.id.spin_county_register)
//    Spinner spinCountry;
//    @BindView(R.id.et_village_register)
//    EditText etVillage;
    @BindView(R.id.btn_register_register)
    Button btnRegister;
    @BindView(R.id.activity_register)
    LinearLayout activity;
    @BindView(R.id.pb_load_register)
    ProgressBar pbLoad;
    @BindView(R.id.btn_get_check_code)
    Button getCheckCode;

    private ArrayAdapter<String> provinceAdapter = null;
    private ArrayAdapter<String> cityAdapter = null;
    private ArrayAdapter<String> countyAdapter = null;
    private List<String> provinces = new ArrayList<>();
    private List<String> cities = new ArrayList<>();
    private List<String> counties = new ArrayList<>();


    int i = 60;

    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
           // Toast.makeText(RegisterActivity.this, "eeeee", Toast.LENGTH_SHORT).show();
            if (msg.what == -1) {
                //修改控件文本进行倒计时  i 以60秒倒计时为例
                getCheckCode.setText(i + " s");
            } else if (msg.what == -2) {
                //修改控件文本，进行重新发送验证码
                getCheckCode.setText("重新发送");
                getCheckCode.setClickable(true);
                i = 60;
            } else {
                int event = msg.arg1;
                int result = msg.arg2;
                Object data = msg.obj;

                // 短信注册成功后，返回MainActivity,然后提示
                if (event == cn.smssdk.SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                    // 提交验证码成功,调用注册接口，之后直接登录
                    //当号码来自短信注册页面时调用登录注册接口
                    //当号码来自绑定页面时调用绑定手机号码接口


                } else if (event == cn.smssdk.SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                    Toast.makeText(getApplicationContext(), "验证码已经发送",
                            Toast.LENGTH_SHORT).show();
                } else if (result == cn.smssdk.SMSSDK.RESULT_ERROR) {
                    try {
                        Throwable throwable = (Throwable) data;
                        throwable.printStackTrace();
                        JSONObject object = new JSONObject(throwable.getMessage());
                        String des = object.optString("detail");//错误描述
                        int status = object.optInt("status");//错误代码
                        if (status > 0 && !TextUtils.isEmpty(des)) {
                            Toast.makeText(RegisterActivity.this, des, Toast.LENGTH_SHORT).show();
                            return;
                        }
                    } catch (Exception e) {
                        //do something
                    }
                } else {
                    ((Throwable) data).printStackTrace();
                }
            }
        }
    };

    @OnClick({  R.id.btn_get_check_code, R.id.btn_register_register})
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.rd_person_register:
//                break;
//            case R.id.rd_company_register:
//                break;
            case R.id.btn_get_check_code:
                String phoneNum = etTelNumber.getText().toString().trim();
                //待添加添加短信验证信息
                //初始化SMSSDK
                cn.smssdk.SMSSDK.initSDK(RegisterActivity.this, "1c235bc0af12d", "575be61e723d6879695ea361b439784f");
                EventHandler eventHandler = new EventHandler() {
                    @Override
                    public void afterEvent(int event, int result, Object data) {
                        Message msg = new Message();
                        msg.arg1 = event;
                        msg.arg2 = result;
                        msg.obj = data;
                        handler.sendMessage(msg);
                    }
                };
                cn.smssdk.SMSSDK.registerEventHandler(eventHandler);

                if (TextUtils.isEmpty(phoneNum)) {
                    Toast.makeText(getApplicationContext(), "手机号码不能为空",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                cn.smssdk.SMSSDK.getVerificationCode("86", phoneNum);
                getCheckCode.setClickable(false);
                //开始倒计时
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (; i > 0; i--) {
                            handler.sendEmptyMessage(-1);
                            if (i <= 0) {
                                break;
                            }
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        //倒计时结束执行
                        handler.sendEmptyMessage(-2);
                    }
                }).start();
                break;
            case R.id.btn_register_register:
                if (etPassword.getText().toString().equals(etRepassword.getText().toString())) {
                    registe();
                } else {
                    Toast.makeText(this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private IProgressDialog progressDialog = null;
    private IMessagePromptDialog messageDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        initSpinner();
        hideProgress();
    }

    @Override
    protected void initializeInjector() {

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
    }

    @Override
    protected void initViews() {
//        rdPerson.setChecked(true);
//        rdCompany.setChecked(false);
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
        hideProgress();
        Intent it = new Intent(RegisterActivity.this, EditInfoActivity.class);
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

    private void registe() {
        RegisterModelApiImpl registerModelApi = new RegisterModelApiImpl();
        registerModelApi.register(etTelNumber.getText().toString()
                , etPassword.getText().toString()
                ,etCheckCode.getText().toString()
               , this);
        showProgress();
    }

//    private void initSpinner() {
//        provinces.add("湖北");
//        provinces.add("江西");
//        provinces.add("湖南");
//        cities.add("武汉");
//        cities.add("黄石");
//        cities.add("黄冈");
//        counties.add("洪山");
//        counties.add("武昌");
//        counties.add("汉口");
//        provinceAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, provinces);
//        provinceAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        cityAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cities);
//        cityAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        countyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, counties);
//        countyAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        spinCity.setAdapter(cityAdapter);
//        spinProvince.setAdapter(provinceAdapter);
//        spinCountry.setAdapter(countyAdapter);
//
//
//    }

}
