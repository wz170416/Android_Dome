package com.example.wanandroid.api;


import com.example.wanandroid.wanandorid.bean.BannerBean;
import com.example.wanandroid.wanandorid.bean.NavigationBean;
import com.example.wanandroid.wanandorid.bean.PjItemBean;
import com.example.wanandroid.wanandorid.bean.PjTitleBean;
import com.example.wanandroid.wanandorid.bean.WxAuthor;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyService {

    //Banner轮播图
    //https://www.wanandroid.com/banner/json
    String BANNERURL="https://www.wanandroid.com/";
    @GET("banner/json")
    Observable<BannerBean> getBanner();
    /*
    * 首页
    * https://www.wanandroid.com/article/list/1/json
    * */
    /*String HOMEURL="https://www.wanandroid.com/article/";
    @GET("list/{num}/json")
    Observable<HomeBean> getHome(@Path("num") int page);*/
    /*
    * 知识体系
    * http://www.wanandroid.com/tree/json
    * */
    /*String ZHISHIURL="http://www.wanandroid.com/";
    @GET("tree/json")
    Observable<ZhiShiBean> getZhishiData();*/
    /*
    * http://wanandroid.com/wxarticle/chapters/json
    * 公众号
    * */
    /*String WXURL="http://wanandroid.com/";
    @GET("wxarticle/chapters/json")
    Observable<WeChatsBean> getWxData();*/
    /*
    * http://wanandroid.com/wxarticle/list/405/1/json
    * 公众号某页的数据
    * */
    String WXITEMURL="http://wanandroid.com/";
    @GET("wxarticle/list/{id}/{page}/json")
    Observable<WxAuthor> getWxItemData(@Path("id") int id, @Path("page") int page);
    /*
    * 项目分类
    * https://www.wanandroid.com/project/tree/json
    * */
    String PJTITLE="https://www.wanandroid.com/";
    @GET("project/tree/json")
    Observable<PjTitleBean> getPjTitleData();
    /*
    * 项目数据
    * https://www.wanandroid.com/project/list/1/json?cid=402
    * */
    String PJITEM="https://www.wanandroid.com/project/";
    @GET("list/{page}/json?")
    Observable<PjItemBean> getPjItemData(@Path("page") int page, @Query("cid") int cid);
    /*
    * 导航
    * https://www.wanandroid.com/navi/json
    * */
    String NVGTURL="https://www.wanandroid.com/";
    @GET("navi/json")
    Observable<NavigationBean> getNvgtData();
    /*
    * 公众号搜索
    * http://wanandroid.com/wxarticle/list/405/1/json?k=Java
    * */
    String WXSOU="http://wanandroid.com/";
    @GET("wxarticle/list/{cid}/{page}/json?")
    Observable<WxAuthor> getWxSouData(@Path("cid") int cid, @Path("page") int page, @Query("k") String k);
    /*
    * 登录注册
    * http://yun918.cn/study/public/index.php/verify
    * */
    String LOGINURL="http://yun918.cn/study/public/index.php/verify";

}
