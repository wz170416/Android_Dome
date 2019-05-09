package com.example.wanandroid.wanandorid.model;


import com.example.wanandroid.api.MyService;
import com.example.wanandroid.wanandorid.bean.PjTitleBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PjTitleM {
    public interface PjTitleCallBack{
        void onPjTitleSuccess(PjTitleBean pjTitleBean);
        void onPjTitleError(String error);
    }
    public void getPjTitle(final PjTitleCallBack callBack){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyService.PJTITLE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Observable<PjTitleBean> pjTitleData = retrofit.create(MyService.class).getPjTitleData();
        pjTitleData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PjTitleBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PjTitleBean pjTitleBean) {
                        if(pjTitleBean!=null){
                            callBack.onPjTitleSuccess(pjTitleBean);
                        }else {
                            callBack.onPjTitleError("PjTitleBean没数据");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onPjTitleError(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
