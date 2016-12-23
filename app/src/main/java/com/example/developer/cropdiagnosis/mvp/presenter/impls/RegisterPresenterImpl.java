package com.example.developer.cropdiagnosis.mvp.presenter.impls;

import com.example.developer.cropdiagnosis.mvp.model.beans.UserModelBean;
import com.example.developer.cropdiagnosis.mvp.model.impls.RegisterModelApiImpl;
import com.example.developer.cropdiagnosis.mvp.model.interfaces.RegisterModelApi;
import com.example.developer.cropdiagnosis.mvp.presenter.impls.base.BasePresenterImpl;
import com.example.developer.cropdiagnosis.mvp.presenter.interfaces.RegisterPresenter;
import com.example.developer.cropdiagnosis.mvp.view.RegisterView;

/**
 * Created by Developer on 16-12-23.
 * Wang Cheng is a intelligent Android developer.
 */

public class RegisterPresenterImpl extends BasePresenterImpl<RegisterView, UserModelBean> implements RegisterPresenter {

    private RegisterModelApi api = null;

    public RegisterPresenterImpl() {
        super.onCreate();
        api = new RegisterModelApiImpl();
    }

    @Override
    public void register(String phoneNumber, String password, int userType, String province, String city, String county, String village) {
        if (api != null) {
            beforeRequest();
            mSubscription = api.register(phoneNumber, password, userType, province, city, county, village, this);
        }
    }

    @Override
    public void success(UserModelBean data) {
        super.success(data);
        mBaseView.registerSuccess();
    }

    @Override
    public void onError(String errorMsg) {
        super.onError(errorMsg);
        mBaseView.registerFailed(errorMsg);
    }
}
