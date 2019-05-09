package com.example.wanandroid.wanandorid.view;

import com.example.wanandroid.base.BaseView;
import com.example.wanandroid.wanandorid.bean.KnowledgeHierarchyData;

import java.util.List;

public interface BView extends BaseView {
    void getData(List<KnowledgeHierarchyData> bean);
    void Error(String string);
}
