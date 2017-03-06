package com.example.developer.cropdiagnosis.mvp.view;

import com.example.developer.cropdiagnosis.mvp.model.beans.UserModelBean;
import com.example.developer.cropdiagnosis.mvp.view.base.BaseView;

/**
 * Created by Developer on 16-12-23.
 * Wang Cheng is a intelligent Android developer.
 */

public interface RegisterView extends BaseView {
    void registerSuccess();

    void registerFailed(String errorMsg);
}
