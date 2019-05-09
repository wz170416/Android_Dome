package com.example.wanandroid.wanandorid.setting.fragment;

import com.example.wanandroid.R;
import com.example.wanandroid.base.SimpleFragment;
import com.example.wanandroid.wanandorid.persenter.SettingP;
import com.example.wanandroid.wanandorid.view.SettingV;

public class SettingFragment extends SimpleFragment<SettingV,SettingP> {
    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected SettingP initPersenter() {
        return new SettingP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_setting;
    }
}
