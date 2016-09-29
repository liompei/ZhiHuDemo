package com.liompei.zhihudemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.liompei.zhihudemo.App;

/**
 * Created by Liompei
 * on 2016/9/29.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getInstance().addActivity(this);
        setContentView(getLayout());
        initToolBar();
        initView();
        initData();
        initEvent();

    }

    protected abstract int getLayout();

    protected abstract void initToolBar();

    protected abstract void initView();

    protected abstract void initData();

    protected void initEvent() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getInstance().deleteActivity(this);
    }
}
