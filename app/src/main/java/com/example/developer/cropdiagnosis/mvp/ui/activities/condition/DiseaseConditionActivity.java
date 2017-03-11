package com.example.developer.cropdiagnosis.mvp.ui.activities.condition;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.adapter.ImagePickerAdapter;
import com.example.developer.cropdiagnosis.mvp.ui.activities.base.BaseActivity;
import com.example.developer.cropdiagnosis.mvp.view.DiseaseConditionView;
import com.example.developer.cropdiagnosis.shared.GetUrlImageHelper;
import com.stormphoenix.imagepicker.bean.ImageItem;

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
    @BindView(R.id.rv_disease_crop_picture_site)
    RecyclerView recyclerView;
    private List<ImageItem> imageList;
    private int maxImageCount;
    private ImagePickerAdapter imageAdapter;
    private ArrayAdapter<String> adapter = null;

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

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void initDiseaseImageView(List<ImageItem> imageUrlList) {
//       Bitmap bmp = null;
        
        imageList = imageUrlList;
        maxImageCount = 10;
        imageAdapter = new ImagePickerAdapter(this, imageList, maxImageCount);
        imageAdapter.setOnItemClickListener((ImagePickerAdapter.OnRecyclerViewItemClickListener) this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(imageAdapter);
//           for (int i=0;i<imageUrlList.size();i++){
//               // String url = imageUrlList.get(i);
////                URL myurl = new URL(url);
////                //获得链接
////                HttpURLConnection connection = (HttpURLConnection) myurl.openConnection();
////                connection.setConnectTimeout(6000);
////                connection.setDoInput(true);
////        connection.setUseCaches(false);
////                InputStream is = connection.getInputStream();
//                bmp = BitmapFactory.decodeStream(new GetUrlImageHelper().getUrlImage(imageUrlList.get(i)));
//                cropImage.setImageBitmap(bmp);
//                imageList.add(cropImage);
//            }

    }

}
