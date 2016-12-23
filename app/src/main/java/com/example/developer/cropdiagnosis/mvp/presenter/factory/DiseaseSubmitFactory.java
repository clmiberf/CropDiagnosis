package com.example.developer.cropdiagnosis.mvp.presenter.factory;

import com.example.developer.cropdiagnosis.mvp.presenter.impls.DiseaseSubmitPresenterImpl;
import com.example.developer.cropdiagnosis.mvp.presenter.interfaces.DiseaseSubmitPresenter;

/**
 * Created by Developer on 16-12-21.
 * Wang Cheng is a intelligent Android developer.
 */

public class DiseaseSubmitFactory {
    public static DiseaseSubmitPresenter createSubmitController() {
        return new DiseaseSubmitPresenterImpl();
    }
}
