package com.example.wanandroid.wanandorid.model;

import com.example.wanandroid.wanandorid.bean.MyDbBean;
import com.example.wanandroid.wanandorid.utils.MyDb;

import java.util.ArrayList;
import java.util.List;

public class CollectModel {
    public interface CollectCallBack{
        void onSuccessCollect(ArrayList<MyDbBean> myDbBean);
        void onErrorCollect(String error);
    }
    public void getCollectData(CollectCallBack collectCallBack){
        ArrayList<MyDbBean> query = (ArrayList<MyDbBean>) MyDb.getMyDb().query();
        if(query!=null){
            collectCallBack.onSuccessCollect(query);
        }else {
            collectCallBack.onErrorCollect("没数据");
        }

    }
}
