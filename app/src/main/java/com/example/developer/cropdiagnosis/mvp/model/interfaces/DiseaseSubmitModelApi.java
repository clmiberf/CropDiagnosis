package com.example.developer.cropdiagnosis.mvp.model.interfaces;

import java.io.File;
import java.util.List;

import rx.Subscription;

/**
 * Created by Developer on 16-12-24.
 * Wang Cheng is a intelligent Android developer.
 */

public interface DiseaseSubmitModelApi {
    Subscription submitDisease(String userId, String cropKind, String description, List<File> imageFiles);
}
