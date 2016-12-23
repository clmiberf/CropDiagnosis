package com.example.developer.cropdiagnosis.mvp.presenter.factory;

import com.example.developer.cropdiagnosis.mvp.presenter.impls.DiseasePresenterImpl;
import com.example.developer.cropdiagnosis.mvp.presenter.interfaces.IDiseasePresenter;

/**
 * Created by Developer on 16-12-14.
 * Wang Cheng is a intelligent Android developer.
 */

public class DiseaseControllerFactory {
    public static IDiseasePresenter createDiseasePresenter() {
        return new DiseasePresenterImpl();
    }
}
