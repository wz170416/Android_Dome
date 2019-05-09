package com.example.wanandroid.wanandorid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wanandroid.R;
import com.example.wanandroid.wanandorid.bean.BannerBean;
import com.example.wanandroid.wanandorid.bean.DataBean;
import com.example.wanandroid.wanandorid.bean.MyDbBean;
import com.example.wanandroid.wanandorid.utils.MyDb;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class RecycAdater_A extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<BannerBean> beanArrayList;
    private ArrayList<DataBean.DatasBean> datasBeans;
    private Context context;

    public RecycAdater_A(ArrayList<BannerBean> beanArrayList, ArrayList<DataBean.DatasBean> datasBeans, Context context) {
        this.beanArrayList = beanArrayList;
        this.datasBeans = datasBeans;
        this.context = context;
    }

    public void setBeanArrayList(ArrayList<BannerBean> beanArrayList) {
        this.beanArrayList = beanArrayList;
    }

    public void setDatasBeans(ArrayList<DataBean.DatasBean> datasBeans) {
        this.datasBeans = datasBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder = null;
        if (i == 0) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_recyc_a_banner, null);
            viewHolder = new BannerViewHolder(inflate);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_recyc_a_title, null);
            viewHolder = new TitleViewHoler(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof BannerViewHolder) {
            BannerViewHolder bannerViewHolder = (BannerViewHolder) viewHolder;
            bannerViewHolder.img_banner.setImages(beanArrayList);
            bannerViewHolder.img_banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    BannerBean dataBean = (BannerBean) path;
                    Glide.with(context).load(dataBean.getImagePath()).into(imageView);
                }
            });
            bannerViewHolder.img_banner.start();
        } else if (viewHolder instanceof TitleViewHoler) {//文章列表显示
            final TitleViewHoler titleViewHoler = (TitleViewHoler) viewHolder;//转换成文章列表ViewHolder
            int newPosition = i;
            if (beanArrayList.size() > 0) {
                newPosition = i - 1;
            }
            final DataBean.DatasBean datasBean = datasBeans.get(newPosition);
            titleViewHoler.author.setText(datasBean.getAuthor());
            titleViewHoler.chapterName.setText(datasBean.getSuperChapterName());
            titleViewHoler.title.setText(datasBean.getTitle());
            titleViewHoler.niceDate.setText(datasBean.getNiceDate());

            final int finalNewPosition = newPosition;
            List<MyDbBean> where = MyDb.getMyDb().where(datasBeans.get(finalNewPosition));
            if(where!=null&&where.size()>0){
                titleViewHoler.follow.setChecked(true);
            }else {
                titleViewHoler.follow.setChecked(false);
            }
            titleViewHoler.follow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onImgClickListener.onImgClick(finalNewPosition,datasBeans.get(finalNewPosition),titleViewHoler.follow);

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (beanArrayList.size() > 0) {
            return datasBeans.size() + 1;
        } else {
            return datasBeans.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        private Banner img_banner;
        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            img_banner=itemView.findViewById(R.id.img_banner);
        }
    }
    class TitleViewHoler extends RecyclerView.ViewHolder {
        private CheckBox follow;
        private TextView author;
        private TextView chapterName;
        private TextView title;
        private TextView niceDate;
        public TitleViewHoler(@NonNull View itemView) {
            super(itemView);
            follow=itemView.findViewById(R.id.follow);
            author=itemView.findViewById(R.id.author);
            chapterName=itemView.findViewById(R.id.chapterName);
            title=itemView.findViewById(R.id.title);
            niceDate=itemView.findViewById(R.id.niceDate);
        }
    }
    OnImgClickListener onImgClickListener;

    public void setOnImgClickListener(OnImgClickListener onImgClickListener) {
        this.onImgClickListener = onImgClickListener;
    }

    public interface OnImgClickListener{
        void onImgClick(int position,DataBean.DatasBean data,CheckBox img);
    }
}
