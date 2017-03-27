package com.example.developer.cropdiagnosis.mvp.view;

import com.example.developer.cropdiagnosis.mvp.model.beans.UserModelBean;
import com.example.developer.cropdiagnosis.mvp.view.base.BaseView;

/**
 * Created by socer on 17-3-27.
 */

public interface EditInfoView extends BaseView {

    void editInfoSuccess();

    void editInfoFailed(String errMsg);
}
