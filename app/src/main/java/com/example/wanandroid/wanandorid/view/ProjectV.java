package com.example.wanandroid.wanandorid.view;


import com.example.wanandroid.base.BaseView;
import com.example.wanandroid.wanandorid.bean.PjTitleBean;

public interface ProjectV extends BaseView {
    void onPjTSuccess(PjTitleBean pjTitleBean);
    void onPjTError(String error);
}
