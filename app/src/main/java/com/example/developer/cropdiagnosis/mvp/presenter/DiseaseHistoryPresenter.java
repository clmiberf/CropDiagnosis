package com.example.developer.cropdiagnosis.mvp.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.example.developer.cropdiagnosis.CropApplication;
import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.db.DbConstants;
import com.example.developer.cropdiagnosis.mvp.model.beans.DiseaseModelBean;
import com.example.developer.cropdiagnosis.mvp.model.impls.DiseaseHistoryModelApiImpl;
import com.example.developer.cropdiagnosis.mvp.view.DiseaseHistoryView;
import com.example.developer.cropdiagnosis.network.HttpResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by StormPhoenix on 17-2-9.
 * StormPhoenix is a intelligent Android developer.
 */
public class DiseaseHistoryPresenter extends BasePresenter<DiseaseHistoryView> {

    private Context mContext = null;
    private SharedPreferences preferences = null;
    private String userId = null;

    @Inject
    DiseaseHistoryPresenter(Context context) {
        mContext = context;
    }

    public DiseaseHistoryPresenter(Context context, SharedPreferences preferences) {
        this.preferences = preferences;
        userId  = preferences.getString("user_Id", "");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadDiseaseHistoryInfo();
    }


    /**
     * 获取历史病害信息
     *
     * @param userId
     */
    public void loadDiseaseHistoryInfo1(String userId) {
        /**
         * Fake data
         */
        Observable.create(new Observable.OnSubscribe<HttpResult<List<DiseaseModelBean>>>() {
            @Override
            public void call(Subscriber<? super HttpResult<List<DiseaseModelBean>>> subscriber) {


            }
        }).subscribe(new Subscriber<HttpResult<List<DiseaseModelBean>>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                mView.loadFailed(mContext.getResources().getString(R.string.load_data_failed));
            }

            @Override
            public void onNext(HttpResult<List<DiseaseModelBean>> result) {
                mView.initDiseaseListView(result.getData());
            }
        });

        /**
         HttpMethod.getInstance().getDiseaseInfo(userId)
         .compose(RxJavaCustomTransformer.defaultSchedulers())
         .subscribe(new Subscriber<HttpResult<List<DiseaseModelBean>>>() {
        @Override public void onCompleted() {
        }

        @Override public void onError(Throwable e) {
        mView.loadFailed(mContext.getResources().getString(R.string.load_data_failed));
        }

        @Override public void onNext(HttpResult<List<DiseaseModelBean>> result) {
        mView.initDiseaseListView(result.getData());
        }
        });
         **/
    }

    private void loadDiseaseHistoryInfo() {
        DiseaseHistoryModelApiImpl diseaseHistoryModelApi = new DiseaseHistoryModelApiImpl();
        diseaseHistoryModelApi.loadDiseaseHistory(userId, mView);
    }
}
