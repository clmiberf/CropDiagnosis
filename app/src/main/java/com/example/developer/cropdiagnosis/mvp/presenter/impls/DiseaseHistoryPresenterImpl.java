package com.example.developer.cropdiagnosis.mvp.presenter.impls;

import com.example.developer.cropdiagnosis.mvp.model.beans.DiseaseModelBean;
import com.example.developer.cropdiagnosis.mvp.model.impls.DiseaseHistoryModelApiImpl;
import com.example.developer.cropdiagnosis.mvp.model.interfaces.DiseaseHistoryModelApi;
import com.example.developer.cropdiagnosis.mvp.presenter.impls.base.BasePresenterImpl;
import com.example.developer.cropdiagnosis.mvp.presenter.interfaces.DiseaseHistoryPresenter;
import com.example.developer.cropdiagnosis.mvp.view.DiseaseHistoryView;

import java.util.List;

/**
 * Created by Developer on 16-12-14.
 * Wang Cheng is a intelligent Android developer.
 */

public class DiseaseHistoryPresenterImpl extends BasePresenterImpl<DiseaseHistoryView, List<DiseaseModelBean>> implements DiseaseHistoryPresenter {

    private DiseaseHistoryModelApi api = null;

    public DiseaseHistoryPresenterImpl() {
        api = new DiseaseHistoryModelApiImpl();
    }

    @Override
    public void loadHistoryInfo(String userId) {
        beforeRequest();
        mSubscription = api.loadDiseaseHistory(userId, this);
    }

    @Override
    public void beforeRequest() {
        super.beforeRequest();
    }

    @Override
    public void success(List<DiseaseModelBean> data) {
        super.success(data);
        mBaseView.loadSuccess(data);
    }

    @Override
    public void onError(String errorMsg) {
        super.onError(errorMsg);
        mBaseView.loadFailed(errorMsg);
    }

    //    @Override
//    public void getDiseaseListInfo(Context context, String userId) {
//        // 判断用户名是否为空
//        if (userId == null) {
////            callback.onLoadHistoryInfoFailed(null);
//            return;
//        }
//
//        DiseaseModel diseaseModel = new DiseaseModel();
//        // 判断网络条件是否良好
//        if (NetManager.isNetworkWorkWell(context)) {
////            diseaseModel.getFromNetwork(userId, callback);
//        } else {
//
//        }
//    }
}
