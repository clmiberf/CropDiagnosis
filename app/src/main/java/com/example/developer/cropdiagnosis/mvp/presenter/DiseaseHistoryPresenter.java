package com.example.developer.cropdiagnosis.mvp.presenter;

import android.os.Bundle;

import com.example.developer.cropdiagnosis.mvp.view.DiseaseHistoryView;

import javax.inject.Inject;

/**
 * Created by StormPhoenix on 17-2-9.
 * StormPhoenix is a intelligent Android developer.
 */
public class DiseaseHistoryPresenter extends BasePresenter<DiseaseHistoryView> {

    @Inject
    public DiseaseHistoryPresenter() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
