package com.example.wanandroid.wanandorid.persenter;

import com.example.wanandroid.base.BasePersenter;
import com.example.wanandroid.wanandorid.bean.BannerBean;
import com.example.wanandroid.wanandorid.bean.DataBean;
import com.example.wanandroid.wanandorid.callback.MyCallBack;
import com.example.wanandroid.wanandorid.model.HomeModel;
import com.example.wanandroid.wanandorid.view.AView;

import java.util.List;

public class HomePersenter extends BasePersenter<AView> implements MyCallBack {
    private AView aView;

    public HomePersenter(AView aView) {
        this.aView = aView;
    }

    public void getData(){
        HomeModel aModel = new HomeModel();
        aModel.getBanner(this);
        aModel.getTitle(this);
    }

    @Override
    public void getData(Object bean) {
        if (bean instanceof DataBean){
            aView.onSuccess((DataBean) bean);
        }else if (bean instanceof List){
            aView.onBanner((List<BannerBean>) bean);
        }
    }

    @Override
    public void Error(String string) {
        aView.onFail(string);
    }
}
