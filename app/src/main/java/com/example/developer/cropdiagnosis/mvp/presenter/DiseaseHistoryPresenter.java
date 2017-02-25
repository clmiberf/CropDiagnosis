package com.example.developer.cropdiagnosis.mvp.presenter;

import android.content.Context;
import android.os.Bundle;

import com.example.developer.cropdiagnosis.CropApplication;
import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.db.DbConstants;
import com.example.developer.cropdiagnosis.mvp.model.beans.DiseaseModelBean;
import com.example.developer.cropdiagnosis.mvp.view.DiseaseHistoryView;
import com.example.developer.cropdiagnosis.network.HttpResult;
import com.example.developer.cropdiagnosis.shared.ConfigManager;

import java.util.ArrayList;
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

    @Inject
    public DiseaseHistoryPresenter(Context context) {
        mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadCropKindInfo();
        loadCropStatusInfo();
        loadDiseaseHistoryInfo(ConfigManager.getUserId());
    }

    /**
     * 获取作物病例状态信息。
     * 状态：
     * 1.已诊断
     * 2.未诊断
     */
    public void loadCropStatusInfo() {
        List<String> diagnosedStatus = new ArrayList<>();
        diagnosedStatus.add(CropApplication.getInstance().getResources().getString(R.string.diagnosed));
        diagnosedStatus.add(CropApplication.getInstance().getResources().getString(R.string.not_diagnosed));
        /**
         * 调用 BaseView
         */
    }

    /**
     * 获取作物种类信息
     */
    public void loadCropKindInfo() {
        ConfigManager.getUserPreferCrops().toArray();
        /**
         * 调用 BaseView
         */
    }

    /**
     * 获取历史病害信息
     *
     * @param userId
     */
    public void loadDiseaseHistoryInfo(String userId) {
        /**
         * Fake data
         */
        Observable.create(new Observable.OnSubscribe<HttpResult<List<DiseaseModelBean>>>() {
            @Override
            public void call(Subscriber<? super HttpResult<List<DiseaseModelBean>>> subscriber) {
                HttpResult<List<DiseaseModelBean>> result = new HttpResult<List<DiseaseModelBean>>();
                List<DiseaseModelBean> data = new ArrayList<DiseaseModelBean>();
                DiseaseModelBean model = new DiseaseModelBean();

                model.setAcceptExpertName("王成");
                model.setCommentDetails("还不错");
                model.setCommentType(DbConstants.CommentType.GOOD);
                model.setCrop("麦子");
                model.setDescription("麦子病的很重 :(");
                model.setDiseaseName("天花");
                model.setDiseaseStatus(DbConstants.DiagnosedStatus.NOT_DIAGNOSED);
                model.setHasCommented(false);
                model.setImageUrl(null);
                model.setSolution("并入膏肓，无法医治");
                model.setDiseaseReason("浇水过少");
                model.setSubmitTime(new Date(System.currentTimeMillis()));

                data.add(model);
                data.add(model);
                data.add(model);
                data.add(model);
                data.add(model);

                result.setData(data);

                subscriber.onNext(result);
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
}
