package com.example.developer.cropdiagnosis.mvp.model.impls;

import com.example.developer.cropdiagnosis.mvp.model.beans.UserModelBean;
import com.example.developer.cropdiagnosis.mvp.model.interfaces.EditInfoModelApi;
import com.example.developer.cropdiagnosis.mvp.view.EditInfoView;
import com.example.developer.cropdiagnosis.network.HttpMethod;
import com.example.developer.cropdiagnosis.network.HttpResult;
import com.example.developer.cropdiagnosis.network.apis.EditInfoApi;

import retrofit2.http.Field;
import rx.Observable;
import rx.Subscription;

/**
 * Created by socer on 17-3-27.
 */

public class EditInfoApiImpl implements EditInfoModelApi {

    @Override
    public Subscription editInfo(String nickname, String name, String userId, EditInfoView editInfoView) {
        return HttpMethod.getInstance().editInfo(nickname,name,userId,editInfoView);
    }
}
