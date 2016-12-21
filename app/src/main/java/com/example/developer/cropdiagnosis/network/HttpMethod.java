package com.example.developer.cropdiagnosis.network;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.developer.cropdiagnosis.mvp.controller.impls.LoginControllerImpl;
import com.example.developer.cropdiagnosis.mvp.model.beans.DiseaseModelBean;
import com.example.developer.cropdiagnosis.mvp.model.beans.UserModelBean;
import com.example.developer.cropdiagnosis.mvp.ui.fragments.DiseaseHistoryFragment;
import com.example.developer.cropdiagnosis.mvp.ui.fragments.DiseaseSubmitFragment;
import com.example.developer.cropdiagnosis.network.apis.DiseaseHistoryApi;
import com.example.developer.cropdiagnosis.network.apis.DiseaseSubmitApi;
import com.example.developer.cropdiagnosis.network.apis.ImageApi;
import com.example.developer.cropdiagnosis.network.apis.LoginApi;
import com.example.developer.cropdiagnosis.network.utils.HttpUtils;
import com.example.developer.cropdiagnosis.shared.NetManager;
import com.example.developer.cropdiagnosis.shared.rxutils.RxJavaCustomTransformer;

import java.io.File;
import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by Developer on 16-12-14.
 * <p>
 * 用于执行网络请求的类
 * <p>
 * open the source file with VIM !!!!!!
 */

public class HttpMethod {

    private static HttpMethod instance = null;
    private DiseaseHistoryApi diseaseApi = null;
    private ImageApi imageApi = null;
    private LoginApi loginApi = null;
    private DiseaseSubmitApi submitApi = null;

    private HttpMethod() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NetManager.getBaseUrl())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        diseaseApi = retrofit.create(DiseaseHistoryApi.class);
        imageApi = retrofit.create(ImageApi.class);
        loginApi = retrofit.create(LoginApi.class);
        submitApi = retrofit.create(DiseaseSubmitApi.class);
    }

    public static HttpMethod getInstance() {
        if (instance == null) {
            synchronized (HttpMethod.class) {
                if (instance == null) {
                    instance = new HttpMethod();
                }
            }
        }
        return instance;
    }

    public void login(String username, String password, final LoginControllerImpl.LoginCallback callback) {
        loginApi.login(username, password)
                .compose(RxJavaCustomTransformer.<HttpResult<UserModelBean>>defaultSchedulers())
                .subscribe(new Subscriber<HttpResult<UserModelBean>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onLoginFailed(e);
                    }

                    @Override
                    public void onNext(HttpResult<UserModelBean> result) {
                        callback.onLoginSuccess(result);
                    }
                });
    }

    public void downloadImage(String url) {
        imageApi.downloadImage(url)
                .compose(RxJavaCustomTransformer.<ResponseBody>defaultSchedulers())
                .map(new Func1<ResponseBody, Bitmap>() {
                    @Override
                    public Bitmap call(ResponseBody responseBody) {
                        return BitmapFactory.decodeStream(responseBody.byteStream());
                    }
                })
                .subscribe(new Subscriber<Object>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Object o) {

                    }
                });
    }

    public void submitDisease(String userId, String cropKind, String description, List<File> imageFiles, final DiseaseSubmitFragment.Callback callback) {

        RequestBody userIdBody = HttpUtils.createStringBody(userId);
        RequestBody cropKindBody = HttpUtils.createStringBody(cropKind);
        RequestBody descriptionBody = HttpUtils.createStringBody(description);
        Map<String, RequestBody> map = HttpUtils.createMultFileMap(imageFiles);

        submitApi.submitDisease(userIdBody, cropKindBody, descriptionBody, map)
                .compose(RxJavaCustomTransformer.<HttpResult<Void>>defaultSchedulers())
                .subscribe(new Subscriber<HttpResult<Void>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onSubmitFailed();
                    }

                    @Override
                    public void onNext(HttpResult<Void> voidHttpResult) {
                        callback.onSubmitSuccess();
                    }
                });
    }

    public void getDiseaseInfo(String userId, final DiseaseHistoryFragment.DiseaseHistoryCallback callback) {
        diseaseApi.getDiseaseHistory(userId)
                .compose(RxJavaCustomTransformer.<HttpResult<List<DiseaseModelBean>>>defaultSchedulers())
                .subscribe(new Subscriber<HttpResult<List<DiseaseModelBean>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onLoadHistoryInfoFailed(e);
                    }

                    @Override
                    public void onNext(HttpResult<List<DiseaseModelBean>> listHttpResult) {
                        callback.onLoadHistoryInfoSuccess(listHttpResult.getData());
                    }
                });
    }
}
