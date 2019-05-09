package com.example.wanandroid.wanandorid.view;


import com.example.wanandroid.base.BaseView;
import com.example.wanandroid.wanandorid.bean.NavigationBean;

public interface NvgtV extends BaseView {
    void onNvgtSuccess(NavigationBean navigationBean);
    void onNvgtError(String error);
}
