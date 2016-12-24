package com.example.developer.cropdiagnosis.network;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.developer.cropdiagnosis.mvp.model.beans.DiseaseModelBean;
import com.example.developer.cropdiagnosis.mvp.model.beans.UserModelBean;
import com.example.developer.cropdiagnosis.mvp.presenter.interfaces.base.RequestCallback;
import com.example.developer.cropdiagnosis.network.apis.DiseaseHistoryApi;
import com.example.developer.cropdiagnosis.network.apis.DiseaseSubmitApi;
import com.example.developer.cropdiagnosis.network.apis.ImageApi;
import com.example.developer.cropdiagnosis.network.apis.LoginApi;
import com.example.developer.cropdiagnosis.network.apis.RegisterApi;
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
import rx.Subscription;
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
    private RegisterApi registerApi = null;
    private DiseaseHistoryApi diseaseHistoryApi = null;

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
        registerApi = retrofit.create(RegisterApi.class);
        diseaseHistoryApi = retrofit.create(DiseaseHistoryApi.class);
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

    public Subscription login(String username, String password, final RequestCallback<UserModelBean> callback) {
        return loginApi.login(username, password)
                .compose(RxJavaCustomTransformer.<HttpResult<UserModelBean>>defaultSchedulers())
                .subscribe(new Subscriber<HttpResult<UserModelBean>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e.toString());
                    }

                    @Override
                    public void onNext(HttpResult<UserModelBean> result) {
                        callback.success(result.getData());
                    }
                });
    }

    public Subscription register(String phoneNumber, String password, int userType, String province, String city, String county, String village, final RequestCallback<UserModelBean> callback) {
        return registerApi.register(phoneNumber, password, userType, province, city, county, village)
                .compose(RxJavaCustomTransformer.<HttpResult<UserModelBean>>defaultSchedulers())
                .subscribe(new Subscriber<HttpResult<UserModelBean>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e.toString());
                    }

                    @Override
                    public void onNext(HttpResult<UserModelBean> result) {
                        callback.success(result.getData());
                    }
                });
    }

    public Subscription loadDiseaseHistory(String userId, final RequestCallback<List<DiseaseModelBean>> callback) {
        return diseaseHistoryApi.getDiseaseHistory(userId)
                .compose(RxJavaCustomTransformer.<HttpResult<List<DiseaseModelBean>>>defaultSchedulers())
                .subscribe(new Subscriber<HttpResult<List<DiseaseModelBean>>>() {

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e.toString());
                    }

                    @Override
                    public void onNext(HttpResult<List<DiseaseModelBean>> result) {
                        callback.success(result.getData());
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

    public Subscription submitDisease(String userId, String cropKind, String description, List<File> imageFiles, final RequestCallback<Void> callback) {
        RequestBody userIdBody = HttpUtils.createStringBody(userId);
        RequestBody cropKindBody = HttpUtils.createStringBody(cropKind);
        RequestBody descriptionBody = HttpUtils.createStringBody(description);
        Map<String, RequestBody> map = HttpUtils.createMultFileMap(imageFiles);

        return submitApi.submitDisease(userIdBody, cropKindBody, descriptionBody, map)
                .compose(RxJavaCustomTransformer.<HttpResult<Void>>defaultSchedulers())
                .subscribe(new Subscriber<HttpResult<Void>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e.toString());
                    }

                    @Override
                    public void onNext(HttpResult<Void> voidHttpResult) {
                        callback.success(null);
                    }
                });
    }

    public void getDiseaseInfo(String userId, final RequestCallback<List<DiseaseModelBean>> callback) {
        diseaseApi.getDiseaseHistory(userId)
                .compose(RxJavaCustomTransformer.<HttpResult<List<DiseaseModelBean>>>defaultSchedulers())
                .subscribe(new Subscriber<HttpResult<List<DiseaseModelBean>>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e.toString());
                    }

                    @Override
                    public void onNext(HttpResult<List<DiseaseModelBean>> result) {
                        callback.success(result.getData());
                    }
                });
    }
}
