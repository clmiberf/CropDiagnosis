package com.example.developer.cropdiagnosis.mvp.ui.activities.condition;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.mvp.ui.activities.base.BaseActivity;
import com.example.developer.cropdiagnosis.mvp.view.DiseaseConditionView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import fr.ganfra.materialspinner.MaterialSpinner;

public class DiseaseConditionActivity extends BaseActivity implements DiseaseConditionView {

    //图片说明
    @BindView(R.id.image_crop)
    ImageView cropImage;
    //文字说明
    @BindView(R.id.word_instruction)
    TextView instruction;
    //补充
    @BindView(R.id.supplementary)
    TextView supplement;
    @BindView(R.id.crop_diagnose_btn)
    Button diagnoseBtn;


    @Override
    public int getLayoutId() {
        return R.layout.content_disease_condition;
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
        diagnoseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiseaseConditionActivity.this,DiagnoseActivity.class);
                startActivity(intent);
            }
        });
        initWordInstruction("今天天气真好");


    }

    @Override
    protected void initializeInjector() {

    }

    @Override
    public void initDiseaseName(String name) {

    }

    @Override
    public void initWordInstruction(String instruction) {

    }

    @Override
    public void initDiseaseCause(String cause) {

    }

    @Override
    public void initSolution(String solution) {

    }

    @Override
    public void initSoluteDate(String soluteDate) {

    }

    @Override
    public void initAccpter(String accept) {

    }

    @Override
    public void initEvaluate(List<String> evaluate) {

    }

    @Override
    public void initSupplement(String supplement) {
        this.supplement.setText(supplement);
    }

    @Override
    public void showProgress() {
        //alsdjf
    }

    @Override
    public void hideProgress() {

    }
//
//    @Override
//    public void initDiseaseImageView(String imageUrl) {
//        Bitmap bmp = null;
//        try {
//            URL myurl = new URL(imageUrl);
//            //获得链接
//            HttpURLConnection connection = (HttpURLConnection) myurl.openConnection();
//            connection.setConnectTimeout(6000);
//            connection.setDoInput(true);
//            connection.setUseCaches(false);
//            InputStream is = connection.getInputStream();
//            bmp = BitmapFactory.decodeStream(is);
//            is.close();
//            cropImage.setImageBitmap(bmp);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
