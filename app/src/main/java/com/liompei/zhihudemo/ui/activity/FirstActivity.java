package com.liompei.zhihudemo.ui.activity;

import com.liompei.zhihudemo.R;
import com.liompei.zhihudemo.base.BaseActivity;
import com.liompei.zhihudemo.ui.fragment.FirstFragment;

public class FirstActivity extends BaseActivity {

    @Override
    protected int getLayout() {
        return R.layout.activity_first;
    }

    @Override
    protected void initToolBar() {

    }

    @Override
    protected void initView() {

        replaceFragment(R.id.frame_container,new FirstFragment());
    }

    @Override
    protected void initData() {

    }
}
