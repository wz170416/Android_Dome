package com.example.wanandroid.wanandorid.utils;

import com.example.wanandroid.app.MyApp;
import com.example.wanandroid.dao.DaoMaster;
import com.example.wanandroid.dao.DaoSession;
import com.example.wanandroid.dao.MyDbBeanDao;
import com.example.wanandroid.wanandorid.bean.DataBean;
import com.example.wanandroid.wanandorid.bean.MyDbBean;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

public class MyDb {
    private static MyDb myDb;
    private final MyDbBeanDao myDbBeanDao;

    public MyDb() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApp.getMyApp(), "info.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        myDbBeanDao = daoSession.getMyDbBeanDao();
    }

    public static MyDb getMyDb() {
        if(myDb ==null){
            synchronized (MyDb.class){
                if(myDb ==null){
                    myDb =new MyDb();
                }
            }
        }
        return myDb;
    }
    public List<MyDbBean> query(){
        return myDbBeanDao.queryBuilder().list();
    }
    public void insert(MyDbBean myDbBean){
        if(!has(myDbBean)){
            myDbBeanDao.insert(myDbBean);
        }
    }
    public void delete(ArrayList<MyDbBean> myDbBean){
        myDbBeanDao.deleteInTx(myDbBean);
    }
    public boolean has(MyDbBean myDbBean){
        List<MyDbBean> list = myDbBeanDao.queryBuilder().where(MyDbBeanDao.Properties.Title.eq(myDbBean.getTitle())).list();
        if(list.size()>0&&list!=null){
            return true;
        }
        return false;
    }
    public List<MyDbBean> where(DataBean.DatasBean data){
        return myDbBeanDao.queryBuilder().where(MyDbBeanDao.Properties.Title.eq(data.getTitle())).list();
    }
    public List<MyDbBean> where(MyDbBean data){
        return myDbBeanDao.queryBuilder().where(MyDbBeanDao.Properties.Title.eq(data.getTitle())).list();
    }
}
