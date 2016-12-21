package com.example.developer.cropdiagnosis.mvp.controller.factory;

import com.example.developer.cropdiagnosis.mvp.controller.impls.SubmitDieaseControllerImpl;
import com.example.developer.cropdiagnosis.mvp.controller.interfaces.ISubmitDiseaseController;

/**
 * Created by Developer on 16-12-21.
 * Wang Cheng is a intelligent Android developer.
 */

public class DiseaseSubmitFactory {
    public static ISubmitDiseaseController createSubmitController() {
        return new SubmitDieaseControllerImpl();
    }
}
