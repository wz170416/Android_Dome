package com.example.wanandroid.app;

import android.app.Application;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.tencent.bugly.crashreport.CrashReport;

public class MyApp extends Application {
    private static MyApp myApp;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "a9b6ec7f00", true);
        myApp = this;
    }
    public static MyApp getMyApp() {
        return myApp;
    }
}
