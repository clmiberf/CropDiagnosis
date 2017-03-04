package com.example.developer.cropdiagnosis.mvp.model.interfaces;

import com.example.developer.cropdiagnosis.network.HttpResult;

import java.io.File;
import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Developer on 16-12-24.
 * Wang Cheng is a intelligent Android developer.
 */

public interface DiseaseSubmitModelApi {
    Observable<HttpResult<Void>> submitDisease(String userId, String cropKind, String description, List<File> imageFiles);
}
