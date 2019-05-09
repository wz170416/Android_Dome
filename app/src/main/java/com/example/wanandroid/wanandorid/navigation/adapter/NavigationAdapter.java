package com.example.wanandroid.wanandorid.navigation.adapter;


import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wanandroid.R;
import com.example.wanandroid.wanandorid.bean.NavigationBean;
import com.example.wanandroid.wanandorid.utils.FlowLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NavigationAdapter extends RecyclerView.Adapter {

    private List<NavigationBean.DataBean> list;
    private Context context;

    public NavigationAdapter(List<NavigationBean.DataBean> list, Context context) {

        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.navigation_item, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int pos) {
        ViewHolder holder = (ViewHolder) viewHolder;
        holder.tv.setText(list.get(pos).getName());
        if (pos % 4 == 0) {
            holder.tv.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
        } else if (pos % 4 == 1) {
            holder.tv.setTextColor(ContextCompat.getColor(context, R.color.gold_title));
        } else if (pos % 4 == 2) {
            holder.tv.setTextColor(ContextCompat.getColor(context, R.color.light_red));
        } else if (pos % 4 == 3) {
            holder.tv.setTextColor(ContextCompat.getColor(context, R.color.blue));
        }
        List<NavigationBean.DataBean.ArticlesBean> bean = list.get(pos).getArticles();
//        holder.fl.removeAllViews();
        for (int i = 0; i < bean.size(); i++) {
//            TextView view = new TextView(context);
            TextView view = (TextView) LayoutInflater.from(context).inflate(R.layout.item_flow, null);
            view.setText(bean.get(i).getTitle());
            view.setTextColor(Color.BLUE);
//          view.setBackgroundDrawable(getResources().getDrawable(R.drawable.textview_bg));
            if (i % 4 == 0) {
                view.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
            } else if (i % 4 == 1) {
                view.setTextColor(ContextCompat.getColor(context, R.color.gold_title));
            } else if (i % 4 == 2) {
                view.setTextColor(ContextCompat.getColor(context, R.color.light_red));
            } else if (i % 4 == 3) {
                view.setTextColor(ContextCompat.getColor(context, R.color.blue));
            }
            holder.nvgt_fl.addView(view);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(List<NavigationBean.DataBean> data) {
        list.addAll(data);
        notifyDataSetChanged();
    }


        static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv)
        TextView tv;
            @BindView(R.id.nvgt_fl)
            FlowLayout nvgt_fl;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
