package com.example.wanandroid.wanandorid.persenter;


import com.example.wanandroid.base.BasePersenter;
import com.example.wanandroid.wanandorid.bean.NavigationBean;
import com.example.wanandroid.wanandorid.model.NvgtM;
import com.example.wanandroid.wanandorid.view.NvgtV;

public class NvgtP extends BasePersenter<NvgtV> implements NvgtM.NvgtCallBack {

    private NvgtM nvgtM;

    public void getNvgtData(){
        nvgtM = new NvgtM();
        nvgtM.getNvgt(this);
    }

    @Override
    public void onNvgtSuccess(NavigationBean navigationBean) {
        mView.onNvgtSuccess(navigationBean);
    }

    @Override
    public void onNvgtError(String error) {
        mView.onNvgtError(error);
    }
}
