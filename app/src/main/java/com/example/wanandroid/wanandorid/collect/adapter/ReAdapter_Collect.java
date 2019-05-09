package com.example.wanandroid.wanandorid.collect.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wanandroid.R;
import com.example.wanandroid.wanandorid.bean.MyDbBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReAdapter_Collect extends RecyclerView.Adapter<ReAdapter_Collect.ViewHolder> {

    private ArrayList<MyDbBean> myDbBeans;
    private Context context;

    public ReAdapter_Collect(ArrayList<MyDbBean> myDbBeans, Context context) {
        this.myDbBeans = myDbBeans;
        this.context = context;
    }

    public void setMyDbBeans(ArrayList<MyDbBean> myDbBeans) {
        this.myDbBeans = myDbBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_recyc_a_title, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.author.setText(myDbBeans.get(i).getAuthor());
        viewHolder.chapterName.setText(myDbBeans.get(i).getBody());
        viewHolder.niceDate.setText(myDbBeans.get(i).getTime());
        viewHolder.title.setText(myDbBeans.get(i).getTitle());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(i,myDbBeans.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return myDbBeans.size();
    }

    static

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.author)
        TextView author;
        @BindView(R.id.chapterName)
        TextView chapterName;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.niceDate)
        TextView niceDate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position,MyDbBean myDbBean);
    }

}
