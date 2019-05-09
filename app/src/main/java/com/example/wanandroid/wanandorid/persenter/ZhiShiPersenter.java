package com.example.wanandroid.wanandorid.persenter;

import com.example.wanandroid.base.BasePersenter;
import com.example.wanandroid.wanandorid.bean.KnowledgeHierarchyData;
import com.example.wanandroid.wanandorid.callback.MyCallBack;
import com.example.wanandroid.wanandorid.model.ZhiShiModel;
import com.example.wanandroid.wanandorid.view.BView;

import java.util.List;

public class ZhiShiPersenter extends BasePersenter<BView> implements MyCallBack<List<KnowledgeHierarchyData>> {
    private ZhiShiModel bModel = new ZhiShiModel();
    public void getData(){
        bModel.getData(this);
    }

    @Override
    public void getData(List<KnowledgeHierarchyData> bean) {
        mView.getData(bean);
    }

    @Override
    public void Error(String string) {
        mView.Error(string);
    }
}
