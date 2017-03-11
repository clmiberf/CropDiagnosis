package com.example.developer.cropdiagnosis.mvp.view;

import com.example.developer.cropdiagnosis.mvp.view.base.BaseView;
import java.util.List;

/**
 * Created by xiang on 2017/3/10.
 */

public interface DiagnoseView extends BaseView {
    public void loadDiseaseImageView(List<String> imageUrlList);
    public void loadDiseaseName(String name);
    public void loadWordInstruction(String instruction);
    public void loadDiseaseCause(String cause);
    public void loadSolution(String solution);
    public void loadSoluteDate(String soluteDate);
    public void loadAccpter(String accept);
    public void loadEvaluate(List<String> evaluate);
    public void loadSupplement(String supplement);
}
