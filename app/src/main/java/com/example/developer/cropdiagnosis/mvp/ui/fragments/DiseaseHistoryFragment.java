package com.example.developer.cropdiagnosis.mvp.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.adapter.DiseaseListAdapter;
import com.example.developer.cropdiagnosis.dagger2.component.DaggerActivityComponent;
import com.example.developer.cropdiagnosis.dagger2.module.ActivityModule;
import com.example.developer.cropdiagnosis.mvp.model.beans.DiseaseModelBean;
import com.example.developer.cropdiagnosis.mvp.presenter.DiseaseHistoryPresenter;
import com.example.developer.cropdiagnosis.mvp.ui.activities.HomeActivity;
import com.example.developer.cropdiagnosis.mvp.ui.activities.LoginActivity;
import com.example.developer.cropdiagnosis.mvp.ui.activities.MainActivity;
import com.example.developer.cropdiagnosis.mvp.ui.activities.RegisterActivity;
import com.example.developer.cropdiagnosis.mvp.ui.activities.condition.DiseaseConditionActivity;
import com.example.developer.cropdiagnosis.mvp.ui.fragments.base.BaseFragment;
import com.example.developer.cropdiagnosis.mvp.view.DiseaseHistoryView;

import java.util.ArrayList;
import java.util.Arrays;
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
    private List<DiseaseModelBean> diseaseModelList;
    private DiseaseModelBean diseaseModel;


    private DiseaseListAdapter diseaseAdapter = null;
    private List<DiseaseModelBean> data = new ArrayList<>();
    private ArrayAdapter<String> cropAdapter = null;
    private ArrayAdapter<String> durationAdapter = null;
    private ArrayAdapter<String> statusAdapter = null;

    @Inject
    public DiseaseHistoryPresenter mPresenter = null;

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
        diseaseAdapter.setClickListener(new DiseaseListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //you问题
                Intent intent = new Intent(getActivity(), DiseaseConditionActivity.class);
                startActivity(intent);
               // Toast.makeText(getActivity(),"4r44r4erfwe",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void initCropSpinner(List<String> cropData) {

        cropAdapter = new ArrayAdapter<>(this.getActivity(),
                android.R.layout.simple_spinner_item, cropData);
        cropAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspinCrop.setAdapter(cropAdapter);
        mspinCrop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
              //  String[] languages = getResources().getStringArray(R.array.languages);
              // Toast.makeText(getActivity(),"32332",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        mspinCrop.setVisibility(View.VISIBLE);
        mspinCrop.setError("init cropSpinner error");
    }

    @Override
    public void initDurationSpinner(List<String> durationData) {
        durationAdapter = new ArrayAdapter<>(this.getActivity(),
                android.R.layout.simple_spinner_item, durationData);
        durationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspinDuration.setAdapter(durationAdapter);
        mspinDuration.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //  String[] languages = getResources().getStringArray(R.array.languages);
                // Toast.makeText(getActivity(),"32332",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        mspinDuration.setError("init durationSpinner error");
    }

    @Override
    public void initStatusSpinner(List<String> statusData) {
        statusAdapter = new ArrayAdapter<>(this.getActivity(),
                android.R.layout.simple_spinner_item, statusData);
        statusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspinStatus.setAdapter(statusAdapter);
        mspinStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //  String[] languages = getResources().getStringArray(R.array.languages);
                // Toast.makeText(getActivity(),"32332",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        mspinStatus.setError("init statusSpinner error");
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
