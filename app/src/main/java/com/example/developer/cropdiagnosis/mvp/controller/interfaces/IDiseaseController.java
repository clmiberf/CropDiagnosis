package com.example.developer.cropdiagnosis.mvp.controller.interfaces;

import android.content.Context;

import com.example.developer.cropdiagnosis.mvp.ui.fragments.DiseaseHistoryFragment;

/**
 * Created by Developer on 16-12-14.
 * <p>
 * 向 DiseaseHistoryFragment 提供获取病害参数的借口
 */

public interface IDiseaseController {
    /**
     * 此方法将会获取病害信息，并通过callback回调返回信息
     *
     * @param callback DiseaseHistoryFragment 提供的回调接口
     */
    void getDiseaseListInfo(Context context, String userId, DiseaseHistoryFragment.DiseaseHistoryCallback callback);
}
