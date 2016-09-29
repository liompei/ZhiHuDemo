package com.liompei.zhihudemo;

import android.app.Activity;
import android.app.Application;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liompei
 * on 2016/9/29.
 */

public class App extends Application {

    public static int COLOR_OF_DIALOG = R.color.primary;
    public static int COLOR_OF_DIALOG_CONTENT = Color.WHITE;

    private static App instance;

    private List<Activity> mActivityList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }


    public static App getInstance() {
        return instance;
    }


    public void addActivity(Activity activity) {
        mActivityList.add(activity);
    }

    public void deleteActivity(Activity activity) {
        mActivityList.remove(activity);
    }

    public void finishAllActivity() {
        for (Activity activity : mActivityList) {
            activity.finish();
        }
        mActivityList.clear();
    }

    // 退出
    public void exit() {
        for (Activity activity : mActivityList) {
            activity.finish();
        }
        mActivityList.clear();
        System.exit(0);
    }

}
