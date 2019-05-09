package com.example.wanandroid.wanandorid.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.wanandroid.R;
import com.example.wanandroid.base.SimpleFragment;
import com.example.wanandroid.wanandorid.adapter.RecycAdater_A;
import com.example.wanandroid.wanandorid.bean.BannerBean;
import com.example.wanandroid.wanandorid.bean.DataBean;
import com.example.wanandroid.wanandorid.bean.MyDbBean;
import com.example.wanandroid.wanandorid.persenter.HomePersenter;
import com.example.wanandroid.wanandorid.utils.MyDb;
import com.example.wanandroid.wanandorid.view.AView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends SimpleFragment<AView, HomePersenter> implements AView {


    @BindView(R.id.rv_a)
    RecyclerView rvA;
    @BindView(R.id.smart_a)
    SmartRefreshLayout smart;
    private ArrayList<DataBean.DatasBean> datasBeans;
    private ArrayList<BannerBean> bannerBeans;
    private RecycAdater_A recycAdater_a;

    @Override
    protected void initView() {
        datasBeans = new ArrayList<>();
        bannerBeans = new ArrayList<>();
        rvA.setLayoutManager(new LinearLayoutManager(getContext()));
        recycAdater_a = new RecycAdater_A(bannerBeans, datasBeans, getContext());
        rvA.setAdapter(recycAdater_a);

        recycAdater_a.setOnImgClickListener(new RecycAdater_A.OnImgClickListener() {
            @Override
            public void onImgClick(int position, DataBean.DatasBean data, CheckBox img) {
                MyDbBean myDbBean = new MyDbBean();
                myDbBean.setAuthor(data.getAuthor());
                myDbBean.setBody(data.getChapterName());
                myDbBean.setTitle(data.getTitle());
                myDbBean.setTime(data.getNiceDate());
                if(img.isChecked()==false){
                    ArrayList<MyDbBean> where = (ArrayList<MyDbBean>) MyDb.getMyDb().where(myDbBean);
                    MyDb.getMyDb().delete(where);
                }else {

                    MyDb.getMyDb().insert(myDbBean);
                }

            }
        });
    }

    @Override
    protected void initData() {
        mPersenter.getData();
    }

    @Override
    protected HomePersenter initPersenter() {
        return new HomePersenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_a;
    }

    @Override
    public void onSuccess(DataBean bean) {
        datasBeans.addAll(bean.getDatas());
        recycAdater_a.setDatasBeans(datasBeans);
        recycAdater_a.notifyDataSetChanged();
    }

    @Override
    public void onBanner(List<BannerBean> bean) {
        bannerBeans.addAll(bean);
        recycAdater_a.setBeanArrayList(bannerBeans);
        recycAdater_a.notifyDataSetChanged();
    }

    @Override
    public void onFail(String s) {
        Log.e("wz", "onFail: " + s);
        Toast.makeText(getContext(), "" + s, Toast.LENGTH_SHORT).show();
    }
}