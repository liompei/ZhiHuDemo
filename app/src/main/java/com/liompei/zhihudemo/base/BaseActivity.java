package com.liompei.zhihudemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Liompei
 * on 2016/9/29.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        initData();
        initEvent();

    }

    protected abstract int getLayout();

    protected abstract void initView();

    protected abstract void initData();

    protected void initEvent(){

    }


}
