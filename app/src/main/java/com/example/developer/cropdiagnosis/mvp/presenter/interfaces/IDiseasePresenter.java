package com.example.developer.cropdiagnosis.mvp.presenter.interfaces;

import android.content.Context;

/**
 * Created by Developer on 16-12-14.
 * <p>
 * 向 DiseaseHistoryFragment 提供获取病害参数的借口
 */

public interface IDiseasePresenter {
    /**
     * 此方法将会获取病害信息，并通过callback回调返回信息
     */
    void getDiseaseListInfo(Context context, String userId);
}
