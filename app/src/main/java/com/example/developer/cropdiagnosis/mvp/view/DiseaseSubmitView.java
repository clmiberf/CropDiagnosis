package com.example.developer.cropdiagnosis.mvp.view;

import com.example.developer.cropdiagnosis.mvp.view.base.BaseView;
import com.stormphoenix.imagepicker.bean.ImageItem;

import java.util.List;

/**
 * Created by Developer on 16-12-24.
 * Wang Cheng is a intelligent Android developer.
 */

public interface DiseaseSubmitView extends BaseView {
    void submitSuccess();

    String getCropKind();

    String getDiseaseDescription();

    List<String> getUploadPicturesPaths();

    void submitFailed(String errorMsg);

    void setCropKindAdapter(List<String> crops);

    void setPicturesListView(List<ImageItem> selImageList);
}
