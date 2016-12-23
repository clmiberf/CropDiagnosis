package com.example.developer.cropdiagnosis.mvp.presenter.impls;

import android.content.Context;

import com.example.developer.cropdiagnosis.mvp.model.DiseaseModel;
import com.example.developer.cropdiagnosis.mvp.presenter.interfaces.IDiseaseHistoryPresenter;
import com.example.developer.cropdiagnosis.shared.NetManager;

/**
 * Created by Developer on 16-12-14.
 * Wang Cheng is a intelligent Android developer.
 */

public class DiseaseHistoryPresenterImpl implements IDiseaseHistoryPresenter {
    @Override
    public void getDiseaseListInfo(Context context, String userId) {
        // 判断用户名是否为空
        if (userId == null) {
//            callback.onLoadHistoryInfoFailed(null);
            return;
        }

        DiseaseModel diseaseModel = new DiseaseModel();
        // 判断网络条件是否良好
        if (NetManager.isNetworkWorkWell(context)) {
//            diseaseModel.getFromNetwork(userId, callback);
        } else {

        }
    }
}
