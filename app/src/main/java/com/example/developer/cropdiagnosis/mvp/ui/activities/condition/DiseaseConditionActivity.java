package com.example.developer.cropdiagnosis.mvp.ui.activities.condition;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.mvp.model.beans.DiseaseModelBean;
import com.example.developer.cropdiagnosis.mvp.ui.activities.base.BaseActivity;
import com.example.developer.cropdiagnosis.mvp.view.DiseaseConditionView;
import java.util.List;
import butterknife.BindView ;
import butterknife.OnClick ;

public class DiseaseConditionActivity extends BaseActivity implements DiseaseConditionView {

    DiseaseModelBean disease;
    @BindView(R.id.content_word_instruction)
    TextView contentWordInstruction;
    @BindView(R.id.crop_diagnose_btn)
    Button cropDiagnoseBtn;

    @Override
    public int getLayoutId() {
        return R.layout.content_disease_condition;
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {
        disease = (DiseaseModelBean) getIntent().getSerializableExtra("Disease");
        loadDescription(disease.getDescription());
        loadImages(disease.getImageUrl());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initializeInjector() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void loadDescription(String description) {
        contentWordInstruction.setText(description);
    }

    @Override
    public void loadImages(List<String> imageUrl) {

    }

    @OnClick(R.id.crop_diagnose_btn)
    public void onClick() {
        Intent intent = new Intent(DiseaseConditionActivity.this, DiagnoseActivity.class);
        intent.putExtra("Disease", disease);
        startActivity(intent);
    }

}
