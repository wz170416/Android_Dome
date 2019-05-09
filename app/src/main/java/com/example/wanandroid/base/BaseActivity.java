package com.example.wanandroid.base;

import android.view.View;

public abstract class BaseActivity<V,P extends BasePersenter<V>> extends SimpleActivity {
    public P presenter;
    @Override
    public void viewCreate(View view) {
        super.viewCreate(view);
        presenter=createPresenter();
        presenter.attachView((V) this);
    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter == null) {
            presenter.deachView();
            presenter=null;
        }
    }
}
