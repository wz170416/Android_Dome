package com.example.wanandroid.wanandorid.view;

import com.example.wanandroid.base.BaseView;
import com.example.wanandroid.wanandorid.bean.MyDbBean;

import java.util.ArrayList;

public interface CollectV extends BaseView {
    void onDbSuccess(ArrayList<MyDbBean> myDbBean);
    void onDbError(String error);
}
