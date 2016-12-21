package com.example.developer.cropdiagnosis.mvp.ui.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.mvp.ui.activities.base.BaseActivity;
import com.example.developer.cropdiagnosis.mvp.ui.fragments.DiseaseHistoryFragment;
import com.example.developer.cropdiagnosis.mvp.ui.fragments.DiseaseSubmitFragment;
import com.example.developer.cropdiagnosis.mvp.view.FragmentViewPager;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeActivity extends BaseActivity {

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
    protected void initViews() {
        String[] tabTitles = getResources().getStringArray(R.array.tablayout_titles);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new DiseaseHistoryFragment());
        fragments.add(new DiseaseSubmitFragment());
        vpContent.setData(this, fragments, tabTitles);
        tabTitle.setViewPager(vpContent);
    }
}
