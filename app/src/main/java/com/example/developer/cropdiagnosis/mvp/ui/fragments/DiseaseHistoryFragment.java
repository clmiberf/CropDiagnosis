package com.example.developer.cropdiagnosis.mvp.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.adapter.DiseaseListAdapter;
import com.example.developer.cropdiagnosis.dagger2.component.DaggerActivityComponent;
import com.example.developer.cropdiagnosis.dagger2.module.ActivityModule;
import com.example.developer.cropdiagnosis.mvp.model.beans.DiseaseModelBean;
import com.example.developer.cropdiagnosis.mvp.presenter.DiseaseHistoryPresenter;
import com.example.developer.cropdiagnosis.mvp.ui.fragments.base.BaseFragment;
import com.example.developer.cropdiagnosis.mvp.view.DiseaseHistoryView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import fr.ganfra.materialspinner.MaterialSpinner;

/**
 * Created by Developer on 16-12-14.
 * Wang Cheng is a intelligent Android developer.
 */

public class DiseaseHistoryFragment extends BaseFragment implements DiseaseHistoryView {

    @BindView(R.id.mspin_crop_disease_history)
    MaterialSpinner mspinCrop;
    @BindView(R.id.mspin_duration_disease_history)
    MaterialSpinner mspinDuration;
    @BindView(R.id.mspin_status_disease_history)
    MaterialSpinner mspinStatus;
    @BindView(R.id.rv_content_disease_history)
    RecyclerView rvContent;

    private DiseaseListAdapter diseaseAdapter = null;
    private List<DiseaseModelBean> data = new ArrayList<>();
    private ArrayAdapter<String> cropAdapter = null;
    private ArrayAdapter<String> durationAdapter = null;
    private ArrayAdapter<String> statusAdapter = null;


    @Inject
    public DiseaseHistoryPresenter mPresenter = null;

//            data.clear();
//            data.addAll(datas);
//            diseaseAdapter.notifyDataSetChanged();
//        }
//
//        @Override
//        public void onLoadHistoryInfoFailed(Throwable e) {
//            for (int i = 0; i < 10; i++) {
//                DiseaseModelBean bean = new DiseaseModelBean();
//                bean.setAcceptExpertName("李飞飞");
//                bean.setCommentDetails("我的图像识别");
//                bean.setCommentType(DbConstants.CommentType.VERY_GOOD);
//                bean.setCrop("橘子");
//                bean.setDescription("机器学习教会了我很多");
//                bean.setDiseaseName("机器不会识图");
//                bean.setHasCommented(true);
//                bean.setImageUrl(null);
//                bean.setSolution("一起努力吧");
//                bean.setSubmitTime(new Date());
//                bean.setSolveTime(new Date());
//                data.add(bean);
//            }
//        }
//    };

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_disease_history;
    }

    @Override
    protected void initializeInjector() {
        DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(getActivity()))
                .build()
                .inject(this);
    }

    protected void initVariables() {
        data = new ArrayList<>();
        String[] crops = {"水稻", "玉米", "小麦"};
        String[] durations = {"一年内", "玉米", "小麦"};
        String[] status = {"水稻", "玉米", "小麦"};
        cropAdapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, crops);
        durationAdapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, crops);

        cropAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        initPresenter();
    }

    private void initPresenter() {
    }

    protected void initViews(View view) {
        mspinCrop.setAdapter(cropAdapter);
        mspinCrop.setError("Hello world");

//        mspinDuration.setAdapter(adapter);
//        mspinStatus.setAdapter(adapter);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        mPresenter.attachView(this);
        mPresenter.onCreate(savedInstanceState);
        return view;
    }

    @Override
    public void initDiseaseListView(List<DiseaseModelBean> diseaseData) {
        diseaseAdapter = new DiseaseListAdapter(this.getActivity(), diseaseData);
        rvContent.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        rvContent.setAdapter(diseaseAdapter);

    }

    @Override
    public void loadSuccess(List<DiseaseModelBean> data) {

    }

    @Override
    public void loadFailed(String errorMsg) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

//    public interface DiseaseHistoryCallback {
//        void onLoadHistoryInfoSuccess(List<DiseaseModelBean> datas);
//
//        void onLoadHistoryInfoFailed(Throwable e);
//    }
}
