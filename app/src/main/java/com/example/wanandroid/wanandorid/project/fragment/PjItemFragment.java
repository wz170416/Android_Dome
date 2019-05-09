package com.example.wanandroid.wanandorid.project.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.wanandroid.R;
import com.example.wanandroid.base.SimpleFragment;
import com.example.wanandroid.wanandorid.activity.HomeInfoActivity;
import com.example.wanandroid.wanandorid.bean.PjItemBean;
import com.example.wanandroid.wanandorid.persenter.PjItemP;
import com.example.wanandroid.wanandorid.project.adapter.PjItemReAdapter;
import com.example.wanandroid.wanandorid.view.PjItemV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

@SuppressLint("ValidFragment")
public class PjItemFragment extends SimpleFragment<PjItemV, PjItemP> implements PjItemV {
    @BindView(R.id.recycler)
    RecyclerView mRecycler;
    private View view;
    private Unbinder unbinder;
    private int id;
    private int page=1;
    private ArrayList<PjItemBean.DataBean.DatasBean> pjItems;
    private PjItemReAdapter pjItemReAdapter;
    @SuppressLint("ValidFragment")
    public PjItemFragment(int id) {
        this.id=id;
    }

    @Override
    protected void initData() {
        mPersenter.getPjItemData(page,id);
    }

    @Override
    protected void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mRecycler.setLayoutManager(manager);
        pjItems =new ArrayList<>();
        pjItemReAdapter =new PjItemReAdapter(getActivity(),pjItems);
        mRecycler.setAdapter(pjItemReAdapter);

        pjItemReAdapter.setOnClickListener(new PjItemReAdapter.OnClickListener() {
            @Override
            public void onClick(int position, PjItemBean.DataBean.DatasBean pjItemData) {
                Intent intent = new Intent(getActivity(), HomeInfoActivity.class);
                intent.putExtra("url",pjItemData.getLink());
                intent.putExtra("title",pjItemData.getTitle());
                startActivity(intent);
            }
        });

    }

    @Override
    protected PjItemP initPersenter() {
        return new PjItemP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_project_item;
    }


    @Override
    public void onPjItemSuccess(PjItemBean pjItemBean) {
        pjItems.addAll(pjItemBean.getData().getDatas());
        pjItemReAdapter.setPjItems(pjItems);
        pjItemReAdapter.notifyDataSetChanged();
    }

    @Override
    public void onPjItemError(String error) {
        Toast.makeText(getActivity(),"Project："+error, Toast.LENGTH_SHORT).show();
        Log.e("Project：",error);
    }
}
