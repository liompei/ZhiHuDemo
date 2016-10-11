package com.liompei.zhihudemo.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

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
        to_start.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.to_start:
                Intent intent = new Intent();
                intent.setClass(getActivity(), MainActivity.class);
                break;
        }
    }
}
