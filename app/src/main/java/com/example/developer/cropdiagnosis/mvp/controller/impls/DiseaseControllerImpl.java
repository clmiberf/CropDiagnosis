package com.example.developer.cropdiagnosis.mvp.controller.impls;

import android.content.Context;

import com.example.developer.cropdiagnosis.mvp.controller.interfaces.IDiseaseController;
import com.example.developer.cropdiagnosis.mvp.model.DiseaseModel;
import com.example.developer.cropdiagnosis.mvp.ui.fragments.DiseaseHistoryFragment;
import com.example.developer.cropdiagnosis.shared.NetManager;

/**
 * Created by Developer on 16-12-14.
 * Wang Cheng is a intelligent Android developer.
 */

public class DiseaseControllerImpl implements IDiseaseController {
    @Override
    public void getDiseaseListInfo(Context context, String userId, DiseaseHistoryFragment.DiseaseHistoryCallback callback) {
        // 判断用户名是否为空
        if (userId == null) {
            callback.onLoadHistoryInfoFailed(null);
            return;
        }

        DiseaseModel diseaseModel = new DiseaseModel();
        // 判断网络条件是否良好
        if (NetManager.isNetworkWorkWell(context)) {
            diseaseModel.getFromNetwork(userId, callback);
        } else {

        }
    }
}
