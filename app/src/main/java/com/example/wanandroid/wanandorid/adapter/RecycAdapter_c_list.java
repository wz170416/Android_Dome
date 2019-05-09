package com.example.wanandroid.wanandorid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wanandroid.R;
import com.example.wanandroid.wanandorid.bean.FeedArticleListData;

import java.util.ArrayList;

public class RecycAdapter_c_list extends RecyclerView.Adapter<RecycAdapter_c_list.HHH> {
    private ArrayList<FeedArticleListData.DatasBean> list;
    private Context context;

    public RecycAdapter_c_list(ArrayList<FeedArticleListData.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<FeedArticleListData.DatasBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public HHH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_recyc_a_title, null);
        HHH hhh = new HHH(inflate);
        return hhh;
    }

    @Override
    public void onBindViewHolder(@NonNull HHH hhh, int i) {
        hhh.author.setText(list.get(i).getAuthor());
        hhh.chapterName.setText(list.get(i).getChapterName());
        hhh.niceDate.setText(list.get(i).getNiceDate());
        hhh.title.setText(list.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HHH extends RecyclerView.ViewHolder {
        private ImageView follow;
        private TextView author;
        private TextView chapterName;
        private TextView title;
        private TextView niceDate;
        public HHH(@NonNull View itemView) {
            super(itemView);
            follow=itemView.findViewById(R.id.follow);
            author=itemView.findViewById(R.id.author);
            chapterName=itemView.findViewById(R.id.chapterName);
            title=itemView.findViewById(R.id.title);
            niceDate=itemView.findViewById(R.id.niceDate);
        }
    }
}
