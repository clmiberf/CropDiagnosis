package com.example.developer.cropdiagnosis.mvp.view;

import com.example.developer.cropdiagnosis.mvp.view.base.BaseView;

import java.util.List;

/**
 * Created by Developer on 16-12-24.
 * Wang Cheng is a intelligent Android developer.
 */

public interface DiseaseSubmitView extends BaseView {
    void submitSuccess();

    String getCropKind();

    String getDiseaseDescription();

    List<String> getUploadImagePaths();

    void submitFailed(String errorMsg);

    void setCropKindAdapter(List<String> crops);
}
