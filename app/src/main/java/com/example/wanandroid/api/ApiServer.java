package com.example.wanandroid.api;


import com.example.myhttplibrary.callback.BaseResponce;
import com.example.wanandroid.wanandorid.bean.BannerBean;
import com.example.wanandroid.wanandorid.bean.DataBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 项目名：MyMvpDemo
 * 包名：  com.liangxq.myapplication1.http
 * 文件名：ApiServer
 * 创建者：liangxq
 * 创建时间：2019/4/29  9:48
 * 描述：TODO
 */
public interface ApiServer {
    String URL="http://www.wanandroid.com/";
    @GET("banner/json")
    Observable<BaseResponce<List<BannerBean>>> getBanner();
    @GET("article/list/{pageNum}/json")
    Observable<BaseResponce<DataBean>> getTitle(@Path("pageNum") int pageNum);
}
