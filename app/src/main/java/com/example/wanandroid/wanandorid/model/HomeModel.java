package com.example.wanandroid.wanandorid.model;

import com.example.myhttplibrary.callback.BaseResponce;
import com.example.myhttplibrary.callback.ObServerCallback;
import com.example.myhttplibrary.utils.HttpUtils;
import com.example.wanandroid.api.ApiManager;
import com.example.wanandroid.wanandorid.bean.BannerBean;
import com.example.wanandroid.wanandorid.bean.DataBean;
import com.example.wanandroid.wanandorid.callback.MyCallBack;

import java.util.List;

public class HomeModel {
    public void getTitle(final MyCallBack<DataBean> myCallBack){
        ApiManager.getInstance().getServer().getTitle(1)
                .compose(HttpUtils.<BaseResponce<DataBean>>rxShcdule())
                .compose(HttpUtils.<DataBean>handResult())
                .subscribe(new ObServerCallback<DataBean>() {
                    @Override
                    public void onNext(DataBean dataBean) {
                        myCallBack.getData(dataBean);
                    }

                    @Override
                    public void onError(String message) {
                        myCallBack.Error(message);
                    }
                });
    }
    public void getBanner(final MyCallBack<List<BannerBean>> myCallBack){
        ApiManager.getInstance().getServer().getBanner()
                .compose(HttpUtils.<BaseResponce<List<BannerBean>>>rxShcdule())
                .compose(HttpUtils.<List<BannerBean>>handResult())
                .subscribe(new ObServerCallback<List<BannerBean>>() {
                    @Override
                    public void onNext(List<BannerBean> bannerBeans) {
                        myCallBack.getData(bannerBeans);
                    }

                    @Override
                    public void onError(String message) {
                        myCallBack.Error(message);
                    }
                });
    }
}
