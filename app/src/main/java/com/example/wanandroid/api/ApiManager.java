package com.example.wanandroid.api;

import com.example.myhttplibrary.mylibrary.HttpManager;
import com.example.wanandroid.app.MyApp;

/**
 * 项目名：MyMvpDemo
 * 包名：  com.liangxq.myapplication1.http
 * 文件名：ApiManager
 * 创建者：liangxq
 * 创建时间：2019/4/29  9:50
 * 描述：TODO
 */
public class ApiManager {

    private static volatile ApiManager apiManager;

    private ApiManager(){

    }

    public static ApiManager getInstance(){
        if (apiManager == null) {
            synchronized (ApiManager.class){
                if (apiManager == null) {
                    apiManager=new ApiManager();
                }
            }
        }

        return apiManager;
    }

    public ApiServer getServer(){
        return HttpManager.getHttpManager().getRetrofit(ApiServer.URL,MyApp.getMyApp()).create(ApiServer.class);
    }
    public ApiServerList getServerList(){
        return HttpManager.getHttpManager().getRetrofit(ApiServerList.HOST,MyApp.getMyApp()).create(ApiServerList.class);
    }
}
