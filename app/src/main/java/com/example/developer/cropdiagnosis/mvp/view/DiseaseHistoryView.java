package com.example.developer.cropdiagnosis.mvp.view;

import com.example.developer.cropdiagnosis.mvp.model.beans.DiseaseModelBean;
import com.example.developer.cropdiagnosis.mvp.view.base.BaseView;

import java.util.List;

/**
 * Created by Developer on 16-12-24.
 * Wang Cheng is a intelligent Android developer.
 */

public interface DiseaseHistoryView extends BaseView {
    void initDiseaseListView(List<DiseaseModelBean> diseaseData);

    void initCropSpinner(String[] cropData);

    void initDurationSpinner(List<String> durationData);

    void initStatusSpinner(List<String> statusData);

    void loadSuccess(List<DiseaseModelBean> data);

    void loadFailed(String errorMsg);
}
