package com.example.developer.cropdiagnosis.mvp.ui.activities.condition;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.adapter.ImagePickerAdapter;
import com.example.developer.cropdiagnosis.mvp.model.beans.DiseaseModelBean;
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
