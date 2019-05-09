package com.example.wanandroid.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class SimpleFragment<V,P extends BasePersenter<V>> extends Fragment {

    private Unbinder unbinder;
    protected P mPersenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this,inflate);
        mPersenter = initPersenter();
        mPersenter.attachView((V) this);

        initView();
        initData();
        return inflate;
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract P initPersenter();

    protected abstract int getLayoutId();
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPersenter == null&&unbinder!=null){
            unbinder.unbind();
            mPersenter.deachView();
            mPersenter = null;
        }
    }
}
