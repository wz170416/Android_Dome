package com.example.wanandroid.wanandorid.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;


@Entity
public class MyDbBean {
    @Id(autoincrement = true)
    private Long id;
    private String title;
    private String author;
    private String time;
    private String body;
    @Generated(hash = 1041381807)
    public MyDbBean(Long id, String title, String author, String time,
            String body) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.time = time;
        this.body = body;
    }
    @Generated(hash = 720896287)
    public MyDbBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getBody() {
        return this.body;
    }
    public void setBody(String body) {
        this.body = body;
    }

}
