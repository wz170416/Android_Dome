package com.example.wanandroid.wanandorid.collect.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;


import com.example.wanandroid.R;
import com.example.wanandroid.base.SimpleFragment;
import com.example.wanandroid.wanandorid.bean.MyDbBean;
import com.example.wanandroid.wanandorid.collect.adapter.ReAdapter_Collect;
import com.example.wanandroid.wanandorid.persenter.CollectP;
import com.example.wanandroid.wanandorid.utils.MyDb;
import com.example.wanandroid.wanandorid.view.CollectV;

import java.util.ArrayList;

import butterknife.BindView;

import butterknife.Unbinder;

public class CollectFragment extends SimpleFragment<CollectV, CollectP> implements CollectV{
    @BindView(R.id.recycler)
    RecyclerView mRecycler;
    private View view;
    private Unbinder unbinder;
    private ArrayList<MyDbBean> myDbBeans =new ArrayList<>();
    private ReAdapter_Collect reAdapter_collect;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()){
            initData();
        }else {
            myDbBeans.clear();
        }
    }

    @Override
    protected void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mRecycler.setLayoutManager(manager);
        reAdapter_collect =new ReAdapter_Collect(myDbBeans,getActivity());
        mRecycler.setAdapter(reAdapter_collect);

        reAdapter_collect.setOnItemClickListener(new ReAdapter_Collect.OnItemClickListener() {
            @Override
            public void onItemClick(int position, MyDbBean myDbBean) {
                //MyDb.getMyDb().delete(myDbBean);
                myDbBeans.remove(position);
                reAdapter_collect.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void initData() {
        mPersenter.getCollectData();
    }

    @Override
    protected CollectP initPersenter() {
        return new CollectP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_collect;
    }

    @Override
    public void onDbSuccess(ArrayList<MyDbBean> myDbBean) {
        myDbBeans.addAll(myDbBean);
        reAdapter_collect.setMyDbBeans(myDbBeans);
        reAdapter_collect.notifyDataSetChanged();
    }

    @Override
    public void onDbError(String error) {

    }
}
