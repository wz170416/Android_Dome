package com.example.wanandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class SimpleActivity extends AppCompatActivity {

    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View inflate = LayoutInflater.from(this).inflate(getLayout(),null);
        setContentView(inflate);
        bind = ButterKnife.bind(this);
        viewCreate(inflate);
        initData();
    }

    protected abstract void initData();

    public void viewCreate(View inflate) {

    }

    protected abstract int getLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind==null){
            bind.unbind();
        }
    }
}
