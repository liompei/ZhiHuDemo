package com.liompei.zhihudemo;

import android.content.BroadcastReceiver;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import com.liompei.zhihudemo.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;

    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private BroadcastReceiver mBroadcastReceiver;
//    private

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
