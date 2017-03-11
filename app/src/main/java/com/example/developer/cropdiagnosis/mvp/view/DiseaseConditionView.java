package com.example.developer.cropdiagnosis.mvp.view;

import android.widget.ImageView;

import com.example.developer.cropdiagnosis.mvp.view.base.BaseView;

import java.util.List;

/**
 * Created by clmiberf on 2017/2/25.
 */

public interface DiseaseConditionView extends BaseView{
    //void initDiseaseImageView(String imageUrl);
    void loadDescription(String description);
    void loadImages(List<String> imageUrl);
}
