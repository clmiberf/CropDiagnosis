package com.example.developer.cropdiagnosis.mvp.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.adapter.DiseaseListAdapter;
import com.example.developer.cropdiagnosis.mvp.model.beans.DiseaseModelBean;
import com.example.developer.cropdiagnosis.mvp.presenter.DiseaseHistoryPresenter;
import com.example.developer.cropdiagnosis.mvp.ui.activities.condition.DiseaseConditionActivity;
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

    MaterialSpinner mspinStatus;
    @BindView(R.id.rv_content_disease_history)
    RecyclerView rvContent;
    private List<DiseaseModelBean> diseaseModelList;
    private DiseaseModelBean diseaseModel;


    private DiseaseListAdapter diseaseAdapter = null;
    private List<DiseaseModelBean> data = new ArrayList<>();
    private ArrayAdapter<String> cropAdapter = null;
    private ArrayAdapter<String> durationAdapter = null;
    private ArrayAdapter<String> statusAdapter = null;



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_disease_history;
    }

    @Override
    protected void initializeInjector() {
//        DaggerActivityComponent.builder()
//                .activityModule(new ActivityModule(getActivity()))
//                .build()
//                .inject(this);
    }

    protected void initVariables() {
        data = new ArrayList<>();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        DiseaseHistoryPresenter mPresenter = new DiseaseHistoryPresenter(getActivity()
                , PreferenceManager.getDefaultSharedPreferences(getActivity()));
        mPresenter.attachView(this);
        mPresenter.onCreate(savedInstanceState);

        return view;
    }

    @Override
    public void initDiseaseListView(List<DiseaseModelBean> diseaseData) {
        diseaseAdapter = new DiseaseListAdapter(this.getActivity(), diseaseData);
        rvContent.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        rvContent.setAdapter(diseaseAdapter);
        diseaseAdapter.setClickListener(new DiseaseListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //you问题
                Intent intent = new Intent(getActivity(), DiseaseConditionActivity.class);
                intent.putExtra("Disease", diseaseData.get(position));
                startActivity(intent);
               // Toast.makeText(getActivity(),"4r44r4erfwe",Toast.LENGTH_SHORT).show();
            }
        });
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
