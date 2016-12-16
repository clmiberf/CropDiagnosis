package com.example.developer.cropdiagnosis.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.adapter.DiseaseListAdapter;
import com.example.developer.cropdiagnosis.db.DbConstants;
import com.example.developer.cropdiagnosis.model.beans.DiseaseModelBean;
import com.example.developer.cropdiagnosis.controller.factory.DiseaseControllerFactory;
import com.example.developer.cropdiagnosis.controller.interfaces.IDiseaseController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.ganfra.materialspinner.MaterialSpinner;

/**
 * Created by Developer on 16-12-14.
 */

public class DiseaseHistoryFragment extends Fragment {

    @BindView(R.id.mspin_crop_disease_history)
    MaterialSpinner mspinCrop;
    @BindView(R.id.mspin_duration_disease_history)
    MaterialSpinner mspinDuration;
    @BindView(R.id.mspin_status_disease_history)
    MaterialSpinner mspinStatus;
    @BindView(R.id.rv_content_disease_history)
    RecyclerView rvContent;

    private DiseaseListAdapter diseaseAdapter = null;
    private IDiseaseController presenter = null;
    private List<DiseaseModelBean> data = new ArrayList<>();

    private DiseaseHistoryCallback callback = new DiseaseHistoryCallback() {
        @Override
        public void onLoadHistoryInfoSuccess(List<DiseaseModelBean> datas) {
            data.clear();
            data.addAll(datas);
            diseaseAdapter.notifyDataSetChanged();
        }

        @Override
        public void onLoadHistoryInfoFailed(Throwable e) {
            for (int i = 0; i < 10; i++) {
                DiseaseModelBean bean = new DiseaseModelBean();
                bean.setAcceptExpertName("李飞飞");
                bean.setCommentDetails("我的图像识别");
                bean.setCommentType(DbConstants.CommentType.VERY_GOOD);
                bean.setCrop("橘子");
                bean.setDescription("机器学习教会了我很多");
                bean.setDiseaseName("机器不会识图");
                bean.setHasCommented(true);
                bean.setImageUrl(null);
                bean.setSolution("一起努力吧");
                bean.setSubmitTime(new Date());
                bean.setSolveTime(new Date());
                data.add(bean);
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View resultView = inflater.inflate(R.layout.fragment_disease_history, container, false);
        ButterKnife.bind(this, resultView);
        initViews();
        return resultView;
    }

    private void initViews() {
        data = new ArrayList<>();
        presenter = DiseaseControllerFactory.createDiseasePresenter();

        String[] crops = {"水稻", "玉米", "小麦"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, crops);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspinCrop.setAdapter(adapter);
        mspinCrop.setError("Hello world");

        mspinDuration.setAdapter(adapter);
        mspinStatus.setAdapter(adapter);

        diseaseAdapter = new DiseaseListAdapter(this.getActivity(), data);
        rvContent.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        rvContent.setAdapter(diseaseAdapter);
    }

    private void updateDiseaseHistoryInfo() {
        presenter.getDiseaseListInfo(getContext(), callback);
    }

    public interface DiseaseHistoryCallback {
        void onLoadHistoryInfoSuccess(List<DiseaseModelBean> datas);

        void onLoadHistoryInfoFailed(Throwable e);
    }
}
