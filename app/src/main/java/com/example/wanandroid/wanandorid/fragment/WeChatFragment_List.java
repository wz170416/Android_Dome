package com.example.wanandroid.wanandorid.fragment;

import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.wanandroid.R;
import com.example.wanandroid.base.SimpleFragment;
import com.example.wanandroid.wanandorid.adapter.RecycAdapter_c_list;
import com.example.wanandroid.wanandorid.bean.FeedArticleListData;
import com.example.wanandroid.wanandorid.persenter.WeChat_ListPersenter;
import com.example.wanandroid.wanandorid.view.C_ListView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.Unbinder;

@SuppressLint("ValidFragment")
public class WeChatFragment_List extends SimpleFragment<C_ListView, WeChat_ListPersenter> implements C_ListView, View.OnClickListener {

    @BindView(R.id.search_back_ib)
    ImageButton searchBackIb;
    @BindView(R.id.search_tv)
    TextView searchTv;
    @BindView(R.id.search_edit)
    EditText searchEdit;
    @BindView(R.id.search_tint_tv)
    TextView searchTintTv;
    @BindView(R.id.search_toolbar)
    Toolbar searchToolbar;
    @BindView(R.id.we_detail_list_recycler_view)
    RecyclerView weDetailListRecyclerView;
    @BindView(R.id.normal_view)
    SmartRefreshLayout normalView;
    Unbinder unbinder;
    private int name;
    private ArrayList<FeedArticleListData.DatasBean> datasBeans;
    private RecycAdapter_c_list recycAdapter_c_list;
    int page=1;
    String s;

    @SuppressLint("ValidFragment")
    public WeChatFragment_List(int name) {
        this.name = name;
    }

    @Override
    protected void initView() {
        weDetailListRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        datasBeans = new ArrayList<>();
        recycAdapter_c_list = new RecycAdapter_c_list(datasBeans, getContext());
        weDetailListRecyclerView.setAdapter(recycAdapter_c_list);
        searchTv.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        mPersenter.getData(name);
    }

    @Override
    protected WeChat_ListPersenter initPersenter() {
        return new WeChat_ListPersenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cfragment__list;
    }

    @Override
    public void onSuccess(FeedArticleListData bean) {
        datasBeans.clear();
        datasBeans.addAll(bean.getDatas());
        recycAdapter_c_list.setList(datasBeans);
        recycAdapter_c_list.notifyDataSetChanged();
    }

    @Override
    public void onError(String string) {
        Log.e("wz", "onError: "+string );
    }

    @Override
    public void onClick(View v) {
        s=searchEdit.getText().toString();
        mPersenter.getDatas(name,page,s);
    }
}
