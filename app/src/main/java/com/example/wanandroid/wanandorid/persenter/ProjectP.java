package com.example.wanandroid.wanandorid.persenter;

import com.example.wanandroid.base.BasePersenter;
import com.example.wanandroid.wanandorid.bean.PjTitleBean;
import com.example.wanandroid.wanandorid.model.PjTitleM;
import com.example.wanandroid.wanandorid.view.ProjectV;

public class ProjectP extends BasePersenter<ProjectV> implements PjTitleM.PjTitleCallBack {

    private PjTitleM pjTitleM;

    public void getPjData(){
        pjTitleM = new PjTitleM();
        pjTitleM.getPjTitle(this);
    }

    @Override
    public void onPjTitleSuccess(PjTitleBean pjTitleBean) {
        mView.onPjTSuccess(pjTitleBean);
    }

    @Override
    public void onPjTitleError(String error) {
        mView.onPjTError(error);
    }
}
