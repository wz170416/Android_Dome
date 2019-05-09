package com.example.wanandroid.wanandorid.persenter;

import com.example.wanandroid.base.BasePersenter;
import com.example.wanandroid.wanandorid.bean.WxAuthor;
import com.example.wanandroid.wanandorid.callback.MyCallBack;
import com.example.wanandroid.wanandorid.model.WeChatModel;
import com.example.wanandroid.wanandorid.view.CView;

import java.util.List;

public class WeChatPersenter extends BasePersenter<CView> implements MyCallBack<List<WxAuthor>> {
    public void getData(){
        WeChatModel cModel = new WeChatModel();
        cModel.getData(this);
    }

    @Override
    public void getData(List<WxAuthor> bean) {
        mView.onSuccess(bean);
    }

    @Override
    public void Error(String string) {
        mView.onError(string);
    }
}
