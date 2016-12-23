package com.example.developer.cropdiagnosis.mvp.presenter.interfaces;

import com.example.developer.cropdiagnosis.mvp.presenter.interfaces.base.BasePresenter;

import java.io.File;
import java.util.List;

/**
 * Created by Developer on 16-12-21.
 * Wang Cheng is a intelligent Android developer.
 */

public interface DiseaseSubmitPresenter extends BasePresenter {
    void submitDisease(String userId,
                       String cropKind,
                       String description,
                       List<File> imageFiles);
}
