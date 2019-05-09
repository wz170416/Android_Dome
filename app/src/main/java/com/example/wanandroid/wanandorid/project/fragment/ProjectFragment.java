package com.example.wanandroid.wanandorid.project.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.wanandroid.R;
import com.example.wanandroid.base.SimpleFragment;
import com.example.wanandroid.wanandorid.bean.PjTitleBean;
import com.example.wanandroid.wanandorid.persenter.ProjectP;
import com.example.wanandroid.wanandorid.project.adapter.ProjectFpAdapter;
import com.example.wanandroid.wanandorid.view.ProjectV;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ProjectFragment extends SimpleFragment<ProjectV, ProjectP> implements ProjectV{
    @BindView(R.id.tab)
    SlidingTabLayout mTab;
    @BindView(R.id.pager)
    ViewPager mPager;
    private View view;
    private Unbinder unbinder;
    private ArrayList<String> titles;
    private ArrayList<Fragment> fragments;
    private ProjectFpAdapter fpAdapter;


    @Override
    protected void initData() {
        mPersenter.getPjData();
    }

    @Override
    protected void initView() {
        titles = new ArrayList<>();
        fragments = new ArrayList<>();
        fpAdapter =new ProjectFpAdapter(getChildFragmentManager(),fragments,titles);
        mPager.setAdapter(fpAdapter);
        mTab.setViewPager(mPager);


    }

    @Override
    protected ProjectP initPersenter() {
        return new ProjectP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_project;
    }

    @Override
    public void onPjTSuccess(PjTitleBean pjTitleBean) {
        List<PjTitleBean.DataBean> data = pjTitleBean.getData();
        for (PjTitleBean.DataBean pjData:data) {
            titles.add(pjData.getName());
            fragments.add(new PjItemFragment(pjData.getId()));
        }
        fpAdapter.notifyDataSetChanged();
        mTab.notifyDataSetChanged();
    }

    @Override
    public void onPjTError(String error) {

    }
}
