package com.example.developer.cropdiagnosis.mvp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.mvp.ui.activities.base.BaseActivity;
import com.example.developer.cropdiagnosis.mvp.ui.component.FragmentViewPager;
import com.example.developer.cropdiagnosis.mvp.ui.fragments.DiseaseHistoryFragment;
import com.example.developer.cropdiagnosis.mvp.ui.fragments.DiseaseSubmitFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.stormphoenix.imagepicker.ImagePicker;
import com.stormphoenix.imagepicker.bean.ImageItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.stormphoenix.imagepicker.ImagePicker.REQUEST_CODE_PREVIEW;
import static com.stormphoenix.imagepicker.ImagePicker.RESULT_CODE_ITEMS;

public class HomeActivity extends BaseActivity {

    public static final int PICK_IMAGE = 100;
    public static final int PRESS_BACK = 101;

    @BindView(R.id.tl_home)
    SmartTabLayout tabTitle;
    @BindView(R.id.vp_content_home)
    FragmentViewPager vpContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 保存上次的数据
     *
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {
        String[] tabTitles = getResources().getStringArray(R.array.tablayout_titles);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new DiseaseHistoryFragment());
        fragments.add(new DiseaseSubmitFragment());
        vpContent.setData(this, fragments, tabTitles);
        tabTitle.setViewPager(vpContent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_PREVIEW:
                if (data != null && resultCode == ImagePicker.RESULT_CODE_BACK) {
                    ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_IMAGE_ITEMS);
                    vpContent.getDisFragment().updatePicturesData(images);
                }
                break;
            case PICK_IMAGE:
                if (data != null && resultCode == ImagePicker.RESULT_CODE_ITEMS){
                    List<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                    if (images == null) {
                    } else {
                        vpContent.getDisFragment().addPicturesData(images);
                    }
                }
                break;

        }
    }
}
