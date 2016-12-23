package com.example.developer.cropdiagnosis.mvp.presenter.factory;

import com.example.developer.cropdiagnosis.mvp.presenter.impls.DiseaseHistoryPresenterImpl;
import com.example.developer.cropdiagnosis.mvp.presenter.interfaces.IDiseaseHistoryPresenter;

/**
 * Created by Developer on 16-12-14.
 * Wang Cheng is a intelligent Android developer.
 */

public class DiseaseControllerFactory {
    public static IDiseaseHistoryPresenter createDiseasePresenter() {
        return new DiseaseHistoryPresenterImpl();
    }
}
