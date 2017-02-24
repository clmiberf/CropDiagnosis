package com.example.developer.cropdiagnosis.dagger2.module;

import android.app.Activity;
import android.content.Context;

import com.example.developer.cropdiagnosis.db.DatabaseManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Developer on 17-1-25.
 * Wang Cheng is a intelligent Android developer.
 */

@Module
public class ActivityModule {
    private Activity mActivity = null;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    public Context provideContext() {
        return mActivity;
    }

    @Provides
    public DatabaseManager provideDbManager() {
        return new DatabaseManager(mActivity);
    }

    @Provides
    public Activity provideActivity() {
        return mActivity;
    }
}
