package com.example.wanandroid.wanandorid.persenter;

import com.example.wanandroid.base.BasePersenter;
import com.example.wanandroid.wanandorid.bean.PjItemBean;
import com.example.wanandroid.wanandorid.model.PjItemM;
import com.example.wanandroid.wanandorid.view.PjItemV;

;

public class PjItemP extends BasePersenter<PjItemV> implements PjItemM.PjItemCallBack {

    private PjItemM pjItemM;

    public void getPjItemData(int page, int cid){
        pjItemM = new PjItemM();
        pjItemM.getPjData(page,cid,this);
    }

    @Override
    public void onPjItemSuccess(PjItemBean pjItemBean) {
        mView.onPjItemSuccess(pjItemBean);
    }

    @Override
    public void onPjItemError(String error) {
        mView.onPjItemError(error);
    }
}
