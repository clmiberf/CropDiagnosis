package com.example.developer.cropdiagnosis.mvp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.mvp.ui.fragments.base.BaseFragment;
import com.example.developer.cropdiagnosis.mvp.view.DiseaseSubmitView;
import com.example.developer.cropdiagnosis.shared.ConfigManager;

import butterknife.BindView;
import butterknife.OnClick;
import fr.ganfra.materialspinner.MaterialSpinner;

public class DiseaseSubmitFragment extends BaseFragment implements DiseaseSubmitView {

    @BindView(R.id.mspin_crop_kind_disease_submit)
    MaterialSpinner mspinCropKind;
    @BindView(R.id.gl_images_wrapper_disease_submit)
    GridLayout glImagesWrapper;
    @BindView(R.id.et_disease_illustration_disease_submit)
    EditText etDiseaseIllustration;
    @BindView(R.id.btn_submit_disease_disease_submit)
    Button btnSubmitDisease;
    @BindView(R.id.pb_wait_submit)
    ProgressBar pbWait;

    private String[] crops = null;
    private ArrayAdapter<String> adapter = null;
    private String strCropKind;
    private String strDescription;

    public DiseaseSubmitFragment() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_disease_submit;
    }

    @Override
    protected void initializeInjector() {

    }

    public void initViews(View view) {
        adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, crops);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspinCropKind.setAdapter(adapter);
        mspinCropKind.setError("Hello world");
    }

    public void initVariables() {
        if (ConfigManager.getCrops() != null) {
            crops = (String[]) ConfigManager.getCrops().toArray();
        } else {
            crops = new String[]{};
        }
        initPresenter();
    }

    private void initPresenter() {
//        mPresenter = new DiseaseSubmitPresenterImpl();
//        mPresenter.attachView(this);
//        mPresenter.onCreate();
    }

    @OnClick(R.id.btn_submit_disease_disease_submit)
    public void onClick() {
        submit();
    }

    private void submit() {
        pbWait.setVisibility(View.VISIBLE);
        // not completed
//        mPresenter.submitDisease(ConfigManager.getUserId(), strCropKind, strDescription, null);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void refreshUI() {
        etDiseaseIllustration.setText("");
    }

    @Override
    public void submitSuccess() {

    }

    @Override
    public void submitFailed(String errorMsg) {
        Toast.makeText(getContext(), errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        pbWait.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbWait.setVisibility(View.GONE);
    }
}
