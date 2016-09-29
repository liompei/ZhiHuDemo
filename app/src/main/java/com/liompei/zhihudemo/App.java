package com.liompei.zhihudemo;

import android.app.Application;

/**
 * Created by Liompei
 * on 2016/9/29.
 */

public class App extends Application {

    private static App instance;


    @Override
    public void onCreate() {
        super.onCreate();
    }


    public static App getInstance() {
        return instance;
    }
}
