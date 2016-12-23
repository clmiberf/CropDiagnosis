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

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.mvp.presenter.factory.DiseaseSubmitFactory;
import com.example.developer.cropdiagnosis.mvp.presenter.interfaces.ISubmitDiseasePresenter;
import com.example.developer.cropdiagnosis.mvp.ui.fragments.base.BaseFragment;
import com.example.developer.cropdiagnosis.shared.ConfigManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fr.ganfra.materialspinner.MaterialSpinner;

public class DiseaseSubmitFragment extends BaseFragment {

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
    private ISubmitDiseasePresenter controller = null;
    private Callback callback = null;
    private String strCropKind;
    private String strDescription;

    public DiseaseSubmitFragment() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_disease_submit;
    }

    @Override
    public void initViews(View view) {
        initConfigs();
        adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, crops);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspinCropKind.setAdapter(adapter);
        mspinCropKind.setError("Hello world");
    }

    @Override
    public void initConfigs() {
        if (ConfigManager.getCrops() != null) {
            crops = (String[]) ConfigManager.getCrops().toArray();
        } else {
            crops = new String[]{};
        }
        controller = DiseaseSubmitFactory.createSubmitController();
        callback = new Callback() {
            @Override
            public void onSubmitSuccess() {
                pbWait.setVisibility(View.INVISIBLE);
                refreshUI();
            }

            @Override
            public void onSubmitFailed() {
                pbWait.setVisibility(View.INVISIBLE);
            }
        };
    }

    @OnClick(R.id.btn_submit_disease_disease_submit)
    public void onClick() {
        submit();
    }

    private void submit() {
        pbWait.setVisibility(View.VISIBLE);
//        controller.submitDisease(ConfigManager.getUserId(), strCropKind, strDescription, null, callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    private void refreshUI() {
        etDiseaseIllustration.setText("");
    }

    public interface Callback {
        void onSubmitSuccess();

        void onSubmitFailed();
    }
}
