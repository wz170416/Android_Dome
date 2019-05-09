package com.example.wanandroid.wanandorid.model;


import com.example.wanandroid.api.MyService;
import com.example.wanandroid.wanandorid.bean.NavigationBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NvgtM {
    public interface NvgtCallBack{
        void onNvgtSuccess(NavigationBean navigationBean);
        void onNvgtError(String error);
    }
    public void getNvgt(final NvgtCallBack callBack){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyService.NVGTURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Observable<NavigationBean> nvgtData = retrofit.create(MyService.class).getNvgtData();
        nvgtData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NavigationBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NavigationBean navigationBean) {
                        if(navigationBean!=null){
                            callBack.onNvgtSuccess(navigationBean);
                        }else {
                            callBack.onNvgtError("NavigationBean没数据");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onNvgtError(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
