package com.example.developer.cropdiagnosis.controller.impls;

import android.content.Context;

import com.example.developer.cropdiagnosis.model.DiseaseModel;
import com.example.developer.cropdiagnosis.controller.interfaces.IDiseaseController;
import com.example.developer.cropdiagnosis.shared.NetManager;
import com.example.developer.cropdiagnosis.ui.fragments.DiseaseHistoryFragment;

/**
 * Created by Developer on 16-12-14.
 * Wang Cheng is a intelligent Android developer.
 */

public class DiseaseControllerImpl implements IDiseaseController {
    @Override
    public void getDiseaseListInfo(Context context, DiseaseHistoryFragment.DiseaseHistoryCallback callback) {
        DiseaseModel diseaseModel = new DiseaseModel();
        // 判断网络条件是否良好
        if (NetManager.isNetworkWorkWell(context)) {
            diseaseModel.getFromNetwork(callback);
        } else {

        }
    }
}
