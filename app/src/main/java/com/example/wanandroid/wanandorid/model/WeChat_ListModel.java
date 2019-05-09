package com.example.wanandroid.wanandorid.model;

import com.example.myhttplibrary.callback.BaseResponce;
import com.example.myhttplibrary.callback.ObServerCallback;
import com.example.myhttplibrary.utils.HttpUtils;
import com.example.wanandroid.api.ApiManager;
import com.example.wanandroid.wanandorid.bean.FeedArticleListData;
import com.example.wanandroid.wanandorid.callback.MyCallBack;

public class WeChat_ListModel {
    public void getData(final MyCallBack<FeedArticleListData> myCallBack, int num){
        ApiManager.getInstance().getServerList().getWxSumData(num,1)
                .compose(HttpUtils.<BaseResponce<FeedArticleListData>>rxShcdule())
                .compose(HttpUtils.<FeedArticleListData>handResult())
                .subscribe(new ObServerCallback<FeedArticleListData>() {
                    @Override
                    public void onNext(FeedArticleListData feedArticleListData) {
                        myCallBack.getData(feedArticleListData);
                    }

                    @Override
                    public void onError(String message) {
                        myCallBack.Error(message);
                    }
                });
    }
    public void getDatas(final MyCallBack<FeedArticleListData> myCallBack, int id, int page, String s){
        ApiManager.getInstance().getServerList().getWxSearchSumData(id,page,s)
                .compose(HttpUtils.<BaseResponce<FeedArticleListData>>rxShcdule())
                .compose(HttpUtils.<FeedArticleListData>handResult())
                .subscribe(new ObServerCallback<FeedArticleListData>() {
                    @Override
                    public void onNext(FeedArticleListData feedArticleListData) {
                        myCallBack.getData(feedArticleListData);
                    }

                    @Override
                    public void onError(String message) {
                        myCallBack.Error(message);
                    }
                });
    }
}
