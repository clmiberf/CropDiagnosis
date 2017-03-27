package com.example.developer.cropdiagnosis.mvp.model.interfaces;

import com.example.developer.cropdiagnosis.mvp.view.EditInfoView;

import rx.Subscription;

/**
 * Created by socer on 17-3-27.
 */

public interface EditInfoModelApi {

    Subscription editInfo(String nickname, String name, String userId, EditInfoView editInfoView);
}
