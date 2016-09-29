package com.liompei.zhihudemo;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.provider.Settings;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;

import com.afollestad.materialdialogs.MaterialDialog;
import com.liompei.zhihudemo.base.BaseActivity;
import com.liompei.zhihudemo.util.ShowToast;

public class MainActivity extends BaseActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;

    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private BroadcastReceiver mBroadcastReceiver;
    private MaterialDialog noNetWorkDialog;
    private long exitTime;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }


    @Override
    protected void initEvent() {
        if (noNetWorkDialog == null) {
            noNetWorkDialog = new MaterialDialog.Builder(MainActivity.this)
                    .title("无网络连接")
                    .content("去开启网络?")
                    .positiveText("是")
                    .backgroundColor(getResources().getColor(App.COLOR_OF_DIALOG))
                    .contentColor(App.COLOR_OF_DIALOG_CONTENT)
                    .positiveColor(App.COLOR_OF_DIALOG_CONTENT)
                    .negativeColor(App.COLOR_OF_DIALOG_CONTENT)
                    .titleColor(App.COLOR_OF_DIALOG_CONTENT)
                    .negativeText("否")
                    .callback(new MaterialDialog.ButtonCallback() {
                        @Override
                        public void onPositive(MaterialDialog dialog) {
                            Intent intent = new Intent(
                                    Settings.ACTION_WIRELESS_SETTINGS);
                            startActivity(intent);
                        }

                        @Override
                        public void onNegative(MaterialDialog dialog) {
                        }
                    })
                    .cancelable(false)
                    .build();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.FLAG_FALLBACK && event.getAction() == KeyEvent.ACTION_DOWN) {

            if ((System.currentTimeMillis() - exitTime) > 2000) {
                ShowToast.Short("再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
