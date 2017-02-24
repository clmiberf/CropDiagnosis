package com.example.developer.cropdiagnosis.dagger2.component;

import com.example.developer.cropdiagnosis.dagger2.module.ActivityModule;
import com.example.developer.cropdiagnosis.mvp.ui.fragments.DiseaseHistoryFragment;

import dagger.Component;

/**
 * Created by Developer on 17-1-25.
 * Wang Cheng is a intelligent Android developer.
 */

@Component(modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(DiseaseHistoryFragment fragment);
}
