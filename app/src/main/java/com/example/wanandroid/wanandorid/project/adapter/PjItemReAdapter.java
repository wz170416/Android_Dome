package com.example.wanandroid.wanandorid.project.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wanandroid.R;
import com.example.wanandroid.wanandorid.bean.PjItemBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PjItemReAdapter extends RecyclerView.Adapter<PjItemReAdapter.ViewHolder> {
    private static final String TAG = "PjItemReAdapter";
    private Context context;
    private ArrayList<PjItemBean.DataBean.DatasBean> pjItems;

    public PjItemReAdapter(Context context, ArrayList<PjItemBean.DataBean.DatasBean> pjItems) {
        this.context = context;
        this.pjItems = pjItems;
    }

    public void setPjItems(ArrayList<PjItemBean.DataBean.DatasBean> pjItems) {
        this.pjItems = pjItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_project_re_item, viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.pjItemName.setText(pjItems.get(i).getChapterName());
        viewHolder.pjItemTime.setText(pjItems.get(i).getNiceDate());
        viewHolder.pjItemTitle.setText(pjItems.get(i).getTitle());
        viewHolder.pjItemTxt.setText(pjItems.get(i).getDesc());

        Glide.with(context).load(pjItems.get(i).getEnvelopePic()).into(viewHolder.pjItemImg);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(i,pjItems.get(i));
            }
        });

    }

    @Override
    public int getItemCount() {
        return pjItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.pj_item_img)
        ImageView pjItemImg;
        @BindView(R.id.pj_item_nameimg)
        ImageView pjItemNameimg;
        @BindView(R.id.pj_item_title)
        TextView pjItemTitle;
        @BindView(R.id.pj_item_txt)
        TextView pjItemTxt;
        @BindView(R.id.pj_item_time)
        TextView pjItemTime;
        @BindView(R.id.pj_item_name)
        TextView pjItemName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener{
        void onClick(int position, PjItemBean.DataBean.DatasBean pjItemData);
    }
}
