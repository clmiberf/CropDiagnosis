package com.example.developer.cropdiagnosis.mvp.controller.interfaces;

import com.example.developer.cropdiagnosis.mvp.ui.fragments.DiseaseSubmitFragment;

import java.io.File;
import java.util.List;

/**
 * Created by Developer on 16-12-21.
 * Wang Cheng is a intelligent Android developer.
 */

public interface ISubmitDiseaseController {
    void submitDisease(String userId,
                       String cropKind,
                       String description,
                       List<File> imageFiles,
                       DiseaseSubmitFragment.Callback callback);
}
