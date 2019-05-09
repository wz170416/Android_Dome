package com.example.wanandroid.wanandorid.view;


import com.example.wanandroid.base.BaseView;
import com.example.wanandroid.wanandorid.bean.PjItemBean;

public interface PjItemV extends BaseView {
    void onPjItemSuccess(PjItemBean pjItemBean);
    void onPjItemError(String error);
}
