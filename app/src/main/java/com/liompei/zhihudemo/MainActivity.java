package com.liompei.zhihudemo;

import android.support.v7.widget.Toolbar;

import com.liompei.zhihudemo.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private Toolbar mToolbar;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initToolBar() {
        mToolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
