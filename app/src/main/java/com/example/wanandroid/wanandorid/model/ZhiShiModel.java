package com.example.wanandroid.wanandorid.model;

import com.example.myhttplibrary.callback.BaseResponce;
import com.example.myhttplibrary.callback.ObServerCallback;
import com.example.myhttplibrary.utils.HttpUtils;
import com.example.wanandroid.api.ApiManager;
import com.example.wanandroid.wanandorid.bean.KnowledgeHierarchyData;
import com.example.wanandroid.wanandorid.callback.MyCallBack;

import java.util.List;


public class ZhiShiModel {
    public void getData(final MyCallBack<List<KnowledgeHierarchyData>> myCallBack){
        ApiManager.getInstance().getServerList().getKnowledgeHierarchyData()
                .compose(HttpUtils.<BaseResponce<List<KnowledgeHierarchyData>>>rxShcdule())
                .compose(HttpUtils.<List<KnowledgeHierarchyData>>handResult())
                .subscribe(new ObServerCallback<List<KnowledgeHierarchyData>>() {
                    @Override
                    public void onNext(List<KnowledgeHierarchyData> knowledgeHierarchyData) {
                        myCallBack.getData(knowledgeHierarchyData);
                    }

                    @Override
                    public void onError(String message) {
                        myCallBack.Error(message);
                    }
                });
    }
}
