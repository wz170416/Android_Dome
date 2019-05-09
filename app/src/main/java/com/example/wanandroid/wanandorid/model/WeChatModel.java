package com.example.wanandroid.wanandorid.model;

import com.example.myhttplibrary.callback.BaseResponce;
import com.example.myhttplibrary.callback.ObServerCallback;
import com.example.myhttplibrary.utils.HttpUtils;
import com.example.wanandroid.api.ApiManager;
import com.example.wanandroid.wanandorid.bean.WxAuthor;
import com.example.wanandroid.wanandorid.callback.MyCallBack;

import java.util.List;

public class WeChatModel {
    public void getData(final MyCallBack<List<WxAuthor>> myCallBack){
        ApiManager.getInstance().getServerList().getWxAuthorListData()
                .compose(HttpUtils.<BaseResponce<List<WxAuthor>>>rxShcdule())
                .compose(HttpUtils.<List<WxAuthor>>handResult())
                .subscribe(new ObServerCallback<List<WxAuthor>>() {
                    @Override
                    public void onNext(List<WxAuthor> wxAuthors) {
                        myCallBack.getData(wxAuthors);
                    }

                    @Override
                    public void onError(String message) {
                        myCallBack.Error(message);
                    }
                });
    }
}
