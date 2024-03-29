package com.example.wanandroid.api;

import com.example.myhttplibrary.callback.BaseResponce;
import com.example.wanandroid.wanandorid.bean.FeedArticleListData;
import com.example.wanandroid.wanandorid.bean.KnowledgeHierarchyData;
import com.example.wanandroid.wanandorid.bean.LoginData;
import com.example.wanandroid.wanandorid.bean.NavigationListData;
import com.example.wanandroid.wanandorid.bean.ProjectClassifyData;
import com.example.wanandroid.wanandorid.bean.ProjectListData;
import com.example.wanandroid.wanandorid.bean.TopSearchData;
import com.example.wanandroid.wanandorid.bean.UsefulSiteData;
import com.example.wanandroid.wanandorid.bean.WxAuthor;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author quchao
 * @date 2018/2/12
 */

public interface ApiServerList {

    String HOST = "https://www.wanandroid.com/";

    /**
     * 获取feed文章列表
     *
     * @param num 页数
     * @return feed文章列表数据
     */
    @GET("article/list/{num}/json")
    Observable<BaseResponce<FeedArticleListData>> getFeedArticleList(@Path("num") int num);

    /**
     * 搜索
     * http://www.wanandroid.com/article/query/0/json
     * @param page page
     * @param k POST search key
     * @return 搜索数据
     */
    @POST("article/query/{page}/json")
    @FormUrlEncoded
    Observable<BaseResponce<FeedArticleListData>> getSearchList(@Path("page") int page, @Field("k") String k);

    /**
     * 热搜
     * http://www.wanandroid.com//hotkey/json
     *
     * @return 热门搜索数据
     */
    @GET("hotkey/json")
    @Headers("Cache-Control: public, max-age=36000")
    Observable<BaseResponce<List<TopSearchData>>> getTopSearchData();

    /**
     * 常用网站
     * http://www.wanandroid.com/friend/json
     *
     * @return 常用网站数据
     */
    @GET("friend/json")
    Observable<BaseResponce<List<UsefulSiteData>>> getUsefulSites();

    /**
     * 广告栏
     * http://www.wanandroid.com/banner/json
     *
     * @return 广告栏数据
     */
    //@GET("banner/json")
    //Observable<BaseResponse<List<BannerData>>> getBannerData();

    /**
     * 知识体系
     * http://www.wanandroid.com/tree/json
     *
     * @return 知识体系数据
     */
    @GET("tree/json")
    Observable<BaseResponce<List<KnowledgeHierarchyData>>> getKnowledgeHierarchyData();

    /**
     * 知识体系下的文章
     * http://www.wanandroid.com/article/list/0?cid=60
     *
     * @param page page num
     * @param cid second page id
     * @return 知识体系feed文章数据
     */
    @GET("article/list/{page}/json")
    Observable<BaseResponce<FeedArticleListData>> getKnowledgeHierarchyDetailData(@Path("page") int page, @Query("cid") int cid);

    /**
     * 导航
     * http://www.wanandroid.com/navi/json
     *
     * @return 导航数据
     */
    @GET("navi/json")
    Observable<BaseResponce<List<NavigationListData>>> getNavigationListData();

    /**
     * 项目分类
     * http://www.wanandroid.com/project/tree/json
     *
     * @return 项目分类数据
     */
    @GET("project/tree/json")
    Observable<BaseResponce<List<ProjectClassifyData>>> getProjectClassifyData();

    /**
     * 项目类别数据
     * http://www.wanandroid.com/project/list/1/json?cid=294
     *
     * @param page page num
     * @param cid second page id
     * @return 项目类别数据
     */
    @GET("project/list/{page}/json")
    Observable<BaseResponce<ProjectListData>> getProjectListData(@Path("page") int page, @Query("cid") int cid);

    /**
     * 获取公众号列表
     * http://wanandroid.com/wxarticle/chapters/json
     *
     * @return 公众号列表数据
     */
    @GET("wxarticle/chapters/json")
    Observable<BaseResponce<List<WxAuthor>>> getWxAuthorListData();

    /**
     * 获取当前公众号某页的数据
     * http://wanandroid.com/wxarticle/list/405/1/json
     *
     * @param id
     * @param page
     * @return 获取当前公众号某页的数据
     */
    @GET("wxarticle/list/{id}/{page}/json")
    Observable<BaseResponce<FeedArticleListData>> getWxSumData(@Path("id") int id, @Path("page") int page);

    /**
     * 指定搜索内容，搜索当前公众号的某页的此类数据
     * http://wanandroid.com/wxarticle/list/405/1/json?k=Java
     *
     * @param id
     * @param page
     * @param k
     * @return 指定搜索内容，搜索当前公众号的某页的此类数据
     */
    @GET("wxarticle/list/{id}/{page}/json")
    Observable<BaseResponce<FeedArticleListData>> getWxSearchSumData(@Path("id") int id, @Path("page") int page, @Query("k") String k);

    /**
     * 登陆
     * http://www.wanandroid.com/user/login
     *
     * @param username user name
     * @param password password
     * @return 登陆数据
     */
    @POST("user/login")
    @FormUrlEncoded
    Observable<BaseResponce<LoginData>> getLoginData(@Field("username") String username, @Field("password") String password);

    /**
     * 注册
     * http://www.wanandroid.com/user/register
     *
     * @param username user name
     * @param password password
     * @param repassword re password
     * @return 注册数据
     */
    @POST("user/register")
    @FormUrlEncoded
    Observable<BaseResponce<LoginData>> getRegisterData(@Field("username") String username, @Field("password") String password, @Field("repassword") String repassword);

    /**
     * 退出登录
     * http://www.wanandroid.com/user/logout/json
     *
     * @return 登陆数据
     */
    @GET("user/logout/json")
    Observable<BaseResponce<LoginData>> logout();

    /**
     * 收藏站内文章
     * http://www.wanandroid.com/lg/collect/1165/json
     *
     * @param id article id
     * @return 收藏站内文章数据
     */
    @POST("lg/collect/{id}/json")
    Observable<BaseResponce<FeedArticleListData>> addCollectArticle(@Path("id") int id);

    /**
     * 收藏站外文章
     * http://www.wanandroid.com/lg/collect/add/json
     *
     * @param title title
     * @param author author
     * @param link link
     * @return 收藏站外文章数据
     */
    @POST("lg/collect/add/json")
    @FormUrlEncoded
    Observable<BaseResponce<FeedArticleListData>> addCollectOutsideArticle(@Field("title") String  title, @Field("author") String author, @Field("link") String link);


    /**
     * 获取收藏列表
     * http://www.wanandroid.com/lg/collect/list/0/json
     *
     * @param page page number
     * @return 收藏列表数据
     */
    @GET("lg/collect/list/{page}/json")
    Observable<BaseResponce<FeedArticleListData>> getCollectList(@Path("page") int page);

    /**
     * 取消站内文章
     * http://www.wanandroid.com/lg/uncollect_originId/2333/json
     *
     * @param id article id
     * @param originId origin id
     * @return 取消站内文章数据
     */
    @POST("lg/uncollect/{id}/json")
    @FormUrlEncoded
    Observable<BaseResponce<FeedArticleListData>> cancelCollectPageArticle(@Path("id") int id, @Field("originId") int originId);
}

