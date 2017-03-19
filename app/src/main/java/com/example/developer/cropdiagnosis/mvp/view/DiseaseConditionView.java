package com.example.developer.cropdiagnosis.mvp.view;

import android.widget.ImageView;

import com.example.developer.cropdiagnosis.mvp.view.base.BaseView;
import com.stormphoenix.imagepicker.bean.ImageItem;

import java.util.List;

/**
 * Created by clmiberf on 2017/2/25.
 */

public interface DiseaseConditionView extends BaseView{
    void initDiseaseImageView(List<String> imageUrlList);
    void loadDescription(String description);
    void loadImages(List<String> imageUrl);
}
