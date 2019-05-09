package com.example.wanandroid.wanandorid.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.example.wanandroid.R;
import com.example.wanandroid.base.SimpleFragment;
import com.example.wanandroid.wanandorid.adapter.FragmentAdapter_c;
import com.example.wanandroid.wanandorid.bean.WxAuthor;
import com.example.wanandroid.wanandorid.persenter.WeChatPersenter;
import com.example.wanandroid.wanandorid.view.CView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeChatFragment extends SimpleFragment<CView, WeChatPersenter> implements CView {

    @BindView(R.id.tab_c)
    TabLayout tabC;
    @BindView(R.id.vp_c)
    ViewPager vpC;
    Unbinder unbinder;
    private ArrayList<Fragment> fragments;
    private List<WxAuthor> list=new ArrayList<>();
    private FragmentAdapter_c fragmentAdapter_c;

    @Override
    protected void initView() {
        fragments = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            fragments.add(new WeChatFragment_List(list.get(i).getId()));
            tabC.addTab(tabC.newTab().setText(list.get(i).getName()));
        }
        fragmentAdapter_c = new FragmentAdapter_c(getChildFragmentManager(), fragments);
        vpC.setAdapter(fragmentAdapter_c);
        tabC.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpC.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vpC.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabC));
    }

    @Override
    protected void initData() {
        mPersenter.getData();
    }

    @Override
    protected WeChatPersenter initPersenter() {
        return new WeChatPersenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_c;
    }

    @Override
    public void onSuccess(List<WxAuthor> bean) {
        list.addAll(bean);
        for (int i = 0; i < list.size(); i++) {
            list.set(i,bean.get(i));
        }
        //list.addAll(bean);
        fragmentAdapter_c.notifyDataSetChanged();
        initView();
        String name = bean.get(0).getName();
        Log.e("wz", "onSuccess: "+name );
    }

    @Override
    public void onError(String string) {
        Log.e("wz", "onError: "+string );
    }
}
