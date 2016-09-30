package com.liompei.zhihudemo;

import android.content.BroadcastReceiver;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import com.afollestad.materialdialogs.MaterialDialog;
import com.liompei.zhihudemo.base.BaseActivity;
import com.liompei.zhihudemo.ui.activity.HomeFragment;
import com.liompei.zhihudemo.util.ShowToast;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
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
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);
        mNavigationView.getMenu().getItem(0).setChecked(true);
        replaceFragment(R.id.frame_container, new HomeFragment());


    }

    @Override
    protected void initData() {

    }


    @Override
    protected void initEvent() {
//        if (noNetWorkDialog == null) {
//            noNetWorkDialog = new MaterialDialog.Builder(MainActivity.this)
//                    .title("无网络连接")
//                    .content("去开启网络?")
//                    .positiveText("是")
//                    .backgroundColor(getResources().getColor(App.COLOR_OF_DIALOG))
//                    .contentColor(App.COLOR_OF_DIALOG_CONTENT)
//                    .positiveColor(App.COLOR_OF_DIALOG_CONTENT)
//                    .negativeColor(App.COLOR_OF_DIALOG_CONTENT)
//                    .titleColor(App.COLOR_OF_DIALOG_CONTENT)
//                    .negativeText("否")
//                    .callback(new MaterialDialog.ButtonCallback() {
//                        @Override
//                        public void onPositive(MaterialDialog dialog) {
//                            Intent intent = new Intent(
//                                    Settings.ACTION_WIRELESS_SETTINGS);
//                            startActivity(intent);
//                        }
//
//                        @Override
//                        public void onNegative(MaterialDialog dialog) {
//                        }
//                    })
//                    .cancelable(false)
//                    .build();
//        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            replaceFragment(R.id.frame_container, new HomeFragment());

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
}
