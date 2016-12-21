package com.example.developer.cropdiagnosis.mvp.ui.fragments;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.mvp.controller.factory.DiseaseSubmitFactory;
import com.example.developer.cropdiagnosis.mvp.controller.interfaces.ISubmitDiseaseController;
import com.example.developer.cropdiagnosis.mvp.ui.fragments.base.BaseFragment;
import com.example.developer.cropdiagnosis.shared.ConfigManager;

import butterknife.BindView;
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

    private String[] crops = null;
    private ArrayAdapter<String> adapter = null;
    private ISubmitDiseaseController controller = null;
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
        if (ConfigManager.getCrops(getContext()) != null) {
            crops = (String[]) ConfigManager.getCrops(getContext()).toArray();
        } else {
            crops = new String[]{};
        }
        controller = DiseaseSubmitFactory.createSubmitController();
        callback = new Callback() {
            @Override
            public void onSubmitSuccess() {

            }

            @Override
            public void onSubmitFailed() {

            }
        };
    }

    @OnClick(R.id.btn_submit_disease_disease_submit)
    public void onClick() {
        submit();
    }

    private void submit() {
        controller.submitDisease(ConfigManager.getUserId(getContext()), strCropKind, strDescription, null, callback);
    }

    public interface Callback {
        void onSubmitSuccess();

        void onSubmitFailed();
    }
}
