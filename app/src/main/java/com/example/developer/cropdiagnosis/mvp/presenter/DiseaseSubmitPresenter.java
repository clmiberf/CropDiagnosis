package com.example.developer.cropdiagnosis.mvp.presenter;

import android.os.Bundle;

import com.example.developer.cropdiagnosis.mvp.view.DiseaseSubmitView;
import com.example.developer.cropdiagnosis.network.HttpMethod;
import com.example.developer.cropdiagnosis.network.HttpResult;
import com.example.developer.cropdiagnosis.shared.ConfigManager;
import com.example.developer.cropdiagnosis.shared.rxutils.RxJavaCustomTransformer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by StormPhoenix on 17-2-25.
 * StormPhoenix is a intelligent Android developer.
 */

public class DiseaseSubmitPresenter extends BasePresenter<DiseaseSubmitView> {

    @Inject
    public DiseaseSubmitPresenter() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initCropKind();
    }


    public void initCropKind() {
        List<String> crops = new ArrayList<String>(ConfigManager.getUserPreferCrops());
        /**
         * 调用BaseView 设置Adapter
         * setCropKindAdapter(String);
         */
        mView.setCropKindAdapter(crops);
    }

    private void submitDisease(String userId, String cropKind, String description, List<String> imagePaths) {
        List<File> files = new ArrayList<>();
        for (String path : imagePaths) {
            files.add(new File(path));
        }
        Observable<HttpResult<Void>> observable = HttpMethod.getInstance().submitDisease(userId, cropKind, description, files);
        observable.compose(RxJavaCustomTransformer.<HttpResult<Void>>defaultSchedulers())
                .subscribe(new Subscriber<HttpResult<Void>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.submitFailed(e.toString());
                    }

                    @Override
                    public void onNext(HttpResult<Void> voidHttpResult) {
                        mView.submitSuccess();
                    }
                });
    }
}
