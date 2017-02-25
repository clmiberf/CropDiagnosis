package com.example.developer.cropdiagnosis.mvp.ui.activities.condition;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.mvp.ui.activities.base.BaseActivity;

public class DiseaseConditionActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_disease_condition);
    }

}
