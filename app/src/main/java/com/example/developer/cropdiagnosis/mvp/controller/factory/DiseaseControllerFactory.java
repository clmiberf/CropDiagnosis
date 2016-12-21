package com.example.developer.cropdiagnosis.mvp.controller.factory;

import com.example.developer.cropdiagnosis.mvp.controller.impls.DiseaseControllerImpl;
import com.example.developer.cropdiagnosis.mvp.controller.interfaces.IDiseaseController;

/**
 * Created by Developer on 16-12-14.
 * Wang Cheng is a intelligent Android developer.
 */

public class DiseaseControllerFactory {
    public static IDiseaseController createDiseasePresenter() {
        return new DiseaseControllerImpl();
    }
}
