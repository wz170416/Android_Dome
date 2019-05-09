package com.example.wanandroid.wanandorid.view;

import com.example.wanandroid.base.BaseView;
import com.example.wanandroid.wanandorid.bean.BannerBean;
import com.example.wanandroid.wanandorid.bean.DataBean;

import java.util.List;

public interface AView extends BaseView {
    void onSuccess(DataBean bean);
    void onBanner(List<BannerBean> bean);
    void onFail(String s);
}
