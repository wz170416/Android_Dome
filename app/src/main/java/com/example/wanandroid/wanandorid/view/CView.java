package com.example.wanandroid.wanandorid.view;

import com.example.wanandroid.base.BaseView;
import com.example.wanandroid.wanandorid.bean.WxAuthor;

import java.util.List;

public interface CView extends BaseView {
    void onSuccess(List<WxAuthor> bean);
    void onError(String string);
}
