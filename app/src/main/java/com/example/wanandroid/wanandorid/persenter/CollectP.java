package com.example.wanandroid.wanandorid.persenter;

import com.example.wanandroid.base.BasePersenter;
import com.example.wanandroid.wanandorid.bean.MyDbBean;
import com.example.wanandroid.wanandorid.model.CollectModel;
import com.example.wanandroid.wanandorid.view.CollectV;

import java.util.ArrayList;

public class CollectP extends BasePersenter<CollectV> implements CollectModel.CollectCallBack {

    private CollectModel collectModel;

    public void getCollectData(){
        collectModel = new CollectModel();
        collectModel.getCollectData(this);
    }

    @Override
    public void onSuccessCollect(ArrayList<MyDbBean> myDbBean) {
        mView.onDbSuccess(myDbBean);
    }

    @Override
    public void onErrorCollect(String error) {
        mView.onDbError(error);
    }
}
