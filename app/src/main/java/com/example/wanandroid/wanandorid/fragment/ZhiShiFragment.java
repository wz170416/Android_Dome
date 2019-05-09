package com.example.wanandroid.wanandorid.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.wanandroid.R;
import com.example.wanandroid.base.SimpleFragment;
import com.example.wanandroid.wanandorid.adapter.RecycAdater_B;
import com.example.wanandroid.wanandorid.bean.KnowledgeHierarchyData;
import com.example.wanandroid.wanandorid.persenter.ZhiShiPersenter;
import com.example.wanandroid.wanandorid.view.BView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhiShiFragment extends SimpleFragment<BView, ZhiShiPersenter> implements BView {

    @BindView(R.id.rv_b)
    RecyclerView rvB;
    @BindView(R.id.smart_b)
    SmartRefreshLayout smartB;
    private ArrayList<KnowledgeHierarchyData> data=new ArrayList<>();
    private RecycAdater_B adaterB;

    @Override
    protected void initView() {

        LinearLayoutManager lin = new LinearLayoutManager(getContext());
        rvB.setLayoutManager(lin);
        adaterB = new RecycAdater_B(data, getContext());
        rvB.setAdapter(adaterB);
    }

    @Override
    protected void initData() {
      mPersenter.getData();
    }

    @Override
    protected ZhiShiPersenter initPersenter() {
        return new ZhiShiPersenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_b;
    }

    @Override
    public void getData(List<KnowledgeHierarchyData> bean) {
        data.addAll(bean);
        adaterB.setList(data);
        adaterB.notifyDataSetChanged();
    }

    @Override
    public void Error(String string) {
        Toast.makeText(getContext(), string, Toast.LENGTH_SHORT).show();
    }


}
