package com.example.wanandroid.wanandorid.persenter;

import com.example.wanandroid.base.BasePersenter;
import com.example.wanandroid.wanandorid.bean.FeedArticleListData;
import com.example.wanandroid.wanandorid.callback.MyCallBack;
import com.example.wanandroid.wanandorid.model.WeChat_ListModel;
import com.example.wanandroid.wanandorid.view.C_ListView;

public class WeChat_ListPersenter extends BasePersenter<C_ListView> implements MyCallBack<FeedArticleListData> {

    private WeChat_ListModel c_listModel;

    public void getData(int id){
        c_listModel = new WeChat_ListModel();
        c_listModel.getData(this,id);
    }

    public void getDatas(int id, int page, String s){
        c_listModel.getDatas(this,id,page,s);
    }

    @Override
    public void getData(FeedArticleListData bean) {
        mView.onSuccess(bean);
    }

    @Override
    public void Error(String string) {
        mView.onError(string);
    }
}
