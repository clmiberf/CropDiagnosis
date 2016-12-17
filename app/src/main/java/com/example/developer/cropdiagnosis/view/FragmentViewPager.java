package com.example.developer.cropdiagnosis.view;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import java.util.List;

/**
 * Created by developer on 16-10-18.
 * Wang Cheng is a intelligent Android developer.
 */

public class FragmentViewPager extends ViewPager {

    private String[] titles = null;
    private List<Fragment> fragments = null;
    private FragmentActivity fragmentActivity = null;

    public FragmentViewPager(Context context) {
        super(context);
    }

    public FragmentViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private boolean isDataSet() {
        return fragmentActivity != null && fragments != null && titles != null;
    }

//    @Override
//    public void setAdapter(PagerAdapter adapter) {
//        super.setAdapter(adapter);
//    }

    public void setData(FragmentActivity activity, List<Fragment> fragmentList, String[] fragmentTitles) {
        if (fragmentList.size() != fragmentTitles.length) {
            throw new IllegalArgumentException("the size of fragments is not equal to the size of titles.");
        }
        this.fragmentActivity = activity;
        this.fragments = fragmentList;
        this.titles = fragmentTitles;
        PageAdapter adapter = new PageAdapter(fragmentActivity.getSupportFragmentManager());
        super.setAdapter(adapter);
    }

    @Override
    public void setAdapter(PagerAdapter adapter) {
    }

    class PageAdapter extends FragmentPagerAdapter {
        public PageAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

}
