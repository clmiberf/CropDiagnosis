package com.example.developer.cropdiagnosis.mvp.presenter;

import android.os.Bundle;

import com.example.developer.cropdiagnosis.mvp.model.impls.DiseaseSubmitModelApiImpl;
import com.example.developer.cropdiagnosis.mvp.view.DiseaseSubmitView;
import com.stormphoenix.imagepicker.bean.ImageItem;

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
        initPicturesList();
    }


    private void initCropKind() {
        List<String> crops = new ArrayList<String>();
        crops.add("苹果");
        crops.add("香蕉");
        crops.add("梨子");
        crops.add("荔枝");

        /**
         * 调用BaseView 设置Adapter
         * setCropKindAdapter(String);
         */
        mView.setCropKindAdapter(crops);
    }

    private void initPicturesList() {
        List<ImageItem> selImageList = new ArrayList<>();
        mView.setPicturesListView(selImageList);
    }

    public void submitDisease(String userId, String cropKind, String description, List<ImageItem> imageItems) {
//        List<File> files = new ArrayList<>();
//        for (String path : imagePaths) {
//            files.add(new File(path));
//        }
//        Observable<HttpResult<Void>> observable = HttpMethod.getInstance().submitDisease(userId, cropKind, description, files);
//        observable.compose(RxJavaCustomTransformer.<HttpResult<Void>>defaultSchedulers())
//                .subscribe(new Subscriber<HttpResult<Void>>() {
//                    @Override
//                    public void onCompleted() {
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        mView.submitFailed(e.toString());
//                    }
//
//                    @Override
//                    public void onNext(HttpResult<Void> voidHttpResult) {
//                        mView.submitSuccess();
//                    }
//                });
        List<File> imageFiles = new ArrayList<>();
        for (int i=0; i<imageItems.size(); i++) {
            imageFiles.add(new File(imageItems.get(i).path));
        }
        DiseaseSubmitModelApiImpl diseaseSubmitModelApi = new DiseaseSubmitModelApiImpl();
        diseaseSubmitModelApi.submitDisease(userId, cropKind, description, imageFiles, mView);
        mView.submitSuccess();
    }


}
