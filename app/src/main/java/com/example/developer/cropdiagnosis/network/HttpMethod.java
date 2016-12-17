package com.example.developer.cropdiagnosis.network;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.developer.cropdiagnosis.model.beans.DiseaseModelBean;
import com.example.developer.cropdiagnosis.model.beans.UserModelBean;
import com.example.developer.cropdiagnosis.network.apis.DiseaseHistoryApi;
import com.example.developer.cropdiagnosis.network.apis.ImageApi;
import com.example.developer.cropdiagnosis.network.apis.LoginApi;
import com.example.developer.cropdiagnosis.shared.NetManager;
import com.example.developer.cropdiagnosis.shared.rxutils.RxJavaCustomTransformer;
import com.example.developer.cropdiagnosis.ui.LoginActivity;
import com.example.developer.cropdiagnosis.ui.fragments.DiseaseHistoryFragment;

import java.util.List;

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
 */

public class HttpMethod {

    private DiseaseHistoryApi diseaseApi = null;
    private ImageApi imageApi = null;
    private LoginApi loginApi = null;
    private static HttpMethod instance = null;

    private HttpMethod() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NetManager.getBaseUrl())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        diseaseApi = retrofit.create(DiseaseHistoryApi.class);
        imageApi = retrofit.create(ImageApi.class);
        loginApi = retrofit.create(LoginApi.class);
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

    public void login(String username, String password, final LoginActivity.LoginCallback callback) {
        loginApi.login(username, password)
                .compose(RxJavaCustomTransformer.<UserModelBean>defaultSchedulers())
                .subscribe(new Subscriber<UserModelBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onLoginFailed();
                    }

                    @Override
                    public void onNext(UserModelBean userModelBean) {
                        callback.onLoginSuccess(userModelBean);
                    }
                });
    }

    public void downloadImage() {
        imageApi.downloadImage()
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

    public void getDiseaseInfo(final DiseaseHistoryFragment.DiseaseHistoryCallback callback) {
        diseaseApi.getDiseaseHistory()
                .compose(RxJavaCustomTransformer.<List<DiseaseModelBean>>defaultSchedulers())
                .subscribe(new Subscriber<List<DiseaseModelBean>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onLoadHistoryInfoFailed(e);
                    }

                    @Override
                    public void onNext(List<DiseaseModelBean> diseaseModelBeen) {
                        callback.onLoadHistoryInfoSuccess(diseaseModelBeen);
                    }
                });
    }
}
