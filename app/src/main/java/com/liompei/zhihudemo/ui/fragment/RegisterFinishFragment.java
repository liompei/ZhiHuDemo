package com.liompei.zhihudemo.ui.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.avos.avoscloud.AVUser;
import com.liompei.zhihudemo.MainActivity;
import com.liompei.zhihudemo.R;
import com.liompei.zhihudemo.base.BaseFragment;

/**
 * Created by Liompei
 * on 2016/10/11.
 */

public class RegisterFinishFragment extends BaseFragment implements View.OnClickListener {


    private RelativeLayout to_start;  //开始吧

    @Override
    protected int getLayout() {
        return R.layout.fragment_register_finish;
    }

    @Override
    protected void initView() {
        to_start = (RelativeLayout) findViewById(R.id.to_start);
    }

    @Override
    protected void initEvent() {
        to_start.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.to_start:
                AVUser currentUser = AVUser.getCurrentUser();
                if (currentUser != null) {
                    //跳转到主页
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), MainActivity.class);
                    startActivity(intent);
                    break;
                } else {
                    //没有缓存对象
                    Log.d("aaa", "没有缓存对象");
                }


        }
    }
}
