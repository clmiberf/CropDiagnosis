package com.example.developer.cropdiagnosis.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.ui.fragments.DiseaseHistoryFragment;
import com.example.developer.cropdiagnosis.view.FragmentViewPager;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.tl_home)
    SmartTabLayout tabTitle;
    @BindView(R.id.vp_content_home)
    FragmentViewPager vpContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        String[] tabTitles = getResources().getStringArray(R.array.tablayout_titles);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new DiseaseHistoryFragment());
        vpContent.setData(this, fragments, tabTitles);
        tabTitle.setViewPager(vpContent);
    }
}
