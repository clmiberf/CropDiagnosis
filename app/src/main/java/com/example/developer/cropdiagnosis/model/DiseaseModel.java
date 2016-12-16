package com.example.developer.cropdiagnosis.model;

import android.content.Context;

import com.example.developer.cropdiagnosis.network.HttpMethod;
import com.example.developer.cropdiagnosis.ui.fragments.DiseaseHistoryFragment;

/**
 * Created by Developer on 16-12-14.
 */

public class DiseaseModel {
    public void getFromDatabase(Context context, DiseaseHistoryFragment.DiseaseHistoryCallback callback) {
    }

    public void getFromNetwork(DiseaseHistoryFragment.DiseaseHistoryCallback callback) {
        HttpMethod.getInstance().getDiseaseInfo(callback);
    }
}
