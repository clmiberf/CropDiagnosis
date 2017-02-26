package com.example.developer.cropdiagnosis.mvp.ui.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.adapter.ImagePickerAdapter;
import com.example.developer.cropdiagnosis.mvp.ui.activities.HomeActivity;
import com.example.developer.cropdiagnosis.mvp.ui.fragments.base.BaseFragment;
import com.example.developer.cropdiagnosis.mvp.view.DiseaseSubmitView;
import com.stormphoenix.imagepicker.FishImageType;
import com.stormphoenix.imagepicker.ImagePicker;
import com.stormphoenix.imagepicker.bean.ImageItem;
import com.stormphoenix.imagepicker.ui.ImageGridActivity;
import com.stormphoenix.imagepicker.ui.ImagePreviewDelActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import fr.ganfra.materialspinner.MaterialSpinner;

import static com.stormphoenix.imagepicker.ImagePicker.REQUEST_CODE_PREVIEW;

public class DiseaseSubmitFragment extends BaseFragment implements DiseaseSubmitView
        , ImagePickerAdapter.OnRecyclerViewItemClickListener {

    @BindView(R.id.mspin_crop_kind_disease_submit)
    MaterialSpinner mspinCropKind;
    @BindView(R.id.rv_pic_monitor_site)
    RecyclerView recyclerView;
    @BindView(R.id.et_disease_illustration_disease_submit)
    EditText etDiseaseIllustration;
    @BindView(R.id.btn_submit_disease_disease_submit)
    Button btnSubmitDisease;
    private List<ImageItem> selImageList;
    private int maxImgCount;
    private ImagePickerAdapter imagePickerAdapter;
    private String[] crops = null;
    private ArrayAdapter<String> adapter = null;

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
//        if (ConfigManager.getCrops() != null) {
//            crops = (String[]) ConfigManager.getCrops().toArray();
//        } else {
//            crops = new String[]{};
//        }
        initPresenter();
    }

    private void initPresenter() {
//        mPresenter = new DiseaseSubmitPresenterImpl();
//        mPresenter.attachView(this);
//        mPresenter.onCreate();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick(R.id.btn_submit_disease_disease_submit)
    public void onClick() {
        showProgress();
        submit();
    }

    private void submit() {
        // not completed
//        mPresenter.submitDisease(ConfigManager.getUserId(), strCropKind, strDescription, null);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View view = super.onCreateView(inflater, container, savedInstanceState);
        initPicturesListView();
        return view;
    }

    private void refreshUI() {
        etDiseaseIllustration.setText("");
    }

    @Override
    public void submitSuccess() {

    }

    @Override
    public String getCropKind() {
        return null;
    }

    @Override
    public void initPicturesListData(List<String> imagePaths) {

    }

    @Override
    public String getDiseaseDescription() {
        return null;
    }

    @Override
    public List<String> getUploadPicturesPaths() {
        return null;
    }

    @Override
    public void submitFailed(String errorMsg) {
        Toast.makeText(getContext(), errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setCropKindAdapter(List<String> crops) {

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void showProgress() {
        ProgressDialog progressDialog = new ProgressDialog(this.getActivity());
        progressDialog.setMessage(getString(R.string.submiting));
        progressDialog.create();
        progressDialog.show();
    }

    @Override
    public void hideProgress() {

    }
    //初始化图片RecyclerView
    private void initPicturesListView() {
        selImageList = new ArrayList<>();
        maxImgCount = 10;
        imagePickerAdapter = new ImagePickerAdapter(this.getActivity(), selImageList, maxImgCount);
        imagePickerAdapter.setOnItemClickListener(this);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(), 4));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(imagePickerAdapter);
    }

    //更新图片RecyclerView
    public void addPicturesData(List<ImageItem> imageItems) {
        selImageList.addAll(imageItems);
//        selImageList = imageItems;
        imagePickerAdapter.setImages(selImageList);
    }

    public void updatePicturesData(List<ImageItem> imageItems) {
//        selImageList.addAll(imageItems);
        selImageList.clear();
        selImageList.addAll(imageItems);
        imagePickerAdapter.setImages(selImageList);
    }


    @Override
    public void onItemClick(View view, int position) {
        switch (position) {
            case -1:
                ImagePicker.getInstance().setSelectLimit(maxImgCount - selImageList.size());
                Intent intent = new Intent(this.getActivity(), ImageGridActivity.class);
                intent.putExtra(FishImageType.IMAGE_TYPE, FishImageType.MONITORING_SITE);
                getActivity().startActivityForResult(intent, HomeActivity.PICK_IMAGE);
                break;
            default:
                Intent intentPreview = new Intent(this.getActivity(), ImagePreviewDelActivity.class);
                intentPreview.putExtra(ImagePicker.EXTRA_IMAGE_ITEMS, (ArrayList<ImageItem>) imagePickerAdapter.getImages());
                intentPreview.putExtra(ImagePicker.EXTRA_SELECTED_IMAGE_POSITION, position);
                getActivity().startActivityForResult(intentPreview, REQUEST_CODE_PREVIEW);
                break;
        }
    }

}
