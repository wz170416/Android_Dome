package com.example.wanandroid.base;

import java.lang.ref.WeakReference;

public class BasePersenter<V> {
    private WeakReference<V> weakReference;

    public V mView;
    public void attachView(V v){
        //创建一个软引用 关联对象
        weakReference=new WeakReference<V>(v);
        //关联上路引用
        mView=weakReference.get();
    }


    public void deachView(){
        if(weakReference!=null){
            weakReference.clear();
        }
    }
}
