package com.example.wanandroid.wanandorid.callback;

public interface MyCallBack<T> {
    void getData(T bean);
    void Error(String string);
}
