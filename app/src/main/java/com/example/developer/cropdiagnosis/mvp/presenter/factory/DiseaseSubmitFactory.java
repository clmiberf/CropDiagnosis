package com.example.developer.cropdiagnosis.mvp.presenter.factory;

import com.example.developer.cropdiagnosis.mvp.presenter.impls.SubmitDieasePresenterImpl;
import com.example.developer.cropdiagnosis.mvp.presenter.interfaces.ISubmitDiseasePresenter;

/**
 * Created by Developer on 16-12-21.
 * Wang Cheng is a intelligent Android developer.
 */

public class DiseaseSubmitFactory {
    public static ISubmitDiseasePresenter createSubmitController() {
        return new SubmitDieasePresenterImpl();
    }
}
