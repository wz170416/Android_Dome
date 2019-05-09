package com.example.wanandroid.wanandorid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.wanandroid.R;
import com.example.wanandroid.base.BaseActivity;
import com.example.wanandroid.wanandorid.activity.HomeInfoP;
import com.example.wanandroid.wanandorid.activity.HomeInfoV;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeInfoActivity extends BaseActivity<HomeInfoV, HomeInfoP> implements View.OnClickListener {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.web)
    WebView mWeb;
    @BindView(R.id.info_backarrow)
    ImageView mInfoBackarrow;
    @BindView(R.id.info_tv)
    TextView mInfoTv;
    @BindView(R.id.info_collect)
    ImageView mInfoCollect;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");
        mToolbar.setTitle("");
        mInfoTv.setText(title);
        //setSupportActionBar(mToolbar);
        mWeb.loadUrl(url);
        mInfoBackarrow.setOnClickListener(this);
    }


    @Override
    protected int getLayout() {
        return R.layout.activity_home_info;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1, 1, 1, "qwe");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {
        finish();
    }

    @Override
    protected HomeInfoP createPresenter() {
        return new HomeInfoP();
    }
}
