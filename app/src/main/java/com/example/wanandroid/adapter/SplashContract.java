package com.example.wanandroid.adapter;

/**
 * 王卓
 */
public interface SplashContract {

    interface View extends AbstractView {
        /**
         * after some time jump to main page
         */
        void jumpToMain();
    }

    interface Presenter extends AbstractPresenter<View> {

    }

}
