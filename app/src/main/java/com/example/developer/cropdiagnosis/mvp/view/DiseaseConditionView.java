package com.example.developer.cropdiagnosis.mvp.view;

import android.widget.ImageView;

import java.util.List;

/**
 * Created by clmiberf on 2017/2/25.
 */

public interface DiseaseConditionView {
    //void initDiseaseImageView(String imageUrl);
    void initDiseaseName(String name);
    void initWordInstruction(String instruction);
    void initDiseaseCause(String cause);
    void initSolution(String solution);
    void initSoluteDate(String soluteDate);
    void initAccpter(String accept);
    void initEvaluate(List<String> evaluate);
    void initSupplement(String supplement);
}
