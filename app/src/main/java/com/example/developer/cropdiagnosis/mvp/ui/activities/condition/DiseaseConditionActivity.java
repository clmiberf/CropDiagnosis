package com.example.developer.cropdiagnosis.mvp.ui.activities.condition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.adapter.ImageAdapter;
import com.example.developer.cropdiagnosis.adapter.ImagePickerAdapter;
import com.example.developer.cropdiagnosis.mvp.model.beans.DiseaseModelBean;
import com.example.developer.cropdiagnosis.mvp.ui.activities.HomeActivity;
import com.example.developer.cropdiagnosis.mvp.ui.activities.base.BaseActivity;
import com.example.developer.cropdiagnosis.mvp.view.DiseaseConditionView;
import com.example.developer.cropdiagnosis.shared.GetUrlImageHelper;
import com.example.developer.cropdiagnosis.shared.SpacesItemDecoration;
import com.stormphoenix.imagepicker.FishImageType;
import com.stormphoenix.imagepicker.ImagePicker;
import com.stormphoenix.imagepicker.bean.ImageItem;
import com.stormphoenix.imagepicker.ui.ImageGridActivity;
import com.stormphoenix.imagepicker.ui.ImagePreviewDelActivity;

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

import static com.stormphoenix.imagepicker.ImagePicker.REQUEST_CODE_PREVIEW;

public class DiseaseConditionActivity extends BaseActivity implements DiseaseConditionView {

    DiseaseModelBean disease;
    @BindView(R.id.content_word_instruction)
    TextView contentWordInstruction;
    @BindView(R.id.crop_diagnose_relativelayout)
    RelativeLayout cropDiagnoseBtn;
    @BindView(R.id.rv_disease_crop_picture_site)
    RecyclerView recyclerView;


    List<ImageItem> imageList;
    private int maxImageCount;
    //private ImagePickerAdapter imageAdapter;
    private ImageAdapter imageAdapter;

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
        
        List<String> imageItems = new ArrayList<String>();
        imageItems.add("http://img.my.csdn.net/uploads/201407/26/1406383299_1976.jpg");
        imageItems.add("http://img.my.csdn.net/uploads/201407/26/1406383291_6518.jpg");
        imageItems.add("http://img.my.csdn.net/uploads/201407/26/1406383291_8239.jpg");
        imageItems.add("http://img.my.csdn.net/uploads/201407/26/1406383290_9329.jpg");
        imageItems.add("http://img.my.csdn.net/uploads/201407/26/1406383290_1042.jpg");
        imageItems.add("http://img.my.csdn.net/uploads/201407/26/1406383275_3977.jpg");
        initDiseaseImageView(imageItems);
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
    public void initDiseaseImageView(List<String> imageUrlList) {
//       Bitmap bmp = null;
        
        maxImageCount = 10;
        imageAdapter = new ImageAdapter(this,imageUrlList);
        int distense = 15;
        recyclerView.addItemDecoration(new SpacesItemDecoration(distense));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
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

    @OnClick(R.id.crop_diagnose_relativelayout)
    public void onClick() {
        Intent intent = new Intent(DiseaseConditionActivity.this, DiagnoseActivity.class);
        intent.putExtra("Disease", disease);
        startActivity(intent);
    }

//    @Override
//    public void onItemClick(View view, int position) {
//        switch (position) {
//            case -1:
//                ImagePicker.getInstance().setSelectLimit(maxImageCount - imageList.size());
//                Intent intent = new Intent(this, ImageGridActivity.class);
//                intent.putExtra(FishImageType.IMAGE_TYPE, FishImageType.MONITORING_SITE);
//                this.startActivityForResult(intent, HomeActivity.PICK_IMAGE);
//                break;
//            default:
//                Intent intentPreview = new Intent(this, ImagePreviewDelActivity.class);
//                intentPreview.putExtra(ImagePicker.EXTRA_IMAGE_ITEMS, (ArrayList<ImageItem>) imageAdapter.getItemCount());
//                intentPreview.putExtra(ImagePicker.EXTRA_SELECTED_IMAGE_POSITION, position);
//                this.startActivityForResult(intentPreview, REQUEST_CODE_PREVIEW);
//                break;
//        }
//
//    }

}
