package com.example.wanandroid.wanandorid.model;


import com.example.wanandroid.api.MyService;
import com.example.wanandroid.wanandorid.bean.PjItemBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PjItemM {
    public interface PjItemCallBack{
        void onPjItemSuccess(PjItemBean pjItemBean);
        void onPjItemError(String error);
    }
    public void getPjData(int page, int cid, final PjItemCallBack callBack){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyService.PJITEM)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Observable<PjItemBean> pjItemData = retrofit.create(MyService.class).getPjItemData(page, cid);
        pjItemData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PjItemBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PjItemBean pjItemBean) {
                        if(pjItemBean!=null){
                            callBack.onPjItemSuccess(pjItemBean);
                        }else {
                            callBack.onPjItemError("PjItemBean没数据");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onPjItemError(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
