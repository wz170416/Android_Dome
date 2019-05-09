package com.example.wanandroid.wanandorid.view;

import com.example.wanandroid.base.BaseView;
import com.example.wanandroid.wanandorid.bean.FeedArticleListData;

import java.util.List;

public interface C_ListView extends BaseView {
    void onSuccess(FeedArticleListData bean);
    void onError(String string);
}
